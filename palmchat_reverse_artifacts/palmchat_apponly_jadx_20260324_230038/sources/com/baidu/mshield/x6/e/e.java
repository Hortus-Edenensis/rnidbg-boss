package com.baidu.mshield.x6.e;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.f.j;
import com.baidu.mshield.x6.f.l;
import com.baidu.platform.comapi.map.MapController;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.x;
import com.qq.gdt.action.ActionUtils;
import com.umeng.analytics.pro.bt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4082a;
    public com.baidu.mshield.x6.b.c b;
    public int c;
    public int d;

    public e(Context context, int i) {
        this(context, i, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x025e A[Catch: all -> 0x0266, TryCatch #3 {, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f A[Catch: all -> 0x0266, TRY_LEAVE, TryCatch #3 {, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d5 A[Catch: all -> 0x0266, TRY_LEAVE, TryCatch #3 {, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0246 A[Catch: all -> 0x0266, TryCatch #3 {, blocks: (B:5:0x0004, B:7:0x000c, B:8:0x0011, B:10:0x0013, B:12:0x0074, B:14:0x007a, B:28:0x00a5, B:30:0x00ab, B:34:0x00b3, B:36:0x00c5, B:38:0x00d5, B:40:0x00f7, B:42:0x0107, B:46:0x011e, B:48:0x0125, B:50:0x013f, B:52:0x0148, B:54:0x0156, B:56:0x0164, B:58:0x0174, B:60:0x0181, B:62:0x018e, B:64:0x019f, B:66:0x01a9, B:67:0x01b0, B:69:0x01bb, B:73:0x01c6, B:75:0x01d5, B:81:0x01f4, B:88:0x0209, B:91:0x0211, B:96:0x0230, B:98:0x0246, B:100:0x0251, B:102:0x0264, B:101:0x025e, B:86:0x0204, B:80:0x01f1, B:17:0x0081, B:19:0x0087, B:27:0x00a2, B:77:0x01dd, B:21:0x008d, B:23:0x0099, B:83:0x01fc), top: B:117:0x0004, outer: #4, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        String strH;
        String strD;
        String strB;
        JSONObject jSONObjectA;
        int iA;
        int i;
        try {
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        synchronized (e.class) {
            if (!com.baidu.mshield.b.e.a.d(this.f4082a)) {
                com.baidu.mshield.b.c.a.a("run isCanRequestNetBackground=false");
                return;
            }
            com.baidu.mshield.b.c.a.a("startzidcheck===" + this.c + x.aQ + h.b);
            h.b = true;
            Object objB = com.baidu.mshield.x6.f.b.b(this.f4082a);
            String strB2 = this.b.b();
            String strE = this.b.e();
            String strC = this.b.c();
            String strF = this.b.f();
            String strD2 = this.b.d();
            Object obj = strB2 + "#" + strC;
            if (TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strD2)) {
                if (!TextUtils.isEmpty(strC)) {
                    strB2 = strC;
                }
                if (TextUtils.isEmpty(strB2)) {
                }
                strE = strB2;
                Object objB2 = com.baidu.mshield.utility.c.b(this.f4082a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", strE);
                jSONObject.put("ut", com.baidu.mshield.x6.f.f.g(this.f4082a));
                jSONObject.put("magic", objB);
                jSONObject.put("token_rt", this.b.f());
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f4082a);
                bVar.k(this.c);
                Object objB3 = com.baidu.mshield.utility.c.b(this.f4082a);
                jSONObject.put("mz", objB2);
                jSONObject.put("ds", com.baidu.mshield.x6.f.b.a(this.f4082a));
                jSONObject.put(bt.af, objB3);
                jSONObject.put("act_st", String.valueOf(this.d));
                jSONObject.put("chn_st", com.baidu.mshield.x6.f.f.a(this.f4082a, "plc95", false) ? "1" : "0");
                jSONObject.put("os_ver", EngineImpl.getInstance(this.f4082a).getPropertyByType("arl"));
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("1", bVar.J());
                jSONObject2.put("2", bVar.K());
                jSONObject2.put("3", jCurrentTimeMillis);
                jSONObject2.put("4", bVar.m());
                jSONObject.put("reason", jSONObject2);
                jSONObject.put(OapsKey.KEY_TYPE, String.valueOf(this.c));
                jSONObject.put("tk", obj);
                jSONObject.put("pd", String.valueOf(Process.myPid()));
                jSONObject.put("lrc", String.valueOf(bVar.F()));
                jSONObject.put(com.umeng.ccg.a.f11001a, bVar.B());
                strH = bVar.h();
                if (!TextUtils.isEmpty(strH)) {
                }
                jSONObject.put("lre", bVar.j());
                jSONObject.put("ipo", !bVar.z() ? "1" : "0");
                strD = com.baidu.mshield.x6.f.f.d(this.f4082a);
                if (TextUtils.isEmpty(strD)) {
                }
                a(jSONObject);
                bVar.d(0);
                strB = "";
                strB = com.baidu.mshield.utility.c.b(this.f4082a);
                if (TextUtils.isEmpty(strB)) {
                }
                jSONObject.put(EngineImpl.KEY_CUID, strB);
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f4082a, jSONObject, com.baidu.mshield.x6.f.g.d, false);
                iA = l.a(this.f4082a, jSONObjectA.toString(), this.d);
                while (iA == -100) {
                    Thread.sleep(2000L);
                    iA = l.a(this.f4082a, jSONObjectA.toString(), this.d);
                }
                if (iA != -100) {
                }
                h.b = false;
            }
            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strD2)) {
                try {
                    if (Long.parseLong(strD2) > Long.parseLong(strF)) {
                        if (!TextUtils.isEmpty(strC)) {
                            strB2 = strC;
                        }
                    }
                } catch (Throwable th2) {
                    com.baidu.mshield.x6.f.f.b(th2);
                }
            }
            if (TextUtils.isEmpty(strB2) || TextUtils.isEmpty(strE)) {
                strE = strB2;
            }
            Object objB22 = com.baidu.mshield.utility.c.b(this.f4082a);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("token", strE);
            jSONObject3.put("ut", com.baidu.mshield.x6.f.f.g(this.f4082a));
            jSONObject3.put("magic", objB);
            jSONObject3.put("token_rt", this.b.f());
            com.baidu.mshield.x6.b.b bVar2 = new com.baidu.mshield.x6.b.b(this.f4082a);
            bVar2.k(this.c);
            Object objB32 = com.baidu.mshield.utility.c.b(this.f4082a);
            jSONObject3.put("mz", objB22);
            jSONObject3.put("ds", com.baidu.mshield.x6.f.b.a(this.f4082a));
            jSONObject3.put(bt.af, objB32);
            jSONObject3.put("act_st", String.valueOf(this.d));
            jSONObject3.put("chn_st", com.baidu.mshield.x6.f.f.a(this.f4082a, "plc95", false) ? "1" : "0");
            jSONObject3.put("os_ver", EngineImpl.getInstance(this.f4082a).getPropertyByType("arl"));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("1", bVar2.J());
            jSONObject22.put("2", bVar2.K());
            jSONObject22.put("3", jCurrentTimeMillis2);
            jSONObject22.put("4", bVar2.m());
            jSONObject3.put("reason", jSONObject22);
            jSONObject3.put(OapsKey.KEY_TYPE, String.valueOf(this.c));
            jSONObject3.put("tk", obj);
            jSONObject3.put("pd", String.valueOf(Process.myPid()));
            jSONObject3.put("lrc", String.valueOf(bVar2.F()));
            jSONObject3.put(com.umeng.ccg.a.f11001a, bVar2.B());
            strH = bVar2.h();
            if (!TextUtils.isEmpty(strH)) {
                jSONObject3.put(OapsKey.KEY_DOWNLOAD_COUNT, String.valueOf(com.baidu.mshield.x6.f.d.a(bVar2.i(), strH)));
            }
            jSONObject3.put("lre", bVar2.j());
            jSONObject3.put("ipo", !bVar2.z() ? "1" : "0");
            strD = com.baidu.mshield.x6.f.f.d(this.f4082a);
            if (TextUtils.isEmpty(strD)) {
                try {
                    jSONObject3.put("rmf", new JSONObject(strD).optString("2", ""));
                } catch (Throwable th3) {
                    com.baidu.mshield.x6.f.f.b(th3);
                }
            } else {
                jSONObject3.put("rmf", "");
            }
            a(jSONObject3);
            bVar2.d(0);
            strB = "";
            try {
                strB = com.baidu.mshield.utility.c.b(this.f4082a);
            } catch (Throwable th4) {
                com.baidu.mshield.x6.f.f.b(th4);
            }
            if (TextUtils.isEmpty(strB)) {
                strB = "";
            }
            jSONObject3.put(EngineImpl.KEY_CUID, strB);
            jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f4082a, jSONObject3, com.baidu.mshield.x6.f.g.d, false);
            iA = l.a(this.f4082a, jSONObjectA.toString(), this.d);
            for (i = 1; iA == -100 && i < 3; i++) {
                Thread.sleep(2000L);
                iA = l.a(this.f4082a, jSONObjectA.toString(), this.d);
            }
            if (iA != -100) {
                bVar2.g(false);
                if (com.baidu.mshield.b.a.d.b(this.f4082a)) {
                    f.b(this.f4082a).a(300000L);
                }
            } else {
                bVar2.c(jCurrentTimeMillis2);
                bVar2.d(1);
            }
            h.b = false;
        }
    }

    public e(Context context, int i, int i2) {
        this.f4082a = context;
        this.c = i;
        this.d = i2;
        this.b = new com.baidu.mshield.x6.b.c(context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:0|2|64|3|(21:5|(1:7)(1:9)|62|10|60|11|26|27|28|29|(1:31)(1:32)|33|34|(1:36)|37|(1:39)|40|41|(1:43)(1:44)|45|(2:47|48)(3:49|50|(3:52|53|68)(2:54|69)))(15:17|27|28|29|(0)(0)|33|34|(0)|37|(0)|40|41|(0)(0)|45|(0)(0))|59|20|21|66|22|26|27|28|29|(0)(0)|33|34|(0)|37|(0)|40|41|(0)(0)|45|(0)(0)|(2:(0)|(1:67))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        com.baidu.mshield.x6.f.f.b(r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100 A[Catch: all -> 0x0185, TryCatch #0 {all -> 0x0185, blocks: (B:28:0x0078, B:33:0x0083, B:37:0x009a, B:40:0x00cd, B:45:0x00f7, B:47:0x0100, B:49:0x0106, B:53:0x0115, B:54:0x0157, B:20:0x0062, B:25:0x0070, B:22:0x0067), top: B:59:0x0062, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106 A[Catch: all -> 0x0185, TRY_LEAVE, TryCatch #0 {all -> 0x0185, blocks: (B:28:0x0078, B:33:0x0083, B:37:0x009a, B:40:0x00cd, B:45:0x00f7, B:47:0x0100, B:49:0x0106, B:53:0x0115, B:54:0x0157, B:20:0x0062, B:25:0x0070, B:22:0x0067), top: B:59:0x0062, inners: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(JSONObject jSONObject) {
        String str;
        Throwable th;
        String strOptString;
        String str2;
        String str3;
        String strE;
        String strG;
        String strD;
        String strOptString2 = "";
        try {
            strD = com.baidu.mshield.x6.f.f.d(this.f4082a);
        } catch (Throwable th2) {
            str = "";
            th = th2;
            strOptString = str;
        }
        try {
            if (!TextUtils.isEmpty(strD)) {
                JSONObject jSONObject2 = new JSONObject(strD);
                String strOptString3 = jSONObject2.optString("1");
                if (TextUtils.isEmpty(strOptString3)) {
                    str = "";
                } else {
                    str = new String(com.baidu.mshield.b.a.c.b(Base64.decode(strOptString3.getBytes(), 0)), "utf-8");
                    com.baidu.mshield.b.c.a.a("doRmfDetect ungzDrf : " + str);
                }
                try {
                    strOptString = jSONObject2.optString("3");
                    try {
                        strOptString2 = jSONObject2.optString("2");
                    } catch (Throwable th3) {
                        th = th3;
                        com.baidu.mshield.x6.f.f.b(th);
                        jSONObject.put("15094", com.baidu.mshield.x6.f.f.a(th));
                    }
                } catch (Throwable th4) {
                    th = th4;
                    strOptString = "";
                }
                str2 = strOptString;
                str3 = strOptString2;
                strOptString2 = str;
                jSONObject.put("15091", !TextUtils.isEmpty(strOptString2) ? "1" : "0");
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.f4082a);
                strE = bVar.E();
                if (TextUtils.isEmpty(strE)) {
                    strE = "#";
                }
                boolean zA = com.baidu.mshield.x6.f.f.a(this.f4082a, false);
                jSONObject.put("15082", str3 + "#" + strE + "#" + (zA ? 1 : 0));
                jSONObject.put("15083", str2);
                strG = bVar.G();
                if (TextUtils.isEmpty(strG)) {
                    strG = "#";
                }
                jSONObject.put("15112", str3 + "#" + strG + "#" + (zA ? 1 : 0));
                boolean zF = com.baidu.xclient.gdid.a.f(this.f4082a);
                jSONObject.put("15006", zF ? "1" : "0");
                if (TextUtils.isEmpty(strOptString2)) {
                    com.baidu.mshield.b.c.a.a("real machine sig is empty");
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zF) {
                    String strA = a(strOptString2, true);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    com.baidu.mshield.b.c.a.a("cpp param 2 result : " + strA);
                    jSONObject.put("d0006", String.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis));
                    jSONObject.put("15085", strA);
                    jSONObject.put("isj", "0");
                    jSONObject.put("ise", "1");
                    com.baidu.mshield.b.c.a.b("native cpp=" + strA);
                    return;
                }
                String strA2 = a(strOptString2, false);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                com.baidu.mshield.b.c.a.a("java param 2 result : " + strA2);
                jSONObject.put("d0006", String.valueOf(jCurrentTimeMillis3 - jCurrentTimeMillis));
                jSONObject.put("15085", strA2);
                jSONObject.put("isj", "1");
                jSONObject.put("ise", "0");
                return;
            }
            str3 = "";
            str2 = str3;
            jSONObject.put("15091", !TextUtils.isEmpty(strOptString2) ? "1" : "0");
            com.baidu.mshield.x6.b.b bVar2 = new com.baidu.mshield.x6.b.b(this.f4082a);
            strE = bVar2.E();
            if (TextUtils.isEmpty(strE)) {
            }
            boolean zA2 = com.baidu.mshield.x6.f.f.a(this.f4082a, false);
            jSONObject.put("15082", str3 + "#" + strE + "#" + (zA2 ? 1 : 0));
            jSONObject.put("15083", str2);
            strG = bVar2.G();
            if (TextUtils.isEmpty(strG)) {
            }
            jSONObject.put("15112", str3 + "#" + strG + "#" + (zA2 ? 1 : 0));
            boolean zF2 = com.baidu.xclient.gdid.a.f(this.f4082a);
            jSONObject.put("15006", zF2 ? "1" : "0");
            if (TextUtils.isEmpty(strOptString2)) {
            }
            com.baidu.mshield.x6.f.f.b(th);
            jSONObject.put("15094", com.baidu.mshield.x6.f.f.a(th));
            str2 = strOptString;
            str3 = strOptString2;
            strOptString2 = str;
            jSONObject.put("15091", !TextUtils.isEmpty(strOptString2) ? "1" : "0");
            com.baidu.mshield.x6.b.b bVar22 = new com.baidu.mshield.x6.b.b(this.f4082a);
            strE = bVar22.E();
            if (TextUtils.isEmpty(strE)) {
            }
            boolean zA22 = com.baidu.mshield.x6.f.f.a(this.f4082a, false);
            jSONObject.put("15082", str3 + "#" + strE + "#" + (zA22 ? 1 : 0));
            jSONObject.put("15083", str2);
            strG = bVar22.G();
            if (TextUtils.isEmpty(strG)) {
            }
            jSONObject.put("15112", str3 + "#" + strG + "#" + (zA22 ? 1 : 0));
            boolean zF22 = com.baidu.xclient.gdid.a.f(this.f4082a);
            jSONObject.put("15006", zF22 ? "1" : "0");
            if (TextUtils.isEmpty(strOptString2)) {
            }
        } catch (Throwable th5) {
            com.baidu.mshield.x6.f.f.b(th5);
        }
    }

    public final String a(String str, boolean z) {
        int iOptInt;
        int iOptInt2;
        String strOptString;
        String strOptString2;
        String strValueOf;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    iOptInt = jSONObjectOptJSONObject.optInt("eid");
                    iOptInt2 = jSONObjectOptJSONObject.optInt("pattern");
                    strOptString = jSONObjectOptJSONObject.optString(MapController.ITEM_LAYER_TAG);
                    strOptString2 = jSONObjectOptJSONObject.optString(ActionUtils.PAYMENT_AMOUNT);
                } catch (Throwable th) {
                    com.baidu.mshield.x6.f.f.b(th);
                }
                if (iOptInt2 != 0) {
                    str2 = "";
                    if (iOptInt2 == 2 || iOptInt2 == 3) {
                        String[] strArrSplit = strOptString.split("\\|");
                        String str3 = strArrSplit[0];
                        String str4 = strArrSplit[1];
                        str2 = strArrSplit.length == 3 ? strArrSplit[2] : "";
                        if (iOptInt2 == 2) {
                            if (z) {
                                strValueOf = (String) com.baidu.xclient.gdid.a.a(25, strOptString, strOptString2, (Object) null);
                            } else {
                                strValueOf = j.b(str3, str4, str2, strOptString2);
                            }
                        } else if (z) {
                            strValueOf = (String) com.baidu.xclient.gdid.a.a(26, strOptString, strOptString2, (Object) null);
                        } else {
                            strValueOf = j.a(str3, str4, str2, strOptString2);
                        }
                    }
                    jSONObject.put(String.valueOf(iOptInt), str2);
                } else if (z) {
                    strValueOf = (String) com.baidu.xclient.gdid.a.a(24, strOptString, strOptString2, (Object) null);
                } else {
                    strValueOf = String.valueOf(com.baidu.mshield.x6.f.f.c(strOptString));
                }
                str2 = strValueOf;
                jSONObject.put(String.valueOf(iOptInt), str2);
            }
        } catch (Throwable th2) {
            com.baidu.mshield.x6.f.f.b(th2);
        }
        return jSONObject.toString();
    }
}
