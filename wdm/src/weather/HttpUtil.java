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
					//HttpURLConnection���ǳ����಻��ֱ��ʵ����������UTL��openConnection()������ȡ����
					//����һ��HTTP����
					connection = (HttpURLConnection) url.openConnection();
					//ʹ��openConnection()������HttpURLConnection���󣬻�û��������ִ�����Ӳ�����ֻ�Ǹոմ���һ���µ�ʵ������������֮ǰ����������һЩ���ԡ�
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);
					//��÷������϶�ȡ������
					InputStream in = connection.getInputStream();
					//��ȡ����������
					BufferedReader reader =
							new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					//ͨ��ѭ�����ж�ȡ�������е�����
					while ((line = reader.readLine()) != null) {
						response.append(line);		
					}
					if (listener != null) {
						// �ص� onFinish()����
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener != null) {
						// �ص� onError()����
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