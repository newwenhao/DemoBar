package com.czhappy.commonindexdemo.listener;

import android.content.Context;
import android.content.Intent;

import com.czhappy.commonindexdemo.activity.LoginActivity;
import com.czhappy.commonindexdemo.dialog.base.SimpleDialog;

import org.alex.dialog.annotation.ClickPosition;
import org.alex.dialog.callback.OnDialogClickListener;

/**
 * Created by Administrator on 2017/7/19.
 */
public final class MyOnDialogClickListener implements OnDialogClickListener<SimpleDialog> {

    private final Context mContext;

    public MyOnDialogClickListener(Context mContext){
        this.mContext = mContext;
    }
    @Override
    public void onDialogClick(SimpleDialog dialog, @ClickPosition String clickPosition) {
        //LogUtil.e("tag = " + dialog.tag + " clickPosition =" + clickPosition);
        if(clickPosition.equals(ClickPosition.SUBMIT)){
            /**
             * 表示进入登录界面 跳入登陆界面 Submit 接收进入登录页面
             */
            Intent intent = new Intent(mContext, LoginActivity.class);
            mContext.startActivity(intent);
            dialog.dismiss();

        }else if(clickPosition.equals(ClickPosition.CANCEL)){
            /**
             * 表示不登陆 那么对话框就消失
             */
            dialog.dismiss();
        }
    }
}