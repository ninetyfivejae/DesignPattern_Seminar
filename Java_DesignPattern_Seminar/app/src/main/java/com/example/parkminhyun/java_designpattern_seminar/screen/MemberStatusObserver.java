package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface MemberStatusObserver {
    void addMember(MemberVO user);

    void deleteMember(MemberVO user);
}
