package com.djh.test.mapp.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.djh.test.mapp.Pay;
import com.djh.test.mapp.Worker;

import junit.framework.TestCase;

public class TestWork extends TestCase {
	
	private Session session;
	private Transaction transaction;
	private SessionFactory factory;
	
	protected void setUp() throws Exception {
		Configuration configuration = new Configuration().configure();
		//加载持久化类
		configuration.addClass(Worker.class);
		//创建ServiceRegistry对象
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	public void testSaveWork(){
		Pay pay = new Pay();
		pay.setMonthlyPay(2000);
		pay.setYearlyPay(24000);
		pay.setVocationPay(100);
		Worker worker = new Worker();
		worker.setName("michael");
		worker.setPay(pay);
		session.save(worker);
	}
	
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		transaction.commit();
		session.close();
		factory.close();
	}
}
