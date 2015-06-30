package com.mindplus.image;

import java.lang.ref.WeakReference;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * @author lishang 针对接口编程，而不要针对对象编程
 * 
 */
public class ImageViewAsyncCallback implements ImageAsyncCallback {

	private String mUrl;
	private ImageAsyncCallback mCallback;

	public String getUrl() {
		return mUrl;
	}

	private WeakReference<ImageView> mImgReference;

	public ImageViewAsyncCallback(ImageView imageView, ImageAsyncCallback callback, String url) {
		this.mImgReference = new WeakReference<ImageView>(imageView);
		this.mUrl = url;
		this.mCallback=callback;
		imageView.setTag(this);
		setImageUrl(url);
	}

	public void setImageUrl(String url) {

		ImageManager.getInstance().setImage(this, url);
		if (mCallback != null) {
			mCallback.onPreUiGetImage();
		}
	}

	@Override
	public boolean onPreUiGetImage() {
		return false;
	}

	@Override
	public void onUiGetImage(Bitmap bitmap) {
		if (isValid()) {
			if (mImgReference.get() != null) {
				if (mCallback != null) {
					mCallback.onUiGetImage(bitmap);
				}
				mImgReference.get().setImageBitmap(bitmap);
			}
		}
	}

	@Override
	public boolean isValid() {
		if (mImgReference.get() != null) {
			return mImgReference.get().getTag() == this;
		}
		return false;
	}

	@Override
	public String onRedirectUrl(String originalUrl, String redirectUrl) {
		return null;
	}
}