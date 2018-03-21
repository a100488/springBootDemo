package com.guige.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.guige.springbootdemo.interceptor.TimeInterceptor;

@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        
        return new HttpMessageConverters(converter);

    }
    
  /*  @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(),"/servletTest");
    }
    
    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        
        return registrationBean;
    }
    
    @Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
    }*/
    
    @Autowired
    private TimeInterceptor timeInterceptor;
    

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/fastjson/**")
                      .allowedOrigins("*");// http://localhost:8088允许 8088 端口访问
          }
        };
    }
    
   /* @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
              .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
    }*/
}