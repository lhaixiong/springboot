package com.lhx;

import com.lhx.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class SpringbootApplication {
	@Autowired
	private ConfigBean configBean;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	@RequestMapping("/")
	public String index(){
		return configBean.getSay();
	}
}
