 package com.hibernate;




import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateTestApplication {
	// configuazione alternativa al posto di properties 
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder =DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5432/palestra");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("postgres");
		return dataSourceBuilder.build();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateTestApplication.class, args);
	}

}
