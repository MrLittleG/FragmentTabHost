package com.androidtest.littleg.fragmenttabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.androidtest.littleg.fragmenttabhost.bean.Tab;
import com.androidtest.littleg.fragmenttabhost.fragment.HomeFragment;
import com.androidtest.littleg.fragmenttabhost.fragment.MyFragment;
import com.androidtest.littleg.fragmenttabhost.fragment.ShopcarFragment;
import com.androidtest.littleg.fragmenttabhost.fragment.TypeFragment;
import com.androidtest.littleg.fragmenttabhost.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


private List <Tab> mTab= new ArrayList<>(4);

    private FragmentTabHost mTabhost;

    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);





        initTab();

    }

    private void initTab() {
        Tab tab_home = new Tab(R.drawable.selector_icon_home,R.string.home,HomeFragment.class);

        Tab tab_type = new Tab(R.drawable.selector_icon_type,R.string.type,TypeFragment.class);

        Tab tab_shopcar = new Tab(R.drawable.selector_icon_shopcar,R.string.shopcar,ShopcarFragment.class);

        Tab tab_my = new Tab(R.drawable.selector_icon_my,R.string.my, MyFragment.class);

        mTab.add(tab_home);
        mTab.add(tab_type);
        mTab.add(tab_shopcar);
        mTab.add(tab_my);




        mInflater =  LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        for(Tab tab : mTab){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTittle()));

            tabSpec.setIndicator(buildIndicator(tab));

            mTabhost.addTab(tabSpec, tab.getFragment(),null);
        }


        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);



    }
    private View buildIndicator(Tab tab){

        View view = mInflater.inflate(R.layout.tab_indicator,null);

        ImageView img = (ImageView) view.findViewById(R.id.tab_img);

        img.setBackgroundResource(tab.getImage());

        TextView textview = (TextView) view.findViewById(R.id.tab_text);

        textview.setText(tab.getTittle());

        return view;
    }
}
