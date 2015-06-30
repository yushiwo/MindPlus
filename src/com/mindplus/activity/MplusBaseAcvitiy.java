package com.mindplus.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.mindplus.R;

public class MplusBaseAcvitiy extends FragmentActivity {

	private Activity mActivity;
	private ProgressDialog mWaitingProgress;
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mWaitingProgress = new ProgressDialog(this);
		mActivity = this;
		mActionBar = getActionBar();
		setUpActionBar();
	}

	protected void showWatting(String title, String message) {
		if (mWaitingProgress != null)
			stopWaiting();

		mWaitingProgress = ProgressDialog.show(mActivity, title, message, true, true);
		mWaitingProgress.setCanceledOnTouchOutside(false);
	}

	protected void showWatting(String title, String message, boolean cancle) {
		if (mWaitingProgress != null)
			stopWaiting();

		mWaitingProgress = ProgressDialog.show(mActivity, title, message, true, true);
		mWaitingProgress.setCancelable(cancle);
		mWaitingProgress.setCanceledOnTouchOutside(false);
	}

	protected void stopWaiting() {
		if (mWaitingProgress != null) {
			mWaitingProgress.dismiss();
			mWaitingProgress = null;
		}
	}

	private void setUpActionBar() {
		mActionBar.setCustomView(R.layout.customed_action_bar);
	}

	public TextView getCustomeActionBarLeftTextView() {
		TextView textView = (TextView) findViewById(R.id.left);
		return textView;
	}

	public TextView getCustomeActionBarMiddleTextView() {
		TextView textView = (TextView) findViewById(R.id.middle);
		return textView;
	}

	public TextView getCustomeActionBarRightTextView() {
		TextView textView = (TextView) findViewById(R.id.right);
		return textView;
	}
}
