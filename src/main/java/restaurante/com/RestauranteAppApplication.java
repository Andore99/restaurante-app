package restaurante.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableRetry
public class RestauranteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteAppApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				        .allowedOrigins("http://localhost:4200") 
				        .allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
