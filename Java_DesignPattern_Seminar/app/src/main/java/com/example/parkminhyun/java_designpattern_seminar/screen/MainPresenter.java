package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPresenter implements MainInterface.Presenter {

    private List<MemberVO> memberVOList = new ArrayList<>();
    private MainInterface.View mainView;
    private DatabaseReference memberDataReference;

    public MainPresenter(MainInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

    @Override
    public void init() {
        initMemberData();
    }

    private void initMemberData() {
        memberDataReference = App.getFirebaseDatabase().getReference();
        setMemberList(0);
    }

    @Override
    public void onClickAddMemberButton(int index, String name, String phoneNum) {
        hideKeyBoard();
        MemberVO user = new MemberVO(name, phoneNum);

        memberVOList.add(user);
        String id = memberDataReference.push().getKey();
        memberDataReference.child(String.valueOf(index + 16) + "th").child(id).setValue(user);

        mainView.clearTextView();
        mainView.updateMemberRecyclerView(memberVOList);
    }

    @Override
    public void setMemberList(int index) {
        Query query = memberDataReference.child(String.valueOf(index + 16) + "th");
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
    public List<MemberVO> getCurrentMemberList() {
        return memberVOList;
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) App.getInstance().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

}
