package com.example.parkminhyun.designpattern_seminar.screen;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.parkminhyun.designpattern_seminar.R;
import com.example.parkminhyun.designpattern_seminar.common.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
    }

    @Override
    protected void initPresenter() {
    }

    @Override
    protected void createPresenter() {
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
