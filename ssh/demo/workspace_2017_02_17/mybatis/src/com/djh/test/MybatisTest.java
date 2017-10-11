package com.djh.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.djh.beans.User;
import com.djh.dao.MapperUserDAO;
import com.djh.dao.XMLUserDAO;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MybatisTest {
	public static void main(String[] args) throws IOException {
		MapperUserDAO dao = new MapperUserDAO();
//		String resource = "mybatis.xml";
//		// 加载mybatis的配置文件(它也加载关联的映射文件)
//		Reader reader = Resources.getResourceAsReader(resource);
//		// 构建sqlSession工厂
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
//		// 创建能执行映射文件的sql的sqlSession
//		SqlSession sqlSession = factory.openSession();
//		// 映射sql的标识字符串
//		String statement = "com.djh.beans.userMapper" + ".selectUser";
		// 执行查询返回一个唯一user对象的sql
		//User user1 = (User) sqlSession.selectOne(statement, new Integer(1));
		User user1 = dao.getUserById(1);
		System.out.println(user1);

		System.out.println("--------------------------------");
		//String updateUser = "com.djh.beans.userMapper" + ".updateUser";
		user1.setId(1);
		user1.setAge(20);
		dao.updateUser(user1);

		// select all user
//		String sqlUsers = "com.djh.beans.userMapper" + ".selectAllUser";
//		List<User> users = sqlSession.selectList(sqlUsers);
		List<User> users = dao.getAllUser();
		for (User user : users) {
			System.out.println(user);
		}

	}
}
