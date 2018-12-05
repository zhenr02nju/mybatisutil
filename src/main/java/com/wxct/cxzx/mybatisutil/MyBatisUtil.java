/**
 * 
 */
package com.wxct.cxzx.mybatisutil;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 2018-12-05 14:38:11
 * MyBatis工具类
 * @author zhenr
 *
 */
public class MyBatisUtil {
	private String resource;
	
	public MyBatisUtil(String resource) {
		this.resource=resource;
	}
	
	/**
	 * 获取SqlSessionFactory
	 * 
	 * */
	public SqlSessionFactory getSqlSessionFactory() {
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
	
	/**
	 * 获取SqlSessionFactory
	 * @param environment 多数据源时 选择数据源
	 * */
	public SqlSessionFactory getSqlSessionFactory(String environment) {
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is,environment);
		return factory;
	}
	
	/**
	 * 获取SqlSession
	 * */
	public SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	
	/**
	 * 获取SqlSession
	 * 
	 * @param environment 多数据源时 选择数据源
	 * */
	public SqlSession getSqlSession(String environment) {
		return getSqlSessionFactory(environment).openSession();
	}
	
	/**
	 * 获取SqlSession
	 * @param isAutoCommit 
     *        true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *        false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
	 * */
	public SqlSession getSqlSession(boolean isAutoCommit) {
		return getSqlSessionFactory().openSession(isAutoCommit);
	}
	
	/**
	 * 获取SqlSession
	 * @param isAutoCommit 
     *        true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *        false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
     * @param environment 多数据源时 选择数据源
	 * */
	public SqlSession getSqlSession(String environment,boolean isAutoCommit) {
		return getSqlSessionFactory(environment).openSession(isAutoCommit);
	}
}
