package com.iyb.ak.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iyb.ak.interceptor.SimpleCORSFilter;
import com.iyb.ak.interceptor.TrackerZuulFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);	// 排除值为空属性
//		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);// 排除初始值未被改变的属性
//		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		// 进行日期格式化
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		objectMapper.setDateFormat(dateFormat);
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(customJackson2HttpMessageConverter());
	}

	@Bean
	public FilterRegistrationBean corsFilter(){
		SimpleCORSFilter filter = new SimpleCORSFilter();
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.setOrder(1);
		return registration;
	}


	@Bean
	public TrackerZuulFilter trackerZuulFilter(){
		return new TrackerZuulFilter();
	}
}
