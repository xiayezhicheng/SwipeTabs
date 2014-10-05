package com.wanghao.swipetabs;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

public class TabListener implements OnClickListener {
    
    private ViewPager viewPager = null;
    
    public TabListener(ViewPager v) {
        this.viewPager = v;
    }
    
    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
        case R.id.btn_home:
            this.viewPager.setCurrentItem(0);
            break;
        case R.id.btn_contact:
            this.viewPager.setCurrentItem(1);
            break;
        case R.id.btn_center:
            this.viewPager.setCurrentItem(2);
            break;
        }
    }
}