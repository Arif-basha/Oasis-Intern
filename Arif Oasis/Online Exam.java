import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static String currentUser;
    private static int currentQuestionIndex = 0;
    private static int score = 0;
    private static final int MAX_QUESTIONS = 5; // Set the total number of questions

    public static void main(String[] args) {
        // Initialize the GUI
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Online Exam Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create login panel
        JPanel loginPanel = new JPanel();
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Simple authentication (replace with actual authentication logic)
            if (authenticateUser(username, password)) {
                currentUser = username;
                showMainPanel(frame);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials. Try again.");
            }

            // Clear password field for security
            passwordField.setText("");
        });

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        frame.getContentPane().add(loginPanel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    private static boolean authenticateUser(String username, char[] password) {
        // Simple hardcoded authentication (replace with actual authentication logic)
        return username.equals("admin") && new String(password).equals("admin123");
    }

    private static void showMainPanel(JFrame frame) {
        frame.getContentPane().removeAll();

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add question label
        JLabel questionLabel = new JLabel("Question: What is the capital of France?");
        mainPanel.add(questionLabel);

        // Add radio buttons for options
        String[] options = {"Paris", "Berlin", "London", "Madrid"};
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < options.length; i++) {
            JRadioButton radioButton = new JRadioButton(options[i]);
            final int optionIndex = i;
            radioButton.addActionListener(e -> checkAnswer(optionIndex));
            buttonGroup.add(radioButton);
            mainPanel.add(radioButton);
        }

        // Add next button
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> showNextQuestion(frame));
        mainPanel.add(nextButton);

        // Add logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> logout(frame));
        mainPanel.add(logoutButton);

        frame.getContentPane().add(mainPanel);
        frame.setSize(400, 250);
        frame.revalidate();
        frame.repaint();
    }

    private static void checkAnswer(int selectedOption) {
        // Hardcoded correct answer (replace with dynamic questions and answers)
        int correctAnswer = 0;

        if (selectedOption == correctAnswer) {
            score++;
        }
    }

    private static void showNextQuestion(JFrame frame) {
        currentQuestionIndex++;

        if (currentQuestionIndex < MAX_QUESTIONS) {
            // Display the next question (replace with dynamic questions and answers)
            JLabel questionLabel = new JLabel("Question " + (currentQuestionIndex + 1) + ": Sample Question?");
            JOptionPane.showMessageDialog(frame, questionLabel);
        } else {
            // Display final score
            JOptionPane.showMessageDialog(frame, "Your score: " + score + " out of " + MAX_QUESTIONS);
            logout(frame);
        }
    }

    private static void logout(JFrame frame) {
        currentUser = null;
        currentQuestionIndex = 0;
        score = 0;
        createAndShowGUI();
    }
}
