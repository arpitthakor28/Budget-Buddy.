import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class Login extends JFrame implements ActionListener {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    
    // Modern Color Palette
    private final Color BACKGROUND_COLOR = new Color(15, 23, 42); // slate_900
    private final Color GLASS_COLOR = new Color(255, 255, 255, 20); // semi-transparent white
    private final Color ACCENT_COLOR = new Color(5, 150, 105); // emerald_600
    private final Color TEXT_PRIMARY = new Color(248, 250, 252); // slate_50
    private final Color TEXT_SECONDARY = new Color(148, 163, 184); // slate_400

    public Login() {
        setTitle("MoneyApp - Premium Login");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setUndecorated(false); // Set to true for a custom title bar if desired
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main background panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        setContentPane(mainPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;

        // Header
        JLabel logoLabel = new JLabel("MoneyApp", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Inter", Font.BOLD, 32));
        logoLabel.setForeground(TEXT_PRIMARY);
        gbc.gridy = 0;
        mainPanel.add(logoLabel, gbc);

        JLabel subTitle = new JLabel("Welcome Back", SwingConstants.CENTER);
        subTitle.setFont(new Font("Inter", Font.PLAIN, 16));
        subTitle.setForeground(TEXT_SECONDARY);
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 30, 0);
        mainPanel.add(subTitle, gbc);

        // Form Container (Visual only, using gbc for placement)
        gbc.insets = new Insets(10, 0, 5, 0);
        
        // Email Field
        JLabel emailLabel = new JLabel("Email or Phone Number");
        emailLabel.setFont(new Font("Inter", Font.BOLD, 12));
        emailLabel.setForeground(TEXT_SECONDARY);
        gbc.gridy = 2;
        mainPanel.add(emailLabel, gbc);

        emailField = createModernTextField();
        gbc.gridy = 3;
        mainPanel.add(emailField, gbc);

        // Password Field
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Inter", Font.BOLD, 12));
        passLabel.setForeground(TEXT_SECONDARY);
        gbc.gridy = 4;
        mainPanel.add(passLabel, gbc);

        passwordField = createModernPasswordField();
        gbc.gridy = 5;
        mainPanel.add(passwordField, gbc);

        // Login Button
        loginButton = new JButton("Login");
        stylePrimaryButton(loginButton);
        gbc.gridy = 6;
        gbc.insets = new Insets(30, 0, 15, 0);
        mainPanel.add(loginButton, gbc);

        // Register Link
        registerButton = new JButton("Don't have an account? Register");
        styleLinkButton(registerButton);
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(registerButton, gbc);

        // Actions
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        setVisible(true);
    }

    private JTextField createModernTextField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(300, 45));
        field.setBackground(new Color(30, 41, 59)); // slate_800
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(51, 65, 85), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        field.setFont(new Font("Inter", Font.PLAIN, 14));
        return field;
    }

    private JPasswordField createModernPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setPreferredSize(new Dimension(300, 45));
        field.setBackground(new Color(30, 41, 59));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(51, 65, 85), 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        field.setFont(new Font("Inter", Font.PLAIN, 14));
        return field;
    }

    private void stylePrimaryButton(JButton button) {
        button.setPreferredSize(new Dimension(300, 50));
        button.setBackground(ACCENT_COLOR);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Inter", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(ACCENT_COLOR.brighter());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(ACCENT_COLOR);
            }
        });
    }

    private void styleLinkButton(JButton button) {
        button.setForeground(new Color(99, 102, 241)); // indigo_500
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Inter", Font.BOLD, 13));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String pass = new String(passwordField.getPassword());
            
            if (email.isEmpty() || pass.isEmpty()) {
                showModernError("Please enter both email and password.");
                return;
            }
            
            JOptionPane.showMessageDialog(this, "Welcome Back! Login Successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == registerButton) {
            JOptionPane.showMessageDialog(this, "Redirecting to registration...", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void showModernError(String message) {
        UIManager.put("OptionPane.background", BACKGROUND_COLOR);
        UIManager.put("Panel.background", BACKGROUND_COLOR);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        JOptionPane.showMessageDialog(this, message, "Notice", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        // Use system look and feel for better font rendering
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(Login::new);
    }
}
