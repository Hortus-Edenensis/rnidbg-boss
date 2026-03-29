package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import defpackage.m5;
import defpackage.p63;
import defpackage.vx2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DActivity extends Activity {
    private static final String TAG = "DActivity";

    private void handleStart() {
        try {
            vx2.b(getApplicationContext(), getIntent() != null ? getIntent().getExtras() : null, 8);
        } catch (Throwable th) {
            p63.a(TAG, "handle start error#" + th);
        }
        try {
            finish();
        } catch (Throwable th2) {
            p63.a(TAG, "finish error#" + th2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        m5.c(this, bundle);
        super.onCreate(bundle);
        p63.a(TAG, "DActivity oncreate");
        handleStart();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        p63.a(TAG, "DActivity onNewIntent");
        handleStart();
    }
}
