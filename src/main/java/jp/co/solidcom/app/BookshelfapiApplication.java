package jp.co.solidcom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.solidcom.security.WebSecurityConfig;

@SpringBootApplication
@RestController
@Import(WebSecurityConfig.class)
public class BookshelfapiApplication {

	@GetMapping
	String home() {
		return "Hello World!";
	}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	public static void main(String[] args) {
		SpringApplication.run(BookshelfapiApplication.class, args);
	}

}
