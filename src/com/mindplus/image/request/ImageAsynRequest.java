package com.mindplus.image.request;

import java.lang.ref.WeakReference;

import android.graphics.Bitmap;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.mindplus.image.ImageViewAsyncCallback;

public class ImageAsynRequest {

	private ImageRequest mRequest;
	private String mUrl;
	private WeakReference<ImageViewAsyncCallback> mImageReference;

	public ImageAsynRequest(ImageViewAsyncCallback callbakc, String url) {
		super();
		this.mImageReference = new WeakReference<ImageViewAsyncCallback>(callbakc);
		this.mUrl = url;
		init();
	}

	private void init() {

		mRequest = new ImageRequest(mUrl, new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				if (mImageReference.get() != null) {
					ImageViewAsyncCallback callback = (ImageViewAsyncCallback) mImageReference.get();
					callback.onUiGetImage(response);
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
