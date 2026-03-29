package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import defpackage.bq6;
import defpackage.gr2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FirstLevelItemView extends RelativeLayout {
    private Context mContext;
    private ImageView mIndecatorImageView;
    private ImageView mIv_icon;
    private TextView mLableTextView;

    public FirstLevelItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View viewInflate = View.inflate(context, R.layout.first_level_item_view, this);
        this.mLableTextView = (TextView) viewInflate.findViewById(R.id.tv_item);
        this.mIndecatorImageView = (ImageView) viewInflate.findViewById(R.id.iv_down);
        this.mIv_icon = (ImageView) viewInflate.findViewById(R.id.iv_icon);
    }

    public void fillBlockView() {
        this.mIndecatorImageView.setVisibility(4);
        this.mLableTextView.setVisibility(4);
    }

    public void setIcon(int i) {
        this.mIv_icon.setImageResource(i);
    }

    public void setSelectState(boolean z) {
        if (z) {
            this.mIndecatorImageView.setBackgroundResource(R.drawable.dialog_forword_group_up);
        } else {
            this.mIndecatorImageView.setBackgroundResource(R.drawable.dialog_forword_group_downandr);
        }
    }

    public void setText(String str) {
        this.mLableTextView.setText(str);
    }

    public void setUrlIcon(String str) {
        gr2.j().h(str, this.mIv_icon, bq6.s());
    }

    public FirstLevelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FirstLevelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
