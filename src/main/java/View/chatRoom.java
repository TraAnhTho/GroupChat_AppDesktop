package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.SocketClient;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

public class chatRoom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mesageTextField;
	static String idUser;
	static String room  = "trivo";
    SocketClient client = new SocketClient();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chatRoom frame = new chatRoom(idUser,room);
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
	public chatRoom(String idUser, String room) {
		this.setVisible(true);
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
		
		JLabel lbl_idRoom = new JLabel("Room: "+room);
		lbl_idRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_idRoom.setForeground(new Color(255, 105, 180));
		lbl_idRoom.setBounds(10, 11, 401, 54);
		panel.add(lbl_idRoom);
		
		JLabel lbl_idUsser = new JLabel(" "+idUser);
		lbl_idUsser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_idUsser.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-user-48.png")));
		lbl_idUsser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idUsser.setForeground(new Color(255, 105, 180));
		lbl_idUsser.setBounds(401, 11, 253, 54);
		panel.add(lbl_idUsser);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setBounds(10, 76, 441, 474);
		panel.add(chatTextArea);
		
		JTextArea listActiveTextArea = new JTextArea();
		listActiveTextArea.setBounds(461, 146, 193, 404);
		panel.add(listActiveTextArea);
		
		JLabel lblNewLabel = new JLabel("Đang hoạt động");
		lblNewLabel.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-dot-24.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(461, 76, 193, 59);
		panel.add(lblNewLabel);
		
		mesageTextField = new JTextField();
		mesageTextField.setBounds(55, 561, 505, 43);
		panel.add(mesageTextField);
		mesageTextField.setColumns(10);
		
		JLabel fileBtn = new JLabel("");
		fileBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fileBtn.setHorizontalAlignment(SwingConstants.CENTER);
		fileBtn.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-attach-24.png")));
		fileBtn.setBounds(10, 563, 35, 41);
		panel.add(fileBtn);
		
		JLabel sendMessageBtn = new JLabel("");
		sendMessageBtn.setHorizontalAlignment(SwingConstants.LEFT);
		sendMessageBtn.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-send-24.png")));
		sendMessageBtn.setBounds(576, 561, 78, 43);
		panel.add(sendMessageBtn);
		
		
		
	}
	
	
}
