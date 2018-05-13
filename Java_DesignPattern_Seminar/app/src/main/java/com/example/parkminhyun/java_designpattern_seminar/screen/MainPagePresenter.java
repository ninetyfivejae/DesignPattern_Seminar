package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.text.Editable;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPagePresenter implements MainPageInterface.Presenter {


    private MainPageInterface.View mainView;
    private DatabaseReference databaseMember;

    public MainPagePresenter(MainPageInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

    @Override
    public void init() {
        databaseMember = App.getFirebaseDatabase().getReference();
    }

    @Override
    public void onClickAddMemberButton(int index, String name, String phoneNum) {
        MemberVO user = new MemberVO(index, name, phoneNum);

        String id = databaseMember.push().getKey();
        databaseMember.child(id).setValue(user);
    }

}
