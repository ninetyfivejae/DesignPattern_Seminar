package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

class ScreenFormat3 implements UserInfoScreenInterface {

    private InfoDialogFragment infoDialogFragment;
    private MemberVO user;

    @Override
    public void show() {
        infoDialogFragment = new InfoDialogFragment(user);
        infoDialogFragment.show(App.getCurrentActivity().getFragmentManager(),"InfoDialogFragment");
    }

    @Override
    public boolean isShowing() {
        return infoDialogFragment.getDialog() != null && infoDialogFragment.getDialog().isShowing();
    }

    @Override
    public void update() {

    }

    @Override
    public void setContent(MemberVO memberVO) {
        this.user = memberVO;
    }
}
