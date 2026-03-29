package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<u> u;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<u> weakReference = this.u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.u.get().b_(intExtra);
    }

    public void u(u uVar) {
        this.u = new WeakReference<>(uVar);
    }
}
