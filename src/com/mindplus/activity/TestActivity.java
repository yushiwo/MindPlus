package com.mindplus.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.text.TextUtils;
import android.widget.TextView;

import com.mindplus.R;
import com.mindplus.http.MplusCallBakc;
import com.mindplus.http.THttpRequest;
import com.mindplus.service.BaseHttpService;
import com.mindplus.utils.ToastUtils;
import com.mindplus.view.CircleImageView;
import com.mindplus.view.ProgressLoadingImageView;

public class TestActivity extends MplusBaseAcvitiy {

	TextView mTextView;
	private ProgressLoadingImageView mImageView;

	public static void startActivity(Context context) {
		Intent intent = new Intent(context, TestActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		mTextView = (TextView) findViewById(R.id.textView1);
		// BaseHttpService.getInstance().addCallBack(mplusCallBakc);
		// BaseHttpService.getInstance().doLogin();

		mImageView = (ProgressLoadingImageView) findViewById(R.id.image);
		mImageView.setImageUrl("http://yimg.nos.netease.com/images/rank/v1062");

		CircleImageView mCircleImageView = (CircleImageView) findViewById(R.id.circle_img);
		mCircleImageView.setImageURI("http://yimg.nos.netease.com/images/rank/v1062");
		// showWatting("", "请等待。。。");
	}

	private MplusCallBakc mplusCallBakc = new MplusCallBakc() {
		public void onLoginSucess(int id, Object result) {
			stopWaiting();
			if (result instanceof String) {

				// // 不同的数据如何处理
				// try {
				// JSONObject object = new JSONObject((String) response);
				// BaseHttpService.getInstance().notifySucess(THttpRequest.this,
				// object);
				// } catch (JSONException exception) {
				// BaseHttpService.getInstance().notifyError(THttpRequest.this,
				// response);
				// }

				// 解析
				// JSONObject jObject = (JSONObject) result;
				mTextView.setText((CharSequence) result);
				// 检查是否返回错误
				// String errcode = jObject.optString("errcode");
				// String errmsg = jObject.optString("errmsg");
				// 返回错误码
			}
		}

		public void onLoginError(int id, Object result) {

		};

	};
}
