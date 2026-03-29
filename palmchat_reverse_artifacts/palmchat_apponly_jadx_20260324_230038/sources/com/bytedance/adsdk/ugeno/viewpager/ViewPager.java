package com.bytedance.adsdk.ugeno.viewpager;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.bytedance.sdk.component.utils.k;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ViewPager extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f5049a;
    private int ay;
    int b;
    private int bc;
    private int bf;
    private int bg;
    private float bq;
    private int c;
    private boolean cj;
    private boolean d;
    private float dw;
    private b eh;
    com.bytedance.adsdk.ugeno.viewpager.nr fx;
    private pn gc;
    private int gi;
    private boolean h;
    private int ja;
    private int jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private int f5050jp;
    private iz k;
    private boolean kj;
    private ArrayList<View> kw;
    private ClassLoader l;
    private b lf;
    private float m;
    private boolean mh;
    private int mk;
    private Scroller mv;
    private int my;
    private final nr n;
    private List<Object> nb;
    private Drawable o;
    private int oa;
    private int p;
    private float pb;
    private int q;
    private boolean qq;
    private int rh;
    private boolean s;
    private boolean su;
    private int sx;
    private Parcelable t;
    private EdgeEffect tk;
    private int tm;
    private int u;
    private List<b> v;
    private int w;
    private EdgeEffect wi;
    private float wq;
    private final ArrayList<nr> x;
    private float xg;
    private int xw;
    private VelocityTracker y;
    private boolean yd;
    private boolean z;
    private final Runnable za;
    static final int[] nr = {R.attr.layout_gravity};
    private static final Comparator<nr> pn = new Comparator<nr>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(nr nrVar, nr nrVar2) {
            return nrVar.nr - nrVar2.nr;
        }
    };
    private static final Interpolator iz = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final n f = new n();

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);

        void n(int i);

        void u(int i, float f, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class iz extends DataSetObserver {
        public iz() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.nr();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.nr();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            fx fxVar = (fx) view.getLayoutParams();
            fx fxVar2 = (fx) view2.getLayoutParams();
            boolean z = fxVar.u;
            return z != fxVar2.u ? z ? 1 : -1 : fxVar.pn - fxVar2.pn;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        float b;
        boolean fx;
        int nr;
        float pn;
        Object u;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface pn {
        void u(View view, float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface u {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class x extends com.bytedance.adsdk.ugeno.viewpager.u {
        public static final Parcelable.Creator<x> CREATOR = new Parcelable.ClassLoaderCreator<x>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.x.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i) {
                return new x[i];
            }
        };
        ClassLoader b;
        Parcelable fx;
        int nr;

        public x(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.nr + "}";
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.u, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.nr);
            parcel.writeParcelable(this.fx, i);
        }

        public x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.nr = parcel.readInt();
            this.fx = parcel.readParcelable(classLoader);
            this.b = classLoader;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.x = new ArrayList<>();
        this.n = new nr();
        this.f5049a = new Rect();
        this.jk = -1;
        this.t = null;
        this.l = null;
        this.bq = -3.4028235E38f;
        this.dw = Float.MAX_VALUE;
        this.gi = 1;
        this.f5050jp = -1;
        this.su = true;
        this.mh = false;
        this.za = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.fx();
            }
        };
        this.tm = 0;
        u();
    }

    private nr a() {
        int i;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.my / clientWidth : 0.0f;
        nr nrVar = null;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.x.size()) {
            nr nrVar2 = this.x.get(i3);
            if (!z && nrVar2.nr != (i = i2 + 1)) {
                nrVar2 = this.n;
                nrVar2.pn = f2 + f4 + f3;
                nrVar2.nr = i;
                nrVar2.b = this.fx.u(i);
                i3--;
            }
            nr nrVar3 = nrVar2;
            f2 = nrVar3.pn;
            float f5 = nrVar3.b + f2 + f3;
            if (!z && scrollX < f2) {
                return nrVar;
            }
            if (scrollX < f5 || i3 == this.x.size() - 1) {
                return nrVar3;
            }
            int i4 = nrVar3.nr;
            float f6 = nrVar3.b;
            i3++;
            z = false;
            i2 = i4;
            f4 = f6;
            nrVar = nrVar3;
        }
        return nrVar;
    }

    private boolean b(int i) {
        if (this.x.size() == 0) {
            if (this.su) {
                return false;
            }
            this.yd = false;
            u(0, 0.0f, 0);
            if (this.yd) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        nr nrVarA = a();
        int clientWidth = getClientWidth();
        int i2 = this.my;
        int i3 = clientWidth + i2;
        float f2 = clientWidth;
        int i4 = nrVarA.nr;
        float f3 = ((i / f2) - nrVarA.pn) / (nrVarA.b + (i2 / f2));
        this.yd = false;
        u(i4, f3, (int) (i3 * f3));
        if (this.yd) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void iz() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((fx) getChildAt(i).getLayoutParams()).u) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    private void jk() {
        this.d = false;
        this.h = false;
        VelocityTracker velocityTracker = this.y;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.y = null;
        }
    }

    private boolean n() {
        this.f5050jp = -1;
        jk();
        this.tk.onRelease();
        this.wi.onRelease();
        return this.tk.isFinished() || this.wi.isFinished();
    }

    private void pn(int i) {
        b bVar = this.eh;
        if (bVar != null) {
            bVar.n(i);
        }
        List<b> list = this.v;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar2 = this.v.get(i2);
                if (bVar2 != null) {
                    bVar2.n(i);
                }
            }
        }
        b bVar3 = this.lf;
        if (bVar3 != null) {
            bVar3.n(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.kj != z) {
            this.kj = z;
        }
    }

    private void x() {
        if (this.p != 0) {
            ArrayList<View> arrayList = this.kw;
            if (arrayList == null) {
                this.kw = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.kw.add(getChildAt(i));
            }
            Collections.sort(this.kw, f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        nr nrVarU;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (nrVarU = u(childAt)) != null && nrVarU.nr == this.b) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        nr nrVarU;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (nrVarU = u(childAt)) != null && nrVarU.nr == this.b) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        fx fxVar = (fx) layoutParams;
        boolean zFx = fxVar.u | fx(view);
        fxVar.u = zFx;
        if (!this.qq) {
            super.addView(view, i, layoutParams);
        } else {
            if (zFx) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            fxVar.b = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.fx == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.bq)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.dw));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof fx) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.s = true;
        if (this.mv.isFinished() || !this.mv.computeScrollOffset()) {
            u(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mv.getCurrX();
        int currY = this.mv.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!b(currX)) {
                this.mv.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || u(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        nr nrVarU;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (nrVarU = u(childAt)) != null && nrVarU.nr == this.b && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (nrVar = this.fx) != null && nrVar.u() > 1)) {
            if (!this.tk.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.bq * width);
                this.tk.setSize(height, width);
                zDraw = false | this.tk.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.wi.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.dw + 1.0f)) * width2);
                this.wi.setSize(height2, width2);
                zDraw |= this.wi.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.tk.finish();
            this.wi.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void fx() {
        u(this.b);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new fx();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.viewpager.nr getAdapter() {
        return this.fx;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.p == 2) {
            i2 = (i - 1) - i2;
        }
        return ((fx) this.kw.get(i2).getLayoutParams()).iz;
    }

    public int getCurrentItem() {
        return this.b;
    }

    public int getOffscreenPageLimit() {
        return this.gi;
    }

    public int getPageMargin() {
        return this.my;
    }

    public void nr() {
        int iU = this.fx.u();
        this.u = iU;
        boolean z = this.x.size() < (this.gi * 2) + 1 && this.x.size() < iU;
        int iMax = this.b;
        int i = 0;
        while (i < this.x.size()) {
            nr nrVar = this.x.get(i);
            int iU2 = this.fx.u(nrVar.u);
            if (iU2 != -1) {
                if (iU2 == -2) {
                    this.x.remove(i);
                    i--;
                    this.fx.u((ViewGroup) this, nrVar.nr, nrVar.u);
                    int i2 = this.b;
                    if (i2 == nrVar.nr) {
                        iMax = Math.max(0, Math.min(i2, iU - 1));
                    }
                } else {
                    int i3 = nrVar.nr;
                    if (i3 != iU2) {
                        if (i3 == this.b) {
                            iMax = iU2;
                        }
                        nrVar.nr = iU2;
                    }
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.x, pn);
        if (z) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                fx fxVar = (fx) getChildAt(i4).getLayoutParams();
                if (!fxVar.u) {
                    fxVar.fx = 0.0f;
                }
            }
            u(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.su = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.za);
        Scroller scroller = this.mv;
        if (scroller != null && !scroller.isFinished()) {
            this.mv.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.my <= 0 || this.o == null || this.x.size() <= 0 || this.fx == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.my / width;
        int i2 = 0;
        nr nrVar = this.x.get(0);
        float f5 = nrVar.pn;
        int size = this.x.size();
        int i3 = nrVar.nr;
        int i4 = this.x.get(size - 1).nr;
        while (i3 < i4) {
            while (true) {
                i = nrVar.nr;
                if (i3 <= i || i2 >= size) {
                    break;
                }
                i2++;
                nrVar = this.x.get(i2);
            }
            if (i3 == i) {
                float f6 = nrVar.pn;
                float f7 = nrVar.b;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float fU = this.fx.u(i3);
                f2 = (f5 + fU) * width;
                f5 += fU + f4;
            }
            if (this.my + f2 > scrollX) {
                f3 = f4;
                this.o.setBounds(Math.round(f2), this.sx, Math.round(this.my + f2), this.bg);
                this.o.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i3++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            n();
            return false;
        }
        if (action != 0) {
            if (this.d) {
                return true;
            }
            if (this.h) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.xg = x2;
            this.wq = x2;
            float y = motionEvent.getY();
            this.m = y;
            this.pb = y;
            this.f5050jp = motionEvent.getPointerId(0);
            this.h = false;
            this.s = true;
            this.mv.computeScrollOffset();
            if (this.tm != 2 || Math.abs(this.mv.getFinalX() - this.mv.getCurrX()) <= this.w) {
                u(false);
                this.d = false;
            } else {
                this.mv.abortAnimation();
                this.z = false;
                fx();
                this.d = true;
                fx(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.f5050jp;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f2 = x3 - this.wq;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.m);
                if (f2 != 0.0f && !u(this.wq, f2) && u(this, false, (int) f2, (int) x3, (int) y2)) {
                    this.wq = x3;
                    this.pb = y2;
                    this.h = true;
                    return false;
                }
                int i2 = this.bf;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.d = true;
                    fx(true);
                    setScrollState(1);
                    this.wq = f2 > 0.0f ? this.xg + this.bf : this.xg - this.bf;
                    this.pb = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.h = true;
                }
                if (this.d && nr(x3)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            u(motionEvent);
        }
        if (this.y == null) {
            this.y = VelocityTracker.obtain();
        }
        this.y.addMovement(motionEvent);
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        nr nrVarU;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                fx fxVar = (fx) childAt.getLayoutParams();
                if (fxVar.u) {
                    int i9 = fxVar.nr;
                    int i10 = i9 & 7;
                    int i11 = i9 & 112;
                    if (i10 != 1) {
                        if (i10 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i10 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i11 == 16) {
                            if (i11 == 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i11 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i12 = paddingLeft + scrollX;
                            childAt.layout(i12, paddingTop, childAt.getMeasuredWidth() + i12, paddingTop + childAt.getMeasuredHeight());
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i13 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i13;
                        int i122 = paddingLeft + scrollX;
                        childAt.layout(i122, paddingTop, childAt.getMeasuredWidth() + i122, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i14 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i14;
                    if (i11 == 16) {
                    }
                    int i132 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i132;
                    int i1222 = paddingLeft + scrollX;
                    childAt.layout(i1222, paddingTop, childAt.getMeasuredWidth() + i1222, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i15 = (i5 - paddingLeft) - paddingRight;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                fx fxVar2 = (fx) childAt2.getLayoutParams();
                if (!fxVar2.u && (nrVarU = u(childAt2)) != null) {
                    float f2 = i15;
                    int i17 = ((int) (nrVarU.pn * f2)) + paddingLeft;
                    if (fxVar2.b) {
                        fxVar2.b = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * fxVar2.fx), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i17, paddingTop, childAt2.getMeasuredWidth() + i17, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.sx = paddingTop;
        this.bg = i6 - paddingBottom;
        this.ay = i7;
        if (this.su) {
            z2 = false;
            u(this.b, false, 0, false);
        } else {
            z2 = false;
        }
        this.su = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        fx fxVar;
        fx fxVar2;
        int i3;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.ja = Math.min(measuredWidth / 10, this.rh);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (fxVar2 = (fx) childAt.getLayoutParams()) != null && fxVar2.u) {
                int i7 = fxVar2.nr;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i10 = 1073741824;
                } else {
                    int i11 = z ? 1073741824 : Integer.MIN_VALUE;
                    i3 = ((ViewGroup.LayoutParams) fxVar2).width;
                    if (i3 == -2) {
                        if (i3 == -1) {
                            i3 = paddingLeft;
                        }
                        i10 = 1073741824;
                    } else {
                        i3 = paddingLeft;
                    }
                    i4 = ((ViewGroup.LayoutParams) fxVar2).height;
                    if (i4 != -2) {
                        i4 = measuredHeight;
                        i6 = i11;
                    } else if (i4 == -1) {
                        i4 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i10), View.MeasureSpec.makeMeasureSpec(i4, i6));
                    if (!z2) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i3 = ((ViewGroup.LayoutParams) fxVar2).width;
                if (i3 == -2) {
                }
                i4 = ((ViewGroup.LayoutParams) fxVar2).height;
                if (i4 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, i10), View.MeasureSpec.makeMeasureSpec(i4, i6));
                if (!z2) {
                }
            }
            i5++;
        }
        this.c = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.q = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.qq = true;
        fx();
        this.qq = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((fxVar = (fx) childAt2.getLayoutParams()) == null || !fxVar.u)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * fxVar.fx), 1073741824), this.q);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        nr nrVarU;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (nrVarU = u(childAt)) != null && nrVarU.nr == this.b && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        super.onRestoreInstanceState(xVar.u());
        if (this.fx != null) {
            u(xVar.nr, false, true);
            return;
        }
        this.jk = xVar.nr;
        this.t = xVar.fx;
        this.l = xVar.b;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        xVar.nr = this.b;
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar = this.fx;
        if (nrVar != null) {
            xVar.fx = nrVar.nr();
        }
        return xVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.my;
            u(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar;
        int iFindPointerIndex;
        if (this.cj) {
            return true;
        }
        boolean zN = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (nrVar = this.fx) == null || nrVar.u() == 0) {
            return false;
        }
        if (this.y == null) {
            this.y = VelocityTracker.obtain();
        }
        this.y.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mv.abortAnimation();
            this.z = false;
            fx();
            float x2 = motionEvent.getX();
            this.xg = x2;
            this.wq = x2;
            float y = motionEvent.getY();
            this.m = y;
            this.pb = y;
            this.f5050jp = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.wq = motionEvent.getX(actionIndex);
                            this.f5050jp = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        u(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f5050jp);
                        if (iFindPointerIndex2 != -1) {
                            this.wq = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.d) {
                    u(this.b, true, 0, false);
                    zN = n();
                }
            } else if (!this.d) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.f5050jp);
                if (iFindPointerIndex3 == -1) {
                    zN = n();
                } else {
                    float x3 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x3 - this.wq);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.pb);
                    if (fAbs > this.bf && fAbs > fAbs2) {
                        this.d = true;
                        fx(true);
                        float f2 = this.xg;
                        this.wq = x3 - f2 > 0.0f ? f2 + this.bf : f2 - this.bf;
                        this.pb = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.d) {
                        zN = false | nr(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.d && (iFindPointerIndex = motionEvent.findPointerIndex(this.f5050jp)) != -1) {
                zN = false | nr(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.d) {
            VelocityTracker velocityTracker = this.y;
            velocityTracker.computeCurrentVelocity(1000, this.xw);
            int xVelocity = (int) velocityTracker.getXVelocity(this.f5050jp);
            this.z = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            nr nrVarA = a();
            float f3 = clientWidth;
            int i = nrVarA.nr;
            float f4 = ((scrollX / f3) - nrVarA.pn) / (nrVarA.b + (this.my / f3));
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.f5050jp);
            if (iFindPointerIndex4 != -1) {
                u(u(i, f4, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.xg)), true, true, xVelocity);
                zN = n();
            }
        }
        if (zN) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.qq) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.nr nrVar) {
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar2 = this.fx;
        if (nrVar2 != null) {
            nrVar2.u((DataSetObserver) null);
            for (int i = 0; i < this.x.size(); i++) {
                nr nrVar3 = this.x.get(i);
                this.fx.u((ViewGroup) this, nrVar3.nr, nrVar3.u);
            }
            this.x.clear();
            iz();
            this.b = 0;
            scrollTo(0, 0);
        }
        this.fx = nrVar;
        this.u = 0;
        if (nrVar != null) {
            if (this.k == null) {
                this.k = new iz();
            }
            this.fx.u((DataSetObserver) this.k);
            this.z = false;
            boolean z = this.su;
            this.su = true;
            this.u = this.fx.u();
            int i2 = this.jk;
            if (i2 >= 0) {
                u(i2, false, true);
                this.jk = -1;
                this.t = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                fx();
            }
        }
        List<Object> list = this.nb;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.nb.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.nb.get(i3);
        }
    }

    public void setCurrentItem(int i) {
        this.z = false;
        u(i, !this.su, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i != this.gi) {
            this.gi = i;
            fx();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(b bVar) {
        this.eh = bVar;
    }

    public void setPageMargin(int i) {
        int i2 = this.my;
        this.my = i;
        int width = getWidth();
        u(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.tm == i) {
            return;
        }
        this.tm = i;
        if (this.gc != null) {
            nr(i != 0);
        }
        iz(i);
    }

    public void setScroller(Scroller scroller) {
        this.mv = scroller;
    }

    public void u() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mv = new Scroller(context, iz);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.bf = viewConfiguration.getScaledPagingTouchSlop();
        this.bc = (int) (400.0f * f2);
        this.xw = viewConfiguration.getScaledMaximumFlingVelocity();
        this.tk = new EdgeEffect(context);
        this.wi = new EdgeEffect(context);
        this.oa = (int) (25.0f * f2);
        this.w = (int) (2.0f * f2);
        this.rh = (int) (f2 * 16.0f);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx extends ViewGroup.LayoutParams {
        boolean b;
        float fx;
        int iz;
        public int nr;
        int pn;
        public boolean u;

        public fx() {
            super(-1, -1);
            this.fx = 0.0f;
        }

        public fx(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fx = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.nr);
            this.nr = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static boolean fx(View view) {
        return view.getClass().getAnnotation(u.class) != null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new fx(getContext(), attributeSet);
    }

    private void fx(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    private void iz(int i) {
        b bVar = this.eh;
        if (bVar != null) {
            bVar.a(i);
        }
        List<b> list = this.v;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar2 = this.v.get(i2);
                if (bVar2 != null) {
                    bVar2.a(i);
                }
            }
        }
        b bVar3 = this.lf;
        if (bVar3 != null) {
            bVar3.a(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean fx(int i) {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zB = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                k.nr("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i == 17 || i == 1) {
                zB = b();
            } else if (i == 66 || i == 2) {
                zB = pn();
            }
        } else if (i == 17) {
            int i2 = u(this.f5049a, viewFindNextFocus).left;
            int i3 = u(this.f5049a, viewFindFocus).left;
            if (viewFindFocus != null && i2 >= i3) {
                zB = b();
            } else {
                zB = viewFindNextFocus.requestFocus();
            }
        } else if (i == 66) {
            int i4 = u(this.f5049a, viewFindNextFocus).left;
            int i5 = u(this.f5049a, viewFindFocus).left;
            if (viewFindFocus == null || i4 > i5) {
                zB = viewFindNextFocus.requestFocus();
            }
        }
        if (zB) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zB;
    }

    public boolean pn() {
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar = this.fx;
        if (nrVar == null || this.b >= nrVar.u() - 1) {
            return false;
        }
        u(this.b + 1, true);
        return true;
    }

    public boolean b() {
        int i = this.b;
        if (i <= 0) {
            return false;
        }
        u(i - 1, true);
        return true;
    }

    public void u(int i, boolean z) {
        this.z = false;
        u(i, z, false);
    }

    public void u(int i, boolean z, boolean z2) {
        u(i, z, z2, 0);
    }

    public void u(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.viewpager.nr nrVar = this.fx;
        if (nrVar != null && nrVar.u() > 0) {
            if (!z2 && this.b == i && this.x.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.fx.u()) {
                i = this.fx.u() - 1;
            }
            int i3 = this.gi;
            int i4 = this.b;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.x.size(); i5++) {
                    this.x.get(i5).fx = true;
                }
            }
            boolean z3 = this.b != i;
            if (this.su) {
                this.b = i;
                if (z3) {
                    pn(i);
                }
                requestLayout();
                return;
            }
            u(i);
            u(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public nr nr(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return u(view);
            }
        }
    }

    public nr nr(int i) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            nr nrVar = this.x.get(i2);
            if (nrVar.nr == i) {
                return nrVar;
            }
        }
        return null;
    }

    private void nr(int i, float f2, int i2) {
        b bVar = this.eh;
        if (bVar != null) {
            bVar.u(i, f2, i2);
        }
        List<b> list = this.v;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar2 = this.v.get(i3);
                if (bVar2 != null) {
                    bVar2.u(i, f2, i2);
                }
            }
        }
        b bVar3 = this.lf;
        if (bVar3 != null) {
            bVar3.u(i, f2, i2);
        }
    }

    private void u(int i, boolean z, int i2, boolean z2) {
        nr nrVarNr = nr(i);
        int clientWidth = nrVarNr != null ? (int) (getClientWidth() * Math.max(this.bq, Math.min(nrVarNr.pn, this.dw))) : 0;
        if (z) {
            u(clientWidth, 0, i2);
            if (z2) {
                pn(i);
                return;
            }
            return;
        }
        if (z2) {
            pn(i);
        }
        u(false);
        scrollTo(clientWidth, 0);
        b(clientWidth);
    }

    private void nr(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mk : 0, null);
        }
    }

    private boolean nr(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.wq - f2;
        this.wq = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.bq * clientWidth;
        float f5 = this.dw * clientWidth;
        boolean z3 = false;
        nr nrVar = this.x.get(0);
        ArrayList<nr> arrayList = this.x;
        nr nrVar2 = arrayList.get(arrayList.size() - 1);
        if (nrVar.nr != 0) {
            f4 = nrVar.pn * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (nrVar2.nr != this.fx.u() - 1) {
            f5 = nrVar2.pn * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.tk.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.wi.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i = (int) scrollX;
        this.wq += scrollX - i;
        scrollTo(i, getScrollY());
        b(i);
        return z3;
    }

    public void u(b bVar) {
        if (this.v == null) {
            this.v = new ArrayList();
        }
        this.v.add(bVar);
    }

    public void u(boolean z, pn pnVar) {
        u(z, pnVar, 2);
    }

    public void u(boolean z, pn pnVar, int i) {
        boolean z2 = pnVar != null;
        boolean z3 = z2 != (this.gc != null);
        this.gc = pnVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.p = z ? 2 : 1;
            this.mk = i;
        } else {
            this.p = 0;
        }
        if (z3) {
            fx();
        }
    }

    public float u(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public void u(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mv;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.s ? this.mv.getCurrX() : this.mv.getStartX();
            this.mv.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            u(false);
            fx();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i7;
        float fU = f3 + (u(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fU / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f2 * this.fx.u(this.b)) + this.my)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.s = false;
        this.mv.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    public nr u(int i, int i2) {
        nr nrVar = new nr();
        nrVar.nr = i;
        nrVar.u = this.fx.u((ViewGroup) this, i);
        nrVar.b = this.fx.u(i);
        if (i2 >= 0 && i2 < this.x.size()) {
            this.x.add(i2, nrVar);
        } else {
            this.x.add(nrVar);
        }
        return nrVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1 A[PHI: r7 r10 r15
      0x00f1: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
      0x00f1: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:61:0x00e6, B:58:0x00d0, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i) {
        nr nrVarNr;
        String hexString;
        nr nrVarU;
        nr nrVarU2;
        nr nrVar;
        int i2 = this.b;
        if (i2 != i) {
            nrVarNr = nr(i2);
            this.b = i;
        } else {
            nrVarNr = null;
        }
        if (this.fx == null) {
            x();
            return;
        }
        if (this.z) {
            x();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.gi;
        int iMax = Math.max(0, this.b - i3);
        int iU = this.fx.u();
        int iMin = Math.min(iU - 1, this.b + i3);
        if (iU == this.u) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.x.size()) {
                    break;
                }
                nrVarU = this.x.get(i4);
                int i5 = nrVarU.nr;
                int i6 = this.b;
                if (i5 >= i6) {
                    if (i5 != i6) {
                        break;
                    }
                } else {
                    i4++;
                }
            }
            if (nrVarU == null && iU > 0) {
                nrVarU = u(this.b, i4);
            }
            if (nrVarU != null) {
                int i7 = i4 - 1;
                nr nrVar2 = i7 >= 0 ? this.x.get(i7) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - nrVarU.b) + (getPaddingLeft() / clientWidth);
                float f2 = 0.0f;
                for (int i8 = this.b - 1; i8 >= 0; i8--) {
                    if (f2 >= paddingLeft && i8 < iMax) {
                        if (nrVar2 == null) {
                            break;
                        }
                        if (i8 == nrVar2.nr && !nrVar2.fx) {
                            this.x.remove(i7);
                            this.fx.u((ViewGroup) this, i8, nrVar2.u);
                            i7--;
                            i4--;
                            if (i7 >= 0) {
                                nrVar = this.x.get(i7);
                            }
                            nrVar2 = nrVar;
                        }
                    } else if (nrVar2 != null && i8 == nrVar2.nr) {
                        f2 += nrVar2.b;
                        i7--;
                        if (i7 >= 0) {
                            nrVar = this.x.get(i7);
                        }
                        nrVar2 = nrVar;
                    } else {
                        f2 += u(i8, i7 + 1).b;
                        i4++;
                        nrVar = i7 >= 0 ? this.x.get(i7) : null;
                        nrVar2 = nrVar;
                    }
                }
                float f3 = nrVarU.b;
                int i9 = i4 + 1;
                if (f3 < 2.0f) {
                    nr nrVar3 = i9 < this.x.size() ? this.x.get(i9) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    int i10 = this.b;
                    while (true) {
                        i10++;
                        if (i10 >= iU) {
                            break;
                        }
                        if (f3 >= paddingRight && i10 > iMin) {
                            if (nrVar3 == null) {
                                break;
                            }
                            if (i10 == nrVar3.nr && !nrVar3.fx) {
                                this.x.remove(i9);
                                this.fx.u((ViewGroup) this, i10, nrVar3.u);
                                if (i9 < this.x.size()) {
                                    nrVar3 = this.x.get(i9);
                                }
                            }
                        } else if (nrVar3 != null && i10 == nrVar3.nr) {
                            f3 += nrVar3.b;
                            i9++;
                            if (i9 < this.x.size()) {
                                nrVar3 = this.x.get(i9);
                            }
                        } else {
                            nr nrVarU3 = u(i10, i9);
                            i9++;
                            f3 += nrVarU3.b;
                            nrVar3 = i9 < this.x.size() ? this.x.get(i9) : null;
                        }
                    }
                }
                u(nrVarU, i4, nrVarNr);
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                fx fxVar = (fx) childAt.getLayoutParams();
                fxVar.iz = i11;
                if (!fxVar.u && fxVar.fx == 0.0f && (nrVarU2 = u(childAt)) != null) {
                    fxVar.fx = nrVarU2.b;
                    fxVar.pn = nrVarU2.nr;
                }
            }
            x();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                nr nrVarNr2 = viewFindFocus != null ? nr(viewFindFocus) : null;
                if (nrVarNr2 == null || nrVarNr2.nr != this.b) {
                    for (int i12 = 0; i12 < getChildCount(); i12++) {
                        View childAt2 = getChildAt(i12);
                        nr nrVarU4 = u(childAt2);
                        if (nrVarU4 != null && nrVarU4.nr == this.b && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        try {
            hexString = getResources().getResourceName(getId());
        } catch (Resources.NotFoundException unused) {
            hexString = Integer.toHexString(getId());
        }
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.u + ", found: " + iU + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.fx.getClass());
    }

    private void u(nr nrVar, int i, nr nrVar2) {
        int i2;
        int i3;
        nr nrVar3;
        nr nrVar4;
        int iU = this.fx.u();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.my / clientWidth : 0.0f;
        if (nrVar2 != null) {
            int i4 = nrVar2.nr;
            int i5 = nrVar.nr;
            if (i4 < i5) {
                float fU = nrVar2.pn + nrVar2.b + f2;
                int i6 = i4 + 1;
                int i7 = 0;
                while (i6 <= nrVar.nr && i7 < this.x.size()) {
                    nr nrVar5 = this.x.get(i7);
                    while (true) {
                        nrVar4 = nrVar5;
                        if (i6 <= nrVar4.nr || i7 >= this.x.size() - 1) {
                            break;
                        }
                        i7++;
                        nrVar5 = this.x.get(i7);
                    }
                    while (i6 < nrVar4.nr) {
                        fU += this.fx.u(i6) + f2;
                        i6++;
                    }
                    nrVar4.pn = fU;
                    fU += nrVar4.b + f2;
                    i6++;
                }
            } else if (i4 > i5) {
                int size = this.x.size() - 1;
                float fU2 = nrVar2.pn;
                while (true) {
                    i4--;
                    if (i4 < nrVar.nr || size < 0) {
                        break;
                    }
                    nr nrVar6 = this.x.get(size);
                    while (true) {
                        nrVar3 = nrVar6;
                        if (i4 >= nrVar3.nr || size <= 0) {
                            break;
                        }
                        size--;
                        nrVar6 = this.x.get(size);
                    }
                    while (i4 > nrVar3.nr) {
                        fU2 -= this.fx.u(i4) + f2;
                        i4--;
                    }
                    fU2 -= nrVar3.b + f2;
                    nrVar3.pn = fU2;
                }
            }
        }
        int size2 = this.x.size();
        float fU3 = nrVar.pn;
        int i8 = nrVar.nr;
        int i9 = i8 - 1;
        this.bq = i8 == 0 ? fU3 : -3.4028235E38f;
        int i10 = iU - 1;
        this.dw = i8 == i10 ? (nrVar.b + fU3) - 1.0f : Float.MAX_VALUE;
        int i11 = i - 1;
        while (i11 >= 0) {
            nr nrVar7 = this.x.get(i11);
            while (true) {
                i3 = nrVar7.nr;
                if (i9 <= i3) {
                    break;
                }
                fU3 -= this.fx.u(i9) + f2;
                i9--;
            }
            fU3 -= nrVar7.b + f2;
            nrVar7.pn = fU3;
            if (i3 == 0) {
                this.bq = fU3;
            }
            i11--;
            i9--;
        }
        float fU4 = nrVar.pn + nrVar.b + f2;
        int i12 = nrVar.nr + 1;
        int i13 = i + 1;
        while (i13 < size2) {
            nr nrVar8 = this.x.get(i13);
            while (true) {
                i2 = nrVar8.nr;
                if (i12 >= i2) {
                    break;
                }
                fU4 += this.fx.u(i12) + f2;
                i12++;
            }
            if (i2 == i10) {
                this.dw = (nrVar8.b + fU4) - 1.0f;
            }
            nrVar8.pn = fU4;
            fU4 += nrVar8.b + f2;
            i13++;
            i12++;
        }
        this.mh = false;
    }

    public nr u(View view) {
        for (int i = 0; i < this.x.size(); i++) {
            nr nrVar = this.x.get(i);
            if (this.fx.u(view, nrVar.u)) {
                return nrVar;
            }
        }
        return null;
    }

    private void u(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.x.isEmpty()) {
            if (!this.mv.isFinished()) {
                this.mv.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        nr nrVarNr = nr(this.b);
        int iMin = (int) ((nrVarNr != null ? Math.min(nrVarNr.pn, this.dw) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            u(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i, float f2, int i2) {
        int iMax;
        int width;
        int left;
        if (this.ay > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                fx fxVar = (fx) childAt.getLayoutParams();
                if (fxVar.u) {
                    int i4 = fxVar.nr & 7;
                    if (i4 == 1) {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = width;
                }
            }
        }
        nr(i, f2, i2);
        if (this.gc != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((fx) childAt2.getLayoutParams()).u) {
                    this.gc.u(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.yd = true;
    }

    private void u(boolean z) {
        boolean z2 = this.tm == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mv.isFinished()) {
                this.mv.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mv.getCurrX();
                int currY = this.mv.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        b(currX);
                    }
                }
            }
        }
        this.z = false;
        for (int i = 0; i < this.x.size(); i++) {
            nr nrVar = this.x.get(i);
            if (nrVar.fx) {
                nrVar.fx = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.za);
            } else {
                this.za.run();
            }
        }
    }

    private boolean u(float f2, float f3) {
        if (f2 >= this.ja || f3 <= 0.0f) {
            return f2 > ((float) (getWidth() - this.ja)) && f3 < 0.0f;
        }
        return true;
    }

    private int u(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.oa || Math.abs(i2) <= this.bc) {
            i += (int) (f2 + (i >= this.b ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.x.size() <= 0) {
            return i;
        }
        return Math.max(this.x.get(0).nr, Math.min(i, this.x.get(r4.size() - 1).nr));
    }

    private void u(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f5050jp) {
            int i = actionIndex == 0 ? 1 : 0;
            this.wq = motionEvent.getX(i);
            this.f5050jp = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.y;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean u(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && u(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public boolean u(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return b();
                }
                return fx(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return pn();
                }
                return fx(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return fx(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return fx(1);
                }
            }
        }
        return false;
    }

    private Rect u(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
