package com.czhappy.commonindexdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/18.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.back_iv)
    ImageView backIv;
    @BindView(R.id.layout_back)
    LinearLayout layoutBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.right_tv)
    TextView rightTv;
    @BindView(R.id.layout_right)
    LinearLayout layoutRight;
    @BindView(R.id.tv_create_account)
    TextView tv_create_account;
    @BindView(R.id.tv_forget_password)
    TextView tv_forget_password;
    @BindView(R.id.btn_login)
    Button btn_login;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("登陆");
        layoutRight.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void bindEvent() {
        tv_create_account.setOnClickListener(this);
        tv_forget_password.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tv_create_account:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
            case R.id.tv_forget_password:
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            break;

        }
    }
}
