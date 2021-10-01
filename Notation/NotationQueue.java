import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
	private Object[] elements;
	private int first;
	private int last;
	private int numberOfElements;
	private int capacity;

	public NotationQueue() {
		capacity = 20;
		elements = new Object[capacity];
	}

	public NotationQueue(int capacity) {
		this.capacity = capacity;
		this.first = this.last = -1;
		this.numberOfElements = 0;
		elements = new Object[capacity];
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public boolean isFull() {
		return capacity == numberOfElements;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		@SuppressWarnings("unchecked")
		T firstInLine = (T) elements[first];
		if (firstInLine == null)
			return null;
		elements[first] = null;
		first++;
		numberOfElements--;
		return firstInLine;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (isEmpty()) {
			first = last = 0;
		} else {
			last++;
		}
		numberOfElements++;
		elements[last] = e;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = first; i <= last; i++) {
			sb.append(elements[i]);
		}
		return sb.toString();
	}

	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();

		for (int i = first; i < last; i++) {
			sb.append(elements[i] + delimiter);
		}
		sb.append(elements[last]);
		return sb.toString();
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> cloneList = new ArrayList<>(list);
		cloneList.forEach(t -> {
			try {
				enqueue(t);
			} catch (QueueOverflowException ex) {
				ex.getMessage();
			}
		});
	}
}
