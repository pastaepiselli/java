package it.test.corsospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	// qui si va a definire i nostri bean
	// questo equivale a creare un elemento <beans> in .xml

	@Bean(name = "ordineAnnotation", initMethod = "init") // name = id in .xml
	public OrdineService getOrdineService() {
		return new OrdineService();
				
	}
}
