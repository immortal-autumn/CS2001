package Test;
import static org.junit.Assert.*;

import Impl.BubbleSort;
import Impl.QuickSort;
import Impl.SelectionSort;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialTest {
    private String listString;
    private String[] listAsArray;

    private List<Integer> list;
    private List<Integer> actual;
    private List<Integer> expected;

    private final int lengthOfList = 1000;

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
    public void SortCheck() {
        QuickSort sorted = new QuickSort();
        long initialTime = System.currentTimeMillis();
        actual = sorted.recursiveQuickSort(list);
        long afterTime = System.currentTimeMillis();
        actual = sorted.recursiveQuickSort(list);
        System.out.println("Quick sort time spend: " + (afterTime - initialTime) + "ms");
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void BubbleSortCheck() {
        BubbleSort sorted = new BubbleSort();
        long initialTime = System.currentTimeMillis();
        actual = sorted.ilterativeBubbleSort(list);
        long afterTime = System.currentTimeMillis();
        System.out.println("Bubble sort time spend: " + (afterTime - initialTime) + "ms");
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void SelectionSortTest() {
        SelectionSort sorted = new SelectionSort();
        long initialTime = System.currentTimeMillis();
        actual = sorted.selectionSort(list);
        long afterTime = System.currentTimeMillis();
        System.out.println("Bubble sort time spend: " + (afterTime - initialTime) + "ms");
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
