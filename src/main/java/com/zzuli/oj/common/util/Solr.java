package com.zzuli.oj.common.util;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

/**
 * @author xiangqh
 *
 */
public class Solr {

	private final static Logger logger = Logger.getLogger(Solr.class);

	private static String URL = "http://127.0.0.1:8080/solr/";
	private static CommonsHttpSolrServer instance;

	static {
		instance = getSolrServer(URL);
	}

	public static CommonsHttpSolrServer getInstance() {
		if (instance == null) {
			instance = getSolrServer(URL);
		}
		return instance;
	}

	private static CommonsHttpSolrServer getSolrServer(String url) {
		CommonsHttpSolrServer server = null;
		try {
			server = new CommonsHttpSolrServer(url);
			server.setSoTimeout(3000); // socket read timeout
			server.setConnectionTimeout(1000);
			server.setDefaultMaxConnectionsPerHost(1000);
			server.setMaxTotalConnections(10);
			server.setFollowRedirects(false); // defaults to false
			server.setAllowCompression(true);
			server.setMaxRetries(1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return server;
	}
}
