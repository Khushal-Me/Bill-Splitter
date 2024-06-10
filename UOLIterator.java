import java.util.NoSuchElementException;

public class UOLIterator<T> implements CopyableIterator<T> {
    // curr is a node that will keep track of our current position in the iteration
    private LinearNode<T> curr;

    // Constructor that takes a starting node
    public UOLIterator(LinearNode<T> start) {
        // Initialize curr with the starting node
        this.curr = start;
    }

    // Method to check if there is a next element in the iteration
    public boolean hasNext() {
        // If curr is not null, it means we have a next element
        return curr != null;
    }

    // Method to get the next element in the iteration
    public T next() {
        // If there is no next element, throw an exception
        if (!hasNext()) {
            throw new NoSuchElementException("iterator empty");
        }
        // Otherwise, get the data from the current node, move to the next node, and return the data
        T result = curr.getData();
        curr = curr.getNext();
        return result;
    }

    // Method to create a copy of the iterator
    public UOLIterator<T> copy() {
        // Create a new iterator starting from the current node
        return new UOLIterator<>(curr);
    }
}
