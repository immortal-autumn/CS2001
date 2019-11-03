package Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort {
    /**
     * This class is for bubble sort.
     * @param list is the list that requires to be sorted.
     */
    public List<Integer> ilterativeBubbleSort(List<Integer> list) {
        if(list == null) return null;
        List<Integer> sorted = new ArrayList<>(list);
        for (int i : sorted) {
            for (int j = 0; j < sorted.size() - 1; j++) {
                if(sorted.get(j) > sorted.get(j+1)) {
                    Collections.swap(sorted, j, j+1);
                }
            }
        }
        return sorted;
    }
}
