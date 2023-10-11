import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 200;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private static final String WINDOW_NAME = "Server Connection";

    private JTextField loginField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField serverField = new JTextField();
    private JButton buttonConnect = new JButton("Connect");

    private JLabel loginLabel = new JLabel("Enter your login:");
    private JLabel passwordLabel = new JLabel("Enter your password:");
    private JLabel serverLabel = new JLabel("Enter server address and port:");

    JPanel grid = new JPanel(new GridLayout(4, 1));
    JPanel loginPanel = new JPanel(new GridLayout(1, 2));
    JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
    JPanel serverPanel = new JPanel(new GridLayout(1, 2));
    JPanel buttonPanel = new JPanel();

    ConnectWindow() {
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginPanel.add(loginLabel);
        loginPanel.add(loginField);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        serverPanel.add(serverLabel);
        serverPanel.add(serverField);

        buttonPanel.add(buttonConnect);

        grid.add(loginPanel);
        grid.add(passwordPanel);
        grid.add(serverPanel);
        grid.add(buttonPanel);

        add(grid);

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());
                String serverAddress = serverField.getText();

                if (login.isEmpty() || password.isEmpty() || serverAddress.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    new ChatWindow(login);
                }
            }
        });

        setVisible(true);
    }
}
