package weather;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.example.wdm.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
public class WeatherActivity extends Activity {
	private EditText ecCity;
	private ImageButton btnQuery;
	private ListView lvFutureWeather;
	public static final int SHOW_RESPONSE=1;
	private List<Weather> data;
	private Handler handler=new Handler(){
		public void handleMessage(Message msg){
			switch (msg.what) {
			case SHOW_RESPONSE:
				String response=(String )msg.obj;
				if(response!=null){
					parseWithJSON(response);
					WeatherAdapter weatherAdapter=new WeatherAdapter
							(WeatherActivity.this, 
									R.layout.activity_weather_listitem, data);
					lvFutureWeather.setAdapter(weatherAdapter);
					ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1);
					scaleAnimation.setDuration(1000);
					LayoutAnimationController animationController  =  new
							LayoutAnimationController(
									scaleAnimation, 0.6f);
					lvFutureWeather.setLayoutAnimation(animationController);

				}
				break;
			default:
				break;
			}
		}

		private void parseWithJSON(String response) {
			data=new ArrayList<Weather>();
			JsonParser parser=new JsonParser();//json解析器
			JsonObject obj=(JsonObject) parser.parse(response);
			Log.i("response---:",response);
			//获取返回状态吗
			String resultcode=obj.get("resultcode").getAsString();
			Log.i("resultcode---:",resultcode);
			//状态码如果是200说明数据返回成功
			if(resultcode!=null&&resultcode.equals("200")){
				//JSONObject和JSONArray把集合或者普通数据，转换成json格式的字符串
				JsonObject resultObj=obj.get("result").getAsJsonObject();
				JsonArray futureWeatherArray=resultObj.get("future").getAsJsonArray();
				for(int i=0;i<futureWeatherArray.size();i++){
					Weather  weather=new Weather();
					JsonObject weatherObject=futureWeatherArray.get(i).getAsJsonObject();
					weather.setDayOfWeek(weatherObject.get("week").getAsString());
					weather.setDate(weatherObject.get("date").getAsString());
					weather.setTemperature(weatherObject.get("temperature")
							.getAsString());
					weather.setWeather(weatherObject.get("weather")
							.getAsString());
					data.add(weather);
				}
			}
		}

	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_weather);
		initViews();
		send();

	}
	public void initViews(){
		lvFutureWeather=(ListView) findViewById(R.id.lvFutureWeather);
		 data=new ArrayList<Weather>();
	}
	
	public void send(){
		String cityName="";
		try {
			cityName = URLEncoder.encode("深圳", "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println("lvFutureWeather="+lvFutureWeather);
		String weatherUrl = "http://v.juhe.cn/weather/index?format=2&cityname="+cityName+"&key=b5f411acef0f42d500d1c459741db7ca";
		HttpUtil.sendHttpRequest(weatherUrl, new HttpCallbackListener() {

			public void onFinish(String response) {
				// TODO Auto-generated method stub
				Message message=new Message();
				message.what=SHOW_RESPONSE;
				//将服务器返回的结果存放到Message中
				message.obj=response.toString();
				handler.sendMessage(message);
			}
			public void onError(Exception e) {
				// TODO Auto-generated method stub
				System.out.println("访问失败");
			}
		});
	}
}

