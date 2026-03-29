package cn.shuzilm.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class t extends BroadcastReceiver {
    private t() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getAction() == null) {
                return;
            }
            DUHelper.aXZlZWNl(context, intent);
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ t(k kVar) {
        this();
    }
}
