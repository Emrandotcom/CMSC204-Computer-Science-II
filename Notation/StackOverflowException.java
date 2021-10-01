public class StackOverflowException extends RuntimeException {
	public StackOverflowException() {
		super("Push method has been called on a full stack");
	}
}