package it.test.corsospring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// con questa classe possiamo configuare tutti i bean
@Configuration
public class Config {
	@Bean(name = "phoneBean")
	@Scope("prototype")
	public Phone getPhone() {
		return new Phone();
	}
	@Bean(name = "userBean")
	public User getUser() {
		return new User(getPhone());
	}

}
