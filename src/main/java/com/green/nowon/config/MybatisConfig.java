package com.green.nowon.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class MybatisConfig {
	
	//hikari bean 생성
	@Bean
	DataSource dataSource() {
		return new HikariDataSource(hikariconfig());
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	HikariConfig hikariconfig() {
		return new HikariConfig();
	}
	
	private final ApplicationContext ap;
	
	@Bean //xml 에대한 설정
	SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		System.out.println(">>>>:"+dataSource());
		factoryBean.setDataSource(dataSource());
		factoryBean.setConfiguration(mybatisConfiguration());
		String locationPattern="classpath:mapper/**/*-mapper.xml";
		Resource[] mapperLocations=ap.getResources(locationPattern);
		//Resource[] mapperLocations = new ClassLoaderFilesResourcePatternResolver().getResources(locationPattern);
		factoryBean.setMapperLocations(mapperLocations);//xml파일위치 설정
		
		return factoryBean.getObject();
	}
	
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	org.apache.ibatis.session.Configuration mybatisConfiguration() {
		return new org.apache.ibatis.session.Configuration();
	}

	@Bean
	SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}
