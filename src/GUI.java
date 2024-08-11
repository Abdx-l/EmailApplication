import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel lbTitle;

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
        frame.setBounds(100, 100, 841, 580);
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

        
        cardLayout.show(mainPanel, "email"); // Set default view
        lbTitle.setText("Emails");  
    }

    private JPanel createNavbar() {
        JPanel navbar = new JPanel();
        navbar.setBounds(10, 11, 842, 47);
        navbar.setLayout(new BoxLayout(navbar, BoxLayout.X_AXIS));
        
        navbar.add(Box.createRigidArea(new Dimension(10, 0))); 
        
        JButton btnEmail = new JButton("Emails");
        btnEmail.addActionListener(e -> {
            cardLayout.show(mainPanel, "email");
            lbTitle.setText("Emails");  // Update title
        });
        navbar.add(btnEmail);

        navbar.add(Box.createRigidArea(new Dimension(30, 0))); // Spacing

        JButton btnWrite = new JButton("Write");
        btnWrite.addActionListener(e -> {
            cardLayout.show(mainPanel, "write");
            lbTitle.setText("Writing"); 
        });
        navbar.add(btnWrite);

        navbar.add(Box.createRigidArea(new Dimension(30, 0))); 

        JButton btnImportant = new JButton("Important");
        btnImportant.addActionListener(e -> {
            cardLayout.show(mainPanel, "important");
            lbTitle.setText("Important");  
        });
        navbar.add(btnImportant);

        navbar.add(Box.createRigidArea(new Dimension(30, 0))); 

        JButton btnTrash = new JButton("Trash");
        btnTrash.addActionListener(e -> {
            cardLayout.show(mainPanel, "trash");
            lbTitle.setText("Trash"); 
        });
        navbar.add(btnTrash);

        // Glue to push the title to the right
        navbar.add(Box.createHorizontalGlue());// Pushes the title to the right
       
        
        lbTitle = new JLabel("Emails");
        lbTitle.setHorizontalAlignment(SwingConstants.RIGHT);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
        navbar.add(lbTitle);
        navbar.add(Box.createRigidArea(new Dimension(30, 0))); 
        
        return navbar;
    }


    private JPanel createEmailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createWritePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

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

        JTextField textField = new JTextField();
        textField.setBounds(36, 69, 328, 20);
        panel.add(textField);
        textField.setColumns(10);

        return panel;
    }

    private JPanel createImportantPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createTrashPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 80, 798, 403);
        panel.add(scrollPane);

        return panel;
    }
}