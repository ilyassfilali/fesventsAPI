package com.integrateur.fesevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.integrateur.fesevent.conf.SwaggerConfiguration;

@SpringBootApplication ( exclude = {SecurityAutoConfiguration.class})
@EnableAsync
@Import(SwaggerConfiguration.class)
public class FeseventApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeseventApplication.class, args);
	}

}
