package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface UserInfoScreenInterface {
    void show();

    boolean isShowing();

    void update();

    void setContent(MemberVO memberVO);
}
