package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

/**
 * main view, presenter 연결을 위한 interface
 * Created by ParkMinHyun on 2018-05-13.
 */

public interface MainInterface {

    //UI가 변경되는 메소드만 존재
    interface View {
        void clearTextView();

        void updateMemberToViews(MemberVO user, int mode);

        void updateMemberRecyclerView(List<MemberVO> memberVOList);
    }

    //기능만 수행되는 메소드만 존재
    interface Presenter {
        void init();

        void onClickAddMemberButton(int number, String name, String phoneNum);

        void onClickUserInfoButton(MemberVO user);

        void setMemberList(String index);

        List<MemberVO> getMemberList();
    }

}
