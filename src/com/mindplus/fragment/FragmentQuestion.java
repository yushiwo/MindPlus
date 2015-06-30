package com.mindplus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mindplus.R;

public class FragmentQuestion extends FragmentBase {

	public static FragmentBase newInstance(String tag) {
		FragmentQuestion mFragment = new FragmentQuestion();
		Bundle bundle = new Bundle();

		mFragment.setArguments(null);
		return mFragment;
	}

	private FragmentActivity mActivity;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mActivity = getActivity();
		View rootView = inflater.inflate(R.layout.fragment_question, null);
		return rootView;
	}
}
