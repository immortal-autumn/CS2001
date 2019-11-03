package common;

import interfaces.IInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputStream implements IInputStream {

    @Override
    public String inputFile(String filepath) {
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            line = reader.readLine();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    @Override
    public String[] inputArray(String input) {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        List<String> wordList = new ArrayList<>();

        String word = null;
        try {
            word = reader.readLine();
            for(int i = 0; i < word.length(); i++){
                wordList.add(word.substring(i, i+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList.toArray(new String[0]);
    }
}
