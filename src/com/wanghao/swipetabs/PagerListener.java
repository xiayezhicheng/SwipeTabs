package com.wanghao.swipetabs;

import java.util.ArrayList;

import android.graphics.Color;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;

public class PagerListener implements OnPageChangeListener {
    
    private ArrayList<View> tabArray = null;
    private final static String TAG = "PagerListener";
    private float pre = 0;
    
    public PagerListener(ArrayList<View> tabArray) {
        this.tabArray = tabArray;
    }
    
    @Override
    //有三种状态（0，1，2）。arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
    //当页面开始滑动的时候，三种状态的变化顺序为（1，2，0）

    public void onPageScrollStateChanged(int arg0) {
        Log.i(TAG, "onPageScrollStateChanged:" + Integer.toString(arg0));
    }

    @Override
    //这个方法是页面滚动的时候被调用，我们将在这个方法里完成对激活条的操作
    //arg0 :当前可见的第一个页的position
    //arg1:当前页面偏移的百分比
    //arg2:当前页面偏移的像素位置   230 126 34   211 84 0

    public void onPageScrolled(int arg0, float arg1, int arg2) {
        Log.i("当前页面", "onPageScrolled"+arg0);
        Log.i("以前偏移百分比pre", ""+pre);
        Log.i("当前页面偏移的百分比 arg1", String.valueOf(arg1));
        Log.i("当前页面偏移的像素位置 arg2", String.valueOf(arg2));
        
        switch(arg0){
	        case 0:
	        	tabArray.get(2).setBackgroundColor(Color.parseColor("#E67E22"));
	        	 if(pre<=arg1){
		             //向右滑动
	        		 tabArray.get(0).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	        		 tabArray.get(1).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	 pre = arg1;
	            }else{
	            	//向左滑动
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	tabArray.get(0).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	            	pre = arg1;
	            }
	        	break;
	        case 1:
	        	tabArray.get(0).setBackgroundColor(Color.parseColor("#E67E22"));
	        	if(pre<=arg1){
	            	//向右滑动
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	           	 	tabArray.get(2).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	pre = arg1;
	            }else{
	            	//向左滑动
	            	tabArray.get(2).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	            	pre = arg1;
	            }
	        	break;
        }
       
    }

    @Override
    //页面跳转完后得到调用，arg0是你当前选中的页面的Position（位置编号）
    public void onPageSelected(int arg0) {
        Log.i(TAG, "onPageSelected"+arg0);
        
//        //先将所有的tab设置成灰色的
//        for (View item : this.tabArray) {
//            item.setBackgroundColor(Color.parseColor("#E67E22"));
//        }
//        
//        //再将当前的tab设置成白色的，表示激活状态
//        tabArray.get(arg0).setBackgroundColor(Color.parseColor("#D35400"));
    }
}
