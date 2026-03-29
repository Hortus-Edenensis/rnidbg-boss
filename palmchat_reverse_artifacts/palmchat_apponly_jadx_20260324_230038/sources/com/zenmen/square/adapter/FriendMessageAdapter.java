package com.zenmen.square.adapter;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.zenmen.listui.list.BaseRecyclerAdapter;
import com.zenmen.listui.list.BaseViewHolder;
import com.zenmen.square.mvp.holder.FootViewHolder;
import com.zenmen.square.mvp.holder.FriendMessageViewHolder;
import com.zenmen.square.mvp.model.bean.PlaceFeed;
import defpackage.m42;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FriendMessageAdapter extends BaseRecyclerAdapter<BaseViewHolder, PlaceFeed, m42> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        BaseViewHolder footViewHolder = i == 1 ? new FootViewHolder(relativeLayout) : new FriendMessageViewHolder(relativeLayout);
        footViewHolder.n(this.f);
        return footViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return ((PlaceFeed) this.e.get(i)).isBottomTip() ? 1 : 2;
    }
}
