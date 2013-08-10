package com.zzuli.oj.user.dao;

import com.zzuli.oj.hibernate.entry.Privilege;

public interface IPrivilegeDao {

	public void addPrivilege(String user_id, String rightstr);

	public Privilege getUserRight(String user_id);

}
