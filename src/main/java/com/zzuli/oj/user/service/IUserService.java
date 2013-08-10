package com.zzuli.oj.user.service;

import java.util.List;

import com.zzuli.oj.hibernate.entry.Privilege;
import com.zzuli.oj.hibernate.entry.User;

public interface IUserService {

	public User getUser(String user_id, String password);

	public User getUserById(String user_id);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUserRankList();

	public Privilege getUserPrivilege(String user_id);

}
