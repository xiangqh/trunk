package com.zzuli.oj.page.problem.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.BaseResult;
import com.zzuli.oj.common.Page;
import com.zzuli.oj.common.util.SearchField;
import com.zzuli.oj.common.util.SearchProblem;
import com.zzuli.oj.hibernate.entry.Problem;
import com.zzuli.oj.problem.service.IProblemService;
import com.zzuli.oj.problem.service.ISearchService;

/**
 * @author xiangqh
 *
 */
@Controller
@ActionController
public class ProblemAction extends Action{

	@Autowired
	private IProblemService problemService;
	@Autowired
	private ISearchService searchService;

	@RequestMapping("problemlist")
	public Result problemList(){
		int volume = getParameterInt("volume");
		String keyWord = getHttpParameter("keyWord");
		if(keyWord == null) {
			keyWord = "";
		}else {
			keyWord = keyWord.trim();
		}
		if(volume == 0) volume = 1;
		Page page = new Page();
		page.setPageNo(volume);
		page.setPageSize(100);
	//	List<Problem> problems = problemService.problemList(page);
		SearchField searchField = new SearchField();
		searchField.setSort("id asc");
		searchField.setKeyWord(keyWord);
		List<SearchProblem> problems = (List<SearchProblem>) searchService.search(searchField, page).get("problemList");
		setHttpAttribute("problems", problems);
		setHttpAttribute("page", page);
		setHttpAttribute("volume", volume);
		return new BaseResult("/system/default/page/problems.vm");
	}

	@RequestMapping("refesh")
	public Result refreshIndex(){
		List<Problem> problems = problemService.getAllProblem();
		searchService.refreshIndex(problems);
		return new BaseResult("/system/default/page/problems.vm");
	}


	@RequestMapping("problem")
	public Result problemInfo(){
		int problem_id = getParameterInt("id");
		Problem problem = problemService.getProblemById(problem_id);
		setHttpAttribute("problem", problem);
		return new BaseResult("/system/default/page/problemInfo.vm");
	}

	@Required
	public void setProblemService(IProblemService problemService) {
		this.problemService = problemService;
	}

	@Required
	public void setSearchService(ISearchService searchService) {
		this.searchService = searchService;
	}

}
