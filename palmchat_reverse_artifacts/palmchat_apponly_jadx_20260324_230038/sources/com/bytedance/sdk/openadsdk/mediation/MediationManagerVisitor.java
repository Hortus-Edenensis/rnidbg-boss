package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.nr.u.u.nr;
import com.bytedance.sdk.openadsdk.my.u.u.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationManagerVisitor {
    private static volatile Object nr;
    private static volatile MediationManagerVisitor u;
    private nr fx;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (u == null) {
            synchronized (MediationManagerVisitor.class) {
                if (u == null) {
                    u = new MediationManagerVisitor();
                }
            }
        }
        return u;
    }

    public synchronized IMediationManager getMediationManager() {
        Bundle bundle = new Bundle();
        bundle.putString("mediation_manager", "mediation_manager");
        TTAdManager adManager = TTAdSdk.getAdManager();
        Object obj = nr;
        if (adManager != null) {
            nr = adManager.getExtra(null, bundle);
        }
        if (nr == null) {
            return null;
        }
        if (this.fx == null) {
            this.fx = new nr(k.u(nr));
        } else if (obj != nr) {
            this.fx.u(k.u(nr));
        }
        return this.fx;
    }
}
