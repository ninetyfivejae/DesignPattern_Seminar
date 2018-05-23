package com.example.parkminhyun.practice_seminar.common.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.parkminhyun.practice_seminar.App;
import com.example.parkminhyun.practice_seminar.common.enums.AnimationDirection;

import butterknife.ButterKnife;

/**
 * onCreate 등 Activity 마다 공통적으로 구현되는 부분의 중복 제거를 위한 BaseActivity.
 * Created by ParkMinHyun on 2018-05-11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        createPresenter();
        initActivity();
        initEnterAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setTopActivity();
    }

    @Override
    public void finish() {
        super.finish();
        initFinishAnimation();
    }

    private void initActivity() {
        //메인택티비티에서 구현을 해놓아서 R.layout.activity_main을 반환을 함
        setContentView(getLayout());

        ButterKnife.bind(getViews());
        setTopActivity();

        init();
    }

    private void setTopActivity() {
        App.setCurrentActivity(getViews());
    }

    /**
     * abstract 사용하지 않음으로써 View 초기화가 필요한 Activity만 Override할 수 있음.
     */
    protected AnimationDirection getAnimationDirection() {
        return AnimationDirection.LEFT;
    }

    protected void initEnterAnimation() {
//        overridePendingTransition(ScreenAnimationUtils.getEnterAnimationId(getAnimationDirection()),
//                ScreenAnimationUtils.getFinishAnimationId(getAnimationDirection()));
    }

    protected void initFinishAnimation() {
//        overridePendingTransition(ScreenAnimationUtils.getEnterAnimationId(getAnimationDirection()),
//                ScreenAnimationUtils.getFinishAnimationId(getAnimationDirection()));
    }

    /**
     * StartActivity 관련 Method
     */
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected void startActivity(String phoneNum){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        startActivity(intent);
    }

    protected void startActivityClearTop(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivityThenKill(Class<?> cls) {
        startActivityThenKill(cls, null);
    }

    protected void startActivityThenKill(Class<?> cls, Bundle bundle) {
        startActivity(cls, bundle);
        this.finish();
    }

    protected void showToastText(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    /**
     * 밑의 Method는 Activity 생성시 꼭 필요하기에 abstract로 구현.
     */
    protected abstract void init();

//    protected abstract void createPresenter();

    protected abstract Activity getViews();

    protected abstract int getLayout();

}
