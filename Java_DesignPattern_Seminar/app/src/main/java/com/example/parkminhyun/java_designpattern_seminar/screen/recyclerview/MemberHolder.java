package com.example.parkminhyun.java_designpattern_seminar.screen.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public MemberHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindView(List<MemberVO> memberVOList, int position) {
        nameView.setText(memberVOList.get(position).getName());
    }
}
