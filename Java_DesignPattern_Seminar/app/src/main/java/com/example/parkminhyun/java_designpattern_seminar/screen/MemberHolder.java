package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by ParkMinHyun on 2018-05-14.
 */

public class MemberHolder extends RecyclerView.ViewHolder {
    public MemberHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindView(List<MemberVO> memberVOList, int position) {
    }
}
