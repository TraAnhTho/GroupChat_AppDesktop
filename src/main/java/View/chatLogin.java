package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.UserListener;
import DAO.UserDAO;
import Model.UserModel;
import design.FButton;
import design.FPasswordField;
import design.FTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class chatLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private UserDAO userDAO;

	JPanel panelDangNhap;
	JPanel panelDangKi;
	private FTextField uNameTextField;
	private FTextField emailTextField;
	private FTextField phoneTextField;
	private FPasswordField passwordTextField;
	private FTextField ipTextField;
	private FTextField userNameTextField;
	private FPasswordField passTextField;
	private FTextField portTextField;
	private FTextField textField_4;
	public FButton registerBtn;
	public FButton loginBtn;
	private JButton showPassBtnLo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chatLogin frame = new chatLogin();
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
	public chatLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// gọi
		// thís là cái view mình đang làm việc
		ActionListener ac = new UserListener(this);

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

		JLabel lbl_idDN = new JLabel("IP :");
		lbl_idDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_idDN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_idDN.setForeground(new Color(255, 182, 193));
		lbl_idDN.setBounds(84, 110, 145, 47);
		panelDangNhap.add(lbl_idDN);

		JLabel lbl_usernameDN = new JLabel("User Name:");
		lbl_usernameDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_usernameDN.setForeground(new Color(255, 182, 193));
		lbl_usernameDN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_usernameDN.setBounds(84, 165, 145, 47);
		panelDangNhap.add(lbl_usernameDN);

		JLabel lbl_passDN = new JLabel("Password:");
		lbl_passDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_passDN.setForeground(new Color(255, 182, 193));
		lbl_passDN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_passDN.setBounds(84, 223, 145, 47);
		panelDangNhap.add(lbl_passDN);

		JLabel lbl_portDN = new JLabel("Port:");
		lbl_portDN.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_portDN.setForeground(new Color(255, 182, 193));
		lbl_portDN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_portDN.setBounds(84, 281, 145, 47);
		panelDangNhap.add(lbl_portDN);

		ipTextField = new FTextField();
		ipTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ipTextField.setForeground(new Color(255, 182, 193));
		ipTextField.setBounds(276, 112, 338, 47);
		panelDangNhap.add(ipTextField);
		ipTextField.setColumns(10);

		userNameTextField = new FTextField();
		userNameTextField.setForeground(new Color(255, 182, 193));
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userNameTextField.setColumns(10);
		userNameTextField.setBounds(276, 167, 338, 47);
		panelDangNhap.add(userNameTextField);

		passTextField = new FPasswordField();
		passTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passTextField.setForeground(new Color(255, 182, 193));
		passTextField.setColumns(10);
		passTextField.setBounds(276, 225, 338, 47);
		panelDangNhap.add(passTextField);

		portTextField = new FTextField();
		portTextField.setForeground(new Color(255, 182, 193));
		portTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		portTextField.setColumns(10);
		portTextField.setBounds(276, 283, 338, 47);
		panelDangNhap.add(portTextField);

		loginBtn = new FButton();
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginBtn.setText("Đăng Nhập");
		loginBtn.addActionListener(ac);
		loginBtn.setBounds(469, 359, 145, 47);
		panelDangNhap.add(loginBtn);
		
		showPassBtnLo = new JButton("showPassBtnLo");
		showPassBtnLo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShowPasswordLogin(e);
			}
		});
		showPassBtnLo.setBounds(286, 341, 89, 23);
		panelDangNhap.add(showPassBtnLo);

		panelDangKi = new JPanel();
		panelDangKi.setBackground(new Color(255, 182, 193));
		panelDangKi.setBounds(0, 64, 664, 577);
		panelHome.add(panelDangKi);
		panelDangKi.setLayout(null);
		panelDangKi.setVisible(false);

		JLabel lbl_usernameaDK = new JLabel("User Name :");
		lbl_usernameaDK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_usernameaDK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_usernameaDK.setForeground(new Color(255, 255, 255));
		lbl_usernameaDK.setBounds(84, 110, 145, 47);
		panelDangKi.add(lbl_usernameaDK);

		JLabel lbl_emailDK = new JLabel("Email:");
		lbl_emailDK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_emailDK.setForeground(new Color(255, 255, 255));
		lbl_emailDK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_emailDK.setBounds(84, 165, 145, 47);
		panelDangKi.add(lbl_emailDK);

		JLabel lbl_phoneDK = new JLabel("Số điện thoại:");
		lbl_phoneDK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_phoneDK.setForeground(new Color(255, 255, 255));
		lbl_phoneDK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_phoneDK.setBounds(84, 223, 145, 47);
		panelDangKi.add(lbl_phoneDK);

		JLabel lbl_passDK = new JLabel("Password:");
		lbl_passDK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_passDK.setForeground(new Color(255, 255, 255));
		lbl_passDK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_passDK.setBounds(84, 281, 145, 47);
		panelDangKi.add(lbl_passDK);

		uNameTextField = new FTextField();
		uNameTextField.setLineColor(new Color(255, 255, 255));
		uNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		uNameTextField.setForeground(new Color(255, 182, 193));
		uNameTextField.setBounds(276, 112, 338, 47);
		panelDangKi.add(uNameTextField);
		uNameTextField.setColumns(10);

		emailTextField = new FTextField();
		emailTextField.setLineColor(new Color(255, 255, 255));
		emailTextField.setForeground(new Color(255, 182, 193));
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailTextField.setColumns(10);
		emailTextField.setBounds(276, 167, 338, 47);
		panelDangKi.add(emailTextField);

		phoneTextField = new FTextField();
		phoneTextField.setLineColor(new Color(255, 255, 255));
		phoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneTextField.setForeground(new Color(255, 182, 193));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(276, 225, 338, 47);
		panelDangKi.add(phoneTextField);

		passwordTextField = new FPasswordField();
		passwordTextField.setLineColor(new Color(255, 255, 255));
		passwordTextField.setForeground(new Color(255, 182, 193));
		passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(276, 283, 338, 47);
		panelDangKi.add(passwordTextField);

		registerBtn = new FButton();
		registerBtn.setBackground(new Color(255, 255, 255));
		registerBtn.setForeground(new Color(255, 182, 193));
		registerBtn.setFillOriginal(new Color(255, 255, 255));
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		registerBtn.setText("Đăng Kí");

		registerBtn.addActionListener(ac);
		registerBtn.setBounds(469, 359, 145, 47);
		panelDangKi.add(registerBtn);
		
		JButton showPassBtnRe = new JButton("showPassBtnRe");
		showPassBtnRe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setShowPasswordRegister(e);
			}
		});
		showPassBtnRe.setBounds(286, 340, 89, 23);
		panelDangKi.add(showPassBtnRe);

	}

	public void InsertsUser() {
		if (uNameTextField.getText().trim().isEmpty() || passwordTextField.getText().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			String text = phoneTextField.getText();
			int number = Integer.parseInt(text);
			UserModel usernote = new UserModel(uNameTextField.getText(), passwordTextField.getText(), null,
					emailTextField.getText(), number);
			this.userDAO.getInstance().create(usernote);
			dispose();
		}
	}

	public void Login() {

		System.out.println("Đăng Nhập click");
		if (userNameTextField.getText().trim().isEmpty() || passTextField.getText().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!!");
		} else {
			this.userDAO.getInstance().DangNhap(userNameTextField.getText(), passTextField.getText());
			dispose();
		}

	}

	private void setShowPasswordLogin(ActionEvent event) {
		if (passTextField.getEchoChar() == (char) 0) { // Password is hidden
			passTextField.setEchoChar('\u25cf'); // Hide password
		} else { // Password is visible
			passTextField.setEchoChar((char) 0); // Show password
		}
	}
	private void setShowPasswordRegister(ActionEvent event) {
		if (passwordTextField.getEchoChar() == (char) 0) { // Password is hidden
			passwordTextField.setEchoChar('\u25cf'); // Hide password
		} else { // Password is visible
			passwordTextField.setEchoChar((char) 0); // Show password
		}
	}
}
