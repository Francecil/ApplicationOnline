package com.france.service.impl;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.france.util.ConvertUtil;

public class SimpleTest {

	@Test
	public void test() {
		ConvertUtil.getUUID();
	}
	@Test
	public void encodeSet(){
		String sb="asdjkqw.action";
		try {
			System.out.println(new String(sb.getBytes("iso8859-1"),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
