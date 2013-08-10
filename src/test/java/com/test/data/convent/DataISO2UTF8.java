package com.test.data.convent;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.security.action.GetIntegerAction;

import com.zzuli.oj.hibernate.entry.Problem;

public class DataISO2UTF8 {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection inputConn = getInputConn();
		Connection outputConn = getOutputConn();

		List<Problem> list = new ArrayList<Problem>();
		String sql = "select * from problem";
		try {
			PreparedStatement pstmt = inputConn.prepareStatement(sql) ;
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Problem problem = new Problem();
				problem.setProblem_id(rs.getInt("problem_id"));
				problem.setTitle(getUtf8(rs.getString("title")));
				problem.setDescription(getUtf8(rs.getString("description")));
				problem.setHint(getUtf8(rs.getString("hint")));
				problem.setDifficulty(rs.getInt("difficulty"));
				problem.setAccepted(rs.getInt("accepted"));
				problem.setCase_time_limit(rs.getInt("case_time_limit"));
				problem.setDefunct(rs.getString("defunct").equals("N")?false:true);
				problem.setError(rs.getInt("error"));
				problem.setIn_date(rs.getDate("in_date"));
				problem.setInput(rs.getString("input"));
			//	problem.setInput_path(rs.get)

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getUtf8(String string) {
		// TODO Auto-generated method stub
		try {
			return new String(string.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static Connection getOutputConn(){

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/judgeonline", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Connection getInputConn(){

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/oj", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
