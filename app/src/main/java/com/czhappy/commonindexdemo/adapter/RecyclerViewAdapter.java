package com.czhappy.commonindexdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.PersonActivity;
import com.czhappy.commonindexdemo.context.ImageConfig;
import com.czhappy.commonindexdemo.context.MyApplication;
import com.czhappy.commonindexdemo.model.Campaign;
import com.lzy.ninegrid.NineGridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.czhappy.commonindexdemo.R.id.address_tv;
import static com.czhappy.commonindexdemo.R.id.campaign_time_tv;


/**
 * Created by Administrator on 2017/7/19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    @BindView(R.id.user_head_iv)
    ImageView userHeadIv;
    @BindView(R.id.username_tv)
    TextView usernameTv;
    @BindView(R.id.createtime_tv)
    TextView createtimeTv;
    @BindView(R.id.status_tv)
    TextView statusTv;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.desc_tv)
    TextView descTv;
    @BindView(campaign_time_tv)
    TextView campaignTimeTv;
    @BindView(R.id.prise_iv)
    ImageView priseIv;
    @BindView(R.id.prise_count_tv)
    TextView priseCountTv;
    @BindView(R.id.comment_count_tv)
    TextView commentCountTv;
    @BindView(R.id.nineGrid)
    NineGridView nineGrid;
    @BindView(address_tv)
    TextView addressTv;
    @BindView(R.id.cardView)
    CardView cardView;

    @BindView(R.id.layout_address)
    LinearLayout layoutAddress;

    private final Context context;
    private final ArrayList<Campaign> datas;

    public RecyclerViewAdapter(Context context, ArrayList<Campaign> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//绑定
        //1.根据位置得到数据
        Campaign data = datas.get(position);
        ButterKnife.bind(this, holder.itemView);

        //2.绑定数据
        campaignTimeTv.setText(data.getStart_time());
        addressTv.setText(data.getCampaign_address());
        titleTv.setText(data.getCampaign_name());
        descTv.setText(data.getCampaign_desc());
        statusTv.setText("已开始");

        ImageConfig imageConfig = new ImageConfig();
        MyApplication.getInstance().getImageLoader().displayImage(data.getHead_img(),
                userHeadIv, imageConfig.getOption());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PersonActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//创建
        View itemView;
        itemView = View.inflate(context, R.layout.menu_item, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {//总的数目
        return datas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void addData(int position, Campaign s) {
        /**
         * 位置 position
         */
        datas.add(position, s);
        /**
         *  刷新添加 位置
         */
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        /**
         * 删除位置
         */
        datas.remove(position);
        //移除刷新
        notifyItemRemoved(0);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
            /**
             * 点击事件 是对整个item添加的点击事件
             * 1.如果对iv_icon添加点击事件 就用iv_icon.setOnClickListener
             * 2.如果对tv_text添加点击事件 就用tv_text.setOnClickListener
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemListener != null){
                        /**
                         * 因为在添加删除的时候 position会发生改变  而getLayoutPosition获得的是当前正确的值
                         */
                        onItemListener.OnItemClick(v, getLayoutPosition(), datas.get(getLayoutPosition()));
                    }
                }
            });
        }
    }

    /**
     * 写好接口
     */
    public interface OnItemClickListener{
        /**
         * 当点击某条的时候回调方法
         * @param view 谁被点击了
         * @param position 点击的位置
         * @param data 点击位置的数据
         */
        public void OnItemClick(View view, int position, Campaign data);
    }
    /**
     * 定义接口
     */
    private OnItemClickListener onItemListener;
    /**
     * 设置Item的点击事件
     */
    public void setOnItemClickListener(OnItemClickListener l){
        this.onItemListener = l;
    }

}
