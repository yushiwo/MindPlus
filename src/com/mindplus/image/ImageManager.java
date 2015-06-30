package com.mindplus.image;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.mindplus.app.MindPlusApplication;
import com.mindplus.image.request.ImageAsynRequest;
import com.mindplus.image.request.ImageUrlRequest;
import com.mindplus.service.BaseHttpService;
import com.mindplus.view.LoadingImageView;

public class ImageManager {

	private static ImageManager mManager;
	private RequestQueue mVolleyQueue;

	public ImageManager() {
		mVolleyQueue = Volley.newRequestQueue(MindPlusApplication.getAppInstance());
		mVolleyQueue.start();
	}

	public static ImageManager getInstance() {
		if (mManager == null) {
			synchronized (BaseHttpService.class) {
				if (mManager == null) {
					mManager = new ImageManager();
				}
			}
		}
		return mManager;
	}

	public void setImage(LoadingImageView imageView, String url) {
		ImageUrlRequest request = new ImageUrlRequest(imageView, url);
		mVolleyQueue.add(request.getRequest());
	}

	public void setImage(ImageViewAsyncCallback imageView, String url) {
		ImageAsynRequest request = new ImageAsynRequest(imageView, url);
		mVolleyQueue.add(request.getRequest());
	}
}
