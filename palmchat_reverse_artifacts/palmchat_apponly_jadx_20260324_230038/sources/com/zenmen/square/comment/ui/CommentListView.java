package com.zenmen.square.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommentListView extends RecyclerView {
    private c listener;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                CommentListView.this.checkLoadMore();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends LinearLayoutManager {
        public b(Context context, int i, boolean z) {
            super(context, i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();
    }

    public CommentListView(Context context) {
        this(context, null);
    }

    private void init() {
        setItemAnimator(null);
        setLayoutManager(new b(getContext(), 1, false));
        addOnScrollListener(new a());
    }

    public void checkLoadMore() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        if (linearLayoutManager == null) {
            return;
        }
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (getAdapter() != null && iFindLastVisibleItemPosition > getAdapter().getItemCount() - 6) {
            this.listener.a();
        }
    }

    public boolean needScrollToPosition(int i) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        return i <= linearLayoutManager.findFirstVisibleItemPosition() || i > linearLayoutManager.findLastVisibleItemPosition();
    }

    public int scrollToNextShotDate(int i) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i < iFindFirstVisibleItemPosition) {
            smoothScrollToPosition(i);
            return 0;
        }
        if (i > iFindLastVisibleItemPosition) {
            smoothScrollToPosition(i);
            return 0;
        }
        int top = getChildAt(i - iFindFirstVisibleItemPosition).getTop();
        smoothScrollBy(0, top);
        return top;
    }

    public void setOnLoadMoreListener(c cVar) {
        this.listener = cVar;
    }

    public CommentListView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CommentListView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
