package com.zzuli.oj.problem.service;

import java.util.List;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.hibernate.entry.Problem;

/**
 * @author xiangqh
 * 
 */
public interface IProblemService {

	public void addProblem(Problem problem);

	public void updateProblem(Problem problem);

	public void saveProblem(Problem problem);

	public void delProblem(int problem_id);

	public List<Problem> problemList(Page page);

	public Problem getProblemById(int problem_id);

	public List<Problem> getAllProblem();

	public int getNextProblemId();
}
