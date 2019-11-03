package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EditDistance {
    public List<Integer> list = new ArrayList<>();
    private int size;
    private int complexity = 0;

    /**
     * The constructor will set up a sorted list with size that inputted.
     * @param size is the size that we want to use.
     */
    public EditDistance(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            list.add(i + 1);
        }
    }

    /**
     * This method will randomly swap two elements in the list.
     */
    public void randomExchange() {
        int a = ThreadLocalRandom.current().nextInt(0, size - 1);
        Collections.swap(list, a, a+1);
        complexity++;
    }

    /**
     * THIS METHOD WILL RETURN THE COMPLEXITY OF THE LIST.
     * @return the complexity
     */
    public int getComplexity() {
        return complexity;
    }
}
