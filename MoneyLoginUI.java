import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MoneyLoginUI {

    // Antigravity Premium Color Palette
    private static final Color BG_DARK = new Color(15, 23, 42); // slate_900
    private static final Color CARD_BG = new Color(30, 41, 59); // slate_800
    private static final Color EMERALD_PRIMARY = new Color(5, 150, 105); // emerald_600
    private static final Color TEXT_PRIMARY = new Color(248, 250, 252); // slate_50
    private static final Color TEXT_MUTED = new Color(148, 163, 184); // slate_400
    private static final Color BORDER_COLOR = new Color(51, 65, 85); // slate_700

    public static void main(String[] args) {
        // Set System Look and Feel for better font rendering
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        JFrame frame = new JFrame("MoneyApp Premium Login");
        frame.setSize(450, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main Background Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG_DARK);
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
        frame.add(mainPanel);

        // GridBag Layout Constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;

        // --- Card Panel ---
        // We simulate a card using a container with a background color and padding
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(CARD_BG);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(40, 30, 40, 30)
        ));
        mainPanel.add(card, gbc);

        // Title
        JLabel titleLabel = new JLabel("MoneyApp", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 32));
        titleLabel.setForeground(TEXT_PRIMARY);
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 5, 0);
        card.add(titleLabel, gbc);

        // Subtitle
        JLabel subTitleLabel = new JLabel("Welcome Back", SwingConstants.CENTER);
        subTitleLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        subTitleLabel.setForeground(TEXT_MUTED);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 40, 0);
        card.add(subTitleLabel, gbc);

        // --- Form Fields ---
        gbc.insets = new Insets(10, 0, 5, 0);

        // Email label
        JLabel emailLabel = new JLabel("Email or Phone Number");
        emailLabel.setFont(new Font("Inter", Font.BOLD, 12));
        emailLabel.setForeground(TEXT_MUTED);
        gbc.gridy = 2;
        card.add(emailLabel, gbc);

        JTextField emailField = createStyledTextField();
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        card.add(emailField, gbc);

        // Password label
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Inter", Font.BOLD, 12));
        passLabel.setForeground(TEXT_MUTED);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 5, 0);
        card.add(passLabel, gbc);

        JPasswordField passField = createStyledPasswordField();
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 30, 0);
        card.add(passField, gbc);

        // Login Button
        JButton loginBtn = new JButton("Login");
        styleBtnPrimary(loginBtn);
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 0, 20, 0);
        card.add(loginBtn, gbc);

        // OR Divider
        JPanel dividerPanel = new JPanel(new GridBagLayout());
        dividerPanel.setOpaque(false);
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 10, 0);
        card.add(dividerPanel, gbc);

        GridBagConstraints dGbc = new GridBagConstraints();
        dGbc.fill = GridBagConstraints.HORIZONTAL;
        dGbc.weightx = 1.0;
        
        JSeparator leftSep = new JSeparator();
        leftSep.setForeground(BORDER_COLOR);
        dividerPanel.add(leftSep, dGbc);

        JLabel orLabel = new JLabel("  OR  ");
        orLabel.setForeground(TEXT_MUTED);
        orLabel.setFont(new Font("Inter", Font.BOLD, 10));
        dividerPanel.add(orLabel);

        JSeparator rightSep = new JSeparator();
        rightSep.setForeground(BORDER_COLOR);
        dividerPanel.add(rightSep, dGbc);

        // Google Button
        JButton googleBtn = new JButton("Connect with Google");
        styleBtnSecondary(googleBtn);
        gbc.gridy = 8;
        gbc.insets = new Insets(20, 0, 30, 0);
        card.add(googleBtn, gbc);

        // Register Link
        JButton registerBtn = new JButton("Don't have an account? Register");
        styleBtnLink(registerBtn);
        gbc.gridy = 9;
        gbc.insets = new Insets(0, 0, 0, 0);
        card.add(registerBtn, gbc);

        // Interactions
        loginBtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Login Successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE));
        
        frame.setVisible(true);
    }

    private static JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(300, 45));
        field.setMinimumSize(new Dimension(300, 45));
        field.setBackground(new Color(15, 23, 42)); // darker BG
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(51, 65, 85), 1),
            BorderFactory.createEmptyBorder(0, 15, 0, 15)
        ));
        field.setFont(new Font("Inter", Font.PLAIN, 14));
        return field;
    }

    private static JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setPreferredSize(new Dimension(300, 45));
        field.setMinimumSize(new Dimension(300, 45));
        field.setBackground(new Color(15, 23, 42));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(51, 65, 85), 1),
            BorderFactory.createEmptyBorder(0, 15, 0, 15)
        ));
        field.setFont(new Font("Inter", Font.PLAIN, 14));
        return field;
    }

    private static void styleBtnPrimary(JButton btn) {
        btn.setPreferredSize(new Dimension(300, 50));
        btn.setBackground(EMERALD_PRIMARY);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Inter", Font.BOLD, 16));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { btn.setBackground(EMERALD_PRIMARY.brighter()); }
            @Override
            public void mouseExited(MouseEvent e) { btn.setBackground(EMERALD_PRIMARY); }
        });
    }

    private static void styleBtnSecondary(JButton btn) {
        btn.setPreferredSize(new Dimension(300, 45));
        btn.setBackground(CARD_BG);
        btn.setForeground(TEXT_PRIMARY);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
        btn.setFont(new Font("Inter", Font.BOLD, 14));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { btn.setBackground(BORDER_COLOR); }
            @Override
            public void mouseExited(MouseEvent e) { btn.setBackground(CARD_BG); }
        });
    }

    private static void styleBtnLink(JButton btn) {
        btn.setForeground(new Color(99, 102, 241)); // indigo_500
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Inter", Font.BOLD, 13));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
