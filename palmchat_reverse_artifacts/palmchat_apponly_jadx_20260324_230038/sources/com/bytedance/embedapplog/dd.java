package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class dd {
    private final SharedPreferences u;

    @WorkerThread
    public dd(Context context) {
        this.u = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "device_register_oaid_refine", 0);
    }

    @WorkerThread
    public void u(@Nullable qf qfVar) {
        if (qfVar == null) {
            return;
        }
        this.u.edit().putString("oaid", qfVar.nr().toString()).apply();
    }

    @Nullable
    @WorkerThread
    public qf u() {
        return qf.u(this.u.getString("oaid", ""));
    }
}
