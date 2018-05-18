package com.example.parkminhyun.practice_seminar.screen.main;

import com.example.parkminhyun.practice_seminar.common.vo.MemberVO;

import java.util.List;

/**
 * main view, presenter 연결을 위한 interface
 * Created by ParkMinHyun on 2018-05-13.
 */

public interface MainInterface {

    interface View {
        void clearTextView();

        void updateMemberToViews(MemberVO user, int mode);

        void updateMemberRecyclerView(List<MemberVO> memberVOList);
    }

    interface Presenter {
        void init();

        void onClickAddMemberButton(int number, String name, String phoneNum);

        void onClickUserInfoButton(MemberVO user);

        void setMemberList(String index);

        List<MemberVO> getMemberList();
    }

}
