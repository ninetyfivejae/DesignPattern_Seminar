package com.example.parkminhyun.java_designpattern_seminar.screen.userinfo;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * 각 화면 Mode에서 공통된 기능을 사용하는 Method를 모은 인터페이스
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface UserInfoScreenInterface {
    void show();

    boolean isShowing();

    void update();

    void setContent(MemberVO memberVO);
}
