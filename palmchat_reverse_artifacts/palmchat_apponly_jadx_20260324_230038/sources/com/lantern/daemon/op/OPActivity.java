package com.lantern.daemon.op;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import defpackage.pt0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OPActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BroadcastReceiver f7538a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d(pt0.f20091a, "BroadcastReceiver OPActivity finish");
            OPActivity.this.finish();
        }
    }

    public final boolean a(String str) {
        String str2 = pt0.f20091a;
        Log.d(str2, "from call method: " + str);
        boolean zIsScreenOn = ((PowerManager) getSystemService("power")).isScreenOn();
        Log.d(str2, "isScreenOn: " + zIsScreenOn);
        if (zIsScreenOn) {
            finish();
        }
        Intent intent = new Intent("ONEPIXEL_ACTION_LOG");
        intent.putExtra("funId", "1px_" + str);
        intent.putExtra("screen", zIsScreenOn);
        sendBroadcast(intent);
        return zIsScreenOn;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        a aVar = new a();
        this.f7538a = aVar;
        registerReceiver(aVar, new IntentFilter("ONEPIXEL_ACTION_FINISH_ACTIVITY"));
        a("onCreate");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Log.d(pt0.f20091a, "onDestroy");
        try {
            unregisterReceiver(this.f7538a);
        } catch (IllegalArgumentException unused) {
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a("onResume");
    }
}
