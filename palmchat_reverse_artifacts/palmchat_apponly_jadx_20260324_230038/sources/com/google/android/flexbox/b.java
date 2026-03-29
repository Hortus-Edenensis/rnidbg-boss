package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.media3.muxer.MuxerUtil;
import defpackage.rx1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rx1 f6051a;
    public boolean[] b;

    @Nullable
    public int[] c;

    @Nullable
    public long[] d;

    @Nullable
    public long[] e;

    /* JADX INFO: renamed from: com.google.android.flexbox.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0366b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<com.google.android.flexbox.a> f6052a;
        public int b;

        public void a() {
            this.f6052a = null;
            this.b = 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6053a;
        public int b;

        public c() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NonNull c cVar) {
            int i = this.b;
            int i2 = cVar.b;
            return i != i2 ? i - i2 : this.f6053a - cVar.f6053a;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.b + ", index=" + this.f6053a + '}';
        }
    }

    public b(rx1 rx1Var) {
        this.f6051a = rx1Var;
    }

    public final int A(int i, FlexItem flexItem, int i2) {
        rx1 rx1Var = this.f6051a;
        int childWidthMeasureSpec = rx1Var.getChildWidthMeasureSpec(i, rx1Var.getPaddingLeft() + this.f6051a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        return size > flexItem.getMaxWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    public final int B(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    public final int C(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    public final int D(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    public final int E(FlexItem flexItem, boolean z) {
        return z ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    public final int F(FlexItem flexItem, boolean z) {
        return z ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean z) {
        return z ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean z) {
        return z ? this.f6051a.getPaddingBottom() : this.f6051a.getPaddingEnd();
    }

    public final int I(boolean z) {
        return z ? this.f6051a.getPaddingEnd() : this.f6051a.getPaddingBottom();
    }

    public final int J(boolean z) {
        return z ? this.f6051a.getPaddingTop() : this.f6051a.getPaddingStart();
    }

    public final int K(boolean z) {
        return z ? this.f6051a.getPaddingStart() : this.f6051a.getPaddingTop();
    }

    public final int L(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int i, int i2, com.google.android.flexbox.a aVar) {
        return i == i2 - 1 && aVar.c() != 0;
    }

    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f6051a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.f6051a.getFlexItemAt(i);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int i, int i2, int i3, int i4, FlexItem flexItem, int i5, int i6, int i7) {
        if (this.f6051a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.f6051a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f6051a.getDecorationLengthMainAxis(view, i5, i6);
        if (decorationLengthMainAxis > 0) {
            i4 += decorationLengthMainAxis;
        }
        return i2 < i3 + i4;
    }

    public void Q(View view, com.google.android.flexbox.a aVar, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f6051a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = aVar.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f6051a.getFlexWrap() == 2) {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop(), i3, (i4 - i5) + view.getMeasuredHeight() + flexItem.getMarginTop());
                    return;
                } else {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i3, i6 - flexItem.getMarginBottom());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.f6051a.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f6051a.getFlexWrap() != 2) {
                    int iMax = Math.max(aVar.l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((aVar.l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f6051a.getFlexWrap() != 2) {
            view.layout(i, i2 + flexItem.getMarginTop(), i3, i4 + flexItem.getMarginTop());
        } else {
            view.layout(i, i2 - flexItem.getMarginBottom(), i3, i4 - flexItem.getMarginBottom());
        }
    }

    public void R(View view, com.google.android.flexbox.a aVar, boolean z, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f6051a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i5 = aVar.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (z) {
                    view.layout((i - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i2, (i3 - i5) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i4);
                    return;
                } else {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                } else {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i - flexItem.getMarginRight(), i2, i3 - flexItem.getMarginRight(), i4);
        } else {
            view.layout(i + flexItem.getMarginLeft(), i2, i3 + flexItem.getMarginLeft(), i4);
        }
    }

    @VisibleForTesting
    public long S(int i, int i2) {
        return (((long) i) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) i2) << 32);
    }

    public final void T(int i, int i2, com.google.android.flexbox.a aVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        int i7 = aVar.e;
        float f = aVar.k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f;
        aVar.e = i4 + aVar.f;
        if (!z) {
            aVar.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < aVar.h) {
            int i10 = aVar.o + i8;
            View reorderedFlexItemAt = this.f6051a.getReorderedFlexItemAt(i10);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i5 = i7;
                i6 = i8;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f6051a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int i11 = i8;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i10]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i10]);
                    }
                    if (this.b[i10] || flexItem.getFlexShrink() <= 0.0f) {
                        i6 = i11;
                    } else {
                        float flexShrink = measuredWidth - (flexItem.getFlexShrink() * f3);
                        i6 = i11;
                        if (i6 == aVar.h - 1) {
                            flexShrink += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            iRound = flexItem.getMinWidth();
                            this.b[i10] = true;
                            aVar.k -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            f4 += flexShrink - iRound;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iZ = z(i2, flexItem, aVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i10, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f6051a.updateViewCache(i10, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f6051a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    aVar.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i10]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i10]);
                    }
                    if (this.b[i10] || flexItem.getFlexShrink() <= f2) {
                        i5 = i7;
                        i6 = i8;
                    } else {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f3);
                        if (i8 == aVar.h - 1) {
                            flexShrink2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.b[i10] = true;
                            aVar.k -= flexItem.getFlexShrink();
                            i5 = i7;
                            i6 = i8;
                            z2 = true;
                        } else {
                            f4 += flexShrink2 - iRound2;
                            i5 = i7;
                            i6 = i8;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        int iA = A(i, flexItem, aVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i10, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f6051a.updateViewCache(i10, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f6051a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    aVar.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                }
                aVar.g = Math.max(aVar.g, iMax);
                i9 = iMax;
            }
            i8 = i6 + 1;
            i7 = i5;
            f2 = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == aVar.e) {
            return;
        }
        T(i, i2, aVar, i3, i4, true);
    }

    public final int[] U(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.f6053a;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.b);
            i2++;
        }
        return iArr;
    }

    public final void V(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.f6051a.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f6051a.updateViewCache(i2, view);
    }

    public final void W(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.f6051a.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f6051a.updateViewCache(i2, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i) {
        View reorderedFlexItemAt;
        if (i >= this.f6051a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f6051a.getFlexDirection();
        if (this.f6051a.getAlignItems() != 4) {
            for (com.google.android.flexbox.a aVar : this.f6051a.getFlexLinesInternal()) {
                for (Integer num : aVar.n) {
                    View reorderedFlexItemAt2 = this.f6051a.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(reorderedFlexItemAt2, aVar.g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(reorderedFlexItemAt2, aVar.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.c;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f6051a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            com.google.android.flexbox.a aVar2 = flexLinesInternal.get(i2);
            int i3 = aVar2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = aVar2.o + i4;
                if (i4 < this.f6051a.getFlexItemCount() && (reorderedFlexItemAt = this.f6051a.getReorderedFlexItemAt(i5)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(reorderedFlexItemAt, aVar2.g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(reorderedFlexItemAt, aVar2.g, i5);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = S(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<com.google.android.flexbox.a> list, com.google.android.flexbox.a aVar, int i, int i2) {
        aVar.m = i2;
        this.f6051a.onNewFlexLineAdded(aVar);
        aVar.p = i;
        list.add(aVar);
    }

    public void b(C0366b c0366b, int i, int i2, int i3, int i4, int i5, @Nullable List<com.google.android.flexbox.a> list) {
        int i6;
        C0366b c0366b2;
        int i7;
        int i8;
        int i9;
        List<com.google.android.flexbox.a> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        com.google.android.flexbox.a aVar;
        int i18;
        int i19 = i;
        int i20 = i2;
        int i21 = i5;
        boolean zIsMainAxisDirectionHorizontal = this.f6051a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<com.google.android.flexbox.a> arrayList = list == null ? new ArrayList() : list;
        c0366b.f6052a = arrayList;
        boolean z = i21 == -1;
        int iK = K(zIsMainAxisDirectionHorizontal);
        int I = I(zIsMainAxisDirectionHorizontal);
        int iJ = J(zIsMainAxisDirectionHorizontal);
        int iH = H(zIsMainAxisDirectionHorizontal);
        com.google.android.flexbox.a aVar2 = new com.google.android.flexbox.a();
        int i22 = i4;
        aVar2.o = i22;
        int i23 = I + iK;
        aVar2.e = i23;
        int flexItemCount = this.f6051a.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                c0366b2 = c0366b;
                break;
            }
            View reorderedFlexItemAt = this.f6051a.getReorderedFlexItemAt(i22);
            if (reorderedFlexItemAt != null) {
                if (reorderedFlexItemAt.getVisibility() != 8) {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        v((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i27 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        aVar2.n.add(Integer.valueOf(i22));
                    }
                    int iG = G(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        iG = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        int childWidthMeasureSpec = this.f6051a.getChildWidthMeasureSpec(i19, i23 + E(flexItem, true) + C(flexItem, true), iG);
                        i7 = size;
                        i8 = mode;
                        int childHeightMeasureSpec = this.f6051a.getChildHeightMeasureSpec(i20, iJ + iH + D(flexItem, true) + B(flexItem, true) + i24, F(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        Z(i22, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i9 = childWidthMeasureSpec;
                    } else {
                        i7 = size;
                        i8 = mode;
                        int childWidthMeasureSpec2 = this.f6051a.getChildWidthMeasureSpec(i20, iJ + iH + D(flexItem, false) + B(flexItem, false) + i24, F(flexItem, false));
                        int childHeightMeasureSpec2 = this.f6051a.getChildHeightMeasureSpec(i19, E(flexItem, false) + i23 + C(flexItem, false), iG);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        Z(i22, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        i9 = childHeightMeasureSpec2;
                    }
                    this.f6051a.updateViewCache(i22, reorderedFlexItemAt);
                    i(reorderedFlexItemAt, i22);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i28 = i24;
                    int i29 = i23;
                    com.google.android.flexbox.a aVar3 = aVar2;
                    int i30 = i22;
                    list2 = arrayList;
                    int i31 = i9;
                    if (P(reorderedFlexItemAt, i8, i7, aVar2.e, C(flexItem, zIsMainAxisDirectionHorizontal) + M(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i30, i25, arrayList.size())) {
                        if (aVar3.c() > 0) {
                            if (i30 > 0) {
                                i18 = i30 - 1;
                                aVar = aVar3;
                            } else {
                                aVar = aVar3;
                                i18 = 0;
                            }
                            a(list2, aVar, i18, i28);
                            i24 = aVar.g + i28;
                        } else {
                            i24 = i28;
                        }
                        if (!zIsMainAxisDirectionHorizontal) {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i22 = i30;
                            if (flexItem.getWidth() == -1) {
                                rx1 rx1Var = this.f6051a;
                                view.measure(rx1Var.getChildWidthMeasureSpec(i10, rx1Var.getPaddingLeft() + this.f6051a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i24, flexItem.getWidth()), i31);
                                i(view, i22);
                            }
                        } else if (flexItem.getHeight() == -1) {
                            rx1 rx1Var2 = this.f6051a;
                            i10 = i2;
                            i22 = i30;
                            view = reorderedFlexItemAt;
                            view.measure(i31, rx1Var2.getChildHeightMeasureSpec(i10, rx1Var2.getPaddingTop() + this.f6051a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i24, flexItem.getHeight()));
                            i(view, i22);
                        } else {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i22 = i30;
                        }
                        aVar2 = new com.google.android.flexbox.a();
                        i12 = 1;
                        aVar2.h = 1;
                        i11 = i29;
                        aVar2.e = i11;
                        aVar2.o = i22;
                        i13 = 0;
                        i14 = Integer.MIN_VALUE;
                    } else {
                        i10 = i2;
                        view = reorderedFlexItemAt;
                        i22 = i30;
                        aVar2 = aVar3;
                        i11 = i29;
                        i12 = 1;
                        aVar2.h++;
                        i13 = i25 + 1;
                        i24 = i28;
                        i14 = i26;
                    }
                    aVar2.q |= flexItem.getFlexGrow() != 0.0f;
                    aVar2.r |= flexItem.getFlexShrink() != 0.0f;
                    int[] iArr = this.c;
                    if (iArr != null) {
                        iArr[i22] = list2.size();
                    }
                    aVar2.e += M(view, zIsMainAxisDirectionHorizontal) + E(flexItem, zIsMainAxisDirectionHorizontal) + C(flexItem, zIsMainAxisDirectionHorizontal);
                    aVar2.j += flexItem.getFlexGrow();
                    aVar2.k += flexItem.getFlexShrink();
                    this.f6051a.onNewFlexItemAdded(view, i22, i13, aVar2);
                    int iMax = Math.max(i14, L(view, zIsMainAxisDirectionHorizontal) + D(flexItem, zIsMainAxisDirectionHorizontal) + B(flexItem, zIsMainAxisDirectionHorizontal) + this.f6051a.getDecorationLengthCrossAxis(view));
                    aVar2.g = Math.max(aVar2.g, iMax);
                    if (zIsMainAxisDirectionHorizontal) {
                        if (this.f6051a.getFlexWrap() != 2) {
                            aVar2.l = Math.max(aVar2.l, view.getBaseline() + flexItem.getMarginTop());
                        } else {
                            aVar2.l = Math.max(aVar2.l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i15 = i27;
                    if (N(i22, i15, aVar2)) {
                        a(list2, aVar2, i22, i24);
                        i24 += aVar2.g;
                    }
                    i16 = i5;
                    if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).p < i16 || i22 < i16 || z2) {
                        i17 = i3;
                    } else {
                        i24 = -aVar2.a();
                        i17 = i3;
                        z2 = true;
                    }
                    if (i24 > i17 && z2) {
                        c0366b2 = c0366b;
                        i6 = iCombineMeasuredStates;
                        break;
                    }
                    i25 = i13;
                    i26 = iMax;
                    i22++;
                    i19 = i;
                    flexItemCount = i15;
                    i20 = i10;
                    i23 = i11;
                    arrayList = list2;
                    size = i7;
                    i21 = i16;
                    mode = i8;
                } else {
                    aVar2.i++;
                    aVar2.h++;
                    if (N(i22, flexItemCount, aVar2)) {
                        a(arrayList, aVar2, i22, i24);
                    }
                }
            } else if (N(i22, flexItemCount, aVar2)) {
                a(arrayList, aVar2, i22, i24);
            }
            i7 = size;
            i8 = mode;
            i10 = i20;
            i16 = i21;
            list2 = arrayList;
            i11 = i23;
            i15 = flexItemCount;
            i22++;
            i19 = i;
            flexItemCount = i15;
            i20 = i10;
            i23 = i11;
            arrayList = list2;
            size = i7;
            i21 = i16;
            mode = i8;
        }
        c0366b2.b = i6;
    }

    public void c(C0366b c0366b, int i, int i2) {
        b(c0366b, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(C0366b c0366b, int i, int i2, int i3, int i4, @Nullable List<com.google.android.flexbox.a> list) {
        b(c0366b, i, i2, i3, i4, -1, list);
    }

    public void e(C0366b c0366b, int i, int i2, int i3, int i4, List<com.google.android.flexbox.a> list) {
        b(c0366b, i, i2, i3, 0, i4, list);
    }

    public void f(C0366b c0366b, int i, int i2) {
        b(c0366b, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(C0366b c0366b, int i, int i2, int i3, int i4, @Nullable List<com.google.android.flexbox.a> list) {
        b(c0366b, i2, i, i3, i4, -1, list);
    }

    public void h(C0366b c0366b, int i, int i2, int i3, int i4, List<com.google.android.flexbox.a> list) {
        b(c0366b, i2, i, i3, 0, i4, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(View view, int i) {
        boolean z;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < flexItem.getMinWidth()) {
            measuredWidth = flexItem.getMinWidth();
        } else {
            if (measuredWidth <= flexItem.getMaxWidth()) {
                z = false;
                if (measuredHeight >= flexItem.getMinHeight()) {
                    measuredHeight = flexItem.getMinHeight();
                } else if (measuredHeight > flexItem.getMaxHeight()) {
                    measuredHeight = flexItem.getMaxHeight();
                } else {
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                Z(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f6051a.updateViewCache(i, view);
                return;
            }
            measuredWidth = flexItem.getMaxWidth();
        }
        z = true;
        if (measuredHeight >= flexItem.getMinHeight()) {
        }
        if (z2) {
        }
    }

    public void j(List<com.google.android.flexbox.a> list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final List<com.google.android.flexbox.a> k(List<com.google.android.flexbox.a> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
        aVar.g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(aVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<c> l(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.f6051a.getFlexItemAt(i2).getLayoutParams();
            c cVar = new c();
            cVar.b = flexItem.getOrder();
            cVar.f6053a = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f6051a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f6051a.getFlexItemCount();
        List<c> listL = l(flexItemCount);
        c cVar = new c();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.b = 1;
        } else {
            cVar.b = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= this.f6051a.getFlexItemCount()) {
            cVar.f6053a = flexItemCount;
        } else {
            cVar.f6053a = i;
            while (i < flexItemCount) {
                listL.get(i).f6053a++;
                i++;
            }
        }
        listL.add(cVar);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    public void o(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.f6051a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<com.google.android.flexbox.a> flexLinesInternal = this.f6051a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f6051a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f6051a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    com.google.android.flexbox.a aVar = new com.google.android.flexbox.a();
                    aVar.g = i5;
                    flexLinesInternal.add(0, aVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f6051a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i4 < size4) {
                        arrayList.add(flexLinesInternal.get(i4));
                        if (i4 != flexLinesInternal.size() - 1) {
                            com.google.android.flexbox.a aVar2 = new com.google.android.flexbox.a();
                            if (i4 == flexLinesInternal.size() - 2) {
                                aVar2.g = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                aVar2.g = Math.round(size3);
                            }
                            int i6 = aVar2.g;
                            f += size3 - i6;
                            if (f > 1.0f) {
                                aVar2.g = i6 + 1;
                                f -= 1.0f;
                            } else if (f < -1.0f) {
                                aVar2.g = i6 - 1;
                                f += 1.0f;
                            }
                            arrayList.add(aVar2);
                        }
                        i4++;
                    }
                    this.f6051a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f6051a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    com.google.android.flexbox.a aVar3 = new com.google.android.flexbox.a();
                    aVar3.g = size5;
                    for (com.google.android.flexbox.a aVar4 : flexLinesInternal) {
                        arrayList2.add(aVar3);
                        arrayList2.add(aVar4);
                        arrayList2.add(aVar3);
                    }
                    this.f6051a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        com.google.android.flexbox.a aVar5 = flexLinesInternal.get(i4);
                        float f3 = aVar5.g + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        aVar5.g = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    public void p(int i, int i2) {
        q(i, i2, 0);
    }

    public void q(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f6051a.getFlexItemCount());
        if (i3 >= this.f6051a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f6051a.getFlexDirection();
        int flexDirection2 = this.f6051a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f6051a.getLargestMainSize();
            if (mode != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.f6051a.getPaddingLeft();
            paddingRight = this.f6051a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.f6051a.getLargestMainSize();
            }
            paddingLeft = this.f6051a.getPaddingTop();
            paddingRight = this.f6051a.getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.c;
        List<com.google.android.flexbox.a> flexLinesInternal = this.f6051a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            com.google.android.flexbox.a aVar = flexLinesInternal.get(i5);
            int i6 = aVar.e;
            if (i6 < size && aVar.q) {
                w(i, i2, aVar, size, i4, false);
            } else if (i6 > size && aVar.r) {
                T(i, i2, aVar, size, i4, false);
            }
        }
    }

    public final void r(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.b = new boolean[i];
        } else {
            if (zArr.length >= i) {
                Arrays.fill(zArr, false);
                return;
            }
            int length = zArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.b = new boolean[i];
        }
    }

    public void s(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.c = Arrays.copyOf(iArr, i);
        }
    }

    public void t(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.d = Arrays.copyOf(jArr, i);
        }
    }

    public void u(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.e = Arrays.copyOf(jArr, i);
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    public final void w(int i, int i2, com.google.android.flexbox.a aVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = aVar.j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = aVar.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        aVar.e = i4 + aVar.f;
        if (!z) {
            aVar.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < aVar.h) {
            int i10 = aVar.o + i8;
            View reorderedFlexItemAt = this.f6051a.getReorderedFlexItemAt(i10);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i6 = i5;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f6051a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i5;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i10]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    i6 = i11;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i10]);
                    }
                    if (!this.b[i10] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow = measuredWidth + (flexItem.getFlexGrow() * f3);
                        if (i8 == aVar.h - 1) {
                            flexGrow += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.b[i10] = true;
                            aVar.j -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            f4 += flexGrow - iRound;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int iZ = z(i2, flexItem, aVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i10, iMakeMeasureSpec, iZ, reorderedFlexItemAt);
                        this.f6051a.updateViewCache(i10, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.f6051a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    aVar.e += measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i10]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i10]);
                    }
                    if (this.b[i10] || flexItem.getFlexGrow() <= f2) {
                        i7 = i5;
                    } else {
                        float flexGrow2 = measuredHeight3 + (flexItem.getFlexGrow() * f3);
                        if (i8 == aVar.h - 1) {
                            flexGrow2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.b[i10] = true;
                            aVar.j -= flexItem.getFlexGrow();
                            i7 = i5;
                            z2 = true;
                        } else {
                            f4 += flexGrow2 - iRound2;
                            i7 = i5;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int iA = A(i, flexItem, aVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        Z(i10, iA, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.f6051a.updateViewCache(i10, reorderedFlexItemAt);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.f6051a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    aVar.e += measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i6 = i7;
                }
                aVar.g = Math.max(aVar.g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z2 || i12 == aVar.e) {
            return;
        }
        w(i, i2, aVar, i3, i4, true);
    }

    public int x(long j) {
        return (int) (j >> 32);
    }

    public int y(long j) {
        return (int) j;
    }

    public final int z(int i, FlexItem flexItem, int i2) {
        rx1 rx1Var = this.f6051a;
        int childHeightMeasureSpec = rx1Var.getChildHeightMeasureSpec(i, rx1Var.getPaddingTop() + this.f6051a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        return size > flexItem.getMaxHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }
}
