package Test;
import static org.junit.Assert.*;

import Impl.QuickSort;
import org.junit.*;

import java.util.Arrays;

public class SortTest {
    private final int lengthOfList = 10;
    private final String random = RandomNumber.random(lengthOfList);

    private QuickSort sort;

    private String[] listAsArray;
    private int[] intArray;
    private int[] expected;

    @Before
    public void setUp() {
        listAsArray = random.split(",");
        intArray = Arrays.stream(listAsArray).mapToInt(Integer::parseInt).toArray();
        expected = Arrays.stream(listAsArray).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(expected);
    }

    /**
     * This will test arrays are successfully converted into int[] array and will show the random number series.
     */
    @Test
    public void arrayTest() {
        System.out.println(random);
        assertEquals(listAsArray.length, intArray.length);
        for (int i = 0; i < listAsArray.length; i++) {
            assertEquals(Integer.parseInt(listAsArray[i]), intArray[i]);
        }
    }

    /**
     * This will test and prevent null for inputted array is null.
     */
    @Test
    public void nullTest() {
        sort = new QuickSort(null);
        assertNull(sort.array);
    }

    /**
     * This method will test the quick sort is successfully
     */
    @Test
    public void equalTest() {
        long initialTime = System.currentTimeMillis();
        sort = new QuickSort(intArray);
        long spendtime = System.currentTimeMillis() - initialTime;
        System.out.println("Time spend for compiling the quick sort is " + spendtime + "ms.");
        int[] actual = sort.array;
        for (int a = 0; a < expected.length; a++) {
            assertEquals(expected[a], actual[a]);
        }
    }
}
