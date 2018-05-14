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
        initTabBar();
        initRecyclerView();
        initButtons();
        mainPresenter.init();
    }

    private void initTabBar() {
        mainTabBar.setTabIndex(currentTabIndex, true);
    }

    private void initRecyclerView() {
    }

    private void initButtons() {
        memberListView.setOnClickButtonListener(v -> {
            switch (v.getId()) {
                case R.id.memberAddButton:
                    mainPresenter.onClickAddMemberButton(mainTabBar.getTabIndex(), memberListView.getNameText(), memberListView.getPhoneNumText());
                    break;
            }
        });
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
