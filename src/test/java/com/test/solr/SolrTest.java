package com.test.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.zzuli.oj.common.util.SolrServer;
import com.zzuli.oj.hibernate.entry.Problem;
import com.zzuli.oj.problem.service.ISearchService;
import com.zzuli.oj.problem.service.SearchService;


/**
 * @author xiangqh
 *
 */
public class SolrTest {

	public static void main(String[] args) throws SolrServerException, IOException {
		SolrServer server = new SolrServer();
		server.deleteQuery();

		/*List<Problem> list = new ArrayList<Problem>();
		for(int i=0 ;i<100;i++) {
			Problem item = new Problem();
			item.setProblem_id(i);
			item.setTitle("title"+i);
			item.setDescription("ddddd"+i);
			item.setSubmit(3);
			item.setAccepted(2);
			item.setRatio(3);
			item.setDifficulty(4);
			list.add(item);
		}
		server.addIndex(list);

		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.addFacetQuery("title:"+1111);
		query.setStart(0);
		query.setRows(100);
		QueryResponse result = server.execueQuery(query);
		SolrDocumentList docList = result.getResults();
		System.out.println(docList.size());*/

	}
}
