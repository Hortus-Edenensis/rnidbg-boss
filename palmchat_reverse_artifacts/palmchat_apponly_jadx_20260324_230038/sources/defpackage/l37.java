package defpackage;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.m.u.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l37 {
    public static l37 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18899a;

    public l37(Context context) {
        try {
            try {
                String macAddress = rz6.e(null, context).getMacAddress();
                this.f18899a = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e) {
                w97.d(e);
                if (!TextUtils.isEmpty(this.f18899a)) {
                    return;
                }
            }
            this.f18899a = "00:00:00:00:00:00";
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f18899a)) {
                this.f18899a = "00:00:00:00:00:00";
            }
            throw th;
        }
    }

    public static l37 a(Context context) {
        if (b == null) {
            b = new l37(context);
        }
        return b;
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static g e(Context context) {
        try {
            NetworkInfo networkInfoA = rz6.a(null, context);
            return (networkInfoA == null || networkInfoA.getType() != 0) ? (networkInfoA == null || networkInfoA.getType() != 1) ? g.NONE : g.WIFI : g.a(networkInfoA.getSubtype());
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String f() {
        return this.f18899a;
    }
}
