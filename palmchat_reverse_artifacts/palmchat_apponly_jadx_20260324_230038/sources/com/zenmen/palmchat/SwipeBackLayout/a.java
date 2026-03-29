package com.zenmen.palmchat.SwipeBackLayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static final Interpolator w = new InterpolatorC0948a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12143a;
    public int b;
    public float[] d;
    public float[] e;
    public float[] f;
    public float[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public ScrollerCompat q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public int c = -1;
    public final Runnable v = new b();

    /* JADX INFO: renamed from: com.zenmen.palmchat.SwipeBackLayout.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class InterpolatorC0948a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.D(0);
        }
    }

    public a(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = ScrollerCompat.create(context, w);
    }

    public static a l(ViewGroup viewGroup, c cVar) {
        return new a(viewGroup.getContext(), viewGroup, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.zenmen.palmchat.SwipeBackLayout.a$c] */
    public final void A(float f, float f2, int i) {
        boolean zC = c(f, f2, i, 1);
        ?? r0 = zC;
        if (c(f2, f, i, 4)) {
            r0 = (zC ? 1 : 0) | 4;
        }
        ?? r02 = r0;
        if (c(f, f2, i, 2)) {
            r02 = (r0 == true ? 1 : 0) | 2;
        }
        ?? r03 = r02;
        if (c(f2, f, i, 8)) {
            r03 = (r02 == true ? 1 : 0) | 8;
        }
        if (r03 != 0) {
            int[] iArr = this.i;
            iArr[i] = iArr[i] | r03;
            this.r.f(r03, i);
        }
    }

    public final void B(float f, float f2, int i) {
        p(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = s((int) f, (int) f2);
        this.k |= 1 << i;
    }

    public final void C(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            this.f[pointerId] = x;
            this.g[pointerId] = y;
        }
    }

    public void D(int i) {
        if (this.f12143a != i) {
            this.f12143a = i;
            this.r.j(i);
            if (i == 0) {
                this.s = null;
            }
        }
    }

    public void E(int i) {
        this.o = i;
    }

    public void F(int i) {
        this.p = i;
    }

    public void G(float f) {
        this.m = f;
    }

    public void H(float f) {
        this.n = f;
    }

    public void I(Context context, float f) {
        this.b = (int) (ViewConfiguration.get(context).getScaledTouchSlop() * (1.0f / Math.max(0.0f, Math.min(1.0f, f))));
    }

    public boolean J(int i, int i2) {
        if (this.t) {
            return r(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.l, this.c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean K(MotionEvent motionEvent) {
        View viewQ;
        View viewQ2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            B(x, y, pointerId);
            View viewQ3 = q((int) x, (int) y);
            if (viewQ3 == this.s && this.f12143a == 2) {
                M(viewQ3, pointerId);
            }
            int i = this.h[pointerId];
            int i2 = this.p;
            if ((i & i2) != 0) {
                this.r.h(i & i2, pointerId);
            }
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked == 2) {
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            for (int i3 = 0; i3 < pointerCount; i3++) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i3);
                float x2 = MotionEventCompat.getX(motionEvent, i3);
                float y2 = MotionEventCompat.getY(motionEvent, i3);
                float f = x2 - this.d[pointerId2];
                float f2 = y2 - this.e[pointerId2];
                A(f, f2, pointerId2);
                if (this.f12143a == 1 || ((viewQ = q((int) x2, (int) y2)) != null && d(viewQ, f, f2) && M(viewQ, pointerId2))) {
                    break;
                }
            }
            C(motionEvent);
        } else if (actionMasked != 3) {
            if (actionMasked == 5) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x3 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y3 = MotionEventCompat.getY(motionEvent, actionIndex);
                B(x3, y3, pointerId3);
                int i4 = this.f12143a;
                if (i4 == 0) {
                    int i5 = this.h[pointerId3];
                    int i6 = this.p;
                    if ((i5 & i6) != 0) {
                        this.r.h(i5 & i6, pointerId3);
                    }
                } else if (i4 == 2 && (viewQ2 = q((int) x3, (int) y3)) == this.s) {
                    M(viewQ2, pointerId3);
                }
            } else if (actionMasked == 6) {
                h(MotionEventCompat.getPointerId(motionEvent, actionIndex));
            }
        }
        return this.f12143a == 1;
    }

    public boolean L(View view, int i, int i2) {
        this.s = view;
        this.c = -1;
        return r(i, i2, 0, 0);
    }

    public boolean M(View view, int i) {
        if (view == this.s && this.c == i) {
            return true;
        }
        if (view == null || !this.r.m(view, i)) {
            return false;
        }
        this.c = i;
        b(view, i);
        return true;
    }

    public void a() {
        this.c = -1;
        g();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void b(View view, int i) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.c = i;
            this.r.i(view, i);
            D(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public final boolean c(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.p & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.r.g(i2)) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    public final boolean d(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.d(view) > 0;
        boolean z2 = this.r.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.b) : z2 && Math.abs(f2) > ((float) this.b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.b;
        return f3 > ((float) (i * i));
    }

    public final float e(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    public final int f(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    public final void g() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    public final void h(int i) {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    public final int i(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f = width / 2;
        float fN = f + (n(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fN / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final int j(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iF = f(i3, (int) this.n, (int) this.m);
        int iF2 = f(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iF != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iF2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((i(i, iF, this.r.d(view)) * f5) + (i(i2, iF2, this.r.e(view)) * (f3 / f4)));
    }

    public boolean k(boolean z) {
        if (this.f12143a == 2) {
            boolean zComputeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                this.s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.s.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.r.k(this.s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                zComputeScrollOffset = this.q.isFinished();
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    D(0);
                }
            }
        }
        return this.f12143a == 2;
    }

    public final void m(float f, float f2) {
        this.t = true;
        this.r.l(this.s, f, f2);
        this.t = false;
        if (this.f12143a == 1) {
            D(0);
        }
    }

    public final float n(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    public final void o(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i3 != 0) {
            i = this.r.a(this.s, i, i3);
            this.s.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.r.b(this.s, i2, i4);
            this.s.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.r.k(this.s, i5, i6, i5 - left, i6 - top);
    }

    public final void p(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    public View q(int i, int i2) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean r(int i, int i2, int i3, int i4) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.q.abortAnimation();
            D(0);
            return false;
        }
        this.q.startScroll(left, top, i5, i6, j(this.s, i5, i6, i3, i4));
        D(2);
        return true;
    }

    public final int s(int i, int i2) {
        int i3 = i < this.u.getLeft() + this.o ? 1 : 0;
        if (i2 < this.u.getTop() + this.o) {
            i3 = 4;
        }
        if (i > this.u.getRight() - this.o) {
            i3 = 2;
        }
        if (i2 > this.u.getBottom() - this.o) {
            return 8;
        }
        return i3;
    }

    public int t() {
        return this.f12143a;
    }

    public boolean u(int i, int i2) {
        return x(this.s, i, i2);
    }

    public boolean v(int i, int i2) {
        return w(i2) && (i & this.h[i2]) != 0;
    }

    public boolean w(int i) {
        return ((1 << i) & this.k) != 0;
    }

    public boolean x(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void y(MotionEvent motionEvent) {
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            a();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View viewQ = q((int) x, (int) y);
            B(x, y, pointerId);
            M(viewQ, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.p;
            if ((i3 & i4) != 0) {
                this.r.h(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f12143a == 1) {
                z();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f12143a == 1) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.c);
                float x2 = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                float y2 = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                float[] fArr = this.f;
                int i5 = this.c;
                int i6 = (int) (x2 - fArr[i5]);
                int i7 = (int) (y2 - this.g[i5]);
                o(this.s.getLeft() + i6, this.s.getTop() + i7, i6, i7);
                C(motionEvent);
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                float x3 = MotionEventCompat.getX(motionEvent, i2);
                float y3 = MotionEventCompat.getY(motionEvent, i2);
                float f = x3 - this.d[pointerId2];
                float f2 = y3 - this.e[pointerId2];
                A(f, f2, pointerId2);
                if (this.f12143a != 1) {
                    View viewQ2 = q((int) x3, (int) y3);
                    if (d(viewQ2, f, f2) && M(viewQ2, pointerId2)) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    break;
                }
            }
            C(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f12143a == 1) {
                m(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
            B(x4, y4, pointerId3);
            if (this.f12143a != 0) {
                if (u((int) x4, (int) y4)) {
                    M(this.s, pointerId3);
                    return;
                }
                return;
            } else {
                M(q((int) x4, (int) y4), pointerId3);
                int i8 = this.h[pointerId3];
                int i9 = this.p;
                if ((i8 & i9) != 0) {
                    this.r.h(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.f12143a == 1 && pointerId4 == this.c) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                if (pointerId5 != this.c) {
                    View viewQ3 = q((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2));
                    View view = this.s;
                    if (viewQ3 == view && M(view, pointerId5)) {
                        i = this.c;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                z();
            }
        }
        h(pointerId4);
    }

    public final void z() {
        this.l.computeCurrentVelocity(1000, this.m);
        m(e(VelocityTrackerCompat.getXVelocity(this.l, this.c), this.n, this.m), e(VelocityTrackerCompat.getYVelocity(this.l, this.c), this.n, this.m));
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public abstract int d(View view);

        public abstract int e(View view);

        public boolean g(int i) {
            return false;
        }

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);

        public int c(int i) {
            return i;
        }

        public void j(int i) {
        }

        public void f(int i, int i2) {
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i) {
        }

        public void k(View view, int i, int i2, int i3, int i4) {
        }
    }
}
