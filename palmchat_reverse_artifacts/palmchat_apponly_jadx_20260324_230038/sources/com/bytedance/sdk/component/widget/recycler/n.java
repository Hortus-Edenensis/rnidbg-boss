package com.bytedance.sdk.component.widget.recycler;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class n {
    private int fx;
    final Rect nr;
    protected final RecyclerView.a u;

    public abstract int b();

    public abstract int b(View view);

    public abstract int fx();

    public abstract int fx(View view);

    public abstract int iz();

    public abstract int iz(View view);

    public abstract int n();

    public int nr() {
        if (Integer.MIN_VALUE == this.fx) {
            return 0;
        }
        return iz() - this.fx;
    }

    public abstract int nr(View view);

    public abstract int pn();

    public abstract int pn(View view);

    public abstract int u(View view);

    public void u() {
        this.fx = iz();
    }

    public abstract void u(int i);

    public abstract int x();

    private n(RecyclerView.a aVar) {
        this.fx = Integer.MIN_VALUE;
        this.nr = new Rect();
        this.u = aVar;
    }

    public static n nr(RecyclerView.a aVar) {
        return new n(aVar) { // from class: com.bytedance.sdk.component.widget.recycler.n.2
            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int b() {
                return this.u.q() - this.u.gi();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int fx() {
                return this.u.kj();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int iz(View view) {
                RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
                return this.u.pn(view) + ((ViewGroup.MarginLayoutParams) jkVar).leftMargin + ((ViewGroup.MarginLayoutParams) jkVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int n() {
                return this.u.dw();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int nr(View view) {
                return this.u.jk(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.jk) view.getLayoutParams())).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int pn() {
                return this.u.q();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public void u(int i) {
                this.u.jk(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int x() {
                return this.u.gi();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int b(View view) {
                this.u.u(view, true, this.nr);
                return this.nr.top;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int fx(View view) {
                this.u.u(view, true, this.nr);
                return this.nr.bottom;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int pn(View view) {
                RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
                return this.u.iz(view) + ((ViewGroup.MarginLayoutParams) jkVar).topMargin + ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int u(View view) {
                return this.u.n(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.jk) view.getLayoutParams())).topMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int iz() {
                return (this.u.q() - this.u.kj()) - this.u.gi();
            }
        };
    }

    public static n u(RecyclerView.a aVar, int i) {
        if (i == 0) {
            return u(aVar);
        }
        if (i == 1) {
            return nr(aVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static n u(RecyclerView.a aVar) {
        return new n(aVar) { // from class: com.bytedance.sdk.component.widget.recycler.n.1
            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int b() {
                return this.u.c() - this.u.z();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int fx() {
                return this.u.qq();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int iz(View view) {
                RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
                return this.u.iz(view) + ((ViewGroup.MarginLayoutParams) jkVar).topMargin + ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int n() {
                return this.u.bq();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int nr(View view) {
                return this.u.a(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.jk) view.getLayoutParams())).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int pn() {
                return this.u.c();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public void u(int i) {
                this.u.a(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int x() {
                return this.u.z();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int b(View view) {
                this.u.u(view, true, this.nr);
                return this.nr.left;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int fx(View view) {
                this.u.u(view, true, this.nr);
                return this.nr.right;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int pn(View view) {
                RecyclerView.jk jkVar = (RecyclerView.jk) view.getLayoutParams();
                return this.u.pn(view) + ((ViewGroup.MarginLayoutParams) jkVar).leftMargin + ((ViewGroup.MarginLayoutParams) jkVar).rightMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int u(View view) {
                return this.u.x(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.jk) view.getLayoutParams())).leftMargin;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.n
            public int iz() {
                return (this.u.c() - this.u.qq()) - this.u.z();
            }
        };
    }
}
