package common;

import Impl.BubbleSort;
import Impl.MergeSort;
import Impl.QuickSort;
import Impl.SelectionSort;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This method is used to output the data into csv file with matrix.
 */
class OutputData {
    private PrintWriter writer;
    private EditDistance distance;
    private QuickSort sort;
    private BubbleSort sort1;
    private SelectionSort sort2;
    private MergeSort sort3;

    List<Integer> unsorted;

    private String filename;
    private final int maximum_complexity = 1000;
    private static final String header = "Complexity(times), TimeSpending(ms)";

    OutputData(String fileName, int size) {
        if(fileName == null) return;
        this.filename = fileName;
        setUp(size);
    }

    private void setUp(int size) {
        distance = new EditDistance(size);
        sort = new QuickSort();
        sort1 = new BubbleSort();
        sort2 = new SelectionSort();
        try {
            writer = new PrintWriter(filename);
            writer.println(header);
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    void quickwrite() {
        if(distance.getComplexity() == maximum_complexity) {
            writer.close();
            return;
        }
        unsorted = new ArrayList<>();
        unsorted.addAll(distance.list);
//        System.out.println(distance.getComplexity());
        long initialTime = System.currentTimeMillis();
        sort.recursiveQuickSort(unsorted);
        System.out.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        distance.randomExchange();
        quickwrite();
    }

    void complexityWithSize(int size) {
        distance = new EditDistance(size);
        unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            distance.randomExchange();
        }
        unsorted.addAll(distance.list);
        long initialTime = System.currentTimeMillis();
        sort.recursiveQuickSort(unsorted);
        System.out.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
    }

    void bubbleWrite() {
        if(distance.getComplexity() == maximum_complexity) {
            writer.close();
            return;
        }
        unsorted = new ArrayList<>();
        unsorted.addAll(distance.list);
//        System.out.println(distance.getComplexity());
        long initialTime = System.currentTimeMillis();
        sort1.ilterativeBubbleSort(unsorted);
        System.out.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        distance.randomExchange();
        quickwrite();
    }

    void bubbleComplexityWithSize(int size) {
        distance = new EditDistance(size);
        unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            distance.randomExchange();
        }
        unsorted.addAll(distance.list);
        long initialTime = System.currentTimeMillis();
        sort1.ilterativeBubbleSort(unsorted);
        System.out.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
    }

    void selectionSortWrite() {
        sort2 = new SelectionSort();
        if(distance.getComplexity() == maximum_complexity) {
            writer.close();
            return;
        }
        unsorted = new ArrayList<>();
        unsorted.addAll(distance.list);
//        System.out.println(distance.getComplexity());
        long initialTime = System.currentTimeMillis();
        sort2.selectionSort(unsorted);
        System.out.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        distance.randomExchange();
        quickwrite();
    }

    void selectionComplexityWithSize (int size) {
        sort2 = new SelectionSort();
        distance = new EditDistance(size);
        unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            distance.randomExchange();
        }
        unsorted.addAll(distance.list);
        long initialTime = System.currentTimeMillis();
        unsorted = sort2.selectionSort(unsorted);
        System.out.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
    }

    void mergeSortWrite() {
        sort3 = new MergeSort();
        if(distance.getComplexity() == maximum_complexity) {
            writer.close();
            return;
        }
        unsorted = new ArrayList<>();
        unsorted.addAll(distance.list);
//        System.out.println(distance.getComplexity());
        long initialTime = System.currentTimeMillis();
        sort3.sort(unsorted);
        System.out.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(distance.getComplexity() + ", " + (System.currentTimeMillis() - initialTime));
        distance.randomExchange();
        quickwrite();
    }

    void mergeComplexityWithSize (int size) {
        sort3 = new MergeSort();
        distance = new EditDistance(size);
        unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            distance.randomExchange();
        }
        unsorted.addAll(distance.list);
        long initialTime = System.currentTimeMillis();
        sort3.sort(unsorted);
        System.out.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
        writer.println(unsorted.size() + ", " + (System.currentTimeMillis() - initialTime));
    }

    void closeWriter() {
        writer.close();
    }
}
