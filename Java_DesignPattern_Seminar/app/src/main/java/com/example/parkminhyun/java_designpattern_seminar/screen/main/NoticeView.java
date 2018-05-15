package com.example.parkminhyun.java_designpattern_seminar.screen.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.example.parkminhyun.java_designpattern_seminar.screen.main.observer.MemberStatusData;
import com.example.parkminhyun.java_designpattern_seminar.screen.main.observer.MemberStatusObserver;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public class NoticeView extends LinearLayout implements MemberStatusObserver {

    @BindView(R.id.noticeTextView)
    TextView noticeTextView;

    public NoticeView(Context context) {
        this(context, null);
    }

    public NoticeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NoticeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NoticeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.layout_notice, this);
        ButterKnife.bind(this);
    }

    public void setMemberStatusObserver(MemberStatusData observable) {
        observable.addObserver(this);
    }

    @Override
    public void addMember(MemberVO user) {
        noticeTextView.setText(user.getName() + "님이 추가되었습니다!");
    }

    @Override
    public void deleteMember(MemberVO user) {

    }
}
