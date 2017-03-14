/**
 * 
 */
package org.pub.sprmvc.action;

import org.jsonrpc.JsonrpcFailResponse;
import org.jsonrpc.JsonrpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * 错误处理Action
 * 
 * @author wuhuoxin 2016年12月5日 下午6:04:07
 *
 */
@Controller
public class ErrorAction {
	
	private static Logger logger = LoggerFactory.getLogger(ErrorAction.class);
	
	/**
	 * 服务器异常
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/error_400", produces = "application/json")
	@ResponseBody
	public JsonrpcResponse error_400() {
		return new JsonrpcFailResponse("", 400, "无效参数");
	}
	
	/**
	 * 请求异常
	 * 
	 * @return
	 * @throws Exception
	 *             String
	 */
	@RequestMapping(value = "/error_404", produces = "application/json")
	@ResponseBody
	public JsonrpcResponse error_404() {
		return new JsonrpcFailResponse("", 404, "找不到页面");
	}

	/**
	 * 服务器异常
	 * 
	 * @return String
	 */
	@RequestMapping(value = "/error_500", produces = "application/json")
	@ResponseBody
	public JsonrpcResponse error_500(WebRequest request) {
		Throwable e = (Throwable)request.getAttribute("javax.servlet.error.exception", WebRequest.SCOPE_REQUEST);
		logger.error("error_500 ",e);
		return new JsonrpcFailResponse("", 500, "服务器内部异常");
	}
}
