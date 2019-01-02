package com.javalec.ex;

public class MemberDTO {

	private String name;
	private String id;
	private String pw;
	private String div;
	private String pos;
	
	public MemberDTO(String name, String id, String pw, String div, String pos) {
		this.name	= name;
		this.id		= id;
		this.pw		= pw;
		this.div	= div;
		this.pos	= pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
	
}
