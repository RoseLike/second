package com.Downloading;

import java.io.IOException;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownLoadUtils {
	public static String getJsonString(String url){
		Log.d("hee","========"+url);
		String jString = "";
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		try {
			Response response = client.newCall(request).execute();
			jString = response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("winter", "-----Utils--jsonString------" + jString);
		return jString;
		
	}
	public static byte[] getImageByte(String url){
		byte[] imageByte = null;
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		try {
			Response response = client.newCall(request).execute();
			imageByte = response.body().bytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("winter", "------Utils--jsonImage------" + imageByte);
		return imageByte;
		
	}
}
