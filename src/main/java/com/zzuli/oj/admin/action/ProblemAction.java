package com.zzuli.oj.admin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.Page;
import com.zzuli.oj.common.util.SearchField;
import com.zzuli.oj.common.util.SearchProblem;
import com.zzuli.oj.hibernate.entry.Problem;
import com.zzuli.oj.problem.service.IProblemService;
import com.zzuli.oj.problem.service.ISearchService;

@Controller
public class ProblemAction extends Action {

	@Autowired
	private IProblemService problemService;
	@Autowired
	private ISearchService searchService;

	public String problemList() {
		int volume = getParameterInt("volume");
		String keyWord = "";
		if (volume == 0)
			volume = 1;
		Page page = new Page();
		page.setPageNo(volume);
		page.setPageSize(100);
		SearchField searchField = new SearchField();
		searchField.setSort("id desc");
		searchField.setKeyWord(keyWord);
		List<SearchProblem> problems = (List<SearchProblem>) searchService.search(searchField, page).get("problemList");
		setHttpAttribute("problems", problems);
		setHttpAttribute("page", page);
		setHttpAttribute("volume", volume);
		return "success";
	}

	public String editProblemPage() {
		String operate = "new";

		int problem_id = getParameterInt("problem_id");
		if (problem_id != 0) {
			operate = "modify";
			setHttpAttribute("problem_id", problem_id);
		}

		if (operate.equals("modify")) {
			List<String> errors = new ArrayList<String>();
			Problem problem = problemService.getProblemById(problem_id);
			if (problem == null) {
				errors.add("No such problem, ID:" + problem_id);
				return ERROR;
			}
			setHttpAttribute("problem", problem);
		}
		setHttpAttribute("operate", operate);
		return SUCCESS;
	}

	public String addProblem() {

		int problem_id = problemService.getNextProblemId();
		Problem problem = createProblem();
		String input_path = "";
		String output_path = "";
		problem.setProblem_id(problem_id);
		problem.setIn_date(new Date());
		problem.setInput_path(input_path);
		problem.setOutput_path(output_path);

		problemService.addProblem(problem);
		return SUCCESS;
	}

	public String modifyProblem() {

		int problem_id = getParameterInt("problem_id");
		Problem problem = createProblem();
		problem.setProblem_id(problem_id);

		problemService.updateProblem(problem);
		return SUCCESS;
	}

	public String delProblem() {
		int problem_id = getParameterInt("problem_id");
		problemService.delProblem(problem_id);
		return SUCCESS;
	}

	private Problem createProblem() {

		String title = getHttpParameter("title");
		if (title == null)
			title = "";
		int time_limit;
		try {
			time_limit = Integer.parseInt(getHttpParameter("time_limit"));
		} catch (NumberFormatException numberformatexception) {
			time_limit = 0;
		}
		int case_time_limit;
		try {
			case_time_limit = Integer.parseInt(getHttpParameter("case_time_limit"));
		} catch (NumberFormatException numberformatexception1) {
			case_time_limit = 0;
		}
		if (case_time_limit == 0)
			case_time_limit = time_limit;
		int memory_limit;
		try {
			memory_limit = Integer.parseInt(getHttpParameter("memory_limit"));
		} catch (NumberFormatException numberformatexception2) {
			memory_limit = 0;
		}
		String description = getHttpParameter("description");
		if (description == null)
			description = "";
		String input = getHttpParameter("input");
		if (input == null)
			input = "";
		String output = getHttpParameter("output");
		if (output == null)
			output = "";
		String contest_id = getHttpParameter("contest_id");
		if (contest_id != null && contest_id.trim().equals(""))
			contest_id = null;
		String sample_input = getHttpParameter("sample_input");
		if (sample_input == null)
			sample_input = "";
		String sample_output = getHttpParameter("sample_output");
		if (sample_output == null)
			sample_output = "";
		String source = getHttpParameter("source");
		if (source == null)
			source = "";
		String hint = getHttpParameter("hint");
		if (hint == null)
			hint = "";

		Problem problem = new Problem();
		problem.setTitle(title);
		problem.setDescription(description);
		problem.setHint(hint);
		problem.setSource(source);
		problem.setInput(input);
		problem.setOutput(output);
		problem.setSample_input(sample_input);
		problem.setSample_output(sample_output);
		problem.setCase_time_limit(case_time_limit);
		problem.setTime_limit(time_limit);
		problem.setMemory_limit(memory_limit);
		return problem;

	}

	public void setProblemService(IProblemService problemService) {
		this.problemService = problemService;
	}

	public void setSearchService(ISearchService searchService) {
		this.searchService = searchService;
	}

}
