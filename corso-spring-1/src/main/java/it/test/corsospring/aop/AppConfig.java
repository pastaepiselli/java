package it.test.corsospring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // abilitiamo aspect nella nostra applicazione
public class AppConfig {

	@Bean(name = "logger")
	public LogAspect getLog() {
		return new LogAspect();
	}
}
