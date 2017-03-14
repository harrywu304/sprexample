/**
 * 
 */
package org.pub.sprmvc.action;

import java.util.HashMap;
import java.util.Map;

import org.jsonrpc.JsonrpcFailResponse;
import org.jsonrpc.JsonrpcResponse;
import org.jsonrpc.JsonrpcSucResponse;
import org.pub.sprmvc.util.UserAgentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
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
	
	@Value("${isDebugMode}")
	private boolean isDebugMode;
	
    /**
     * 收单接口
     * @param payOrder
     * @return
     */
    @RequestMapping(value="/order",method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public JsonrpcResponse order(String id, String version, WebRequest request) {
    	logger.debug("request id:{}", id);	
    	JsonrpcResponse rt = new JsonrpcResponse();
    	
    	//检查签名
    	if(id == null && !isDebugMode){
	    		//不合法
	    		return new JsonrpcFailResponse(id, 4011, "无效签名");
    	}
    	//构建JsonrpcSucResponse
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put("payOrderId", "123456");
    	result.put("counterUrl", "http://www.baidu.com");
    	rt = new JsonrpcSucResponse<Map>(id,result);
        return rt;
    }
    
    
    
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
		
		if(UserAgentUtil.isMobile(userAgent)){
			mv.setViewName("forward:/dopay/json");
		}
		
		if(UserAgentUtil.isWeixin(userAgent)){
			String redirectUrl = "http://www.baidu.com?h5url=abc";
			mv.setViewName("redirect:"+redirectUrl);
		}
		
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
