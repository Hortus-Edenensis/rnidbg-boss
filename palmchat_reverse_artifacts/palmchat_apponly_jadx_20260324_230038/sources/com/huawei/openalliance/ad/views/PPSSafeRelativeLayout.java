package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jw;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class PPSSafeRelativeLayout extends RelativeLayout {
    private AdContentData Code;
    private long V;

    public PPSSafeRelativeLayout(Context context) {
        super(context);
        this.V = 0L;
    }

    public void b() {
        try {
            if (z.V(this.Code) && getClass().getSimpleName().equals("AppDownloadButton")) {
                return;
            }
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSafeRelativeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSafeRelativeLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fh.V(PPSSafeRelativeLayout.this.getTAG(), "checkValidDisplay, cheating: %s", Boolean.valueOf(jw.Code(PPSSafeRelativeLayout.this.getContext(), PPSSafeRelativeLayout.this.Code, stackTrace, PPSSafeRelativeLayout.this, jw.I).Code()));
                        }
                    });
                }
            });
        } catch (Throwable th) {
            fh.I(getTAG(), "checkValidDisplay ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
        } catch (Throwable th) {
            fh.I(getTAG(), "check touch ex: %s", th.getClass().getSimpleName());
        }
        if (System.currentTimeMillis() - this.V < 10000) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.V = System.currentTimeMillis();
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSafeRelativeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                fh.Code(PPSSafeRelativeLayout.this.getTAG(), "dispatchTouch, cheating: %s", Boolean.valueOf(jw.Code(PPSSafeRelativeLayout.this.getContext(), PPSSafeRelativeLayout.this.Code, stackTrace, PPSSafeRelativeLayout.this, jw.Code).Code()));
            }
        });
        return super.dispatchTouchEvent(motionEvent);
    }

    public abstract String getTAG();

    @Override // android.view.View
    public boolean performClick() {
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSafeRelativeLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    fh.Code(PPSSafeRelativeLayout.this.getTAG(), "performClick, cheating: %s", Boolean.valueOf(jw.Code(PPSSafeRelativeLayout.this.getContext(), PPSSafeRelativeLayout.this.Code, stackTrace, PPSSafeRelativeLayout.this, jw.V).Code()));
                }
            });
        } catch (Throwable th) {
            fh.I(getTAG(), "check click ex: %s", th.getClass().getSimpleName());
        }
        return super.performClick();
    }

    public void setAdData(AdContentData adContentData) {
        this.Code = adContentData;
    }

    public PPSSafeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = 0L;
    }

    public PPSSafeRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = 0L;
    }

    @SuppressLint({"NewApi"})
    public PPSSafeRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.V = 0L;
    }
}
