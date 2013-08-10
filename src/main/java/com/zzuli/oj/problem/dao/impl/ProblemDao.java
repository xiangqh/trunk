package com.zzuli.oj.problem.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.common.hibernate.dao.BaseDaoSupport;
import com.zzuli.oj.hibernate.entry.Problem;
import com.zzuli.oj.problem.dao.IProblemDao;

/**
 * @author xiangqh
 * 
 */
public class ProblemDao extends BaseDaoSupport<Problem> implements IProblemDao {

	@Override
	public void addProblem(Problem problem) {
		super.save(problem);
	}

	@Override
	public void updateProblem(Problem problem) {
		super.update(problem);
	}

	@Override
	public void deleteProblem(int problem_id) {
		Problem problem = new Problem();
		problem.setProblem_id(problem_id);
		super.delete(problem);
	}

	@Override
	public Problem getProblem(int problem_id) {
		// TODO Auto-generated method stub
		return (Problem) super.findUniqueResultByCriteria(createDetachedCriteria().add(
				Restrictions.eq("problem_id", problem_id)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Problem> getProblemList(Page page) {
		// TODO Auto-generated method stub
		return super.findByCriteria(createDetachedCriteria().addOrder(Order.asc("problem_id")), page);
	}

	@Override
	public List<Problem> getAll() {
		// TODO Auto-generated method stub
		return super.queryAll();
	}

	@Override
	public int getNextProblemId() {
		// TODO Auto-generated method stub
		return (Integer) super.findByCriteria(createDetachedCriteria().setProjection(Projections.max("problem_id")))
				.get(0) + 1;
	}

	@Override
	public void saveProblem(Problem problem) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(problem);
	}

}