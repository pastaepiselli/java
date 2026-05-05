package it.test.corsospring.annotation.scan;

import org.springframework.stereotype.Component;

@Component
public class Role {

	public void getRole() {
		System.out.println("User");
	}
}
