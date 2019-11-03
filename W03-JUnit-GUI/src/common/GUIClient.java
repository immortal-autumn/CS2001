package common;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;

public class GUIClient extends JFrame {
    /**
     * This frame is basically taught from the website:
     * https://blog.csdn.net/beiouwolf/article/details/7714793
     * which is edited by "beiouwolf"
     */

    private JTextField command;
    private JButton action;
    private JTextArea output;

    private Process process;
    private PrintWriter writer;

    public GUIClient() {
        //default import
        ImageIcon img = new ImageIcon("/W03-JUnit_GUI/time.jpg");

        //size of GUI window
        this.setPreferredSize(new Dimension(666, 666));
        this.setTitle("Loyalty Card System");
        this.setIconImage(img.getImage());

        //command input
        TitledBorder titledBorder = new TitledBorder("Action");
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(titledBorder);

        //give word to JButton
        action = new JButton("Action");

        buttonPanel.add(command = new JTextField(), BorderLayout.CENTER);
        buttonPanel.add(action, BorderLayout.EAST);

        //disable traversal: Tab or others
        command.setFocusTraversalKeysEnabled(false);

        //add panel to the top
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        //show result
        JScrollPane scrollPane = new JScrollPane(output = new JTextArea(20, 20));
        //add pane to the content
        this.getContentPane().add(scrollPane);

        //enable always show results in bottom line
        ((DefaultCaret)output.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //listener
        this.action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(command.getText().equals("")) return;

                int command_input = Integer.parseInt(command.getText());
                new AccessOperator(output, command_input);

                command.setText("");


            }
        });

        //listener2
        this.command.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    action.doClick();
                    command.setText("");
                }
            }
        });
    }

    /**
     * This method is used to show the frame.
     */
    public void showFrame() {
        this.pack();
        this.setVisible(true);
    }
}
