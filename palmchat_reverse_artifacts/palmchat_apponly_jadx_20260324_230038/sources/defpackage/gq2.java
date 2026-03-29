package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gq2 {
    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String strF = f(context);
            p63.a("IdHelper", "[getAllIds] miit id is: " + strF);
            if (TextUtils.isEmpty(strF)) {
                String str = lv2.b;
                if (!TextUtils.isEmpty(str)) {
                    p63.a("IdHelper", "start getAllIds by local");
                    String strG = g(context, str);
                    if (!TextUtils.isEmpty(strG)) {
                        jSONObject = new JSONObject(strG);
                    }
                }
            } else {
                jSONObject = new JSONObject(strF);
            }
            String strD = d(context);
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put("jgad", strD);
            }
            p63.a("IdHelper", "gaid: " + strD);
            if (jSONObject.toString().equals("{}")) {
                return null;
            }
            return jSONObject;
        } catch (Throwable th) {
            p63.f("IdHelper", "[getAllIds] failed：" + th.getMessage());
            return null;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String strH = rv2.h("AVy8x+cBVze9OKJHZKioHyNDBGqtEllVM4dvG69zMJc=");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            Intent intent = new Intent(strH);
            String strH2 = rv2.h("8lAhWp7NB89J3VIJU4lIGQtLf0YkfPcfFvWDnnGUuiQ=");
            if (TextUtils.isEmpty(strH2)) {
                return "";
            }
            String strH3 = rv2.h("8lAhWp7NB89J3VIJU4lIGQnPwmB8zgbENyN+gUA8dpRI7pO4GGAXufB+HCPmLRg7bL9N6o9V3Rxxk98J3lyy6g==");
            if (TextUtils.isEmpty(strH3)) {
                return "";
            }
            ComponentName componentName = new ComponentName(strH2, strH3);
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            p63.d("IdHelper", "start to bind did service.");
            yh yhVar = new yh();
            boolean zBindService = context.bindService(intent2, yhVar, 1);
            if (zBindService) {
                try {
                    String oaid = new xh(yhVar.f22195a.take()).getOAID();
                    p63.a("IdHelper", "asus ids-oa; " + oaid);
                    return oaid;
                } catch (Throwable th) {
                    try {
                        p63.f("IdHelper", "get asus ids-oa error: " + th.getMessage());
                        if (zBindService) {
                            p63.d("IdHelper", "start to unbind did service");
                            context.unbindService(yhVar);
                        }
                        return "";
                    } finally {
                        if (zBindService) {
                            p63.d("IdHelper", "start to unbind did service");
                            context.unbindService(yhVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            p63.f("IdHelper", "asus getAdvertisingIdInfo Exception: " + e.toString());
        }
        return "";
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String strH = rv2.h("CV+BUnOM9r9hBWkUu5oSnA==");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(strH, 0);
            try {
                String strH2 = rv2.h("axDZqud6H+CDQBXA/yBXOiEPy9gW6px8eLENPXdBlBHSZeanEgWxhi72s58AM6wZ");
                if (TextUtils.isEmpty(strH2)) {
                    return "";
                }
                Intent intent = new Intent(strH2);
                intent.setPackage(strH);
                yj2 yj2Var = new yj2();
                boolean zBindService = context.bindService(intent, yj2Var, 1);
                if (zBindService) {
                    try {
                        String oaid = new vj2(yj2Var.f22209a.take()).getOaid();
                        p63.a("IdHelper", "hw ids-o:" + oaid);
                        return oaid;
                    } catch (Throwable th) {
                        try {
                            p63.f("IdHelper", "hw get Ids-oa error: " + th.getMessage());
                            if (zBindService) {
                                context.unbindService(yj2Var);
                            }
                            return "";
                        } finally {
                            if (zBindService) {
                                context.unbindService(yj2Var);
                            }
                        }
                    }
                }
                p63.f("IdHelper", "hw service bind failed");
            } catch (Throwable th2) {
                p63.f("IdHelper", "hw getAdvertisingIdInfo Exception: " + th2.toString());
            }
            return "";
        } catch (Throwable unused) {
            p63.f("IdHelper", "not supported hw");
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return e(context);
        } catch (Throwable th) {
            p63.f("IdHelper", "getGoogleAdid failed:" + th.getMessage());
            return "";
        }
    }

    public static String e(Context context) {
        if (p()) {
            p63.f("IdHelper", "not get id in main thread");
            return "";
        }
        try {
            String strH = rv2.h("83JmFPusB5CQP/HtGWAx9pgfJZgEDCaE2wJbKIZa8GM=");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(strH, 0);
            try {
                String strH2 = rv2.h("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjLhqIYeN+juscczCl6Sq6PxwLAq9CdDlLtmxsbD83akRg==");
                if (TextUtils.isEmpty(strH2)) {
                    return "";
                }
                Intent intent = new Intent(strH2);
                String strH3 = rv2.h("+Fc+/S0DV5xukan0E/9N4VArQdi8pEVBp8UquAC8VbE=");
                if (TextUtils.isEmpty(strH3)) {
                    return "";
                }
                intent.setPackage(strH3);
                cd2 cd2Var = new cd2();
                if (context.bindService(intent, cd2Var, 1)) {
                    try {
                        if (cd2Var.f1954a) {
                            p63.f("IdHelper", "google service repeat bind");
                            return "";
                        }
                        String id = new e8(cd2Var.b.take()).getId();
                        p63.a("IdHelper", "google ad id:" + id);
                        return id;
                    } catch (Throwable th) {
                        try {
                            p63.f("IdHelper", "get google Ids by service error: " + th.getMessage());
                            context.unbindService(cd2Var);
                            return "";
                        } finally {
                            context.unbindService(cd2Var);
                        }
                    }
                }
                p63.f("IdHelper", "google service bind failed");
            } catch (Throwable th2) {
                p63.f("IdHelper", "google getAdvertisingIdInfo Exception: " + th2.toString());
            }
            return "";
        } catch (Throwable unused) {
            p63.f("IdHelper", "not supported google");
            return "";
        }
    }

    public static String f(Context context) {
        if (p()) {
            p63.f("IdHelper", "not get id in main thread");
            return "";
        }
        if (q()) {
            String strI = i(context);
            if (!TextUtils.isEmpty(strI)) {
                return strI;
            }
            p63.f("IdHelper", "not get ids by mitts");
        }
        return "";
    }

    public static String g(Context context, String str) {
        try {
        } catch (Throwable th) {
            p63.f("IdHelper", "getIdsByLocal failed:" + th.getMessage());
        }
        if (p()) {
            p63.f("IdHelper", "not get id in main thread");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String strH = rv2.h("KACzk43fXSu6fNDY3NHiRg==");
        if (!TextUtils.isEmpty(strH) && str.toLowerCase().equals(strH)) {
            String strC = c(context);
            if (TextUtils.isEmpty(strC)) {
                return "";
            }
            jSONObject.put("joad", strC);
            return jSONObject.toString();
        }
        String strH2 = rv2.h("abElWL6JFOA3DmtpsVXe5g==");
        if (!TextUtils.isEmpty(strH2) && str.toLowerCase().equals(strH2)) {
            return n(context);
        }
        String strH3 = rv2.h("ZCUqO8ru60AnJTvdxNftwg==");
        if (!TextUtils.isEmpty(strH3) && str.toLowerCase().equals(strH3)) {
            return m(context);
        }
        String strH4 = rv2.h("Sqo/G40afBQEk/ThxiHCDA==");
        if (!TextUtils.isEmpty(strH4) && str.toLowerCase().equals(strH4)) {
            String strK = k(context);
            if (TextUtils.isEmpty(strK)) {
                return "";
            }
            jSONObject.put("joad", strK);
            return jSONObject.toString();
        }
        String strH5 = rv2.h("Fl44OKc45ZSCqG4pxdgAdA==");
        if (!TextUtils.isEmpty(strH5) && str.toLowerCase().equals(strH5)) {
            String strL = l(context);
            if (TextUtils.isEmpty(strL)) {
                return "";
            }
            jSONObject.put("joad", strL);
            return jSONObject.toString();
        }
        String strH6 = rv2.h("v4ibuvMAw0xxYGyCW947bw==");
        String strH7 = rv2.h("lJTl9z+ZycJlu+D6qavE9g==");
        if ((!TextUtils.isEmpty(strH6) && str.toLowerCase().equals(strH6)) || (!TextUtils.isEmpty(strH7) && str.toLowerCase().equals(strH7))) {
            return h(context);
        }
        String strH8 = rv2.h("7UUoz3VX0wN8BuYNQ77o2g==");
        if (!TextUtils.isEmpty(strH8) && str.toLowerCase().equals(strH8)) {
            return j(context);
        }
        String strH9 = rv2.h("NftKgs8fjwuVYJ3VslncvA==");
        String strH10 = rv2.h("Wq1559o9+HHChTmry59Bkg==");
        if ((!TextUtils.isEmpty(strH9) && str.toLowerCase().equals(strH9)) || (!TextUtils.isEmpty(strH10) && str.toLowerCase().equals(strH10))) {
            String strO = o(context);
            if (TextUtils.isEmpty(strO)) {
                return "";
            }
            jSONObject.put("joad", strO);
            return jSONObject.toString();
        }
        String strH11 = rv2.h("fmTCWm9ViPlyzM8H0bOrgw==");
        if (TextUtils.isEmpty(strH11) || !str.toLowerCase().equals(strH11)) {
            p63.f("IdHelper", "not supported this device: " + str);
            return "";
        }
        String strB = b(context);
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        jSONObject.put("joad", strB);
        return jSONObject.toString();
    }

    public static String h(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            in3 in3Var = new in3(context);
            String strB = in3Var.b();
            String strC = in3Var.c();
            String strA = in3Var.a();
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("joad", strB);
            }
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("jvad", strC);
            }
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("jaad", strA);
            }
        } catch (JSONException e) {
            p63.f("IdHelper", "getVivoIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public static String i(Context context) {
        try {
            Class.forName(rv2.h("KbEOJC6hqkBcbuUrDsdaXOUofElYAGZhekK9mozUIHGMGWMoSFaqAoiWtoXrQsHy"));
            FutureTask futureTask = new FutureTask(new up3(context));
            rv2.c(futureTask);
            return (String) futureTask.get(2L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            p63.f("IdHelper", "getMittIds by version 13 failed:" + th);
            return "";
        }
    }

    public static String j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            x34 x34Var = new x34(context);
            String strB = x34Var.b();
            String strC = x34Var.c();
            String strA = x34Var.a();
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("joad", strB);
            }
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("jvad", strC);
            }
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("jaad", strA);
            }
        } catch (JSONException e) {
            p63.f("IdHelper", "getNubiaIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public static String k(Context context) {
        try {
            String strH = rv2.h("qFFOesfckPwVmbfqzGl5oG9IMWwJa4PjDfKEUokUsrU=");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            boolean z = false;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strH, 0);
            if (packageInfo == null) {
                p63.f("IdHelper", "oppo get package info is null");
                return "";
            }
            if (Build.VERSION.SDK_INT < 28 ? packageInfo.versionCode >= 1 : packageInfo.getLongVersionCode() >= 1) {
                z = true;
            }
            if (!z) {
                p63.a("IdHelper", "oppo not support above version 28");
                return "";
            }
            try {
                String strH2 = rv2.h("qFFOesfckPwVmbfqzGl5oOMkBF5tSSPHMYAiT/owwSwoCrUg5HXoJRYDJrCupV3K");
                if (TextUtils.isEmpty(strH2)) {
                    return "";
                }
                Intent intent = new Intent(strH2);
                intent.setPackage(strH);
                String strH3 = rv2.h("/3gurUKcGzqF8/YMsL45D9RvCsSd5y5lQDTuvU2S5vtG2aMIkkluUNr+NKF2loi0");
                if (TextUtils.isEmpty(strH3)) {
                    return "";
                }
                intent.setAction(strH3);
                m94 m94Var = new m94();
                boolean zBindService = context.bindService(intent, m94Var, 1);
                if (zBindService) {
                    try {
                        String strT = new h94(m94Var.f19171a.take()).t(context);
                        p63.a("IdHelper", "oppo ids-oa: " + strT);
                        return strT;
                    } catch (Throwable th) {
                        try {
                            p63.f("IdHelper", "get oppo ids-oa error: " + th.getMessage());
                            if (zBindService) {
                                context.unbindService(m94Var);
                            }
                            return "";
                        } finally {
                            if (zBindService) {
                                context.unbindService(m94Var);
                            }
                        }
                    }
                }
                p63.f("IdHelper", "oppo service bind failed");
            } catch (Exception e) {
                p63.f("IdHelper", "oppo getAdvertisingIdInfo Exception: " + e.toString());
            }
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            p63.f("IdHelper", "package com.heytap.openid not found");
            return "";
        }
    }

    public static String l(Context context) {
        try {
            String strH = rv2.h("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVtSyGK74B1pfv+DoniV/u8H");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            if (context.getPackageManager().getPackageInfo(strH, 0) == null) {
                p63.f("IdHelper", "sumsung not support");
                return "";
            }
            try {
                String strH2 = rv2.h("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVsaSg3goTgfCOA0dOFWjVLPc7dVv4XHGL0Dk7MQTYMVQw==");
                if (TextUtils.isEmpty(strH2)) {
                    return "";
                }
                Intent intent = new Intent();
                intent.setClassName(strH, strH2);
                rn5 rn5Var = new rn5();
                boolean zBindService = context.bindService(intent, rn5Var, 1);
                if (zBindService) {
                    try {
                        String strG = new qn5(rn5Var.f20514a.take()).g(context);
                        p63.a("IdHelper", "sumsuang ids-oa:" + strG);
                        return strG;
                    } catch (Throwable th) {
                        try {
                            p63.f("IdHelper", "get sumsung Ids-oa error: " + th.getMessage());
                            if (zBindService) {
                                context.unbindService(rn5Var);
                            }
                            return "";
                        } finally {
                            if (zBindService) {
                                context.unbindService(rn5Var);
                            }
                        }
                    }
                }
                p63.f("IdHelper", "sumsung service bind failed");
            } catch (Exception e) {
                p63.f("IdHelper", "sumsung getAdvertisingIdInfo Exception: " + e.toString());
            }
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            p63.f("IdHelper", "package com.samsung.android.deviceidservice not found");
            return "";
        }
    }

    public static String m(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            ng6 ng6Var = new ng6(context);
            ng6Var.d("");
            String strB = ng6Var.b();
            String strC = ng6Var.c();
            String strA = ng6Var.a();
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("joad", strB);
            }
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("jvad", strC);
            }
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("jaad", strA);
            }
        } catch (JSONException e) {
            p63.f("IdHelper", "getVivoIds err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public static String n(Context context) {
        return hq2.a(context);
    }

    public static String o(Context context) {
        try {
            String strH = rv2.h("Mpy0fkBSw1N+kug2cBPj2YJ2JkldBoT0Hj8EbMwXMGU=");
            if (TextUtils.isEmpty(strH)) {
                return "";
            }
            context.getPackageManager().getPackageInfo(strH, 0);
            try {
                String strH2 = rv2.h("Mpy0fkBSw1N+kug2cBPj2dTFEwqSue3aUHyxqBhF0BWQuC1TiTYwRmpXbBFYowSK");
                if (TextUtils.isEmpty(strH2)) {
                    return "";
                }
                Intent intent = new Intent(strH2);
                intent.setPackage(strH);
                kr6 kr6Var = new kr6();
                boolean zBindService = context.bindService(intent, kr6Var, 1);
                if (zBindService) {
                    try {
                        String oaid = new jr6(kr6Var.f18817a.take()).getOAID();
                        p63.a("IdHelper", "zui ids-oa:" + oaid);
                        return oaid;
                    } catch (Throwable th) {
                        try {
                            p63.f("IdHelper", "get zui ids-oa error: " + th.getMessage());
                            if (zBindService) {
                                context.unbindService(kr6Var);
                            }
                            return "";
                        } finally {
                            if (zBindService) {
                                context.unbindService(kr6Var);
                            }
                        }
                    }
                }
                p63.f("IdHelper", "zui service bind failed");
            } catch (Exception e) {
                p63.f("IdHelper", "zui getAdvertisingIdInfo Exception: " + e.toString());
            }
            return "";
        } catch (Throwable unused) {
            p63.f("IdHelper", "package com.zui.deviceidservice not found ");
            return "";
        }
    }

    public static boolean p() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            p63.f("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    public static boolean q() {
        try {
            p63.a("IdHelper", "MdidSdkHelper name:" + Class.forName(rv2.h("PcAdtsBZRJNo5a0tkYAln7JmiO95myc4NXXWf+j90/KXOpD1MlJOBugPF6SmMTLe")).getName());
            return true;
        } catch (Throwable th) {
            p63.f("IdHelper", "not found mitt class" + th);
            return false;
        }
    }
}
