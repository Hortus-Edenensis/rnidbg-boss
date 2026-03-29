package com.zenmen.square.mvp.holder;

import android.view.View;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedVenusShareViewHolder extends FeedViewHolder {
    public float v;

    public FeedVenusShareViewHolder(View view, int i) {
        super(view, i);
        this.v = 100.0f;
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void A(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).k.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void B(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed) {
        List<Media> list;
        if (squareFeed == null || (list = squareFeed.mediaList) == null || list.isEmpty()) {
            return;
        }
        feedItemVenusView.setVisibility(0);
        feedItemVenusView.setMediaList(squareFeed.mediaList, squareFeed.liveFlag);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void D(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).n.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void v() {
        super.v();
    }
}
