package com.emindsblogapplication;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan

public class BlogApplication {
	@Bean
	public ModelMapper modelMapper (){
		return  new ModelMapper();

	}

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

}
