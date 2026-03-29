package com.bytedance.sdk.openadsdk.core.y;

import android.content.Intent;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    private static volatile k u;
    private com.bytedance.sdk.component.b.nr.fx nr;

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.b.nr.fx nr() {
        if (this.nr == null) {
            this.nr = bf.u("hide_recent_activity_recorder");
        }
        return this.nr;
    }

    public static k u() {
        if (u == null) {
            synchronized (k.class) {
                if (u == null) {
                    u = new k();
                }
            }
        }
        return u;
    }

    public void u(Intent intent) {
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.k.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = k.this.nr().get("all_activity_count", 0) + 1;
                if (z) {
                    int i3 = k.this.nr().get("hide_activity_count", 0) + 1;
                    if (i3 >= 10) {
                        k.this.u(i2);
                        i2 = 0;
                    } else {
                        i = i3;
                    }
                    k.this.nr().put("hide_activity_count", i);
                }
                k.this.nr().put("all_activity_count", i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final int i) {
        try {
            com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.y.k.2
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OapsKey.KEY_ACTIVE_CODE, i);
                    return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("hide_activity_record").nr(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
