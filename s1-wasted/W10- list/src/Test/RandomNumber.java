package Test;

public class RandomNumber {
    /**
     * This will return a series of random number splitted by comma.
     * @param n is the size that used to stop the recursive process.
     * @return the next step of recursive or stop the process.
     */
    static String random(int n) {
        return random(n, 1);
    }

    static String random(int n, int size) {
        int number = (int) (Math.random() * 10 + 1);
        if (size == n) {
            return number + "";
        }
        return number + "," + random(n, size + 1);
    }
}
