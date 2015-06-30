package com.mindplus.cache;

public class HttpCacheManager {

	private static HttpCacheManager manager;

	private HttpCacheManager() {
	}

	public static HttpCacheManager getInstance() {
		if (manager == null) {
			synchronized (HttpCacheManager.class) {
				if (manager == null) {
					manager = new HttpCacheManager();
				}
			}
		}
		return manager;
	}

	public void addCache(String url, StoreFile mFile) {

	}

	public StoreFile getCache(String url) {
		return null;
	}
}
