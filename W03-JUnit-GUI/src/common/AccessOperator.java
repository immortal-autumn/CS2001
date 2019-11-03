package common;

import javax.swing.*;
import java.io.InputStream;

public class AccessOperator extends AbstractFactoryClient{

    private JTextArea text;
    private int is;

    public AccessOperator(JTextArea text, int is) {
        this.text = text;
        this.is = is;
    }

    public void mainMenu(int is) {
        text.append("Press 1: Register a new user.");
        text.append("Press 2: Unregister a current user.");
        text.append("Press 3: Money process.");
        text.append("Press 4: Get the most used user.");
        switch (is) {
            case 1 : {
                text.append("To register a user, please input your e-mail and your name.");
                registerOwner();
            }
            case 2 : {
                text.append("To unregister your user, please input your e-mail");
                unregisterOwner();
            }
            case 3 : {
                text.append("Press 1: Purchase from ");
                purchase(is);
            }
            case 4 : {
                text.append("Get most used user");
            }
            default: {

            }
        }
    }

    public void registerOwner() {
        text = new JTextArea();

    }

    public void unregisterOwner() {

    }

    public void purchase(int i) {
        switch (i) {
            case 1 : {

            }
        }
    }
}
