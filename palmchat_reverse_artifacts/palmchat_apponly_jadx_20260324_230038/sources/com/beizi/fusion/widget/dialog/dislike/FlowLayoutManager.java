package com.beizi.fusion.widget.dialog.dislike;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class FlowLayoutManager extends RecyclerView.LayoutManager {
    private static final String e = "FlowLayoutManager";
    protected int b;
    protected int c;
    private int f;
    private int g;
    private int h;
    private int i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final FlowLayoutManager f4801a = this;
    private int j = 0;
    protected int d = 0;
    private b k = new b();
    private List<b> l = new ArrayList();
    private SparseArray<Rect> m = new SparseArray<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4802a;
        View b;
        Rect c;

        public a(int i, View view, Rect rect) {
            this.f4802a = i;
            this.b = view;
            this.c = rect;
        }

        public void a(Rect rect) {
            this.c = rect;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f4803a;
        float b;
        List<a> c = new ArrayList();

        public b() {
        }

        public void a(float f) {
            this.f4803a = f;
        }

        public void b(float f) {
            this.b = f;
        }

        public void a(a aVar) {
            this.c.add(aVar);
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || getItemCount() == 0) {
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.j, getWidth() - getPaddingRight(), this.j + (getHeight() - getPaddingBottom()));
        for (int i = 0; i < this.l.size(); i++) {
            b bVar = this.l.get(i);
            float f = bVar.f4803a;
            List<a> list = bVar.c;
            for (int i2 = 0; i2 < list.size(); i2++) {
                View view = list.get(i2).b;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i2).c;
                int i3 = rect.left;
                int i4 = rect.top;
                int i5 = this.j;
                layoutDecoratedWithMargins(view, i3, i4 - i5, rect.right, rect.bottom - i5);
            }
        }
    }

    private int b() {
        return (this.f4801a.getHeight() - this.f4801a.getPaddingBottom()) - this.f4801a.getPaddingTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.d = 0;
        int i = this.g;
        this.k = new b();
        this.l.clear();
        this.m.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(recycler);
            this.j = 0;
            return;
        }
        if (getChildCount() == 0 && state.isPreLayout()) {
            return;
        }
        detachAndScrapAttachedViews(recycler);
        if (getChildCount() == 0) {
            this.b = getWidth();
            this.c = getHeight();
            this.f = getPaddingLeft();
            this.h = getPaddingRight();
            this.g = getPaddingTop();
            this.i = (this.b - this.f) - this.h;
        }
        int i2 = 0;
        int iMax = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            View viewForPosition = recycler.getViewForPosition(i3);
            if (8 != viewForPosition.getVisibility()) {
                measureChildWithMargins(viewForPosition, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
                int i4 = i2 + decoratedMeasuredWidth;
                if (i4 <= this.i) {
                    int i5 = this.f + i2;
                    Rect rect = this.m.get(i3);
                    if (rect == null) {
                        rect = new Rect();
                    }
                    rect.set(i5, i, decoratedMeasuredWidth + i5, i + decoratedMeasuredHeight);
                    this.m.put(i3, rect);
                    iMax = Math.max(iMax, decoratedMeasuredHeight);
                    this.k.a(new a(decoratedMeasuredHeight, viewForPosition, rect));
                    this.k.a(i);
                    this.k.b(iMax);
                    i2 = i4;
                } else {
                    a();
                    i += iMax;
                    this.d += iMax;
                    int i6 = this.f;
                    Rect rect2 = this.m.get(i3);
                    if (rect2 == null) {
                        rect2 = new Rect();
                    }
                    rect2.set(i6, i, i6 + decoratedMeasuredWidth, i + decoratedMeasuredHeight);
                    this.m.put(i3, rect2);
                    this.k.a(new a(decoratedMeasuredHeight, viewForPosition, rect2));
                    this.k.a(i);
                    this.k.b(decoratedMeasuredHeight);
                    i2 = decoratedMeasuredWidth;
                    iMax = decoratedMeasuredHeight;
                }
                if (i3 == getItemCount() - 1) {
                    a();
                    this.d += iMax;
                }
            }
        }
        this.d = Math.max(this.d, b());
        a(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2 = this.j;
        if (i2 + i < 0) {
            i = -i2;
        } else if (i2 + i > this.d - b()) {
            i = (this.d - b()) - this.j;
        }
        this.j += i;
        offsetChildrenVertical(-i);
        a(recycler, state);
        return i;
    }

    private void a() {
        List<a> list = this.k.c;
        for (int i = 0; i < list.size(); i++) {
            a aVar = list.get(i);
            int position = getPosition(aVar.b);
            float f = this.m.get(position).top;
            b bVar = this.k;
            if (f < bVar.f4803a + ((bVar.b - list.get(i).f4802a) / 2.0f)) {
                Rect rect = this.m.get(position);
                if (rect == null) {
                    rect = new Rect();
                }
                int i2 = this.m.get(position).left;
                b bVar2 = this.k;
                int i3 = (int) (bVar2.f4803a + ((bVar2.b - list.get(i).f4802a) / 2.0f));
                int i4 = this.m.get(position).right;
                b bVar3 = this.k;
                rect.set(i2, i3, i4, (int) (bVar3.f4803a + ((bVar3.b - list.get(i).f4802a) / 2.0f) + getDecoratedMeasuredHeight(r3)));
                this.m.put(position, rect);
                aVar.a(rect);
                list.set(i, aVar);
            }
        }
        b bVar4 = this.k;
        bVar4.c = list;
        this.l.add(bVar4);
        this.k = new b();
    }
}
