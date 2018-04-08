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
 * 2017-5-17 �����࣬ͨ��URL����һ����Ӧ��html
 * 
 * @author tom
 */
public class AbstractSpider {

	public static String getResult(String url) throws Exception {

		try{
			//��ʼ������httpClient����
			HttpClient httpClient = HttpClientBuilder.create().build();
			//��ȡָ��ҳ�����Ϣ
			HttpResponse response = httpClient.execute(new HttpGetConfig(url));
			//������ת���ַ������
			String result = EntityUtils.toString(response.getEntity());
			//�����ַ���
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("��ȡʧ��");
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
