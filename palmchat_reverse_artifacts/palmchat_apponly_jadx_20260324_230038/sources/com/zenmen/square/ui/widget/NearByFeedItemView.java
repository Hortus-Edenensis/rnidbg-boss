package com.zenmen.square.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.mvp.model.bean.NearByBean;
import defpackage.a46;
import defpackage.gr2;
import defpackage.je1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFeedItemView extends RelativeLayout {
    private static je1 options;
    private EffectiveShapeView picView;

    public NearByFeedItemView(Context context) {
        this(context, null);
    }

    private void initView() {
        this.picView = (EffectiveShapeView) LayoutInflater.from(getContext()).inflate(R$layout.nearby_feed_item, this).findViewById(R$id.iv_iamge);
    }

    public void setFeedSimpleInfo(NearByBean.FeedSimpleInfo feedSimpleInfo) {
        setTag(feedSimpleInfo);
        this.picView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (options == null) {
            options = a46.j(getContext(), 4.0f, R$drawable.icon_default_thumbnail);
        }
        gr2.j().h(a46.g(a46.b(getContext(), 20.0f), a46.b(getContext(), 20.0f), feedSimpleInfo.thumbUrl), this.picView, options);
    }

    public NearByFeedItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearByFeedItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    @SuppressLint({"NewApi"})
    public NearByFeedItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView();
    }
}
