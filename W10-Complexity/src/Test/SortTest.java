package Test;
import static org.junit.Assert.*;

import Impl.BubbleSort;
import Impl.MergeSort;
import Impl.QuickSort;
import Impl.SelectionSort;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    private String listString;
    private String[] listAsArray;

    private List<Integer> list;
    private List<Integer> actual;
    private List<Integer> expected;

    private final int lengthOfList = 10;
    private QuickSort sorted;
    private BubbleSort sorted1;

    @Before
    public void createList() {
        list = new ArrayList<>();
        expected = new ArrayList<>();
        listString = RandomNumber.random(lengthOfList);
        listAsArray = listString.split(",");
        for (String aListAsArray : listAsArray) {
//            System.out.println(aListAsArray);
            list.add(Integer.parseInt(aListAsArray));
            expected.add(Integer.parseInt(aListAsArray));
        }
        Collections.sort(expected);
    }

    @Test
    public void CheckRandomNumber() {
//        System.out.println(listString);
        assertNotNull(listString, listString);
        assertEquals(listAsArray.length, list.size());
        assertEquals(expected.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.parseInt(listAsArray[i]), list.get(i));
        }
    }

    @Test
    public void nullTest() {
        sorted = new QuickSort();
        actual = sorted.recursiveQuickSort(null);
        assertNull(actual);
    }

    @Test
    public void noneEleTest() {
        sorted = new QuickSort();
        actual =sorted.recursiveQuickSort(new ArrayList<>());
        assertEquals(0, actual.size());
    }

    @Test
    public void QuickSortCheck() {
        sorted = new QuickSort();
        System.out.println("Random series is: " + listString);
        long initialTime = System.currentTimeMillis();
        actual = sorted.recursiveQuickSort(list);
        long afterTime = System.currentTimeMillis();
        System.out.println("Quick sort time spend: " + (afterTime - initialTime) + "ms");
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            System.out.println("actual: >" + actual.get(i) + " / expected: >" + expected.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void BubbleNullTest() {
        sorted1 = new BubbleSort();
        actual = sorted1.ilterativeBubbleSort(null);
        assertNull(actual);
    }

    @Test
    public void BubbleSortCheck() {
        sorted1 = new BubbleSort();
        long initialTime = System.currentTimeMillis();
        actual = sorted1.ilterativeBubbleSort(list);
        long afterTime = System.currentTimeMillis();
        System.out.println("Bubble sort time spend: " + (afterTime - initialTime) + "ms");
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            System.out.println("actual: >" + actual.get(i) + " / expected: >" + expected.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void MergeSortCheck() {
        MergeSort sort = new MergeSort();
        long initialTime = System.currentTimeMillis();
        actual = list;
        sort.sort(actual);
        long afterTime = System.currentTimeMillis();
        System.out.println("Merge sort time spend: " + (afterTime - initialTime) + "ms");
//        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            System.out.println("actual: >" + actual.get(i) + " / expected: >" + expected.get(i));
//            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void SelectionTest() {
        SelectionSort sort = new SelectionSort();
        long initialTime = System.currentTimeMillis();
        actual = sort.selectionSort(list);
        long afterTime = System.currentTimeMillis();
        System.out.println("Merge sort time spend: " + (afterTime - initialTime) + "ms");
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            System.out.println("actual: >" + actual.get(i) + " / expected: >" + expected.get(i));
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void SelectionNullTest() {
        SelectionSort sort = new SelectionSort();
        actual = sort.selectionSort(null);
        assertNull(actual);
    }
}
