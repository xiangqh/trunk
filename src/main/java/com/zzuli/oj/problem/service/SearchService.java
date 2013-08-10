package com.zzuli.oj.problem.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.zzuli.oj.common.Page;
import com.zzuli.oj.common.util.SearchField;
import com.zzuli.oj.common.util.SearchProblem;
import com.zzuli.oj.common.util.Solr;
import com.zzuli.oj.hibernate.entry.Problem;

/**
 * @author xiangqh
 *
 */
public class SearchService implements ISearchService {

	@Override
	public Map<String, Object> search(SearchField searchField, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer key = new StringBuffer();
		String keyWord = searchField.getKeyWord();
		String sort = searchField.getSort();
		if (StringUtils.isNotBlank(keyWord.replaceAll("\"", ""))) {
			key.append(keyWord);
		} else {
			key.append("*:*");
		}

		SolrQuery query = new SolrQuery();
		query.setQuery(key.toString());
		if (keyWord != null && !"".equals(keyWord.trim())) {
			if (keyWord.matches("^[0-9]*$")) {
				query.addFilterQuery("id:" + keyWord);
			}
		}

		if (StringUtils.isNotBlank(sort)) {
			query.setParam("sort", sort);
		}
		query.setStart(page.getStart());
		query.setRows(page.getPageSize());
		QueryResponse result = null;
		try {
			result = Solr.getInstance().query(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null) {
			SolrDocumentList list = result.getResults();
			page.setTotalCount(Long.valueOf(list.getNumFound()).intValue());
			List<SearchProblem> searchProblems = result.getBeans(SearchProblem.class);
			map.put("problemList", searchProblems);
		}
		return map;
	}

	@Override
	public void addDoc(Problem problem) {
		List<Problem> problems = new ArrayList<Problem>(1);
		problems.add(problem);
		List<SolrInputDocument> docs = this.convertPro2Doc(problems);

		try {
			Solr.getInstance().add(docs);
			Solr.getInstance().optimize();
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addDocs(List<Problem> problems) {
		List<SolrInputDocument> docs = this.convertPro2Doc(problems);

		try {
			Solr.getInstance().add(docs);
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void updateDocs(List<Problem> problems) {
		// TODO Auto-generated method stub
		List<SolrInputDocument> docs = this.convertPro2Doc(problems);
		try {
			Solr.getInstance().add(docs);
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void deleteDocById(int problem_id) {
		try {
			Solr.getInstance().deleteById(String.valueOf(problem_id));
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void deleteDoc(Problem problems) {
		// TODO Auto-generated method stub
		try {
			Solr.getInstance().deleteById(String.valueOf(problems.getProblem_id()));
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDoc(List<Problem> problems) {
		List<String> ids = new ArrayList<String>();
		for (Problem problem : problems) {
			ids.add(String.valueOf(problem.getProblem_id()));
		}

		try {
			Solr.getInstance().deleteById(ids);
			Solr.getInstance().commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void refreshIndex(List<Problem> problems){
		try {
			Solr.getInstance().deleteByQuery("*:*");
			this.addDocs(problems);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<SolrInputDocument> convertPro2Doc(List<Problem> problems) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'");

		List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		for (Problem problem : problems) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", problem.getProblem_id());
			document.addField("title", problem.getTitle());
			document.addField("accepted", problem.getAccepted());
			document.addField("submit", problem.getSubmit());
			document.addField("ratio", problem.getRatio());
			document.addField("difficulty", problem.getDifficulty());
			String createTime=sdf.format(problem.getIn_date());
			document.addField("in_date", createTime);
			docs.add(document);
		}
		return docs;
	}

	


}
