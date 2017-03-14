/**
 *
 */
package org.jsonrpc;

import java.util.HashMap;
import java.util.Map;

/**
 * Json rpc 失败返回对象
 * @author wuhuoxin 2016年12月2日 下午4:56:52
 *
 */
public class JsonrpcFailResponse extends JsonrpcResponse{

	/**
	 * 返回结果
	 */
	private Map<String,Object> error;

	/**
	 * @param id
	 * @param result
	 */
	public JsonrpcFailResponse(String id, int code, String message) {
		super();
		super.setId(id);
		error = new HashMap<String,Object>();
		error.put("code", code);
		error.put("message", message);
	}

	/**
	 * @return the error
	 */
	public Map getError() {
		return error;
	}



	/**
	 * @param error the error to set
	 */
	public void setError(Map error) {
		this.error = error;
	}


}
