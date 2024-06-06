package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class chatRoom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chatRoom frame = new chatRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public chatRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 664, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label: .....");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 105, 180));
		lblNewLabel.setBounds(10, 11, 401, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-user-48.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 105, 180));
		lblNewLabel_1.setBounds(421, 11, 233, 54);
		panel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 76, 401, 474);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(421, 146, 233, 404);
		panel.add(textArea_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đang hoạt động");
		lblNewLabel_1_1.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-dot-24.png")));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(421, 76, 233, 54);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(55, 561, 505, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-attach-24.png")));
		lblNewLabel_2.setBounds(10, 563, 35, 41);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-send-24.png")));
		lblNewLabel_3.setBounds(576, 561, 78, 43);
		panel.add(lblNewLabel_3);
		
		
		
	}
}
