package com.zenmen.square.mvp.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zenmen.square.databinding.FeedLayoutItemViewBinding;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.view.widget.FeedItemMultiPicView;
import com.zenmen.square.mvp.view.widget.FeedItemVenusView;
import com.zenmen.square.ui.widget.SquareItemVideoView;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FeedTextViewHolder extends FeedViewHolder {
    public FeedTextViewHolder(View view, int i) {
        super(view, i);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void A(FeedItemMultiPicView feedItemMultiPicView, SquareFeed squareFeed) {
        feedItemMultiPicView.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ((FeedLayoutItemViewBinding) this.d).H.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -a46.b(((FeedLayoutItemViewBinding) this.d).H.getContext(), 3.0f);
        layoutParams.goneTopMargin = -a46.b(((FeedLayoutItemViewBinding) this.d).H.getContext(), 3.0f);
        ((FeedLayoutItemViewBinding) this.d).H.setLayoutParams(layoutParams);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void B(FeedItemVenusView feedItemVenusView, SquareFeed squareFeed) {
        feedItemVenusView.setVisibility(8);
    }

    @Override // com.zenmen.square.mvp.holder.FeedViewHolder
    public void D(SquareItemVideoView squareItemVideoView, SquareFeed squareFeed) {
        squareItemVideoView.setVisibility(8);
    }
}
