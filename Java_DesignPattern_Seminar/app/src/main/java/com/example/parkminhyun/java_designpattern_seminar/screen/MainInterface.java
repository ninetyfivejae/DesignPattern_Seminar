package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public interface MainInterface {


    interface View {
        void clearTextView();

        void updateMemberRecyclerView(List<MemberVO> memberVOList);
    }

    interface Presenter {
        void init();

        void onClickAddMemberButton(int number, String name, String phoneNum);

        void onClickUserInfoButton();

        void setMemberList(int index);

        List<MemberVO> getMemberList();
    }


}
