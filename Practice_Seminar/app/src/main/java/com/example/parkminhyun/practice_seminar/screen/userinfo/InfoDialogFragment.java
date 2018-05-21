package com.example.parkminhyun.practice_seminar.screen.userinfo;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parkminhyun.practice_seminar.R;
import com.example.parkminhyun.practice_seminar.common.vo.MemberVO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ParkMinHyun on 2018-05-15.
 */

@SuppressLint("ValidFragment")
public class InfoDialogFragment extends DialogFragment {

    @BindView(R.id.dialogNameText)
    TextView dialogNameText;

    @BindView(R.id.dialogPhoneNumText)
    TextView dialogPhoneNumText;

    @BindView(R.id.action_ok)
    TextView okButton;

    @BindView(R.id.action_cancel)
    TextView cancelButton;

    private MemberVO user;

    public InfoDialogFragment(MemberVO memberVO) {
        this.user = memberVO;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_info_dialog, container, false);
        ButterKnife.bind(this, view);

        initViews();

        return view;
    }

    private void initViews() {
        dialogNameText.setText(user.getName());
        dialogPhoneNumText.setText(user.getPhoneNum());
    }


    @OnClick({R.id.action_ok, R.id.action_cancel})
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.action_ok:
            case R.id.action_cancel:
                this.dismiss();
                break;
        }
    }

}
