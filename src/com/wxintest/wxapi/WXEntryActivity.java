package com.wxintest.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.mindplus.share.WXUtils;
import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.SendAuth;
import com.tencent.mm.sdk.openapi.SendMessageToWX;

/**
 * @author personal WXEntryActivity基本是用与微信毁掉结束而不是开始    
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

	private IWXAPI api;
	private Activity mActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		api = WXUtils.getWXApi();
		api.handleIntent(getIntent(), this);
		mActivity = this;

	}

	@Override
	public void onReq(BaseReq req) {

	}

	// 这个函数必要的处理
	@Override
	public void onResp(BaseResp resp) {

		if (resp != null && resp instanceof SendAuth.Resp) {

		} else if (resp != null && resp instanceof SendMessageToWX.Resp) {
			String trans = resp.transaction;
			if (!TextUtils.isEmpty(trans)) {
				boolean timeline = trans.charAt(0) == 'T'; // T 表示朋友圈，N表示一般朋友
				boolean success = resp.errCode == BaseResp.ErrCode.ERR_OK;
				Toast.makeText(mActivity, "分享成功", Toast.LENGTH_SHORT).show();

			}
		}
		finish();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		api.handleIntent(intent, this);
	}
}
