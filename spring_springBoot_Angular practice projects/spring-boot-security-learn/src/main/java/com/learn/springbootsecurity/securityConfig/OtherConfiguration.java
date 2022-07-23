package com.learn.springbootsecurity.securityConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class OtherConfiguration {

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
         return NoOpPasswordEncoder.getInstance();
	}
	
    @Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource driverManagerDatasource = new DriverManagerDataSource();
		driverManagerDatasource.setUrl("jdbc:mysql://127.0.0.1:3306/springBootSecurity");
		driverManagerDatasource.setUsername("root");
		driverManagerDatasource.setPassword("Ankit@1234");
		driverManagerDatasource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		return driverManagerDatasource;
	}
  
}


