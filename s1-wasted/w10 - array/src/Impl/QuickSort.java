package Impl;

public class QuickSort {
    public int[] array;
    /**
     * Constructor calls the method that will quick sort the array.
     * @param array is the array that needs to be sorted.
     */
    public QuickSort(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }
        this.array = array;
        recursiveQuickSort(0, array.length - 1);
    }

    /**
     * This method is used to sort the array using quick sort.
     * Misunderstanding: sort with element (x) -> correct: sort with index
     * Algorithm:
     * Find the last element as the pivot element -> swap bigger and smaller values -> insert pivot to correct space -> recursive function
     */
    private void recursiveQuickSort(int lower, int length) {
        if(lower <= length) {
            int pivot = array[length];
            int low = lower;

            for (int a = 0; a < length; a++) {
                if (array[a] < pivot) {
                    exchange(low, length);
                    low ++;
                }
            }
            array[length] = array[low];
            array[low] = pivot;
            recursiveQuickSort(low, length);
        }
    }
}

/*
Note:
{a, b, c, d, x(Pivot)} -> {a, b(Pivot)|, x,| c, d(Pivot)} -> {b, a, x, d, c}
let left side smaller than x and right side higher than x

Note2:
Not using in-place quick-sort:
{a,b,c,d,x(pivot)} -> bigger:{...}, smaller{...} -> return and sort elements from smaller to bigger.
*/