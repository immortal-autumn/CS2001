package common;

import interfaces.IReadFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile implements IReadFile {

    /**
     * This method will read the file that was given from the .fsm file.
     */
    @Override
    public List<String> readFsmFile(String path){
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            //establish a new reader
            reader = new BufferedReader(new FileReader(path));
            String wordLine;
            while ((wordLine = reader.readLine()) != null) {
                list.add(wordLine);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String[] splitFsmLine(String line) {
        Scanner scanner = new Scanner(line);
        String[] fsm = new String[4];
        int i = 0;
        while (scanner.hasNext()) {
            fsm[i] = scanner.next();
//            System.out.println(fsm[i]);
            i++;
        }
        return fsm;
    }

    @Override
    public FSMContent saveFSMContent(String[] word) {
        return new FSMContent(word[0], word[1], word[2], word[3]);
    }

}
