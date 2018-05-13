package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.text.Editable;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public interface MainPageInterface {


    interface View {
        void updateBottomMenuButton();
    }

    interface Presenter {
        void init();

        void onClickAddMemberButton(int number, String name, String phoneNum);
    }


}
