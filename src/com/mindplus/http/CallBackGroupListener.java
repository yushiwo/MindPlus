package com.mindplus.http;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class CallBackGroupListener {
	// 直接用作索引
	WeakHashMap<MplusCallBakc, Void> mCallbacks = new WeakHashMap<MplusCallBakc, Void>();
	private static CallBackGroupListener mAppGroupListener;

	private List<MplusCallBakc> mAppCallBakcs;

	public CallBackGroupListener() {
		mAppCallBakcs = new ArrayList<MplusCallBakc>();
	}

	public static CallBackGroupListener getInstance() {
		if (mAppGroupListener == null) {
			synchronized (CallBackGroupListener.class) {
				if (mAppGroupListener == null) {
					mAppGroupListener = new CallBackGroupListener();
				}
			}
		}
		return mAppGroupListener;
	}

	public synchronized void onSucess(THttpRequest request, Object result) {
		for (MplusCallBakc item : mAppCallBakcs) {
			item.onSuccess(request, result);
		}
	}
	public synchronized void onError(THttpRequest request, Object result) {
		for (MplusCallBakc item : mAppCallBakcs) {
			item.onSuccess(request, result);
		}
	}
	public void addCallBack(MplusCallBakc callBakc) {
		mAppCallBakcs.add(callBakc);
	}

	public void removeCallBack(MplusCallBakc callBakc) {
		mAppCallBakcs.remove(callBakc);
	}
}
