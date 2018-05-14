package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseActivity;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainInterface.View {

    @BindView(R.id.custom_layout)
    MemberListView memberListView;

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    private RecyclerView memberRecyclerView;
    private MainInterface.Presenter mainPresenter;

    private int currentTabIndex = 0;

    @Override
    protected void init() {
        mainTabBar.setTabIndex(currentTabIndex, true);
//        mainLinearLayout.setOnTouchListener(new OnSwipeTouchListener(App.getInstance()) {
//            @Override
//            public void onSwipeLeft() {
//                if (currentTabIndex == 0) {
//                    currentTabIndex = 2;
//                } else {
//                    currentTabIndex -= 1;
//                }
//                mainTabBar.setTabIndex(currentTabIndex, true);
//            }
//
//            @Override
//            public void onSwipeRight() {
//                currentTabIndex = (currentTabIndex + 1) % 3;
//                mainTabBar.setTabIndex(currentTabIndex, true);
//            }
//        });
        mainPresenter.init();
    }

//
//    @OnClick({R.id.memberAddButton})
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.memberAddButton) {
//            mainPresenter.onClickAddMemberButton(mainTabBar.getTabIndex(), nameText.getText().toString(), phoneNumText.getText().toString());
//        }
//
//    }

    @Override
    protected void createPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    protected Activity getViews() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
