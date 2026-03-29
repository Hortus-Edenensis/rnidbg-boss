package com.zenmen.square.mvp.holder;

import android.view.View;
import android.view.ViewGroup;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import com.zenmen.square.fragment.FeedsFragment;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import defpackage.zm;
import defpackage.zt1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedVideoViewHolder extends FeedViewHolder implements zm {
    public FeedVideoViewHolder(View view, int i) {
        super(view, i);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void A(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).k.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void B(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed) {
        ((FeedLayoutItemViewBinding) this.d).m.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void D(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed) {
        squareItemVideoView.setVisibility(0);
        N(squareItemVideoView);
        squareItemVideoView.bindMedia(((FeedLayoutItemViewBinding) this.d).o(), squareItemVideoView.getLayoutParams().width, squareItemVideoView.getLayoutParams().height, this.f, ((FeedsFragment) ((zt1) this.e).p()).G0());
    }

    @Override // defpackage.zm
    public boolean canPlay() {
        return ((FeedLayoutItemViewBinding) this.d).n.canPlay();
    }

    @Override // defpackage.zm
    public ViewGroup getContainerView() {
        return ((FeedLayoutItemViewBinding) this.d).n.getContainerView();
    }

    @Override // defpackage.zm
    public String getPlayPath() {
        return ((FeedLayoutItemViewBinding) this.d).n.getPlayPath();
    }

    @Override // defpackage.zm
    public boolean isZooming() {
        return ((FeedLayoutItemViewBinding) this.d).n.isZooming();
    }

    @Override // defpackage.zm
    public void onPlayPause() {
        ((FeedLayoutItemViewBinding) this.d).n.onPlayPause();
    }

    @Override // defpackage.zm
    public void onPlayRelease() {
        ((FeedLayoutItemViewBinding) this.d).n.onPlayRelease();
    }

    @Override // defpackage.zm
    public void onPlayResume() {
        ((FeedLayoutItemViewBinding) this.d).n.onPlayResume();
    }

    @Override // defpackage.zm
    public void onPlayStart(String str) {
        ((FeedLayoutItemViewBinding) this.d).n.onPlayStart(str);
    }
}
