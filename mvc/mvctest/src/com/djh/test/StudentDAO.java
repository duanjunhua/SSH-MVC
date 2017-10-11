package com.djh.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDAO {

	private static final String DIRVERCLASS = "com.mysql.jdbc.Driver";
	private static final String MYSQLURL = "jdbc:mysql://127.0.0.1:3306/testing";
	private static final String USER = "root";
	private static final String PASSWORD = "java";
	
	private static Connection coon = null;
	private static PreparedStatement pStatement = null;
	private static ResultSet rSet = null;
	
	
	public static Connection getConnection(){
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			Class.forName(DIRVERCLASS);
			coon = (Connection) DriverManager.getConnection(MYSQLURL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coon;
	}
	
	public static ResultSet getResultSet(Connection connection, String sql){
		try {
			rSet = connection.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rSet;
	}
	
	
	public static void releaseAll(Connection coon, PreparedStatement pStatement, ResultSet rSet){
		if(rSet != null){
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pStatement != null){
			try {
				pStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(coon != null){
			try {
				coon.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
}
