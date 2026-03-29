package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private u u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("reason");
                if ("homekey".equals(stringExtra) || "recentapps".equals(stringExtra)) {
                    return;
                }
                "assist".equals(stringExtra);
            }
        } catch (Throwable unused) {
            k.nr("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
