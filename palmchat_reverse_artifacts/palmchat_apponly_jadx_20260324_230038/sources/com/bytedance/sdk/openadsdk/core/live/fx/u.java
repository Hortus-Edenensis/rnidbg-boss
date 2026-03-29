package com.bytedance.sdk.openadsdk.core.live.fx;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.s.b;
import com.bytedance.sdk.openadsdk.core.s.n;
import com.huawei.openalliance.ad.constant.az;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private String u = "";

    public u u(String str) {
        this.u = str;
        return this;
    }

    public void u(final Context context, final bc bcVar) {
        if (bcVar == null || bcVar.kv() == null || TextUtils.isEmpty(bcVar.kv().nr())) {
            return;
        }
        bg.iz().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.fx.u.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(bcVar.kv().nr()));
                    intent.addFlags(268435456);
                    if (com.bytedance.sdk.component.utils.nr.u(context, intent, null, TextUtils.equals("main", UMModuleRegister.INNER))) {
                        b.u(bcVar, u.this.u, "deeplink_success_realtime", (Throwable) null);
                    } else {
                        b.u(bcVar, u.this.u, "deeplink_fail_realtime", (Throwable) null);
                    }
                    HashMap map = new HashMap();
                    map.put(az.at, "LiveDoubleOpenProcessor");
                    b.n(bcVar, u.this.u, "open_url_app", map);
                    n.u().u(bcVar, u.this.u, false);
                } catch (Throwable unused) {
                }
            }
        }, 50L);
    }
}
