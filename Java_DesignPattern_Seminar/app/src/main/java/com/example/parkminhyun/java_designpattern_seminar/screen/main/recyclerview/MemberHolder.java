package com.example.parkminhyun.java_designpattern_seminar.screen.main.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ParkMinHyun on 2018-05-14.
 */

public class MemberHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.nameView)
    TextView nameView;

    @BindView(R.id.memberCall)
    ImageView memberCall;

    @BindView(R.id.memberInfo)
    ImageView memberInfo;

    private MemberVO user;
    private MemberItemClickListener memberItemClickListener;

    public MemberHolder(View view, MemberItemClickListener memberItemClickListener) {
        super(view);
        ButterKnife.bind(this, view);

        this.memberItemClickListener = memberItemClickListener;
    }

    /**
     * RecyclerView에 변화가 생길 때 호출되는 Method.
     * ex) 새로운 내용이 나타나거나, 삭제되거나, 변경되거나 등..
     */
    public void bindView(List<MemberVO> memberVOList, int position) {
        user = memberVOList.get(position);
        nameView.setText(user.getName());
    }

    /**
     * Butterknife Library OnClick Method
     */
    @OnClick({R.id.memberCall, R.id.memberInfo})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.memberCall) {
            memberItemClickListener.onClickPhoneCall(user.getPhoneNum());
        } else if (id == R.id.memberInfo) {
            memberItemClickListener.onClickUserInfo(user);
        }
    }
}
