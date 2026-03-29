package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.zenmen.palmchat.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZXBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16009a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public ViewDragHelper j;
    public boolean k;
    public int l;
    public boolean m;
    public int n;
    public WeakReference<V> o;
    public WeakReference<View> p;
    public c q;
    public VelocityTracker r;
    public int s;
    public int t;
    public boolean u;
    public final ViewDragHelper.Callback v;

    /* JADX INFO: compiled from: SearchBox */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new a());
        final int state;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f16010a;
        public final /* synthetic */ int b;

        public a(View view, int i) {
            this.f16010a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZXBottomSheetBehavior.this.c(this.f16010a, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ViewDragHelper.Callback {
        public b() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            ZXBottomSheetBehavior zXBottomSheetBehavior = ZXBottomSheetBehavior.this;
            return d.a(i, zXBottomSheetBehavior.e, zXBottomSheetBehavior.g ? zXBottomSheetBehavior.n : zXBottomSheetBehavior.f);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            int i;
            int i2;
            ZXBottomSheetBehavior zXBottomSheetBehavior = ZXBottomSheetBehavior.this;
            if (zXBottomSheetBehavior.g) {
                i = zXBottomSheetBehavior.n;
                i2 = zXBottomSheetBehavior.e;
            } else {
                i = zXBottomSheetBehavior.f;
                i2 = zXBottomSheetBehavior.e;
            }
            return i - i2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                ZXBottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            ZXBottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = ZXBottomSheetBehavior.this.e;
            } else {
                ZXBottomSheetBehavior zXBottomSheetBehavior = ZXBottomSheetBehavior.this;
                if (zXBottomSheetBehavior.g && zXBottomSheetBehavior.shouldHide(view, f2)) {
                    i = ZXBottomSheetBehavior.this.n;
                    i2 = 5;
                } else {
                    if (f2 == 0.0f) {
                        int top = view.getTop();
                        if (Math.abs(top - ZXBottomSheetBehavior.this.e) < Math.abs(top - ZXBottomSheetBehavior.this.f)) {
                            i = ZXBottomSheetBehavior.this.e;
                        } else {
                            i = ZXBottomSheetBehavior.this.f;
                        }
                    } else {
                        i = ZXBottomSheetBehavior.this.f;
                    }
                    i2 = 4;
                }
            }
            if (!ZXBottomSheetBehavior.this.j.settleCapturedViewAt(view.getLeft(), i)) {
                ZXBottomSheetBehavior.this.setStateInternal(i2);
            } else {
                ZXBottomSheetBehavior.this.setStateInternal(2);
                ViewCompat.postOnAnimation(view, new e(view, i2));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            WeakReference<V> weakReference;
            View view2;
            ZXBottomSheetBehavior zXBottomSheetBehavior = ZXBottomSheetBehavior.this;
            int i2 = zXBottomSheetBehavior.i;
            if (i2 == 1 || zXBottomSheetBehavior.u) {
                return false;
            }
            return ((i2 == 3 && zXBottomSheetBehavior.s == i && (view2 = zXBottomSheetBehavior.p.get()) != null && ViewCompat.canScrollVertically(view2, -1)) || (weakReference = ZXBottomSheetBehavior.this.o) == null || weakReference.get() != view) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c {
        public abstract void a(@NonNull View view, float f);

        public abstract void b(@NonNull View view, int i);

        public abstract boolean c(View view, MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {
        public static int a(int i, int i2, int i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f16012a;
        public final int b;

        public e(View view, int i) {
            this.f16012a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = ZXBottomSheetBehavior.this.j;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                ZXBottomSheetBehavior.this.setStateInternal(this.b);
            } else {
                ViewCompat.postOnAnimation(this.f16012a, this);
            }
        }
    }

    public ZXBottomSheetBehavior() {
        this.i = 4;
        this.v = new b();
    }

    public static <V extends View> ZXBottomSheetBehavior<V> a(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof ZXBottomSheetBehavior) {
            return (ZXBottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public void b(c cVar) {
        this.q = cVar;
    }

    public void c(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.f;
        } else if (i == 3) {
            i2 = this.e;
        } else {
            if (!this.g || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            i2 = this.n;
        }
        if (!this.j.smoothSlideViewTo(view, view.getLeft(), i2)) {
            setStateInternal(i);
        } else {
            setStateInternal(2);
            ViewCompat.postOnAnimation(view, new e(view, i));
        }
    }

    public void dispatchOnSlide(int i) {
        c cVar;
        V v = this.o.get();
        if (v == null || (cVar = this.q) == null) {
            return;
        }
        if (i > this.f) {
            cVar.a(v, (r2 - i) / (this.n - r2));
        } else {
            cVar.a(v, (r2 - i) / (r2 - this.e));
        }
    }

    @VisibleForTesting
    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
            if (viewFindScrollingChild != null) {
                return viewFindScrollingChild;
            }
        }
        return null;
    }

    public final float getYVelocity() {
        this.r.computeCurrentVelocity(1000, this.f16009a);
        return this.r.getYVelocity(this.s);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        c cVar;
        if (!v.isShown() || ((cVar = this.q) != null && !cVar.c(v, motionEvent))) {
            this.k = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.r == null) {
            this.r = VelocityTracker.obtain();
        }
        this.r.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.t = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.p;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.t)) {
                this.s = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.u = true;
            }
            this.k = this.s == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.t);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.u = false;
            this.s = -1;
            if (this.k) {
                this.k = false;
                return false;
            }
        }
        if (!this.k && this.j.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        View view2 = this.p.get();
        return (actionMasked != 2 || view2 == null || this.k || this.i == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.t) - motionEvent.getY()) <= ((float) this.j.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        int iMax;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.n = coordinatorLayout.getHeight();
        if (this.c) {
            if (this.d == 0) {
                this.d = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            iMax = Math.max(this.d, this.n - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            iMax = this.b;
        }
        int iMax2 = Math.max(0, this.n - v.getHeight());
        this.e = iMax2;
        int iMax3 = Math.max(this.n - iMax, iMax2);
        this.f = iMax3;
        int i2 = this.i;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(v, this.e);
        } else if (this.g && i2 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.n);
        } else if (i2 == 4) {
            ViewCompat.offsetTopAndBottom(v, iMax3);
        } else if (i2 == 1 || i2 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.j == null) {
            this.j = ViewDragHelper.create(coordinatorLayout, this.v);
        }
        this.o = new WeakReference<>(v);
        this.p = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.p.get() && (this.i != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view != this.p.get()) {
            return;
        }
        int top = v.getTop();
        int i3 = top - i2;
        if (i2 > 0) {
            int i4 = this.e;
            if (i3 < i4) {
                int i5 = top - i4;
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v, -i5);
                setStateInternal(3);
            } else {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !ViewCompat.canScrollVertically(view, -1)) {
            int i6 = this.f;
            if (i3 <= i6 || this.g) {
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            } else {
                int i7 = top - i6;
                iArr[1] = i7;
                ViewCompat.offsetTopAndBottom(v, -i7);
                setStateInternal(4);
            }
        }
        dispatchOnSlide(v.getTop());
        this.l = i2;
        this.m = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        int i = savedState.state;
        if (i == 1 || i == 2) {
            this.i = 4;
        } else {
            this.i = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.l = 0;
        this.m = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i;
        int i2 = 3;
        if (v.getTop() == this.e) {
            setStateInternal(3);
            return;
        }
        if (view == this.p.get() && this.m) {
            if (this.l > 0) {
                i = this.e;
            } else if (this.g && shouldHide(v, getYVelocity())) {
                i = this.n;
                i2 = 5;
            } else {
                if (this.l == 0) {
                    int top = v.getTop();
                    if (Math.abs(top - this.e) < Math.abs(top - this.f)) {
                        i = this.e;
                    } else {
                        i = this.f;
                    }
                } else {
                    i = this.f;
                }
                i2 = 4;
            }
            if (this.j.smoothSlideViewTo(v, v.getLeft(), i)) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(v, new e(v, i2));
            } else {
                setStateInternal(i2);
            }
            this.m = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        c cVar = this.q;
        if (cVar != null && !cVar.c(v, motionEvent)) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.i == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.j;
        if (viewDragHelper != null) {
            try {
                viewDragHelper.processTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.r == null) {
            this.r = VelocityTracker.obtain();
        }
        this.r.addMovement(motionEvent);
        if (actionMasked == 2 && !this.k && this.j != null && Math.abs(this.t - motionEvent.getY()) > this.j.getTouchSlop()) {
            this.j.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.k;
    }

    public final void reset() {
        this.s = -1;
        VelocityTracker velocityTracker = this.r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.r = null;
        }
    }

    public void setHideable(boolean z) {
        this.g = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setPeekHeight(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (this.c) {
                z = false;
            } else {
                this.c = true;
            }
        } else if (this.c || this.b != i) {
            this.c = false;
            this.b = Math.max(0, i);
            this.f = this.n - i;
        }
        if (!z || this.i != 4 || (weakReference = this.o) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void setSkipCollapsed(boolean z) {
        this.h = z;
    }

    public final void setState(int i) {
        if (i == this.i) {
            return;
        }
        WeakReference<V> weakReference = this.o;
        if (weakReference == null) {
            if (i == 4 || i == 3 || (this.g && i == 5)) {
                this.i = i;
                return;
            }
            return;
        }
        V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new a(v, i));
        } else {
            c(v, i);
        }
    }

    public void setStateInternal(int i) {
        c cVar;
        if (this.i == i) {
            return;
        }
        this.i = i;
        V v = this.o.get();
        if (v == null || (cVar = this.q) == null) {
            return;
        }
        cVar.b(v, i);
    }

    public boolean shouldHide(View view, float f) {
        if (this.h) {
            return true;
        }
        return view.getTop() >= this.f && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.f)) / ((float) this.b) > 0.5f;
    }

    public ZXBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.i = 4;
        this.v = new b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            setPeekHeight(i);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        setHideable(false);
        setSkipCollapsed(false);
        typedArrayObtainStyledAttributes.recycle();
        this.f16009a = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
