package com.bnegrao.NetTest;

import java.util.Map;

public class ProxyRequest {
	
	/**
	 * must be a valid URL string
	 * @see https://docs.oracle.com/javase/7/docs/api/java/net/URL.html
	 */
	private String url;
	
	private Map<String, String> params;
	
	private Map<String, String> requestHeaders;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Map<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(Map<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	
	
}
