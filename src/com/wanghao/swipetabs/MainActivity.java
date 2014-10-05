package com.wanghao.swipetabs;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    
    private ViewPager viewPager = null;
    
    //三个tab
    private View tab1 = null;
    private View tab2 = null;
    private View tab3 = null;//存放tab的数组
    private ArrayList<View> tabArray = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        this.initViewPager();
        this.initTab();
        this.setListener();
    
    }
    private void initTab() {
        this.tab1 = findViewById(R.id.btn_home);
        this.tab2 = findViewById(R.id.btn_contact);
        this.tab3 = findViewById(R.id.btn_center);
        
        this.tabArray = new ArrayList<View>();
        this.tabArray.add(tab1);
        this.tabArray.add(tab2);
        this.tabArray.add(tab3);
    }
    
    private void initViewPager() {
        //获取到ViewPager的实例
        this.viewPager = (ViewPager)findViewById(R.id.viewpager);
        
        //构造好存放Fragment的数组
        ArrayList<Fragment> fragmentArray = new ArrayList<Fragment>();
        fragmentArray.add(new Fragment1());
        fragmentArray.add(new Fragment2());
        fragmentArray.add(new Fragment3());
        
        //为ViewPager设置适配器
        this.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentArray));
        
        //设置当前显示的页面
        this.viewPager.setCurrentItem(0);
    }
    
    private void setListener() {
        TabListener tl = new TabListener(this.viewPager);
        
        this.tab1.setOnClickListener(tl);
        this.tab2.setOnClickListener(tl);
        this.tab3.setOnClickListener(tl);

        this.viewPager.setOnPageChangeListener(new PagerListener(this.tabArray));
    }

}