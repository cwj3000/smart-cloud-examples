package org.smartframework.cloud.examples.basic.user;

import org.smartframework.cloud.examples.framework.annotation.SmartApplication;
import org.springframework.boot.SpringApplication;

@SmartApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}