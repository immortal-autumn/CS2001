package interfaces;

import java.io.FileNotFoundException;

public interface IInputStream {
    /**
     * This method will read the input file when the input is a kind of file.
     * @param filepath is the path of the file
     * @return the content of the file.
     */
    String inputFile(String filepath) throws FileNotFoundException;
    /**
     * This method will convert the input into array.
     * @return the array of input.
     */
    String[] inputArray(String input);
}
