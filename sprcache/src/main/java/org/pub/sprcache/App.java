package org.pub.sprcache;


import org.pub.sprcache.bean.User;
import org.pub.sprcache.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UserService userServie = context.getBean(UserService.class);
    	User user = userServie.getUser("123");
    	System.out.println(user);
    	user = userServie.getUser("123");
    	System.out.println(user);
    	user = userServie.getUser("456");
    	System.out.println(user);
    	user = userServie.getUser("456");
    	System.out.println(user);    	
    }
    
}
