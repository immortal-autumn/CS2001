package Test;
import static org.junit.Assert.*;

import Impl.QuickSort;
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
        assertEquals(lengthOfList, list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(Integer.parseInt(listAsArray[i]), list.get(i));
        }
    }

    @Test
    public void SortCheck() {
        System.out.println("Random series is: " + listString);
        long initialTime = System.currentTimeMillis();
        QuickSort sorted = new QuickSort(list);
        long afterTime = System.currentTimeMillis();
        actual = sorted.sorted;
        System.out.println("Quick sort time spend: " + (afterTime - initialTime) + "ms");
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < list.size() + 1; i++) {
            System.out.println(actual.get(i) + "," + expected.get(i));
//            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
