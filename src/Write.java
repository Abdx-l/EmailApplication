import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Write extends EmailGUI{

	private JFrame frame;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Write window = new Write();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Write() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Navbar = new JPanel();
		Navbar.setBounds(10, 11, 842, 47);
		frame.getContentPane().add(Navbar);
		Navbar.setLayout(new BoxLayout(Navbar, BoxLayout.X_AXIS));
		
		JButton btnEmail = new JButton("Emails");
		Navbar.add(btnEmail);
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		Navbar.add(Box.createRigidArea(new Dimension(30, 0))); // Invisible box for spacing 
		
		JButton btnWrite = new JButton("Write");
		Navbar.add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
			
		});
		
		Navbar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		JButton btnImportant = new JButton("Important");
		Navbar.add(btnImportant);
		btnImportant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Navbar.add(Box.createRigidArea(new Dimension(30, 0)));
		
		JButton btnTrash = new JButton("Trash");
		Navbar.add(btnTrash);
		btnTrash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLayeredPane layeredPaneTitle = new JLayeredPane();
		Navbar.add(layeredPaneTitle);
		layeredPaneTitle.setLayout(null);
		
		JLabel lbTitle = new JLabel("Writing");
		lbTitle.setBounds(325, 11, 90, 24);
		layeredPaneTitle.add(lbTitle);
		lbTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(730, 472, 89, 23);
		frame.getContentPane().add(btnSend);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.setBounds(599, 472, 89, 23);
		frame.getContentPane().add(btnDiscard);
		
		JTextArea textAreaContent = new JTextArea();
		textAreaContent.setBounds(10, 103, 809, 358);
		frame.getContentPane().add(textAreaContent);
		
		JLabel lbAddressing = new JLabel("To:");
		lbAddressing.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lbAddressing.setBounds(10, 69, 48, 14);
		frame.getContentPane().add(lbAddressing);
		
		textField = new JTextField();
		textField.setBounds(36, 69, 328, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
