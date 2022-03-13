
/**
 * @author Emran Abbamacha
 */

import java.util.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

	protected Node<T> head;
	protected Node<T> tail;
	protected int size = 0;

	/**
	 * Constructor to set to initialize head, tail and size to null, null and 0
	 */
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * A generic inner class Node - This class has the following attributes: data of
	 * type T, prev of type Node, next of type Node
	 */
	public static class Node<T> {

		T data;
		Node<T> prev;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Node getPrev() {
			return prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node node) {
			next = node;
		}

		public void setPrev(Node node) {
			prev = node;
		}

		public boolean equals(Node node) {
			if (next == node.getNext() && prev == node.getPrev() && data == node.getData()) {
				return true;
			}
			return false;
		}
	}

	/**
	 * A generic inner class named DoubleLinkedListIterator that implements java’s
	 * ListIterator interface (for the iterator method).
	 */
	public class DoubleLinkedListIterator implements ListIterator<T> {

		private Node head;
		private Node trav;
		private Node previous;
		private int index;

		public DoubleLinkedListIterator(Node start) {
			trav = start;
			head = start;
			previous = null;
			index = 0;
		}

		@Override
		public boolean hasNext() {
			return this.trav != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {

			if (this.trav == null || (index > 0 && this.trav.equals(this.head))) {
				throw new NoSuchElementException("No further elements");
			}

			this.previous = this.trav;
			this.trav = trav.getNext();
			this.index++;

			return (T) this.previous.getData();
		}

		@Override
		public boolean hasPrevious() {
			return this.previous != null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T previous() {

			Node previousHead = null;
			Node next = this.head;

			if (this.previous == null) {
				throw new NoSuchElementException("No previous elements");
			}
			if (!this.previous.equals(this.head)) {
				while (!next.getNext().equals(this.previous)) {
					next = next.getNext();
				}
				previousHead = next;
			}

			this.trav = this.previous;
			this.previous = previousHead;
			return (T) this.trav.getData();
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Adds an element to the end of the list and updated the size of the list
	 * 
	 * @param data - the data to be added to the list
	 */
	public void addToEnd(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null, null);
		} else {
			tail.next = new Node<T>(data, tail, null);
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Adds element to the front of the list and updated the size of the list
	 * 
	 * @param data - the data to be added to the list
	 */
	public void addToFront(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null, null);
		} else {
			head.prev = new Node<T>(data, null, head);
			head = head.prev;
		}
		size++;
	}

	/**
	 * Returns but does not remove the first element from the list. If there are no
	 * elements the method returns null.
	 */
	public T getFirst() {
		if (isEmpty())
			return null;
		return head.data;
	}

	/**
	 * Returns but does not remove the last element from the list. If there are no
	 * elements the method returns null.
	 */
	public T getLast() {
		if (isEmpty())
			return null;
		return tail.data;
	}

	/**
	 * Returns the number of nodes in the list.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns true if list is empty
	 */
	public boolean isEmpty() {
		return getSize() == 0;
	}

	/**
	 * This method returns an object of the DoubleLinkedListIterator.
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new DoubleLinkedListIterator(this.head);
	}

	/**
	 * Removes the first instance of the targetData from the list.
	 * 
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {

		Node previous = this.tail;
		Node currentNode = this.head;
		Node next = null;
		int index = 0;

		while (currentNode != null) {
			if (comparator.compare(targetData, (T) currentNode.data) == 0) {
				if (currentNode == head) {
					head = head.next;
				} else if (currentNode == tail) {
					tail = tail.prev;
				} else {
					currentNode.prev.next = currentNode.next;
				}
				size--;
				return this;
			}
			currentNode = currentNode.next;
		}
		return this;
	}

	/**
	 * Removes and returns the first element from the list. If there are no elements
	 * the method returns null.
	 */
	public T retrieveFirstElement() {

		if (isEmpty())
			return null;

		T data = head.data;
		head = head.next;
		--size;

		if (isEmpty())
			tail = null;
		else
			head.prev = null;

		return data;
	}

	/**
	 * Removes and returns the last element from the list. If there are no elements
	 * the method returns null.
	 */
	public T retrieveLastElement() {

		if (isEmpty())
			return null;

		T data = tail.data;
		tail = tail.prev;
		--size;

		if (isEmpty())
			head = null;
		else
			tail.next = null;

		return data;
	}

	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 */
	public ArrayList<T> toArrayList() {

		ArrayList<T> list = new ArrayList<>();
		Node<T> current = head;
		while (current != null) {
			list.add(current.data);
			current = current.next;
		}
		return list;
	}

}
