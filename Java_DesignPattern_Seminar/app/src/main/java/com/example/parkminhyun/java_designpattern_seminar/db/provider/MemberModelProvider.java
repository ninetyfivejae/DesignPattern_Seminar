package com.example.parkminhyun.java_designpattern_seminar.db.provider;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.db.core.SingleResponse;
import com.example.parkminhyun.java_designpattern_seminar.db.dao.MemberFirebaseDAO;

/**
 * 본체와 DAO 간 중간자 역할을 담당하는 Provider Class
 * Created by ParkMinHyun on 2018-05-17.
 */

public class MemberModelProvider {

    private MemberFirebaseDAO memberFirebaseDAO;

    public MemberModelProvider() {
        this.memberFirebaseDAO = new MemberFirebaseDAO();
    }

    public void getMemberList(String index, SingleResponse singleResponse) {
        memberFirebaseDAO.requestMemberList(index, singleResponse);
    }

    public void addMember(MemberVO user, int index) {
        memberFirebaseDAO.addMember(user, index);
    }
}
