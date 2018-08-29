package com.edu.ssh.entity;
//用户
public class User {
	private Integer id;
	private String account;
	private String pwd;
	private String faceImg;
	private String name;
	private char sex;
	private String phoneNumber;
	private String address;
	private UserPosition position;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String account, String pwd, String faceImg, String name,
			char sex, String phoneNumber, String address, UserPosition position) {
		this.account = account;
		this.pwd = pwd;
		this.faceImg = faceImg;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
	}

	public User(Integer id, String account, String pwd, String faceImg,
			String name, char sex, String phoneNumber, String address,
			UserPosition position) {
		this.id = id;
		this.account = account;
		this.pwd = pwd;
		this.faceImg = faceImg;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserPosition getPosition() {
		return position;
	}

	public void setPosition(UserPosition position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", pwd=" + pwd
				+ ", faceImg=" + faceImg + ", name=" + name + ", sex=" + sex
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", position=" + position + "]";
	}

}
