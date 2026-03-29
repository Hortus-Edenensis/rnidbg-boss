package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.umeng.analytics.pro.dn;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7857a = "e";

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7858a;
        public final boolean b;

        public a(String str, boolean z) {
            this.f7858a = str;
            this.b = z;
        }
    }

    public static a a(Context context, String str, MonitorEvent monitorEvent) {
        String strA = str;
        for (String str2 : c.f7856a) {
            String strB = b(context, str2, monitorEvent);
            if (strB != null) {
                strA = a(strA, str2, b(strB));
            }
        }
        return new a(strA, a(str));
    }

    public static String b(Context context) {
        String strB = com.opos.cmn.an.h.e.a.b(context);
        return ("none".equals(strB) || TextUtils.isEmpty(strB)) ? GrsBaseInfo.CountryCodeSource.UNKNOWN : strB;
    }

    private static String c(Context context) {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c(f7857a, "getUA", e);
            return "";
        }
    }

    public static String a(Context context) {
        String strH = com.opos.cmn.an.h.c.a.h(context);
        return ("none".equals(strH) || TextUtils.isEmpty(strH)) ? GrsBaseInfo.CountryCodeSource.UNKNOWN : strH.toUpperCase();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String b(Context context, String str, MonitorEvent monitorEvent) {
        String str2;
        String str3;
        int iH;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 37701:
                if (str.equals("$c$")) {
                    b = 0;
                }
                break;
            case 37856:
                if (str.equals("$h$")) {
                    b = 1;
                }
                break;
            case 38011:
                if (str.equals("$m$")) {
                    b = 2;
                }
                break;
            case 38228:
                if (str.equals("$t$")) {
                    b = 3;
                }
                break;
            case 38321:
                if (str.equals("$w$")) {
                    b = 4;
                }
                break;
            case 1169294:
                if (str.equals("$as$")) {
                    b = 5;
                }
                break;
            case 1169387:
                if (str.equals("$av$")) {
                    b = 6;
                }
                break;
            case 1169790:
                if (str.equals("$bd$")) {
                    b = 7;
                }
                break;
            case 1170658:
                if (str.equals("$ca$")) {
                    b = 8;
                }
                break;
            case 1170906:
                if (str.equals("$ci$")) {
                    b = 9;
                }
                break;
            case 1171123:
                if (str.equals("$cp$")) {
                    b = 10;
                }
                break;
            case 1171185:
                if (str.equals("$cr$")) {
                    b = 11;
                }
                break;
            case 1171247:
                if (str.equals("$ct$")) {
                    b = 12;
                }
                break;
            case 1172332:
                if (str.equals("$dx$")) {
                    b = dn.k;
                }
                break;
            case 1172363:
                if (str.equals("$dy$")) {
                    b = dn.l;
                }
                break;
            case 1177912:
                if (str.equals("$jr$")) {
                    b = 15;
                }
                break;
            case 1181818:
                if (str.equals("$nt$")) {
                    b = 16;
                }
                break;
            case 1182748:
                if (str.equals("$os$")) {
                    b = 17;
                }
                break;
            case 1182841:
                if (str.equals("$ov$")) {
                    b = 18;
                }
                break;
            case 1185228:
                if (str.equals("$rf$")) {
                    b = 19;
                }
                break;
            case 1185259:
                if (str.equals("$rg$")) {
                    b = 20;
                }
                break;
            case 1187956:
                if (str.equals("$ua$")) {
                    b = 21;
                }
                break;
            case 1188669:
                if (str.equals("$ux$")) {
                    b = 22;
                }
                break;
            case 1188700:
                if (str.equals("$uy$")) {
                    b = 23;
                }
                break;
            case 36560847:
                if (str.equals("$lan$")) {
                    b = 24;
                }
                break;
            case 36689404:
                if (str.equals("$pkg$")) {
                    b = 25;
                }
                break;
            case 546794483:
                if (str.equals("$progress$")) {
                    b = 26;
                }
                break;
            case 1125369693:
                if (str.equals("$ckid$")) {
                    b = 27;
                }
                break;
            case 1978886681:
                if (str.equals("__CONTENT__")) {
                    b = 28;
                }
                break;
        }
        switch (b) {
            case 0:
                return com.opos.cmn.an.c.b.b();
            case 1:
                try {
                    return String.valueOf(com.opos.cmn.an.h.f.a.c(context));
                } catch (Exception e) {
                    e = e;
                    str2 = f7857a;
                    str3 = "get height fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case 2:
                return com.opos.cmn.an.c.c.a();
            case 3:
                return String.valueOf(System.currentTimeMillis());
            case 4:
                try {
                    return String.valueOf(com.opos.cmn.an.h.f.a.b(context));
                } catch (Exception e2) {
                    e = e2;
                    str2 = f7857a;
                    str3 = "get width fail";
                    com.opos.cmn.an.f.a.b(str2, str3, e);
                    return String.valueOf(0);
                }
            case 5:
                return monitorEvent.i();
            case 6:
                return com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
            case 7:
                return com.opos.cmn.biz.a.b.a(context);
            case 8:
                return b(context);
            case 9:
                iH = monitorEvent.h();
                return String.valueOf(iH);
            case 10:
                return monitorEvent.f();
            case 11:
                return monitorEvent.g();
            case 12:
            case 19:
                return "";
            case 13:
                iH = monitorEvent.b();
                return String.valueOf(iH);
            case 14:
                iH = monitorEvent.c();
                return String.valueOf(iH);
            case 15:
                return monitorEvent.j();
            case 16:
                return a(context);
            case 17:
                return "android";
            case 18:
                return com.opos.cmn.an.c.c.c();
            case 20:
                return com.opos.cmn.biz.a.d.a(context);
            case 21:
                return c(context);
            case 22:
                iH = monitorEvent.d();
                return String.valueOf(iH);
            case 23:
                iH = monitorEvent.e();
                return String.valueOf(iH);
            case 24:
                return com.opos.cmn.an.c.b.a();
            case 25:
                return context.getPackageName();
            case 26:
                iH = monitorEvent.a();
                return String.valueOf(iH);
            case 27:
                return UUID.randomUUID().toString() + System.currentTimeMillis();
            case 28:
                return monitorEvent.k();
            default:
                return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, -1, false);
    }

    private static String b(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 0) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String a(String str, String str2, String str3, int i, boolean z) {
        String lowerCase;
        int i2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str3 == null || i == 0) {
            return str;
        }
        if (z) {
            lowerCase = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            lowerCase = str;
        }
        int i3 = 0;
        int iIndexOf = lowerCase.indexOf(str2, 0);
        if (iIndexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i < 0) {
            i2 = 16;
        } else {
            i2 = 64;
            if (i <= 64) {
                i2 = i;
            }
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * i2));
        while (iIndexOf != -1) {
            sb.append(str.substring(i3, iIndexOf));
            sb.append(str3);
            i3 = iIndexOf + length;
            i--;
            if (i == 0) {
                break;
            }
            iIndexOf = lowerCase.indexOf(str2, i3);
        }
        sb.append(str.substring(i3));
        return sb.toString();
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("mix_in") >= 0;
    }
}
