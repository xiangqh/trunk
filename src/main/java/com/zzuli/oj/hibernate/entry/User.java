package com.zzuli.oj.hibernate.entry;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zzuli.oj.common.hibernate.entry.PO;

/**
 * @author xiangqh
 *
 */
@Entity
@Table(name = "users")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class User extends PO {

	@Id
	@Column(name = "user_id")
	private String user_id;
	@Column(name = "password")
	private String password;
	@Column(name = "nick")
	private String nick;
	@Column(name = "email")
	private String email;
	@Column(name = "school")
	private String school;
	@Column(name = "submit")
	private int submit;
	@Column(name = "solved")
	private int solved;
	@Column(name = "defunct")
	private char defunct;
	@Column(name = "ip")
	private String ip;
	@Column(name = "accesstime")
	private Date accesstime;
	@Column(name = "volume")
	private int volume;
	@Column(name = "language")
	private int language;
	@Column(name = "reg_time")
	private Date reg_time;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	public char getDefunct() {
		return defunct;
	}

	public void setDefunct(char defunct) {
		this.defunct = defunct;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getAccesstime() {
		return accesstime;
	}

	public void setAccesstime(Date accesstime) {
		this.accesstime = accesstime;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public Date getReg_time() {
		return reg_time;
	}

	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}

}