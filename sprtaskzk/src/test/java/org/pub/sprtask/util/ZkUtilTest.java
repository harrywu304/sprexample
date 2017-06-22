package org.pub.sprtask.util;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration ({"/applicationContext.xml"})
//在spring-mvc中增加mvc:resources配置后需要@WebAppConfiguration
//@WebAppConfiguration(value = "src/main/webapp") 
public class ZkUtilTest {
	
	@Resource
	private ZkUtil zkUtil;

	@Test
	public void testCreateNode() throws UnsupportedEncodingException, InterruptedException {
		//assertTrue(zkUtil.createNode("/testnode", "abc".getBytes("utf8")));
		assertTrue(zkUtil.createNode("/manlock", "8912@ZY-20160907TPKV".getBytes("utf8")));
		Thread.sleep(10000);
	}

	@Test
	public void testDeleteNode() {
		//zkUtil.deleteNode("/testnode");
	}

}
