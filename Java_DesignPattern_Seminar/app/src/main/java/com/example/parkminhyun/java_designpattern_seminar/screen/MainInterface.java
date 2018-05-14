package com.example.parkminhyun.java_designpattern_seminar.screen;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public interface MainInterface {


    interface View {
        void clearTextView();
    }

    interface Presenter {
        void init();

        void onClickAddMemberButton(int number, String name, String phoneNum);

        void setMemberList(int index);
    }


}
