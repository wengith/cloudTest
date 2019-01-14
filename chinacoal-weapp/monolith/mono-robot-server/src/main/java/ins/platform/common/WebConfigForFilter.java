package ins.platform.common;

import ins.framework.aop.log.tool.RequestFilter;
import ins.framework.aop.log.tool.WebAopFilter;
import ins.framework.log.TraceLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Web过滤器配置，这里主要加了调试过滤器（traceLogFilter）和AOP日志过滤器（requestFilter和webAopFilter）
 * 
 * @author zhouxianli
 *
 */
@Configuration
public class WebConfigForFilter {
	private static final int ORDER_100 = 100;
	private static final int ORDER_200 = 200;
	private static final int ORDER_300 = 300;

	@Bean
	public FilterRegistrationBean<TraceLogFilter> traceLogFilter() {
		TraceLogFilter filter = new TraceLogFilter();
		FilterRegistrationBean<TraceLogFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.addInitParameter("enable", "true");
		registrationBean.addInitParameter("minTime", "-1");
		registrationBean.addInitParameter("maxShowParam", "10");
		registrationBean.setName("traceLogFilter");
		registrationBean.setOrder(ORDER_100);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<RequestFilter> requestFilter() {
		RequestFilter filter = new RequestFilter();
		FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setName("requestFilter");
		registrationBean.setOrder(ORDER_200);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<WebAopFilter> webAopFilter() {
		WebAopFilter filter = new WebAopFilter();
		FilterRegistrationBean<WebAopFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(filter);
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setName("webAopFilter");
		registrationBean.setOrder(ORDER_300);
		return registrationBean;
	}

}
