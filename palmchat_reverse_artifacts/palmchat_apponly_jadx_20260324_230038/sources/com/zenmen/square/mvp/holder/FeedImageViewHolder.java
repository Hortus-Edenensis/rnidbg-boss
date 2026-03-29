package com.zenmen.square.mvp.holder;

import android.view.View;
import android.view.ViewGroup;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import defpackage.l50;
import defpackage.zt1;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedImageViewHolder extends FeedViewHolder implements FeedItemMultiPicView.b {
    public float v;
    public long w;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedItemMultiPicView f16421a;
        public final /* synthetic */ SquareFeed b;

        public a(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
            this.f16421a = feedItemMultiPicView;
            this.b = squareFeed;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16421a.setMediaList(this.b.mediaList);
        }
    }

    public FeedImageViewHolder(View view, int i) {
        super(view, i);
        this.v = 100.0f;
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void A(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
        List<Media> list;
        if (squareFeed == null || (list = squareFeed.mediaList) == null || list.isEmpty()) {
            return;
        }
        long j = this.w;
        long j2 = squareFeed.id;
        if (j == j2) {
            return;
        }
        this.w = j2;
        feedItemMultiPicView.setVisibility(0);
        N(feedItemMultiPicView);
        feedItemMultiPicView.clearImage();
        feedItemMultiPicView.post(new a(feedItemMultiPicView, squareFeed));
        feedItemMultiPicView.setOnPicClickListener(this);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void B(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).m.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void D(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).n.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void N(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.square.mvp.view.widget.FeedItemMultiPicView.b
    public void k(int i) {
        if (l50.a()) {
            return;
        }
        SquareFeed squareFeedO = ((FeedLayoutItemViewBinding) this.d).o();
        List<Media> list = squareFeedO.mediaList;
        if (list == null || list.size() <= i) {
            i = 0;
        }
        squareFeedO.targetMediaPosition = i;
        ((zt1) this.e).L(squareFeedO);
    }
}
