package com.example.parkminhyun.java_designpattern_seminar.screen.main.observer;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.ADD_MEMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DELETE_MEMBER;

/**
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

    @Override
    public void notifyObserver(int mode) {
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

    public void setMember(MemberVO memberVO, int mode) {
        this.user = memberVO;
        notifyObserver(mode);
    }
}
