package com.zenmen.palmchat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.m5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12072a = true;
    public BroadcastReceiver b = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ((intent != null ? intent.getAction() : null).equals(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY)) {
                BaseActivity.this.finish();
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    public void b(BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        m5.c(this, bundle);
        super.onCreate(bundle);
        a(this.b, new IntentFilter(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
    }

    @Override // android.app.Activity
    public void onDestroy() {
        b(this.b);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f12072a = true;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12072a = false;
    }
}
