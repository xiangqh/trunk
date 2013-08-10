package com.zzuli.oj.user.dao;

import java.util.List;
import com.zzuli.oj.hibernate.entry.User;

public interface IUserDao {

	public void addUser(User user);

	public void updateUser(User user);

	public User getUserById(int id);

	public User getUser(String user_id);

	public List<User> getAllUsers();

	public User getUser(String user_id, String password);

}
