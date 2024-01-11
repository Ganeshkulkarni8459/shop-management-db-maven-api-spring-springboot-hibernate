package org.dnyanyog.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeans {
	
	@Bean
	public List<String> StringListBean(){
		return new ArrayList<String>();
	}

}
