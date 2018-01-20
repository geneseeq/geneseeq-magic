package com.geneseeq.service.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:config/oracleDatasource.properties"})
@MapperScan(value = "com.geneseeq.common.dao" , sqlSessionFactoryRef = "oracleSessionFactory")
public class OracleDatabaseConfig {

    @Bean(name = "oracleDataSource")
    @Primary
    @ConfigurationProperties(prefix = "oracle.db1")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("oracleDataSource")DataSource oracleDataSource) {
        return new DataSourceTransactionManager((oracleDataSource));
    }


    @Bean(name = "oracleSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleDataSource")DataSource oracleDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory1 = new SqlSessionFactoryBean();
        sqlSessionFactory1.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
        sqlSessionFactory1.setDataSource(oracleDataSource());
        return sqlSessionFactory1.getObject();
    }




}