package com.example.parkminhyun.java_designpattern_seminar.screen.recyclerview;

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

    private List<MemberVO> memberVOList;
    private MemberItemClickListener memberItemClickListener;

    public MemberRVAdapter(List<MemberVO> memberVOList) {
        this.memberVOList = memberVOList;
    }

    @Override
    public MemberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_item, parent, false);
        MemberHolder holder = new MemberHolder(view, memberItemClickListener);
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

    public void setMemberVOList(List<MemberVO> memberVOList) {
        this.memberVOList = memberVOList;
    }

    public void setOnClickItemListener(MemberItemClickListener memberItemClickListener) {
        this.memberItemClickListener = memberItemClickListener;
    }
}
