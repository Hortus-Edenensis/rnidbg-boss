package com.bytedance.sdk.openadsdk.core.playable.nr;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private boolean b;
    private boolean u;
    private long nr = 0;
    private long fx = 0;

    public nr(String str) {
        this.b = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public boolean nr(Activity activity, bc bcVar) {
        boolean zU = false;
        if (activity != null && bcVar != null) {
            boolean z = this.u;
            this.u = false;
            if (!bcVar.l() || !z) {
                return false;
            }
            if (u.u(activity) || nr()) {
                return true;
            }
            try {
                if (!this.b || !u.u()) {
                    zU = u(activity);
                }
            } catch (Throwable unused) {
            }
        }
        return zU;
    }

    public void u(final Activity activity, bc bcVar) {
        if (activity == null || bcVar == null || !bcVar.l()) {
            return;
        }
        y.fx(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.nr.nr.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        nr.this.u();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.nr.nr.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y.fx(activity);
                                }
                            }, 5000L);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void u(int i) {
        boolean z = i == 4;
        this.u = z;
        if (z) {
            this.nr = System.currentTimeMillis();
        }
    }

    public void u() {
        this.fx = System.currentTimeMillis();
    }

    private boolean u(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean nr() {
        long j = this.nr;
        long jAbs = j > 0 ? Math.abs(j - this.fx) : -1L;
        return jAbs >= 0 && jAbs < 300;
    }
}
