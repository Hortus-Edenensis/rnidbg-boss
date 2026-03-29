package com.zenmen.square.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.zenmen.square.MediaViewActivity;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import defpackage.a46;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFeedContainer extends LinearLayout implements View.OnClickListener {
    private NearByBean nearByBean;
    private List<NearByFeedItemView> thumbnailViewList;

    public NearByFeedContainer(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof NearByFeedItemView) {
            Object tag = view.getTag();
            if (tag instanceof NearByBean.FeedSimpleInfo) {
                NearByBean.FeedSimpleInfo feedSimpleInfo = (NearByBean.FeedSimpleInfo) tag;
                SquareFeed squareFeed = new SquareFeed();
                squareFeed.id = feedSimpleInfo.feedId;
                squareFeed.feedType = feedSimpleInfo.feedType;
                squareFeed.exid = this.nearByBean.exid;
                MediaViewActivity.B1(14, getContext(), squareFeed, false);
            }
        }
    }

    public void setFeedThumbnail(NearByBean nearByBean) {
        this.nearByBean = nearByBean;
        NearByBean.Extra extra = nearByBean.extra;
        if (extra.feedList == null) {
            extra.feedList = new ArrayList();
        }
        int size = this.nearByBean.extra.feedList.size() - this.thumbnailViewList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                NearByFeedItemView nearByFeedItemView = new NearByFeedItemView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (this.thumbnailViewList.size() > 0) {
                    layoutParams.leftMargin = a46.b(getContext(), 3.0f);
                }
                addView(nearByFeedItemView, layoutParams);
                this.thumbnailViewList.add(nearByFeedItemView);
            }
        } else if (size < 0) {
            for (int i2 = 0; i2 > size; i2--) {
                removeView(this.thumbnailViewList.remove(r3.size() - 1));
            }
        }
        for (int i3 = 0; i3 < this.thumbnailViewList.size(); i3++) {
            this.thumbnailViewList.get(i3).setFeedSimpleInfo(nearByBean.extra.feedList.get(i3));
        }
    }

    public NearByFeedContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NearByFeedContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.thumbnailViewList = new ArrayList();
    }

    @RequiresApi(api = 21)
    public NearByFeedContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.thumbnailViewList = new ArrayList();
    }
}
