package com.example.parkminhyun.designpattern_seminar.screen;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parkminhyun.designpattern_seminar.R;
import com.example.parkminhyun.designpattern_seminar.common.base.BaseActivity;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainPageInterface.View{

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    private MainPageInterface.Presenter mainPresenter;

    @Override
    protected void initView() {
        mainTabBar.setTabIndex(0,true);
    }

    @Override
    protected void initPresenter() {
    }

    @Override
    public void updateBottomMenuButton() {

    }

    @Override
    protected void createPresenter() {
        mainPresenter = new MainPagePresenter(this);
    }

    @Override
    protected Activity getViews() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
