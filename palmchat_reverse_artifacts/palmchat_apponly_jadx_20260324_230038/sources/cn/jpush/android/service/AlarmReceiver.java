package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import defpackage.h9;
import defpackage.k63;
import defpackage.tv2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k63.a(TAG, "onReceive");
        if (!tv2.h.get()) {
            k63.b(TAG, "please call init");
        } else {
            h9.b(context);
            JCoreManager.onEvent(context, "JCore", 10, "a2", null, new Object[0]);
        }
    }
}
