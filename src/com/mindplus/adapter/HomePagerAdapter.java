package com.mindplus.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mindplus.fragment.FragmentAssistance;
import com.mindplus.fragment.FragmentBase;
import com.mindplus.fragment.FragmentQuestion;

public class HomePagerAdapter extends FragmentPagerAdapter {

	/**
	 * Fragment 数目
	 */
	private static final int TAB_COUNT = 2;

	public interface IHomeIndex {
		int QUESTION = 0;
		int ANSWERS = 1;
	}

	public HomePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		FragmentBase fragment = null;
		switch (index) {
		case IHomeIndex.QUESTION:
			fragment = FragmentQuestion.newInstance("");
			break;
		case IHomeIndex.ANSWERS:
			fragment = FragmentAssistance.newInstance("");
			break;
		default:
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return TAB_COUNT;
	}

}
