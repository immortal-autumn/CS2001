package test;

import common.*;
import interfaces.IFSMContent;
import interfaces.IInputStream;
import interfaces.IReadFile;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


public class Tests {
    private final String path = "example-1.fsm";
    private final String[] args = {path, "001"};
    private IReadFile readFile = new ReadFile();

    /**
     * This will checks files has been correctly read.
     */
    @Test
    public void checkReadFiles() {
        assertFalse(readFile.readFsmFile(path).size() == 0);
    }

    /**
     * This will test scanner will get correct positions of every statement.
     */
    @Test
    public void scannerTest() {
        String[] result = readFile.splitFsmLine("1 2 3 4");
        assertEquals(result[0], "1");
        assertEquals(result[1], "2");
        assertEquals(result[2], "3");
        assertEquals(result[3], "4");
    }

    /**
     * This will test fsm will correctly being saved to fsmContent.
     */
    @Test
    public void savingDataTest() {
        String[] result = readFile.splitFsmLine("1 2 3 4");
        FSMContent content = readFile.saveFSMContent(result);
        assertEquals(content.getCurrentState(), "1");
        assertEquals(content.getInputSymbol(), "2");
        assertEquals(content.getOutputSymbol(), "3");
        assertEquals(content.getNextState(), "4");
    }

    /**
     * This will test the InputStream class can successfully split the input stream
     */
    @Test
    public void inputTest() {
        IInputStream input = new InputStream();
        assertEquals(input.inputArray("123").length, 3);
    }

    /**
     * This will test the FSM Content can be successfully retrieved.
     */
    @Test
    public void contentTest() {
        IFSMContent content = new FSMContent("1", "2", "3", "4");
        assertEquals("1", content.getCurrentState());
        assertEquals("2", content.getInputSymbol());
        assertEquals("3", content.getOutputSymbol());
        assertEquals("4", content.getNextState());
    }

    /**
     * This test will check the Client is not null and can get correct instance.
     */
    @Test
    public void clientTest() {
        Client client = Client.getInstance();
        assertNotNull(client);
    }

    /**
     * This will test the input can be successfully divided
     */
    @Test
    public void InputTest() {
        Client client = Client.getInstance();
        IInputStream inputTest = new InputStream();
        assertEquals(inputTest.inputArray("123").length, 3);
        assertEquals(client.setInputArray("123").length, 3);
    }

    /**
     * This will test the fsm function using real example file.
     */
    @Test
    public void FSMFileTest() throws BadInputException {
        Client client = Client.getInstance();
        client.setPath(path);
        client.getAllFSMProcess();
        client.FSMProcess("1");
        client.FSMProcess("1");
    }

    /**
     * This will test bad description can be successfully thrown
     */
    @Test
    public void BadDescriptionCheck() throws BadDescriptionException {
        Client client = Client.getInstance();
        client.setPath(path);
        client.setInputArray("111");
        client.getAllFSMProcess();
        System.out.println(client.solution_set.size() + " " +client.current_state.size());
    }
}
