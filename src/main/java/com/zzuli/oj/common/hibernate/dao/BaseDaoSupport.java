package com.zzuli.oj.common.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @author xiangqh
 *
 */
public class BaseDaoSupport<T> extends BaseDao implements PODao<T> {

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(int id) {
		return (T) this.getHibernateTemplate().get(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		return findByCriteria(createDetachedCriteria());
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return findByCriteria(createDetachedCriteria());
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<T> getList(DetachedCriteria criteria) {
		return findByCriteria(criteria);
	}

	public DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(getEntityClass());
	}

	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
