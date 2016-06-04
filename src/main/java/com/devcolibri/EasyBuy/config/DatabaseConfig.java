package com.devcolibri.EasyBuy.config;

/**
 * Created by misha on 04.06.2016.
 */

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public BasicDataSource createDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/easy_buy");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(1);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager(BasicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public AnnotationSessionFactoryBean sessionFactory(BasicDataSource dataSource) {
        AnnotationSessionFactoryBean factory = new AnnotationSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan(new String[]{"com.devcolibri"});//TODO: write better package name
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
        factory.setHibernateProperties(properties);
        return factory;
    }
}
