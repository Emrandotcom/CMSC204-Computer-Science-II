public class QueueOverflowException extends RuntimeException {
	public QueueOverflowException() {
		// occurs when a dequeue method is called on an empty queue
	}
}