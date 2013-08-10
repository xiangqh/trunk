package com.zzuli.oj.hibernate.entry;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.zzuli.oj.common.hibernate.entry.PO;

@Entity
@Table(name = "problem")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class Problem extends PO {

	@Id
	@Column(name = "problem_id")
	private int problem_id;
	@Column(name = "title")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String title;
	@Column(name = "description")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String description;
	@Column(name = "input")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String input;
	@Column(name = "output")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String output;
	@Column(name = "input_path")
	private String input_path;
	@Column(name = "output_path")
	private String output_path;
	@Column(name = "sample_input")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String sample_input;
	@Column(name = "sample_output")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String sample_output;
	@Column(name = "hint")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String hint;
	@Column(name = "source")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String source;
	@Column(name = "sample_program")
	@Type(type = "com.zzuli.oj.hibernate.entry.type.UTF8String")
	private String sample_program;
	@Column(name = "in_date")
	private Date in_date;
	@Column(name = "time_limit")
	private int time_limit;
	@Column(name = "memory_limit")
	private int memory_limit;
	@Column(name = "defunct")
	@Type(type = "yes_no")
	private boolean defunct;
	@Column(name = "accepted")
	private int accepted;
	@Column(name = "submit")
	private int submit;
	@Column(name = "ratio")
	private int ratio;
	@Column(name = "error")
	private int error;
	@Column(name = "difficulty")
	private int difficulty;
	@Column(name = "submit_user")
	private int submit_user;
	@Column(name = "solved")
	private int solved;
	@Column(name = "case_time_limit")
	private int case_time_limit;

	public int getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getInput_path() {
		return input_path;
	}

	public void setInput_path(String input_path) {
		this.input_path = input_path;
	}

	public String getOutput_path() {
		return output_path;
	}

	public void setOutput_path(String output_path) {
		this.output_path = output_path;
	}

	public String getSample_input() {
		return sample_input;
	}

	public void setSample_input(String sample_input) {
		this.sample_input = sample_input;
	}

	public String getSample_output() {
		return sample_output;
	}

	public void setSample_output(String sample_output) {
		this.sample_output = sample_output;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSample_program() {
		return sample_program;
	}

	public void setSample_program(String sample_program) {
		this.sample_program = sample_program;
	}

	public Date getIn_date() {
		return in_date;
	}

	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}

	public int getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}

	public int getMemory_limit() {
		return memory_limit;
	}

	public void setMemory_limit(int memory_limit) {
		this.memory_limit = memory_limit;
	}

	public boolean isDefunct() {
		return defunct;
	}

	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
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

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getSubmit_user() {
		return submit_user;
	}

	public void setSubmit_user(int submit_user) {
		this.submit_user = submit_user;
	}

	public int getSolved() {
		return solved;
	}

	public void setSolved(int solved) {
		this.solved = solved;
	}

	public int getCase_time_limit() {
		return case_time_limit;
	}

	public void setCase_time_limit(int case_time_limit) {
		this.case_time_limit = case_time_limit;
	}

}
