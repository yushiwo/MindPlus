package com.mindplus.share;

import java.util.Random;

import android.widget.Toast;

import com.mindplus.app.MindPlusApplication;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;

public class WXUtils {

	// 如果没有APP_ID就无法调动起来
	private static String WEIXIN_APPID = "wxac68b0cdb0b5269e";
	private static IWXAPI mIwxapi;

	public static IWXAPI getWXApi() {
		if (mIwxapi == null) {
			mIwxapi = WXAPIFactory.createWXAPI(MindPlusApplication.getAppInstance(), WEIXIN_APPID, true);
			if (mIwxapi.isWXAppInstalled()) {
				mIwxapi.registerApp(WEIXIN_APPID);
			}
		}
		return mIwxapi;
	}

	public static boolean isWeiXInInstalled() {
		return getWXApi().isWXAppInstalled();
	}

	public static void sendTextMesage(String msg) {

		if (isWeiXInInstalled()) {
			mIwxapi = getWXApi();
			WXTextObject object = new WXTextObject();
			object.text = msg;

			WXMediaMessage mMediaMessage = new WXMediaMessage();
			mMediaMessage.title = MindPlusApplication.getAppInstance().getPackageName();
			mMediaMessage.description = msg + " " + (new Random().nextInt(100));
			mMediaMessage.mediaObject = object;

			SendMessageToWX.Req req = new SendMessageToWX.Req();
			req.message = mMediaMessage;
			req.transaction = String.valueOf(System.currentTimeMillis());
			mIwxapi.sendReq(req);
		} else {
			Toast.makeText(MindPlusApplication.getAppInstance(), "未安装微信", Toast.LENGTH_SHORT).show();

		}
	}
}
