package com.zzuli.oj.hibernate.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zzuli.oj.common.hibernate.entry.PO;

@Entity
@Table(name = "privilege")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Privilege extends PO {

	@Id
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "rightstr")
	private String rightstr;
	private char defunct;

	public Privilege(String user_id, String rightstr) {
		this.user_id = user_id;
		this.rightstr = rightstr;
		this.defunct = 'N';
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRightstr() {
		return rightstr;
	}

	public void setRightstr(String rightstr) {
		this.rightstr = rightstr;
	}

	public char getDefunct() {
		return defunct;
	}

	public void setDefunct(char defunct) {
		this.defunct = defunct;
	}

}
