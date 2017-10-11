package com.djh.spring.transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.djh.spring.transaction.BookShopDao;

public class TestAll {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate;
	private BookShopDao bookShopDao;

	{
		ctx = new ClassPathXmlApplicationContext("springJdbcContext.xml");
		jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		bookShopDao = ctx.getBean(BookShopDao.class);
	}
	
	
	
	@Test
	public void testFindPriceByIsbn(){
		System.out.println(bookShopDao.findPriceByIsbn(1001));
	}
	
	@Test
	public void testUpdateBookStockByIsbn(){
		bookShopDao.updateBookStoreByIsbn(1003);
	}
	
	@Test
	public void testUpdateUserAccount(){
		bookShopDao.updateUserAccountByUse("Kay", 80);
	}
}
