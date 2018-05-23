package com.example.parkminhyun.java_designpattern_seminar.screen.main.observer;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.ADD_MEMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DELETE_MEMBER;

/**
 * 옵저버를 관리하는 클래스
 * Created by ParkMinHyun on 2018-05-15.
 */

public class MemberStatusData implements MemberStatusObservable {

    private MemberVO user;
    private List<MemberStatusObserver> memberStatusObservers;

    public MemberStatusData() {
        memberStatusObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(MemberStatusObserver memberStatusObserver) {
        memberStatusObservers.add(memberStatusObserver);
    }

    @Override
    public void deleteObserver(MemberStatusObserver memberStatusObserver) {
        int index = memberStatusObservers.indexOf(memberStatusObserver);
        if (index >= 0) {
            memberStatusObservers.remove(index);
        }
    }

    /**
     * 옵저버 전체 알림을 동작시키는 Method
     */
    @Override
    public void notifyObserver(int mode) {
        //옵저버들에게 알림을 주기위해
        for (MemberStatusObserver memberStatusObserver : memberStatusObservers) {
            switch (mode) {
                case ADD_MEMBER:
                    memberStatusObserver.addMember(user);
                    break;
                case DELETE_MEMBER:
                    memberStatusObserver.deleteMember(user);
                    break;
            }
        }
    }

    /**
     * 옵저버에게 전달할 Data를 저장하고 저장한 내용을 옵저버에게 전달하기 위한 Method
     */
    public void setMember(MemberVO memberVO, int mode) {
        this.user = memberVO;
        notifyObserver(mode);
    }
}
