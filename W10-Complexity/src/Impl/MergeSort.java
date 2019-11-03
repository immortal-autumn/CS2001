package Impl;

import java.util.ArrayList;
import java.util.List;

/**
 * The code is learned from:
 * https://gist.github.com/louisbros/8514819 @author: louisbros
 * Understanding of the code will be described below.
 */
public class MergeSort {
    public void sort(List<Integer> list) {
        mergeSort(0, list.size() - 1, list, new ArrayList<Integer>(list));
    }

    /**
     * This method will divide the index of the list recursively into half.
     * algorithm:
     * index of the full list -> index dived to half and recursively until low = high -> operate using index.
     * @param low is the index from 0.
     * @param high is the index of the size of list.
     * @param list is the list needs to be sorted.
     * @param temp is the list temporarily store the data.
     */
    private void mergeSort(int low, int high, List<Integer> list, List<Integer> temp) {
        if (low < high) {
            int n = high - low;
            int mid = low + n / 2;
            mergeSort(low, mid, list, temp);
            mergeSort(mid+1, high, list, temp);
            merge(low, mid, high, list, temp);
        }
    }

    /**
     * This method operate using original list with index. The algorithm is as follows:
     * when both  index of lower and higher of the list is in operable range the list will add the element, if one of the index is out of range,
     * the list will add the rest of the data.
     * The algorithm are similar when only one element in the operable list and the list will only operate the lower one.
     * @param low is the lowest number of operable list.
     * @param mid is the medium number of the operable list.
     * @param high is the highest number of the operable list.
     * @param list is the list that requires to be sorted.
     * @param temp is the list that stores the data.
     */
    private void merge(int low, int mid, int high, List<Integer> list, List<Integer> temp) {
        int lower = low;
        int higher = mid + 1;

        for (int i = low; i <= high; i++) {
            temp.set(i, list.get(i));
        }

        while (lower <= mid && higher <= high) {
            list.set(low++, temp.get(lower).compareTo(temp.get(higher)) < 0 ? temp.get(lower++) : temp.get(higher++));
        }

        while (lower <= mid) {
            list.set(low++, temp.get(lower++));
        }
    }
}
