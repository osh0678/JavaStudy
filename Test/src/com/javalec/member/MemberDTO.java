package com.javalec.member;

import java.sql.Timestamp;

public class MemberDTO {

	private String name;
	private String id;
	private String pw;
	private String eMail;
	private Timestamp rDate;
	private String address;
	
	public String getName() {
		System.out.println("get : " + name);
		return name;
	}
	public void setName(String name) {
		System.out.println("set : " + name);
		this.name = name;
	}
	public String getId() {
		System.out.println("get : " + id);
		return id;
	}
	public void setId(String id) {
		System.out.println("set : " + id);
		this.id = id;
	}
	public String getPw() {
		System.out.println("get : " + pw);
		return pw;
	}
	public void setPw(String pw) {
		System.out.println("set : " + pw);
		this.pw = pw;
	}
	public String geteMail() {
		System.out.println("get : " + eMail);
		return eMail;
	}
	public void seteMail(String eMail) {
		System.out.println("set : " + eMail);
		this.eMail = eMail;
	}
	public Timestamp getrDate() {
		System.out.println("get : " + rDate);
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		System.out.println("set : " + rDate);
		this.rDate = rDate;
	}
	public String getAddress() {
		System.out.println("get : " + address);
		return address;
	}
	public void setAddress(String address) {
		System.out.println("set : " + address);
		this.address = address;
	}
}
