package com.mindplus.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.mindplus.R;
import com.mindplus.adapter.HomePagerAdapter;
import com.mindplus.view.TableSelectView;
import com.mindplus.view.TableSelectView.OnTableSelectListener;

public class MplusActivity extends MplusBaseAcvitiy {

	private ViewPager mViewPager;
	private TableSelectView mSelectView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mplus);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
		mSelectView = (TableSelectView) findViewById(R.id.select_container);
		mSelectView.setOnTableSelectListener(new OnTableSelectListener() {

			@Override
			public void onSelect(int index) {
				mViewPager.setCurrentItem(index);
				switch (index) {
				case 0:
					break;
				default:
					break;
				}
			}

			@Override
			public void onReSelcet() {

			}
		});
	}
}
