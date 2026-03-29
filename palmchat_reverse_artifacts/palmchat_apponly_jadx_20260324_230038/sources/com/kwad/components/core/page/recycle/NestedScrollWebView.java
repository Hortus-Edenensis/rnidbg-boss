package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int WE;
    private int WF;
    private final int[] WG;
    private final int[] WH;
    private int WI;
    private boolean WJ;
    private int WK;
    private int WL;
    private NestedScrollingChildHelper WM;
    private VelocityTracker WN;
    private int WO;

    public NestedScrollWebView(Context context) {
        super(context);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }

    private void sG() {
        this.WO = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.WM = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.WL = viewConfiguration.getScaledMaximumFlingVelocity();
        this.WK = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.WM.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.WM.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.WM.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.WM.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.WM.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.WM.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.WO != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.k((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (com.kwad.components.core.s.d.ux() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.WO, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent;
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.WI = 0;
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.WI);
        if (actionMasked == 0) {
            this.WE = y;
            this.WF = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.WH;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.WG;
            iArr2[0] = 0;
            iArr2[1] = 0;
            zOnTouchEvent = super.onTouchEvent(motionEvent);
            this.WJ = false;
        } else if (actionMasked == 1) {
            this.WN.addMovement(motionEvent);
            this.WN.computeCurrentVelocity(1000, this.WL);
            float f = -VelocityTrackerCompat.getYVelocity(this.WN, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.WK && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean zOnTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.WE) < 10.0f) {
                Math.abs(motionEvent.getX() - this.WF);
            }
            zOnTouchEvent = zOnTouchEvent2;
            z = true;
        } else if (actionMasked == 2) {
            int i = this.WE - y;
            if (dispatchNestedPreScroll(0, i, this.WH, this.WG)) {
                i -= this.WH[1];
                motionEventObtain.offsetLocation(0.0f, this.WG[1]);
                this.WI += this.WG[1];
            }
            int scrollY = getScrollY();
            this.WE = y - this.WG[1];
            int iMax = Math.max(0, scrollY + i);
            int i2 = i - (iMax - scrollY);
            if (dispatchNestedScroll(0, iMax - i2, 0, i2, this.WG)) {
                int i3 = this.WE;
                int i4 = this.WG[1];
                this.WE = i3 - i4;
                motionEventObtain.offsetLocation(0.0f, i4);
                this.WI += this.WG[1];
            }
            if (Math.abs(this.WH[1]) >= 5 || Math.abs(this.WG[1]) >= 5) {
                if (!this.WJ) {
                    this.WJ = true;
                    super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                }
                zOnTouchEvent = false;
            } else {
                if (this.WJ) {
                    this.WJ = false;
                    zOnTouchEvent = false;
                } else {
                    zOnTouchEvent = super.onTouchEvent(motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        } else if (actionMasked != 3) {
            if (actionMasked != 5) {
                zOnTouchEvent = false;
            } else {
                stopNestedScroll();
                zOnTouchEvent = super.onTouchEvent(motionEvent);
            }
        }
        if (!z) {
            this.WN.addMovement(motionEvent);
        }
        return zOnTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.WM.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.WM.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.WM.stopNestedScroll();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }
}
