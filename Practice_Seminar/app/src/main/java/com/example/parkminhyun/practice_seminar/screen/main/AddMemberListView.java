package com.example.parkminhyun.practice_seminar.screen.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.parkminhyun.practice_seminar.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Member를 등록하는 customView
 * Created by ParkMinHyun on 2018-05-14.
 */

public class AddMemberListView extends FrameLayout {

    @BindView(R.id.nameText)
    MaterialEditText nameText;

    @BindView(R.id.phoneNumText)
    MaterialEditText phoneNumText;

    @BindView(R.id.memberAddButton)
    View memberAddButton;

    public AddMemberListView(Context context) {
        this(context, null);
    }

    public AddMemberListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddMemberListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AddMemberListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.layout_add_member, this);
        ButterKnife.bind(this);
    }

    public String getNameText(){
        return nameText.getText().toString();
    }

    public String getPhoneNumText(){
        return phoneNumText.getText().toString();
    }

    public void setOnClickButtonListener(OnClickListener onClickListener) {
        this.memberAddButton.setOnClickListener(onClickListener);
    }

}
