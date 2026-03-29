package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.internal.CardStackDataObserver;
import com.yuyakaido.android.cardstackview.internal.CardStackSnapHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackView extends RecyclerView {
    private final CardStackDataObserver observer;

    public CardStackView(Context context) {
        this(context, null);
    }

    private void initialize() {
        new CardStackSnapHelper().attachToRecyclerView(this);
        setOverScrollMode(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            if (motionEvent.getY(motionEvent.getActionIndex()) > getHeight() - getPaddingBottom()) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        CardStackLayoutManager cardStackLayoutManager;
        if (motionEvent.getAction() == 0 && (cardStackLayoutManager = (CardStackLayoutManager) getLayoutManager()) != null) {
            cardStackLayoutManager.s(motionEvent.getX(), motionEvent.getY());
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void rewind() {
        if (getLayoutManager() instanceof CardStackLayoutManager) {
            smoothScrollToPosition(((CardStackLayoutManager) getLayoutManager()).f() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (getLayoutManager() == null) {
            setLayoutManager(new CardStackLayoutManager(getContext()));
        }
        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(this.observer);
            getAdapter().onDetachedFromRecyclerView(this);
        }
        adapter.registerAdapterDataObserver(this.observer);
        super.setAdapter(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof CardStackLayoutManager)) {
            throw new IllegalArgumentException("CardStackView must be set CardStackLayoutManager.");
        }
        super.setLayoutManager(layoutManager);
    }

    public void swipe() {
        if (getLayoutManager() instanceof CardStackLayoutManager) {
            smoothScrollToPosition(((CardStackLayoutManager) getLayoutManager()).f() + 1);
        }
    }

    public CardStackView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardStackView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.observer = new CardStackDataObserver(this);
        initialize();
    }
}
