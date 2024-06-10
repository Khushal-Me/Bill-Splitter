import java.util.ArrayList;
import java.util.List;

// This class is used to split a bill among a group of people
public class BillSplitter {
    // The split method takes a UniqueOrderedList of integers and a target amount
    public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target) {
        // Convert the UniqueOrderedList to a List
        List<Integer> elements = new ArrayList<>();
        CopyableIterator<Integer> iterator = in.iterator();
        while (iterator.hasNext()) {
            elements.add(iterator.next());
        }
        // Find a combination of elements that add up to the target
        return findCombination(elements, target);
    }

    // The findCombination method is a helper method that finds a combination of elements that add up to the target
    private static UniqueOrderedList<Integer> findCombination(List<Integer> elements, int target) {
        // If the target is 0, return an empty list
        if (target == 0) {
            return new UniqueOrderedList<>();
        }
        // If the target is negative or the list is empty, return null
        if (target < 0 || elements.isEmpty()) {
            return null;
        }

        // Get the first element and the rest of the list
        Integer first = elements.get(0);
        List<Integer> rest = new ArrayList<>(elements);
        rest.remove(0);

        // Try including the first element in the combination
        UniqueOrderedList<Integer> withFirst = findCombination(rest, target - first);
        if (withFirst != null) {
            withFirst.add(first);
            return withFirst;
        }

        // If that doesn't work, try excluding the first element from the combination
        return findCombination(rest, target);
    }
}


/*
The split method converts the input UniqueOrderedList into a List and,
 then calls the findCombination method to find a combination of elements that adds up to the target.
 It tries two possibilities for each element: including it in the combination and excluding it.
 If a valid combination is found, it is returned as a UniqueOrderedList. If no combination is found, the method returns null.
 */