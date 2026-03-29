package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.c;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.lantern.auth.server.WkParams;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.bu6;
import defpackage.f17;
import defpackage.o27;
import defpackage.t47;
import defpackage.w87;
import defpackage.xu6;
import defpackage.y87;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2558a;
    public com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    public int c = 4;

    public a(Context context) {
        this.f2558a = context;
    }

    private t47 b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b bVarB;
        b bVarC;
        String str4 = "";
        try {
            Context context = this.f2558a;
            y87 y87Var = new y87();
            String strB = xu6.b(map, WfConstant.EVENT_KEY_APP_NAME, "");
            String strB2 = xu6.b(map, WkParams.SESSIONID, "");
            String strB3 = xu6.b(map, "rpcVersion", "");
            String strA = a(context, strB);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String strD = h.d(context);
            if (xu6.f(strB2)) {
                y87Var.c = strB2;
            } else {
                y87Var.c = strA;
            }
            y87Var.d = securityToken;
            y87Var.e = strD;
            y87Var.f22163a = "android";
            c cVarC = d.c(context);
            if (cVarC != null) {
                str2 = cVarC.f2562a;
                str = cVarC.c;
            } else {
                str = "";
                str2 = str;
            }
            if (xu6.c(str2) && (bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = bVarC.f2561a;
                str = bVarC.c;
            }
            c cVarB = d.b();
            if (cVarB != null) {
                str4 = cVarB.f2562a;
                str3 = cVarB.c;
            } else {
                str3 = "";
            }
            if (xu6.c(str4) && (bVarB = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = bVarB.f2561a;
                str3 = bVarB.c;
            }
            y87Var.h = str2;
            y87Var.g = str4;
            y87Var.j = strB3;
            if (xu6.c(str2)) {
                y87Var.b = str4;
                str = str3;
            } else {
                y87Var.b = str2;
            }
            y87Var.i = str;
            y87Var.f = e.a(context, map);
            return w87.c(this.f2558a, this.b.c()).a(y87Var);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01fc A[Catch: Exception -> 0x023b, TryCatch #0 {Exception -> 0x023b, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e2, B:71:0x01fc, B:74:0x0204, B:76:0x020a, B:80:0x0213, B:82:0x0219, B:40:0x00d2, B:42:0x00ea, B:48:0x00f7, B:49:0x0107, B:51:0x010e, B:55:0x0120, B:57:0x0170, B:59:0x017a, B:61:0x0182, B:63:0x018f, B:65:0x0199, B:67:0x01a1, B:66:0x019d, B:60:0x017e, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:88:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Map<String, String> map) {
        String strB;
        boolean z;
        boolean z2;
        int i;
        String str;
        bu6 bu6VarC;
        Context context;
        NetworkInfo activeNetworkInfo;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f2558a, xu6.b(map, "tid", ""), xu6.b(map, "utdid", ""), a(this.f2558a));
            strB = xu6.b(map, WfConstant.EVENT_KEY_APP_NAME, "");
            b();
            b(this.f2558a);
            a(this.f2558a, strB);
            i.a();
            z = false;
            if (a() || com.alipay.apmobilesecuritysdk.common.a.a(this.f2558a)) {
                z2 = xu6.c(a(this.f2558a, strB)) || xu6.c(b(this.f2558a));
            } else {
                e.a();
                if (!(!xu6.d(e.b(this.f2558a, map), i.c()))) {
                    String strB2 = xu6.b(map, "tid", "");
                    String strB3 = xu6.b(map, "utdid", "");
                    if ((xu6.f(strB2) && !xu6.d(strB2, i.d())) || ((xu6.f(strB3) && !xu6.d(strB3, i.e())) || !i.a(this.f2558a, strB) || xu6.c(a(this.f2558a, strB)) || xu6.c(b(this.f2558a)))) {
                    }
                }
            }
            Context context2 = this.f2558a;
            o27.e();
            h.b(context2, String.valueOf(o27.C()));
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        if (z2) {
            new com.alipay.apmobilesecuritysdk.c.b();
            UmidSdkWrapper.startUmidTaskSync(this.f2558a, com.alipay.apmobilesecuritysdk.b.a.a().b());
            t47 t47VarB = b(map);
            int iC = t47VarB != null ? t47VarB.c() : 2;
            if (iC != 1) {
                if (iC != 3) {
                    if (t47VarB != null) {
                        str = "Server error, result:" + t47VarB.b;
                    } else {
                        str = "Server error, returned null";
                    }
                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                    if (xu6.c(a(this.f2558a, strB))) {
                        i = 4;
                    }
                } else {
                    i = 1;
                }
                this.c = i;
                bu6VarC = w87.c(this.f2558a, this.b.c());
                context = this.f2558a;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                activeNetworkInfo = connectivityManager == null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) {
                    z = true;
                }
                if (z && h.c(context)) {
                    new f17(context.getFilesDir().getAbsolutePath() + "/log/ap", bu6VarC).b();
                }
                return this.c;
            }
            h.a(this.f2558a, t47VarB.b());
            h.d(this.f2558a, t47VarB.a());
            h.e(this.f2558a, t47VarB.g);
            h.a(this.f2558a, t47VarB.h);
            h.f(this.f2558a, t47VarB.i);
            h.g(this.f2558a, t47VarB.k);
            i.c(e.b(this.f2558a, map));
            i.a(strB, t47VarB.d);
            i.b(t47VarB.c);
            i.d(t47VarB.j);
            String strB4 = xu6.b(map, "tid", "");
            if (!xu6.f(strB4) || xu6.d(strB4, i.d())) {
                strB4 = i.d();
            } else {
                i.e(strB4);
            }
            i.e(strB4);
            String strB5 = xu6.b(map, "utdid", "");
            if (!xu6.f(strB5) || xu6.d(strB5, i.e())) {
                strB5 = i.e();
            } else {
                i.f(strB5);
            }
            i.f(strB5);
            i.a();
            d.a(this.f2558a, i.g());
            d.a();
            com.alipay.apmobilesecuritysdk.e.a.a(this.f2558a, new b(i.b(), i.c(), i.f()));
            com.alipay.apmobilesecuritysdk.e.a.a();
            g.a(this.f2558a, strB, i.a(strB));
            g.a();
            h.a(this.f2558a, strB, System.currentTimeMillis());
        }
        i = 0;
        this.c = i;
        bu6VarC = w87.c(this.f2558a, this.b.c());
        context = this.f2558a;
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager2 == null) {
        }
        if (activeNetworkInfo != null) {
            z = true;
        }
        if (z) {
            new f17(context.getFilesDir().getAbsolutePath() + "/log/ap", bu6VarC).b();
        }
        return this.c;
    }

    public static String a(Context context) {
        String strB = b(context);
        return xu6.c(strB) ? h.f(context) : strB;
    }

    public static String b(Context context) {
        try {
            String strB = i.b();
            if (!xu6.c(strB)) {
                return strB;
            }
            c cVarB = d.b(context);
            if (cVarB != null) {
                i.a(cVarB);
                String str = cVarB.f2562a;
                if (xu6.f(str)) {
                    return str;
                }
            }
            b bVarB = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (bVarB == null) {
                return "";
            }
            i.a(bVarB);
            String str2 = bVarB.f2561a;
            return xu6.f(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!xu6.c(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !xu6.c(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                String str = strArr[i];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i = 0; i < 3; i++) {
            try {
                String[] strArrSplit = strArr[i].split(" ");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
