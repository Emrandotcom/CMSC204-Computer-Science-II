public class QueueUnderflowException extends RuntimeException {
	public QueueUnderflowException() {
		super("Dequeue method has been called on an empty queue");
	}
}