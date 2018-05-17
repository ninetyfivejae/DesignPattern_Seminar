package com.example.parkminhyun.java_designpattern_seminar.screen.userinfo;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.EIGHTEEN_TH;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.SEVENTEEN_TH;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.SIXTEEN_TH;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public class UserInfoScreen {

    private UserInfoScreenInterface userInfoScreenInterface;

    /**
     * 교체된 인스턴스에게 show() Method 동작시키기
     */
    public void show(){
        userInfoScreenInterface.show();
    }

    public boolean isShowing(){
        return userInfoScreenInterface.isShowing();
    }

    public void update(){
        userInfoScreenInterface.update();
    }

    /**
     * 상황에 맞는 Screen Mode를 결정하기 위한 Method
     * 인스턴스가 교체되는 식으로 동작
     */
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

    /**
     * content를 저장하는 Method
     */
    public void setScreenContent(MemberVO memberVO){
        userInfoScreenInterface.setContent(memberVO);
    }
}
