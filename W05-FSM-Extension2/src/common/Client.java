package common;

import interfaces.IInputStream;
import interfaces.IReadFile;

import java.util.*;

public class Client {

    private static Client client = null;
    private String path;
    private Map<String, FSMContent> contentsMap;
    private String currentState = null;
    public Set<String> current_state, next_state, solution_set;
//    private int max_currentState, max_nextState;

    private Client() {
        solution_set = new HashSet<>();
        contentsMap = new HashMap<>();
        current_state = new HashSet<>();
        next_state = new HashSet<>();
    }

    /**
     * Get the instance can be used for return only one Client without losing data.
     * @return the Client.
     */
    public static Client getInstance() {
        if(client == null) {
            client = new Client();
        }
        return client;
    }

    /**
     * This method is used to set path.
     * @param path is the path of the fsm file;
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Originally I thought "<" is used to identify a file, however it is used to identify a new line.
     * This method is used to set  the input into array.
     * @param input is the input String
     * @return values of input array
     */
    public String[] setInputArray(String input) {
        IInputStream input_array = new InputStream();
//        if (input.contains(".txt")) {
//           input = input_array.inputFile(input);
//        }
        return input_array.inputArray(input);
    }

    /**
     * This method is used to get all FSM File and save into map.
     */
    public void getAllFSMProcess() {
        IReadFile readFile = new ReadFile();
        List<String> list = readFile.readFsmFile(path);
        for(String s : list) {
            FSMContent content = readFile.saveFSMContent(readFile.splitFsmLine(s));
            if(currentState == null) {
                currentState = content.getCurrentState();
            }
            current_state.add(content.getCurrentState());
            next_state.add(content.getNextState());
            solution_set.add(content.getInputSymbol());
            contentsMap.put(content.getCurrentState() + content.getInputSymbol(), content);
        }
    }

    /**
     * This method is used to identify reflected statement.
     * @param currentInput is the current input.
     * @throws BadInputException will give hints to prevent no input available in fsm.
     */
    public void FSMProcess(String currentInput) throws BadInputException{
        if (contentsMap.containsKey(currentState + currentInput)) {
            System.out.print(contentsMap.get(currentState + currentInput).getOutputSymbol());
            this.currentState = contentsMap.get(currentState + currentInput).getNextState();
        }
        else throw new BadInputException();
    }

    /**
     * This method will check several things:
     * 1. next state contains each current state and vice versa.n
     * 2. Every current state contains solution to every input
     */
    public void missingInput() throws BadDescriptionException {
        //check 1
        if (!current_state.containsAll(next_state)) {
            throw new BadDescriptionException();
        }
    }

    public void badDescription() throws BadDescriptionException{
        //check 2
        for (String o : current_state) {
            for (String u : solution_set) {
                if(!contentsMap.containsKey(o + u)) {
                    contentsMap.put(o + u, new FSMContent(o, u, "<null>", o));
                }
            }
        }
    }
}
