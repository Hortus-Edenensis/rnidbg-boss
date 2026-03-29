package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.wifi.ad.core.interactive.WkInteractiveManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2683a;

    public cv(Context context) {
        this.f2683a = context.getApplicationContext();
    }

    private static String b() {
        return WkInteractiveManager.TimingTypeOff;
    }

    private static String c() {
        return "ANDA0605000";
    }

    private static String d() {
        return "";
    }

    private String e() {
        return fv.a(this.f2683a);
    }

    private static String f() {
        return "9.7.2";
    }

    private static String g() {
        return "";
    }

    private static String h() {
        return fv.k();
    }

    private static String i() {
        return "";
    }

    private static String j() {
        return "";
    }

    private static String k() {
        return "";
    }

    private static String l() {
        return "";
    }

    private static String m() {
        return "";
    }

    private static String n() {
        return "";
    }

    private static String o() {
        return "";
    }

    private static String p() {
        return "ANDH070308";
    }

    private static String q() {
        return "android";
    }

    private static String r() {
        return "";
    }

    private static String s() {
        return "";
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("");
        sb.append("personal_switch=");
        sb.append(b());
        sb.append("&autodiv=");
        sb.append(c());
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            sb.append("&tid=");
            sb.append(strD);
        }
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            sb.append("&adiu=");
            sb.append(strE);
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            sb.append("&app_version=");
            sb.append(strF);
        }
        String strG = g();
        if (!TextUtils.isEmpty(strG)) {
            sb.append("&cifa=");
            sb.append(strG);
        }
        String strH = h();
        if (!TextUtils.isEmpty(strH)) {
            sb.append("&deviceid=");
            sb.append(strH);
        }
        String strI = i();
        if (!TextUtils.isEmpty(strI)) {
            sb.append("&did=");
            sb.append(strI);
        }
        String strJ = j();
        if (!TextUtils.isEmpty(strJ)) {
            sb.append("&didv=");
            sb.append(strJ);
        }
        String strK = k();
        if (!TextUtils.isEmpty(strK)) {
            sb.append("&dic=");
            sb.append(strK);
        }
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            sb.append("&dip=");
            sb.append(strL);
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            sb.append("&diu=");
            sb.append(strM);
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            sb.append("&diu2=");
            sb.append(strN);
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            sb.append("&diu3=");
            sb.append(strO);
        }
        String strP = p();
        if (!TextUtils.isEmpty(strP)) {
            sb.append("&div=");
            sb.append(strP);
        }
        String strQ = q();
        if (!TextUtils.isEmpty(strQ)) {
            sb.append("&os=");
            sb.append(strQ);
        }
        String strR = r();
        if (!TextUtils.isEmpty(strR)) {
            sb.append("&stepid=");
            sb.append(strR);
        }
        String strS = s();
        if (!TextUtils.isEmpty(strS)) {
            sb.append("&session=");
            sb.append(strS);
        }
        return sb.toString();
    }
}
