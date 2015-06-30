package com.mindplus.http;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.ClientError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mindplus.service.BaseHttpService;

/**
 * @author lishang最简单的字符串请求 返回可以不是Json格式
 * 
 */
public class THttpRequest {

	private static short NextRequestID;
	public int id;
	public int mTransactionType;
	private StringRequest stringRequest;

	public StringRequest getStringRequest() {
		return stringRequest;
	}

	public synchronized static int getNextRequestID() {
		if (NextRequestID >= Short.MAX_VALUE) {
			NextRequestID = 0;
		}

		return ++NextRequestID;
	}

	public THttpRequest(int metheodType, String url, int transactionType) {
		mTransactionType = transactionType;
		id = getNextRequestID();
		stringRequest = new StringRequest(metheodType, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				// 不同的数据如何处理

				BaseHttpService.getInstance().notifySucess(THttpRequest.this, response);

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				if (error instanceof NetworkError) {
				} else if (error instanceof ClientError) {
				} else if (error instanceof ServerError) {
				} else if (error instanceof AuthFailureError) {
				} else if (error instanceof ParseError) {
				} else if (error instanceof NoConnectionError) {
				} else if (error instanceof TimeoutError) {
				}
				BaseHttpService.getInstance().notifyError(THttpRequest.this, error);

			}
		});
	}

}
