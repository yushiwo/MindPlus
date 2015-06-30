package com.mindplus.app;

import android.app.Application;

import com.mindplus.service.BaseHttpService;

public class MindPlusApplication extends Application {

	private static Application mApplicatioContext;

	public MindPlusApplication() {
		super();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mApplicatioContext = this;
		initConfig();
	}

	// initial application
	private void initConfig() {
		// 初始化服务
		BaseHttpService.getInstance();
	}

	public static Application getAppInstance() {
		if (mApplicatioContext == null)
			throw new NullPointerException("Appliaction not create or be terminated!");
		return mApplicatioContext;
	}
}
