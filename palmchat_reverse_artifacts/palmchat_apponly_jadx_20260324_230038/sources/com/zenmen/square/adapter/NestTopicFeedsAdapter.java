package com.zenmen.square.adapter;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.mvp.holder.FeedImageViewHolder;
import com.zenmen.square.mvp.holder.FootViewHolder;
import com.zenmen.square.mvp.holder.NestTopicFeedViewHolder;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.FeedItemView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NestTopicFeedsAdapter extends FeedsAdapter {
    public NestTopicFeedsAdapter(int i) {
        super(i);
    }

    @Override // com.zenmen.square.adapter.FeedsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedItemView feedItemView = new FeedItemView(viewGroup.getContext());
        BaseViewHolder nestTopicFeedViewHolder = (i == 2 || i == 3 || i == 1) ? new NestTopicFeedViewHolder(feedItemView) : i == 101 ? new FootViewHolder(feedItemView) : new FeedImageViewHolder(feedItemView, 6);
        nestTopicFeedViewHolder.n(this.f);
        return nestTopicFeedViewHolder;
    }

    @Override // com.zenmen.square.adapter.FeedsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (TextUtils.isEmpty(((SquareFeed) this.e.get(i)).bottomTips)) {
            return ((SquareFeed) this.e.get(i)).feedType;
        }
        return 101;
    }
}
