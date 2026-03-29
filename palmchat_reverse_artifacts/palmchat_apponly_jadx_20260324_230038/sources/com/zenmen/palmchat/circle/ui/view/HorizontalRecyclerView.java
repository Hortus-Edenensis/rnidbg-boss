package com.zenmen.palmchat.circle.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class HorizontalRecyclerView extends RecyclerView {
    private int downX;
    private int downY;
    private LinearItemDecoration linearItemDecoration;
    private int offsetX;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            HorizontalRecyclerView.this.offsetX -= i;
        }
    }

    public HorizontalRecyclerView(Context context) {
        this(context, null);
    }

    private void requestDisallowInterceptTouch(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i) {
        try {
            this.linearItemDecoration = (LinearItemDecoration) itemDecoration;
            super.addItemDecoration(itemDecoration, i);
        } catch (Exception unused) {
            throw new IllegalAccessError("You can only use LinearItemDecoration in  HorizontalRecyclerView");
        }
    }

    public LinearItemDecoration getItemDecoration() {
        return this.linearItemDecoration;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i) {
        return this.linearItemDecoration;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = (int) motionEvent.getX();
            this.downY = (int) motionEvent.getY();
        } else if (action == 2) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int i = x - this.downX;
            int i2 = y - this.downY;
            this.downX = x;
            this.downY = y;
            if (Math.abs(i) > Math.abs(i2) && ((i > 0 && canScrollHorizontally(-1)) || (i < 0 && canScrollHorizontally(1)))) {
                requestDisallowInterceptTouch(true);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollTo(int i, int i2) {
        scrollBy(this.offsetX - i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        super.setAdapter(adapter);
    }

    public HorizontalRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offsetX = 0;
        addOnScrollListener(new a());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        try {
            this.linearItemDecoration = (LinearItemDecoration) itemDecoration;
            super.addItemDecoration(itemDecoration);
        } catch (Exception unused) {
            throw new IllegalAccessError("You can only use LinearItemDecoration in  HorizontalRecyclerView");
        }
    }
}
