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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Trash {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trash window = new Trash();
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
	public Trash() {
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
		
		JLabel lbTitle = new JLabel("Trash");
		lbTitle.setBounds(325, 11, 67, 24);
		layeredPaneTitle.add(lbTitle);
		lbTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Rockwell", Font.BOLD | Font.ITALIC, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 798, 403);
		frame.getContentPane().add(scrollPane);
		
	}

}
