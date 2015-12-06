package com.france.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class PathTest {
	private final PathMatcher pathMatcher = new AntPathMatcher();  
	@Test
	public void test() {
		String whiteURL="/ckfinder/**";
		String currentURL="/ckfinder/core/connector/java/connector.java";
		 if (pathMatcher.match(whiteURL, currentURL)) {  
        	 System.out.println("白名单匹配进入具体的控制 url filter : white url list matches : [{"+whiteURL+"}] match [{"+currentURL+"}] continue"); 
        }  
		 else System.out.println("nothing");
	}

}
