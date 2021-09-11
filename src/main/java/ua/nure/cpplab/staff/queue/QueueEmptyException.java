package ua.nure.cpplab.staff.queue;

class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String message) {
        super(message);
    }
}
