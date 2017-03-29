package org.pub.sprmvc.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/app" })
public class AppAction {
	
	private static Logger logger = LoggerFactory.getLogger(AppAction.class);
	
	@RequestMapping({ "/list" })
	public ModelAndView appList(String username) {
		ModelAndView mv = new ModelAndView();
		logger.debug("appList...");
		//mv.setViewName("counter");

		mv.addObject("username", username);
		return mv;
	}

}
