package com.czhappy.commonindexdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.base.BaseActivity;
import com.czhappy.commonindexdemo.adapter.ManyLayoutRecycleViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/20.
 */
public class PersonActivity extends BaseActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener{
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
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.lay_refresh)
    SwipeRefreshLayout lay_refresh;

    private ManyLayoutRecycleViewAdapter adapter;


    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_person;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("今晚匹配");
        layoutRight.setVisibility(View.INVISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new ManyLayoutRecycleViewAdapter(PersonActivity.this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void bindEvent() {
        lay_refresh.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        lay_refresh.setOnRefreshListener(this);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lay_refresh.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        }, 1000);
    }
}
