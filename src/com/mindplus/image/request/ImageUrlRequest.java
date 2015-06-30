package com.mindplus.image.request;

import java.lang.ref.WeakReference;

import android.R.mipmap;
import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.mindplus.view.LoadingImageView;

public class ImageUrlRequest {

	private ImageRequest mRequest;
	private String mUrl;
	private WeakReference<LoadingImageView> mImageReference;

	public ImageUrlRequest(LoadingImageView imageView, String url) {
		super();
		this.mImageReference = new WeakReference<LoadingImageView>(imageView);
		this.mUrl = url;
		init();
	}

	private void init() {
		
		mRequest = new ImageRequest(mUrl, new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				if (mImageReference.get() != null) {
					LoadingImageView imageView = mImageReference.get();
					if (imageView.getImageUrl().equals(mUrl)) {
						// 防止ListVIew中的多个引用
						imageView.setImageBitmap(response);
						if (imageView.getImageListener() != null) {
							(imageView.getImageListener()).onLoadingFinish();
						}
					}
				}
			}
		}, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

			}
		});
	}

	public ImageRequest getRequest() {
		return mRequest;
	}
}
