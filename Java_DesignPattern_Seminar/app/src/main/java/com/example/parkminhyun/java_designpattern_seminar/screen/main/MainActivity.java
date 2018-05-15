package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.parkminhyun.java_designpattern_seminar.App;
import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseActivity;
import com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.screen.main.observer.MemberStatusData;
import com.example.parkminhyun.java_designpattern_seminar.screen.main.recyclerview.MemberItemClickListener;
import com.example.parkminhyun.java_designpattern_seminar.screen.main.recyclerview.MemberRVAdapter;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.gigamole.navigationtabstrip.NavigationTabStrip.OnTabStripSelectedIndexListener;

import java.util.List;

import butterknife.BindView;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_GROUP_NUMBER;

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
    private MemberStatusData memberStatusData;
    private MainInterface.Presenter mainPresenter;

    @Override
    protected void init() {
        mainPresenter.init();

        initView();
        initListener();
        initObserver();
    }

    private void initView() {
        initTabBar();
        initRecyclerView();
    }

    private void initTabBar() {
        mainTabBar.setTabIndex(0, true);
    }

    private void initRecyclerView() {
        memberRecyclerView.setLayoutManager(new LinearLayoutManager(App.getInstance()));
        memberRVAdapter = new MemberRVAdapter(mainPresenter.getMemberList());
        memberRecyclerView.setAdapter(memberRVAdapter);
    }

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

        mainTabBar.setOnTabStripSelectedIndexListener(new OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                mainPresenter.setMemberList(String.valueOf(index + DEFAULT_GROUP_NUMBER));
            }

            @Override
            public void onEndTabSelected(String title, int index) {}
        });
    }

    private void initObserver() {
        memberStatusData = new MemberStatusData();
        noticeView.setMemberStatusObserver(memberStatusData);
    }

    @Override
    public void clearTextView() {
        addMemberView.nameText.setText("");
        addMemberView.phoneNumText.setText("");
    }

    @Override
    public void updateMemberToViews(MemberVO user) {
        memberStatusData.setMember(user, MemberConstant.ADD_MEMBER);
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
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
