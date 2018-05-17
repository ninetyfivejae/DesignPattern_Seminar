package com.example.parkminhyun.java_designpattern_seminar.db.provider;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.db.core.SingleResponse;
import com.example.parkminhyun.java_designpattern_seminar.db.dao.MemberFirebaseDAO;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public class MemberModelProvider {

    private MemberFirebaseDAO memberFirebaseDAO;

    public MemberModelProvider() {
        this.memberFirebaseDAO = new MemberFirebaseDAO();
    }

    public void getMemberList(String index, SingleResponse singleResponse) {
        memberFirebaseDAO.getMemberList(index, singleResponse);
    }

    public void addMember(MemberVO user, int index) {
        memberFirebaseDAO.addMember(user, index);
    }

    public void execute(){}
}
