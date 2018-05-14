package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.parkminhyun.java_designpattern_seminar.R;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public class NoticeView extends LinearLayout {

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

}
