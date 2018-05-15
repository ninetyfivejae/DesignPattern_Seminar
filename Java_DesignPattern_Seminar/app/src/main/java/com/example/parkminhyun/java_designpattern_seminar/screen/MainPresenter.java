package com.example.parkminhyun.java_designpattern_seminar.screen;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_MEMBER_NUMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.MEMBER;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPresenter implements MainInterface.Presenter {

    private MainInterface.View mainView;

    private List<MemberVO> memberVOList;
    private DatabaseReference memberDataReference;

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
        memberVOList = new ArrayList<>();
    }

    private void initMemberData() {
        memberDataReference = App.getFirebaseDatabase().getReference();
        setMemberList(String.valueOf(DEFAULT_MEMBER_NUMBER));
    }

    @Override
    public void onClickAddMemberButton(int index, String name, String phoneNum) {
        App.hideKeyBoard();

        MemberVO user = new MemberVO(index, name, phoneNum);
        memberVOList.add(user);

        String id = memberDataReference.push().getKey();
        String memberNumber = String.valueOf(index + DEFAULT_MEMBER_NUMBER);
        memberDataReference.child(MEMBER).child(memberNumber).child(id).setValue(user);

        mainView.clearTextView();
        mainView.updateMemberRecyclerView(memberVOList);
    }

    @Override
    public void onClickUserInfoButton(MemberVO user) {
        userInfoScreen.setScreen(user.getIndex());
        userInfoScreen.setScreenContent(user);
        userInfoScreen.show();
    }

    @Override
    public void setMemberList(String index) {
        Query query = memberDataReference
                .child(MEMBER)
                .child(String.valueOf(index));

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                memberVOList.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MemberVO memberVO = snapshot.getValue(MemberVO.class);
                        memberVOList.add(memberVO);
                    }
                }
                mainView.updateMemberRecyclerView(memberVOList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    @Override
    public List<MemberVO> getMemberList() {
        return memberVOList;
    }


}
