package com.zzuli.oj.problem.dao;

import java.util.List;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.hibernate.entry.Problem;

/**
 * @author xiangqh
 * 
 */
public interface IProblemDao {

	public void addProblem(Problem problem);

	public void updateProblem(Problem problem);

	public void saveProblem(Problem problem);

	public void deleteProblem(int problem_id);

	public Problem getProblem(int problem_id);

	public List<Problem> getProblemList(Page page);

	public List<Problem> getAll();

	public int getNextProblemId();

}
