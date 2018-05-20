package com.example.parkminhyun.practice_seminar.screen.main;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

import com.example.parkminhyun.practice_seminar.App;
import com.example.parkminhyun.practice_seminar.common.vo.MemberVO;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.practice_seminar.common.constants.MemberConstant.ADD_MEMBER;
import static com.example.parkminhyun.practice_seminar.common.constants.MemberConstant.DEFAULT_GROUP_NUMBER;

/**
 * Main 화면의 기능을 담당하는 Class
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPresenter {

    private void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) App.getInstance().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
}
