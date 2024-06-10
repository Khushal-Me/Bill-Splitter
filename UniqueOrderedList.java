// In this class I refactored some code to remove the redundant parts, as indicated by the IDE.
// All the tests still pass and all required functionalities havee been implemented.

public class UniqueOrderedList<T extends Comparable<T>> implements UniqueOrderedListADT<T>, SimpleIterable<T> {
	// size will keep track of the number of elements in the list
	private int size;
	// head is the first node in the list
	private LinearNode<T> head;

	// Default constructor that initializes an empty list
	public UniqueOrderedList() {
		this.head = null;
		size = 0;
	}

	// Method to check if an element is in the list
	public boolean contains(T element) {
		LinearNode<T> curr = this.head;
		// Iterate through the list until we find the element or reach a node with a greater value
		while (curr != null  && curr.getData().compareTo(element) <= 0)  {
			if (curr.getData().equals(element)) {
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		// If we didn't find the element, return false
		return false;
	}

	// Method to add an element to the list
	public boolean add(T element) {
		// First check if the element is already in the list
		if (this.contains(element)) {
			return false;
		} else {
			// If the list is empty or the element is smaller than the head, insert at the beginning
			if (this.head == null || this.head.getData().compareTo(element) > 0) {
				this.head = new LinearNode<>(element, head);
			} else {
				// Otherwise, find the correct position to insert the element
				LinearNode<T> curr = this.head;
				LinearNode<T> prev = null;

				while (curr != null && curr.getData().compareTo(element) < 0) {
					prev = curr;
					curr = curr.getNext();
				}

				// Insert the element at the found position
				assert prev != null;
				prev.setNext(new LinearNode<> (element, curr));
			}
		}
		// Increase the size of the list
		size+=1;
		return true;
	}

	// Method to get the size of the list
	public int size() {
		return this.size;
	}

	// Method to get an iterator for the list
	public UOLIterator<T> iterator() {
		return new UOLIterator<>(head);
	}
}
