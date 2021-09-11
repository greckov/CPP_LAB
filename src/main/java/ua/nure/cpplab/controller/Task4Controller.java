package ua.nure.cpplab.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task4Controller extends BaseTaskController {
    @FXML private TextField pathInput;
    @FXML private Label nodesLabel;

    public static void display() throws IOException {
        displayInternal("Task 4.4", "task4-view.fxml");
    }

    @FXML
    public void onListClick() throws ClassNotFoundException {
        final var desiredPath = pathInput.getText();

        if (desiredPath.isBlank() || desiredPath.isEmpty())
            return;

        try {
            final var path = Paths.get(desiredPath);
            final var nodes = listOnlySpecificFiles(path);

            final var serializedFilePath = serializePathsToFile(nodes);
            final var deserializedNodes = deserializePathsFromFile(serializedFilePath);

            final var stringifiesNodes = deserializedNodes.stream()
                    .map(Path::toString)
                    .collect(Collectors.joining("\n"));

            nodesLabel.setText(stringifiesNodes);
        } catch (IOException e) {
            nodesLabel.setText("Failed to list files: " + e);
        }
    }

    private Path serializePathsToFile(final List<Path> nodes) throws IOException {
        final var outputFilePath = Paths.get(System.getProperty("java.io.tmpdir"), "serialized.bin");

        final var fileStream = new FileOutputStream(outputFilePath.toString());

        try (final var objectStream = new ObjectOutputStream(fileStream)) {
            final var convertedPaths = nodes.stream().map(Path::toString).collect(Collectors.toList());
            objectStream.writeObject(convertedPaths);
        }

        return outputFilePath;
    }

    private List<Path> deserializePathsFromFile(final Path path) throws IOException, ClassNotFoundException {
        final var fileStream = new FileInputStream(path.toString());

        try (final var objectStream = new ObjectInputStream(fileStream)) {
            final var loadedPaths = (List<String>) objectStream.readObject();
            return loadedPaths.stream().map(Paths::get).collect(Collectors.toList());
        }
    }

    private List<Path> listOnlySpecificFiles(final Path directory) throws IOException {
        return Files.walk(directory)
                .filter(this::isNeedPath)
                .collect(Collectors.toList());
    }

    private boolean isNeedPath(final Path path) {
        final var stringPath = path.toString();
        final var needExtensions = Arrays.asList(".java", ".class", ".txt");

        return Files.isRegularFile(path) && needExtensions.stream().anyMatch(stringPath::endsWith);
    }
}
