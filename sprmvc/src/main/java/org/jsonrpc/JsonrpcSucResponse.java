/**
 * 
 */
package org.jsonrpc;

/**
 * Json rpc 成功返回对象
 * @author wuhuoxin 2016年12月2日 下午4:56:52
 *
 */
public class JsonrpcSucResponse<T> extends JsonrpcResponse{
	
	/**
	 * 返回结果
	 */
	private T result;

	/**
	 * @param id
	 * @param result
	 */
	public JsonrpcSucResponse(String id, T result) {
		super();
		super.setId(id);
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}
}
