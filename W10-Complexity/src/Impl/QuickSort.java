package Impl;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    /**
     * This method is used to sort the list using quick sort.
     * Algorithm:
     * Find the last element as the pivot element -> insert bigger and smaller values -> return all as a list
     * @param list is the list that would be used to sort.
     */
    public List<Integer> recursiveQuickSort(List<Integer> list) {
        if(list == null) {
            return null;
        }
        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        List<Integer> sorted = new ArrayList<>();

        int listSize = list.size();
        if (list.size() > 1) {
            int pivot = list.get(listSize - 1);
            for (Integer element : list) {
                if (element > pivot) {
                    bigger.add(element);
                }
                if (element < pivot) {
                    smaller.add(element);
                }
                if (element == pivot) {
                    equal.add(element);
                }
            }
            if(bigger.isEmpty() && smaller.isEmpty()) {
                // return something here
                return equal;
            }
            else {
                sorted.addAll(recursiveQuickSort(smaller));
                sorted.addAll(equal);
                sorted.addAll(recursiveQuickSort(bigger));
                return sorted;
            }
        }
        else {
            return list;
        }
        // return something here
    }
}