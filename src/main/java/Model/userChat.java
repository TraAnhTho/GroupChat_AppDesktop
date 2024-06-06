package Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userChat")
public class userChat {
	@Id // khóa chính
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column(name = "userName")
	public String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "firstName")
	protected String firstName;
	@Column(name = "lastName")
	protected String lastName;
	@Column(name = "birthday")
	protected Date birthday;
	@Column(name = "status")
	public String status;
	@Column(name = "email")
	public String email;
	@Column(name = "phoneNumber")
	public int phoneNumber;

	public void createAccount() {

	}

	public void login(String username, String password) {

	}

	public void chat() {

	}

	public void getActiveList() {

	}

	public void createGroup() {

	}

	public void viewSettings() {

	}

	public void blockUser(String username) {

	}

	public void acceptUser(String username) {

	}

	public void getNotifications() {

	}

	public void sreach(String string) {

	}

	public void logout() {

	}

}
