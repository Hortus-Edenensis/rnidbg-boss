package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.f;
import defpackage.ru6;
import defpackage.xt6;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AlipayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f2574a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, String str, String str2);
    }

    public final void a(String str, Bundle bundle) {
        a aVarRemove = f2574a.remove(str);
        if (aVarRemove == null) {
            return;
        }
        try {
            aVarRemove.a(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra(f.aC);
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                ru6 ru6VarB = ru6.a.b(stringExtra);
                if (ru6VarB == null) {
                    finish();
                    return;
                }
                xt6.b(ru6VarB, "biz", "BSPSession", stringExtra + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        stringExtra = jSONObject.getString(f.aC);
                        xt6.b(ru6VarB, "biz", "BSPUriSession", stringExtra);
                        Bundle bundle2 = new Bundle();
                        try {
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (Throwable th2) {
                            th = th2;
                            bundleExtra = bundle2;
                            xt6.c(ru6VarB, "biz", "BSPResEx", th);
                            xt6.c(ru6VarB, "biz", "ParseSchemeQueryError", th);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    xt6.h(this, ru6VarB, "", ru6VarB.d);
                    finish();
                    return;
                }
                try {
                    xt6.b(ru6VarB, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                    xt6.b(ru6VarB, "biz", "PgReturnV", bundleExtra.getInt("endCode", -1) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + bundleExtra.getString("memo", "-"));
                    OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
                    xt6.h(this, ru6VarB, "", ru6VarB.d);
                    finish();
                } catch (Throwable th4) {
                    xt6.h(this, ru6VarB, "", ru6VarB.d);
                    finish();
                    throw th4;
                }
            } catch (Throwable th5) {
                xt6.c(null, "biz", "BSPSerError", th5);
                xt6.c(null, "biz", "ParseBundleSerializableError", th5);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
