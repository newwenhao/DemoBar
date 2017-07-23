package com.czhappy.commonindexdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.base.BaseActivity;
import com.czhappy.commonindexdemo.banner.Banner;
import com.czhappy.commonindexdemo.banner.BannerData;
import com.czhappy.commonindexdemo.context.AppConfig;
import com.czhappy.commonindexdemo.context.ImageConfig;
import com.czhappy.commonindexdemo.context.MyApplication;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/17.
 */

public class IntroduceActivity extends BaseActivity implements View.OnClickListener{
    /**
     * 轮播图
     */
    @BindView(R.id.home_top_vp)
    Banner banner;
    @BindView(R.id.start_seat)
    Button start_seat;

    @BindView(R.id.refresh)
    MaterialRefreshLayout materialRefreshLayout;
    @BindView(R.id.ivIcon)
    ImageView imageView;
    @BindView(R.id.taskName)
    TextView taskName;
    private ImageConfig imageConfig;

    /**
     * 对象中的参数传递接收
     */
    private String name;
    @Override
    protected int getContentView() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        return R.layout.introduce_activity;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        materialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);
        ImageConfig imageConfig = new ImageConfig();
        MyApplication.getInstance().getImageLoader().displayImage(AppConfig.PROTOCOL+"192.168.150.2:8480/picture/lwh.jpg",
                imageView, imageConfig.getOption());
        initBanner();
    }

    @Override
    protected void bindEvent() {
        start_seat.setOnClickListener(this);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        taskName.setText(name + "参数传递");
                        materialRefreshLayout.finishRefresh();

                    }
                }, 3000);
            }

            @Override
            public void onfinish() {
                Toast.makeText(IntroduceActivity.this, "finish", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }
    /**
     * 轮播器初始化
     */
    private void initBanner() {
        banner = (Banner) findViewById(R.id.home_top_vp);
        ArrayList<BannerData> bannerList = new ArrayList<>();
        String[] urls = new String[]{
                "drawable://" + R.drawable.banner1,
                "drawable://" + R.drawable.banner2,
                "drawable://" + R.drawable.banner3
        };
        for (int i = 0; i < urls.length; i++) {
            BannerData d = new BannerData();
            d.setImage(urls[i]);
            d.setTitle("");
            d.setId(i);
            if (i%2==0)
                d.setUrl("http://blog.csdn.net/u012402940/article/details/64439417");
            else
                d.setUrl("http://blog.csdn.net/u012402940/article/category/6226042");
            bannerList.add(d);
        }

        Banner.ImageCycleViewListener mAdCycleViewListener = new Banner.ImageCycleViewListener() {

            @Override
            public void onImageClick(int position, View imageView) {
                // 单击图片处理事件

            }

            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                /**
                 * 显示图片
                 */
                ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
            }
        };
        banner.setIndicator(Gravity.RIGHT);//指示器未知设置
        banner.setImageResources(bannerList, mAdCycleViewListener);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_seat:
                Intent intent = new Intent(IntroduceActivity.this, ConfirmActivity.class);
                startActivity(intent);
                break;
        }

    }
}
