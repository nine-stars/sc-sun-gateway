package com.iyb.ak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages={"com.iyb.ak"})
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableZuulProxy
//@SpringCloudApplication
//@EnableCircuitBreaker
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
