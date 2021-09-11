package ua.nure.cpplab.staff.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CircularQueue<E> {
    private int currentSize;
    private final E[] circularQueueElements;

    private int rear;
    private int front;

    @SuppressWarnings("unchecked")
    public CircularQueue(int maxSize) {
        circularQueueElements = (E[]) new Object[maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    public void enqueue(@NotNull E item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        } else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;

            if (front == -1) {
                front = rear;
            }
        }
    }

    @NotNull
    public E dequeue() throws QueueEmptyException {
        E deQueuedElement;

        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        } else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @NotNull
    @Override
    public String toString() {
        return "CircularQueue [" + Arrays.stream(circularQueueElements).map(el -> {
            if (el == null)
                return "__";

            return el.toString();
        }).collect(Collectors.joining("  ")) + "]";
    }
}
