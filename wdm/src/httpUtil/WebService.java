package httpUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {

    private static String IP = "192.168.1.105:8080";
    
    public static String executeHttpGet_UserInfo(String username, String password) {

        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/UserInfo";
            path = path + "?username=" + username + "&password=" + password;
            
            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000); // ���ó�ʱʱ��
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
    
    // ͨ��Get��ʽ��ȡHTTP����������
    public static String executeHttpGet(String tag) {

        HttpURLConnection conn = null;
        InputStream is = null;

        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/Jsoup_request";
            path = path + "?tag=" + tag ;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000); // ���ó�ʱʱ��
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
   

    // ͨ��Get��ʽ��ȡHTTP����������
    public static String executeHttpGet(String username, String password,String tag) {

        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/LogLet";
            path = path + "?username=" + username + "&password=" + password+ "&tag=" + tag;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000); // ���ó�ʱʱ��
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
 // ͨ��Get��ʽ��ȡHTTP����������
    public static String executeHttpGet_all(String tag) {

        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/Gonglue_servlet";
            path = path + "?tag=" + tag;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000); // ���ó�ʱʱ��
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
    // ͨ��Get��ʽ��ȡHTTP����������
    public static String executeHttpGet2(String username,String article) {

        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            // �û��� ����
            // URL ��ַ
            String path = "http://" + IP + "/HelloWeb/SaveArticle";
            path = path + "?username=" + username + "&article=" + article;

            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000); // ���ó�ʱʱ��
            conn.setReadTimeout(5000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET"); // ���û�ȡ��Ϣ��ʽ
            conn.setRequestProperty("Charset", "UTF-8"); // ���ý������ݱ����ʽ

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // �����˳�ʱ�������ӹرձ���
            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }
    

    // ��������ת��Ϊ String �� 
    private static String parseInfo(InputStream inStream) throws Exception {
        byte[] data = read(inStream);
        // ת��Ϊ�ַ���
        return new String(data, "UTF-8");
    }

    // ��������ת��Ϊbyte�� 
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}