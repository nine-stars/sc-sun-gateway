package com.iyb.ak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.iyb.ak"})
@EnableFeignClients
@EnableHystrix
@EnableZuulProxy
@EnableDiscoveryClient
@Slf4j
public class GatewayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info(">>>>>>>>>>>>>>> sc-sun-gateway 启动完成<<<<<<<<<<<<<");
	}


	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}



}
