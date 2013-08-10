package com.test.hiberante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zzuli.oj.common.hibernate.entry.PO;

/**
 * @author xiangqh
 *
 */
@Entity
@Table(name = "users_test")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class UserTest extends PO{

	@Id
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "password")
	private String password;
	@Column(name = "nick")
	private String nick;

	private Address address;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
