package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

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

import DAO.GroupDAO;
import Model.groupChat;
import design.FButton;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.URL;
import java.awt.event.ActionEvent;

public class InterfaceMain extends JFrame {
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel dtmTableRoom;
	private JTable tableRoom;
	private Container panel;
	private JTextArea listActiveTextArea;
	static String idUser;

	/** Chat List **/
	public Vector socketList = new Vector();
	public Vector clientList = new Vector();
	/** File Sharing List **/
	public Vector clientFileSharingUsername = new Vector();
	public Vector clientFileSharingSocket = new Vector();
	/** Server **/
	ServerSocket server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMain frame = new InterfaceMain(idUser);
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
	public InterfaceMain(String idUser) {
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

		JLabel lbl_idRoom = new JLabel("Tin nhắn");
		lbl_idRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idRoom.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_idRoom.setForeground(new Color(255, 105, 180));
		lbl_idRoom.setBounds(35, 95, 357, 40);
		panel.add(lbl_idRoom);

		JLabel lbl_idUsser = new JLabel(" " + idUser);
		lbl_idUsser.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_idUsser.setIcon(new ImageIcon(chatRoom.class.getResource("/img/icons8-user-48.png")));
		lbl_idUsser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_idUsser.setForeground(new Color(255, 105, 180));
		lbl_idUsser.setBounds(401, 11, 253, 54);
		panel.add(lbl_idUsser);

		listActiveTextArea = new JTextArea();
		listActiveTextArea.setBounds(439, 146, 215, 411);
		panel.add(listActiveTextArea);

		JLabel lblNewLabel = new JLabel("Đang hoạt động");
		lblNewLabel.setIcon(new ImageIcon(InterfaceMain.class.getResource("/img/online.png")));
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

		FButton joinRoomBtn = new FButton();
		joinRoomBtn.setText("Join");
		joinRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        connectToServer();
				
			}
		});
		joinRoomBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		joinRoomBtn.setBounds(268, 569, 124, 40);
		panel.add(joinRoomBtn);

	}

	public void LoadDBDataJTableRoom() throws Exception {
		ArrayList<groupChat> groups = GroupDAO.getInstance().loadData();

		for (groupChat group : groups) {
			Object[] row = { group.getGroupName() };
			dtmTableRoom.addRow(row);
		}

	}

	public void appendMessage(String msg) {
		Date date = new Date();
		listActiveTextArea.append(sdf.format(date) + ": " + msg + "\n");
		listActiveTextArea.setCaretPosition(listActiveTextArea.getText().length() - 1);
	}

	public void setClientList(String client) {
		try {
			clientList.add(client);
			appendMessage("[setClientList]: Được thêm");
		} catch (Exception e) {
			appendMessage("[setClientList]: " + e.getMessage());
		}
	}

	/*
	 * Hiển thị danh sách đang online
	 */
	public void showOnLineList(Vector list) {
		try {
			listActiveTextArea.setEditable(true);
//        listActiveTextArea.setContentType("text/html");
			StringBuilder sb = new StringBuilder();
			Iterator it = list.iterator();
			sb.append("<html><table>");
			while (it.hasNext()) {
				Object e = it.next();
				URL url = getImageFile();
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/online.png"));
				sb.append("<tr><td><b>></b></td><td>").append(e).append("</td></tr>");
				System.out.println("Online: " + e);
			}
			sb.append("</table></body></html>");
			listActiveTextArea.removeAll();
			listActiveTextArea.setText(sb.toString());
			listActiveTextArea.setEditable(false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 ************************************ Hiển thị danh sách online *********************************************
	 */
	private void sampleOnlineList(Vector list) {
		listActiveTextArea.setEditable(true);
		listActiveTextArea.removeAll();
		listActiveTextArea.setText("");
		Iterator i = list.iterator();
		while (i.hasNext()) {
			Object e = i.next();
			/* Hiển thị Username Online */
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel.setBackground(Color.white);

			ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/online.png"));
			JLabel label = new JLabel(icon);
			label.setText(" " + e);
			panel.add(label);
			int len = listActiveTextArea.getDocument().getLength();
			listActiveTextArea.setCaretPosition(len);
			listActiveTextArea.add(panel);
			/* Append Next Line */
			sampleAppend();
		}
		listActiveTextArea.setEditable(false);
	}

	private void sampleAppend() {
		int len = listActiveTextArea.getDocument().getLength();
		listActiveTextArea.setCaretPosition(len);
		listActiveTextArea.replaceSelection("\n");
	}

	public URL getImageFile() {
		URL url = this.getClass().getResource("/images/online.png");
		return url;
	}
	//kết nói đến sẻver
	private void connectToServer(){
		DefaultTableModel model_table = (DefaultTableModel) tableRoom.getModel();
		int i_row = tableRoom.getSelectedRow();
		String roomList = model_table.getValueAt(i_row, 0) + "";
		System.out.println(roomList);
		
//                /*  Hiện thị MainForm  */
                	new chatRoom(idUser, roomList);
					dispose();
//                main.initFrame(u, txtHost.getText(), Integer.parseInt(txtPort.getText()));
                //  kiểm tra nếu như được kết nối
//                if(InterfaceMain.isConnected()){
//                	InterfaceMain.setLocationRelativeTo(null);
//                	InterfaceMain.setVisible(true);
//                    setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(this, "Tài khoản phải tối đa 15 ký tự bao gồm [khoảng trắng].!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//            }
//        } 
	}
    
        
}
