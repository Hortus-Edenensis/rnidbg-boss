package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SSWebViewVideoPage extends SSWebView {
    private float iz;
    private ViewParent n;
    private boolean pn;
    private boolean x;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.pn = true;
        this.iz = -1.0f;
        this.x = false;
    }

    public void iz() {
        if (this.x) {
            return;
        }
        this.n.requestDisallowInterceptTouchEvent(true);
        this.x = true;
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.pn = true;
        } else {
            this.pn = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.n == null) {
            this.n = u((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.iz = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.iz;
            if (y > 0.0f) {
                u(true);
            } else if (y != 0.0f && y < 0.0f) {
                u(false);
            }
            this.iz = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            iz();
            this.x = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void u(boolean z) {
        if (((ScrollView) this.n).getScrollY() == 0) {
            if (z) {
                iz();
                return;
            } else {
                x();
                return;
            }
        }
        if (!this.pn) {
            iz();
        } else if (z) {
            x();
        } else {
            iz();
        }
    }

    public void x() {
        if (this.x) {
            return;
        }
        this.n.requestDisallowInterceptTouchEvent(false);
        this.x = true;
    }
}
