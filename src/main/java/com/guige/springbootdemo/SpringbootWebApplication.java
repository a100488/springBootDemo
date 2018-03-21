package com.guige.springbootdemo;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import com.guige.springbootdemo.filter.TimeFilter;
import com.guige.springbootdemo.listener.ListenerTest;
import com.guige.springbootdemo.servlet.ServletTest;

//@SpringBootApplication
public class SpringbootWebApplication implements ServletContextInitializer {
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 配置 Servlet
        servletContext.addServlet("servletTest",new ServletTest())
                      .addMapping("/servletTest");
        // 配置过滤器
        servletContext.addFilter("timeFilter",new TimeFilter())
                      .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
        // 配置监听器
        servletContext.addListener(new ListenerTest());
    }

   /* public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }*/
}