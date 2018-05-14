package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseActivity;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.List;

import butterknife.BindView;

import static com.gigamole.navigationtabstrip.NavigationTabStrip.*;

public class MainActivity extends BaseActivity implements MainInterface.View {

    @BindView(R.id.custom_layout)
    MemberListView memberListView;

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    @BindView(R.id.memberRecyclerView)
    RecyclerView memberRecyclerView;

    private MemberRVAdapter memberRVAdapter;
    private MainInterface.Presenter mainPresenter;

    @Override
    protected void init() {
        initTabBar();
        initButtons();
        initRecyclerView();

        mainPresenter.init();
    }

    private void initTabBar() {
        mainTabBar.setTabIndex(0, true);
        mainTabBar.setOnTabStripSelectedIndexListener(new OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                mainPresenter.setMemberList(index);
            }

            @Override
            public void onEndTabSelected(String title, int index) {}
        });
    }

    private void initRecyclerView() {
        memberRecyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));
        memberRVAdapter = new MemberRVAdapter(mainPresenter.getCurrentMemberList());
        memberRecyclerView.setAdapter(memberRVAdapter);
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

    @Override
    public void clearTextView() {
        memberListView.nameText.setText("");
        memberListView.phoneNumText.setText("");
    }

    @Override
    public void updateMemberRecyclerView(List<MemberVO> memberVOList) {
        memberRVAdapter.setMemberVOList(memberVOList);
        memberRVAdapter.notifyDataSetChanged();
    }
}
