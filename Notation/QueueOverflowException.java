public class QueueOverflowException extends RuntimeException {
	public QueueOverflowException() {
		super("Enqueue method has been called on a full queue");
	}
}