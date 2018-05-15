package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseActivity;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.screen.recyclerview.MemberItemClickListener;
import com.example.parkminhyun.java_designpattern_seminar.screen.recyclerview.MemberRVAdapter;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import java.util.List;

import butterknife.BindView;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_MEMBER_NUMBER;
import static com.gigamole.navigationtabstrip.NavigationTabStrip.OnTabStripSelectedIndexListener;

public class MainActivity extends BaseActivity implements MainInterface.View {

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    @BindView(R.id.add_member_layout)
    AddMemberListView addMemberView;

    @BindView(R.id.memberRecyclerView)
    RecyclerView memberRecyclerView;

    @BindView(R.id.noticeView)
    NoticeView noticeView;

    private MemberRVAdapter memberRVAdapter;
    private MainInterface.Presenter mainPresenter;

    @Override
    protected void init() {
        mainPresenter.init();

        initRecyclerView();
        initListener();
        initTabBar();
    }

    private void initTabBar() {
        mainTabBar.setTabIndex(0, true);
        mainTabBar.setOnTabStripSelectedIndexListener(new OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                mainPresenter.setMemberList(String.valueOf(index + DEFAULT_MEMBER_NUMBER));
            }

            @Override
            public void onEndTabSelected(String title, int index) {}
        });
    }

    private void initRecyclerView() {
        memberRecyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));
        memberRVAdapter = new MemberRVAdapter(mainPresenter.getMemberList());
        memberRecyclerView.setAdapter(memberRVAdapter);
    }

    @SuppressLint("MissingPermission")
    private void initListener() {
        addMemberView.setOnClickButtonListener(v -> {
            switch (v.getId()) {
                case R.id.memberAddButton:
                    mainPresenter.onClickAddMemberButton(mainTabBar.getTabIndex(), addMemberView.getNameText(), addMemberView.getPhoneNumText());
                    break;
            }
        });

        memberRVAdapter.setOnClickItemListener(new MemberItemClickListener() {
            @Override
            public void onClickPhoneCall(String phoneNum) {
                startActivity(phoneNum);
            }

            @Override
            public void onClickUserInfo(MemberVO user) {
                mainPresenter.onClickUserInfoButton(user);
            }
        });
    }

    @Override
    public void clearTextView() {
        addMemberView.nameText.setText("");
        addMemberView.phoneNumText.setText("");
    }

    @Override
    public void updateMemberRecyclerView(List<MemberVO> memberVOList) {
        memberRVAdapter.setMemberVOList(memberVOList);
        memberRVAdapter.notifyDataSetChanged();
    }

    @Override
    protected void createPresenter() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    protected Activity getViews() {
        App.setCurrentActivity(this);
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
