package com.zzuli.oj.user.dao.impl;

import org.hibernate.criterion.Restrictions;

import com.zzuli.oj.common.hibernate.dao.BaseDaoSupport;
import com.zzuli.oj.hibernate.entry.Privilege;
import com.zzuli.oj.user.dao.IPrivilegeDao;

public class PrivilegeDao extends BaseDaoSupport<Privilege> implements
		IPrivilegeDao {

	@Override
	public void addPrivilege(String user_id, String rightstr) {
		Privilege privilege = new Privilege(user_id, rightstr);
		super.save(privilege);
	}

	@Override
	public Privilege getUserRight(String user_id) {
		// TODO Auto-generated method stub
		return (Privilege) this.findByCriteria(createDetachedCriteria().add(Restrictions.eq("user_id", user_id)));
	}

}
