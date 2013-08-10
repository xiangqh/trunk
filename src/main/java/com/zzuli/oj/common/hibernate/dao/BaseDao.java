
package com.zzuli.oj.common.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zzuli.oj.common.Page;


/**
 * @author xiangqh
 *
 */
public abstract class BaseDao extends HibernateDaoSupport{
	private final static Logger logger = LoggerFactory.getLogger(BaseDao.class);

	@SuppressWarnings("unchecked")
	public Object findUniqueResultByCriteria(DetachedCriteria criteria) {
        Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
        return executableCriteria.uniqueResult();
	}

	@SuppressWarnings("rawtypes")
	public List findByCriteria(DetachedCriteria criteria) {
		Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
		return executableCriteria.list();
	}

	@SuppressWarnings("rawtypes")
	public List findByCriteria(DetachedCriteria criteria, Page page) {

		Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
		executableCriteria.setProjection(Projections.rowCount());

		int totalRows =((Long) executableCriteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		page.setTotalCount(totalRows);

		executableCriteria.setProjection(null);
		logger.debug(page.getStart() +":" + page.getPageSize());
		List list = executableCriteria.setFirstResult(page.getStart()).setMaxResults(page.getPageSize()).list();
		return list;
	}
}
