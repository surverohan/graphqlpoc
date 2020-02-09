package com.spike.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Rohan Surve on 01/31/2020. This class is responsible for scanning
 * and creating beans and bootstrap application
 */
@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(GraphqlApplication.class, args);
	}

}
