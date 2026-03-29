package com.zenmen.palmchat.widget.horizontalgridpager;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PageGridView extends RecyclerView {
    private PageGridAdapter adapter;
    private int column;
    private int currentPage;
    private PageIndicatorView pageIndicatorView;
    private int row;
    private int scrollStatus;
    private float scrollX;
    private float swipeDistance;
    private int swipePercent;
    private int totalPage;
    private int validDistance;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends GridLayoutManager {
        public a(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (PageGridView.this.totalPage > 1) {
                return super.scrollHorizontallyBy(i, recycler, state);
            }
            return 0;
        }
    }

    public PageGridView(Context context, int[] iArr, int i) {
        super(context);
        this.swipeDistance = 0.0f;
        this.currentPage = 1;
        this.scrollX = 0.0f;
        this.scrollStatus = 0;
        this.row = iArr[0];
        this.column = iArr[1];
        this.swipePercent = i;
        setOverScrollMode(2);
        setLayoutManager(new a(getContext(), this.row, 0, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.swipePercent;
        if (i3 < 1) {
            this.swipePercent = 1;
        } else if (i3 > 100) {
            this.swipePercent = 100;
        }
        this.validDistance = (getMeasuredWidth() * this.swipePercent) / 100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            float f = this.swipeDistance;
            if (f != 0.0f) {
                this.scrollStatus = 0;
                if (f < 0.0f) {
                    this.currentPage = (int) Math.ceil(this.scrollX / getWidth());
                    if ((r0 * getWidth()) - this.scrollX < this.validDistance) {
                        this.currentPage++;
                    }
                } else {
                    int iCeil = ((int) Math.ceil(this.scrollX / getWidth())) + 1;
                    this.currentPage = iCeil;
                    int i2 = this.totalPage;
                    if (iCeil > i2) {
                        this.currentPage = i2;
                    } else if (this.scrollX - ((iCeil - 2) * getWidth()) < this.validDistance) {
                        this.currentPage--;
                    }
                }
                smoothScrollBy((int) (((this.currentPage - 1) * getWidth()) - this.scrollX), 0);
                this.pageIndicatorView.update(this.currentPage - 1);
                this.swipeDistance = 0.0f;
            }
        } else if (i == 1) {
            this.scrollStatus = 1;
        } else if (i == 2) {
            this.scrollStatus = 2;
        }
        super.onScrollStateChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        float f = i;
        this.scrollX += f;
        if (this.scrollStatus == 1) {
            this.swipeDistance += f;
        }
        super.onScrolled(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.adapter != null) {
            update();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.adapter = (PageGridAdapter) adapter;
    }

    public void setIndicator(PageIndicatorView pageIndicatorView) {
        this.pageIndicatorView = pageIndicatorView;
    }

    public void update() {
        int iCeil = (int) Math.ceil(((double) this.adapter.c().size()) / ((double) (this.row * this.column)));
        if (iCeil != this.totalPage) {
            this.pageIndicatorView.initIndicator(iCeil);
            int i = this.totalPage;
            if (iCeil < i && this.currentPage == i) {
                this.currentPage = iCeil;
                smoothScrollBy(-getWidth(), 0);
            }
            this.pageIndicatorView.update(this.currentPage - 1);
            this.totalPage = iCeil;
        }
        if (this.totalPage > 1) {
            this.pageIndicatorView.setVisibility(0);
        } else {
            this.pageIndicatorView.setVisibility(8);
        }
    }
}
