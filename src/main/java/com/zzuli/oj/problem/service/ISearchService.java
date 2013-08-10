package com.zzuli.oj.problem.service;

import java.util.List;
import java.util.Map;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.common.util.SearchField;
import com.zzuli.oj.hibernate.entry.Problem;

/**
 * @author xiangqh
 *
 */
public interface ISearchService {

	public Map<String, Object> search(SearchField searchField,Page page);

	public void addDoc(Problem problem);

	public void addDocs(List<Problem> problems);

	public void updateDocs(List<Problem> problems);

	public void deleteDoc(Problem problem);
	
	public void deleteDocById(int problem_id);

	public void deleteDoc(List<Problem> problems);

	public void refreshIndex(List<Problem> problems);

}
