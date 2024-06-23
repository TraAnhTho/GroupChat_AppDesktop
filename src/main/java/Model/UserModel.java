package Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	
	

//	public userChat(String userName, String password, String firstName, String lastName, int phoneNumber) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.birthday = birthday;
//		this.status = status;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//	}
	

	public UserModel(String userName, String password, Date birthday, String email, int phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public UserModel() {
		super();
	}
	

	public int getid() {
		return id;
	}


	public void setid(int id) {
		id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


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
