package com.mindplus.image;

import android.graphics.Bitmap;

/**
 * @author lishang 针对接口编程，而不要针对对象编程
 * 
 */
public interface ImageAsyncCallback {

	public boolean onPreUiGetImage();

	public void onUiGetImage(Bitmap bitmap);

	public boolean isValid();

	public String onRedirectUrl(String originalUrl, String redirectUrl);

}