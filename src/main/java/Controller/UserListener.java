package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.mapping.List;

import DAO.UserDAO;

import View.chatLogin;

public class UserListener implements ActionListener {
	private UserDAO userdao;
	private chatLogin chatlogin;

	public UserListener(chatLogin chatlogin) {
		this.chatlogin = chatlogin;
	}
//		login.addButtonClickListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == login.getBtn_dangnhap()) {
//					User_DAO userdao = new User_DAO();
//					String usercol = login.getTextField_user().getText();
//					String pass = login.getTextField_pass().getText();
//					List<u_Dao> userList = u_Dao.getAllUser();
//					
//				}
//			}
//			
//		});
//		
//	}

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println("Bạn đã nhấn nút: " + src);

		if (src.equals(chatlogin.registerBtn.getText())) {
			System.out.println("Dang ki click");
			this.chatlogin.InsertsUser();
		} else if (src.equals(chatlogin.loginBtn.getText())) {
			System.out.println("Dang nhap click");
			this.chatlogin.Login();
		}
	}

}
