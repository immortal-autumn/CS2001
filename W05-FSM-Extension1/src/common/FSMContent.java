package common;

import interfaces.IFSMContent;

/**
 * This class will store data of FSM file in order to retrieve the output and statement.
 */
public class FSMContent implements IFSMContent {

    private String currentState;
    private String nextState;
    private String inputSymbol;
    private String outputSymbol;

    /**
     * This will input fsm key words to FSM Content.
     * @param currentState is the current state of the process.
     * @param inputSymbol is the input from the fsm file.
     * @param outputSymbol is the reflected output according to the input.
     * @param nextState is the next state.
     */
    public FSMContent(String currentState, String inputSymbol, String outputSymbol, String nextState) {
        this.currentState = currentState;
        this.inputSymbol = inputSymbol;
        this.outputSymbol = outputSymbol;
        this.nextState = nextState;
    }

    @Override
    public String getCurrentState() {
        return currentState;
    }

    @Override
    public String getNextState() {
        return nextState;
    }

    @Override
    public String getInputSymbol() {
        return inputSymbol;
    }

    @Override
    public String getOutputSymbol() {
        return outputSymbol;
    }

}
