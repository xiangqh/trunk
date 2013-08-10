package com.zzuli.oj.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.zzuli.oj.hibernate.entry.Problem;

/**
 * @author xiangqh
 *
 */
@Service
public class SolrServer {

	private CommonsHttpSolrServer solr = Solr.getInstance();

	public void addIndex(Collection<Problem> items) throws SolrServerException, IOException {

		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		for (Problem item : items) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", item.getProblem_id());
			document.addField("title", item.getTitle());
			document.addField("description", item.getDescription());
			document.addField("accepted", item.getAccepted());
			document.addField("submit", item.getSubmit());
			document.addField("ratio", item.getRatio());
			document.addField("difficulty", item.getDifficulty());
			docs.add(document);
		}
		solr.add(docs);
		solr.commit();
	}

	public void deleteIndex(Collection<Integer> p_ids) throws SolrServerException, IOException {
		List<String> ids = new ArrayList<String>();
		for (Integer id : p_ids) {
			ids.add(Integer.toString(id));
		}
		solr.deleteById(ids);
		solr.commit();
	}

	public QueryResponse execueQuery(SolrQuery query) throws SolrServerException {
		return solr.query(query);
	}

	public void deleteQuery() throws SolrServerException, IOException {
		solr.deleteByQuery("*:*");
	}

}
