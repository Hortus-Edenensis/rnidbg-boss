package com.yuyakaido.android.cardstackview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.internal.CardStackSmoothScroller;
import com.yuyakaido.android.cardstackview.internal.CardStackState;
import com.zenmen.palmchat.R;
import defpackage.me1;
import defpackage.pz;
import defpackage.qz;
import defpackage.tp5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class CardStackLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final Context n;
    public pz o;
    public qz p;
    public CardStackState q;
    public Handler r;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Direction f11798a;

        public a(Direction direction) {
            this.f11798a = direction;
        }

        @Override // java.lang.Runnable
        public void run() {
            CardStackLayoutManager.this.o.e(this.f11798a);
            View viewG = CardStackLayoutManager.this.g();
            if (viewG != null) {
                CardStackLayoutManager.this.o.f(viewG, CardStackLayoutManager.this.q.f);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11799a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Direction.values().length];
            c = iArr;
            try {
                iArr[Direction.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Direction.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[Direction.Top.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[Direction.Bottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[StackFrom.values().length];
            b = iArr2;
            try {
                iArr2[StackFrom.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[StackFrom.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[StackFrom.TopAndLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[StackFrom.TopAndRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[StackFrom.Bottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[StackFrom.BottomAndLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[StackFrom.BottomAndRight.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[StackFrom.Left.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[StackFrom.Right.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr3 = new int[CardStackState.Status.values().length];
            f11799a = iArr3;
            try {
                iArr3[CardStackState.Status.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f11799a[CardStackState.Status.Dragging.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f11799a[CardStackState.Status.ManualSwipeAnimating.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f11799a[CardStackState.Status.RewindAnimating.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f11799a[CardStackState.Status.AutomaticSwipeAnimating.ordinal()] = 5;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f11799a[CardStackState.Status.AutomaticSwipeAnimated.ordinal()] = 6;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f11799a[CardStackState.Status.ManualSwipeAnimated.ordinal()] = 7;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public CardStackLayoutManager(Context context) {
        this(context, pz.f20140a);
    }

    @NonNull
    public pz c() {
        return this.o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        int itemCount = getItemCount();
        qz qzVar = this.p;
        return itemCount > qzVar.c && qzVar.l.canSwipe() && this.p.j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        int itemCount = getItemCount();
        qz qzVar = this.p;
        return itemCount > qzVar.c && qzVar.l.canSwipe() && this.p.k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        return null;
    }

    @NonNull
    public qz d() {
        return this.p;
    }

    @NonNull
    public CardStackState e() {
        return this.q;
    }

    public int f() {
        return this.q.f;
    }

    public View g() {
        return findViewByPosition(this.q.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -1);
    }

    public final void h(View view) {
        View viewFindViewById = view.findViewById(R.id.left_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(0.0f);
        }
        View viewFindViewById2 = view.findViewById(R.id.right_overlay);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setAlpha(0.0f);
        }
        View viewFindViewById3 = view.findViewById(R.id.top_overlay);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setAlpha(0.0f);
        }
        View viewFindViewById4 = view.findViewById(R.id.bottom_overlay);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setAlpha(0.0f);
        }
    }

    public final void i(View view) {
        view.setRotation(0.0f);
    }

    public final void j(View view) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public final void k(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void l(@NonNull tp5 tp5Var) {
        this.p.m = tp5Var;
    }

    public void m(int i) {
        if (i < 0) {
            i = 0;
        }
        this.q.f = i;
    }

    public final void n(int i) {
        CardStackState cardStackState = this.q;
        cardStackState.h = 0.0f;
        cardStackState.g = i;
        CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.AutomaticSwipe, this);
        cardStackSmoothScroller.setTargetPosition(this.q.f);
        startSmoothScroll(cardStackSmoothScroller);
    }

    public final void o(int i) {
        if (this.q.f < i) {
            n(i);
        } else {
            p(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        View viewG;
        q(recycler);
        if (!state.didStructureChange() || (viewG = g()) == null) {
            return;
        }
        this.o.f(viewG, this.q.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i != 0) {
            if (i == 1 && this.p.l.canSwipeManually()) {
                this.q.f(CardStackState.Status.Dragging);
                return;
            }
            return;
        }
        CardStackState cardStackState = this.q;
        int i2 = cardStackState.g;
        if (i2 == -1) {
            cardStackState.f(CardStackState.Status.Idle);
            this.q.g = -1;
            return;
        }
        int i3 = cardStackState.f;
        if (i3 == i2) {
            cardStackState.f(CardStackState.Status.Idle);
            this.q.g = -1;
        } else if (i3 < i2) {
            n(i2);
        } else {
            p(i2);
        }
    }

    public final void p(int i) {
        if (g() != null) {
            this.o.d(g(), this.q.f);
        }
        CardStackState cardStackState = this.q;
        cardStackState.h = 0.0f;
        cardStackState.g = i;
        m(cardStackState.f - 1);
        CardStackSmoothScroller cardStackSmoothScroller = new CardStackSmoothScroller(CardStackSmoothScroller.ScrollType.AutomaticRewind, this);
        cardStackSmoothScroller.setTargetPosition(this.q.f);
        startSmoothScroll(cardStackSmoothScroller);
    }

    public final void q(RecyclerView.Recycler recycler) {
        this.q.b = getWidth();
        this.q.c = getHeight();
        if (this.q.e()) {
            if (g() != null) {
                removeAndRecycleView(g(), recycler);
            }
            Direction directionB = this.q.b();
            CardStackState cardStackState = this.q;
            cardStackState.f(cardStackState.f11803a.toAnimatedStatus());
            m(this.q.f + 1);
            CardStackState cardStackState2 = this.q;
            cardStackState2.d = 0;
            cardStackState2.e = 0;
            if (cardStackState2.f == cardStackState2.g) {
                cardStackState2.g = -1;
            }
            this.r.post(new a(directionB));
        }
        detachAndScrapAttachedViews(recycler);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingLeft();
        int height = getHeight() - getPaddingBottom();
        for (int i = this.q.f; i < this.q.f + this.p.b && i < getItemCount(); i++) {
            View viewForPosition = recycler.getViewForPosition(i);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            layoutDecoratedWithMargins(viewForPosition, paddingLeft, paddingTop, width, height);
            k(viewForPosition);
            j(viewForPosition);
            i(viewForPosition);
            h(viewForPosition);
            int i2 = this.q.f;
            if (i == i2) {
                v(viewForPosition);
                j(viewForPosition);
                t(viewForPosition);
                r(viewForPosition);
            } else {
                int i3 = i - i2;
                int i4 = i3 - 1;
                if (i3 == this.p.b - 1) {
                    i3 = i4;
                }
                w(viewForPosition, i3, i4);
                u(viewForPosition, i3, i4);
                i(viewForPosition);
                h(viewForPosition);
            }
        }
        if (this.q.f11803a.isDragging()) {
            this.o.a(this.q.b(), this.q.c());
        }
    }

    public final void r(View view) {
        View viewFindViewById = view.findViewById(R.id.left_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setAlpha(0.0f);
        }
        View viewFindViewById2 = view.findViewById(R.id.right_overlay);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setAlpha(0.0f);
        }
        View viewFindViewById3 = view.findViewById(R.id.top_overlay);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setAlpha(0.0f);
        }
        View viewFindViewById4 = view.findViewById(R.id.bottom_overlay);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setAlpha(0.0f);
        }
        Direction directionB = this.q.b();
        float interpolation = this.p.o.getInterpolation(this.q.c()) * 2.0f;
        if (this.q.d()) {
            interpolation = 1.0f;
        }
        int i = b.c[directionB.ordinal()];
        if (i == 1) {
            if (viewFindViewById != null) {
                viewFindViewById.setAlpha(interpolation);
            }
        } else if (i == 2) {
            if (viewFindViewById2 != null) {
                viewFindViewById2.setAlpha(interpolation);
            }
        } else if (i == 3) {
            if (viewFindViewById3 != null) {
                viewFindViewById3.setAlpha(interpolation);
            }
        } else if (i == 4 && viewFindViewById4 != null) {
            viewFindViewById4.setAlpha(interpolation);
        }
    }

    public void s(float f, float f2) {
        View viewFindViewByPosition;
        if (f() >= getItemCount() || (viewFindViewByPosition = findViewByPosition(f())) == null) {
            return;
        }
        float height = getHeight() / 2.0f;
        this.q.h = (-((f2 - height) - viewFindViewByPosition.getTop())) / height;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.q.f >= getItemCount() - this.p.c) {
            return 0;
        }
        int i2 = b.f11799a[this.q.f11803a.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (this.p.l.canSwipeManually()) {
                this.q.d -= i;
                q(recycler);
                return i;
            }
        } else {
            if (i2 == 4) {
                this.q.d -= i;
                q(recycler);
                return i;
            }
            if (i2 == 5 && this.p.l.canSwipeAutomatically()) {
                this.q.d -= i;
                q(recycler);
                return i;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (this.p.l.canSwipeAutomatically() && this.q.a(i, getItemCount())) {
            m(i);
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.q.f >= getItemCount() - this.p.c) {
            return 0;
        }
        int i2 = b.f11799a[this.q.f11803a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        this.q.e -= i;
                        q(recycler);
                        return i;
                    }
                    if (i2 == 5 && this.p.l.canSwipeAutomatically()) {
                        this.q.e -= i;
                        q(recycler);
                        return i;
                    }
                } else if (this.p.l.canSwipeManually()) {
                    this.q.e -= i;
                    q(recycler);
                    return i;
                }
            } else if (this.p.l.canSwipeManually()) {
                this.q.e -= i;
                q(recycler);
                return i;
            }
        } else if (this.p.l.canSwipeManually()) {
            this.q.e -= i;
            q(recycler);
            return i;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        if (this.p.l.canSwipeAutomatically() && this.q.a(i, getItemCount())) {
            o(i);
        }
    }

    public final void t(View view) {
        float f = this.q.h >= 0.0f ? 0.3f : -0.3f;
        view.setRotation(((r0.d * this.p.g) / getWidth()) * (f + ((1.0f - Math.abs(f)) * this.q.h)));
    }

    public final void u(View view, int i, int i2) {
        float f = this.p.e;
        float f2 = 1.0f - (i * (1.0f - f));
        float fC = f2 + (((1.0f - (i2 * (1.0f - f))) - f2) * this.q.c());
        if (Float.isNaN(fC)) {
            return;
        }
        try {
            switch (b.b[this.p.f20356a.ordinal()]) {
                case 1:
                    view.setScaleX(fC);
                    view.setScaleY(fC);
                    break;
                case 2:
                    view.setScaleX(fC);
                    break;
                case 3:
                    view.setScaleX(fC);
                    break;
                case 4:
                    view.setScaleX(fC);
                    break;
                case 5:
                    view.setScaleX(fC);
                    break;
                case 6:
                    view.setScaleX(fC);
                    break;
                case 7:
                    view.setScaleX(fC);
                    break;
                case 8:
                    view.setScaleY(fC);
                    break;
                case 9:
                    view.setScaleY(fC);
                    break;
            }
        } catch (Exception unused) {
        }
    }

    public final void v(View view) {
        view.setTranslationX(this.q.d);
        view.setTranslationY(this.q.e);
    }

    public final void w(View view, int i, int i2) {
        float fA = i * me1.a(this.n, this.p.d);
        float fC = fA - ((fA - (i2 * r0)) * this.q.c());
        switch (b.b[this.p.f20356a.ordinal()]) {
            case 2:
                view.setTranslationY(-fC);
                break;
            case 3:
                float f = -fC;
                view.setTranslationY(f);
                view.setTranslationX(f);
                break;
            case 4:
                view.setTranslationY(-fC);
                view.setTranslationX(fC);
                break;
            case 5:
                view.setTranslationY(fC);
                break;
            case 6:
                view.setTranslationY(fC);
                view.setTranslationX(-fC);
                break;
            case 7:
                view.setTranslationY(fC);
                view.setTranslationX(fC);
                break;
            case 8:
                view.setTranslationX(-fC);
                break;
            case 9:
                view.setTranslationX(fC);
                break;
        }
    }

    public CardStackLayoutManager(Context context, pz pzVar) {
        this.o = pz.f20140a;
        this.p = new qz();
        this.q = new CardStackState();
        this.r = new Handler(Looper.getMainLooper());
        this.n = context;
        this.o = pzVar;
    }
}
