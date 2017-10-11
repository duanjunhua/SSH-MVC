package com.djh.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserUtils {

	private static final String RESOURCE = "mybatis.xml";

	public static SqlSession getSqlSession() throws IOException {
		Reader reader = Resources.getResourceAsReader(RESOURCE);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		return session;
	}
}
