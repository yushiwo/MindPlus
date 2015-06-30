package com.mindplus.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.mindplus.view.LoadingImageView.ILoadingImageListener;

public class ProgressLoadingImageView extends FrameLayout {

	private LoadingImageView mImageView;
	private ProgressBar mProgressBar;

	public ProgressLoadingImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		renderView();
	}

	public ProgressLoadingImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		renderView();
	}

	public ProgressLoadingImageView(Context context) {
		super(context);
		renderView();
	}

	public void setImageUrl(String mImageUrl) {
		mImageView.setImageUrl(mImageUrl);
	}

	private void renderView() {
		mImageView = new LoadingImageView(getContext());
		mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
		mProgressBar = new ProgressBar(getContext());
		FrameLayout.LayoutParams lParams1 = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		addView(mImageView, lParams1);

		FrameLayout.LayoutParams lParams = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		lParams.gravity = Gravity.CENTER;

		addView(mProgressBar, lParams);
		mImageView.setLoadingListener(new ILoadingImageListener() {

			@Override
			public void onStartLoading() {
				mProgressBar.setVisibility(View.VISIBLE);
			}

			@Override
			public void onLoadingFinish() {
				mProgressBar.setVisibility(View.GONE);

			}
		});
	}
}
