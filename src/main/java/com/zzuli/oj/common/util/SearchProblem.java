package com.zzuli.oj.common.util;

import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author xiangqh
 *
 */
public class SearchProblem {

	@Field
	private String id;
	@Field
	private String title;
	@Field
	private int accepted;
	@Field
	private int submit;
	@Field
	private int ratio;
	@Field
	private int difficulty;
	@Field
	private Date in_date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public int getRatio() {
		return ratio;
	}

	public void setRatio(int ratio) {
		this.ratio = ratio;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
