package jp.co.solidcom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.solidcom.security.WebSecurityConfig;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class} )
@RestController
@Import(WebSecurityConfig.class)
public class BookshelfapiApplication {

	@GetMapping
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookshelfapiApplication.class, args);
	}

}
