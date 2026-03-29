package com.zenmen.square.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.square.R$color;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.tag.bean.SquareTagBean;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTagInfoView extends LxRelativeLayout {
    static je1 imageOptions = new je1.a().s(true).t(true).u(true).q(Bitmap.Config.RGB_565).w(ImageScaleType.IN_SAMPLE_POWER_OF_2).r();
    private SquareTagBean bean;
    private ImageView mImageTag;
    private TextView mTvFeedCount;
    private TextView mTvTag;

    public NestTagInfoView(Context context) {
        super(context);
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.layout_nest_tag_info_view, (ViewGroup) this, false);
        this.mImageTag = (ImageView) viewInflate.findViewById(R$id.iv_tag);
        this.mTvTag = (TextView) viewInflate.findViewById(R$id.tv_tag_name);
        this.mTvFeedCount = (TextView) viewInflate.findViewById(R$id.tv_feed_num);
        addView(viewInflate);
    }

    public void setSquareTag(SquareTagBean squareTagBean) {
        this.bean = squareTagBean;
        updateInfo();
    }

    public void updateInfo() {
        gr2.j().h(this.bean.getPicUrl(), this.mImageTag, imageOptions);
        this.mImageTag.setColorFilter(getResources().getColor(R$color.Aa));
        this.mTvTag.setText(this.bean.getName());
        this.mTvFeedCount.setText(this.bean.getPublishCnt() + "");
    }

    public NestTagInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NestTagInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public NestTagInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
