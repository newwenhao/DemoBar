package com.czhappy.commonindexdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @desc 注册界面
 * 功能描述：一般会使用手机登录，通过获取手机验证码，跟服务器交互完成注册
 */
public class SignUpActivity extends BaseActivity implements View.OnClickListener {
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

    @Override
    protected int getContentView() {
        return R.layout.activity_signup;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("注册");
        layoutRight.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }
}