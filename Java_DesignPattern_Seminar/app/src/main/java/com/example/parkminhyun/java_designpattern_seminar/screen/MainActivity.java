package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseActivity;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainPageInterface.View{

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    @BindView(R.id.nameText)
    MaterialEditText nameText;

    @BindView(R.id.phoneNumText)
    MaterialEditText phoneNumText;

    @BindView(R.id.memberAddButton)
    View memberAddButton;

    RecyclerView memberRecyclerView;

    private MainPageInterface.Presenter mainPresenter;

    @Override
    protected void init() {
        mainTabBar.setTabIndex(0,true);

        mainPresenter.init();
    }

    @OnClick({R.id.memberAddButton})
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.memberAddButton){
            mainPresenter.onClickAddMemberButton(mainTabBar.getTabIndex(), nameText.getText().toString(),phoneNumText.getText().toString());
        }

    }

    @Override
    public void updateBottomMenuButton() {
    }

    @Override
    protected void createPresenter() {
        mainPresenter = new MainPagePresenter(this);
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
