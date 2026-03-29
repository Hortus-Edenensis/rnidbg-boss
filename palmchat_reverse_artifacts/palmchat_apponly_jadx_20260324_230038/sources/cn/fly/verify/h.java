package cn.fly.verify;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.fly.verify.fq;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.EventParams;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f2398a = new h();
    }

    private h() {
    }

    public static h a() {
        return a.f2398a;
    }

    public HashMap<String, Object> b() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String strC = fq.d.c();
            map.put("appkey", ax.d());
            map.put("appVersion", fq.d.f());
            map.put("plat", "1");
            map.put("sdkVersion", Integer.valueOf(FlyVerify.SDK_VERSION_CODE));
            map.put(com.heytap.mcssdk.constant.b.e, strC);
            map.put("old", Boolean.FALSE);
            map.put("duid", 0);
            map.put("md5", al.a());
            return map;
        } catch (Throwable th) {
            f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "buildInitParams", th.getMessage());
            return map;
        }
    }

    private String a(int i, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (sb.length() > 0) {
                sb.append("\u0001");
            }
            String strValueOf = obj == null ? "" : String.valueOf(obj);
            sb.append(strValueOf);
            if (i == 1 || (i > 1 && i2 > 0)) {
                sb2.append("[");
                sb2.append(i2 + i);
                sb2.append("]");
                sb2.append(strValueOf);
            }
        }
        String string = sb.toString();
        f.a().a("token " + ((Object) sb2));
        return string;
    }

    public HashMap<String, Object> a(c cVar) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String strB = cVar.b();
            String strC = cVar.c().equals("preVerify") ? ai.a().c() : cVar.c().equals("verify") ? ai.a().b() : null;
            if (strC != null && !strC.equals(strB)) {
                strB = strB + "," + strC;
            }
            map.put("serialId", strB);
            map.put("isFirstPre", Boolean.valueOf(cVar.a()));
            map.put("type", cVar.c());
            map.put(ActionUtils.METHOD, cVar.d());
            map.put("appkey", ax.d());
            map.put("plat", "1");
            map.put(WkParams.MODEL, fq.d.j());
            map.put("deviceName", fq.d.l());
            map.put(NotificationCompat.CATEGORY_SYSTEM, String.valueOf(fq.d.g()));
            map.put("duid", am.a());
            if (TextUtils.isEmpty(cVar.q())) {
                cVar.f(as.b());
            }
            map.put("operator", cVar.q());
            map.put("mnc", as.a());
            String strS = cVar.s();
            if (TextUtils.isEmpty(strS)) {
                strS = "-1";
            }
            map.put("pmask", strS);
            map.put(EventParams.KEY_PARAM_SDKVER, FlyVerify.getVersion());
            map.put("pkg", fq.d.c());
            map.put("md5", al.a());
            map.put("time", Long.valueOf(cVar.i()));
            map.put("sdkMode", "noui1362");
            map.put("romVersion", al.g());
            map.put(WiseOpenHianalyticsData.UNION_COSTTIME, Long.valueOf(cVar.j()));
            map.put("stepTime", Long.valueOf(cVar.k()));
            map.put("removeTelcom", Boolean.valueOf(cVar.m()));
            map.put("isCache", Boolean.valueOf(cVar.l()));
            map.put("appId", cVar.n());
            map.put("isCdn", Boolean.valueOf(cVar.p()));
            map.put("isError", Boolean.valueOf(cVar.o()));
            map.put("resCode", Integer.valueOf(cVar.e()));
            map.put("innerCode", Integer.valueOf(cVar.g()));
            if (cVar.h() != null) {
                map.put("innerDesc", cVar.h());
            }
            if (cVar.f() != null) {
                map.put("resDesc", cVar.f());
            }
            if (!ai.a().g().contains("deviceId")) {
                map.put("deviceId", al.f());
            }
            map.put("oaid", al.k());
            map.put("slots", Integer.valueOf(as.b(false)));
            map.put("slots2", Integer.valueOf(as.c(false)));
            map.put("subids", as.d(false));
            map.put("factory", fq.d.k());
            map.put("brand", fq.d.l());
            if (cVar.r() != null) {
                map.put("auto", cVar.r());
            }
            map.put("ui", 0);
            if (cVar.d().equals("preVerify")) {
                map.put("netStatus", Integer.valueOf(as.h()));
                map.put(TKDownloadReason.KSAD_TK_NET, al.j());
            }
            if (cVar.t() != null) {
                map.put("multiFlag", cVar.t());
            }
            f.a().a("append: method = " + cVar.d() + ", isError = " + cVar.o() + fv.a((HashMap) map));
        } catch (Throwable th) {
            f.a().c("[FlyVerify] ==>%s", "buildLogParams" + th.getMessage());
        }
        return map;
    }

    public HashMap<String, Object> a(String str, String str2, String str3) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("appkey", ax.d());
            map.put(com.heytap.mcssdk.constant.b.A, ax.e());
            map.put("appVersion", fq.d.f());
            map.put("duid", am.a());
            map.put("plat", "1");
            map.put("sdkVersion", Integer.valueOf(FlyVerify.SDK_VERSION_CODE));
            map.put(com.heytap.mcssdk.constant.b.e, fq.d.c());
            map.put("operator", str);
            map.put("phone", str2);
            if (!ai.a().g().contains("simserial")) {
                map.put("simserial", al.h());
            }
            if (!ai.a().g().contains("imsi")) {
                map.put("imsi", al.e());
            }
            if (!ai.a().g().contains("mnc")) {
                map.put("mnc", as.a());
            }
            map.put("subid", Integer.valueOf(as.d()));
            map.put("oaid", al.k());
            map.put("udd", as.f());
            map.put("drd", as.g());
            map.put("fbt", String.valueOf(as.e(as.d("S4B9kH1Lj5WPkIGJS4h9j5BJhIF9gIGOSpCUkA=="))));
            map.put("fwt", String.valueOf(as.e(as.d("UoeEl4RSlpyWl4iQUpqEl4aLj4yWl4KWiJeXjJGKllGbkI8="))));
            map.put("fls", String.valueOf(as.e(as.d("S4B9kH1Lj5WPkIGJS4iLf4ePgZCQhYqDj0qAfg=="))));
            map.put("fda", String.valueOf(as.e(as.d("NGlmeWY="))));
            map.put("fsm", String.valueOf(as.e(as.d("O3BtgG07f4V/gHF5"))));
            map.put("fus", String.valueOf(as.e(as.d("QXZzhnNBhYuFhnd/QYeFd4SF"))));
            map.put("fsf", String.valueOf(as.e(as.d("XJGOoY5coKagoZKaXKKgkp+gXF1coJKhoZablKCMk5ablJKfnZ+Wm6FbpZqZ"))));
            map.put("finp", Build.FINGERPRINT);
            map.put(WkParams.MODEL, fq.d.j());
            map.put("factory", fq.d.k());
            map.put("sysverint", String.valueOf(fq.d.g()));
            if (!TextUtils.isEmpty(str3)) {
                map.put("serialId", str3);
            }
            f.a().a(map.toString());
            return map;
        } catch (Throwable th) {
            f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "buildCacheParams", th.getMessage());
            return map;
        }
    }

    public String[] a(s sVar, String str, String str2, String str3) {
        Throwable th;
        try {
            Object objA = am.a();
            Object objC = fq.d.c();
            Object objD = ax.d();
            Object objA2 = al.a();
            String strF = fq.d.f();
            if (strF.contains("#")) {
                try {
                    strF = strF.replace("#", "_");
                } catch (Throwable th2) {
                    th = th2;
                    f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "getOriginToken", th.getMessage());
                    return null;
                }
            }
            String strE = !ai.a().g().contains("imsi") ? al.e() : "";
            if (TextUtils.isEmpty(strE)) {
                strE = "";
            }
            Object objK = al.k();
            String strF2 = !ai.a().g().contains("deviceId") ? al.f() : "";
            if (TextUtils.isEmpty(strF2)) {
                strF2 = "";
            }
            try {
                try {
                    String strA = a(1, objD, objA, "1", objC, strF, Integer.valueOf(FlyVerify.SDK_VERSION_CODE), "", objA2, strF2, Long.valueOf(System.currentTimeMillis()), strE, objK, "", "", as.a(), String.valueOf(sVar.e), sVar.b, String.valueOf(ai.a().e()), String.valueOf(ai.a().f()), String.valueOf(ai.a().d()), String.valueOf(as.d()), sVar.c() != null ? sVar.c().b() : "", TextUtils.isEmpty(str) ? "" : str);
                    String strA2 = ao.a(str2 + strA + str3);
                    int iD = sVar.d();
                    Object objE = sVar.e();
                    Object objF = sVar.f();
                    int iB = as.b(false);
                    List<Integer> listD = as.d(false);
                    StringBuilder sb = new StringBuilder();
                    if (listD != null && !listD.isEmpty()) {
                        for (Integer num : listD) {
                            if (sb.length() > 0) {
                                sb.append(".");
                            }
                            sb.append(num);
                        }
                    }
                    Object objH = fq.d.h();
                    Object objK2 = fq.d.k();
                    Object objL = fq.d.l();
                    Object objJ = fq.d.j();
                    int iG = fq.d.g();
                    Object objF2 = as.f();
                    Object objG = as.g();
                    long jE = as.e(as.d("S4B9kH1Lj5WPkIGJS4h9j5BJhIF9gIGOSpCUkA=="));
                    long jE2 = as.e(as.d("UoeEl4RSlpyWl4iQUpqEl4aLj4yWl4KWiJeXjJGKllGbkI8="));
                    long jE3 = as.e(as.d("S4B9kH1Lj5WPkIGJS4iLf4ePgZCQhYqDj0qAfg=="));
                    long jE4 = as.e(as.d("NGlmeWY="));
                    long jE5 = as.e(as.d("O3BtgG07f4V/gHF5"));
                    long jE6 = as.e(as.d("QXZzhnNBhYuFhnd/QYeFd4SF"));
                    long jE7 = as.e(as.d("XJGOoY5coKagoZKaXKKgkp+gXF1coJKhoZablKCMk5ablJKfnZ+Wm6FbpZqZ"));
                    return new String[]{a(23, strA, strA2, "", Integer.valueOf(iD), objE, objF, Integer.valueOf(iB), sb.toString(), objH, objK2, objL, objJ, Integer.valueOf(iG), objF2, objG, Long.valueOf(jE), Long.valueOf(jE2), Long.valueOf(jE3), Long.valueOf(jE4), Long.valueOf(jE5), Long.valueOf(jE6), Long.valueOf(jE7), Build.FINGERPRINT) + "\u0001", strA2};
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "getOriginToken", th.getMessage());
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
