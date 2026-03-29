package com.bytedance.sdk.openadsdk.core.miniapp;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u u;
    private String nr = "";

    private u() {
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

    public String nr() {
        return this.nr;
    }

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme("package");
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            context.registerReceiver(miniAppBroadcastReceiver, intentFilter, jp.z(), null);
        } catch (Throwable th) {
            k.nr("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public void u(String str) {
        this.nr = str;
    }
}
