package com.example.parkminhyun.java_designpattern_seminar.screen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkminhyun.java_designpattern_seminar.R;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;

import java.util.List;

/**
 * Created by ParkMinHyun on 2018-05-14.
 */

public class MemberRVAdapter extends RecyclerView.Adapter<MemberHolder>{

    List<MemberVO> memberVOList;

    @Override
    public MemberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item, parent, false);
        MemberHolder holder = new MemberHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MemberHolder holder, int position) {
        holder.bindView(memberVOList, position);
    }

    @Override
    public int getItemCount() {
        return memberVOList.size();
    }
}
