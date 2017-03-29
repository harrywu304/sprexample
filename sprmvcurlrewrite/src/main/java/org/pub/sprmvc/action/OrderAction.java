/**
 * 
 */
package org.pub.sprmvc.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 订单Action
 * 
 * @author wuhuoxin 2016年11月23日 下午2:31:13
 *
 */
@Controller
public class OrderAction {

	private static Logger logger = LoggerFactory.getLogger(OrderAction.class);
	
	/**
	 * 查询指定交易的支付状态
	 * @return 已支付返回returnUrl,未支付返回空 
	 */
    @RequestMapping(value="/order/paystatus",method=RequestMethod.GET)
    @ResponseBody
    public String payStatusQuery(String payOrderId) {
    	String returnUrl = "http://www.baidu.com";
		return (returnUrl == null)?"":returnUrl;    	
    }   
    
	/**
	 * 访问收银台页面
	 *
	 * @return
	 */
	@RequestMapping({ "/counter/agent" })
	public ModelAndView viewPayCounter(@RequestParam(value="payid", required=false) String payOrderId, @RequestHeader("User-Agent") String userAgent) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("counter");
		
		mv.addObject("payOrderId", payOrderId);
		return mv;
	}
	
	/**
	 * 支付返回Json格式
	 *
	 * @return
	 */
	@RequestMapping({ "/dopay/json" })
	@ResponseBody
	public String doPayJson(@RequestAttribute String jsonString) {
		return jsonString;
	}

}
