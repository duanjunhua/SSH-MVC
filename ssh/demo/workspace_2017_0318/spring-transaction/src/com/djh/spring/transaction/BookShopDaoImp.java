package com.djh.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repository("bookShopDao")
public class BookShopDaoImp implements BookShopDao {

//	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findPriceByIsbn(int Isbn) {
		String sql = "select price from book where isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, Isbn);
	}

	@Override
	public void updateBookStoreByIsbn(int Isbn) {
		// TODO Auto-generated method stub
		String querybookStock = "select stock from book_stock where isbn = ?";
		if(jdbcTemplate.queryForObject(querybookStock, Integer.class, Isbn) == 0){
			throw new RuntimeException("stock is not enough...");
		};
		
		String sql = "update book_stock set stock = stock - 1 where isbn = ?";
		jdbcTemplate.update(sql, Isbn);
	}

	@Override
	public void updateUserAccountByUse(String userName, int price) {
		// TODO Auto-generated method stub
		String querybookStock = "select balance from account where username = ?";
		if(jdbcTemplate.queryForObject(querybookStock, Integer.class, userName) < price){
			throw new RuntimeException("balance is not enough...");
		};
		
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, userName);
	}

}
