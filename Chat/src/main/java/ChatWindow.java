/*– Создать окно клиента чата.
 Окно должно содержать JtextField для ввода логина, пароля, IP-адреса сервера, порта подключения к серверу,
 область ввода сообщений,
 JTextArea область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
 Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать
 на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 480;
    private static final int WINDOW_WIDTH = 640;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private static final String WINDOW_NAME = "Server Chat";

    private String login;
    private String logFilePath = "chat_log.txt";

    private JTextArea textOutput = new JTextArea("");
    private JTextField textInput = new JTextField("Type your message here");
    private JButton buttonSend = new JButton("Send");

    private JPanel grid = new JPanel(new BorderLayout());
    private JPanel historyPanel = new JPanel(new BorderLayout());

    ChatWindow(String login) {
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        this.login = login;

        textOutput.setEditable(false);
        textOutput.setBackground(Color.LIGHT_GRAY);

        JScrollPane scrollPane = new JScrollPane(textOutput);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        grid.add(historyPanel, BorderLayout.CENTER);

        textInput.setForeground(Color.GRAY);
        textInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textInput.getText().equals("Type your message here")) {
                    textInput.setText("");
                    textInput.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textInput.getText().isEmpty()) {
                    textInput.setForeground(Color.GRAY);
                    textInput.setText("Type your message here");
                }
            }
        });

        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(textInput, BorderLayout.CENTER);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputPanel.add(buttonSend, BorderLayout.EAST);
        grid.add(inputPanel, BorderLayout.SOUTH);

        add(grid);
        setVisible(true);

        loadChatHistory();
    }

    private void loadChatHistory() {
        File logFile = new File(logFilePath);

        if (logFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textOutput.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMessage() {
        String message = textInput.getText();
        if (!message.isEmpty() && !message.equals("Type your message here")) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));
            String logEntry = timestamp + " " + login + ": " + message + "\n";
            textOutput.append(logEntry);
            textInput.setText("");
            textInput.setForeground(Color.GRAY);
            textInput.setText("Type your message here");

            writeLogToFile(logEntry);

            textInput.setFocusable(false);
            textInput.setFocusable(true);
        }
    }

    private void writeLogToFile(String logEntry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath, true))) {
            writer.write(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
