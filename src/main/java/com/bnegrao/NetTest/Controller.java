package com.bnegrao.NetTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {

	@RequestMapping(method = RequestMethod.GET, value = "ping")
	public Pong ping() {
		return new Pong();
	}

	@RequestMapping(method = RequestMethod.POST, value = "proxyRequest")
	public ProxyResponse proxyRequest(@RequestBody ProxyRequest proxyRequest) throws IOException {

		URL url = new URL(proxyRequest.getUrl());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(proxyRequest.getMethod());
		con.setConnectTimeout(1000);
		con.setReadTimeout(1000);
		con.setInstanceFollowRedirects(false);
		con.setRequestProperty("Accept-Charset", "utf8");
		if (proxyRequest.getRequestHeaders() != null) {
			for (String reqHeader: proxyRequest.getRequestHeaders().keySet()) {
				con.addRequestProperty(reqHeader, proxyRequest.getRequestHeaders().get(reqHeader));
			}	
		}	
		
		ProxyResponse proxyResponse = new ProxyResponse();		
		
		try {
			proxyResponse.setResponseCode(con.getResponseCode());
			proxyResponse.setResponseMessage(con.getResponseMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		proxyResponse.setResponseHeaderFields(con.getHeaderFields());

		InputStream responseInputStream = null;
		
		if (200 <= con.getResponseCode() && con.getResponseCode() <= 299) {
			responseInputStream = con.getInputStream();
		} else {
			responseInputStream = con.getErrorStream();		
		}		
		
		if (responseInputStream != null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(responseInputStream));
			
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			proxyResponse.setResponseBody(content.toString());		
			
			in.close();
		}

		con.disconnect();
		
		return proxyResponse;
	}

}
