package httpUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

public class WebServicePost {

    private static String IP = "192.168.1.102:8080";

    // ͨ�� POST ��ʽ��ȡHTTP����������
    public static String executeHttpPost(String username, String password) {

        try {
            String path = "http://" + IP + "/HelloWeb/LogLet";

            // ����ָ�����Ϣ
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            params.put("password", password);

            return sendPOSTRequest(path, params, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ��������������
    private static String sendPOSTRequest(String path, Map<String, String> params, String encoding) throws Exception {

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, encoding);

        HttpPost post = new HttpPost(path);
        post.setEntity(entity);
        DefaultHttpClient client = new DefaultHttpClient();
        // ����ʱ
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        // ��ȡ��ʱ
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
        HttpResponse response = client.execute(post);

        // �ж��Ƿ�ɹ���ȡ��Ϣ
        if (response.getStatusLine().getStatusCode() == 200) {
            return getInfo(response);
        }

        // δ�ɹ���ȡ��Ϣ�����ؿ�ָ��
        return null;
    }

    // ��ȡ����
    private static String getInfo(HttpResponse response) throws Exception {

        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        // ��������ת��Ϊbyte��
        byte[] data = WebService.read(is);
        // ת��Ϊ�ַ���
        return new String(data, "UTF-8");
    }
}