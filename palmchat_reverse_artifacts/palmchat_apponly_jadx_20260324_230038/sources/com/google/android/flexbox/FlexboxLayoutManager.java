package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.b;
import defpackage.rx1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements rx1, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final Rect O = new Rect();
    public OrientationHelper A;
    public OrientationHelper B;
    public SavedState C;
    public int E;
    public int F;
    public int G;
    public int H;
    public boolean I;
    public SparseArray<View> J;
    public final Context K;
    public View L;
    public int M;
    public b.C0366b N;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public List<com.google.android.flexbox.a> u;
    public final com.google.android.flexbox.b v;
    public RecyclerView.Recycler w;
    public RecyclerView.State x;
    public c y;
    public b z;

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6048a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;
        public boolean g;

        public b() {
            this.d = 0;
        }

        public final void q() {
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.s) {
                this.c = this.e ? FlexboxLayoutManager.this.A.getEndAfterPadding() : FlexboxLayoutManager.this.A.getStartAfterPadding();
            } else {
                this.c = this.e ? FlexboxLayoutManager.this.A.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.A.getStartAfterPadding();
            }
        }

        public final void r(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.o == 0 ? FlexboxLayoutManager.this.B : FlexboxLayoutManager.this.A;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.s) {
                if (this.e) {
                    this.c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.c = orientationHelper.getDecoratedStart(view);
                }
            } else if (this.e) {
                this.c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.c = orientationHelper.getDecoratedEnd(view);
            }
            this.f6048a = FlexboxLayoutManager.this.getPosition(view);
            this.g = false;
            int[] iArr = FlexboxLayoutManager.this.v.c;
            int i = this.f6048a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.u.size() > this.b) {
                this.f6048a = ((com.google.android.flexbox.a) FlexboxLayoutManager.this.u.get(this.b)).o;
            }
        }

        public final void s() {
            this.f6048a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f = false;
            this.g = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.o == 0) {
                    this.e = FlexboxLayoutManager.this.n == 1;
                    return;
                } else {
                    this.e = FlexboxLayoutManager.this.o == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.o == 0) {
                this.e = FlexboxLayoutManager.this.n == 3;
            } else {
                this.e = FlexboxLayoutManager.this.o == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f6048a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.e + ", mValid=" + this.f + ", mAssignedFromSavedState=" + this.g + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6049a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean j;

        public c() {
            this.h = 1;
            this.i = 1;
        }

        public static /* synthetic */ int i(c cVar) {
            int i = cVar.c;
            cVar.c = i + 1;
            return i;
        }

        public static /* synthetic */ int j(c cVar) {
            int i = cVar.c;
            cVar.c = i - 1;
            return i;
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f6049a + ", mFlexLinePosition=" + this.c + ", mPosition=" + this.d + ", mOffset=" + this.e + ", mScrollingOffset=" + this.f + ", mLastScrollDelta=" + this.g + ", mItemDirection=" + this.h + ", mLayoutDirection=" + this.i + '}';
        }

        public final boolean w(RecyclerView.State state, List<com.google.android.flexbox.a> list) {
            int i;
            int i2 = this.d;
            return i2 >= 0 && i2 < state.getItemCount() && (i = this.c) >= 0 && i < list.size();
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
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

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    public boolean A() {
        return this.s;
    }

    public final boolean B(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int iT = t(view);
        int iV = v(view);
        int iU = u(view);
        int iS = s(view);
        return z ? (paddingLeft <= iT && width >= iU) && (paddingTop <= iV && height >= iS) : (iT >= width || iU >= paddingLeft) && (iV >= height || iS >= paddingTop);
    }

    public final int C(com.google.android.flexbox.a aVar, c cVar) {
        return isMainAxisDirectionHorizontal() ? D(aVar, cVar) : E(aVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int D(com.google.android.flexbox.a aVar, c cVar) {
        float f;
        float f2;
        float f3;
        int iB;
        int i;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int width = getWidth();
        int i2 = cVar.e;
        if (cVar.i == -1) {
            i2 -= aVar.g;
        }
        int i3 = i2;
        int i4 = cVar.d;
        int i5 = this.p;
        int i6 = 1;
        if (i5 != 0) {
            if (i5 == 1) {
                int i7 = aVar.e;
                float f4 = (width - i7) + paddingRight;
                f3 = 0.0f;
                f2 = i7 - paddingLeft;
                f = f4;
            } else if (i5 == 2) {
                int i8 = aVar.e;
                f = paddingLeft + ((width - i8) / 2.0f);
                f2 = (width - paddingRight) - ((width - i8) / 2.0f);
            } else if (i5 == 3) {
                f = paddingLeft;
                f3 = (width - aVar.e) / (aVar.h != 1 ? r4 - 1 : 1.0f);
                f2 = width - paddingRight;
            } else if (i5 == 4) {
                int i9 = aVar.h;
                f3 = i9 != 0 ? (width - aVar.e) / i9 : 0.0f;
                float f5 = f3 / 2.0f;
                f = paddingLeft + f5;
                f2 = (width - paddingRight) - f5;
            } else {
                if (i5 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.p);
                }
                f3 = aVar.h != 0 ? (width - aVar.e) / (r4 + 1) : 0.0f;
                f = paddingLeft + f3;
                f2 = (width - paddingRight) - f3;
            }
            float measuredWidth = f - this.z.d;
            float measuredWidth2 = f2 - this.z.d;
            float fMax = Math.max(f3, 0.0f);
            iB = aVar.b();
            int i10 = 0;
            i = i4;
            while (i < i4 + iB) {
                View flexItemAt = getFlexItemAt(i);
                if (flexItemAt != null) {
                    if (cVar.i == i6) {
                        calculateItemDecorationsForChild(flexItemAt, O);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, O);
                        addView(flexItemAt, i10);
                        i10++;
                    }
                    int i11 = i10;
                    com.google.android.flexbox.b bVar = this.v;
                    long j = bVar.d[i];
                    int iY = bVar.y(j);
                    int iX = this.v.x(j);
                    LayoutParams layoutParams2 = (LayoutParams) flexItemAt.getLayoutParams();
                    if (shouldMeasureChild(flexItemAt, iY, iX, layoutParams2)) {
                        flexItemAt.measure(iY, iX);
                    }
                    float leftDecorationWidth = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + getLeftDecorationWidth(flexItemAt);
                    float rightDecorationWidth = measuredWidth2 - (((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getRightDecorationWidth(flexItemAt));
                    int topDecorationHeight = i3 + getTopDecorationHeight(flexItemAt);
                    if (this.s) {
                        layoutParams = layoutParams2;
                        this.v.Q(flexItemAt, aVar, Math.round(rightDecorationWidth) - flexItemAt.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    } else {
                        layoutParams = layoutParams2;
                        this.v.Q(flexItemAt, aVar, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + flexItemAt.getMeasuredWidth(), topDecorationHeight + flexItemAt.getMeasuredHeight());
                    }
                    i10 = i11;
                    measuredWidth = leftDecorationWidth + flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getRightDecorationWidth(flexItemAt) + fMax;
                    measuredWidth2 = rightDecorationWidth - (((flexItemAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + getLeftDecorationWidth(flexItemAt)) + fMax);
                }
                i++;
                i6 = 1;
            }
            cVar.c += this.y.i;
            return aVar.a();
        }
        f = paddingLeft;
        f2 = width - paddingRight;
        f3 = 0.0f;
        float measuredWidth3 = f - this.z.d;
        float measuredWidth22 = f2 - this.z.d;
        float fMax2 = Math.max(f3, 0.0f);
        iB = aVar.b();
        int i102 = 0;
        i = i4;
        while (i < i4 + iB) {
        }
        cVar.c += this.y.i;
        return aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int E(com.google.android.flexbox.a aVar, c cVar) {
        float f;
        float f2;
        float f3;
        int iB;
        int i;
        float f4;
        View view;
        int i2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i3 = cVar.e;
        int i4 = cVar.e;
        if (cVar.i == -1) {
            int i5 = aVar.g;
            i3 -= i5;
            i4 += i5;
        }
        int i6 = i3;
        int i7 = i4;
        int i8 = cVar.d;
        int i9 = this.p;
        if (i9 != 0) {
            if (i9 == 1) {
                int i10 = aVar.e;
                float f5 = (height - i10) + paddingBottom;
                f3 = 0.0f;
                f2 = i10 - paddingTop;
                f = f5;
            } else if (i9 == 2) {
                int i11 = aVar.e;
                f = paddingTop + ((height - i11) / 2.0f);
                f2 = (height - paddingBottom) - ((height - i11) / 2.0f);
            } else if (i9 == 3) {
                f = paddingTop;
                f3 = (height - aVar.e) / (aVar.h != 1 ? r4 - 1 : 1.0f);
                f2 = height - paddingBottom;
            } else if (i9 == 4) {
                int i12 = aVar.h;
                f3 = i12 != 0 ? (height - aVar.e) / i12 : 0.0f;
                float f6 = f3 / 2.0f;
                f = paddingTop + f6;
                f2 = (height - paddingBottom) - f6;
            } else {
                if (i9 != 5) {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.p);
                }
                f3 = aVar.h != 0 ? (height - aVar.e) / (r4 + 1) : 0.0f;
                f = paddingTop + f3;
                f2 = (height - paddingBottom) - f3;
            }
            float measuredHeight = f - this.z.d;
            float measuredHeight2 = f2 - this.z.d;
            float fMax = Math.max(f3, 0.0f);
            iB = aVar.b();
            int i13 = 0;
            i = i8;
            while (i < i8 + iB) {
                View flexItemAt = getFlexItemAt(i);
                if (flexItemAt == null) {
                    i2 = i;
                    f4 = fMax;
                } else {
                    com.google.android.flexbox.b bVar = this.v;
                    f4 = fMax;
                    long j = bVar.d[i];
                    int iY = bVar.y(j);
                    int iX = this.v.x(j);
                    if (shouldMeasureChild(flexItemAt, iY, iX, (LayoutParams) flexItemAt.getLayoutParams())) {
                        flexItemAt.measure(iY, iX);
                    }
                    float topDecorationHeight = measuredHeight + ((ViewGroup.MarginLayoutParams) r13).topMargin + getTopDecorationHeight(flexItemAt);
                    float bottomDecorationHeight = measuredHeight2 - (((ViewGroup.MarginLayoutParams) r13).rightMargin + getBottomDecorationHeight(flexItemAt));
                    if (cVar.i == 1) {
                        calculateItemDecorationsForChild(flexItemAt, O);
                        addView(flexItemAt);
                    } else {
                        calculateItemDecorationsForChild(flexItemAt, O);
                        addView(flexItemAt, i13);
                        i13++;
                    }
                    int i14 = i13;
                    int leftDecorationWidth = i6 + getLeftDecorationWidth(flexItemAt);
                    int rightDecorationWidth = i7 - getRightDecorationWidth(flexItemAt);
                    boolean z = this.s;
                    if (!z) {
                        view = flexItemAt;
                        i2 = i;
                        if (this.t) {
                            this.v.R(view, aVar, z, leftDecorationWidth, Math.round(bottomDecorationHeight) - view.getMeasuredHeight(), leftDecorationWidth + view.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                        } else {
                            this.v.R(view, aVar, z, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + view.getMeasuredWidth(), Math.round(topDecorationHeight) + view.getMeasuredHeight());
                        }
                    } else if (this.t) {
                        view = flexItemAt;
                        i2 = i;
                        this.v.R(flexItemAt, aVar, z, rightDecorationWidth - flexItemAt.getMeasuredWidth(), Math.round(bottomDecorationHeight) - flexItemAt.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                    } else {
                        view = flexItemAt;
                        i2 = i;
                        this.v.R(view, aVar, z, rightDecorationWidth - view.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, Math.round(topDecorationHeight) + view.getMeasuredHeight());
                    }
                    View view2 = view;
                    measuredHeight = topDecorationHeight + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r13).topMargin + getBottomDecorationHeight(view2) + f4;
                    i13 = i14;
                    measuredHeight2 = bottomDecorationHeight - (((view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + getTopDecorationHeight(view2)) + f4);
                }
                i = i2 + 1;
                fMax = f4;
            }
            cVar.c += this.y.i;
            return aVar.a();
        }
        f = paddingTop;
        f2 = height - paddingBottom;
        f3 = 0.0f;
        float measuredHeight3 = f - this.z.d;
        float measuredHeight22 = f2 - this.z.d;
        float fMax2 = Math.max(f3, 0.0f);
        iB = aVar.b();
        int i132 = 0;
        i = i8;
        while (i < i8 + iB) {
        }
        cVar.c += this.y.i;
        return aVar.a();
    }

    public final void F(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.j) {
            if (cVar.i == -1) {
                G(recycler, cVar);
            } else {
                H(recycler, cVar);
            }
        }
    }

    public final void G(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f < 0) {
            return;
        }
        this.A.getEnd();
        int unused = cVar.f;
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i = childCount - 1;
        int i2 = this.v.c[getPosition(getChildAt(i))];
        if (i2 == -1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.u.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!h(childAt, cVar.f)) {
                break;
            }
            if (aVar.o == getPosition(childAt)) {
                if (i2 <= 0) {
                    childCount = i3;
                    break;
                } else {
                    i2 += cVar.i;
                    aVar = this.u.get(i2);
                    childCount = i3;
                }
            }
            i3--;
        }
        recycleChildren(recycler, childCount, i);
    }

    public final void H(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.f >= 0 && (childCount = getChildCount()) != 0) {
            int i = this.v.c[getPosition(getChildAt(0))];
            int i2 = -1;
            if (i == -1) {
                return;
            }
            com.google.android.flexbox.a aVar = this.u.get(i);
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                if (!i(childAt, cVar.f)) {
                    break;
                }
                if (aVar.p == getPosition(childAt)) {
                    if (i >= this.u.size() - 1) {
                        i2 = i3;
                        break;
                    } else {
                        i += cVar.i;
                        aVar = this.u.get(i);
                        i2 = i3;
                    }
                }
                i3++;
            }
            recycleChildren(recycler, 0, i2);
        }
    }

    public final void I() {
        int heightMode = isMainAxisDirectionHorizontal() ? getHeightMode() : getWidthMode();
        this.y.b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    public final void J() {
        int layoutDirection = getLayoutDirection();
        int i = this.n;
        if (i == 0) {
            this.s = layoutDirection == 1;
            this.t = this.o == 2;
            return;
        }
        if (i == 1) {
            this.s = layoutDirection != 1;
            this.t = this.o == 2;
            return;
        }
        if (i == 2) {
            boolean z = layoutDirection == 1;
            this.s = z;
            if (this.o == 2) {
                this.s = !z;
            }
            this.t = false;
            return;
        }
        if (i != 3) {
            this.s = false;
            this.t = false;
            return;
        }
        boolean z2 = layoutDirection == 1;
        this.s = z2;
        if (this.o == 2) {
            this.s = !z2;
        }
        this.t = true;
    }

    public void K(int i) {
        int i2 = this.q;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                removeAllViews();
                j();
            }
            this.q = i;
            requestLayout();
        }
    }

    public void L(int i) {
        if (this.n != i) {
            removeAllViews();
            this.n = i;
            this.A = null;
            this.B = null;
            j();
            requestLayout();
        }
    }

    public void M(int i) {
        if (i == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i2 = this.o;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                removeAllViews();
                j();
            }
            this.o = i;
            this.A = null;
            this.B = null;
            requestLayout();
        }
    }

    public void N(int i) {
        if (this.p != i) {
            this.p = i;
            requestLayout();
        }
    }

    public final boolean O(RecyclerView.State state, b bVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View viewO = bVar.e ? o(state.getItemCount()) : m(state.getItemCount());
        if (viewO == null) {
            return false;
        }
        bVar.r(viewO);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.A.getDecoratedStart(viewO) >= this.A.getEndAfterPadding() || this.A.getDecoratedEnd(viewO) < this.A.getStartAfterPadding()) {
                bVar.c = bVar.e ? this.A.getEndAfterPadding() : this.A.getStartAfterPadding();
            }
        }
        return true;
    }

    public final boolean P(RecyclerView.State state, b bVar, SavedState savedState) {
        int i;
        if (!state.isPreLayout() && (i = this.E) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                bVar.f6048a = this.E;
                bVar.b = this.v.c[bVar.f6048a];
                SavedState savedState2 = this.C;
                if (savedState2 != null && savedState2.g(state.getItemCount())) {
                    bVar.c = this.A.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.g = true;
                    bVar.b = -1;
                    return true;
                }
                if (this.F != Integer.MIN_VALUE) {
                    if (isMainAxisDirectionHorizontal() || !this.s) {
                        bVar.c = this.A.getStartAfterPadding() + this.F;
                    } else {
                        bVar.c = this.F - this.A.getEndPadding();
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.E);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        bVar.e = this.E < getPosition(getChildAt(0));
                    }
                    bVar.q();
                } else {
                    if (this.A.getDecoratedMeasurement(viewFindViewByPosition) > this.A.getTotalSpace()) {
                        bVar.q();
                        return true;
                    }
                    if (this.A.getDecoratedStart(viewFindViewByPosition) - this.A.getStartAfterPadding() < 0) {
                        bVar.c = this.A.getStartAfterPadding();
                        bVar.e = false;
                        return true;
                    }
                    if (this.A.getEndAfterPadding() - this.A.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        bVar.c = this.A.getEndAfterPadding();
                        bVar.e = true;
                        return true;
                    }
                    bVar.c = bVar.e ? this.A.getDecoratedEnd(viewFindViewByPosition) + this.A.getTotalSpaceChange() : this.A.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.E = -1;
            this.F = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void Q(RecyclerView.State state, b bVar) {
        if (P(state, bVar, this.C) || O(state, bVar)) {
            return;
        }
        bVar.q();
        bVar.f6048a = 0;
        bVar.b = 0;
    }

    public final void R(int i) {
        if (i >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.v.t(childCount);
        this.v.u(childCount);
        this.v.s(childCount);
        if (i >= this.v.c.length) {
            return;
        }
        this.M = i;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.E = getPosition(childClosestToStart);
        if (isMainAxisDirectionHorizontal() || !this.s) {
            this.F = this.A.getDecoratedStart(childClosestToStart) - this.A.getStartAfterPadding();
        } else {
            this.F = this.A.getDecoratedEnd(childClosestToStart) + this.A.getEndPadding();
        }
    }

    public final void S(int i) {
        boolean z;
        int i2;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (isMainAxisDirectionHorizontal()) {
            int i3 = this.G;
            z = (i3 == Integer.MIN_VALUE || i3 == width) ? false : true;
            i2 = this.y.b ? this.K.getResources().getDisplayMetrics().heightPixels : this.y.f6049a;
        } else {
            int i4 = this.H;
            z = (i4 == Integer.MIN_VALUE || i4 == height) ? false : true;
            i2 = this.y.b ? this.K.getResources().getDisplayMetrics().widthPixels : this.y.f6049a;
        }
        int i5 = i2;
        this.G = width;
        this.H = height;
        int i6 = this.M;
        if (i6 == -1 && (this.E != -1 || z)) {
            if (this.z.e) {
                return;
            }
            this.u.clear();
            this.N.a();
            if (isMainAxisDirectionHorizontal()) {
                this.v.e(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i5, this.z.f6048a, this.u);
            } else {
                this.v.h(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i5, this.z.f6048a, this.u);
            }
            this.u = this.N.f6052a;
            this.v.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.v.X();
            b bVar = this.z;
            bVar.b = this.v.c[bVar.f6048a];
            this.y.c = this.z.b;
            return;
        }
        int iMin = i6 != -1 ? Math.min(i6, this.z.f6048a) : this.z.f6048a;
        this.N.a();
        if (isMainAxisDirectionHorizontal()) {
            if (this.u.size() > 0) {
                this.v.j(this.u, iMin);
                this.v.b(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i5, iMin, this.z.f6048a, this.u);
            } else {
                this.v.s(i);
                this.v.d(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i5, 0, this.u);
            }
        } else if (this.u.size() > 0) {
            this.v.j(this.u, iMin);
            this.v.b(this.N, iMakeMeasureSpec2, iMakeMeasureSpec, i5, iMin, this.z.f6048a, this.u);
        } else {
            this.v.s(i);
            this.v.g(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i5, 0, this.u);
        }
        this.u = this.N.f6052a;
        this.v.q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.v.Y(iMin);
    }

    public final void T(int i, int i2) {
        this.y.i = i;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !zIsMainAxisDirectionHorizontal && this.s;
        if (i == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.y.e = this.A.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewP = p(childAt, this.u.get(this.v.c[position]));
            this.y.h = 1;
            c cVar = this.y;
            cVar.d = position + cVar.h;
            if (this.v.c.length <= this.y.d) {
                this.y.c = -1;
            } else {
                c cVar2 = this.y;
                cVar2.c = this.v.c[cVar2.d];
            }
            if (z) {
                this.y.e = this.A.getDecoratedStart(viewP);
                this.y.f = (-this.A.getDecoratedStart(viewP)) + this.A.getStartAfterPadding();
                c cVar3 = this.y;
                cVar3.f = cVar3.f >= 0 ? this.y.f : 0;
            } else {
                this.y.e = this.A.getDecoratedEnd(viewP);
                this.y.f = this.A.getDecoratedEnd(viewP) - this.A.getEndAfterPadding();
            }
            if ((this.y.c == -1 || this.y.c > this.u.size() - 1) && this.y.d <= getFlexItemCount()) {
                int i3 = i2 - this.y.f;
                this.N.a();
                if (i3 > 0) {
                    if (zIsMainAxisDirectionHorizontal) {
                        this.v.d(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i3, this.y.d, this.u);
                    } else {
                        this.v.g(this.N, iMakeMeasureSpec, iMakeMeasureSpec2, i3, this.y.d, this.u);
                    }
                    this.v.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.y.d);
                    this.v.Y(this.y.d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.y.e = this.A.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewN = n(childAt2, this.u.get(this.v.c[position2]));
            this.y.h = 1;
            int i4 = this.v.c[position2];
            if (i4 == -1) {
                i4 = 0;
            }
            if (i4 > 0) {
                this.y.d = position2 - this.u.get(i4 - 1).b();
            } else {
                this.y.d = -1;
            }
            this.y.c = i4 > 0 ? i4 - 1 : 0;
            if (z) {
                this.y.e = this.A.getDecoratedEnd(viewN);
                this.y.f = this.A.getDecoratedEnd(viewN) - this.A.getEndAfterPadding();
                c cVar4 = this.y;
                cVar4.f = cVar4.f >= 0 ? this.y.f : 0;
            } else {
                this.y.e = this.A.getDecoratedStart(viewN);
                this.y.f = (-this.A.getDecoratedStart(viewN)) + this.A.getStartAfterPadding();
            }
        }
        c cVar5 = this.y;
        cVar5.f6049a = i2 - cVar5.f;
    }

    public final void U(b bVar, boolean z, boolean z2) {
        if (z2) {
            I();
        } else {
            this.y.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.s) {
            this.y.f6049a = this.A.getEndAfterPadding() - bVar.c;
        } else {
            this.y.f6049a = bVar.c - getPaddingRight();
        }
        this.y.d = bVar.f6048a;
        this.y.h = 1;
        this.y.i = 1;
        this.y.e = bVar.c;
        this.y.f = Integer.MIN_VALUE;
        this.y.c = bVar.b;
        if (!z || this.u.size() <= 1 || bVar.b < 0 || bVar.b >= this.u.size() - 1) {
            return;
        }
        com.google.android.flexbox.a aVar = this.u.get(bVar.b);
        c.i(this.y);
        this.y.d += aVar.b();
    }

    public final void V(b bVar, boolean z, boolean z2) {
        if (z2) {
            I();
        } else {
            this.y.b = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.s) {
            this.y.f6049a = bVar.c - this.A.getStartAfterPadding();
        } else {
            this.y.f6049a = (this.L.getWidth() - bVar.c) - this.A.getStartAfterPadding();
        }
        this.y.d = bVar.f6048a;
        this.y.h = 1;
        this.y.i = -1;
        this.y.e = bVar.c;
        this.y.f = Integer.MIN_VALUE;
        this.y.c = bVar.b;
        if (!z || bVar.b <= 0 || this.u.size() <= bVar.b) {
            return;
        }
        com.google.android.flexbox.a aVar = this.u.get(bVar.b);
        c.j(this.y);
        this.y.d -= aVar.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.o == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.L;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.o == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.L;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        k();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        return Math.min(this.A.getTotalSpace(), this.A.getDecoratedEnd(viewO) - this.A.getDecoratedStart(viewM));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() != 0 && viewM != null && viewO != null) {
            int position = getPosition(viewM);
            int position2 = getPosition(viewO);
            int iAbs = Math.abs(this.A.getDecoratedEnd(viewO) - this.A.getDecoratedStart(viewM));
            int i = this.v.c[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((r4[position2] - i) + 1))) + (this.A.getStartAfterPadding() - this.A.getDecoratedStart(viewM)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM = m(itemCount);
        View viewO = o(itemCount);
        if (state.getItemCount() == 0 || viewM == null || viewO == null) {
            return 0;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.A.getDecoratedEnd(viewO) - this.A.getDecoratedStart(viewM)) / ((findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        return isMainAxisDirectionHorizontal() ? new PointF(0.0f, i2) : new PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final void ensureLayoutState() {
        if (this.y == null) {
            this.y = new c();
        }
    }

    public int findFirstVisibleItemPosition() {
        View viewQ = q(0, getChildCount(), false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public int findLastVisibleItemPosition() {
        View viewQ = q(getChildCount() - 1, -1, false);
        if (viewQ == null) {
            return -1;
        }
        return getPosition(viewQ);
    }

    public final int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iY;
        int endAfterPadding;
        if (!isMainAxisDirectionHorizontal() && this.s) {
            int startAfterPadding = i - this.A.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iY = y(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.A.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iY = -y(-endAfterPadding2, recycler, state);
        }
        int i2 = i + iY;
        if (!z || (endAfterPadding = this.A.getEndAfterPadding() - i2) <= 0) {
            return iY;
        }
        this.A.offsetChildren(endAfterPadding);
        return endAfterPadding + iY;
    }

    public final int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int iY;
        int startAfterPadding;
        if (isMainAxisDirectionHorizontal() || !this.s) {
            int startAfterPadding2 = i - this.A.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iY = -y(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.A.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iY = y(-endAfterPadding, recycler, state);
        }
        int i2 = i + iY;
        if (!z || (startAfterPadding = i2 - this.A.getStartAfterPadding()) <= 0) {
            return iY;
        }
        this.A.offsetChildren(-startAfterPadding);
        return iY - startAfterPadding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // defpackage.rx1
    public int getAlignContent() {
        return 5;
    }

    @Override // defpackage.rx1
    public int getAlignItems() {
        return this.q;
    }

    public final View getChildClosestToStart() {
        return getChildAt(0);
    }

    @Override // defpackage.rx1
    public int getChildHeightMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // defpackage.rx1
    public int getChildWidthMeasureSpec(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // defpackage.rx1
    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // defpackage.rx1
    public int getDecorationLengthMainAxis(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // defpackage.rx1
    public int getFlexDirection() {
        return this.n;
    }

    @Override // defpackage.rx1
    public View getFlexItemAt(int i) {
        View view = this.J.get(i);
        return view != null ? view : this.w.getViewForPosition(i);
    }

    @Override // defpackage.rx1
    public int getFlexItemCount() {
        return this.x.getItemCount();
    }

    @Override // defpackage.rx1
    public List<com.google.android.flexbox.a> getFlexLinesInternal() {
        return this.u;
    }

    @Override // defpackage.rx1
    public int getFlexWrap() {
        return this.o;
    }

    @Override // defpackage.rx1
    public int getLargestMainSize() {
        if (this.u.size() == 0) {
            return 0;
        }
        int size = this.u.size();
        int iMax = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.u.get(i).e);
        }
        return iMax;
    }

    @Override // defpackage.rx1
    public int getMaxLine() {
        return this.r;
    }

    @Override // defpackage.rx1
    public View getReorderedFlexItemAt(int i) {
        return getFlexItemAt(i);
    }

    @Override // defpackage.rx1
    public int getSumOfCrossSize() {
        int size = this.u.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.u.get(i2).g;
        }
        return i;
    }

    public final boolean h(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.s) ? this.A.getDecoratedStart(view) >= this.A.getEnd() - i : this.A.getDecoratedEnd(view) <= i;
    }

    public final boolean i(View view, int i) {
        return (isMainAxisDirectionHorizontal() || !this.s) ? this.A.getDecoratedEnd(view) <= i : this.A.getEnd() - this.A.getDecoratedStart(view) <= i;
    }

    @Override // defpackage.rx1
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.n;
        return i == 0 || i == 1;
    }

    public final void j() {
        this.u.clear();
        this.z.s();
        this.z.d = 0;
    }

    public final void k() {
        if (this.A != null) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            if (this.o == 0) {
                this.A = OrientationHelper.createHorizontalHelper(this);
                this.B = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.A = OrientationHelper.createVerticalHelper(this);
                this.B = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.o == 0) {
            this.A = OrientationHelper.createVerticalHelper(this);
            this.B = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.A = OrientationHelper.createHorizontalHelper(this);
            this.B = OrientationHelper.createVerticalHelper(this);
        }
    }

    public final int l(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f != Integer.MIN_VALUE) {
            if (cVar.f6049a < 0) {
                cVar.f += cVar.f6049a;
            }
            F(recycler, cVar);
        }
        int i = cVar.f6049a;
        int iA = cVar.f6049a;
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int iC = 0;
        while (true) {
            if ((iA <= 0 && !this.y.b) || !cVar.w(state, this.u)) {
                break;
            }
            com.google.android.flexbox.a aVar = this.u.get(cVar.c);
            cVar.d = aVar.o;
            iC += C(aVar, cVar);
            if (zIsMainAxisDirectionHorizontal || !this.s) {
                cVar.e += aVar.a() * cVar.i;
            } else {
                cVar.e -= aVar.a() * cVar.i;
            }
            iA -= aVar.a();
        }
        cVar.f6049a -= iC;
        if (cVar.f != Integer.MIN_VALUE) {
            cVar.f += iC;
            if (cVar.f6049a < 0) {
                cVar.f += cVar.f6049a;
            }
            F(recycler, cVar);
        }
        return i - cVar.f6049a;
    }

    public final View m(int i) {
        View viewR = r(0, getChildCount(), i);
        if (viewR == null) {
            return null;
        }
        int i2 = this.v.c[getPosition(viewR)];
        if (i2 == -1) {
            return null;
        }
        return n(viewR, this.u.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View n(View view, com.google.android.flexbox.a aVar) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i = aVar.h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.s || zIsMainAxisDirectionHorizontal) {
                    if (this.A.getDecoratedStart(view) > this.A.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.A.getDecoratedEnd(view) < this.A.getDecoratedEnd(childAt)) {
                }
            }
        }
        return view;
    }

    public final View o(int i) {
        View viewR = r(getChildCount() - 1, -1, i);
        if (viewR == null) {
            return null;
        }
        return p(viewR, this.u.get(this.v.c[getPosition(viewR)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.L = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.I) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        R(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        R(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        R(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        R(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        this.w = recycler;
        this.x = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        J();
        k();
        ensureLayoutState();
        this.v.t(itemCount);
        this.v.u(itemCount);
        this.v.s(itemCount);
        this.y.j = false;
        SavedState savedState = this.C;
        if (savedState != null && savedState.g(itemCount)) {
            this.E = this.C.mAnchorPosition;
        }
        if (!this.z.f || this.E != -1 || this.C != null) {
            this.z.s();
            Q(state, this.z);
            this.z.f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.z.e) {
            V(this.z, false, true);
        } else {
            U(this.z, false, true);
        }
        S(itemCount);
        if (this.z.e) {
            l(recycler, state, this.y);
            i2 = this.y.e;
            U(this.z, true, false);
            l(recycler, state, this.y);
            i = this.y.e;
        } else {
            l(recycler, state, this.y);
            i = this.y.e;
            V(this.z, true, false);
            l(recycler, state, this.y);
            i2 = this.y.e;
        }
        if (getChildCount() > 0) {
            if (this.z.e) {
                fixLayoutStartGap(i2 + fixLayoutEndGap(i, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i + fixLayoutStartGap(i2, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.C = null;
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.M = -1;
        this.z.s();
        this.J.clear();
    }

    @Override // defpackage.rx1
    public void onNewFlexItemAdded(View view, int i, int i2, com.google.android.flexbox.a aVar) {
        calculateItemDecorationsForChild(view, O);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            aVar.e += leftDecorationWidth;
            aVar.f += leftDecorationWidth;
        } else {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            aVar.e += topDecorationHeight;
            aVar.f += topDecorationHeight;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.C = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.C != null) {
            return new SavedState(this.C);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.A.getDecoratedStart(childClosestToStart) - this.A.getStartAfterPadding();
        } else {
            savedState.h();
        }
        return savedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View p(View view, com.google.android.flexbox.a aVar) {
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - aVar.h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.s || zIsMainAxisDirectionHorizontal) {
                    if (this.A.getDecoratedEnd(view) < this.A.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.A.getDecoratedStart(view) > this.A.getDecoratedStart(childAt)) {
                }
            }
        }
        return view;
    }

    public final View q(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = getChildAt(i);
            if (B(childAt, z)) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public final View r(int i, int i2, int i3) {
        k();
        ensureLayoutState();
        int startAfterPadding = this.A.getStartAfterPadding();
        int endAfterPadding = this.A.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.A.getDecoratedStart(childAt) >= startAfterPadding && this.A.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    public final void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        while (i2 >= i) {
            removeAndRecycleViewAt(i2, recycler);
            i2--;
        }
    }

    public final int s(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || (this.o == 0 && isMainAxisDirectionHorizontal())) {
            int iY = y(i, recycler, state);
            this.J.clear();
            return iY;
        }
        int iZ = z(i);
        this.z.d += iZ;
        this.B.offsetChildren(-iZ);
        return iZ;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.E = i;
        this.F = Integer.MIN_VALUE;
        SavedState savedState = this.C;
        if (savedState != null) {
            savedState.h();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.o == 0 && !isMainAxisDirectionHorizontal())) {
            int iY = y(i, recycler, state);
            this.J.clear();
            return iY;
        }
        int iZ = z(i);
        this.z.d += iZ;
        this.B.offsetChildren(-iZ);
        return iZ;
    }

    @Override // defpackage.rx1
    public void setFlexLines(List<com.google.android.flexbox.a> list) {
        this.u = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public final int t(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    public final int u(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    @Override // defpackage.rx1
    public void updateViewCache(int i, View view) {
        this.J.put(i, view);
    }

    public final int v(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    public List<com.google.android.flexbox.a> w() {
        ArrayList arrayList = new ArrayList(this.u.size());
        int size = this.u.size();
        for (int i = 0; i < size; i++) {
            com.google.android.flexbox.a aVar = this.u.get(i);
            if (aVar.b() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public int x(int i) {
        return this.v.c[i];
    }

    public final int y(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        k();
        int i2 = 1;
        this.y.j = true;
        boolean z = !isMainAxisDirectionHorizontal() && this.s;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int iAbs = Math.abs(i);
        T(i2, iAbs);
        int iL = this.y.f + l(recycler, state, this.y);
        if (iL < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iL) {
                i = (-i2) * iL;
            }
        } else if (iAbs > iL) {
            i = i2 * iL;
        }
        this.A.offsetChildren(-i);
        this.y.g = i;
        return i;
    }

    public final int z(int i) {
        int iMin;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        k();
        boolean zIsMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.L;
        int width = zIsMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = zIsMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i);
            if (i < 0) {
                iMin = Math.min((width2 + this.z.d) - width, iAbs);
            } else {
                if (this.z.d + i <= 0) {
                    return i;
                }
                iMin = this.z.d;
            }
        } else {
            if (i > 0) {
                return Math.min((width2 - this.z.d) - width, i);
            }
            if (this.z.d + i >= 0) {
                return i;
            }
            iMin = this.z.d;
        }
        return -iMin;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean g(int i) {
            int i2 = this.mAnchorPosition;
            return i2 >= 0 && i2 < i;
        }

        public final void h() {
            this.mAnchorPosition = -1;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        public SavedState() {
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i, int i2) {
        this.r = -1;
        this.u = new ArrayList();
        this.v = new com.google.android.flexbox.b(this);
        this.z = new b();
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.G = Integer.MIN_VALUE;
        this.H = Integer.MIN_VALUE;
        this.J = new SparseArray<>();
        this.M = -1;
        this.N = new b.C0366b();
        L(i);
        M(i2);
        K(4);
        setAutoMeasureEnabled(true);
        this.K = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        R(i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        /* JADX INFO: compiled from: SearchBox */
        public static class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i) {
            this.mAlignSelf = i;
        }

        public void setFlexBasisPercent(float f) {
            this.mFlexBasisPercent = f;
        }

        public void setFlexGrow(float f) {
            this.mFlexGrow = f;
        }

        public void setFlexShrink(float f) {
            this.mFlexShrink = f;
        }

        public void setHeight(int i) {
            ((ViewGroup.MarginLayoutParams) this).height = i;
        }

        public void setMaxHeight(int i) {
            this.mMaxHeight = i;
        }

        public void setMaxWidth(int i) {
            this.mMaxWidth = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i) {
            this.mMinHeight = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.mMinWidth = i;
        }

        public void setOrder(int i) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public void setWidth(int i) {
            ((ViewGroup.MarginLayoutParams) this).width = i;
        }

        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.r = -1;
        this.u = new ArrayList();
        this.v = new com.google.android.flexbox.b(this);
        this.z = new b();
        this.E = -1;
        this.F = Integer.MIN_VALUE;
        this.G = Integer.MIN_VALUE;
        this.H = Integer.MIN_VALUE;
        this.J = new SparseArray<>();
        this.M = -1;
        this.N = new b.C0366b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    L(3);
                } else {
                    L(2);
                }
            }
        } else if (properties.reverseLayout) {
            L(1);
        } else {
            L(0);
        }
        M(1);
        K(4);
        setAutoMeasureEnabled(true);
        this.K = context;
    }

    @Override // defpackage.rx1
    public void onNewFlexLineAdded(com.google.android.flexbox.a aVar) {
    }
}
