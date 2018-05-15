package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

class ScreenFormat1 implements UserInfoScreenInterface {
    @Override
    public void show() {

    }

    @Override
    public boolean isShowing() {
        // activity면 activity
        // fragment면 fragment
        // dialog면 dialog 각각의 showing() 호출하기.
        return false;
    }

    @Override
    public void update() {

    }

    @Override
    public void setContent(MemberVO memberVO) {

    }
}
