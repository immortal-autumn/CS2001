package interfaces;

public interface IFSMContent {
    /**
     * Will get the current state.
     * @return the currrent state.
     */
    String getCurrentState();

    /**
     * Will get next state.
     * @return the next state.
     */
    String getNextState();

    /**
     * Will get the input symbol.
     * @return the input symbol.
     */
    String getInputSymbol();

    /**
     * Will get the output symbol.
     * @return the output symbol.
     */
    String getOutputSymbol();
}
