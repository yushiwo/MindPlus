package com.mindplus.fragment;

import com.mindplus.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentAssistance extends FragmentBase {

	private Activity mActivity;

	public static FragmentAssistance newInstance(String tag) {
		FragmentAssistance mFragment = new FragmentAssistance();
		Bundle bundle = new Bundle();

		mFragment.setArguments(null);
		return mFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mActivity = getActivity();
		View rootView = inflater.inflate(R.layout.fragment_answers, null);
		return rootView;
	}
}
