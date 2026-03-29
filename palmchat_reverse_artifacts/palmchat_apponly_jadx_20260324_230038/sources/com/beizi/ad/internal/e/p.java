package com.beizi.ad.internal.e;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4431a = ".AD_CLK_PT_DOWN_X.";
    public static String b = ".AD_CLK_PT_DOWN_Y.";
    public static String c = ".AD_CLK_PT_UP_X.";
    public static String d = ".AD_CLK_PT_UP_Y.";
    public static String e = ".SCRN_CLK_PT_DOWN_X.";
    public static String f = ".SCRN_CLK_PT_DOWN_Y.";
    public static String g = ".SCRN_CLK_PT_UP_X.";
    public static String h = ".SCRN_CLK_PT_UP_Y.";
    public static String i = ".UTC_TS.";
    public static String j = ".AD_CLK_PT_DOWN_X_DP.";
    public static String k = ".AD_CLK_PT_DOWN_Y_DP.";
    public static String l = ".AD_CLK_PT_UP_X_DP.";
    public static String m = ".AD_CLK_PT_UP_Y_DP.";
    public static String n = ".SCRN_CLK_PT_DOWN_X_DP.";
    public static String o = ".SCRN_CLK_PT_DOWN_Y_DP.";
    public static String p = ".SCRN_CLK_PT_UP_X_DP.";
    public static String q = ".SCRN_CLK_PT_UP_Y_DP.";
    public static String r = ".EVENT_TS_START.";
    public static String s = ".EVENT_TS_END.";
    public static String t = ".VIDEO_DURATION.";
    public static String u = "__CLT__";
    public static String v = "__CLT-999__";

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url must no null");
        }
        if (str.contains(f4431a)) {
            str = str.replace(f4431a, str2);
        }
        if (str.contains(b)) {
            str = str.replace(b, str3);
        }
        if (str.contains(c)) {
            str = str.replace(c, str2);
        }
        if (str.contains(d)) {
            str = str.replace(d, str3);
        }
        if (str.contains(e)) {
            str = str.replace(e, str4);
        }
        if (str.contains(f)) {
            str = str.replace(f, str5);
        }
        if (str.contains(g)) {
            str = str.replace(g, str4);
        }
        if (str.contains(h)) {
            str = str.replace(h, str5);
        }
        if (str.contains(i)) {
            str = str.replace(i, String.valueOf(System.currentTimeMillis()));
        }
        if (str.contains(r)) {
            str = str.replace(r, str6);
        }
        if (str.contains(s)) {
            str = str.replace(s, str7);
        }
        return str.contains(t) ? str.replace(t, str8) : str;
    }

    public static String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (i2 == 2) {
                if (str.contains(u)) {
                    str2 = "0";
                    str3 = "0";
                    str4 = str3;
                    str5 = str4;
                }
                if (str.contains(v)) {
                    str2 = "-999";
                    str3 = "-999";
                    str4 = str3;
                    str5 = str4;
                }
            }
            if (str.contains(f4431a)) {
                str = str.replace(f4431a, str2);
            }
            if (str.contains(b)) {
                str = str.replace(b, str3);
            }
            if (str.contains(c)) {
                str = str.replace(c, str2);
            }
            if (str.contains(d)) {
                str = str.replace(d, str3);
            }
            if (str.contains(e)) {
                str = str.replace(e, str4);
            }
            if (str.contains(f)) {
                str = str.replace(f, str5);
            }
            if (str.contains(g)) {
                str = str.replace(g, str4);
            }
            if (str.contains(h)) {
                str = str.replace(h, str5);
            }
            if (str.contains(j)) {
                str = str.replace(j, a(com.beizi.ad.internal.c.a().j, str2));
            }
            if (str.contains(k)) {
                str = str.replace(k, a(com.beizi.ad.internal.c.a().j, str3));
            }
            if (str.contains(l)) {
                str = str.replace(l, a(com.beizi.ad.internal.c.a().j, str2));
            }
            if (str.contains(m)) {
                str = str.replace(m, a(com.beizi.ad.internal.c.a().j, str3));
            }
            if (str.contains(n)) {
                str = str.replace(n, a(com.beizi.ad.internal.c.a().j, str4));
            }
            if (str.contains(o)) {
                str = str.replace(o, a(com.beizi.ad.internal.c.a().j, str5));
            }
            if (str.contains(p)) {
                str = str.replace(p, a(com.beizi.ad.internal.c.a().j, str4));
            }
            if (str.contains(q)) {
                str = str.replace(q, a(com.beizi.ad.internal.c.a().j, str5));
            }
            if (str.contains(u)) {
                str = str.replace(u, String.valueOf(i2));
            }
            if (str.contains(v)) {
                str = str.replace(v, String.valueOf(i2));
            }
            if (str.contains(i)) {
                str = str.replace(i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(r)) {
                str = str.replace(r, str6);
            }
            if (str.contains(s)) {
                str = str.replace(s, str7);
            }
            return str.contains(t) ? str.replace(t, str8) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(String str, com.beizi.ad.model.d dVar, String str2, String str3, String str4) {
        if (str.contains(f4431a) && !TextUtils.isEmpty(dVar.a())) {
            str = str.replace(f4431a, dVar.a());
        }
        if (str.contains(b) && !TextUtils.isEmpty(dVar.b())) {
            str = str.replace(b, dVar.b());
        }
        if (str.contains(c) && !TextUtils.isEmpty(dVar.e())) {
            str = str.replace(c, dVar.e());
        }
        if (str.contains(d) && !TextUtils.isEmpty(dVar.f())) {
            str = str.replace(d, dVar.f());
        }
        if (str.contains(e) && !TextUtils.isEmpty(dVar.c())) {
            str = str.replace(e, dVar.c());
        }
        if (str.contains(f) && !TextUtils.isEmpty(dVar.d())) {
            str = str.replace(f, dVar.d());
        }
        if (str.contains(g) && !TextUtils.isEmpty(dVar.g())) {
            str = str.replace(g, dVar.g());
        }
        if (str.contains(h) && !TextUtils.isEmpty(dVar.h())) {
            str = str.replace(h, dVar.h());
        }
        if (str.contains(j) && !TextUtils.isEmpty(dVar.a())) {
            str = str.replace(j, a(com.beizi.ad.internal.c.a().j, dVar.a()));
        }
        if (str.contains(k) && !TextUtils.isEmpty(dVar.b())) {
            str = str.replace(k, a(com.beizi.ad.internal.c.a().j, dVar.b()));
        }
        if (str.contains(l) && !TextUtils.isEmpty(dVar.e())) {
            str = str.replace(l, a(com.beizi.ad.internal.c.a().j, dVar.e()));
        }
        if (str.contains(m) && !TextUtils.isEmpty(dVar.f())) {
            str = str.replace(m, a(com.beizi.ad.internal.c.a().j, dVar.f()));
        }
        if (str.contains(n) && !TextUtils.isEmpty(dVar.c())) {
            str = str.replace(n, a(com.beizi.ad.internal.c.a().j, dVar.c()));
        }
        if (str.contains(o) && !TextUtils.isEmpty(dVar.d())) {
            str = str.replace(o, a(com.beizi.ad.internal.c.a().j, dVar.d()));
        }
        if (str.contains(p) && !TextUtils.isEmpty(dVar.g())) {
            str = str.replace(p, a(com.beizi.ad.internal.c.a().j, dVar.g()));
        }
        return (!str.contains(q) || TextUtils.isEmpty(dVar.h())) ? str : str.replace(q, a(com.beizi.ad.internal.c.a().j, dVar.h()));
    }

    public static String a(String str, com.beizi.ad.model.d dVar, String str2, String str3, String str4, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (i2 != 2 && i2 != 5) {
                str = a(str, dVar, str2, str3, str4);
            } else {
                com.beizi.ad.model.d dVar2 = new com.beizi.ad.model.d();
                if (str.contains(u)) {
                    dVar2.a("0");
                    dVar2.b("0");
                    dVar2.c("0");
                    dVar2.d("0");
                    dVar2.e("0");
                    dVar2.f("0");
                    dVar2.g("0");
                    dVar2.h("0");
                    str = a(str, dVar2, str2, str3, str4);
                }
                if (str.contains(v)) {
                    dVar2.a("-999");
                    dVar2.b("-999");
                    dVar2.c("-999");
                    dVar2.d("-999");
                    dVar2.e("-999");
                    dVar2.f("-999");
                    dVar2.g("-999");
                    dVar2.h("-999");
                    str = a(str, dVar2, str2, str3, str4);
                }
            }
            if (str.contains(u)) {
                str = str.replace(u, String.valueOf(i2));
            }
            if (str.contains(v)) {
                str = str.replace(v, String.valueOf(i2));
            }
            if (str.contains(i)) {
                str = str.replace(i, String.valueOf(System.currentTimeMillis()));
            }
            if (str.contains(r)) {
                str = str.replace(r, str2);
            }
            if (str.contains(s)) {
                str = str.replace(s, str3);
            }
            return str.contains(t) ? str.replace(t, str4) : str;
        }
        throw new IllegalArgumentException("url must no null");
    }

    public static String a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && !str.equals("-999") && !str.equals("0")) {
                return String.valueOf((int) ((((long) Double.parseDouble(str)) / context.getResources().getDisplayMetrics().density) + 0.5f));
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }
}
