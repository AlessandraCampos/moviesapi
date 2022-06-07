package moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class MoviesCineApplication {

	public static void main(String[] args) {
	SpringApplication.run(MoviesCineApplication.class, args);
		System.out.println("hello");
	}

}
