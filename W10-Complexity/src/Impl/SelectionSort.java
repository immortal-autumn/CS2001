package Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {
    private List<Integer> sorted = new ArrayList<>();

    public List<Integer> selectionSort(List<Integer> list) {
        if(list == null) return null;
        if(list.isEmpty()) return sorted;
        int index = list.indexOf(Collections.min(list));
        sorted.add(list.get(index));
        list.remove(index);
        return selectionSort(list);
    }
}
