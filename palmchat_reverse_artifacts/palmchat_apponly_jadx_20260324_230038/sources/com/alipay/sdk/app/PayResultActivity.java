package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import defpackage.ru6;
import defpackage.w97;
import defpackage.xt6;
import defpackage.xz6;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PayResultActivity extends Activity {
    public static final HashMap<String, Object> b = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ru6 f2580a = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f2581a;

        public a(Activity activity) {
            this.f2581a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2581a.finish();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static volatile String f2582a;
        public static volatile String b;
    }

    public static void a(Activity activity, int i) {
        new Handler().postDelayed(new a(activity), i);
    }

    public static void b(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage("hk.alipay.wallet");
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e) {
            w97.d(e);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    public static void c(String str) {
        b.b = xz6.a();
        e(b, str);
    }

    public static void d(String str, String str2) {
        b.b = str;
        e(b, str2);
    }

    public static boolean e(HashMap<String, Object> map, String str) {
        Object obj;
        if (map == null || str == null || (obj = map.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra("orderSuffix"))) {
                b.f2582a = intent.getStringExtra("phonecashier.pay.hash");
                String stringExtra = intent.getStringExtra("orderSuffix");
                String stringExtra2 = intent.getStringExtra("externalPkgName");
                ru6 ru6VarA = ru6.a.a(intent);
                this.f2580a = ru6VarA;
                if (ru6VarA == null) {
                    finish();
                }
                b(this, b.f2582a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.f2580a == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra("phonecashier.pay.result");
            int intExtra = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
            if (intExtra != 0 && TextUtils.equals(b.f2582a, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    c(b.f2582a);
                } else {
                    d(stringExtra3, b.f2582a);
                }
                b.f2582a = "";
                a(this, 300);
                return;
            }
            xt6.g(this.f2580a, "biz", "SchemePayWrongHashEx", "Expected " + b.f2582a + ", got " + intExtra);
            c(b.f2582a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }
}
