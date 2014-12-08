package com.wanghao.swipetabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager{

	private boolean isCanScroll;
	
	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.myviewpager);
		isCanScroll = typedArray.getBoolean(R.styleable.myviewpager_iscanscroll, true);
		typedArray.recycle();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		return isCanScroll&&super.onTouchEvent(event);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		
		return isCanScroll&&super.onInterceptTouchEvent(arg0);
	}

	public void setCanScroll(boolean isCanScroll){
		this.isCanScroll = isCanScroll;
	}
}
