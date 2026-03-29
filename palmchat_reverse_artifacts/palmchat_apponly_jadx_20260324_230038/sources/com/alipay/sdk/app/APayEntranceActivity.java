package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import defpackage.ru6;
import defpackage.xt6;
import defpackage.xz6;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class APayEntranceActivity extends Activity {
    public static final ConcurrentHashMap<String, a> d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2573a;
    public String b;
    public ru6 c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.b;
        xt6.b(this.c, "biz", "BSAFinish", str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + TextUtils.isEmpty(this.f2573a));
        if (TextUtils.isEmpty(this.f2573a)) {
            this.f2573a = xz6.a();
        }
        if (str != null) {
            a aVarRemove = d.remove(str);
            if (aVarRemove != null) {
                aVarRemove.a(this.f2573a);
            } else {
                xt6.g(this.c, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th) {
            xt6.c(this.c, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        xt6.b(this.c, "biz", "BSAOnAR", this.b + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i + "," + i2);
        if (i == 1000) {
            if (intent != null) {
                try {
                    this.f2573a = intent.getStringExtra("result");
                } catch (Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString("ap_order_info");
            String string2 = extras.getString("ap_target_packagename");
            this.b = extras.getString("ap_session");
            String string3 = extras.getString("ap_local_info", "{}");
            if (!TextUtils.isEmpty(this.b)) {
                ru6 ru6VarB = ru6.a.b(this.b);
                this.c = ru6VarB;
                xt6.b(ru6VarB, "biz", "BSAEntryCreate", this.b + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th) {
                xt6.c(this.c, "wr", "APStartEx", th);
                finish();
            }
            if (this.c != null) {
                Context applicationContext = getApplicationContext();
                ru6 ru6Var = this.c;
                xt6.f(applicationContext, ru6Var, string, ru6Var.d);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
