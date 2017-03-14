package org.pub.sprcache;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheApiTest {
	
    //创建底层Cache  
    private static CacheManager ehcacheManager;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ehcacheManager = new CacheManager(new ClassPathResource("ehcache-setting.xml").getInputStream());
	}
    
	
	@Test
	public void testGet() {
	    Cache cacheTest = ehcacheManager.getCache("cacheTest");
	    cacheTest.put(new Element("key1","abc"));
	    Element e= cacheTest.get("key1");
	    String value =(String)e.getObjectValue();
	    assertEquals("abc",value);
	}
	
	@Test
	public void testSet() {
	    Cache cacheTest = ehcacheManager.getCache("cacheTest");
	    cacheTest.put(new Element("key1","abc"));
	}

}
