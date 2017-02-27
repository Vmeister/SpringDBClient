/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdbclient.config;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.*" })
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig {

        @Bean
        public SessionFactory sessionFactory() {
                LocalSessionFactoryBuilder builder =
			new LocalSessionFactoryBuilder(dataSource());
                builder.scanPackages("com.model")
                      .addProperties(getHibernateProperties());

                return builder.buildSessionFactory();
        }

	private Properties getHibernateProperties() {
                Properties prop = new Properties();
                prop.put("hibernate.format_sql", "true");
                prop.put("hibernate.show_sql", "true");
                prop.put("hibernate.dialect",
                    "org.hibernate.dialect.MySQL5Dialect");
                return prop;
        }

	@Bean(name = "dataSource")
	public BasicDataSource dataSource() {

		BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdbclient");
		ds.setUsername("dbuser");
                ds.setPassword("ambientia123");
		return ds;
	}

	//Create a transaction manager
	@Bean
        public HibernateTransactionManager txManager() {
                return new HibernateTransactionManager(sessionFactory());
        }

}