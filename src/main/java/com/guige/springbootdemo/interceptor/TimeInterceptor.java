package com.guige.springbootdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor {
	Logger log = LoggerFactory.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("========preHandle=========");
		log.info("========preHandle=========");
		log.info(((HandlerMethod) handler).getBean().getClass().getName());
		log.info(((HandlerMethod) handler).getMethod().getName());

		request.setAttribute("startTime", System.currentTimeMillis());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.info("========postHandle=========");
		Long start = (Long) request.getAttribute("startTime");
		log.info("耗时:" + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		log.info("========afterCompletion=========");
		Long start = (Long) request.getAttribute("startTime");
		log.info("耗时:" + (System.currentTimeMillis() - start));
		if (exception != null) {
			log.error( exception.getMessage(),exception);
		}
	}

}