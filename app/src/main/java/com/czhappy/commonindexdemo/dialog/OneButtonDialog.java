package com.czhappy.commonindexdemo.dialog;

import android.content.Context;
import android.view.View;

import com.czhappy.commonindexdemo.R;
import com.czhappy.commonindexdemo.dialog.base.CenterScaleDialog;

import org.alex.dialog.annotation.ClickPosition;

/**
 * 作者：Alex
 * 时间：2016年09月09日    23:52
 * 简述：
 */

public class OneButtonDialog extends CenterScaleDialog<OneButtonDialog> {

    public OneButtonDialog(Context context) {
        super(context);
    }

    /**
     * 配置 对话框的 布局文件
     */
    @Override
    public int getLayoutRes() {
        return R.layout.dialog_one_button;
    }

    /**
     * 在 这里 进行 findView  设置点击事件
     */
    @Override
    public void onCreateData() {
        setOnCilckListener(R.id.tv_submit);
    }

    /**
     * 处理按钮点击事件 并绑定 onDialogClickListener
     *
     * @param v
     */
    @Override
    public void onClick(View v, int id) {
        switch(v.getId()){
            case R.id.tv_submit:
                if (onDialogClickListener != null) {
                    /**
                     * 接收
                     */
                    onDialogClickListener.onDialogClick(this, ClickPosition.SUBMIT);
                }
                break;
            case R.id.tv_no:
                if (onDialogClickListener != null) {
                    /**
                     * 拒绝
                     */
                    onDialogClickListener.onDialogClick(this, ClickPosition.CANCEL);
                }
                break;


        }

    }
}
