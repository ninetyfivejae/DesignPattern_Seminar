package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPresenter implements MainInterface.Presenter {


    private MainInterface.View mainView;
    private DatabaseReference databaseMember;

    public MainPresenter(MainInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

    @Override
    public void init() {
        hideKeyBoard();
        databaseMember = App.getFirebaseDatabase().getReference();
    }

    @Override
    public void onClickAddMemberButton(int index, String name, String phoneNum) {
        hideKeyBoard();
        MemberVO user = new MemberVO(index, name, phoneNum);

        String id = databaseMember.push().getKey();
        databaseMember.child(id).setValue(user);
    }

    public void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager) App.getInstance().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
