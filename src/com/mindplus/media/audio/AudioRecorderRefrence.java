package com.mindplus.media.audio;

public class AudioRecorderRefrence {

	private AudioRecorderWrapper mAudioRecorderWrapper;
	private long mStartTime;
	private String mFilePath;

	/**
	 * 进来就录音，省的等待，浪费时间 也避免录音不完整
	 */
	public void startRecord() {

		mAudioRecorderWrapper = AudioRecorderWrapper.getInstance();
		mStartTime = System.currentTimeMillis();
		mFilePath = String.valueOf(System.currentTimeMillis());
		mAudioRecorderWrapper.setFilePath(mFilePath);
		MediaPlayerWrapper.getInstance().stop();// 停止播放
		mAudioRecorderWrapper.start();// 开始录音
	}
}
