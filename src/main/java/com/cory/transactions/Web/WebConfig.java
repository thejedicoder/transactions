package com.cory.transactions.Web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring configuration class
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cory.transactions")
public class WebConfig {
}
