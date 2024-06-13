# Bill Splitter

This project contains a Java implementation of a Bill Splitter that can split a bill among a group of people. It includes the main class `BillSplitter` and supporting classes `UniqueOrderedList` and `UOLIterator`.

## Classes

### BillSplitter

The `BillSplitter` class is used to split a bill among a group of people. It provides methods to find a combination of elements that add up to a target amount.

#### Methods

- `public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target)`: This method takes a `UniqueOrderedList` of integers and a target amount, and returns a combination of elements that add up to the target.
- `private static UniqueOrderedList<Integer> findCombination(List<Integer> elements, int target)`: A helper method that finds a combination of elements that add up to the target.

### UniqueOrderedList

The `UniqueOrderedList` class represents a list of unique, ordered elements. It implements `UniqueOrderedListADT` and `SimpleIterable`.

#### Fields

- `private int size`: Keeps track of the number of elements in the list.
- `private LinearNode<T> head`: The first node in the list.

#### Methods

- `public UniqueOrderedList()`: Default constructor that initializes an empty list.
- `public boolean contains(T element)`: Checks if an element is in the list.
- `public boolean add(T element)`: Adds an element to the list in the correct order.
- `public int size()`: Returns the size of the list.
- `public UOLIterator<T> iterator()`: Returns an iterator for the list.

### UOLIterator

The `UOLIterator` class implements the `CopyableIterator` interface for the `UniqueOrderedList`.

#### Fields

- `private LinearNode<T> curr`: Keeps track of the current position in the iteration.

#### Methods

- `public UOLIterator(LinearNode<T> start)`: Constructor that initializes the iterator with a starting node.
- `public boolean hasNext()`: Checks if there is a next element in the iteration.
- `public T next()`: Returns the next element in the iteration.
- `public UOLIterator<T> copy()`: Creates a copy of the iterator.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
