package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import android.app.AlertDialog;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

class ScreenFormat2 implements UserInfoScreenInterface {

    private MemberVO user;

    @Override
    public void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(App.getCurrentActivity());
        builder.setTitle(user.getName())
                .setMessage(user.getPhoneNum())
                .show();
    }

    @Override
    public boolean isShowing() {
        return false;
    }

    @Override
    public void update() {}

    @Override
    public void setContent(MemberVO memberVO) {
        this.user = memberVO;
    }
}
