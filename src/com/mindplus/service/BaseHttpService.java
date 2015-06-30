package com.mindplus.service;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mindplus.app.MindPlusApplication;
import com.mindplus.http.CallBackGroupListener;
import com.mindplus.http.MplusCallBakc;
import com.mindplus.http.THttpRequest;
import com.mindplus.protocol.ProtocalConstatant;

/**
 * @author lishang 主要处理String 字符串类的请求
 * 
 */
public class BaseHttpService {

	private static BaseHttpService mService;
	private CallBackGroupListener mGroupListener;
	private RequestQueue mVolleyQueue;

	public BaseHttpService() {
		mGroupListener = CallBackGroupListener.getInstance();
		mVolleyQueue = Volley.newRequestQueue(MindPlusApplication.getAppInstance());
		mVolleyQueue.start();
	}

	public static BaseHttpService getInstance() {
		if (mService == null) {
			synchronized (BaseHttpService.class) {
				if (mService == null) {
					mService = new BaseHttpService();
				}
			}
		}
		return mService;
	}

	public int doLogin() {

		String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk";
		THttpRequest rquest = new THttpRequest(Request.Method.GET, url, ProtocalConstatant.TRANSACTION_TYPE_LOGIN);
		startTransaction(rquest);
		return rquest.id;
	}

	private void startTransaction(THttpRequest request) {
		StringRequest req = request.getStringRequest();
		mVolleyQueue.add(req);
	}

	public void addCallBack(MplusCallBakc callBakc) {
		mGroupListener.addCallBack(callBakc);
	}

	public void removeCallBack(MplusCallBakc callBakc) {
		mGroupListener.removeCallBack(callBakc);
	}

	public void notifySucess(THttpRequest request, Object result) {
		mGroupListener.onSucess(request, result);
	}

	public void notifyError(THttpRequest request, Object result) {
		mGroupListener.onError(request, result);
	}
}
