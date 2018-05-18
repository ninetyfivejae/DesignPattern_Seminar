package com.example.parkminhyun.practice_seminar.screen.main.recyclerview;

import com.example.parkminhyun.practice_seminar.common.vo.MemberVO;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

public interface MemberItemClickListener {
    void onClickPhoneCall(String phoneNum);
    void onClickUserInfo(MemberVO user);
}
