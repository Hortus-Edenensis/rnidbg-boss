package com.bytedance.sdk.openadsdk.core.component.reward.business.fx;

import android.os.Bundle;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static fx u;
    private Map<Integer, Bundle> nr = DesugarCollections.synchronizedMap(new HashMap());

    private fx() {
    }

    public static synchronized fx u() {
        if (u == null) {
            u = new fx();
        }
        return u;
    }

    public void nr(int i) {
        this.nr.remove(Integer.valueOf(i));
    }

    public void u(int i, Bundle bundle) {
        this.nr.put(Integer.valueOf(i), bundle);
    }

    public Bundle u(int i) {
        return this.nr.get(Integer.valueOf(i));
    }
}
