package com.djh.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Service("bookShopService")
public class BookShopServiceImp implements BookShopService {

//	@Autowired
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
//	@Transactional(propagation=Propagation.REQUIRES_NEW, 		//添加事物注解,保证被注解的事物成功则提交,否则回滚
//					isolation=Isolation.READ_COMMITTED,			//读已提交
//					noRollbackFor={RuntimeException.class},		//表示运行时异常时不回滚
//					readOnly=true,								//只读
//					timeout=30									//30秒后未提交,强制事物回滚
//				  )			
//	@Override
	public void service(String userName, int Isbn) {
		// TODO Auto-generated method stub
		int price = bookShopDao.findPriceByIsbn(Isbn);
		
		bookShopDao.updateBookStoreByIsbn(Isbn);
		
		bookShopDao.updateUserAccountByUse(userName, price);
	}

}
