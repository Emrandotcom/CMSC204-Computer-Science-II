public class QueueUnderflowException extends RuntimeException {
	public QueueUnderflowException() {
		// occurs when a enqueue method is called on a full queue.
	}
}