package com.france.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
/**
 * 过滤器基类
 * 支持黑白名单
 * ref:http://jinnianshilongnian.iteye.com/blog/1663481
 * ant 需要spring-core支持
 * @author Administrator
 *
 */
public abstract class BaseFilter implements Filter {  
    
	private FilterConfig config = null;  
    
    private final String[] NULL_STRING_ARRAY = new String[0];  
    private final String URL_SPLIT_PATTERN = "[, ;\r\n]";//逗号  空格 分号  换行  
  
    private final PathMatcher pathMatcher = new AntPathMatcher();  
  
  
    /** 
     * 白名单 
     */  
    private String[] whiteListURLs = null;  
  
    /** 
     * 黑名单 
     */  
    private String[] blackListURLs = null;  
  
    @Override  
    public final void init(FilterConfig config) throws ServletException {  
        this.config = config;  
        this.initConfig();  
        this.init();  
    }  
  
    /** 
     * 子类覆盖 
     *  
     * @throws ServletException 
     */  
    public void init() throws ServletException {  
  
    }  
  
    /** 
     * 1、黑名单匹配 2、白名单匹配 
     */  
    @Override  
    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)   
        throws IOException, ServletException {  
  
        HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;  
  
        String currentURL = httpRequest.getServletPath();  
  
        System.out.println("url filter : current url : [{"+currentURL+"}]");
        if (isBlackURL(currentURL)) {  
            chain.doFilter(request, response);  
            return;  
        }  
        //主要是要过滤这边的url
        if (isWhiteURL(currentURL)) {  
            doFilter(httpRequest, httpResponse, chain);
            return;  
        }  
        //主要是要对白名单的内容进行过滤? 后面就不用每次都把css img这些再过滤一次了
        //这样有什么安全漏洞 可脚本躲过ant match？
        System.out.println("url filter : no url list matches : [{"+currentURL+"}]  break");
        chain.doFilter(request, response);  
        return;  
    }  
  
    private boolean isWhiteURL(String currentURL) {  
        for (String whiteURL : whiteListURLs) {  
            if (pathMatcher.match(whiteURL, currentURL)) {  
            	 System.out.println("白名单匹配进入具体的控制 url filter : white url list matches : [{"+whiteURL+"}] match [{"+currentURL+"}] continue"); 
            	 
            	 return true;  
            }  
        }  
        return false;  
    }  
  
    private boolean isBlackURL(String currentURL) {  
        for (String blackURL : blackListURLs) {  
            if (pathMatcher.match(blackURL, currentURL)) {  
            	 System.out.println("黑名单匹配成功，无需再次检查到下一个过滤器  url filter : black url list matches : [{"+blackURL+"}] match [{"+currentURL+"}] continue"); 
                return true;  
            }  
//            System.out.println("url filter : black url list not matches:"+blackURL);
        }
        return false;  
    }  
  
    /** 
     * 子类覆盖 
     *  
     * @param request 
     * @param response 
     * @param chain 
     * @throws IOException 
     * @throws ServletException 
     */  
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        chain.doFilter(request, response);  
    }  
  
    /** 
     * 子类覆盖 
     */  
    @Override  
    public void destroy() {  
  
    }  
  
    private void initConfig() {  
        String whiteListURLStr = this.config.getInitParameter("whiteListURL");  
        whiteListURLs = strToArray(whiteListURLStr);  
  
        String blackListURLStr = this.config.getInitParameter("blackListURL");  
        blackListURLs = strToArray(blackListURLStr);  
  
    }  
  
    private String[] strToArray(String urlStr) {  
        if (urlStr == null) {  
            return NULL_STRING_ARRAY;  
        }  
        String[] urlArray = urlStr.split(URL_SPLIT_PATTERN);  
  
        List<String> urlList = new ArrayList<String>();  
  
        for (String url : urlArray) {  
            url = url.trim();  
            if (url.length() == 0) {  
                continue;  
            }  
  
            urlList.add(url);  
        }  
  
        return urlList.toArray(NULL_STRING_ARRAY);  
    }  
  
    public FilterConfig getConfig() {  
        return config;  
    }  
}  