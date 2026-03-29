package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.core.b;
import defpackage.ru6;
import defpackage.xt6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class H5OpenAuthActivity extends H5PayActivity {
    public boolean i = false;

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.i) {
            try {
                ru6 ru6VarA = ru6.a.a(getIntent());
                if (ru6VarA != null) {
                    xt6.h(this, ru6VarA, "", ru6VarA.d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            ru6 ru6VarA = ru6.a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                String string = (intent == null || intent.getData() == null) ? b.m : intent.getData().toString();
                if (ru6VarA != null) {
                    xt6.d(ru6VarA, "biz", "StartActivityEx", th, string);
                }
                this.i = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }
}
