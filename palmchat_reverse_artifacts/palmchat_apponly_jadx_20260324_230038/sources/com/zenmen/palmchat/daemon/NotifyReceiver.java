package com.zenmen.palmchat.daemon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NotifyReceiver extends BroadcastReceiver {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RuntimeException f13879a;

        public a(RuntimeException runtimeException) {
            this.f13879a = runtimeException;
            put("action", "startCoreService exception =  " + runtimeException.toString());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("NotifyReceiver", "onReceive action : " + intent.getAction());
        try {
            Intent intent2 = new Intent(context, (Class<?>) CoreService.class);
            intent2.putExtra("ACTION_KEY_START", intent.getAction());
            context.startService(intent2);
        } catch (RuntimeException e) {
            LogUtil.i("NotifyReceiver", 3, new a(e), (Throwable) null);
        }
    }
}
