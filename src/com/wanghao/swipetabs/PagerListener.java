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
    //������״̬��0��1��2����arg0 ==1��ʱ��Ĭʾ���ڻ�����arg0==2��ʱ��Ĭʾ��������ˣ�arg0==0��ʱ��Ĭʾʲô��û����
    //��ҳ�濪ʼ������ʱ������״̬�ı仯˳��Ϊ��1��2��0��

    public void onPageScrollStateChanged(int arg0) {
        Log.i(TAG, "onPageScrollStateChanged:" + Integer.toString(arg0));
    }

    @Override
    //���������ҳ�������ʱ�򱻵��ã����ǽ��������������ɶԼ������Ĳ���
    //arg0 :��ǰ�ɼ��ĵ�һ��ҳ��position
    //arg1:��ǰҳ��ƫ�Ƶİٷֱ�
    //arg2:��ǰҳ��ƫ�Ƶ�����λ��   230 126 34   211 84 0

    public void onPageScrolled(int arg0, float arg1, int arg2) {
        Log.i("��ǰҳ��", "onPageScrolled"+arg0);
        Log.i("��ǰƫ�ưٷֱ�pre", ""+pre);
        Log.i("��ǰҳ��ƫ�Ƶİٷֱ� arg1", String.valueOf(arg1));
        Log.i("��ǰҳ��ƫ�Ƶ�����λ�� arg2", String.valueOf(arg2));
        
        switch(arg0){
	        case 0:
	        	tabArray.get(2).setBackgroundColor(Color.parseColor("#E67E22"));
	        	 if(pre<=arg1){
		             //���һ���
	        		 tabArray.get(0).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	        		 tabArray.get(1).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	 pre = arg1;
	            }else{
	            	//���󻬶�
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	tabArray.get(0).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	            	pre = arg1;
	            }
	        	break;
	        case 1:
	        	tabArray.get(0).setBackgroundColor(Color.parseColor("#E67E22"));
	        	if(pre<=arg1){
	            	//���һ���
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	           	 	tabArray.get(2).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	pre = arg1;
	            }else{
	            	//���󻬶�
	            	tabArray.get(2).setBackgroundColor(Color.rgb((int) (230-19*arg1), (int)(126-42*arg1), (int)(34-34*arg1)));
	            	tabArray.get(1).setBackgroundColor(Color.rgb((int) (211+19*arg1), (int)(84+42*arg1), (int)(34*arg1)));
	            	pre = arg1;
	            }
	        	break;
        }
       
    }

    @Override
    //ҳ����ת���õ����ã�arg0���㵱ǰѡ�е�ҳ���Position��λ�ñ�ţ�
    public void onPageSelected(int arg0) {
        Log.i(TAG, "onPageSelected"+arg0);
        
//        //�Ƚ����е�tab���óɻ�ɫ��
//        for (View item : this.tabArray) {
//            item.setBackgroundColor(Color.parseColor("#E67E22"));
//        }
//        
//        //�ٽ���ǰ��tab���óɰ�ɫ�ģ���ʾ����״̬
//        tabArray.get(arg0).setBackgroundColor(Color.parseColor("#D35400"));
    }
}
