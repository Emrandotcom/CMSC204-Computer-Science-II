
/**
 * @author Emran Abbamacha
*/
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T> {

	private Comparator<T> comparator = null;

	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * 
	 * @param compareableObject - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		this.head = null;
		this.tail = null;
		this.comparator = compareableObject;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @param data - the data to be added to the list
	 */
	public SortedDoubleLinkedList<T> add​(T data) {

		Node newNode = new Node(data);
		Node currentNode = head;

		if (size == 0) {
			head = newNode;
			tail = head;
			size++;
			return this;

		} else if (comparator.compare(head.data, data) > 0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
			return this;

		} else {
			while (comparator.compare((T) currentNode.data, data) < 0) {
				if (currentNode.next == null) {
					currentNode.next = newNode;
					newNode.prev = currentNode;
					tail = newNode;
					size++;
					return this;
				} else {
					currentNode = currentNode.next;
				}
			}

			currentNode.prev.next = newNode;
			newNode.prev = currentNode.prev;
			currentNode.prev = newNode;
			newNode.next = currentNode;
			size++;
			return this;
		}

	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data - the data to be added to the list
	 * @throws UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException
	 * will be generated using the message "Invalid operation for sorted list."
	 * 
	 * @param data - the data to be added to the list
	 * @throws UnsupportedOperationException - if method is called
	 */
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Implements the iterator by calling the super class iterator method. Returns
	 * an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();
	}

	/**
	 * Implements the remove operation by calling the super class remove method.
	 * Returns a node containing the data or null
	 * 
	 * @param data       - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 */
	public SortedDoubleLinkedList<T> remove​(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
	}

}
