package com.zzuli.oj.user.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.zzuli.oj.common.hibernate.dao.BaseDaoSupport;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.dao.IUserDao;

public class UserDao extends BaseDaoSupport<User> implements IUserDao {

	@Override
	public void addUser(User user) {
		super.save(user);
	}

	@Override
	public void updateUser(User user) {
		super.update(user);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

	@Override
	public User getUser(String user_id) {
		// TODO Auto-generated method stub
		return (User) this
				.findUniqueResultByCriteria(createDetachedCriteria().add(Restrictions.eq("user_id", user_id)));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return super.queryAll();
	}

	@Override
	public User getUser(String user_id, String password) {
		// TODO Auto-generated method stub
		return (User) this.findUniqueResultByCriteria(createDetachedCriteria().add(Restrictions.eq("user_id", user_id))
				.add(Restrictions.eq("password", password)));
	}

}
