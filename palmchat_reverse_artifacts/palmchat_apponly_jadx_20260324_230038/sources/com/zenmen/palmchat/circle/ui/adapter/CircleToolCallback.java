package com.zenmen.palmchat.circle.ui.adapter;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleToolCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f13259a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, int i2);
    }

    public CircleToolCallback(a aVar) {
        this.f13259a = aVar;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if ((recyclerView.getAdapter() instanceof CircleToolAdapter) && recyclerView.getAdapter().getItemViewType(viewHolder.getAdapterPosition()) == 1) {
            return ItemTouchHelper.Callback.makeMovementFlags(3, 32);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (this.f13259a != null) {
            int itemViewType = recyclerView.getAdapter().getItemViewType(viewHolder.getAdapterPosition());
            int itemViewType2 = recyclerView.getAdapter().getItemViewType(viewHolder2.getAdapterPosition());
            if (itemViewType != 1 || itemViewType2 != 1) {
                return false;
            }
            this.f13259a.a(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }
}
