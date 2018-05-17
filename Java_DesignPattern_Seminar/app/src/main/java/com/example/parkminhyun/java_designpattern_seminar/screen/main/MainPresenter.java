package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.db.provider.MemberModelProvider;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.ADD_MEMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_GROUP_NUMBER;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.View mainView;

    private List<MemberVO> memberVOList;
    private MemberModelProvider memberModelProvider;

    private UserInfoScreen userInfoScreen;

    public MainPresenter(MainInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

    @Override
    public void init() {
        initObject();
        initMemberData();
    }

    private void initObject() {
        userInfoScreen = new UserInfoScreen();
        memberModelProvider = new MemberModelProvider();
        memberVOList = new ArrayList<>();
    }

    private void initMemberData() {
        setMemberList(String.valueOf(DEFAULT_GROUP_NUMBER));
    }

    @Override
    public void onClickAddMemberButton(int index, String name, String phoneNum) {
        App.hideKeyBoard();

        MemberVO user = new MemberVO(index, name, phoneNum);
        memberModelProvider.addMember(user, index);

        mainView.clearTextView();
        mainView.updateMemberToViews(user, ADD_MEMBER);
    }

    @Override
    public void onClickUserInfoButton(MemberVO user) {
        userInfoScreen.setScreen(user.getGroup());
        userInfoScreen.setScreenContent(user);
        userInfoScreen.show();
    }

    @Override
    public void setMemberList(String index) {
        memberModelProvider.getMemberList(index, memberList -> mainView.updateMemberRecyclerView((List<MemberVO>) memberList));
    }

    @Override
    public List<MemberVO> getMemberList() {
        return memberVOList;
    }


}
