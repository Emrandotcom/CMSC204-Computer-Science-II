public class StackUnderflowException extends RuntimeException {
	public StackUnderflowException() {
		super("Pop or top method has been called on an empty stack");
	}
}