package com.emindsblogapplication;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvc
@EnableSwagger2
@Component

public class BlogApplication {
	@Bean
	public ModelMapper modelMapper (){
		return  new ModelMapper();

	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
