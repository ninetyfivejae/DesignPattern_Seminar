package com.example.parkminhyun.designpattern_seminar.screen;

/**
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainPagePresenter implements MainPageInterface.Presenter {


    private MainPageInterface.View mainView;

    public MainPagePresenter(MainPageInterface.View mainPageView) {
        this.mainView = mainPageView;
    }

}
