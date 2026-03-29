package com.baidu.mshield.x6.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.baidu.mshield.x6.EngineImpl;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.lantern.core.configuration.ConfigConstant;
import com.oplus.tblplayer.processor.util.EffectConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4090a = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.baidu.mshield.x6.f.m.a {
        public final /* synthetic */ int b;
        public final /* synthetic */ Context c;

        public a(int i, Context context) {
            this.b = i;
            this.c = context;
        }

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            try {
                com.baidu.mshield.b.c.a.a("token respone order trigger token delay : " + this.b);
                Thread.sleep((long) (this.b * 1000));
                com.baidu.mshield.x6.e.h.a(this.c).a(7);
            } catch (Throwable th) {
                f.b(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0149 A[Catch: all -> 0x014f, TRY_LEAVE, TryCatch #5 {all -> 0x014f, blocks: (B:5:0x0004, B:10:0x001b, B:14:0x0048, B:30:0x0073, B:35:0x007f, B:37:0x0085, B:39:0x008b, B:41:0x00b6, B:43:0x00bc, B:45:0x00c2, B:47:0x00c8, B:40:0x00a1, B:48:0x00cb, B:50:0x00d1, B:52:0x00d7, B:54:0x0102, B:56:0x0108, B:58:0x010e, B:60:0x0114, B:53:0x00ed, B:67:0x0143, B:69:0x0149, B:66:0x0128, B:28:0x006d, B:23:0x0061, B:18:0x0055, B:20:0x0059, B:15:0x004d, B:61:0x0117, B:63:0x0123, B:25:0x0065), top: B:88:0x0004, outer: #4, inners: #0, #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, String str) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strU;
        String strB;
        String strA;
        String strA2;
        String strB2;
        String strA3;
        synchronized (l.class) {
            try {
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
                if (System.currentTimeMillis() - bVar.D() < 300000) {
                    return -1;
                }
                String strOptString4 = null;
                String strB3 = new com.baidu.mshield.x6.d.a(context, null).b(str);
                bVar.a(System.currentTimeMillis());
                com.baidu.mshield.b.c.a.c("ret: " + strB3);
                if (TextUtils.isEmpty(strB3)) {
                    return -1;
                }
                JSONObject jSONObject = new JSONObject(strB3);
                try {
                    strOptString = jSONObject.optString("status");
                } catch (Throwable th) {
                    f.b(th);
                    strOptString = null;
                }
                try {
                    strOptString2 = jSONObject.optString("xid");
                } catch (Throwable th2) {
                    f.b(th2);
                    strOptString2 = null;
                }
                try {
                    strOptString3 = jSONObject.optString(CmcdConfiguration.KEY_BUFFER_STARVATION);
                } catch (Throwable th3) {
                    f.b(th3);
                    strOptString3 = null;
                }
                if (strOptString != null && strOptString.equals("99999999")) {
                    return -99;
                }
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (com.baidu.mshield.x6.c.b.b()) {
                        strA2 = new com.baidu.mshield.x6.b.b(context).Q();
                        strB2 = b.b(context, "x_o_b_d");
                        strA3 = b.a(context, ".x_o_b_d");
                    } else {
                        strA2 = new com.baidu.mshield.x6.b.b(context).A();
                        strB2 = b.b(context, "x_b_d");
                        strA3 = b.a(context, ".x_b_d");
                    }
                    if (!strOptString2.equals(strB2) || !strOptString2.equals(strA3) || !strOptString2.equals(strA2)) {
                        b.d(context, strOptString2);
                    }
                }
                if (!TextUtils.isEmpty(strOptString3)) {
                    if (com.baidu.mshield.x6.c.b.b()) {
                        strU = new com.baidu.mshield.x6.b.b(context).P();
                        strB = b.b(context, "g_m_o_bs");
                        strA = b.a(context, ".g_m_o_bs");
                    } else {
                        strU = new com.baidu.mshield.x6.b.b(context).u();
                        strB = b.b(context, "g_m_b_s");
                        strA = b.a(context, ".g_m_b_s");
                    }
                    if (!strOptString3.equals(strB) || !strOptString3.equals(strA) || !strOptString3.equals(strU)) {
                        b.c(context, strOptString3);
                    }
                }
                try {
                    strOptString4 = jSONObject.optString("ver");
                } catch (Throwable th4) {
                    com.baidu.mshield.b.c.a.c("1" + th4.toString());
                    f.b(th4);
                }
                if (TextUtils.isEmpty(strOptString4)) {
                    if (!TextUtils.isEmpty(strOptString4)) {
                    }
                    return 0;
                }
                b.e(context, strOptString4);
                if (!TextUtils.isEmpty(strOptString4)) {
                    b.e(context, strOptString4);
                }
                return 0;
            } catch (Throwable th5) {
                com.baidu.mshield.b.c.a.c("2" + th5.toString());
                f.b(th5);
                return -1;
            }
        }
    }

    public static boolean b(Context context) {
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - bVar.I() > 86400000) {
                bVar.e(1);
                bVar.b(jCurrentTimeMillis);
                com.baidu.mshield.b.c.a.a("time limit , reset last time and count");
            }
            int iH = bVar.H();
            if (iH >= bVar.k()) {
                com.baidu.mshield.b.c.a.a("count limit return false ");
                return false;
            }
            int i = iH + 1;
            bVar.e(i);
            com.baidu.mshield.b.c.a.a("count not limit return true , count : " + i);
            return true;
        } catch (Throwable th) {
            f.b(th);
            return false;
        }
    }

    public static void b(Context context, String str) {
        int i;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.mshield.b.c.a.a("sdata:" + str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("1");
            if (jSONObjectOptJSONObject != null) {
                bVar.a(com.baidu.mshield.x6.b.b.f4076a, jSONObjectOptJSONObject.toString());
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("2");
            if (jSONObjectOptJSONObject2 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.b, jSONObjectOptJSONObject2.toString());
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("3");
            if (jSONObjectOptJSONObject3 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.c, jSONObjectOptJSONObject3.toString());
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("4");
            if (jSONObjectOptJSONObject4 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.d, jSONObjectOptJSONObject4.toString());
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("5");
            if (jSONObjectOptJSONObject5 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.e, jSONObjectOptJSONObject5.toString());
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("6");
            if (jSONObjectOptJSONObject6 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.f, jSONObjectOptJSONObject6.toString());
            }
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("7");
            if (jSONObjectOptJSONObject7 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.g, jSONObjectOptJSONObject7.toString());
            }
            JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("8");
            if (jSONObjectOptJSONObject8 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.h, jSONObjectOptJSONObject8.toString());
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("9");
            if (jSONObjectOptJSONObject9 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.i, jSONObjectOptJSONObject9.toString());
            }
            JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("10");
            if (jSONObjectOptJSONObject10 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.j, jSONObjectOptJSONObject10.toString());
            }
            JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("11");
            if (jSONObjectOptJSONObject11 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.k, jSONObjectOptJSONObject11.toString());
            }
            JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_MARKET);
            if (jSONObjectOptJSONObject12 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.l, jSONObjectOptJSONObject12.toString());
            }
            JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_GAME_CENTER);
            if (jSONObjectOptJSONObject13 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.m, jSONObjectOptJSONObject13.toString());
            }
            JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_AD_SDK);
            if (jSONObjectOptJSONObject14 != null) {
                try {
                    JSONObject jSONObjectOptJSONObject15 = jSONObjectOptJSONObject14.optJSONObject("2");
                    if (jSONObjectOptJSONObject15 != null && jSONObjectOptJSONObject15.has("1")) {
                        String strOptString = jSONObjectOptJSONObject15.optString("1");
                        com.baidu.mshield.b.c.a.a("14 prv 1 origin : " + strOptString);
                        jSONObjectOptJSONObject15.put("1", Base64.encodeToString(com.baidu.mshield.b.a.c.a(strOptString.getBytes()), 0));
                        jSONObjectOptJSONObject14.put("2", jSONObjectOptJSONObject15);
                    }
                } catch (Throwable th) {
                    f.b(th);
                }
                bVar.a(com.baidu.mshield.x6.b.b.n, jSONObjectOptJSONObject14.toString());
            }
            JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("15");
            if (jSONObjectOptJSONObject16 != null) {
                try {
                    JSONObject jSONObject2 = jSONObjectOptJSONObject16.getJSONObject("2");
                    if (jSONObject2 != null && (i = jSONObject2.getInt("1")) != bVar.o() && i > 0) {
                        bVar.l(i);
                    }
                } catch (Throwable th2) {
                    f.b(th2);
                }
            }
            JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_19);
            if (jSONObjectOptJSONObject17 != null) {
                com.baidu.mshield.b.c.a.a("emulator retry policy:" + jSONObjectOptJSONObject17.toString());
                JSONObject jSONObjectOptJSONObject18 = jSONObjectOptJSONObject17.optJSONObject("2");
                StringBuilder sb = new StringBuilder();
                sb.append("emulator 2 json:");
                sb.append(jSONObjectOptJSONObject18);
                com.baidu.mshield.b.c.a.a(sb.toString() == null ? com.igexin.push.core.b.m : jSONObjectOptJSONObject18.toString());
                if (jSONObjectOptJSONObject18 != null) {
                    int iOptInt = jSONObjectOptJSONObject18.optInt("1", 0);
                    com.baidu.mshield.b.c.a.a("emulator set totalCount:" + iOptInt);
                    bVar.c(iOptInt);
                }
            }
            JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_SYSTEM_HELPER);
            if (jSONObjectOptJSONObject19 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.o, jSONObjectOptJSONObject19.toString());
            }
            JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING);
            if (jSONObjectOptJSONObject20 != null) {
                JSONObject jSONObjectOptJSONObject21 = jSONObjectOptJSONObject20.optJSONObject("2");
                com.baidu.mshield.b.c.a.b("intervalJson=" + jSONObjectOptJSONObject21);
                if (jSONObjectOptJSONObject21 != null) {
                    bVar.f(jSONObjectOptJSONObject21.optInt("1", EffectConstants.ROTATION_DEGREES_180));
                    bVar.h(jSONObjectOptJSONObject21.optInt("2", 360));
                    bVar.g(jSONObjectOptJSONObject21.optInt("3", 360));
                    bVar.b(jSONObjectOptJSONObject21.optInt("6", 10));
                    bVar.j(jSONObjectOptJSONObject21.optInt("7", 10));
                }
            }
            JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_SHORTCUT);
            if (jSONObjectOptJSONObject22 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.p, jSONObjectOptJSONObject22.toString());
            }
            JSONObject jSONObjectOptJSONObject23 = jSONObject.optJSONObject("24");
            if (jSONObjectOptJSONObject23 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.q, jSONObjectOptJSONObject23.toString());
            }
            JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("25");
            if (jSONObjectOptJSONObject24 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.r, jSONObjectOptJSONObject24.toString());
            }
            JSONObject jSONObjectOptJSONObject25 = jSONObject.optJSONObject("26");
            if (jSONObjectOptJSONObject25 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.s, jSONObjectOptJSONObject25.toString());
            }
            JSONObject jSONObjectOptJSONObject26 = jSONObject.optJSONObject("27");
            if (jSONObjectOptJSONObject26 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.t, jSONObjectOptJSONObject26.toString());
            }
            JSONObject jSONObjectOptJSONObject27 = jSONObject.optJSONObject("28");
            if (jSONObjectOptJSONObject27 != null) {
                bVar.a(com.baidu.mshield.x6.b.b.u, jSONObjectOptJSONObject27.toString());
            }
            bVar.r(f.c());
            com.baidu.mshield.b.c.a.a("pull static Policy for load success");
        } catch (Throwable th3) {
            f.b(th3);
        }
    }

    public static int a(Context context, String str, int i) {
        String strOptString;
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (!com.baidu.mshield.b.a.d.b(context)) {
                bVar.d(-1);
                return -100;
            }
            String strA = new com.baidu.mshield.x6.d.a(context, null).a(str);
            if (TextUtils.isEmpty(strA)) {
                if (bVar.F() == 0) {
                    bVar.d(-2);
                }
                return -100;
            }
            bVar.x(strA);
            JSONObject jSONObject = new JSONObject(strA);
            com.baidu.mshield.x6.b.c cVar = new com.baidu.mshield.x6.b.c(context);
            try {
                String strOptString2 = jSONObject.optString("token");
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (i == 1) {
                        cVar.b(strOptString2);
                        cVar.c(String.valueOf(System.currentTimeMillis()));
                    } else {
                        cVar.a(strOptString2);
                        cVar.d(String.valueOf(System.currentTimeMillis()));
                        cVar.b("");
                        cVar.c("");
                        bVar.d(System.currentTimeMillis());
                    }
                }
                bVar.g(true);
            } catch (Throwable th) {
                f.b(th);
            }
            try {
                strOptString = jSONObject.optString("nc");
            } catch (Throwable th2) {
                f.b(th2);
                strOptString = "";
            }
            if (bVar.z()) {
                bVar.a(false);
            }
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rmf");
                if (jSONObjectOptJSONObject != null) {
                    if (f.a(context, false)) {
                        bVar.v(jSONObjectOptJSONObject.toString());
                        e = "";
                    } else {
                        e = jSONObjectOptJSONObject.toString();
                        bVar.p();
                    }
                    com.baidu.mshield.b.c.a.a("getZidChecktor ungzRmf : " + new String(com.baidu.mshield.b.a.c.b(Base64.decode(jSONObjectOptJSONObject.optString("1").getBytes(), 0)), "utf-8"));
                } else {
                    e = "";
                }
            } catch (Throwable th3) {
                f.b(th3);
            }
            if (!((TextUtils.equals(strOptString, "1") || (jSONObject.has("nt") && jSONObject.optInt("nt") > 0)) ? b(context) : false)) {
                return 0;
            }
            try {
                if (!TextUtils.isEmpty(strOptString) && TextUtils.equals(strOptString, "1")) {
                    com.baidu.mshield.x6.e.h.a(context).a(2, true);
                }
            } catch (Throwable th4) {
                f.b(th4);
            }
            try {
                int iOptInt = jSONObject.optInt(ConfigConstant.COLUMN_OP);
                bVar.w(jSONObject.optJSONArray("da").toString());
                bVar.i(iOptInt);
                if (jSONObject.has("nt") && jSONObject.optInt("nt") > 0) {
                    bVar.g(false);
                    com.baidu.mshield.x6.f.m.c.b().a(new a(jSONObject.optInt("nt"), context));
                }
                return 0;
            } catch (Throwable th5) {
                f.b(th5);
            }
        } catch (Throwable th6) {
            f.b(th6);
            try {
                com.baidu.mshield.x6.b.b bVar2 = new com.baidu.mshield.x6.b.b(context);
                if (bVar2.F() == 0) {
                    bVar2.d(-4);
                }
            } catch (Throwable th7) {
                f.b(th7);
            }
        }
        return -100;
    }

    public static String a(Context context) {
        try {
            com.baidu.mshield.x6.d.a aVar = new com.baidu.mshield.x6.d.a(context, null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("4", com.baidu.mshield.b.b.a.a(context));
            JSONObject jSONObject2 = new JSONObject();
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1", bVar.x());
            String strL = bVar.L();
            if (TextUtils.isEmpty(strL)) {
                String strA = com.baidu.mshield.b.a.g.a(context);
                com.baidu.mshield.b.c.a.a(" manufacturer: " + strA.toLowerCase());
                if (!TextUtils.isEmpty(strA)) {
                    strL = com.baidu.mshield.b.f.e.a(strA.toLowerCase());
                    bVar.l(strL);
                }
            }
            jSONObject3.put("2", strL);
            String strM = bVar.M();
            if (TextUtils.isEmpty(strM)) {
                String propertyByType = EngineImpl.getInstance(context).getPropertyByType("mod");
                com.baidu.mshield.b.c.a.a(" model: " + propertyByType.toLowerCase());
                if (!TextUtils.isEmpty(propertyByType)) {
                    strM = com.baidu.mshield.b.f.e.a(propertyByType.toLowerCase());
                    bVar.m(strM);
                }
            }
            jSONObject3.put("3", strM);
            String strS = bVar.s();
            if (TextUtils.isEmpty(strS)) {
                String lowerCase = Build.ID.toLowerCase();
                com.baidu.mshield.b.c.a.a(" buildId: " + lowerCase);
                strS = com.baidu.mshield.b.f.e.a(lowerCase);
                bVar.d(strS);
            }
            jSONObject3.put("4", strS);
            String strD = bVar.d();
            if (TextUtils.isEmpty(strD)) {
                String strB = com.baidu.mshield.b.a.g.b(context);
                com.baidu.mshield.b.c.a.a(" romName: " + strB.toLowerCase());
                if (!TextUtils.isEmpty(strB)) {
                    strD = com.baidu.mshield.b.f.e.a(strB.toLowerCase());
                    bVar.t(strD);
                }
            }
            jSONObject3.put("5", strD);
            String strE = bVar.e();
            if (TextUtils.isEmpty(strE)) {
                String strC = com.baidu.mshield.b.a.g.c(context);
                com.baidu.mshield.b.c.a.a(" romVersion: " + strC.toLowerCase());
                if (!TextUtils.isEmpty(strC)) {
                    strE = com.baidu.mshield.b.f.e.a(strC.toLowerCase());
                    bVar.u(strE);
                }
            }
            jSONObject3.put("6", strE);
            String strT = bVar.t();
            if (TextUtils.isEmpty(strT)) {
                String propertyByType2 = EngineImpl.getInstance(context).getPropertyByType("arv");
                com.baidu.mshield.b.c.a.a(" romVersion: " + propertyByType2.toLowerCase());
                if (!TextUtils.isEmpty(propertyByType2)) {
                    strT = com.baidu.mshield.b.f.e.a(propertyByType2.toLowerCase());
                    bVar.e(strT);
                }
            }
            jSONObject3.put("7", strT);
            String strD2 = f.d(context);
            if (TextUtils.isEmpty(strD2)) {
                jSONObject3.put("9", "");
            } else {
                try {
                    jSONObject3.put("9", new JSONObject(strD2).optString("2", ""));
                } catch (Throwable th) {
                    f.b(th);
                }
            }
            jSONObject2.put("f", jSONObject3);
            jSONObject.put("module_section", new JSONArray().put(jSONObject2));
            com.baidu.mshield.b.c.a.a("f/2/sig post body : " + jSONObject.toString());
            return aVar.c(jSONObject.toString());
        } catch (Throwable unused) {
            return "";
        }
    }
}
