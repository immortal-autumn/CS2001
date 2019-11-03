package Impl;
import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public List<Integer> sorted = new ArrayList<>();

    /**
     * Constructor calls the method that will quick sort the arrayList.
     * @param head is the head that was given.
     */
    public QuickSort(List<Integer> head) {
        recursiveQuickSort(head);
    }

    /**
     * This method is used to sort the list using quick sort.
     * Algorithm:
     * Find the last element as the pivot element -> insert bigger and smaller values -> return all as a list
     * @param list is the list that would be used to sort.
     */
    private void recursiveQuickSort(List<Integer> list) {
        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        int listSize = list.size();
        int pivot = list.get(listSize - 1);
        list.remove(listSize - 1);
        for (Integer element : list) {
            if (element > pivot) {
                bigger.add(element);
            }
            if (element <= pivot) {
                smaller.add(element);
            }
        }
        //smaller -> bigger
        if(smaller.isEmpty()) {

        }

    }
}