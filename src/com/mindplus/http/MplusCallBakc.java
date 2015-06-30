package com.mindplus.http;

import com.mindplus.protocol.ProtocalConstatant;

public class MplusCallBakc {

	public void onSuccess(THttpRequest request, Object result) {
		switch (request.mTransactionType) {
		case ProtocalConstatant.TRANSACTION_TYPE_LOGIN:
			onLoginSucess(request.id, result);
			break;

		default:
			break;
		}

	}

	public void onLoginSucess(int id, Object result) {
	};

	public void onLoginError(int id, Object result) {
	};
}
