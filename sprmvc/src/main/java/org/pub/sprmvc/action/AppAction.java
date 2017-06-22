package org.pub.sprmvc.action;

import java.util.ArrayList;
import java.util.List;

import org.pub.sprmvc.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/app" })
public class AppAction {
	
	private static Logger logger = LoggerFactory.getLogger(AppAction.class);
	
	@RequestMapping({ "/list" })
	public ModelAndView appList(User user) {
		ModelAndView mv = new ModelAndView();
		logger.debug("appList...");
		//mv.setViewName("counter");
		mv.addObject("user1", user);
		mv.addObject("user2", user);
		return mv;
	}
	
	@RequestMapping({ "/list2" })
	@ResponseBody
	public List<String> appList2(String username) {
		List<String> rt = new ArrayList<String>();
		logger.debug("appList...");
		//mv.setViewName("counter");

		rt.add(username);
		return rt;
	}

}
