package com.zzuli.oj.problem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.hibernate.entry.Problem;
import com.zzuli.oj.problem.dao.IProblemDao;

/**
 * @author xiangqh
 * 
 */
@Transactional
public class ProblemService implements IProblemService {

	@Autowired
	private IProblemDao problemDao;
	@Autowired
	private ISearchService searchService;

	@Override
	public List<Problem> problemList(Page page) {
		// TODO Auto-generated method stub
		List<Problem> problems = problemDao.getProblemList(page);
		return problems;
	}

	@Override
	public void addProblem(Problem problem) {
		// TODO Auto-generated method stub
		problemDao.addProblem(problem);
		searchService.addDoc(problem);
	}

	@Override
	public void updateProblem(Problem problem) {
		// TODO Auto-generated method stub
		problemDao.updateProblem(problem);
		searchService.deleteDoc(problem);
		searchService.addDoc(problem);
	}

	@Override
	public Problem getProblemById(int problem_id) {
		// TODO Auto-generated method stub
		return problemDao.getProblem(problem_id);
	}

	@Required
	public void setProblemDao(IProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	@Override
	public List<Problem> getAllProblem() {
		// TODO Auto-generated method stub
		return this.problemDao.getAll();
	}

	@Override
	public int getNextProblemId() {
		// TODO Auto-generated method stub
		return problemDao.getNextProblemId();
	}

	@Override
	public void saveProblem(Problem problem) {
		// TODO Auto-generated method stub

		problemDao.saveProblem(problem);
	}

	@Override
	public void delProblem(int problem_id) {
		// TODO Auto-generated method stub
		problemDao.deleteProblem(problem_id);
		searchService.deleteDocById(problem_id);
	}

}
