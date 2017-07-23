package com.czhappy.commonindexdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.activity.GameActivity;

/**
 * Created by Administrator on 2017/7/20.
 */

public class ManyLayoutRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private CardView head;
    private CardView midden;
    private LinearLayout footer;
    public static final int TYPE_TYPE1 = 0xff01;
    public static final int TYPE_TYPE2 = 0xff02;
    public static final int TYPE_TYPE3 = 0xff03;
    public static final int TYPE_TYPE4 = 0xff04;
    private final Context context;

    public ManyLayoutRecycleViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_TYPE1;
        }else if(position == 1){
            return TYPE_TYPE2;
        }else if(position == 2){
            return TYPE_TYPE3;
        } else {
            return TYPE_TYPE4;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch(viewType){
            case TYPE_TYPE1:
                return new ItemHead(LayoutInflater.from(parent.getContext()).inflate(R.layout.manylayout_itemhead, parent, false));
            case TYPE_TYPE2:
                return new ItemMidden(LayoutInflater.from(parent.getContext()).inflate(R.layout.manylayout_itemmidden, parent, false));
            case TYPE_TYPE3:
                return new ItemDec(LayoutInflater.from(parent.getContext()).inflate(R.layout.manylayout_itemdec, parent, false));
            case TYPE_TYPE4:
                return new ItemFooter(LayoutInflater.from(parent.getContext()).inflate(R.layout.manylayout_itemfooter, parent, false));
            default :
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(position == 0) {
            head.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " " + position, Toast.LENGTH_SHORT).show();
                }
            });
        } else if(position == 1) {
            midden.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " " + position, Toast.LENGTH_SHORT).show();
                }
            });
        } else if (position == 2) {

        } else {
            footer.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, GameActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return 10;
    }

    private class ItemHead extends RecyclerView.ViewHolder {
        public ItemHead(View itemView) {
            super(itemView);
            head = (CardView) itemView.findViewById(R.id.head);
        }
    }

    private class ItemMidden extends RecyclerView.ViewHolder {
        public ItemMidden(View itemView) {
            super(itemView);
            midden = (CardView) itemView.findViewById(R.id.midden);
        }
    }

    private class ItemFooter extends RecyclerView.ViewHolder {
        public ItemFooter(View itemView) {
            super(itemView);
            footer = (LinearLayout) itemView.findViewById(R.id.footer);
        }
    }

    private class ItemDec extends RecyclerView.ViewHolder {
        public ItemDec(View view) {
            super(view);
        }
    }
}
