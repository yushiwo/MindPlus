package com.mindplus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TableSelectView extends LinearLayout {

	public TableSelectView(Context context) {
		super(context);
	}

	public TableSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TableSelectView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		int count = getChildCount();
		for (int i = 0; i < count; i++) {
			View view = getChildAt(i);
			view.setTag(new Integer(i));
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (mOnTableSelect != null) {
						Integer index = (Integer) v.getTag();
						mOnTableSelect.onSelect(index.intValue());
					}
				}
			});
		}
	}

	private OnTableSelectListener mOnTableSelect;

	public void setOnTableSelectListener(OnTableSelectListener listener) {
		mOnTableSelect = listener;
	}

	public interface OnTableSelectListener {
		void onSelect(int index);

		void onReSelcet();
	}
}
