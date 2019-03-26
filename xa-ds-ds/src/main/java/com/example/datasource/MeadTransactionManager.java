package com.example.datasource;

import javax.sql.XADataSource;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mysql.cj.jdbc.MysqlXADataSource;



@Configuration
public class MeadTransactionManager {

	private static XADataSource xaMySQLDataSource1() {
		System.err.println("init bean: xaMySQLDataSource1");
		MysqlXADataSource mysqlDataSource = new MysqlXADataSource(); 
		mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		mysqlDataSource.setPassword("Ration@33");
		mysqlDataSource.setUser("root");
		mysqlDataSource.setDatabaseName("test");
		return mysqlDataSource;
	}
	
	@Bean(name="entityManagerMySql")
	@DependsOn({"transactionManager"})
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.err.println("init bean: entityManagerFactory");
		//
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
		ds.setXaDataSource(xaMySQLDataSource1());
		ds.setUniqueResourceName("mysql5");
		ds.setMaxPoolSize(3);
		ds.setMinPoolSize(1);
		//
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceXmlLocation("classpath:/META-INF/data-persistence.xml");
		bean.setPersistenceUnitName("org.mysql");
		bean.setJtaDataSource(ds);
		//
		return bean;
	}
}
