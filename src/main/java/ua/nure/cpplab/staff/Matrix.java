package ua.nure.cpplab.staff;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Matrix {
    private final double[][] data;
    private final int rowCount;
    private final int columnCount;

    public Matrix(final double[][] initial) {
        verifyMatrixCorrectness(initial);
        data = initial;
        rowCount = initial.length;
        columnCount = initial[0].length;
    }

    @NotNull
    public Matrix add(@NotNull final Matrix otherMatrix) {
        if (rowCount != otherMatrix.rowCount || columnCount != otherMatrix.columnCount)
            throw new IllegalArgumentException("Matrixes should have the same sizes to add");

        final var resultInitial = new double[rowCount][columnCount];

        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < columnCount; col++) {
                resultInitial[row][col] = data[row][col] + otherMatrix.data[row][col];
            }
        }

        return new Matrix(resultInitial);
    }

    @NotNull
    public Matrix multiply(@NotNull final double number) {
        final var resultInitial = new double[rowCount][columnCount];

        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < columnCount; col++) {
                resultInitial[row][col] = data[row][col] * number;
            }
        }

        return new Matrix(resultInitial);
    }

    @NotNull
    public Matrix multiply(@NotNull final Matrix otherMatrix) {
        final var resultInitial = new double[rowCount][otherMatrix.columnCount];

        for (var row = 0; row < rowCount; row++) {
            for (var colOther = 0; colOther < otherMatrix.columnCount; colOther++) {
                for (var rowOther = 0; rowOther < otherMatrix.rowCount; rowOther++) {
                    resultInitial[row][colOther] += data[row][rowOther] * otherMatrix.data[rowOther][colOther];
                }
            }
        }

        return new Matrix(resultInitial);
    }

    @NotNull
    public Matrix transpose() {
        final var resultInitial = new double[columnCount][rowCount];

        for (var col = 0; col < columnCount; col++) {
            for (var row = 0; row < rowCount; row++) {
                resultInitial[col][row] = data[row][col];
            }
        }

        return new Matrix(resultInitial);
    }

    @NotNull
    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }

    private void verifyMatrixCorrectness(final double[][] data) {
        if (data.length == 0)
            throw new IllegalArgumentException("Initial matrix shouldn't empty");

        final var allRowsTheSame = Arrays.stream(data)
                .map(item -> item.length)
                .allMatch(count -> count == data[0].length);

        if (!allRowsTheSame)
            throw new IllegalArgumentException("Rows should have the same length");
    }
}
