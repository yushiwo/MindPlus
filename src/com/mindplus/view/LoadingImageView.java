package com.mindplus.view;

import com.mindplus.image.ImageManager;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class LoadingImageView extends ImageView {
	
	// 用作标识
	private String mImageUrl;
	private String mTitle;
	private ILoadingImageListener mImageListener;

	public String getImageUrl() {
		return mImageUrl;
	}

	public LoadingImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public LoadingImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LoadingImageView(Context context) {
		super(context);
	}

	public void setImageUrl(String url) {
		mImageUrl = url;
		ImageManager.getInstance().setImage(this, url);
		if (mImageListener != null) {
			mImageListener.onStartLoading();
		}
	}

	public interface ILoadingImageListener {
		void onStartLoading();

		void onLoadingFinish();
	}

	public void setLoadingListener(ILoadingImageListener listener) {
		mImageListener = listener;
	}

	public ILoadingImageListener getImageListener() {
		return mImageListener;
	}
}
