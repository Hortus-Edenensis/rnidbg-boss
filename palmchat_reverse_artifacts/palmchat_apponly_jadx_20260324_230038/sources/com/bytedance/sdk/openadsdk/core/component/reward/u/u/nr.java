package com.bytedance.sdk.openadsdk.core.component.reward.u.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.b.nr.fx;
import com.bytedance.sdk.openadsdk.core.y.bf;
import com.bytedance.sdk.openadsdk.core.y.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static final fx u = bf.u("full_reward_adslot");

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr u(String str) {
        try {
            return h.u(u.get(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void u(String str, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (nrVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                u.put(str, h.u(nrVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
