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
 * Created by Administrator on 2017/7/20.
 */
public class GameActivity extends BaseActivity implements View.OnClickListener {
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

    @BindView(R.id.start)
    Button start;
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start:
                startActivity(new Intent(GameActivity.this, TaskActivity.class));
                break;
        }

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_game;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("礼仪规则");
        layoutRight.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void bindEvent() {
        start.setOnClickListener(this);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
}
