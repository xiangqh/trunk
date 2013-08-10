package com.zzuli.oj.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzuli.oj.hibernate.entry.Privilege;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.dao.IPrivilegeDao;
import com.zzuli.oj.user.dao.IUserDao;

@Transactional
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	public User getUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(user_id, password);
	}

	@Override
	public User getUserById(String user_id) {
		// TODO Auto-generated method stub
		return userDao.getUser(user_id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public Privilege getUserPrivilege(String user_id) {
		// TODO Auto-generated method stub
		return privilegeDao.getUserRight(user_id);
	}

	@Override
	public List<User> getUserRankList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setPrivilegeDao(IPrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}


}
