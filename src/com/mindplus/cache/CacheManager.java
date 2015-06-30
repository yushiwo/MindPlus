package com.mindplus.cache;

public class CacheManager {

	private static CacheManager mCacheManager;
	public static String FileCacheSDCardPrefix = "/mindplus";

	private CacheManager() {
	}

	public static CacheManager getInstance() {
		if (mCacheManager == null) {
			synchronized (CacheManager.class) {
				if (mCacheManager == null) {
					mCacheManager = new CacheManager();

				}
			}
		}
		return mCacheManager;
	}

	public void clear() {

	}

	public void insert() {

	}
}
