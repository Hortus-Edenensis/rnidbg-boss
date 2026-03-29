package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import defpackage.fv2;
import defpackage.k63;
import defpackage.m5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DownloadActivity extends Activity {
    private static final String TAG = "DownloadActivity";

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        m5.c(this, bundle);
        super.onCreate(bundle);
        k63.a(TAG, "DownloadActivity onCreate");
        try {
            fv2.r(getApplicationContext(), getIntent());
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k63.a(TAG, "DownloadActivity onNewIntent");
        try {
            fv2.r(getApplicationContext(), intent);
        } catch (Throwable unused) {
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
    }
}
