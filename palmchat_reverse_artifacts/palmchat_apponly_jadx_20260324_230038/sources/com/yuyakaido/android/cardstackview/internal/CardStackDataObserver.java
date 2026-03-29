package com.yuyakaido.android.cardstackview.internal;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackDataObserver extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f11800a;

    public CardStackDataObserver(RecyclerView recyclerView) {
        this.f11800a = recyclerView;
    }

    public final CardStackLayoutManager a() {
        RecyclerView.LayoutManager layoutManager = this.f11800a.getLayoutManager();
        if (layoutManager instanceof CardStackLayoutManager) {
            return (CardStackLayoutManager) layoutManager;
        }
        throw new IllegalStateException("CardStackView must be set CardStackLayoutManager.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        CardStackLayoutManager cardStackLayoutManagerA = a();
        cardStackLayoutManagerA.m(Math.min(cardStackLayoutManagerA.f(), cardStackLayoutManagerA.getItemCount() - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        a().removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        CardStackLayoutManager cardStackLayoutManagerA = a();
        int iF = cardStackLayoutManagerA.f();
        if (cardStackLayoutManagerA.getItemCount() == 0) {
            cardStackLayoutManagerA.m(0);
        } else if (i < iF) {
            cardStackLayoutManagerA.m(Math.min(iF - (iF - i), cardStackLayoutManagerA.getItemCount() - 1));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
    }
}
