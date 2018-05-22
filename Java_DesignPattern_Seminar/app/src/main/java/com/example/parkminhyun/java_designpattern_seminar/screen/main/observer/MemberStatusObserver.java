package com.example.parkminhyun.java_designpattern_seminar.screen.main.observer;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

/**
 * 옵저버 호출 시 각 기능에 대한 메소드를 담은 인터페이스
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface MemberStatusObserver {
    void addMember(MemberVO user);

    void deleteMember(MemberVO user);
}
