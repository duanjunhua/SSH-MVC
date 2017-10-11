package com.djh.spring.transaction;

public interface BookShopDao {
	
	//查询书籍价格
	public int findPriceByIsbn(int Isbn);
	//更新库存
	public void updateBookStoreByIsbn(int Isbn);
	//更新账户余额
	public void updateUserAccountByUse(String userName, int price);
}
