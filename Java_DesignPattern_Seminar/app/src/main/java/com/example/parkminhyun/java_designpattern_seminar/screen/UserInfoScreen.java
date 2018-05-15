package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public class UserInfoScreen {

    private static final int SIXTEEN_TH = 0;
    private static final int SEVENTEEN_TH = 1;
    private static final int EIGHTEEN_TH = 2;

    private UserInfoScreenInterface userInfoScreenInterface;

    public void show(){
        if(!userInfoScreenInterface.isShowing()) {
            userInfoScreenInterface.show();
        }
    }

    public void update(){
        userInfoScreenInterface.update();
    }

    public void setScreen(int index){
        switch (index){
            case SIXTEEN_TH:
                userInfoScreenInterface = new ScreenFormat1();
                break;
            case SEVENTEEN_TH:
                userInfoScreenInterface = new ScreenFormat2();
                break;
            case EIGHTEEN_TH:
                userInfoScreenInterface = new ScreenFormat3();
                break;
        }
    }

    public void setScreenContent(MemberVO memberVO){
        userInfoScreenInterface.setContent(memberVO);
    }
}
