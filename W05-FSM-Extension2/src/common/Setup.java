package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Setup {
    /**
     * The fsm process contains several Elements:
     * Note that: F = (S, σ, I, O, f, g)
     * @param args will receive arguments with the file path of fsm description file
     */
    public static void starter(String[] args) {
	// write your code here
        try {
            Setup.checkArguments(args);
        }
        catch (BadDescriptionException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        Client client = Client.getInstance();
        client.setPath(args[0]);
        client.getAllFSMProcess();
        try {
            client.missingInput();
            client.badDescription();
        }
        catch (BadDescriptionException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        while (true) {
            try {
                System.out.println();
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                for (String s : client.setInputArray(reader.readLine())) {
                    client.FSMProcess(s);
                }
            } catch (IOException | BadInputException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    /**
     * This method  will check the argument is equal to 2.
     * @param args are arguments inherited from the main class.
     */
    public static void checkArguments(String[] args) throws BadDescriptionException {
        if(args.length != 1) {
            throw new BadDescriptionException();
        }
    }
}
