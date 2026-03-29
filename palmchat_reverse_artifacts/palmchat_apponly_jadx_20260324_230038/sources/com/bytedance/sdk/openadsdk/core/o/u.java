package com.bytedance.sdk.openadsdk.core.o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u u;

    private u() {
    }

    private void nr(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("com.bytedance.minigame.preload.action");
            b bVarU = nr.u().u(context);
            intent.putExtra("key_preload_info", fx.u(bVarU.nr, bVarU.u, str));
            intent.putExtra("key_preload_code", bVarU.fx);
            context.sendBroadcast(intent);
            k.nr("onPreloadFinish", "tryPreload finish1");
        } catch (Exception unused) {
        }
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    public void u(Context context, String str) {
        if (!dw.nr().fx() || TextUtils.isEmpty(str)) {
            return;
        }
        u().nr(context, str);
    }
}
