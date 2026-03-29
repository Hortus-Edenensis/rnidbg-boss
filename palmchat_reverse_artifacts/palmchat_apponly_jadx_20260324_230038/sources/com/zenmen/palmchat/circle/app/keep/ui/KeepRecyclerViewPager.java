package com.zenmen.palmchat.circle.app.keep.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class KeepRecyclerViewPager extends RecyclerView {
    private int curPos;
    private View curView;
    private boolean isFirstShow;
    private KeepSmoothScrollLayoutManager linearLayoutManager;
    private View scrollTargetView;
    private PagerSnapHelper snapHelper;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                View viewFindSnapView = KeepRecyclerViewPager.this.snapHelper.findSnapView(KeepRecyclerViewPager.this.linearLayoutManager);
                if (viewFindSnapView != null) {
                    KeepRecyclerViewPager keepRecyclerViewPager = KeepRecyclerViewPager.this;
                    keepRecyclerViewPager.curPos = keepRecyclerViewPager.linearLayoutManager.getPosition(viewFindSnapView);
                }
                if (viewFindSnapView == KeepRecyclerViewPager.this.curView) {
                    return;
                }
                if (KeepRecyclerViewPager.this.curView != null && (viewFindSnapView instanceof KeepMotionItemView)) {
                    ((KeepMotionItemView) viewFindSnapView).onPageUnSelected();
                }
                KeepRecyclerViewPager.this.curView = viewFindSnapView;
                if (viewFindSnapView instanceof KeepMotionItemView) {
                    Log.d("KeepRecyclerViewPager", "滑动停止，当前是KeepMotionItemView");
                    ((KeepMotionItemView) viewFindSnapView).onPageSelected();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    public KeepRecyclerViewPager(Context context) {
        super(context);
        this.isFirstShow = true;
        init();
    }

    private void init() {
        KeepSmoothScrollLayoutManager keepSmoothScrollLayoutManager = new KeepSmoothScrollLayoutManager(getContext(), 0, false);
        this.linearLayoutManager = keepSmoothScrollLayoutManager;
        setLayoutManager(keepSmoothScrollLayoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.snapHelper = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this);
        addOnChildAttachStateChangeListener(new a());
        addOnScrollListener(new b());
    }

    public int getCurPos() {
        return this.curPos;
    }

    public View getCurView() {
        return this.snapHelper.findSnapView(this.linearLayoutManager);
    }

    public void next() {
        smoothScrollToPosition(this.curPos + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        View viewFindSnapView;
        super.onScrolled(i, i2);
        if (getScrollState() != 2 || this.scrollTargetView == (viewFindSnapView = this.snapHelper.findSnapView(this.linearLayoutManager))) {
            return;
        }
        this.scrollTargetView = viewFindSnapView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void prev() {
        smoothScrollToPosition(Math.max(0, this.curPos - 1));
    }

    public KeepRecyclerViewPager(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFirstShow = true;
        init();
    }

    public KeepRecyclerViewPager(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isFirstShow = true;
        init();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements RecyclerView.OnChildAttachStateChangeListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NonNull View view) {
            Log.d("KeepRecyclerViewPager", "child加载");
            if (KeepRecyclerViewPager.this.isFirstShow) {
                KeepRecyclerViewPager.this.curPos = 0;
                if (view instanceof KeepMotionItemView) {
                    Log.d("KeepRecyclerViewPager", "child加载，当前是KeepMotionItemView");
                    ((KeepMotionItemView) view).onPageSelected();
                }
                KeepRecyclerViewPager.this.isFirstShow = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NonNull View view) {
        }
    }
}
