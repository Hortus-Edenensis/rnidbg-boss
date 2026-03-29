package com.zenmen.square.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.ad.AdViewHolder;
import com.zenmen.square.ad.AdViewHolder2;
import com.zenmen.square.mvp.holder.FeedImageViewHolder;
import com.zenmen.square.mvp.holder.FeedTextViewHolder;
import com.zenmen.square.mvp.holder.FeedTopicHeaderHolder;
import com.zenmen.square.mvp.holder.FeedVenusShareViewHolder;
import com.zenmen.square.mvp.holder.FeedVideoViewHolder;
import com.zenmen.square.mvp.holder.FootViewHolder;
import com.zenmen.square.mvp.holder.FriendEmptyViewHolder;
import com.zenmen.square.mvp.holder.MapFindTripHolder;
import com.zenmen.square.mvp.holder.NestTagHeaderViewHolder;
import com.zenmen.square.mvp.holder.SquareDividerViewHolder;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.FeedItemView;
import com.zenmen.square.vip.FeedVipEnterHolder;
import defpackage.ma3;
import defpackage.n6;
import defpackage.wh5;
import defpackage.zt1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedsAdapter extends BaseRecyclerAdapter<BaseViewHolder, SquareFeed, zt1> {
    public int g;
    public Activity h;

    public FeedsAdapter(int i) {
        this.g = i;
    }

    @Override // com.zenmen.listui.list.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        List<B> list;
        super.onBindViewHolder(baseViewHolder, i);
        ma3.a("onBindViewHolder position " + i, new Object[0]);
        if (this.f != 0 && (list = this.e) != 0 && list.size() > 0) {
            int iM = ((zt1) this.f).m();
            ma3.a("onBindViewHolder stepSize " + iM + " datas.size " + this.e.size(), new Object[0]);
            List<B> list2 = this.e;
            if (TextUtils.isEmpty(((SquareFeed) list2.get(list2.size() - 1)).bottomTips) && iM > 1 && this.e.size() - i <= iM / 2) {
                ma3.a("onBindViewHolder start auto load more ", new Object[0]);
                ((zt1) this.f).q();
            }
        }
        Activity activity = this.h;
        if (activity != null) {
            int i2 = this.g;
            if (i2 == 1) {
                wh5.Y(activity, 3, i);
                return;
            }
            if (i2 == 2) {
                wh5.V(activity, 3, i);
            } else if (i2 == 73) {
                wh5.W(activity, 3, i);
            } else if (i2 == 74) {
                wh5.X(activity, 3, i);
            }
        }
    }

    public void f(Activity activity) {
        this.h = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedItemView feedItemView = new FeedItemView(viewGroup.getContext());
        BaseViewHolder adViewHolder = i == 100 ? new NestTagHeaderViewHolder(feedItemView, this.g) : i == 1 ? new FeedTextViewHolder(feedItemView, this.g) : i == 2 ? new FeedImageViewHolder(feedItemView, this.g) : i == 8 ? new FeedVenusShareViewHolder(feedItemView, this.g) : i == 3 ? new FeedVideoViewHolder(feedItemView, this.g) : i == 10000 ? new SquareDividerViewHolder(feedItemView) : i == 100000 ? new FriendEmptyViewHolder(feedItemView) : i == 10 ? new MapFindTripHolder((FrameworkBaseActivity) this.h, feedItemView) : i == 101 ? new FootViewHolder(feedItemView) : i == 106 ? new FeedVipEnterHolder((FrameworkBaseActivity) this.h, feedItemView) : i == 102 ? new FeedTopicHeaderHolder(feedItemView) : i == 103 ? (n6.a() && n6.b(42) == n6.c) ? new AdViewHolder2(feedItemView, this.g) : new AdViewHolder(feedItemView, this.g) : new FeedImageViewHolder(feedItemView, this.g);
        adViewHolder.n(this.f);
        return adViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SquareFeed squareFeed = (SquareFeed) this.e.get(i);
        if (squareFeed.contactInfoItem != null) {
            return 100;
        }
        if (!TextUtils.isEmpty(squareFeed.bottomTips)) {
            return 101;
        }
        if (squareFeed.isVipBanner) {
            return 106;
        }
        if (squareFeed.isHeadTopic) {
            return 102;
        }
        if (squareFeed.adKey != null) {
            return 103;
        }
        return ((SquareFeed) this.e.get(i)).feedType;
    }
}
