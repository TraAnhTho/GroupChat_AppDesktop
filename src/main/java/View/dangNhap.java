package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class dangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel panelDangNhap;
	JPanel panelDangKi;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangNhap frame = new dangNhap();
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
	public dangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelHome = new JPanel();
		panelHome.setBackground(new Color(255, 255, 255));
		panelHome.setBounds(0, 0, 664, 641);
		contentPane.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel lblDangNhap = new JLabel("Đăng Nhập");
		lblDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelDangNhap.setVisible(true);
				panelDangKi.setVisible(false);

			}
		});
		lblDangNhap.setForeground(new Color(255, 182, 193));
		lblDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDangNhap.setBounds(0, 0, 333, 63);
		panelHome.add(lblDangNhap);
		
		panelDangKi = new JPanel();
		panelDangKi.setBackground(new Color(255, 182, 193));
		panelDangKi.setBounds(0, 64, 664, 577);
		panelHome.add(panelDangKi);
		panelDangKi.setLayout(null);
		panelDangKi.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		panel_2.setBounds(334, 0, 330, 64);
		panelHome.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDangKi = new JLabel("Đăng Kí");
		lblDangKi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelDangKi.setVisible(true);
				panelDangNhap.setVisible(false);
			}
		});
		lblDangKi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangKi.setForeground(new Color(255, 255, 255));
		lblDangKi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDangKi.setBounds(0, 0, 330, 63);
		panel_2.add(lblDangKi);
		
		panelDangNhap = new JPanel();
		panelDangNhap.setLayout(null);
		panelDangNhap.setBackground(new Color(255, 255, 255));
		panelDangNhap.setBounds(0, 64, 664, 577);
		panelHome.add(panelDangNhap);
		
		JLabel lblNewLabel = new JLabel("New label:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 182, 193));
		lblNewLabel.setBounds(84, 110, 145, 47);
		panelDangNhap.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(255, 182, 193));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(84, 165, 145, 47);
		panelDangNhap.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(255, 182, 193));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(84, 223, 145, 47);
		panelDangNhap.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(new Color(255, 182, 193));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(84, 281, 145, 47);
		panelDangNhap.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(276, 112, 338, 47);
		panelDangNhap.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(276, 167, 338, 47);
		panelDangNhap.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(276, 225, 338, 47);
		panelDangNhap.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(276, 283, 338, 47);
		panelDangNhap.add(textField_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(469, 359, 145, 47);
		panelDangNhap.add(btnNewButton);
		
		
		
	}
}
