package org.pub.sprmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LatencyWatchInterceptor implements HandlerInterceptor {
	
	private static Logger logger = LoggerFactory.getLogger(LatencyWatchInterceptor.class);
	
	private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("LatencyWatchInterceptor afterCompletion...");
		//2、结束时间  
        long endTime = System.currentTimeMillis();
        //得到线程绑定的局部变量（开始时间）  
        long beginTime = threadLocal.get();
        //3、消耗的时间  
        long consumeTime = endTime - beginTime;
       //此处认为处理时间超过2000毫秒的请求为慢请求  
        if(consumeTime > 2000) {
            //记录到日志文件  
        	logger.warn("slowopt: {} consume {} ms", request.getRequestURI()+"?"+request.getQueryString(), consumeTime);
        	HandlerMethod handlerMethod = (HandlerMethod)handler;
        	handlerMethod.getMethod().getName();
        } 
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		logger.debug("LatencyWatchInterceptor postHandle...");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("LatencyWatchInterceptor preHandle...");
		//1、开始时间  
        long beginTime = System.currentTimeMillis();
      //线程绑定变量（该数据只有当前请求的线程可见）		
        threadLocal.set(beginTime);
		return true;
	}

}
