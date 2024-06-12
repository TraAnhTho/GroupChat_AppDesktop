package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class InterfaceMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtmTableRoom;
	private JTable tableRoom;
	private Container panel;

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
	public InterfaceMain() {
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

		JLabel lbl_idRoom = new JLabel("Tin nhắn");
		lbl_idRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_idRoom.setForeground(new Color(255, 105, 180));
		lbl_idRoom.setBounds(35, 95, 357, 40);
		panel.add(lbl_idRoom);

		JLabel lbl_idUsser = new JLabel("User123456789");
		lbl_idUsser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_idUsser.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-user-48.png")));
		lbl_idUsser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idUsser.setForeground(new Color(255, 105, 180));
		lbl_idUsser.setBounds(401, 11, 253, 54);
		panel.add(lbl_idUsser);

		JTextArea listActiveTextArea = new JTextArea();
		listActiveTextArea.setBounds(439, 146, 215, 404);
		panel.add(listActiveTextArea);

		JLabel lblNewLabel = new JLabel("Đang hoạt động");
		lblNewLabel.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-dot-24.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(461, 76, 193, 59);
		panel.add(lblNewLabel);

		String[] header = { "List Room Name" };

		dtmTableRoom = new DefaultTableModel(header, 0) {

		};
		panel.add(new JScrollPane(tableRoom = new JTable(dtmTableRoom)));
		tableRoom.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(118, 203, 33)));
		tableRoom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tableRoom.setBackground(new Color(255, 255, 255));
		tableRoom.setForeground(new Color(118, 203, 33));
		tableRoom.setRowHeight(30);
		tableRoom.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane scrollPane = new JScrollPane(tableRoom);
		scrollPane.setBounds(35, 146, 357, 411);
		panel.add(scrollPane);
		try {
			LoadDBDataJTableRoom();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton joinRoomBtn = new JButton("Join");
		joinRoomBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		joinRoomBtn.setBounds(268, 569, 124, 40);
		panel.add(joinRoomBtn);

	}

	public void LoadDBDataJTableRoom() throws Exception {

//        String sql="select STT,`MaSP`, TenSP, GiaSP from sanpham"
//        		+ " WHERE TenSP LIKE '%"+timkiem.getText()+"%'OR MaSP LIKE'%"+timkiem.getText()+"%'";
//        ResultSet rs=conn.createStatement().executeQuery(sql);

		Object[] row = { null };
		dtmTableRoom.addRow(row);
	}
}
