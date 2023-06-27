package com.green.nowon.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class MybatisConfig {
	
	@Bean
	DataSource dataSource() {
		return new HikariDataSource(hikariconfig());
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	HikariConfig hikariconfig() {
		return new HikariConfig();
	}
}
