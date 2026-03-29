package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bytedance.sdk.component.widget.recycler.b;
import com.bytedance.sdk.component.widget.recycler.mv;
import com.bytedance.sdk.component.widget.recycler.nr;
import com.bytedance.sdk.component.widget.recycler.s;
import com.bytedance.sdk.component.widget.recycler.u;
import com.ss.bytertc.engine.type.ErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.u.fx.fx {
    static final boolean b;
    private static final boolean bc;
    static final boolean fx;
    static final Interpolator m;
    static final boolean nr;
    private static final Class<?>[] oa;
    static final boolean u;
    private static final boolean xw;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f5177a;
    private final AccessibilityManager ay;
    boolean bf;
    boolean bg;
    boolean bq;
    boolean c;
    private final Rect cj;
    b.u d;
    private float dc;
    private com.bytedance.sdk.component.widget.recycler.u.fx.b df;
    private iz.u dj;
    boolean dw;
    private int eh;
    private final int[] ex;
    private int f;
    private EdgeEffect gc;
    private int ge;
    com.bytedance.sdk.component.widget.recycler.b gi;
    final bq h;
    private Runnable hs;
    private s i;
    com.bytedance.sdk.component.widget.recycler.u iz;
    boolean ja;
    final Runnable jk;
    private int ju;
    private l jw;
    o k;
    private final int[] ki;
    iz kj;
    private EdgeEffect kw;
    final RectF l;
    private int lf;
    private boolean mh;
    private EdgeEffect mk;
    u mv;
    final ArrayList<n> my;
    final com.bytedance.sdk.component.widget.recycler.s n;
    private pn nb;
    boolean o;
    private int ob;
    private EdgeEffect p;
    final int[] pb;
    final my pn;
    boolean q;
    private List<s> qe;
    boolean qq;
    private final int rg;
    boolean rh;
    private int rv;
    a s;
    private boolean sf;
    private int su;
    boolean sx;
    final Rect t;
    private final s.nr te;
    private final ArrayList<mv> tk;
    private VelocityTracker tm;
    private b tr;
    private float ua;
    private final int uq;
    private List<t> v;
    private final sx w;
    private mv wi;
    final int[] wq;
    com.bytedance.sdk.component.widget.recycler.nr x;
    final List<q> xg;
    private int yd;
    final c z;
    private int za;
    private final int[] zq;
    private int zx;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private static final int[] f5176jp = {R.attr.nestedScrollingEnabled};
    private static final int[] y = {R.attr.clipToPadding};

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RecyclerView f5178a;
        private boolean b;
        private boolean fx;
        private int iz;
        com.bytedance.sdk.component.widget.recycler.mv jk;
        boolean k;
        bg l;
        boolean mv;
        int my;
        com.bytedance.sdk.component.widget.recycler.nr n;
        private final mv.nr nr;
        boolean o;
        private int pn;
        boolean s;
        private int sx;
        com.bytedance.sdk.component.widget.recycler.mv t;
        private final mv.nr u;
        private int x;

        /* JADX INFO: compiled from: SearchBox */
        public interface u {
            void nr(int i, int i2);
        }

        public a() {
            mv.nr nrVar = new mv.nr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.a.1
                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int nr() {
                    return a.this.c() - a.this.z();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public View u(int i) {
                    return a.this.n(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int nr(View view) {
                    return a.this.a(view) + ((ViewGroup.MarginLayoutParams) ((jk) view.getLayoutParams())).rightMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int u() {
                    return a.this.qq();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int u(View view) {
                    return a.this.x(view) - ((ViewGroup.MarginLayoutParams) ((jk) view.getLayoutParams())).leftMargin;
                }
            };
            this.u = nrVar;
            mv.nr nrVar2 = new mv.nr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.a.2
                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int nr() {
                    return a.this.q() - a.this.gi();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public View u(int i) {
                    return a.this.n(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int nr(View view) {
                    return a.this.jk(view) + ((ViewGroup.MarginLayoutParams) ((jk) view.getLayoutParams())).bottomMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int u() {
                    return a.this.kj();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.mv.nr
                public int u(View view) {
                    return a.this.n(view) - ((ViewGroup.MarginLayoutParams) ((jk) view.getLayoutParams())).topMargin;
                }
            };
            this.nr = nrVar2;
            this.jk = new com.bytedance.sdk.component.widget.recycler.mv(nrVar);
            this.t = new com.bytedance.sdk.component.widget.recycler.mv(nrVar2);
            this.mv = false;
            this.s = false;
            this.k = false;
            this.fx = true;
            this.b = true;
        }

        public boolean a() {
            return false;
        }

        public int b(bq bqVar) {
            return 0;
        }

        public void bf() {
            bg bgVar = this.l;
            if (bgVar != null) {
                bgVar.pn();
            }
        }

        public int bg() {
            com.bytedance.sdk.component.widget.recycler.nr nrVar = this.n;
            if (nrVar != null) {
                return nrVar.nr();
            }
            return 0;
        }

        public int bq() {
            return this.pn;
        }

        public int c() {
            return this.x;
        }

        public View d() {
            View focusedChild;
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.n.fx(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int dw() {
            return this.iz;
        }

        public int fx(bq bqVar) {
            return 0;
        }

        public int gi() {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int h() {
            RecyclerView recyclerView = this.f5178a;
            u adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.u();
            }
            return 0;
        }

        public int iz(bq bqVar) {
            return 0;
        }

        public int ja() {
            return com.bytedance.sdk.component.widget.recycler.u.fx.x.pn(this.f5178a);
        }

        public void jk(int i) {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                recyclerView.pn(i);
            }
        }

        public boolean k() {
            RecyclerView recyclerView = this.f5178a;
            return recyclerView != null && recyclerView.f5177a;
        }

        public int kj() {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean l() {
            return false;
        }

        public void mv() {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public boolean my() {
            bg bgVar = this.l;
            return bgVar != null && bgVar.x();
        }

        public int n(bq bqVar) {
            return 0;
        }

        public int nr(int i, my myVar, bq bqVar) {
            return 0;
        }

        public abstract jk nr();

        public int o() {
            return com.bytedance.sdk.component.widget.recycler.u.fx.x.u(this.f5178a);
        }

        public int pn(bq bqVar) {
            return 0;
        }

        public int q() {
            return this.sx;
        }

        public int qq() {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int rh() {
            return com.bytedance.sdk.component.widget.recycler.u.fx.x.b(this.f5178a);
        }

        public final boolean s() {
            return this.b;
        }

        public int sx() {
            return -1;
        }

        public void t(int i) {
        }

        public int u(int i, my myVar, bq bqVar) {
            return 0;
        }

        public boolean wq() {
            int iBg = bg();
            for (int i = 0; i < iBg; i++) {
                ViewGroup.LayoutParams layoutParams = n(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int x(bq bqVar) {
            return 0;
        }

        public int z() {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void a(int i) {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                recyclerView.iz(i);
            }
        }

        public View b(View view, int i) {
            return null;
        }

        public void fx(RecyclerView recyclerView) {
        }

        public void iz(int i) {
            if (n(i) != null) {
                this.n.u(i);
            }
        }

        public int l(View view) {
            return ((jk) view.getLayoutParams()).nr.bottom;
        }

        public View n(int i) {
            com.bytedance.sdk.component.widget.recycler.nr nrVar = this.n;
            if (nrVar != null) {
                return nrVar.nr(i);
            }
            return null;
        }

        public void nr(bq bqVar) {
        }

        public int pn(View view) {
            Rect rect = ((jk) view.getLayoutParams()).nr;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int s(View view) {
            return ((jk) view.getLayoutParams()).nr.right;
        }

        public int t(View view) {
            return ((jk) view.getLayoutParams()).nr.top;
        }

        public View u(View view, int i, my myVar, bq bqVar) {
            return null;
        }

        public void x(int i) {
            u(i, n(i));
        }

        public void b(int i) {
        }

        public boolean fx() {
            return false;
        }

        public int jk(View view) {
            return view.getBottom() + l(view);
        }

        public int mv(View view) {
            return ((jk) view.getLayoutParams()).nr.left;
        }

        public int n(View view) {
            return view.getTop() - t(view);
        }

        public void nr(int i, int i2) {
            this.x = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.pn = mode;
            if (mode == 0 && !RecyclerView.nr) {
                this.x = 0;
            }
            this.sx = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.iz = mode2;
            if (mode2 != 0 || RecyclerView.nr) {
                return;
            }
            this.sx = 0;
        }

        public void u(int i, int i2, bq bqVar, u uVar) {
        }

        public int x(View view) {
            return view.getLeft() - mv(view);
        }

        public int a(View view) {
            return view.getRight() + s(view);
        }

        public boolean b() {
            return false;
        }

        public void fx(int i, int i2) {
            int iBg = bg();
            if (iBg == 0) {
                this.f5178a.pn(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iBg; i7++) {
                View viewN = n(i7);
                Rect rect = this.f5178a.t;
                u(viewN, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.f5178a.t.set(i5, i6, i3, i4);
            u(this.f5178a.t, i, i2);
        }

        public int iz(View view) {
            Rect rect = ((jk) view.getLayoutParams()).nr;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void pn(int i, int i2) {
            this.f5178a.setMeasuredDimension(i, i2);
        }

        public void u(int i, u uVar) {
        }

        public int b(View view) {
            return ((jk) view.getLayoutParams()).b();
        }

        public void u(RecyclerView recyclerView, my myVar) {
        }

        public void b(int i, int i2) {
            View viewN = n(i);
            if (viewN != null) {
                x(i);
                fx(viewN, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f5178a.toString());
            }
        }

        public boolean u(jk jkVar) {
            return jkVar != null;
        }

        public boolean u(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void u(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f5178a = null;
                this.n = null;
                this.x = 0;
                this.sx = 0;
            } else {
                this.f5178a = recyclerView;
                this.n = recyclerView.x;
                this.x = recyclerView.getWidth();
                this.sx = recyclerView.getHeight();
            }
            this.pn = 1073741824;
            this.iz = 1073741824;
        }

        public void b(RecyclerView recyclerView) {
            nr(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public void nr(RecyclerView recyclerView) {
            this.s = true;
            fx(recyclerView);
        }

        public void nr(RecyclerView recyclerView, my myVar) {
            this.s = false;
            u(recyclerView, myVar);
        }

        public void fx(View view) {
            this.n.u(view);
        }

        public void nr(View view) {
            nr(view, -1);
        }

        public void fx(View view, int i) {
            u(view, i, (jk) view.getLayoutParams());
        }

        public void nr(View view, int i) {
            u(view, i, false);
        }

        public void fx(my myVar) {
            for (int iBg = bg() - 1; iBg >= 0; iBg--) {
                if (!RecyclerView.pn(n(iBg)).N_()) {
                    u(iBg, myVar);
                }
            }
        }

        public View nr(int i) {
            int iBg = bg();
            for (int i2 = 0; i2 < iBg; i2++) {
                View viewN = n(i2);
                q qVarPn = RecyclerView.pn(viewN);
                if (qVarPn != null && qVarPn.b() == i && !qVarPn.N_() && (this.f5178a.h.u() || !qVarPn.o())) {
                    return viewN;
                }
            }
            return null;
        }

        public void u(Rect rect, int i, int i2) {
            pn(u(i, rect.width() + qq() + z(), rh()), u(i2, rect.height() + kj() + gi(), ja()));
        }

        public void nr(my myVar) {
            int iPn = myVar.pn();
            for (int i = iPn - 1; i >= 0; i--) {
                View viewB = myVar.b(i);
                q qVarPn = RecyclerView.pn(viewB);
                if (!qVarPn.N_()) {
                    qVarPn.u(false);
                    if (qVarPn.sx()) {
                        this.f5178a.removeDetachedView(viewB, false);
                    }
                    iz izVar = this.f5178a.kj;
                    if (izVar != null) {
                        izVar.b(qVarPn);
                    }
                    qVarPn.u(true);
                    myVar.nr(viewB);
                }
            }
            myVar.iz();
            if (iPn > 0) {
                this.f5178a.invalidate();
            }
        }

        public static int u(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void u(String str) {
            RecyclerView recyclerView = this.f5178a;
            if (recyclerView != null) {
                recyclerView.u(str);
            }
        }

        public boolean u() {
            return this.k;
        }

        public void u(my myVar, bq bqVar) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public jk u(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof jk) {
                return new jk((jk) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new jk((ViewGroup.MarginLayoutParams) layoutParams) : new jk(layoutParams);
        }

        private static boolean nr(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public jk u(Context context, AttributeSet attributeSet) {
            return new jk(context, attributeSet);
        }

        public void u(RecyclerView recyclerView, bq bqVar, int i) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        private int[] nr(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iQq = qq();
            int iKj = kj();
            int iC = c() - z();
            int iQ = q() - gi();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iQq;
            int iMin = Math.min(0, i);
            int i2 = top - iKj;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iC;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iQ);
            if (o() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public void u(bg bgVar) {
            bg bgVar2 = this.l;
            if (bgVar2 != null && bgVar != bgVar2 && bgVar2.x()) {
                this.l.pn();
            }
            this.l = bgVar;
            bgVar.u(this.f5178a, this);
        }

        public void u(View view) {
            u(view, -1);
        }

        public void u(View view, int i) {
            u(view, i, true);
        }

        private void u(View view, int i, boolean z) {
            q qVarPn = RecyclerView.pn(view);
            if (!z && !qVarPn.o()) {
                this.f5178a.n.iz(qVarPn);
            } else {
                this.f5178a.n.pn(qVarPn);
            }
            jk jkVar = (jk) view.getLayoutParams();
            if (!qVarPn.t() && !qVarPn.a()) {
                if (view.getParent() == this.f5178a) {
                    int iNr = this.n.nr(view);
                    if (i == -1) {
                        i = this.n.nr();
                    }
                    if (iNr == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f5178a.indexOfChild(view) + this.f5178a.u());
                    }
                    if (iNr != i) {
                        this.f5178a.s.b(iNr, i);
                    }
                } else {
                    this.n.u(view, i, false);
                    jkVar.fx = true;
                    bg bgVar = this.l;
                    if (bgVar != null && bgVar.x()) {
                        this.l.nr(view);
                    }
                }
            } else {
                if (qVarPn.a()) {
                    qVarPn.jk();
                } else {
                    qVarPn.l();
                }
                this.n.u(view, i, view.getLayoutParams(), false);
            }
            if (jkVar.b) {
                qVarPn.u.invalidate();
                jkVar.b = false;
            }
        }

        public void nr(bg bgVar) {
            if (this.l == bgVar) {
                this.l = null;
            }
        }

        private void u(int i, View view) {
            this.n.pn(i);
        }

        public void u(View view, int i, jk jkVar) {
            q qVarPn = RecyclerView.pn(view);
            if (qVarPn.o()) {
                this.f5178a.n.pn(qVarPn);
            } else {
                this.f5178a.n.iz(qVarPn);
            }
            this.n.u(view, i, jkVar, qVarPn.o());
        }

        public void u(View view, my myVar) {
            fx(view);
            myVar.u(view);
        }

        public void u(int i, my myVar) {
            View viewN = n(i);
            iz(i);
            myVar.u(viewN);
        }

        public void u(my myVar) {
            for (int iBg = bg() - 1; iBg >= 0; iBg--) {
                u(myVar, iBg, n(iBg));
            }
        }

        private void u(my myVar, int i, View view) {
            q qVarPn = RecyclerView.pn(view);
            if (qVarPn.N_()) {
                return;
            }
            if (qVarPn.s() && !qVarPn.o() && !this.f5178a.mv.nr()) {
                iz(i);
                myVar.nr(qVarPn);
            } else {
                x(i);
                myVar.fx(view);
                this.f5178a.n.n(qVarPn);
            }
        }

        public boolean u(View view, int i, int i2, jk jkVar) {
            return (!view.isLayoutRequested() && this.fx && nr(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) jkVar).width) && nr(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) jkVar).height)) ? false : true;
        }

        public void u(View view, int i, int i2) {
            jk jkVar = (jk) view.getLayoutParams();
            Rect rectA = this.f5178a.a(view);
            int i3 = i + rectA.left + rectA.right;
            int i4 = i2 + rectA.top + rectA.bottom;
            int iU = u(c(), bq(), qq() + z() + ((ViewGroup.MarginLayoutParams) jkVar).leftMargin + ((ViewGroup.MarginLayoutParams) jkVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) jkVar).width, fx());
            int iU2 = u(q(), dw(), kj() + gi() + ((ViewGroup.MarginLayoutParams) jkVar).topMargin + ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) jkVar).height, b());
            if (u(view, iU, iU2, jkVar)) {
                view.measure(iU, iU2);
            }
        }

        public static int u(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1 && (i2 == Integer.MIN_VALUE || i2 == 1073741824)) {
                        i4 = iMax;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = iMax;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public void u(View view, int i, int i2, int i3, int i4) {
            jk jkVar = (jk) view.getLayoutParams();
            Rect rect = jkVar.nr;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) jkVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) jkVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) jkVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin);
        }

        public void u(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((jk) view.getLayoutParams()).nr;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f5178a != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f5178a.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void u(View view, Rect rect) {
            RecyclerView.u(view, rect);
        }

        public boolean u(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return u(recyclerView, view, rect, z, false);
        }

        public boolean u(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrNr = nr(recyclerView, view, rect, z);
            int i = iArrNr[0];
            int i2 = iArrNr[1];
            if ((z2 && !u(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.u(i, i2);
            }
            return true;
        }

        private boolean u(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iQq = qq();
            int iKj = kj();
            int iC = c() - z();
            int iQ = q() - gi();
            Rect rect = this.f5178a.t;
            u(focusedChild, rect);
            return rect.left - i < iC && rect.right - i > iQq && rect.top - i2 < iQ && rect.bottom - i2 > iKj;
        }

        @Deprecated
        public boolean u(RecyclerView recyclerView, View view, View view2) {
            return my() || recyclerView.s();
        }

        public boolean u(RecyclerView recyclerView, bq bqVar, View view, View view2) {
            return u(recyclerView, view, view2);
        }

        public void u(my myVar, bq bqVar, int i, int i2) {
            this.f5178a.pn(i, i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        int u(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        private int b;
        private boolean iz;
        Interpolator nr;
        private int pn;
        OverScroller u;
        private boolean x;

        public c() {
            Interpolator interpolator = RecyclerView.m;
            this.nr = interpolator;
            this.iz = false;
            this.x = false;
            this.u = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private void b() {
            this.iz = false;
            if (this.x) {
                u();
            }
        }

        private void fx() {
            this.x = false;
            this.iz = true;
        }

        public void nr(int i, int i2) {
            u(i, i2, 0, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ef  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            if (RecyclerView.this.s == null) {
                nr();
                return;
            }
            fx();
            RecyclerView.this.b();
            OverScroller overScroller = this.u;
            bg bgVar = RecyclerView.this.s.l;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.wq;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.b;
                int i7 = currY - this.pn;
                this.b = currX;
                this.pn = currY;
                if (RecyclerView.this.u(i6, i7, iArr, null, 1)) {
                    i6 -= iArr[0];
                    i7 -= iArr[1];
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mv != null) {
                    recyclerView.u(i6, i7, recyclerView.pb);
                    int[] iArr2 = RecyclerView.this.pb;
                    i2 = iArr2[0];
                    i = iArr2[1];
                    i3 = i6 - i2;
                    i4 = i7 - i;
                    if (bgVar != null && !bgVar.iz() && bgVar.x()) {
                        int iB = RecyclerView.this.h.b();
                        if (iB == 0) {
                            bgVar.pn();
                        } else {
                            if (bgVar.n() >= iB) {
                                bgVar.fx(iB - 1);
                            }
                            bgVar.u(i6 - i3, i7 - i4);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.my.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.fx(i6, i7);
                }
                if (!RecyclerView.this.u(i2, i, i3, i4, (int[]) null, 1) && (i3 != 0 || i4 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 == currX) {
                        i5 = 0;
                        if (i4 == currY) {
                            currVelocity = 0;
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                                RecyclerView.this.b(i5, currVelocity);
                            }
                            if ((i5 == 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                                overScroller.abortAnimation();
                            }
                        } else {
                            if (i4 < 0) {
                                currVelocity = -currVelocity;
                            } else if (i4 <= 0) {
                            }
                            if (RecyclerView.this.getOverScrollMode() != 2) {
                            }
                            if (i5 == 0) {
                                overScroller.abortAnimation();
                            } else {
                                overScroller.abortAnimation();
                            }
                        }
                    } else {
                        if (i3 < 0) {
                            i5 = -currVelocity;
                        } else if (i3 > 0) {
                            i5 = currVelocity;
                        }
                        if (i4 == currY) {
                        }
                    }
                }
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.n(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i6 == 0 && i7 == 0) || (i6 != 0 && RecyclerView.this.s.fx() && i2 == i6) || (i7 != 0 && RecyclerView.this.s.b() && i == i7);
                if (overScroller.isFinished() || !(z || RecyclerView.this.a(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.b) {
                        RecyclerView.this.d.u();
                    }
                    RecyclerView.this.n(1);
                } else {
                    u();
                    RecyclerView recyclerView2 = RecyclerView.this;
                    com.bytedance.sdk.component.widget.recycler.b bVar = recyclerView2.gi;
                    if (bVar != null) {
                        bVar.u(recyclerView2, i6, i7);
                    }
                }
            }
            if (bgVar != null) {
                if (bgVar.iz()) {
                    bgVar.u(0, 0);
                }
                if (!this.x) {
                    bgVar.pn();
                }
            }
            b();
        }

        public void u() {
            if (this.iz) {
                this.x = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.u.fx.x.u(RecyclerView.this, this);
            }
        }

        private int nr(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fU = f2 + (u(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fU / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void u(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.pn = 0;
            this.b = 0;
            this.u.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            u();
        }

        public void u(int i, int i2, int i3, int i4) {
            u(i, i2, nr(i, i2, i3, i4));
        }

        private float u(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        public void u(int i, int i2, int i3) {
            u(i, i2, i3, RecyclerView.m);
        }

        public void nr() {
            RecyclerView.this.removeCallbacks(this);
            this.u.abortAnimation();
        }

        public void u(int i, int i2, Interpolator interpolator) {
            int iNr = nr(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.m;
            }
            u(i, i2, iNr, interpolator);
        }

        public void u(int i, int i2, int i3, Interpolator interpolator) {
            if (this.nr != interpolator) {
                this.nr = interpolator;
                this.u = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.pn = 0;
            this.b = 0;
            this.u.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.u.computeScrollOffset();
            }
            u();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class dw {
        public abstract View u(my myVar, int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class fx {
        public void u() {
        }

        public void u(int i, int i2, Object obj) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class iz {
        private u u = null;
        private ArrayList<Object> nr = new ArrayList<>();
        private long fx = 120;
        private long b = 120;
        private long pn = 250;
        private long iz = 250;

        /* JADX INFO: compiled from: SearchBox */
        public static class nr {
            public int b;
            public int fx;
            public int nr;
            public int u;

            public nr u(q qVar) {
                return u(qVar, 0);
            }

            public nr u(q qVar, int i) {
                View view = qVar.u;
                this.u = view.getLeft();
                this.nr = view.getTop();
                this.fx = view.getRight();
                this.b = view.getBottom();
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public interface u {
            void u(q qVar);
        }

        public final void a() {
            int size = this.nr.size();
            for (int i = 0; i < size; i++) {
                this.nr.get(i);
            }
            this.nr.clear();
        }

        public abstract void b();

        public abstract void b(q qVar);

        public abstract boolean fx(q qVar, nr nrVar, nr nrVar2);

        public long iz() {
            return this.fx;
        }

        public nr jk() {
            return new nr();
        }

        public long n() {
            return this.iz;
        }

        public abstract boolean nr();

        public abstract boolean nr(q qVar, nr nrVar, nr nrVar2);

        public long pn() {
            return this.pn;
        }

        public abstract void u();

        public void u(u uVar) {
            this.u = uVar;
        }

        public abstract boolean u(q qVar, nr nrVar, nr nrVar2);

        public abstract boolean u(q qVar, q qVar2, nr nrVar, nr nrVar2);

        public boolean x(q qVar) {
            return true;
        }

        public static int pn(q qVar) {
            int i = qVar.jk & 14;
            if (qVar.s()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iIz = qVar.iz();
            int iPn = qVar.pn();
            return (iIz == -1 || iPn == -1 || iIz == iPn) ? i : i | 2048;
        }

        public final void iz(q qVar) {
            u uVar = this.u;
            if (uVar != null) {
                uVar.u(qVar);
            }
        }

        public nr u(bq bqVar, q qVar, int i, List<Object> list) {
            return jk().u(qVar);
        }

        public long x() {
            return this.b;
        }

        public nr u(bq bqVar, q qVar) {
            return jk().u(qVar);
        }

        public boolean u(q qVar, List<Object> list) {
            return x(qVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class l {
        public abstract boolean u(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface mv {
        boolean u(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class my {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private dw f5180a;
        int b;
        final ArrayList<q> fx;
        private int n;
        ArrayList<q> nr;
        k pn;
        final ArrayList<q> u;
        private final List<q> x;

        public my() {
            ArrayList<q> arrayList = new ArrayList<>();
            this.u = arrayList;
            this.nr = null;
            this.fx = new ArrayList<>();
            this.x = Collections.unmodifiableList(arrayList);
            this.n = 2;
            this.b = 2;
        }

        private void pn(q qVar) {
            View view = qVar.u;
            if (view instanceof ViewGroup) {
                u((ViewGroup) view, false);
            }
        }

        public void a() {
            int size = this.fx.size();
            for (int i = 0; i < size; i++) {
                this.fx.get(i).u();
            }
            int size2 = this.u.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.u.get(i2).u();
            }
            ArrayList<q> arrayList = this.nr;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.nr.get(i3).u();
                }
            }
        }

        public void b() {
            for (int size = this.fx.size() - 1; size >= 0; size--) {
                fx(size);
            }
            this.fx.clear();
            if (RecyclerView.b) {
                RecyclerView.this.d.u();
            }
        }

        public List<q> fx() {
            return this.x;
        }

        public void iz() {
            this.u.clear();
            ArrayList<q> arrayList = this.nr;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public void jk() {
            int size = this.fx.size();
            for (int i = 0; i < size; i++) {
                jk jkVar = (jk) this.fx.get(i).u.getLayoutParams();
                if (jkVar != null) {
                    jkVar.fx = true;
                }
            }
        }

        public void n() {
            int size = this.fx.size();
            for (int i = 0; i < size; i++) {
                q qVar = this.fx.get(i);
                if (qVar != null) {
                    qVar.nr(6);
                    qVar.u((Object) null);
                }
            }
            u uVar = RecyclerView.this.mv;
            if (uVar == null || !uVar.nr()) {
                b();
            }
        }

        public void nr() {
            a aVar = RecyclerView.this.s;
            this.b = this.n + (aVar != null ? aVar.my : 0);
            for (int size = this.fx.size() - 1; size >= 0 && this.fx.size() > this.b; size--) {
                fx(size);
            }
        }

        public void u() {
            this.u.clear();
            b();
        }

        public k x() {
            if (this.pn == null) {
                this.pn = new k();
            }
            return this.pn;
        }

        public void fx(int i) {
            u(this.fx.get(i), true);
            this.fx.remove(i);
        }

        public int pn() {
            return this.u.size();
        }

        public void u(int i) {
            this.n = i;
            nr();
        }

        public q pn(int i) {
            int size;
            int iNr;
            ArrayList<q> arrayList = this.nr;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    q qVar = this.nr.get(i2);
                    if (!qVar.t() && qVar.b() == i) {
                        qVar.nr(32);
                        return qVar;
                    }
                }
                if (RecyclerView.this.mv.nr() && (iNr = RecyclerView.this.iz.nr(i)) > 0 && iNr < RecyclerView.this.mv.u()) {
                    long jNr = RecyclerView.this.mv.nr(iNr);
                    for (int i3 = 0; i3 < size; i3++) {
                        q qVar2 = this.nr.get(i3);
                        if (!qVar2.t() && qVar2.x() == jNr) {
                            qVar2.nr(32);
                            return qVar2;
                        }
                    }
                }
            }
            return null;
        }

        public void fx(View view) {
            q qVarPn = RecyclerView.pn(view);
            if (!qVarPn.u(12) && qVarPn.z() && !RecyclerView.this.nr(qVarPn)) {
                if (this.nr == null) {
                    this.nr = new ArrayList<>();
                }
                qVarPn.u(this, true);
                this.nr.add(qVarPn);
                return;
            }
            if (qVarPn.s() && !qVarPn.o() && !RecyclerView.this.mv.nr()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.u());
            }
            qVarPn.u(this, false);
            this.u.add(qVarPn);
        }

        public View nr(int i) {
            return u(i, false);
        }

        public boolean u(q qVar) {
            if (qVar.o()) {
                return RecyclerView.this.h.u();
            }
            int i = qVar.fx;
            if (i >= 0 && i < RecyclerView.this.mv.u()) {
                if (RecyclerView.this.h.u() || RecyclerView.this.mv.u(qVar.fx) == qVar.n()) {
                    return !RecyclerView.this.mv.nr() || qVar.x() == RecyclerView.this.mv.nr(qVar.fx);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + qVar + RecyclerView.this.u());
        }

        public View b(int i) {
            return this.u.get(i).u;
        }

        public void nr(q qVar) {
            boolean z;
            boolean z2 = true;
            if (!qVar.a() && qVar.u.getParent() == null) {
                if (!qVar.sx()) {
                    if (!qVar.N_()) {
                        boolean zKj = qVar.kj();
                        u uVar = RecyclerView.this.mv;
                        if ((uVar != null && zKj && uVar.nr(qVar)) || qVar.q()) {
                            if (this.b <= 0 || qVar.u(526)) {
                                z = false;
                            } else {
                                int size = this.fx.size();
                                if (size >= this.b && size > 0) {
                                    fx(0);
                                    size--;
                                }
                                if (RecyclerView.b && size > 0 && !RecyclerView.this.d.u(qVar.fx)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.d.u(this.fx.get(i).fx)) {
                                            break;
                                        } else {
                                            i--;
                                        }
                                    }
                                    size = i + 1;
                                }
                                this.fx.add(size, qVar);
                                z = true;
                            }
                            if (z) {
                                z = z;
                                z2 = false;
                            } else {
                                u(qVar, true);
                                z = z;
                            }
                        } else {
                            z2 = false;
                        }
                        RecyclerView.this.n.x(qVar);
                        if (z || z2 || !zKj) {
                            return;
                        }
                        qVar.my = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.u());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + qVar + RecyclerView.this.u());
            }
            StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(qVar.a());
            sb.append(" isAttached:");
            sb.append(qVar.u.getParent() != null);
            sb.append(RecyclerView.this.u());
            throw new IllegalArgumentException(sb.toString());
        }

        public void b(q qVar) {
            u uVar = RecyclerView.this.mv;
            if (uVar != null) {
                uVar.u(qVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.h != null) {
                recyclerView.n.x(qVar);
            }
        }

        private boolean u(q qVar, int i, int i2, long j) {
            qVar.my = RecyclerView.this;
            int iN = qVar.n();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.pn.nr(iN, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mv.nr(qVar, i);
            this.pn.nr(qVar.n(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.h.u()) {
                return true;
            }
            qVar.x = i2;
            return true;
        }

        public void fx(q qVar) {
            if (qVar.s) {
                this.nr.remove(qVar);
            } else {
                this.u.remove(qVar);
            }
            qVar.mv = null;
            qVar.s = false;
            qVar.l();
        }

        public void fx(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.fx.size() - 1; size >= 0; size--) {
                q qVar = this.fx.get(size);
                if (qVar != null && (i3 = qVar.fx) >= i && i3 < i4) {
                    qVar.nr(2);
                    fx(size);
                }
            }
        }

        public View u(int i, boolean z) {
            return u(i, z, Long.MAX_VALUE).u;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x021f A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0178 A[PHI: r1 r4
          0x0178: PHI (r1v12 com.bytedance.sdk.component.widget.recycler.RecyclerView$q) = 
          (r1v11 com.bytedance.sdk.component.widget.recycler.RecyclerView$q)
          (r1v31 com.bytedance.sdk.component.widget.recycler.RecyclerView$q)
         binds: [B:28:0x005d, B:59:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          0x0178: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0199  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01f5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public q u(int i, boolean z, long j) {
            q qVarNr;
            q qVar;
            boolean z2;
            ViewGroup.LayoutParams layoutParams;
            jk jkVar;
            RecyclerView recyclerViewJk;
            dw dwVar;
            View viewU;
            if (i >= 0 && i < RecyclerView.this.h.b()) {
                if (RecyclerView.this.h.u()) {
                    qVarNr = pn(i);
                    boolean z3 = qVarNr != null;
                    if (qVarNr == null && (qVarNr = nr(i, z)) != null) {
                        if (u(qVarNr)) {
                            if (!z) {
                                qVarNr.nr(4);
                                if (qVarNr.a()) {
                                    RecyclerView.this.removeDetachedView(qVarNr.u, false);
                                    qVarNr.jk();
                                } else if (qVarNr.t()) {
                                    qVarNr.l();
                                }
                                nr(qVarNr);
                            }
                            qVarNr = null;
                        } else {
                            z3 = true;
                        }
                    }
                    if (qVarNr != null) {
                        qVar = qVarNr;
                    } else {
                        int iNr = RecyclerView.this.iz.nr(i);
                        if (iNr >= 0 && iNr < RecyclerView.this.mv.u()) {
                            int iU = RecyclerView.this.mv.u(iNr);
                            if (RecyclerView.this.mv.nr() && (qVarNr = u(RecyclerView.this.mv.nr(iNr), iU, z)) != null) {
                                qVarNr.fx = iNr;
                                z3 = true;
                            }
                            if (qVarNr == null && (dwVar = this.f5180a) != null && (viewU = dwVar.u(this, i, iU)) != null) {
                                qVarNr = RecyclerView.this.nr(viewU);
                                if (qVarNr != null) {
                                    if (qVarNr.N_()) {
                                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.u());
                                    }
                                } else {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.u());
                                }
                            }
                            if (qVarNr == null) {
                                q qVarU = x().u(iU);
                                if (qVarU != null) {
                                    qVarU.c();
                                    if (RecyclerView.u) {
                                        pn(qVarU);
                                    }
                                }
                                qVarNr = qVarU;
                            }
                            if (qVarNr == null) {
                                long nanoTime = RecyclerView.this.getNanoTime();
                                if (j != Long.MAX_VALUE && !this.pn.u(iU, nanoTime, j)) {
                                    return null;
                                }
                                RecyclerView recyclerView = RecyclerView.this;
                                q qVarNr2 = recyclerView.mv.nr(recyclerView, iU);
                                if (RecyclerView.b && (recyclerViewJk = RecyclerView.jk(qVarNr2.u)) != null) {
                                    qVarNr2.nr = new WeakReference<>(recyclerViewJk);
                                }
                                this.pn.u(iU, RecyclerView.this.getNanoTime() - nanoTime);
                                qVar = qVarNr2;
                            }
                        } else {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iNr + ").state:" + RecyclerView.this.h.b() + RecyclerView.this.u());
                        }
                    }
                    z2 = z3;
                    if (z2 && !RecyclerView.this.h.u() && qVar.u(8192)) {
                        qVar.u(0, 8192);
                        if (RecyclerView.this.h.jk) {
                            int iPn = iz.pn(qVar) | 4096;
                            RecyclerView recyclerView2 = RecyclerView.this;
                            RecyclerView.this.u(qVar, recyclerView2.kj.u(recyclerView2.h, qVar, iPn, qVar.dw()));
                        }
                    }
                    if (!RecyclerView.this.h.u() && qVar.my()) {
                        qVar.x = i;
                    } else {
                        boolean zU = (qVar.my() || qVar.k() || qVar.s()) ? u(qVar, RecyclerView.this.iz.nr(i), i, j) : false;
                        layoutParams = qVar.u.getLayoutParams();
                        if (layoutParams == null) {
                            jkVar = (jk) RecyclerView.this.generateDefaultLayoutParams();
                            qVar.u.setLayoutParams(jkVar);
                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                            jkVar = (jk) RecyclerView.this.generateLayoutParams(layoutParams);
                            qVar.u.setLayoutParams(jkVar);
                        } else {
                            jkVar = (jk) layoutParams;
                        }
                        jkVar.u = qVar;
                        jkVar.b = z2 && zU;
                        return qVar;
                    }
                    layoutParams = qVar.u.getLayoutParams();
                    if (layoutParams == null) {
                    }
                    jkVar.u = qVar;
                    jkVar.b = z2 && zU;
                    return qVar;
                }
                qVarNr = null;
                if (qVarNr == null) {
                    if (u(qVarNr)) {
                    }
                }
                if (qVarNr != null) {
                }
                z2 = z3;
                if (z2) {
                    qVar.u(0, 8192);
                    if (RecyclerView.this.h.jk) {
                    }
                }
                if (!RecyclerView.this.h.u()) {
                    if (qVar.my()) {
                    }
                }
                layoutParams = qVar.u.getLayoutParams();
                if (layoutParams == null) {
                }
                jkVar.u = qVar;
                jkVar.b = z2 && zU;
                return qVar;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.h.b() + RecyclerView.this.u());
        }

        public void nr(View view) {
            q qVarPn = RecyclerView.pn(view);
            qVarPn.mv = null;
            qVarPn.s = false;
            qVarPn.l();
            nr(qVarPn);
        }

        public q nr(int i, boolean z) {
            View viewFx;
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                q qVar = this.u.get(i2);
                if (!qVar.t() && qVar.b() == i && !qVar.s() && (RecyclerView.this.h.x || !qVar.o())) {
                    qVar.nr(32);
                    return qVar;
                }
            }
            if (!z && (viewFx = RecyclerView.this.x.fx(i)) != null) {
                q qVarPn = RecyclerView.pn(viewFx);
                RecyclerView.this.x.pn(viewFx);
                int iNr = RecyclerView.this.x.nr(viewFx);
                if (iNr != -1) {
                    RecyclerView.this.x.pn(iNr);
                    fx(viewFx);
                    qVarPn.nr(8224);
                    return qVarPn;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + qVarPn + RecyclerView.this.u());
            }
            int size2 = this.fx.size();
            for (int i3 = 0; i3 < size2; i3++) {
                q qVar2 = this.fx.get(i3);
                if (!qVar2.s() && qVar2.b() == i) {
                    if (!z) {
                        this.fx.remove(i3);
                    }
                    return qVar2;
                }
            }
            return null;
        }

        public void nr(int i, int i2) {
            int size = this.fx.size();
            for (int i3 = 0; i3 < size; i3++) {
                q qVar = this.fx.get(i3);
                if (qVar != null && qVar.fx >= i) {
                    qVar.u(i2, true);
                }
            }
        }

        private void u(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    u((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void u(View view) {
            q qVarPn = RecyclerView.pn(view);
            if (qVarPn.sx()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (qVarPn.a()) {
                qVarPn.jk();
            } else if (qVarPn.t()) {
                qVarPn.l();
            }
            nr(qVarPn);
        }

        public void u(q qVar, boolean z) {
            RecyclerView.fx(qVar);
            if (qVar.u(16384)) {
                qVar.u(0, 16384);
            }
            if (z) {
                b(qVar);
            }
            qVar.my = null;
            x().u(qVar);
        }

        public q u(long j, int i, boolean z) {
            for (int size = this.u.size() - 1; size >= 0; size--) {
                q qVar = this.u.get(size);
                if (qVar.x() == j && !qVar.t()) {
                    if (i == qVar.n()) {
                        qVar.nr(32);
                        if (qVar.o() && !RecyclerView.this.h.u()) {
                            qVar.u(2, 14);
                        }
                        return qVar;
                    }
                    if (!z) {
                        this.u.remove(size);
                        RecyclerView.this.removeDetachedView(qVar.u, false);
                        nr(qVar.u);
                    }
                }
            }
            int size2 = this.fx.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                q qVar2 = this.fx.get(size2);
                if (qVar2.x() == j) {
                    if (i == qVar2.n()) {
                        if (!z) {
                            this.fx.remove(size2);
                        }
                        return qVar2;
                    }
                    if (!z) {
                        fx(size2);
                        return null;
                    }
                }
            }
        }

        public void u(u uVar, u uVar2, boolean z) {
            u();
            x().u(uVar, uVar2, z);
        }

        public void u(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.fx.size();
            for (int i7 = 0; i7 < size; i7++) {
                q qVar = this.fx.get(i7);
                if (qVar != null && (i6 = qVar.fx) >= i5 && i6 <= i4) {
                    if (i6 == i) {
                        qVar.u(i2 - i, false);
                    } else {
                        qVar.u(i3, false);
                    }
                }
            }
        }

        public void u(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.fx.size() - 1; size >= 0; size--) {
                q qVar = this.fx.get(size);
                if (qVar != null) {
                    int i4 = qVar.fx;
                    if (i4 >= i3) {
                        qVar.u(-i2, z);
                    } else if (i4 >= i) {
                        qVar.nr(8);
                        fx(size);
                    }
                }
            }
        }

        public void u(dw dwVar) {
            this.f5180a = dwVar;
        }

        public void u(k kVar) {
            k kVar2 = this.pn;
            if (kVar2 != null) {
                kVar2.fx();
            }
            this.pn = kVar;
            if (kVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.pn.nr();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class n {
        @Deprecated
        public void u(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void u(Rect rect, View view, RecyclerView recyclerView, bq bqVar) {
            u(rect, ((jk) view.getLayoutParams()).b(), recyclerView);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface o {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class pn {
        public EdgeEffect u(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class s {
        public void u(RecyclerView recyclerView, int i) {
        }

        public void u(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface t {
        void nr(View view);

        void u(View view);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class u<VH extends q> {
        private final nr u = new nr();
        private boolean nr = false;

        public final void fx() {
            this.u.u();
        }

        public long nr(int i) {
            return -1L;
        }

        public abstract int u();

        public int u(int i) {
            return 0;
        }

        public abstract VH u(ViewGroup viewGroup, int i);

        public abstract void u(VH vh, int i);

        public boolean nr(VH vh) {
            return false;
        }

        public void u(VH vh) {
        }

        public final VH nr(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV CreateView");
                VH vh = (VH) u(viewGroup, i);
                if (vh.u.getParent() == null) {
                    vh.iz = i;
                    return vh;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                com.bytedance.sdk.component.widget.recycler.u.u.u.u();
            }
        }

        public void u(VH vh, int i, List<Object> list) {
            u(vh, i);
        }

        public void u(fx fxVar) {
            this.u.registerObserver(fxVar);
        }

        public final void u(int i, Object obj) {
            this.u.u(i, 1, obj);
        }

        public final void u(int i, int i2) {
            this.u.u(i, i2);
        }

        public final void nr(VH vh, int i) {
            vh.fx = i;
            if (nr()) {
                vh.pn = nr(i);
            }
            vh.u(1, 519);
            com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV OnBindView");
            u(vh, i, vh.dw());
            vh.bq();
            ViewGroup.LayoutParams layoutParams = vh.u.getLayoutParams();
            if (layoutParams instanceof jk) {
                ((jk) layoutParams).fx = true;
            }
            com.bytedance.sdk.component.widget.recycler.u.u.u.u();
        }

        public final boolean nr() {
            return this.nr;
        }

        public void nr(fx fxVar) {
            this.u.unregisterObserver(fxVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements iz.u {
        public x() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz.u
        public void u(q qVar) {
            qVar.u(true);
            if (qVar.n != null && qVar.f5181a == null) {
                qVar.n = null;
            }
            qVar.f5181a = null;
            if (qVar.qq() || RecyclerView.this.u(qVar.u) || !qVar.sx()) {
                return;
            }
            RecyclerView.this.removeDetachedView(qVar.u, false);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        u = false;
        nr = i >= 23;
        fx = true;
        b = true;
        bc = false;
        xw = false;
        Class<?> cls = Integer.TYPE;
        oa = new Class[]{Context.class, AttributeSet.class, cls, cls};
        m = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void bc() {
        pn();
        l();
        this.h.u(6);
        this.iz.pn();
        this.h.pn = this.mv.u();
        bq bqVar = this.h;
        bqVar.fx = 0;
        bqVar.x = false;
        this.s.u(this.pn, bqVar);
        bq bqVar2 = this.h;
        bqVar2.iz = false;
        bqVar2.jk = bqVar2.jk && this.kj != null;
        bqVar2.b = 4;
        mv();
        u(false);
    }

    private boolean bf() {
        return this.kj != null && this.s.l();
    }

    private void d() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.gc;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.gc.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mk;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mk.isFinished();
        }
        EdgeEffect edgeEffect3 = this.p;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.p.isFinished();
        }
        EdgeEffect edgeEffect4 = this.kw;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.kw.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
        }
    }

    private com.bytedance.sdk.component.widget.recycler.u.fx.b getScrollingChildHelper() {
        if (this.df == null) {
            this.df = new com.bytedance.sdk.component.widget.recycler.u.fx.b(this);
        }
        return this.df;
    }

    private void gi() {
        this.z.nr();
        a aVar = this.s;
        if (aVar != null) {
            aVar.bf();
        }
    }

    private void h() {
        VelocityTracker velocityTracker = this.tm;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        n(0);
        d();
    }

    private void ja() {
        this.yd = 0;
    }

    private void jp() {
        View viewFindViewById;
        if (!this.sf || this.mv == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!xw || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.x.fx(focusedChild)) {
                    return;
                }
            } else if (this.x.nr() == 0) {
                requestFocus();
                return;
            }
        }
        View viewM = null;
        q qVarU = (this.h.mv == -1 || !this.mv.nr()) ? null : u(this.h.mv);
        if (qVarU != null && !this.x.fx(qVarU.u) && qVarU.u.hasFocusable()) {
            viewM = qVarU.u;
        } else if (this.x.nr() > 0) {
            viewM = m();
        }
        if (viewM != null) {
            int i = this.h.s;
            if (i != -1 && (viewFindViewById = viewM.findViewById(i)) != null && viewFindViewById.isFocusable()) {
                viewM = viewFindViewById;
            }
            viewM.requestFocus();
        }
    }

    private void kj() {
        this.x = new com.bytedance.sdk.component.widget.recycler.nr(new nr.InterfaceC0232nr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void b(View view) {
                q qVarPn = RecyclerView.pn(view);
                if (qVarPn != null) {
                    qVarPn.nr(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void fx(int i) {
                q qVarPn;
                View viewNr = nr(i);
                if (viewNr != null && (qVarPn = RecyclerView.pn(viewNr)) != null) {
                    if (qVarPn.sx() && !qVarPn.N_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + qVarPn + RecyclerView.this.u());
                    }
                    qVarPn.nr(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public View nr(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public int u() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void nr() {
                int iU = u();
                for (int i = 0; i < iU; i++) {
                    View viewNr = nr(i);
                    RecyclerView.this.t(viewNr);
                    viewNr.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void u(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.l(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public int u(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void u(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.t(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void fx(View view) {
                q qVarPn = RecyclerView.pn(view);
                if (qVarPn != null) {
                    qVarPn.u(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public q nr(View view) {
                return RecyclerView.pn(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.nr.InterfaceC0232nr
            public void u(View view, int i, ViewGroup.LayoutParams layoutParams) {
                q qVarPn = RecyclerView.pn(view);
                if (qVarPn != null) {
                    if (!qVarPn.sx() && !qVarPn.N_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + qVarPn + RecyclerView.this.u());
                    }
                    qVarPn.mv();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }
        });
    }

    private View m() {
        q qVarB;
        bq bqVar = this.h;
        int i = bqVar.l;
        if (i == -1) {
            i = 0;
        }
        int iB = bqVar.b();
        for (int i2 = i; i2 < iB; i2++) {
            q qVarB2 = b(i2);
            if (qVarB2 == null) {
                break;
            }
            if (qVarB2.u.hasFocusable()) {
                return qVarB2.u;
            }
        }
        int iMin = Math.min(iB, i);
        do {
            iMin--;
            if (iMin < 0 || (qVarB = b(iMin)) == null) {
                return null;
            }
        } while (!qVarB.u.hasFocusable());
        return qVarB.u;
    }

    private void pb() {
        View focusedChild = (this.sf && hasFocus() && this.mv != null) ? getFocusedChild() : null;
        q qVarB = focusedChild != null ? b(focusedChild) : null;
        if (qVarB == null) {
            xg();
            return;
        }
        this.h.mv = this.mv.nr() ? qVarB.x() : -1L;
        this.h.l = this.q ? -1 : qVarB.o() ? qVarB.b : qVarB.pn();
        this.h.s = mv(qVarB.u);
    }

    private void pn(q qVar) {
        View view = qVar.u;
        boolean z = view.getParent() == this;
        this.pn.fx(nr(view));
        if (qVar.sx()) {
            this.x.u(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.x.b(view);
        } else {
            this.x.u(view, true);
        }
    }

    @SuppressLint({"InlinedApi"})
    private void qq() {
        if (com.bytedance.sdk.component.widget.recycler.u.fx.x.a(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.u.fx.x.nr(this, 8);
        }
    }

    private void rh() {
        h();
        setScrollState(0);
    }

    private void wq() {
        boolean z;
        if (this.q) {
            this.iz.u();
        }
        if (bf()) {
            this.iz.nr();
        } else {
            this.iz.pn();
        }
        boolean z2 = false;
        boolean z3 = this.rh || this.ja;
        this.h.jk = this.bg && this.kj != null && ((z = this.q) || z3 || this.s.mv) && (!z || this.mv.nr());
        bq bqVar = this.h;
        if (bqVar.jk && z3 && !this.q && bf()) {
            z2 = true;
        }
        bqVar.t = z2;
    }

    private void xg() {
        bq bqVar = this.h;
        bqVar.mv = -1L;
        bqVar.l = -1;
        bqVar.s = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xw() {
        this.h.u(4);
        pn();
        l();
        bq bqVar = this.h;
        bqVar.b = 1;
        if (bqVar.jk) {
            for (int iNr = this.x.nr() - 1; iNr >= 0; iNr--) {
                q qVarPn = pn(this.x.nr(iNr));
                if (!qVarPn.N_()) {
                    long jU = u(qVarPn);
                    iz.nr nrVarU = this.kj.u(this.h, qVarPn);
                    q qVarU = this.n.u(jU);
                    if (qVarU == null || qVarU.N_()) {
                        this.n.fx(qVarPn, nrVarU);
                    } else {
                        boolean zU = this.n.u(qVarU);
                        boolean zU2 = this.n.u(qVarPn);
                        if (!zU || qVarU != qVarPn) {
                            iz.nr nrVarNr = this.n.nr(qVarU);
                            this.n.fx(qVarPn, nrVarU);
                            iz.nr nrVarFx = this.n.fx(qVarPn);
                            if (nrVarNr == null) {
                                u(jU, qVarPn, qVarU);
                            } else {
                                u(qVarU, qVarPn, nrVarNr, nrVarFx, zU, zU2);
                            }
                        }
                    }
                }
            }
            this.n.u(this.te);
        }
        this.s.nr(this.pn);
        bq bqVar2 = this.h;
        bqVar2.nr = bqVar2.pn;
        this.q = false;
        this.qq = false;
        bqVar2.jk = false;
        bqVar2.t = false;
        this.s.mv = false;
        ArrayList<q> arrayList = this.pn.nr;
        if (arrayList != null) {
            arrayList.clear();
        }
        a aVar = this.s;
        if (aVar.o) {
            aVar.my = 0;
            aVar.o = false;
            this.pn.nr();
        }
        this.s.nr(this.h);
        mv();
        u(false);
        this.n.u();
        int[] iArr = this.ex;
        if (jk(iArr[0], iArr[1])) {
            n(0, 0);
        }
        jp();
        xg();
    }

    private void y() {
        this.h.u(1);
        u(this.h);
        this.h.f5179a = false;
        pn();
        this.n.u();
        l();
        wq();
        pb();
        bq bqVar = this.h;
        bqVar.n = bqVar.jk && this.ja;
        this.ja = false;
        this.rh = false;
        bqVar.x = bqVar.t;
        bqVar.pn = this.mv.u();
        u(this.ex);
        if (this.h.jk) {
            int iNr = this.x.nr();
            for (int i = 0; i < iNr; i++) {
                q qVarPn = pn(this.x.nr(i));
                if (!qVarPn.N_() && (!qVarPn.s() || this.mv.nr())) {
                    this.n.u(qVarPn, this.kj.u(this.h, qVarPn, iz.pn(qVarPn), qVarPn.dw()));
                    if (this.h.n && qVarPn.z() && !qVarPn.o() && !qVarPn.N_() && !qVarPn.s()) {
                        this.n.u(u(qVarPn), qVarPn);
                    }
                }
            }
        }
        if (this.h.t) {
            sx();
            bq bqVar2 = this.h;
            boolean z = bqVar2.iz;
            bqVar2.iz = false;
            this.s.u(this.pn, bqVar2);
            this.h.iz = z;
            for (int i2 = 0; i2 < this.x.nr(); i2++) {
                q qVarPn2 = pn(this.x.nr(i2));
                if (!qVarPn2.N_() && !this.n.b(qVarPn2)) {
                    int iPn = iz.pn(qVarPn2);
                    boolean zU = qVarPn2.u(8192);
                    if (!zU) {
                        iPn |= 4096;
                    }
                    iz.nr nrVarU = this.kj.u(this.h, qVarPn2, iPn, qVarPn2.dw());
                    if (zU) {
                        u(qVarPn2, nrVarU);
                    } else {
                        this.n.nr(qVarPn2, nrVarU);
                    }
                }
            }
            bg();
        } else {
            bg();
        }
        mv();
        u(false);
        this.h.b = 2;
    }

    private boolean z() {
        int iNr = this.x.nr();
        for (int i = 0; i < iNr; i++) {
            q qVarPn = pn(this.x.nr(i));
            if (qVarPn != null && !qVarPn.N_() && qVarPn.z()) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (this.mk == null) {
            EdgeEffect edgeEffectU = this.nb.u(this, 1);
            this.mk = edgeEffectU;
            if (this.f5177a) {
                edgeEffectU.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectU.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        a aVar = this.s;
        if (aVar == null || !aVar.u(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void b() {
        if (this.bg && !this.q) {
            if (!this.iz.b()) {
                return;
            }
            if (this.iz.u(4) && !this.iz.u(11)) {
                com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV PartialInvalidate");
                pn();
                l();
                this.iz.nr();
                if (!this.bq) {
                    if (z()) {
                        my();
                    } else {
                        this.iz.fx();
                    }
                }
                u(true);
                mv();
                com.bytedance.sdk.component.widget.recycler.u.u.u.u();
                return;
            }
            if (!this.iz.b()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV FullInvalidate");
        my();
        com.bytedance.sdk.component.widget.recycler.u.u.u.u();
    }

    public void bg() {
        int iFx = this.x.fx();
        for (int i = 0; i < iFx; i++) {
            q qVarPn = pn(this.x.b(i));
            if (!qVarPn.N_()) {
                qVarPn.u();
            }
        }
        this.pn.a();
    }

    public void bq() {
        int iFx = this.x.fx();
        for (int i = 0; i < iFx; i++) {
            q qVarPn = pn(this.x.b(i));
            if (qVarPn != null && !qVarPn.N_()) {
                qVarPn.nr(6);
            }
        }
        o();
        this.pn.n();
    }

    public void c() {
        q qVar;
        int iNr = this.x.nr();
        for (int i = 0; i < iNr; i++) {
            View viewNr = this.x.nr(i);
            q qVarNr = nr(viewNr);
            if (qVarNr != null && (qVar = qVarNr.f5181a) != null) {
                View view = qVar.u;
                int left = viewNr.getLeft();
                int top = viewNr.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof jk) && this.s.u((jk) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        a aVar = this.s;
        if (aVar != null && aVar.fx()) {
            return this.s.pn(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        a aVar = this.s;
        if (aVar != null && aVar.fx()) {
            return this.s.fx(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        a aVar = this.s;
        if (aVar != null && aVar.fx()) {
            return this.s.x(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        a aVar = this.s;
        if (aVar != null && aVar.b()) {
            return this.s.iz(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        a aVar = this.s;
        if (aVar != null && aVar.b()) {
            return this.s.b(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        a aVar = this.s;
        if (aVar != null && aVar.b()) {
            return this.s.n(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().u(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().u(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().u(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().u(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.my.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.my.get(i);
        }
        EdgeEffect edgeEffect = this.gc;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f5177a ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.gc;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mk;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f5177a) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mk;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.p;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f5177a ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.p;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.kw;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f5177a) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.kw;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.kj == null || this.my.size() <= 0 || !this.kj.nr()) ? z : true) {
            com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public boolean dw() {
        return !this.bg || this.q || this.iz.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewU;
        boolean z;
        View viewB = this.s.b(view, i);
        if (viewB != null) {
            return viewB;
        }
        boolean z2 = (this.mv == null || this.s == null || s() || this.dw) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.s.b()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (bc) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.s.fx()) {
                int i3 = (this.s.o() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (bc) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                b();
                if (fx(view) == null) {
                    return null;
                }
                pn();
                this.s.u(view, i, this.pn, this.h);
                u(false);
            }
            viewU = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                b();
                if (fx(view) == null) {
                    return null;
                }
                pn();
                viewU = this.s.u(view, i, this.pn, this.h);
                u(false);
            } else {
                viewU = viewFindNextFocus;
            }
        }
        if (viewU == null || viewU.hasFocusable()) {
            return u(view, viewU, i) ? viewU : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        u(viewU, (View) null);
        return view;
    }

    public void fx() {
        iz izVar = this.kj;
        if (izVar != null) {
            izVar.b();
        }
        a aVar = this.s;
        if (aVar != null) {
            aVar.fx(this.pn);
            this.s.nr(this.pn);
        }
        this.pn.u();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        a aVar = this.s;
        if (aVar != null) {
            return aVar.nr();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        a aVar = this.s;
        if (aVar != null) {
            return aVar.u(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    public u getAdapter() {
        return this.mv;
    }

    @Override // android.view.View
    public int getBaseline() {
        a aVar = this.s;
        return aVar != null ? aVar.sx() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        b bVar = this.tr;
        return bVar == null ? super.getChildDrawingOrder(i, i2) : bVar.u(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f5177a;
    }

    public pn getEdgeEffectFactory() {
        return this.nb;
    }

    public iz getItemAnimator() {
        return this.kj;
    }

    public int getItemDecorationCount() {
        return this.my.size();
    }

    public a getLayoutManager() {
        return this.s;
    }

    public int getMaxFlingVelocity() {
        return this.rg;
    }

    public int getMinFlingVelocity() {
        return this.uq;
    }

    public long getNanoTime() {
        if (b) {
            return System.nanoTime();
        }
        return 0L;
    }

    public l getOnFlingListener() {
        return this.jw;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.sf;
    }

    public k getRecycledViewPool() {
        return this.pn.x();
    }

    public int getScrollState() {
        return this.f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().nr();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.o;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().u();
    }

    public void iz() {
        setScrollState(0);
        gi();
    }

    public void jk() {
        if (this.kw == null) {
            EdgeEffect edgeEffectU = this.nb.u(this, 3);
            this.kw = edgeEffectU;
            if (this.f5177a) {
                edgeEffectU.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectU.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void k() {
        if (this.bf || !this.o) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.u.fx.x.u(this, this.hs);
        this.bf = true;
    }

    public void l() {
        this.eh++;
    }

    public void mv() {
        nr(true);
    }

    public void my() {
        if (this.mv == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.s == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        bq bqVar = this.h;
        bqVar.f5179a = false;
        if (bqVar.b != 1) {
            if (!this.iz.iz() && this.s.c() == getWidth() && this.s.q() == getHeight()) {
                this.s.b(this);
            }
            xw();
        }
        y();
        this.s.b(this);
        bc();
        xw();
    }

    public void n() {
        if (this.p == null) {
            EdgeEffect edgeEffectU = this.nb.u(this, 2);
            this.p = edgeEffectU;
            if (this.f5177a) {
                edgeEffectU.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectU.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void nr() {
        this.iz = new com.bytedance.sdk.component.widget.recycler.u(new u.InterfaceC0233u() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public void b(int i, int i2) {
                RecyclerView.this.iz(i, i2);
                RecyclerView.this.rh = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public void fx(int i, int i2) {
                RecyclerView.this.x(i, i2);
                RecyclerView.this.rh = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public void nr(int i, int i2) {
                RecyclerView.this.u(i, i2, false);
                RecyclerView.this.rh = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public q u(int i) {
                q qVarU = RecyclerView.this.u(i, true);
                if (qVarU == null || RecyclerView.this.x.fx(qVarU.u)) {
                    return null;
                }
                return qVarU;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public void u(int i, int i2) {
                RecyclerView.this.u(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.rh = true;
                recyclerView.h.fx += i2;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.InterfaceC0233u
            public void u(int i, int i2, Object obj) {
                RecyclerView.this.u(i, i2, obj);
                RecyclerView.this.ja = true;
            }
        });
    }

    public void o() {
        int iFx = this.x.fx();
        for (int i = 0; i < iFx; i++) {
            ((jk) this.x.b(i).getLayoutParams()).fx = true;
        }
        this.pn.jk();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.eh = 0;
        this.o = true;
        this.bg = this.bg && !isLayoutRequested();
        a aVar = this.s;
        if (aVar != null) {
            aVar.nr(this);
        }
        this.bf = false;
        if (b) {
            ThreadLocal<com.bytedance.sdk.component.widget.recycler.b> threadLocal = com.bytedance.sdk.component.widget.recycler.b.u;
            com.bytedance.sdk.component.widget.recycler.b bVar = threadLocal.get();
            this.gi = bVar;
            if (bVar == null) {
                this.gi = new com.bytedance.sdk.component.widget.recycler.b();
                Display displayX = com.bytedance.sdk.component.widget.recycler.u.fx.x.x(this);
                if (isInEditMode() || displayX == null) {
                    refreshRate = 60.0f;
                    com.bytedance.sdk.component.widget.recycler.b bVar2 = this.gi;
                    bVar2.b = (long) (1.0E9f / refreshRate);
                    threadLocal.set(bVar2);
                } else {
                    refreshRate = displayX.getRefreshRate();
                    if (refreshRate < 30.0f) {
                    }
                    com.bytedance.sdk.component.widget.recycler.b bVar22 = this.gi;
                    bVar22.b = (long) (1.0E9f / refreshRate);
                    threadLocal.set(bVar22);
                }
            }
            this.gi.u(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.b bVar;
        super.onDetachedFromWindow();
        iz izVar = this.kj;
        if (izVar != null) {
            izVar.b();
        }
        iz();
        this.o = false;
        a aVar = this.s;
        if (aVar != null) {
            aVar.nr(this, this.pn);
        }
        this.xg.clear();
        removeCallbacks(this.hs);
        this.n.nr();
        if (!b || (bVar = this.gi) == null) {
            return;
        }
        bVar.nr(this);
        this.gi = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.my.size();
        for (int i = 0; i < size; i++) {
            this.my.get(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0069  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.s != null && !this.dw && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.s.b() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.s.fx() ? motionEvent.getAxisValue(10) : 0.0f;
                if (f != 0.0f || axisValue != 0.0f) {
                    u((int) (axisValue * this.dc), (int) (f * this.ua), motionEvent);
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.s.b()) {
                    f = -axisValue;
                    if (f != 0.0f) {
                        u((int) (axisValue * this.dc), (int) (f * this.ua), motionEvent);
                    }
                } else {
                    if (this.s.fx()) {
                        f = 0.0f;
                        if (f != 0.0f) {
                        }
                    }
                    f = 0.0f;
                    if (f != 0.0f) {
                    }
                }
            } else {
                f = 0.0f;
                if (f != 0.0f) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.dw) {
            return false;
        }
        if (u(motionEvent)) {
            rh();
            return true;
        }
        a aVar = this.s;
        if (aVar == null) {
            return false;
        }
        boolean zFx = aVar.fx();
        boolean zB = this.s.b();
        if (this.tm == null) {
            this.tm = VelocityTracker.obtain();
        }
        this.tm.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mh) {
                this.mh = false;
            }
            this.za = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.ob = x2;
            this.rv = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ju = y2;
            this.ge = y2;
            if (this.f == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.ki;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zFx;
            if (zB) {
                i = (zFx ? 1 : 0) | 2;
            }
            a(i, 0);
        } else if (actionMasked == 1) {
            this.tm.clear();
            n(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.za);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Error processing scroll; pointer index for id " + this.za + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f != 1) {
                int i2 = x3 - this.rv;
                int i3 = y3 - this.ge;
                if (!zFx || Math.abs(i2) <= this.zx) {
                    z = false;
                } else {
                    this.ob = x3;
                    z = true;
                }
                if (zB && Math.abs(i3) > this.zx) {
                    this.ju = y3;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            rh();
        } else if (actionMasked == 5) {
            this.za = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ob = x4;
            this.rv = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ju = y4;
            this.ge = y4;
        } else if (actionMasked == 6) {
            fx(motionEvent);
        }
        return this.f == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV OnLayout");
        my();
        com.bytedance.sdk.component.widget.recycler.u.u.u.u();
        this.bg = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        a aVar = this.s;
        if (aVar == null) {
            pn(i, i2);
            return;
        }
        boolean z = false;
        if (aVar.u()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.s.u(this.pn, this.h, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mv == null) {
                return;
            }
            if (this.h.b == 1) {
                y();
            }
            this.s.nr(i, i2);
            this.h.f5179a = true;
            bc();
            this.s.fx(i, i2);
            if (this.s.a()) {
                this.s.nr(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.h.f5179a = true;
                bc();
                this.s.fx(i, i2);
                return;
            }
            return;
        }
        if (this.sx) {
            this.s.u(this.pn, this.h, i, i2);
            return;
        }
        if (this.c) {
            pn();
            l();
            wq();
            mv();
            bq bqVar = this.h;
            if (bqVar.t) {
                bqVar.x = true;
            } else {
                this.iz.pn();
                this.h.x = false;
            }
            this.c = false;
            u(false);
        } else if (this.h.t) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        u uVar = this.mv;
        if (uVar != null) {
            this.h.pn = uVar.u();
        } else {
            this.h.pn = 0;
        }
        pn();
        this.s.u(this.pn, this.h, i, i2);
        u(false);
        this.h.x = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (s()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2 = false;
        if (this.dw || this.mh) {
            return false;
        }
        if (nr(motionEvent)) {
            rh();
            return true;
        }
        a aVar = this.s;
        if (aVar == null) {
            return false;
        }
        boolean zFx = aVar.fx();
        boolean zB = this.s.b();
        if (this.tm == null) {
            this.tm = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.ki;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.ki;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.za = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.ob = x2;
            this.rv = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ju = y2;
            this.ge = y2;
            int i = zFx;
            if (zB) {
                i = (zFx ? 1 : 0) | 2;
            }
            a(i, 0);
        } else if (actionMasked == 1) {
            this.tm.addMovement(motionEventObtain);
            this.tm.computeCurrentVelocity(1000, this.rg);
            float f = zFx ? -this.tm.getXVelocity(this.za) : 0.0f;
            float f2 = zB ? -this.tm.getYVelocity(this.za) : 0.0f;
            if ((f == 0.0f && f2 == 0.0f) || !nr((int) f, (int) f2)) {
                setScrollState(0);
            }
            h();
            z2 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.za);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Error processing scroll; pointer index for id " + this.za + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int i2 = this.ob - x3;
            int i3 = this.ju - y3;
            if (u(i2, i3, this.wq, this.zq, 0)) {
                int[] iArr3 = this.wq;
                i2 -= iArr3[0];
                i3 -= iArr3[1];
                int[] iArr4 = this.zq;
                motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                int[] iArr5 = this.ki;
                int i4 = iArr5[0];
                int[] iArr6 = this.zq;
                iArr5[0] = i4 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.f != 1) {
                if (zFx) {
                    int iAbs = Math.abs(i2);
                    int i5 = this.zx;
                    if (iAbs > i5) {
                        i2 = i2 > 0 ? i2 - i5 : i2 + i5;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (zB) {
                        int iAbs2 = Math.abs(i3);
                        int i6 = this.zx;
                        if (iAbs2 > i6) {
                            i3 = i3 > 0 ? i3 - i6 : i3 + i6;
                            z = true;
                        }
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
            }
            if (this.f == 1) {
                int[] iArr7 = this.zq;
                this.ob = x3 - iArr7[0];
                this.ju = y3 - iArr7[1];
                if (u(zFx ? i2 : 0, zB ? i3 : 0, motionEventObtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                com.bytedance.sdk.component.widget.recycler.b bVar = this.gi;
                if (bVar != null && (i2 != 0 || i3 != 0)) {
                    bVar.u(this, i2, i3);
                }
            }
        } else if (actionMasked == 3) {
            rh();
        } else if (actionMasked == 5) {
            this.za = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ob = x4;
            this.rv = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ju = y4;
            this.ge = y4;
        } else if (actionMasked == 6) {
            fx(motionEvent);
        }
        if (!z2) {
            this.tm.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void q() {
        int i;
        for (int size = this.xg.size() - 1; size >= 0; size--) {
            q qVar = this.xg.get(size);
            if (qVar.u.getParent() == this && !qVar.N_() && (i = qVar.k) != -1) {
                com.bytedance.sdk.component.widget.recycler.u.fx.x.u(qVar.u, i);
                qVar.k = -1;
            }
        }
        this.xg.clear();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        q qVarPn = pn(view);
        if (qVarPn != null) {
            if (qVarPn.sx()) {
                qVarPn.mv();
            } else if (!qVarPn.N_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + qVarPn + u());
            }
        }
        view.clearAnimation();
        t(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.s.u(this, this.h, view, view2) && view2 != null) {
            u(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.s.u(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.tk.size();
        for (int i = 0; i < size; i++) {
            this.tk.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.su != 0 || this.dw) {
            this.bq = true;
        } else {
            super.requestLayout();
        }
    }

    public boolean s() {
        return this.eh > 0;
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        a aVar = this.s;
        if (aVar == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.dw) {
            return;
        }
        boolean zFx = aVar.fx();
        boolean zB = this.s.b();
        if (zFx || zB) {
            if (!zFx) {
                i = 0;
            }
            if (!zB) {
                i2 = 0;
            }
            u(i, i2, (MotionEvent) null);
        }
    }

    public void setAdapter(u uVar) {
        setLayoutFrozen(false);
        u(uVar, false, true);
        fx(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(b bVar) {
        if (bVar != this.tr) {
            this.tr = bVar;
            setChildrenDrawingOrderEnabled(bVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f5177a) {
            t();
        }
        this.f5177a = z;
        super.setClipToPadding(z);
        if (this.bg) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(pn pnVar) {
        u(pnVar);
        this.nb = pnVar;
        t();
    }

    public void setHasFixedSize(boolean z) {
        this.sx = z;
    }

    public void setItemAnimator(iz izVar) {
        iz izVar2 = this.kj;
        if (izVar2 != null) {
            izVar2.b();
            this.kj.u(null);
        }
        this.kj = izVar;
        if (izVar != null) {
            izVar.u(this.dj);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.pn.u(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.dw) {
            u("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.dw = true;
                this.mh = true;
                iz();
                return;
            }
            this.dw = false;
            if (this.bq && this.s != null && this.mv != null) {
                requestLayout();
            }
            this.bq = false;
        }
    }

    public void setLayoutManager(a aVar) {
        if (aVar != this.s) {
            iz();
            if (this.s != null) {
                iz izVar = this.kj;
                if (izVar != null) {
                    izVar.b();
                }
                this.s.fx(this.pn);
                this.s.nr(this.pn);
                this.pn.u();
                if (this.o) {
                    this.s.nr(this, this.pn);
                }
                this.s.u((RecyclerView) null);
                this.s = null;
            } else {
                this.pn.u();
            }
            this.x.u();
            this.s = aVar;
            if (aVar != null) {
                if (aVar.f5178a != null) {
                    throw new IllegalArgumentException("LayoutManager " + aVar + " is already attached to a RecyclerView:" + aVar.f5178a.u());
                }
                aVar.u(this);
                if (this.o) {
                    this.s.nr(this);
                }
            }
            this.pn.nr();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().u(z);
    }

    public void setOnFlingListener(l lVar) {
        this.jw = lVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.sf = z;
    }

    public void setRecycledViewPool(k kVar) {
        this.pn.u(kVar);
    }

    public void setRecyclerListener(o oVar) {
        this.k = oVar;
    }

    public void setScrollState(int i) {
        if (i != this.f) {
            this.f = i;
            if (i != 2) {
                gi();
            }
            x(i);
        }
    }

    public void setViewCacheExtension(dw dwVar) {
        this.pn.u(dwVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().nr(i);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.u.fx.nr
    public void stopNestedScroll() {
        getScrollingChildHelper().fx();
    }

    public void sx() {
        int iFx = this.x.fx();
        for (int i = 0; i < iFx; i++) {
            q qVarPn = pn(this.x.b(i));
            if (!qVarPn.N_()) {
                qVarPn.nr();
            }
        }
    }

    public void t() {
        this.kw = null;
        this.mk = null;
        this.p = null;
        this.gc = null;
    }

    public void x() {
        if (this.gc == null) {
            EdgeEffect edgeEffectU = this.nb.u(this, 0);
            this.gc = edgeEffectU;
            if (this.f5177a) {
                edgeEffectU.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectU.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class bq {
        int k;
        int l;
        long mv;
        int my;
        private SparseArray<Object> o;
        int s;
        int u = -1;
        int nr = 0;
        int fx = 0;
        int b = 1;
        int pn = 0;
        boolean iz = false;
        boolean x = false;
        boolean n = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f5179a = false;
        boolean jk = false;
        boolean t = false;

        public int b() {
            return this.x ? this.nr - this.fx : this.pn;
        }

        public boolean fx() {
            return this.u != -1;
        }

        public boolean nr() {
            return this.t;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.u + ", mData=" + this.o + ", mItemCount=" + this.pn + ", mIsMeasuring=" + this.f5179a + ", mPreviousLayoutItemCount=" + this.nr + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.fx + ", mStructureChanged=" + this.iz + ", mInPreLayout=" + this.x + ", mRunSimpleAnimations=" + this.jk + ", mRunPredictiveAnimations=" + this.t + '}';
        }

        public void u(int i) {
            if ((this.b & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.b));
        }

        public void u(u uVar) {
            this.b = 1;
            this.pn = uVar.u();
            this.x = false;
            this.n = false;
            this.f5179a = false;
        }

        public boolean u() {
            return this.x;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {
        SparseArray<u> u = new SparseArray<>();
        private int nr = 0;

        /* JADX INFO: compiled from: SearchBox */
        public static class u {
            final ArrayList<q> u = new ArrayList<>();
            int nr = 5;
            long fx = 0;
            long b = 0;
        }

        public void fx() {
            this.nr--;
        }

        public void nr(int i, long j) {
            u uVarNr = nr(i);
            uVarNr.b = u(uVarNr.b, j);
        }

        public void u() {
            for (int i = 0; i < this.u.size(); i++) {
                this.u.valueAt(i).u.clear();
            }
        }

        public boolean nr(int i, long j, long j2) {
            long j3 = nr(i).b;
            return j3 == 0 || j + j3 < j2;
        }

        public void nr() {
            this.nr++;
        }

        public q u(int i) {
            u uVar = this.u.get(i);
            if (uVar == null || uVar.u.isEmpty()) {
                return null;
            }
            return uVar.u.remove(r2.size() - 1);
        }

        private u nr(int i) {
            u uVar = this.u.get(i);
            if (uVar != null) {
                return uVar;
            }
            u uVar2 = new u();
            this.u.put(i, uVar2);
            return uVar2;
        }

        public void u(q qVar) {
            int iN = qVar.n();
            ArrayList<q> arrayList = nr(iN).u;
            if (this.u.get(iN).nr > arrayList.size()) {
                qVar.c();
                arrayList.add(qVar);
            }
        }

        public long u(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void u(int i, long j) {
            u uVarNr = nr(i);
            uVarNr.fx = u(uVarNr.fx, j);
        }

        public boolean u(int i, long j, long j2) {
            long j3 = nr(i).fx;
            return j3 == 0 || j + j3 < j2;
        }

        public void u(u uVar, u uVar2, boolean z) {
            if (uVar != null) {
                fx();
            }
            if (!z && this.nr == 0) {
                u();
            }
            if (uVar2 != null) {
                nr();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends Observable<fx> {
        public void u() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((fx) ((Observable) this).mObservers.get(size)).u();
            }
        }

        public void u(int i, int i2) {
            u(i, i2, null);
        }

        public void u(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((fx) ((Observable) this).mObservers.get(size)).u(i, i2, obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class q {
        private static final List<Object> o = Collections.emptyList();
        int jk;
        RecyclerView my;
        WeakReference<RecyclerView> nr;
        public final View u;
        int fx = -1;
        int b = -1;
        long pn = -1;
        int iz = -1;
        int x = -1;
        q n = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        q f5181a = null;
        List<Object> t = null;
        List<Object> l = null;
        private int sx = 0;
        my mv = null;
        boolean s = false;
        private int bg = 0;
        int k = -1;

        public q(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.u = view;
        }

        private void gi() {
            if (this.t == null) {
                ArrayList arrayList = new ArrayList();
                this.t = arrayList;
                this.l = Collections.unmodifiableList(arrayList);
            }
        }

        public boolean N_() {
            return (this.jk & 128) != 0;
        }

        boolean a() {
            return this.mv != null;
        }

        public final int b() {
            int i = this.x;
            return i == -1 ? this.fx : i;
        }

        boolean bg() {
            return (this.jk & 512) != 0 || s();
        }

        void bq() {
            List<Object> list = this.t;
            if (list != null) {
                list.clear();
            }
            this.jk &= ErrorCode.ERROR_CODE_JOIN_ROOM_ROOM_FORBIDDEN;
        }

        void c() {
            this.jk = 0;
            this.fx = -1;
            this.b = -1;
            this.pn = -1L;
            this.x = -1;
            this.sx = 0;
            this.n = null;
            this.f5181a = null;
            bq();
            this.bg = 0;
            this.k = -1;
            RecyclerView.fx(this);
        }

        List<Object> dw() {
            if ((this.jk & 1024) != 0) {
                return o;
            }
            List<Object> list = this.t;
            return (list == null || list.size() == 0) ? o : this.l;
        }

        public final int iz() {
            return this.b;
        }

        void jk() {
            this.mv.fx(this);
        }

        boolean k() {
            return (this.jk & 2) != 0;
        }

        boolean kj() {
            return (this.jk & 16) == 0 && com.bytedance.sdk.component.widget.recycler.u.fx.x.iz(this.u);
        }

        void l() {
            this.jk &= -33;
        }

        void mv() {
            this.jk &= -257;
        }

        boolean my() {
            return (this.jk & 1) != 0;
        }

        public final int n() {
            return this.iz;
        }

        void nr() {
            if (this.b == -1) {
                this.b = this.fx;
            }
        }

        boolean o() {
            return (this.jk & 8) != 0;
        }

        public final int pn() {
            RecyclerView recyclerView = this.my;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b(this);
        }

        public final boolean q() {
            return (this.jk & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.u.fx.x.iz(this.u);
        }

        boolean qq() {
            return (this.jk & 16) != 0;
        }

        boolean s() {
            return (this.jk & 4) != 0;
        }

        boolean sx() {
            return (this.jk & 256) != 0;
        }

        boolean t() {
            return (this.jk & 32) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.fx + " id=" + this.pn + ", oldPos=" + this.b + ", pLpos:" + this.x);
            if (a()) {
                sb.append(" scrap ");
                sb.append(this.s ? "[changeScrap]" : "[attachedScrap]");
            }
            if (s()) {
                sb.append(" invalid");
            }
            if (!my()) {
                sb.append(" unbound");
            }
            if (k()) {
                sb.append(" update");
            }
            if (o()) {
                sb.append(" removed");
            }
            if (N_()) {
                sb.append(" ignored");
            }
            if (sx()) {
                sb.append(" tmpDetached");
            }
            if (!q()) {
                sb.append(" not recyclable(" + this.sx + ")");
            }
            if (bg()) {
                sb.append(" undefined adapter position");
            }
            if (this.u.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void u(int i, int i2, boolean z) {
            nr(8);
            u(i2, z);
            this.fx = i;
        }

        public final long x() {
            return this.pn;
        }

        boolean z() {
            return (this.jk & 2) != 0;
        }

        void nr(int i) {
            this.jk = i | this.jk;
        }

        public void nr(RecyclerView recyclerView) {
            recyclerView.u(this, this.bg);
            this.bg = 0;
        }

        void u(int i, boolean z) {
            if (this.b == -1) {
                this.b = this.fx;
            }
            if (this.x == -1) {
                this.x = this.fx;
            }
            if (z) {
                this.x += i;
            }
            this.fx += i;
            if (this.u.getLayoutParams() != null) {
                ((jk) this.u.getLayoutParams()).fx = true;
            }
        }

        void u() {
            this.b = -1;
            this.x = -1;
        }

        public void u(my myVar, boolean z) {
            this.mv = myVar;
            this.s = z;
        }

        boolean u(int i) {
            return (i & this.jk) != 0;
        }

        void u(int i, int i2) {
            this.jk = (i & i2) | (this.jk & (~i2));
        }

        void u(Object obj) {
            if (obj == null) {
                nr(1024);
            } else if ((1024 & this.jk) == 0) {
                gi();
                this.t.add(obj);
            }
        }

        public void u(RecyclerView recyclerView) {
            int i = this.k;
            if (i != -1) {
                this.bg = i;
            } else {
                this.bg = com.bytedance.sdk.component.widget.recycler.u.fx.x.nr(this.u);
            }
            recyclerView.u(this, 4);
        }

        public final void u(boolean z) {
            int i = this.sx;
            int i2 = z ? i - 1 : i + 1;
            this.sx = i2;
            if (i2 < 0) {
                this.sx = 0;
                com.bytedance.sdk.component.utils.k.nr("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.jk |= 16;
            } else if (z && i2 == 0) {
                this.jk &= -17;
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int mv(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public void l(View view) {
        pn(view);
        List<t> list = this.v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.v.get(size).u(view);
            }
        }
    }

    public void nr(s sVar) {
        List<s> list = this.qe;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public void t(View view) {
        pn(view);
        List<t> list = this.v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.v.get(size).nr(view);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class bg {
        private boolean b;
        private a fx;
        private View iz;
        private boolean n;
        private RecyclerView nr;
        private boolean pn;
        private int u = -1;
        private final u x = new u(0, 0);

        /* JADX INFO: compiled from: SearchBox */
        public interface nr {
            PointF fx(int i);
        }

        /* JADX INFO: compiled from: SearchBox */
        public static class u {
            private int b;
            private int fx;
            private boolean iz;
            private int nr;
            private Interpolator pn;
            private int u;
            private int x;

            public u(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void nr() {
                if (this.pn != null && this.fx <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.fx <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void u(int i) {
                this.b = i;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.u = i;
                this.nr = i2;
                this.fx = i3;
                this.pn = interpolator;
                this.iz = true;
            }

            public u(int i, int i2, int i3, Interpolator interpolator) {
                this.b = -1;
                this.iz = false;
                this.x = 0;
                this.u = i;
                this.nr = i2;
                this.fx = i3;
                this.pn = interpolator;
            }

            public boolean u() {
                return this.b >= 0;
            }

            public void u(RecyclerView recyclerView) {
                int i = this.b;
                if (i >= 0) {
                    this.b = -1;
                    recyclerView.u(i);
                    this.iz = false;
                    return;
                }
                if (this.iz) {
                    nr();
                    Interpolator interpolator = this.pn;
                    if (interpolator == null) {
                        int i2 = this.fx;
                        if (i2 == Integer.MIN_VALUE) {
                            recyclerView.z.nr(this.u, this.nr);
                        } else {
                            recyclerView.z.u(this.u, this.nr, i2);
                        }
                    } else {
                        recyclerView.z.u(this.u, this.nr, this.fx, interpolator);
                    }
                    int i3 = this.x + 1;
                    this.x = i3;
                    if (i3 > 10) {
                        com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.iz = false;
                    return;
                }
                this.x = 0;
            }
        }

        public int a() {
            return this.nr.s.bg();
        }

        public PointF b(int i) {
            Object objB = b();
            if (objB instanceof nr) {
                return ((nr) objB).fx(i);
            }
            return null;
        }

        public void fx(int i) {
            this.u = i;
        }

        public boolean iz() {
            return this.b;
        }

        public int n() {
            return this.u;
        }

        public void nr(View view) {
            if (u(view) == n()) {
                this.iz = view;
            }
        }

        public final void pn() {
            if (this.pn) {
                this.pn = false;
                u();
                this.nr.h.u = -1;
                this.iz = null;
                this.u = -1;
                this.b = false;
                this.fx.nr(this);
                this.fx = null;
                this.nr = null;
            }
        }

        public abstract void u();

        public abstract void u(int i, int i2, bq bqVar, u uVar);

        public abstract void u(View view, bq bqVar, u uVar);

        public void u(RecyclerView recyclerView, a aVar) {
            this.nr = recyclerView;
            this.fx = aVar;
            int i = this.u;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.h.u = i;
            this.pn = true;
            this.b = true;
            this.iz = pn(n());
            this.nr.z.u();
            this.n = true;
        }

        public boolean x() {
            return this.pn;
        }

        public a b() {
            return this.fx;
        }

        public View pn(int i) {
            return this.nr.s.nr(i);
        }

        public void u(int i, int i2) {
            PointF pointFB;
            RecyclerView recyclerView = this.nr;
            if (!this.pn || this.u == -1 || recyclerView == null) {
                pn();
            }
            if (this.b && this.iz == null && this.fx != null && (pointFB = b(this.u)) != null) {
                float f = pointFB.x;
                if (f != 0.0f || pointFB.y != 0.0f) {
                    recyclerView.u((int) Math.signum(f), (int) Math.signum(pointFB.y), (int[]) null);
                }
            }
            this.b = false;
            View view = this.iz;
            if (view != null) {
                if (u(view) == this.u) {
                    u(this.iz, recyclerView.h, this.x);
                    this.x.u(recyclerView);
                    pn();
                } else {
                    com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.iz = null;
                }
            }
            if (this.pn) {
                u(i, i2, recyclerView.h, this.x);
                boolean zU = this.x.u();
                this.x.u(recyclerView);
                if (zU) {
                    if (this.pn) {
                        this.b = true;
                        recyclerView.z.u();
                    } else {
                        pn();
                    }
                }
            }
        }

        public int u(View view) {
            return this.nr.n(view);
        }

        public void u(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = new sx();
        this.pn = new my();
        this.n = new com.bytedance.sdk.component.widget.recycler.s();
        this.jk = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.bg || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.o) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.dw) {
                    recyclerView2.bq = true;
                } else {
                    recyclerView2.b();
                }
            }
        };
        this.t = new Rect();
        this.cj = new Rect();
        this.l = new RectF();
        this.my = new ArrayList<>();
        this.tk = new ArrayList<>();
        this.su = 0;
        this.q = false;
        this.qq = false;
        this.eh = 0;
        this.lf = 0;
        this.nb = new pn();
        this.kj = new com.bytedance.sdk.component.widget.recycler.fx();
        this.f = 0;
        this.za = -1;
        this.dc = Float.MIN_VALUE;
        this.ua = Float.MIN_VALUE;
        this.sf = true;
        this.z = new c();
        this.d = b ? new b.u() : null;
        this.h = new bq();
        this.rh = false;
        this.ja = false;
        this.dj = new x();
        this.bf = false;
        this.ex = new int[2];
        this.zq = new int[2];
        this.wq = new int[2];
        this.ki = new int[2];
        this.pb = new int[2];
        this.xg = new ArrayList();
        this.hs = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                iz izVar = RecyclerView.this.kj;
                if (izVar != null) {
                    izVar.u();
                }
                RecyclerView.this.bf = false;
            }
        };
        this.te = new s.nr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.s.nr
            public void fx(q qVar, iz.nr nrVar, iz.nr nrVar2) {
                qVar.u(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.q) {
                    if (recyclerView.kj.u(qVar, qVar, nrVar, nrVar2)) {
                        RecyclerView.this.k();
                    }
                } else if (recyclerView.kj.fx(qVar, nrVar, nrVar2)) {
                    RecyclerView.this.k();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.s.nr
            public void nr(q qVar, iz.nr nrVar, iz.nr nrVar2) {
                RecyclerView.this.u(qVar, nrVar, nrVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.s.nr
            public void u(q qVar, iz.nr nrVar, iz.nr nrVar2) {
                RecyclerView.this.pn.fx(qVar);
                RecyclerView.this.nr(qVar, nrVar, nrVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.s.nr
            public void u(q qVar) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.s.u(qVar.u, recyclerView.pn);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y, i, 0);
                this.f5177a = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        } else {
            this.f5177a = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.zx = viewConfiguration.getScaledTouchSlop();
        this.dc = com.bytedance.sdk.component.widget.recycler.u.fx.x.u(viewConfiguration, context);
        this.ua = com.bytedance.sdk.component.widget.recycler.u.fx.x.nr(viewConfiguration, context);
        this.uq = viewConfiguration.getScaledMinimumFlingVelocity();
        this.rg = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.kj.u(this.dj);
        nr();
        kj();
        qq();
        if (com.bytedance.sdk.component.widget.recycler.u.fx.x.nr(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.u.fx.x.u(this, 1);
        }
        this.ay = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable unused2) {
        }
        setNestedScrollingEnabled(true);
    }

    public void iz(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int iFx = this.x.fx();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < iFx; i7++) {
            q qVarPn = pn(this.x.b(i7));
            if (qVarPn != null && (i6 = qVarPn.fx) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    qVarPn.u(i2 - i, false);
                } else {
                    qVarPn.u(i5, false);
                }
                this.h.iz = true;
            }
        }
        this.pn.u(i, i2);
        requestLayout();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class jk extends ViewGroup.MarginLayoutParams {
        boolean b;
        boolean fx;
        final Rect nr;
        q u;

        public jk(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.nr = new Rect();
            this.fx = true;
            this.b = false;
        }

        public int b() {
            return this.u.b();
        }

        public boolean fx() {
            return this.u.z();
        }

        public boolean nr() {
            return this.u.o();
        }

        public boolean u() {
            return this.u.s();
        }

        public jk(int i, int i2) {
            super(i, i2);
            this.nr = new Rect();
            this.fx = true;
            this.b = false;
        }

        public jk(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.nr = new Rect();
            this.fx = true;
            this.b = false;
        }

        public jk(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.nr = new Rect();
            this.fx = true;
            this.b = false;
        }

        public jk(jk jkVar) {
            super((ViewGroup.MarginLayoutParams) jkVar);
            this.nr = new Rect();
            this.fx = true;
            this.b = false;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        a aVar = this.s;
        if (aVar != null) {
            return aVar.u(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + u());
    }

    public void nr(int i) {
        if (this.dw) {
            return;
        }
        a aVar = this.s;
        if (aVar == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            aVar.u(this, this.h, i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class sx extends fx {
        public sx() {
        }

        public void nr() {
            if (RecyclerView.fx) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.sx && recyclerView.o) {
                    com.bytedance.sdk.component.widget.recycler.u.fx.x.u(recyclerView, recyclerView.jk);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.c = true;
            recyclerView2.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fx
        public void u() {
            RecyclerView.this.u((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.h.iz = true;
            recyclerView.fx(true);
            if (RecyclerView.this.iz.b()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fx
        public void u(int i, int i2, Object obj) {
            RecyclerView.this.u((String) null);
            if (RecyclerView.this.iz.u(i, i2, obj)) {
                nr();
            }
        }
    }

    public String u() {
        return " " + super.toString() + ", adapter:" + this.mv + ", layout:" + this.s + ", context:" + getContext();
    }

    private boolean jk(int i, int i2) {
        u(this.ex);
        int[] iArr = this.ex;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void u(u uVar, boolean z, boolean z2) {
        u uVar2 = this.mv;
        if (uVar2 != null) {
            uVar2.nr(this.w);
        }
        if (!z || z2) {
            fx();
        }
        this.iz.u();
        u uVar3 = this.mv;
        this.mv = uVar;
        if (uVar != null) {
            uVar.u(this.w);
        }
        this.pn.u(uVar3, this.mv, z);
        this.h.iz = true;
    }

    public Rect a(View view) {
        jk jkVar = (jk) view.getLayoutParams();
        if (!jkVar.fx) {
            return jkVar.nr;
        }
        if (this.h.u() && (jkVar.fx() || jkVar.u())) {
            return jkVar.nr;
        }
        Rect rect = jkVar.nr;
        rect.set(0, 0, 0, 0);
        int size = this.my.size();
        for (int i = 0; i < size; i++) {
            this.t.set(0, 0, 0, 0);
            this.my.get(i).u(this.t, view, this, this.h);
            int i2 = rect.left;
            Rect rect2 = this.t;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        jkVar.fx = false;
        return rect;
    }

    public int n(View view) {
        q qVarPn = pn(view);
        if (qVarPn != null) {
            return qVarPn.b();
        }
        return -1;
    }

    public void x(int i, int i2) {
        int iFx = this.x.fx();
        for (int i3 = 0; i3 < iFx; i3++) {
            q qVarPn = pn(this.x.b(i3));
            if (qVarPn != null && !qVarPn.N_() && qVarPn.fx >= i) {
                qVarPn.u(i2, false);
                this.h.iz = true;
            }
        }
        this.pn.nr(i, i2);
        requestLayout();
    }

    public void fx(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.gc;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.gc.onRelease();
            zIsFinished = this.gc.isFinished();
        }
        EdgeEffect edgeEffect2 = this.p;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.p.onRelease();
            zIsFinished |= this.p.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mk;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mk.onRelease();
            zIsFinished |= this.mk.isFinished();
        }
        EdgeEffect edgeEffect4 = this.kw;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.kw.onRelease();
            zIsFinished |= this.kw.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
        }
    }

    public static RecyclerView jk(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewJk = jk(viewGroup.getChildAt(i));
            if (recyclerViewJk != null) {
                return recyclerViewJk;
            }
        }
        return null;
    }

    public void n(int i, int i2) {
        this.lf++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        s sVar = this.i;
        if (sVar != null) {
            sVar.u(this, i, i2);
        }
        List<s> list = this.qe;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.qe.get(size).u(this, i, i2);
            }
        }
        this.lf--;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean nr(int i, int i2) {
        a aVar = this.s;
        if (aVar == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.dw) {
            return false;
        }
        int iFx = aVar.fx();
        boolean zB = this.s.b();
        if (iFx == 0 || Math.abs(i) < this.uq) {
            i = 0;
        }
        if (!zB || Math.abs(i2) < this.uq) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = iFx != 0 || zB;
            dispatchNestedFling(f, f2, z);
            l lVar = this.jw;
            if (lVar != null && lVar.u(i, i2)) {
                return true;
            }
            if (z) {
                if (zB) {
                    iFx = (iFx == true ? 1 : 0) | 2;
                }
                a(iFx, 1);
                int i3 = this.rg;
                int iMax = Math.max(-i3, Math.min(i, i3));
                int i4 = this.rg;
                this.z.u(iMax, Math.max(-i4, Math.min(i2, i4)));
                return true;
            }
        }
        return false;
    }

    public void pn() {
        int i = this.su + 1;
        this.su = i;
        if (i != 1 || this.dw) {
            return;
        }
        this.bq = false;
    }

    @Deprecated
    public int iz(View view) {
        return x(view);
    }

    public void pn(int i, int i2) {
        setMeasuredDimension(a.u(i, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.u.fx.x.b(this)), a.u(i2, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.u.fx.x.pn(this)));
    }

    public void iz(int i) {
        int iNr = this.x.nr();
        for (int i2 = 0; i2 < iNr; i2++) {
            this.x.nr(i2).offsetLeftAndRight(i);
        }
    }

    public int x(View view) {
        q qVarPn = pn(view);
        if (qVarPn != null) {
            return qVarPn.pn();
        }
        return -1;
    }

    public static q pn(View view) {
        if (view == null) {
            return null;
        }
        return ((jk) view.getLayoutParams()).u;
    }

    public void pn(int i) {
        int iNr = this.x.nr();
        for (int i2 = 0; i2 < iNr; i2++) {
            this.x.nr(i2).offsetTopAndBottom(i);
        }
    }

    public void u(t tVar) {
        if (this.v == null) {
            this.v = new ArrayList();
        }
        this.v.add(tVar);
    }

    public void x(int i) {
        a aVar = this.s;
        if (aVar != null) {
            aVar.t(i);
        }
        s sVar = this.i;
        if (sVar != null) {
            sVar.u(this, i);
        }
        List<s> list = this.qe;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.qe.get(size).u(this, i);
            }
        }
    }

    public void n(int i) {
        getScrollingChildHelper().fx(i);
    }

    public boolean u(View view) {
        pn();
        boolean zIz = this.x.iz(view);
        if (zIz) {
            q qVarPn = pn(view);
            this.pn.fx(qVarPn);
            this.pn.nr(qVarPn);
        }
        u(!zIz);
        return zIz;
    }

    public void b(int i, int i2) {
        if (i < 0) {
            x();
            this.gc.onAbsorb(-i);
        } else if (i > 0) {
            n();
            this.p.onAbsorb(i);
        }
        if (i2 < 0) {
            a();
            this.mk.onAbsorb(-i2);
        } else if (i2 > 0) {
            jk();
            this.kw.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
    }

    private void fx(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.za) {
            int i = actionIndex == 0 ? 1 : 0;
            this.za = motionEvent.getPointerId(i);
            int x2 = (int) (motionEvent.getX(i) + 0.5f);
            this.ob = x2;
            this.rv = x2;
            int y2 = (int) (motionEvent.getY(i) + 0.5f);
            this.ju = y2;
            this.ge = y2;
        }
    }

    public boolean a(int i, int i2) {
        return getScrollingChildHelper().u(i, i2);
    }

    private boolean nr(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.wi != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.wi = null;
                }
                return true;
            }
            this.wi = null;
        }
        if (action != 0) {
            int size = this.tk.size();
            for (int i = 0; i < size; i++) {
                mv mvVar = this.tk.get(i);
                if (mvVar.u(this, motionEvent)) {
                    this.wi = mvVar;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(int i) {
        return getScrollingChildHelper().u(i);
    }

    public void u(n nVar, int i) {
        a aVar = this.s;
        if (aVar != null) {
            aVar.u("Cannot add item decoration during a scroll  or layout");
        }
        if (this.my.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.my.add(nVar);
        } else {
            this.my.add(i, nVar);
        }
        o();
        requestLayout();
    }

    public void fx(boolean z) {
        this.qq = z | this.qq;
        this.q = true;
        bq();
    }

    public q b(View view) {
        View viewFx = fx(view);
        if (viewFx == null) {
            return null;
        }
        return nr(viewFx);
    }

    public View fx(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public q b(int i) {
        q qVar = null;
        if (this.q) {
            return null;
        }
        int iFx = this.x.fx();
        for (int i2 = 0; i2 < iFx; i2++) {
            q qVarPn = pn(this.x.b(i2));
            if (qVarPn != null && !qVarPn.o() && b(qVarPn) == i) {
                if (!this.x.fx(qVarPn.u)) {
                    return qVarPn;
                }
                qVar = qVarPn;
            }
        }
        return qVar;
    }

    public q fx(int i) {
        return u(i, false);
    }

    public void nr(boolean z) {
        int i = this.eh - 1;
        this.eh = i;
        if (i <= 0) {
            this.eh = 0;
            if (z) {
                ja();
                q();
            }
        }
    }

    public static void fx(q qVar) {
        WeakReference<RecyclerView> weakReference = qVar.nr;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == qVar.u) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            qVar.nr = null;
        }
    }

    public void u(n nVar) {
        u(nVar, -1);
    }

    public void u(s sVar) {
        if (this.qe == null) {
            this.qe = new ArrayList();
        }
        this.qe.add(sVar);
    }

    public void nr(q qVar, iz.nr nrVar, iz.nr nrVar2) {
        pn(qVar);
        qVar.u(false);
        if (this.kj.u(qVar, nrVar, nrVar2)) {
            k();
        }
    }

    public int b(q qVar) {
        if (qVar.u(524) || !qVar.my()) {
            return -1;
        }
        return this.iz.fx(qVar.fx);
    }

    public void u(int i) {
        a aVar = this.s;
        if (aVar != null) {
            aVar.b(i);
            awakenScrollBars();
        }
    }

    public boolean nr(q qVar) {
        iz izVar = this.kj;
        return izVar == null || izVar.u(qVar, qVar.dw());
    }

    public q nr(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return pn(view);
    }

    public void u(int i, int i2, int[] iArr) {
        pn();
        l();
        com.bytedance.sdk.component.widget.recycler.u.u.u.u("RV Scroll");
        u(this.h);
        int iU = i != 0 ? this.s.u(i, this.pn, this.h) : 0;
        int iNr = i2 != 0 ? this.s.nr(i2, this.pn, this.h) : 0;
        com.bytedance.sdk.component.widget.recycler.u.u.u.u();
        c();
        mv();
        u(false);
        if (iArr != null) {
            iArr[0] = iU;
            iArr[1] = iNr;
        }
    }

    public boolean u(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        b();
        if (this.mv != null) {
            u(i, i2, this.pb);
            int[] iArr = this.pb;
            int i7 = iArr[0];
            int i8 = iArr[1];
            i4 = i8;
            i5 = i7;
            i6 = i - i7;
            i3 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.my.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (u(i5, i4, i6, i3, this.zq, 0)) {
            int i10 = this.ob;
            int[] iArr2 = this.zq;
            int i11 = iArr2[0];
            this.ob = i10 - i11;
            int i12 = this.ju;
            int i13 = iArr2[1];
            this.ju = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr3 = this.ki;
            int i14 = iArr3[0];
            int[] iArr4 = this.zq;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.u.fx.x.u(motionEvent, 8194)) {
                u(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            fx(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            n(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    public void u(boolean z) {
        if (this.su <= 0) {
            this.su = 1;
        }
        if (!z && !this.dw) {
            this.bq = false;
        }
        if (this.su == 1) {
            if (z && this.bq && !this.dw && this.s != null && this.mv != null) {
                my();
            }
            if (!this.dw) {
                this.bq = false;
            }
        }
        this.su--;
    }

    public void u(int i, int i2) {
        u(i, i2, (Interpolator) null);
    }

    public void u(int i, int i2, Interpolator interpolator) {
        a aVar = this.s;
        if (aVar == null) {
            com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.dw) {
            return;
        }
        if (!aVar.fx()) {
            i = 0;
        }
        if (!this.s.b()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.z.u(i, i2, interpolator);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < 0.0f) {
            x();
            com.bytedance.sdk.component.widget.recycler.u.fx.u.u(this.gc, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        } else {
            if (f2 <= 0.0f) {
                z = false;
                if (f4 >= 0.0f) {
                    a();
                    com.bytedance.sdk.component.widget.recycler.u.fx.u.u(this.mk, (-f4) / getHeight(), f / getWidth());
                } else if (f4 > 0.0f) {
                    jk();
                    com.bytedance.sdk.component.widget.recycler.u.fx.u.u(this.kw, f4 / getHeight(), 1.0f - (f / getWidth()));
                } else {
                    z2 = z;
                }
                if (z2 && f2 == 0.0f && f4 == 0.0f) {
                    return;
                }
                com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
            }
            n();
            com.bytedance.sdk.component.widget.recycler.u.fx.u.u(this.p, f2 / getWidth(), f3 / getHeight());
        }
        z = true;
        if (f4 >= 0.0f) {
        }
        if (z2) {
        }
        com.bytedance.sdk.component.widget.recycler.u.fx.x.fx(this);
    }

    public static <T> T u(T t2) {
        t2.getClass();
        return t2;
    }

    private boolean u(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || fx(view2) == null) {
            return false;
        }
        if (view == null || fx(view) == null) {
            return true;
        }
        this.t.set(0, 0, view.getWidth(), view.getHeight());
        this.cj.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.t);
        offsetDescendantRectToMyCoords(view2, this.cj);
        byte b2 = -1;
        int i3 = this.s.o() == 1 ? -1 : 1;
        Rect rect = this.t;
        int i4 = rect.left;
        Rect rect2 = this.cj;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            b2 = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                b2 = 0;
            }
        }
        if (i == 1) {
            return b2 < 0 || (b2 == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return b2 > 0 || (b2 == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b2 < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + u());
    }

    private void u(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.t.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof jk) {
            jk jkVar = (jk) layoutParams;
            if (!jkVar.fx) {
                Rect rect = jkVar.nr;
                Rect rect2 = this.t;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.t);
            offsetRectIntoDescendantCoords(view, this.t);
        }
        this.s.u(this, view, this.t, !this.bg, view2 == null);
    }

    public void u(String str) {
        if (s()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + u());
            }
            throw new IllegalStateException(str);
        }
        if (this.lf > 0) {
            new IllegalStateException(u());
        }
    }

    private boolean u(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.wi = null;
        }
        int size = this.tk.size();
        for (int i = 0; i < size; i++) {
            mv mvVar = this.tk.get(i);
            if (mvVar.u(this, motionEvent) && action != 3) {
                this.wi = mvVar;
                return true;
            }
        }
        return false;
    }

    public final void u(bq bqVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.z.u;
            bqVar.k = overScroller.getFinalX() - overScroller.getCurrX();
            bqVar.my = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            bqVar.k = 0;
            bqVar.my = 0;
        }
    }

    private void u(long j, q qVar, q qVar2) {
        int iNr = this.x.nr();
        for (int i = 0; i < iNr; i++) {
            q qVarPn = pn(this.x.nr(i));
            if (qVarPn != qVar && u(qVarPn) == j) {
                u uVar = this.mv;
                if (uVar != null && uVar.nr()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + qVarPn + " \n View Holder 2:" + qVar + u());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + qVarPn + " \n View Holder 2:" + qVar + u());
            }
        }
        com.bytedance.sdk.component.utils.k.nr("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + qVar2 + " cannot be found but it is necessary for " + qVar + u());
    }

    public void u(q qVar, iz.nr nrVar) {
        qVar.u(0, 8192);
        if (this.h.n && qVar.z() && !qVar.o() && !qVar.N_()) {
            this.n.u(u(qVar), qVar);
        }
        this.n.u(qVar, nrVar);
    }

    private void u(int[] iArr) {
        int iNr = this.x.nr();
        if (iNr == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iNr; i3++) {
            q qVarPn = pn(this.x.nr(i3));
            if (!qVarPn.N_()) {
                int iB = qVarPn.b();
                if (iB < i) {
                    i = iB;
                }
                if (iB > i2) {
                    i2 = iB;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public long u(q qVar) {
        return this.mv.nr() ? qVar.x() : qVar.fx;
    }

    public void u(q qVar, iz.nr nrVar, iz.nr nrVar2) {
        qVar.u(false);
        if (this.kj.nr(qVar, nrVar, nrVar2)) {
            k();
        }
    }

    private void u(q qVar, q qVar2, iz.nr nrVar, iz.nr nrVar2, boolean z, boolean z2) {
        qVar.u(false);
        if (z) {
            pn(qVar);
        }
        if (qVar != qVar2) {
            if (z2) {
                pn(qVar2);
            }
            qVar.n = qVar2;
            pn(qVar);
            this.pn.fx(qVar);
            qVar2.u(false);
            qVar2.f5181a = qVar;
        }
        if (this.kj.u(qVar, qVar2, nrVar, nrVar2)) {
            k();
        }
    }

    public void u(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iFx = this.x.fx();
        for (int i4 = 0; i4 < iFx; i4++) {
            q qVarPn = pn(this.x.b(i4));
            if (qVarPn != null && !qVarPn.N_()) {
                int i5 = qVarPn.fx;
                if (i5 >= i3) {
                    qVarPn.u(-i2, z);
                    this.h.iz = true;
                } else if (i5 >= i) {
                    qVarPn.u(i - 1, -i2, z);
                    this.h.iz = true;
                }
            }
        }
        this.pn.u(i, i2, z);
        requestLayout();
    }

    public void u(int i, int i2, Object obj) {
        int i3;
        int iFx = this.x.fx();
        int i4 = i + i2;
        for (int i5 = 0; i5 < iFx; i5++) {
            View viewB = this.x.b(i5);
            q qVarPn = pn(viewB);
            if (qVarPn != null && !qVarPn.N_() && (i3 = qVarPn.fx) >= i && i3 < i4) {
                qVarPn.nr(2);
                qVarPn.u(obj);
                ((jk) viewB.getLayoutParams()).fx = true;
            }
        }
        this.pn.fx(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q u(int i, boolean z) {
        int iFx = this.x.fx();
        q qVar = null;
        for (int i2 = 0; i2 < iFx; i2++) {
            q qVarPn = pn(this.x.b(i2));
            if (qVarPn != null && !qVarPn.o()) {
                if (z) {
                    if (qVarPn.fx != i) {
                        continue;
                    } else {
                        if (!this.x.fx(qVarPn.u)) {
                            return qVarPn;
                        }
                        qVar = qVarPn;
                    }
                } else if (qVarPn.b() != i) {
                    continue;
                }
            }
        }
        return qVar;
    }

    public q u(long j) {
        u uVar = this.mv;
        q qVar = null;
        if (uVar != null && uVar.nr()) {
            int iFx = this.x.fx();
            for (int i = 0; i < iFx; i++) {
                q qVarPn = pn(this.x.b(i));
                if (qVarPn != null && !qVarPn.o() && qVarPn.x() == j) {
                    if (!this.x.fx(qVarPn.u)) {
                        return qVarPn;
                    }
                    qVar = qVarPn;
                }
            }
        }
        return qVar;
    }

    public static void u(View view, Rect rect) {
        jk jkVar = (jk) view.getLayoutParams();
        Rect rect2 = jkVar.nr;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) jkVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) jkVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) jkVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) jkVar).bottomMargin);
    }

    public boolean u(q qVar, int i) {
        if (s()) {
            qVar.k = i;
            this.xg.add(qVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.u.fx.x.u(qVar.u, i);
        return true;
    }

    public boolean u(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().u(i, i2, i3, i4, iArr, i5);
    }

    public boolean u(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().u(i, i2, iArr, iArr2, i3);
    }
}
