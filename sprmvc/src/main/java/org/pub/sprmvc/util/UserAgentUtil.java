/**
 * 
 */
package org.pub.sprmvc.util;

/**
 * 用户终端平台类型工具类
 * @author wuhuoxin 2016年12月14日 下午6:59:22
 *
 */
public class UserAgentUtil {
	
	/**
	 * 判别用户是否移动端访问
	 * @param userAgent
	 * @return
	 */
	public static boolean isMobile(String userAgent){
		if(null != userAgent && userAgent.toLowerCase().indexOf("mobile") >0 ){
			return true;
		}
		return false;
	}
	
	/**
	 * 判别用户是否微信内访问
	 * @param userAgent
	 * @return
	 */
	public static boolean isWeixin(String userAgent){
		if(null != userAgent && userAgent.toLowerCase().indexOf("micromessenger") >0 ){
			return true;
		}
		return false;
	}

}
