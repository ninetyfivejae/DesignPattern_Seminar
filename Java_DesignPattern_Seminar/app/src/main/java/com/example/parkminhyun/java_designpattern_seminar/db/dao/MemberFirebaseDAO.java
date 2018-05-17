package com.example.parkminhyun.java_designpattern_seminar.db.dao;

import com.example.parkminhyun.java_designpattern_seminar.common.base.BaseFirebaseDAO;
import com.example.parkminhyun.java_designpattern_seminar.common.vo.MemberVO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.DEFAULT_GROUP_NUMBER;
import static com.example.parkminhyun.java_designpattern_seminar.common.constants.MemberConstant.MEMBER;

/**
 * Created by ParkMinHyun on 2018-05-17.
 */

public class MemberFirebaseDAO extends BaseFirebaseDAO {

    public List<MemberVO> getMemberList(String index) {
        return query(databaseReference -> {

            List<MemberVO> memberList = new ArrayList<>();
            Query getMemberQuery = databaseReference.child(MEMBER).child(index);

            getMemberQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            MemberVO memberVO = snapshot.getValue(MemberVO.class);
                            memberList.add(memberVO);
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            });
            return memberList;
        });

    }

    public void addMember(MemberVO user, int index) {
        modify(databaseReference -> {
            String id = databaseReference.push().getKey();
            String groupIndex = String.valueOf(index + DEFAULT_GROUP_NUMBER);
            databaseReference.child(MEMBER).child(groupIndex).child(id).setValue(user);
        });
    }
}
