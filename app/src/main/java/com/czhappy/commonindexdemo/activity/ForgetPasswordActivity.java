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
 * @desc 忘记密码
 * Created by devilwwj on 16/1/24.
 */
public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener {
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
    public void onClick(View v) {

    }

    @Override
    protected int getContentView() {

        return R.layout.layout_forgetpwd;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("忘记密码");
        layoutRight.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
