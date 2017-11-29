package com.iyb.ak.config;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {

/*	@Bean
	Request.Options feignOptions() {
		return new Request.Options(connectTimeout, readTimeout);
	}*/

	@Bean
	Retryer feignRetryer() {
		return new Retryer() {
			@Override
			public void continueOrPropagate(RetryableException e) {
				throw e;
			}
			@Override
			public Retryer clone() {
				return this;
			}
		};
		//return Retryer.NEVER_RETRY; //需要高版本fiegn-core
	}
}
