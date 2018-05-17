package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.db.core.SingleResponse;
import com.example.parkminhyun.java_designpattern_seminar.db.provider.MemberModelProvider;
import com.example.parkminhyun.java_designpattern_seminar.screen.userinfo.UserInfoScreen;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.ADD_MEMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_GROUP_NUMBER;

/**
 * Main 화면의 기능을 담당하는 Class
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
        hideKeyBoard();

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
        memberModelProvider.getMemberList(index, new SingleResponse<List<MemberVO>>() {
            @Override
            public void onResponse(List<MemberVO> result) {
                memberVOList = result;
                mainView.updateMemberRecyclerView(memberVOList);
            }
        });
    }

    @Override
    public List<MemberVO> getMemberList() {
        return memberVOList;
    }

    private void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) App.getInstance().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
