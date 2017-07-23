package com.czhappy.commonindexdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.base.BaseActivity;
import com.czhappy.commonindexdemo.adapter.RecyclerViewAdapter;
import com.czhappy.commonindexdemo.banner.Banner;
import com.czhappy.commonindexdemo.banner.BannerData;
import com.czhappy.commonindexdemo.context.AppConfig;
import com.czhappy.commonindexdemo.context.ImageConfig;
import com.czhappy.commonindexdemo.context.MyApplication;
import com.czhappy.commonindexdemo.model.Campaign;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/19.
 */
public class MenuActivity extends BaseActivity implements View.OnClickListener{
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
    @BindView(R.id.refresh)
    MaterialRefreshLayout materialRefreshLayout;
    @BindView(R.id.ivIcon)
    ImageView ivIcon;

    /**
     * 轮播图
     */
    @BindView(R.id.home_top_vp)
    Banner banner;
    @BindView(R.id.recycler_id)
    RecyclerView recyclerView;


    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_menu;
    }

    @Override
    protected void initComponent() {
        ButterKnife.bind(this);
        titleTv.setText("今日舞会");
        layoutRight.setVisibility(View.INVISIBLE);
        ImageConfig imageConfig = new ImageConfig();
        MyApplication.getInstance().getImageLoader().displayImage(AppConfig.PROTOCOL+"192.168.150.2:8480/picture/lwh.jpg",
                ivIcon, imageConfig.getOption());
        initBanner();
    }

    @Override
    protected void bindEvent() {
        materialRefreshLayout.setLoadMore(true);
        materialRefreshLayout.finishRefreshLoadMore();
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();
                    }
                }, 3000);
            }

            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefreshLoadMore();
                    }
                }, 3000);
            }
            @Override
            public void onfinish() {
                Toast.makeText(MenuActivity.this, "finish", Toast.LENGTH_LONG).show();
            }
        });

        materialRefreshLayout.autoRefresh();

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linaLayout = new LinearLayoutManager(this);
        linaLayout.setOrientation(1);

        recyclerView.setLayoutManager(linaLayout);

        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 10);


        ArrayList<Campaign> userList = new ArrayList<>();



        Random random = new Random();
        Campaign campaign1 = new Campaign();
        campaign1.setEnd_time("2017-4-5");
        campaign1.setStart_time("2017-3-10");
        campaign1.setComment_count("100");
        campaign1.setCampaign_address("武汉纺织大学");
        campaign1.setIs_praise("1");
        campaign1.setCampaign_name("假面舞会");
        campaign1.setCampaign_desc("纺大的男女比例这么均衡，为什么这么帅的我，就没有妹子呢.......？");
        campaign1.setHead_img("http://192.168.150.2:8480/picture/lwh.jpg");



        Campaign campaign2 = new Campaign();
        campaign2.setEnd_time("2017-5-5");
        campaign2.setStart_time("2017-37-10");
        campaign2.setComment_count("100");
        campaign2.setCampaign_address("武汉大学");
        campaign2.setIs_praise("1");
        campaign2.setCampaign_name("硕士生毕业典礼酒会");
        campaign2.setCampaign_desc("在五武大的樱花大道上来一次美好的邂逅, 说不定这个社会就会少一个单身狗呢......");
        campaign2.setHead_img("http://192.168.150.2:8480/picture/001.jpg");

        userList.add(campaign1);
        userList.add(campaign2);


        final RecyclerViewAdapter adapter= new RecyclerViewAdapter(this, userList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, Campaign data) {
                Toast.makeText(MenuActivity.this,"click " + position + " item", Toast.LENGTH_SHORT).show();
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
}
