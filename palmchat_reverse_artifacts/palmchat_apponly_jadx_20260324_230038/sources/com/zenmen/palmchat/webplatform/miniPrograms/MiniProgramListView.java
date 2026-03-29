package com.zenmen.palmchat.webplatform.miniPrograms;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import com.zenmen.palmchat.ui.widget.pullrecyclerview.PullRefreshFooter;
import defpackage.b74;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MiniProgramListView extends ListView {
    private final String TAG;
    private PullRefreshFooter footerView;
    private b74 onLoadMoreListener;
    AbsListView.OnScrollListener onScrollListener;

    public MiniProgramListView(Context context) {
        super(context);
        this.TAG = "MiniProgramListView";
        this.onScrollListener = new a();
    }

    public void compelete(boolean z) {
        Log.i("MiniProgramListView", "compelete");
        if (z) {
            this.footerView.onNoMoreContent();
        } else {
            this.footerView.onFinish();
        }
    }

    public void setOnLoadMoreListener(b74 b74Var) {
        this.onLoadMoreListener = b74Var;
    }

    public MiniProgramListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MiniProgramListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MiniProgramListView";
        AbsListView.OnScrollListener aVar = new a();
        this.onScrollListener = aVar;
        setOnScrollListener(aVar);
        PullRefreshFooter pullRefreshFooter = new PullRefreshFooter(getContext());
        this.footerView = pullRefreshFooter;
        addFooterView(pullRefreshFooter);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MiniProgramListView.this.onLoadMoreListener != null) {
                MiniProgramListView.this.onLoadMoreListener.a();
                MiniProgramListView.this.footerView.onRefreshing();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }
}
