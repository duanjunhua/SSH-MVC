package com.showstu.test;

import java.sql.Connection;
import org.junit.Test;
import com.djh.test.StudentDAO;

public class TestShow {

	@Test
	public void test(){
		Connection connection = StudentDAO.getConnection();
		System.out.println(connection);
	}
}
