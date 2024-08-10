import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI window = new GUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 841, 555);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Email Application");
        frame.setIconImage(new ImageIcon("img/logo.jpg").getImage());
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel navbar = createNavbar();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(navbar, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(createEmailPanel(), "email");
        mainPanel.add(createWritePanel(), "write");
        mainPanel.add(createImportantPanel(), "important");
        mainPanel.add(createTrashPanel(), "trash");

        // Set default view
        cardLayout.show(mainPanel, "email");
    }

    private JPanel createNavbar() {
    	JPanel navbar = new JPanel();
		navbar.setBounds(10, 11, 842, 47);
		frame.getContentPane().add(navbar);
		navbar.setLayout(new BoxLayout(navbar, BoxLayout.X_AXIS));

        JButton btnEmail = new JButton("Emails");
        btnEmail.addActionListener(e -> cardLayout.show(mainPanel, "email"));
        navbar.add(btnEmail);

        navbar.add(Box.createRigidArea(new Dimension(30, 0))); // Invisible box for spacing

        JButton btnWrite = new JButton("Write");
        btnWrite.addActionListener(e -> cardLayout.show(mainPanel, "write"));
        navbar.add(btnWrite);

        navbar.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnImportant = new JButton("Important");
        btnImportant.addActionListener(e -> cardLayout.show(mainPanel, "important"));
        navbar.add(btnImportant);

        navbar.add(Box.createRigidArea(new Dimension(30, 0)));

        JButton btnTrash = new JButton("Trash");
        btnTrash.addActionListener(e -> cardLayout.show(mainPanel, "trash"));
        navbar.add(btnTrash);

        return navbar;
    }

    private JPanel createEmailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("Emails");
        lbTitle.setBounds(325, 11, 67, 24);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
        panel.add(lbTitle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createWritePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("Writing");
        lbTitle.setBounds(325, 11, 90, 24);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
        panel.add(lbTitle);

        JButton btnSend = new JButton("Send");
        btnSend.setBounds(730, 472, 89, 23);
        panel.add(btnSend);

        JButton btnDiscard = new JButton("Discard");
        btnDiscard.setBounds(599, 472, 89, 23);
        panel.add(btnDiscard);

        JTextArea textAreaContent = new JTextArea();
        textAreaContent.setBounds(10, 103, 809, 358);
        panel.add(textAreaContent);

        JLabel lbAddressing = new JLabel("To:");
        lbAddressing.setFont(new Font("Monospaced", Font.PLAIN, 14));
        lbAddressing.setBounds(10, 69, 48, 14);
        panel.add(lbAddressing);

        textField = new JTextField();
        textField.setBounds(36, 69, 328, 20);
        panel.add(textField);
        textField.setColumns(10);

        return panel;
    }

    private JPanel createImportantPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("Important");
        lbTitle.setBounds(325, 11, 112, 24);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
        panel.add(lbTitle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createTrashPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lbTitle = new JLabel("Trash");
        lbTitle.setBounds(325, 11, 67, 24);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
        panel.add(lbTitle);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }
}
