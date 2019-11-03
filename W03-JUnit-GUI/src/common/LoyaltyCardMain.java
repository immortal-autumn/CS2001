package common;

import javax.swing.*;

public class LoyaltyCardMain {
    /**
     * This will run the program not JUnit test.
     * @param args are arguments but in this project arg.length == 0
     */
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("没有安装jre6u10,尝试当前系统的风格");
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        GUIClient client = new GUIClient();
        client.showFrame();
    }

}
