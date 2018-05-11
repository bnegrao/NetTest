package com.bnegrao.NetTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxyResponse {
	private int responseCode;
	private Map<String, List<String>> responseHeaderFields;
	private String responseBody;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseHttpStatusCode) {
		this.responseCode = responseHttpStatusCode;
	}
	public Map<String, List<String>> getResponseHeaderFields() {
		return responseHeaderFields;
	}
	public void setResponseHeaderFields(Map<String, List<String>> responseHeaderFields) {
		// Remove the null key from the map before serializing it
		Map<String, List<String>> clone = new HashMap<String, List<String>>(responseHeaderFields);
		clone.remove(null);
		this.responseHeaderFields = clone;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}	
	
}
