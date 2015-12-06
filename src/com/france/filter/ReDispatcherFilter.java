package com.france.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ReDispatcherFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		String target = request.getRequestURI();
        target = target.lastIndexOf("?") > 0 ? target.substring(
                target.lastIndexOf("/") + 1,
                target.lastIndexOf("?") - target.lastIndexOf("/")) : target
                .substring(target.lastIndexOf("/") + 1);
        if (request.getRequestURI().indexOf("/ckfinder/") > 0) {
            // request.getRequestURI()格式应该形如：/{base}/ckfinder/.
            // 其中st是项目名，servlet是所有servlet都增加的前缀，用于能够判断出是servlet。
            // if只判断请求uri是否包含/ckfinder/，如果包含则处理；
        	System.out.println("go servlet..");
            RequestDispatcher rdsp = request.getRequestDispatcher(target);
            rdsp.forward(req, resp);
        } else {
        	System.out.println("go struts..");
            chain.doFilter(req, resp);
        }
     // 第二种方式 （二选 一）
        /**
        if (this.includes.contains(target)) {
            // target取出的值则直接是jqueryAjax，在web.xml中配置即可。
            // if判断请求uri最后的那部分是否包含在配置文件中，如果包含，则处理
            RequestDispatcher rdsp = request.getRequestDispatcher(target);
            rdsp.forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
        */
	}

	private ArrayList<String> includes = new ArrayList<String>();
	@Override
	public void init(FilterConfig config) throws ServletException {

//		this.includes.addAll(Arrays.asList(config.getInitParameter(
//				"includeServlets").split(",")));
	}
}
