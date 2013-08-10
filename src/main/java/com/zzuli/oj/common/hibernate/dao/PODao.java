/**
 *
 */
package com.zzuli.oj.common.hibernate.dao;

import java.util.List;

/**
 * @author xiangqh
 *
 */
public interface PODao<T> {

	void save(T t);

	void update(T t);

	void saveOrUpdate(T t);

	void delete(T t);

	T getById(int id);

	List<T> queryAll();
}
