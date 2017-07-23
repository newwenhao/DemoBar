package com.czhappy.commonindexdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.context.AppConfig;
import com.czhappy.commonindexdemo.context.ImageConfig;
import com.czhappy.commonindexdemo.context.MyApplication;
import com.czhappy.commonindexdemo.view.PullScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Description:
 * User: chenzheng
 * Date: 2016/9/9 0009
 * Time: 17:18
 */
public class SelfFragment extends Fragment implements PullScrollView.OnTurnListener{

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
    @BindView(R.id.user_avatar)
    ImageView user_avatar;
    private View mView;



    private PullScrollView mScrollView;
    private ImageView mHeadImg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_self, container,
                false);
        ButterKnife.bind(this, mView);
        initView();
        return mView;
    }


    private void initView() {
        backIv.setVisibility(View.GONE);
        titleTv.setText("个人中心");
        layoutRight.setVisibility(View.INVISIBLE);

        mScrollView = (PullScrollView) mView.findViewById(R.id.scroll_view);
        mHeadImg = (ImageView) mView.findViewById(R.id.background_img);
        ImageConfig imageConfig = new ImageConfig();
        MyApplication.getInstance().getImageLoader().displayImage(AppConfig.PROTOCOL+"192.168.150.2:8480/picture/lwh.jpg",
                user_avatar, imageConfig.getOption());


        mScrollView.setHeader(mHeadImg);
        mScrollView.setOnTurnListener(this);
    }

    @Override
    public void onTurn() {

    }
}
