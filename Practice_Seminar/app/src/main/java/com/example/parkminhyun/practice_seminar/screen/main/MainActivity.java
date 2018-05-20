package com.example.parkminhyun.practice_seminar.screen.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.parkminhyun.practice_seminar.R;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

import butterknife.BindView;

/**
 * Main 화면의 view 초기화 및 view 변경을 담당하는 Class
 * Created by ParkMinHyun on 2018-05-13.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mainTabBar)
    NavigationTabStrip mainTabBar;

    @BindView(R.id.add_member_layout)
    AddMemberListView addMemberView;

    @BindView(R.id.memberRecyclerView)
    RecyclerView memberRecyclerView;

    @BindView(R.id.noticeView)
    NoticeView noticeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
