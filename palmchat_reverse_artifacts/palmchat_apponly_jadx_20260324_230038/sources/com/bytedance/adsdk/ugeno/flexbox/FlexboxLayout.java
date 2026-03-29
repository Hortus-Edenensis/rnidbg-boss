package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.b;
import com.bytedance.adsdk.ugeno.iz.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class FlexboxLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.flexbox.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5024a;
    private int b;
    private int fx;
    private int iz;
    private int jk;
    private b k;
    private int l;
    private int[] mv;
    private List<fx> my;
    private Drawable n;
    private int nr;
    private com.bytedance.adsdk.ugeno.fx o;
    private int pn;
    private SparseIntArray s;
    private b.u sx;
    private int t;
    private int u;
    private Drawable x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends ViewGroup.MarginLayoutParams implements nr {
        public static final Parcelable.Creator<u> CREATOR = new Parcelable.Creator<u>() { // from class: com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout.u.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public u createFromParcel(Parcel parcel) {
                return new u(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public u[] newArray(int i) {
                return new u[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5025a;
        private int b;
        private float fx;
        private int iz;
        private boolean jk;
        private int n;
        private float nr;
        private float pn;
        private int u;
        private int x;

        public u(u uVar) {
            super((ViewGroup.MarginLayoutParams) uVar);
            this.u = 1;
            this.nr = 0.0f;
            this.fx = 0.0f;
            this.b = -1;
            this.pn = -1.0f;
            this.iz = -1;
            this.x = -1;
            this.n = 16777215;
            this.f5025a = 16777215;
            this.u = uVar.u;
            this.nr = uVar.nr;
            this.fx = uVar.fx;
            this.b = uVar.b;
            this.pn = uVar.pn;
            this.iz = uVar.iz;
            this.x = uVar.x;
            this.n = uVar.n;
            this.f5025a = uVar.f5025a;
            this.jk = uVar.jk;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int a() {
            return this.n;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public float b() {
            return this.nr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int fx() {
            return this.u;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int iz() {
            return this.b;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int jk() {
            return this.f5025a;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int k() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public float l() {
            return this.pn;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int mv() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int my() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int n() {
            return this.x;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int nr() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public float pn() {
            return this.fx;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int s() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public boolean t() {
            return this.jk;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int u() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.u);
            parcel.writeFloat(this.nr);
            parcel.writeFloat(this.fx);
            parcel.writeInt(this.b);
            parcel.writeFloat(this.pn);
            parcel.writeInt(this.iz);
            parcel.writeInt(this.x);
            parcel.writeInt(this.n);
            parcel.writeInt(this.f5025a);
            parcel.writeByte(this.jk ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public int x() {
            return this.iz;
        }

        public void b(int i) {
            this.b = i;
        }

        public void fx(int i) {
            this.u = i;
        }

        public void nr(float f) {
            this.fx = f;
        }

        public void u(float f) {
            this.nr = f;
        }

        public void fx(float f) {
            this.pn = f;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public void nr(int i) {
            this.x = i;
        }

        @Override // com.bytedance.adsdk.ugeno.flexbox.nr
        public void u(int i) {
            this.iz = i;
        }

        public u(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.u = 1;
            this.nr = 0.0f;
            this.fx = 0.0f;
            this.b = -1;
            this.pn = -1.0f;
            this.iz = -1;
            this.x = -1;
            this.n = 16777215;
            this.f5025a = 16777215;
        }

        public u(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.u = 1;
            this.nr = 0.0f;
            this.fx = 0.0f;
            this.b = -1;
            this.pn = -1.0f;
            this.iz = -1;
            this.x = -1;
            this.n = 16777215;
            this.f5025a = 16777215;
        }

        public u(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.u = 1;
            this.nr = 0.0f;
            this.fx = 0.0f;
            this.b = -1;
            this.pn = -1.0f;
            this.iz = -1;
            this.x = -1;
            this.n = 16777215;
            this.f5025a = 16777215;
        }

        public u(Parcel parcel) {
            super(0, 0);
            this.u = 1;
            this.nr = 0.0f;
            this.fx = 0.0f;
            this.b = -1;
            this.pn = -1.0f;
            this.iz = -1;
            this.x = -1;
            this.n = 16777215;
            this.f5025a = 16777215;
            this.u = parcel.readInt();
            this.nr = parcel.readFloat();
            this.fx = parcel.readFloat();
            this.b = parcel.readInt();
            this.pn = parcel.readFloat();
            this.iz = parcel.readInt();
            this.x = parcel.readInt();
            this.n = parcel.readInt();
            this.f5025a = parcel.readInt();
            this.jk = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.iz = -1;
        this.k = new b(this);
        this.my = new ArrayList();
        this.sx = new b.u();
    }

    private boolean b(int i, int i2) {
        return pn(i, i2) ? u() ? (this.jk & 1) != 0 : (this.f5024a & 1) != 0 : u() ? (this.jk & 2) != 0 : (this.f5024a & 2) != 0;
    }

    private boolean iz(int i) {
        if (i >= 0 && i < this.my.size()) {
            for (int i2 = i + 1; i2 < this.my.size(); i2++) {
                if (this.my.get(i2).nr() > 0) {
                    return false;
                }
            }
            if (u()) {
                return (this.f5024a & 4) != 0;
            }
            if ((this.jk & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean pn(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewFx = fx(i - i3);
            if (viewFx != null && viewFx.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.s == null) {
            this.s = new SparseIntArray(getChildCount());
        }
        this.mv = this.k.u(view, i, layoutParams, this.s);
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof u;
    }

    public View fx(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.mv;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof u ? new u((u) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new u((ViewGroup.MarginLayoutParams) layoutParams) : new u(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getAlignContent() {
        return this.pn;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getAlignItems() {
        return this.b;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.x;
    }

    public Drawable getDividerDrawableVertical() {
        return this.n;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getFlexDirection() {
        return this.u;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<fx> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.my.size());
        for (fx fxVar : this.my) {
            if (fxVar.nr() != 0) {
                arrayList.add(fxVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public List<fx> getFlexLinesInternal() {
        return this.my;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getFlexWrap() {
        return this.nr;
    }

    public int getJustifyContent() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getLargestMainSize() {
        Iterator<fx> it = this.my.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().pn);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getMaxLine() {
        return this.iz;
    }

    public int getShowDividerHorizontal() {
        return this.f5024a;
    }

    public int getShowDividerVertical() {
        return this.jk;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int getSumOfCrossSize() {
        int size = this.my.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            fx fxVar = this.my.get(i2);
            if (b(i2)) {
                i += u() ? this.t : this.l;
            }
            if (iz(i2)) {
                i += u() ? this.t : this.l;
            }
            i += fxVar.x;
        }
        return i;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public View nr(int i) {
        return fx(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.n == null && this.x == null) {
            return;
        }
        if (this.f5024a == 0 && this.jk == 0) {
            return;
        }
        int iU = x.u(this);
        int i = this.u;
        if (i == 0) {
            u(canvas, iU == 1, this.nr == 2);
            return;
        }
        if (i == 1) {
            u(canvas, iU != 1, this.nr == 2);
            return;
        }
        if (i == 2) {
            boolean z = iU == 1;
            if (this.nr == 2) {
                z = !z;
            }
            nr(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iU == 1;
        if (this.nr == 2) {
            z2 = !z2;
        }
        nr(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.b();
        }
        int iU = x.u(this);
        int i5 = this.u;
        if (i5 == 0) {
            u(iU == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            u(iU != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iU == 1;
            u(this.nr == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else {
            if (i5 != 3) {
                throw new IllegalStateException("Invalid flex direction is set: " + this.u);
            }
            z2 = iU == 1;
            u(this.nr == 2 ? !z2 : z2, true, i, i2, i3, i4);
        }
        com.bytedance.adsdk.ugeno.fx fxVar2 = this.o;
        if (fxVar2 != null) {
            fxVar2.u(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            int[] iArrU = fxVar.u(i, i2);
            u(iArrU[0], iArrU[1]);
        } else {
            u(i, i2);
        }
        com.bytedance.adsdk.ugeno.fx fxVar2 = this.o;
        if (fxVar2 != null) {
            fxVar2.fx();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.nr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.fx fxVar = this.o;
        if (fxVar != null) {
            fxVar.u(z);
        }
    }

    public void setAlignContent(int i) {
        if (this.pn != i) {
            this.pn = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.x) {
            return;
        }
        this.x = drawable;
        if (drawable != null) {
            this.t = drawable.getIntrinsicHeight();
        } else {
            this.t = 0;
        }
        nr();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.n) {
            return;
        }
        this.n = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
        } else {
            this.l = 0;
        }
        nr();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.u != i) {
            this.u = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public void setFlexLines(List<fx> list) {
        this.my = list;
    }

    public void setFlexWrap(int i) {
        if (this.nr != i) {
            this.nr = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.fx != i) {
            this.fx = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.iz != i) {
            this.iz = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.f5024a) {
            this.f5024a = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.jk) {
            this.jk = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int u(View view) {
        return 0;
    }

    private void nr(int i, int i2) {
        this.my.clear();
        this.sx.u();
        this.k.u(this.sx, i, i2);
        this.my = this.sx.u;
        this.k.u(i, i2);
        if (this.b == 3) {
            for (fx fxVar : this.my) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < fxVar.n; i3++) {
                    View viewFx = fx(fxVar.k + i3);
                    if (viewFx != null && viewFx.getVisibility() != 8) {
                        u uVar = (u) viewFx.getLayoutParams();
                        iMax = this.nr != 2 ? Math.max(iMax, viewFx.getMeasuredHeight() + Math.max(fxVar.l - viewFx.getBaseline(), ((ViewGroup.MarginLayoutParams) uVar).topMargin) + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin) : Math.max(iMax, viewFx.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) uVar).topMargin + Math.max((fxVar.l - viewFx.getMeasuredHeight()) + viewFx.getBaseline(), ((ViewGroup.MarginLayoutParams) uVar).bottomMargin));
                    }
                }
                fxVar.x = iMax;
            }
        }
        this.k.nr(i, i2, getPaddingTop() + getPaddingBottom());
        this.k.u();
        u(this.u, i, i2, this.sx.nr);
    }

    private void u(int i, int i2) {
        if (this.s == null) {
            this.s = new SparseIntArray(getChildCount());
        }
        if (this.k.nr(this.s)) {
            this.mv = this.k.u(this.s);
        }
        int i3 = this.u;
        if (i3 == 0 || i3 == 1) {
            nr(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            fx(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.u);
        }
    }

    private void fx(int i, int i2) {
        this.my.clear();
        this.sx.u();
        this.k.nr(this.sx, i, i2);
        this.my = this.sx.u;
        this.k.u(i, i2);
        this.k.nr(i, i2, getPaddingLeft() + getPaddingRight());
        this.k.u();
        u(this.u, i, i2, this.sx.nr);
    }

    private boolean pn(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.my.get(i2).nr() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean b(int i) {
        if (i >= 0 && i < this.my.size()) {
            if (pn(i)) {
                return u() ? (this.f5024a & 1) != 0 : (this.jk & 1) != 0;
            }
            if (u()) {
                return (this.f5024a & 2) != 0;
            }
            if ((this.jk & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public View u(int i) {
        return getChildAt(i);
    }

    private void u(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void nr(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.my.size();
        for (int i3 = 0; i3 < size; i3++) {
            fx fxVar = this.my.get(i3);
            for (int i4 = 0; i4 < fxVar.n; i4++) {
                int i5 = fxVar.k + i4;
                View viewFx = fx(i5);
                if (viewFx != null && viewFx.getVisibility() != 8) {
                    u uVar = (u) viewFx.getLayoutParams();
                    if (b(i5, i4)) {
                        if (z2) {
                            top = viewFx.getBottom() + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin;
                        } else {
                            top = (viewFx.getTop() - ((ViewGroup.MarginLayoutParams) uVar).topMargin) - this.t;
                        }
                        nr(canvas, fxVar.u, top, fxVar.x);
                    }
                    if (i4 == fxVar.n - 1 && (this.f5024a & 4) > 0) {
                        if (z2) {
                            bottom = (viewFx.getTop() - ((ViewGroup.MarginLayoutParams) uVar).topMargin) - this.t;
                        } else {
                            bottom = viewFx.getBottom() + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin;
                        }
                        nr(canvas, fxVar.u, bottom, fxVar.x);
                    }
                }
            }
            if (b(i3)) {
                if (z) {
                    i2 = fxVar.fx;
                } else {
                    i2 = fxVar.u - this.l;
                }
                u(canvas, i2, paddingTop, iMax);
            }
            if (iz(i3) && (this.jk & 4) > 0) {
                if (z) {
                    i = fxVar.u - this.l;
                } else {
                    i = fxVar.fx;
                }
                u(canvas, i, paddingTop, iMax);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public boolean u() {
        int i = this.u;
        return i == 0 || i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(boolean z, int i, int i2, int i3, int i4) {
        float measuredWidth;
        float f;
        float f2;
        int i5;
        int i6;
        int i7;
        float f3;
        int i8;
        u uVar;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i9 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.my.size();
        int i10 = 0;
        while (i10 < size) {
            fx fxVar = this.my.get(i10);
            if (b(i10)) {
                int i11 = this.t;
                paddingBottom -= i11;
                paddingTop += i11;
            }
            int i12 = this.fx;
            int i13 = 1;
            if (i12 == 0) {
                measuredWidth = paddingLeft;
                f = i9 - paddingRight;
            } else if (i12 == 1) {
                int i14 = fxVar.pn;
                f = i14 - paddingLeft;
                measuredWidth = (i9 - i14) + paddingRight;
            } else if (i12 == 2) {
                int i15 = fxVar.pn;
                measuredWidth = paddingLeft + ((i9 - i15) / 2.0f);
                f = (i9 - paddingRight) - ((i9 - i15) / 2.0f);
            } else {
                if (i12 == 3) {
                    measuredWidth = paddingLeft;
                    f2 = (i9 - fxVar.pn) / (fxVar.nr() != 1 ? r10 - 1 : 1.0f);
                    f = i9 - paddingRight;
                } else if (i12 == 4) {
                    int iNr = fxVar.nr();
                    f2 = iNr != 0 ? (i9 - fxVar.pn) / iNr : 0.0f;
                    float f4 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f4;
                    f = (i9 - paddingRight) - f4;
                } else if (i12 == 5) {
                    f2 = fxVar.nr() != 0 ? (i9 - fxVar.pn) / (r7 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i9 - paddingRight) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.fx);
                }
                float fMax = Math.max(f2, 0.0f);
                i5 = 0;
                while (i5 < fxVar.n) {
                    int i16 = fxVar.k + i5;
                    View viewFx = fx(i16);
                    if (viewFx == null || viewFx.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        u uVar2 = (u) viewFx.getLayoutParams();
                        float f5 = measuredWidth + ((ViewGroup.MarginLayoutParams) uVar2).leftMargin;
                        float f6 = f - ((ViewGroup.MarginLayoutParams) uVar2).rightMargin;
                        if (b(i16, i5)) {
                            int i17 = this.l;
                            float f7 = i17;
                            f5 += f7;
                            i8 = i17;
                            f3 = f6 - f7;
                        } else {
                            f3 = f6;
                            i8 = 0;
                        }
                        int i18 = (i5 != fxVar.n - i13 || (this.jk & 4) <= 0) ? 0 : this.l;
                        if (this.nr != 2) {
                            i6 = paddingLeft;
                            i7 = i5;
                            uVar = uVar2;
                            if (z) {
                                this.k.u(viewFx, fxVar, Math.round(f3) - viewFx.getMeasuredWidth(), paddingTop, Math.round(f3), paddingTop + viewFx.getMeasuredHeight());
                            } else {
                                this.k.u(viewFx, fxVar, Math.round(f5), paddingTop, Math.round(f5) + viewFx.getMeasuredWidth(), paddingTop + viewFx.getMeasuredHeight());
                            }
                        } else if (z) {
                            i7 = i5;
                            i6 = paddingLeft;
                            uVar = uVar2;
                            this.k.u(viewFx, fxVar, Math.round(f3) - viewFx.getMeasuredWidth(), paddingBottom - viewFx.getMeasuredHeight(), Math.round(f3), paddingBottom);
                        } else {
                            i6 = paddingLeft;
                            i7 = i5;
                            uVar = uVar2;
                            this.k.u(viewFx, fxVar, Math.round(f5), paddingBottom - viewFx.getMeasuredHeight(), Math.round(f5) + viewFx.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f5 + viewFx.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
                        float measuredWidth2 = f3 - ((viewFx.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) uVar).leftMargin);
                        if (z) {
                            fxVar.u(viewFx, i18, 0, i8, 0);
                        } else {
                            fxVar.u(viewFx, i8, 0, i18, 0);
                        }
                        f = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    paddingLeft = i6;
                    i13 = 1;
                }
                int i19 = paddingLeft;
                int i20 = fxVar.x;
                paddingTop += i20;
                paddingBottom -= i20;
                i10++;
                paddingLeft = i19;
            }
            f2 = 0.0f;
            float fMax2 = Math.max(f2, 0.0f);
            i5 = 0;
            while (i5 < fxVar.n) {
            }
            int i192 = paddingLeft;
            int i202 = fxVar.x;
            paddingTop += i202;
            paddingBottom -= i202;
            i10++;
            paddingLeft = i192;
        }
    }

    private void nr(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.x;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.t + i2);
        this.x.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int nr(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    private void nr() {
        if (this.x == null && this.n == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        u uVar;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.my.size();
        for (int i11 = 0; i11 < size; i11++) {
            fx fxVar = this.my.get(i11);
            if (b(i11)) {
                int i12 = this.l;
                paddingLeft += i12;
                i10 -= i12;
            }
            int i13 = this.fx;
            if (i13 == 0) {
                f = paddingTop;
                i5 = i9 - paddingBottom;
            } else if (i13 == 1) {
                int i14 = fxVar.pn;
                f = (i9 - i14) + paddingBottom;
                i5 = i14 - paddingTop;
            } else if (i13 == 2) {
                int i15 = fxVar.pn;
                f2 = (i9 - paddingBottom) - ((i9 - i15) / 2.0f);
                f = paddingTop + ((i9 - i15) / 2.0f);
                f3 = 0.0f;
                float fMax = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < fxVar.n) {
                }
                int i16 = fxVar.x;
                paddingLeft += i16;
                i10 -= i16;
            } else {
                if (i13 == 3) {
                    f = paddingTop;
                    f3 = (i9 - fxVar.pn) / (fxVar.nr() != 1 ? r7 - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                } else if (i13 == 4) {
                    int iNr = fxVar.nr();
                    f3 = iNr != 0 ? (i9 - fxVar.pn) / iNr : 0.0f;
                    float f6 = f3 / 2.0f;
                    f = paddingTop + f6;
                    f2 = (i9 - paddingBottom) - f6;
                } else if (i13 == 5) {
                    f3 = fxVar.nr() != 0 ? (i9 - fxVar.pn) / (r10 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i9 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.fx);
                }
                float fMax2 = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < fxVar.n) {
                    int i17 = fxVar.k + i6;
                    View viewFx = fx(i17);
                    if (viewFx == null || viewFx.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        u uVar2 = (u) viewFx.getLayoutParams();
                        float f7 = f + ((ViewGroup.MarginLayoutParams) uVar2).topMargin;
                        float f8 = f2 - ((ViewGroup.MarginLayoutParams) uVar2).bottomMargin;
                        if (b(i17, i6)) {
                            int i18 = this.t;
                            float f9 = i18;
                            f4 = f7 + f9;
                            i8 = i18;
                            f5 = f8 - f9;
                        } else {
                            f4 = f7;
                            f5 = f8;
                            i8 = 0;
                        }
                        int i19 = (i6 != fxVar.n - 1 || (this.f5024a & 4) <= 0) ? 0 : this.t;
                        if (!z) {
                            i7 = i6;
                            uVar = uVar2;
                            if (z2) {
                                this.k.u(viewFx, fxVar, false, paddingLeft, Math.round(f5) - viewFx.getMeasuredHeight(), paddingLeft + viewFx.getMeasuredWidth(), Math.round(f5));
                            } else {
                                this.k.u(viewFx, fxVar, false, paddingLeft, Math.round(f4), paddingLeft + viewFx.getMeasuredWidth(), Math.round(f4) + viewFx.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i7 = i6;
                            uVar = uVar2;
                            this.k.u(viewFx, fxVar, true, i10 - viewFx.getMeasuredWidth(), Math.round(f5) - viewFx.getMeasuredHeight(), i10, Math.round(f5));
                        } else {
                            i7 = i6;
                            uVar = uVar2;
                            this.k.u(viewFx, fxVar, true, i10 - viewFx.getMeasuredWidth(), Math.round(f4), i10, Math.round(f4) + viewFx.getMeasuredHeight());
                        }
                        u uVar3 = uVar;
                        float measuredHeight = f4 + viewFx.getMeasuredHeight() + fMax2 + ((ViewGroup.MarginLayoutParams) uVar3).bottomMargin;
                        float measuredHeight2 = f5 - ((viewFx.getMeasuredHeight() + fMax2) + ((ViewGroup.MarginLayoutParams) uVar3).topMargin);
                        if (z2) {
                            fxVar.u(viewFx, 0, i19, 0, i8);
                        } else {
                            fxVar.u(viewFx, 0, i8, 0, i19);
                        }
                        f = measuredHeight;
                        f2 = measuredHeight2;
                    }
                    i6 = i7 + 1;
                }
                int i162 = fxVar.x;
                paddingLeft += i162;
                i10 -= i162;
            }
            f2 = i5;
            f3 = 0.0f;
            float fMax22 = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < fxVar.n) {
            }
            int i1622 = fxVar.x;
            paddingLeft += i1622;
            i10 -= i1622;
        }
    }

    private void u(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.my.size();
        for (int i3 = 0; i3 < size; i3++) {
            fx fxVar = this.my.get(i3);
            for (int i4 = 0; i4 < fxVar.n; i4++) {
                int i5 = fxVar.k + i4;
                View viewFx = fx(i5);
                if (viewFx != null && viewFx.getVisibility() != 8) {
                    u uVar = (u) viewFx.getLayoutParams();
                    if (b(i5, i4)) {
                        if (z) {
                            left = viewFx.getRight() + ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
                        } else {
                            left = (viewFx.getLeft() - ((ViewGroup.MarginLayoutParams) uVar).leftMargin) - this.l;
                        }
                        u(canvas, left, fxVar.nr, fxVar.x);
                    }
                    if (i4 == fxVar.n - 1 && (this.jk & 4) > 0) {
                        if (z) {
                            right = (viewFx.getLeft() - ((ViewGroup.MarginLayoutParams) uVar).leftMargin) - this.l;
                        } else {
                            right = viewFx.getRight() + ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
                        }
                        u(canvas, right, fxVar.nr, fxVar.x);
                    }
                }
            }
            if (b(i3)) {
                if (z2) {
                    i2 = fxVar.b;
                } else {
                    i2 = fxVar.nr - this.t;
                }
                nr(canvas, paddingLeft, i2, iMax);
            }
            if (iz(i3) && (this.f5024a & 4) > 0) {
                if (z2) {
                    i = fxVar.nr - this.t;
                } else {
                    i = fxVar.b;
                }
                nr(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void u(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.n;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.l + i, i3 + i2);
        this.n.draw(canvas);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int u(View view, int i, int i2) {
        int i3;
        int i4;
        if (u()) {
            i3 = b(i, i2) ? 0 + this.l : 0;
            if ((this.jk & 4) <= 0) {
                return i3;
            }
            i4 = this.l;
        } else {
            i3 = b(i, i2) ? 0 + this.t : 0;
            if ((this.f5024a & 4) <= 0) {
                return i3;
            }
            i4 = this.t;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public void u(fx fxVar) {
        if (u()) {
            if ((this.jk & 4) > 0) {
                int i = fxVar.pn;
                int i2 = this.l;
                fxVar.pn = i + i2;
                fxVar.iz += i2;
                return;
            }
            return;
        }
        if ((this.f5024a & 4) > 0) {
            int i3 = fxVar.pn;
            int i4 = this.t;
            fxVar.pn = i3 + i4;
            fxVar.iz += i4;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public int u(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.flexbox.u
    public void u(View view, int i, int i2, fx fxVar) {
        if (b(i, i2)) {
            if (u()) {
                int i3 = fxVar.pn;
                int i4 = this.l;
                fxVar.pn = i3 + i4;
                fxVar.iz += i4;
                return;
            }
            int i5 = fxVar.pn;
            int i6 = this.t;
            fxVar.pn = i5 + i6;
            fxVar.iz += i6;
        }
    }

    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.o = fxVar;
    }
}
