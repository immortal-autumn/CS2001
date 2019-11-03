package interfaces;

import common.FSMContent;

import java.util.List;

public interface IReadFile {
    /**
     * This is used to read the fsm file.
     * @return reader to send to the test.
     */
    List<String> readFsmFile(String path);

    /**
     * This is used to save fsm command to list.
     * @return splited elements in order to send to test.
     * @param line is the line that need to be splitted.
     */
    String[] splitFsmLine(String line);

    /**
     * This is used to save fsm command to FSMContent Class.
     * @return FSMContent type in orde to save all data at once
     * @param word is the single word that already splitted.
     */
    FSMContent saveFSMContent(String[] word);
}
