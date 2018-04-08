package com.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * 2017-5-17 基础类，通过URL返回一个响应的html
 * 
 * @author tom
 */
public class AbstractSpider {

	public static String getResult(String url) throws Exception {

		try{
			//初始化创建httpClient对象
			HttpClient httpClient = HttpClientBuilder.create().build();
			//获取指定页面的信息
			HttpResponse response = httpClient.execute(new HttpGetConfig(url));
			//将对象转成字符串输出
			String result = EntityUtils.toString(response.getEntity());
			//返回字符串
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取失败");
			return "";
		}
	}
}

class HttpGetConfig extends HttpGet {
	public HttpGetConfig(String url) {
		super(url);
		setDefaulConfig();
	}

	private void setDefaulConfig() {
		this.setConfig(RequestConfig.custom()
				.setConnectionRequestTimeout(10000)
				.setConnectTimeout(10000)
				.setSocketTimeout(10000).build());
		this.setHeader("User-Agent", "spider");
	}
}
