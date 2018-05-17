package com.example.parkminhyun.java_designpattern_seminar.db.provider;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.example.parkminhyun.java_designpattern_seminar.db.dao.MemberFirebaseDAO;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public class MemberModelProvider {

    private MemberFirebaseDAO memberFirebaseDAO;

    public MemberModelProvider() {
        this.memberFirebaseDAO = new MemberFirebaseDAO();
    }

    @NonNull
    @CheckResult
    public List<MemberVO> getMemberList(String index) {
        return memberFirebaseDAO.getMemberList(index);
    }

    public void addMember(MemberVO user, int index) {
        memberFirebaseDAO.addMember(user, index);
    }

    public void setSingleObserver(){

    }
}
