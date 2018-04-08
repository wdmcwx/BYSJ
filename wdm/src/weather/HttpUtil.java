package weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtil {
	public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					//HttpURLConnection类是抽象类不能直接实例化对象，用UTL的openConnection()方法获取对象。
					//创建一个HTTP连接
					connection = (HttpURLConnection) url.openConnection();
					//使用openConnection()创建的HttpURLConnection对象，还没有真正的执行连接操作，只是刚刚创建一个新的实例对象，在连接之前，可以设置一些属性。
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);
					//获得服务器上读取的内容
					InputStream in = connection.getInputStream();
					//获取输入流对象
					BufferedReader reader =
							new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					//通过循环逐行读取输入流中的内容
					while ((line = reader.readLine()) != null) {
						response.append(line);		
					}
					if (listener != null) {
						// 回调 onFinish()方法
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener != null) {
						// 回调 onError()方法
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}