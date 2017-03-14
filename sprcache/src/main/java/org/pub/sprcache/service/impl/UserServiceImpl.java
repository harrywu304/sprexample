package org.pub.sprcache.service.impl;

import org.pub.sprcache.bean.User;
import org.pub.sprcache.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Cacheable(value="cacheTest",key="#userId",unless="#result == null")
	@Override
	public User getUser(String userId) {
		System.out.println("do getUser");
		if("456".equals(userId)){
			return null;
		}
		User rt = new User();
		rt.setUserId(userId);
		rt.setName("harry");
		return rt;
	}

}
