package com.baidu.mshield.x0.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.l;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.az;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f4070a;
    public final Context b;

    /* JADX INFO: renamed from: com.baidu.mshield.x0.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0099a extends com.baidu.mshield.x0.d.h.b {
        public final /* synthetic */ b b;

        public C0099a(b bVar) {
            this.b = bVar;
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            a.this.a(this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(int i);
    }

    public a(Context context) {
        this.b = context;
    }

    public final void b(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleRmfPolicy:" + jSONObject);
            if (jSONObject == null) {
                l.e = "";
                return;
            }
            boolean zA = f.a(this.b, false);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.b);
            if (zA) {
                bVar.v(jSONObject.toString());
                l.e = "";
            } else {
                l.e = jSONObject.toString();
                bVar.p();
            }
            com.baidu.mshield.b.c.a.b("handleRmfPolicy ungz:" + new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized a a(Context context) {
        if (f4070a == null) {
            f4070a = new a(context);
        }
        return f4070a;
    }

    public final int a(b bVar) {
        boolean zA;
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.b);
            long j = aVar.j();
            long jM = ((long) aVar.m()) * 60000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jM <= 0) {
                if (bVar != null) {
                    bVar.a(1);
                }
                return 1;
            }
            if (jCurrentTimeMillis - j >= jM) {
                zA = d.n(this.b) ? a() : false;
                aVar.c(jCurrentTimeMillis);
            } else {
                zA = false;
            }
            if (zA) {
                if (bVar != null) {
                    bVar.a(0);
                }
                return 0;
            }
            if (bVar != null) {
                bVar.a(1);
            }
            return 1;
        } catch (Throwable th) {
            d.a(th);
            if (bVar != null) {
                bVar.a(2);
            }
            return 2;
        }
    }

    public final void b(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleFgPolicy:" + str);
            l.b(this.b, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int a(b bVar, boolean z) {
        if (z) {
            com.baidu.mshield.x0.d.h.d.b().a(new C0099a(bVar));
            return 0;
        }
        return a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x016e, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x016e, blocks: (B:5:0x0008, B:22:0x004a, B:26:0x0059, B:76:0x0168, B:72:0x0141, B:65:0x0128, B:58:0x010f, B:51:0x00da, B:47:0x00b1, B:40:0x009b, B:33:0x0085, B:21:0x0045, B:66:0x012b, B:68:0x0133, B:69:0x0137, B:41:0x009e, B:43:0x00a6, B:44:0x00aa, B:27:0x0072, B:29:0x007a, B:30:0x007e, B:73:0x0144, B:59:0x0112, B:61:0x011a, B:62:0x011e, B:48:0x00b4, B:34:0x0088, B:36:0x0090, B:37:0x0094, B:52:0x00dd, B:54:0x00e5, B:55:0x0108), top: B:107:0x0008, inners: #0, #1, #4, #5, #6, #7, #9, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean a() {
        String str;
        Throwable th;
        String str2;
        String str3;
        HashMap<String, String> mapB;
        String str4 = "";
        String str5 = "";
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.b);
            try {
                mapB = new com.baidu.mshield.x0.i.a(this.b, null).b();
            } catch (Throwable th2) {
                str = "";
                th = th2;
            }
            if (mapB == null) {
                return false;
            }
            str2 = mapB.get("decrpt");
            try {
                str3 = mapB.get("url");
                try {
                    str5 = mapB.get(az.at);
                } catch (Throwable th3) {
                    th = th3;
                    str = str3;
                    str4 = str2;
                    d.a(th);
                    str2 = str4;
                    str3 = str;
                }
            } catch (Throwable th4) {
                str = "";
                th = th4;
            }
            aVar.d(System.currentTimeMillis());
            if (!TextUtils.isEmpty(str2)) {
                return false;
            }
            com.baidu.mshield.b.c.a.b("policy sdata====" + str2);
            JSONObject jSONObject = new JSONObject(str2);
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("sec");
                if (jSONObject2 != null) {
                    a(jSONObject2, str2, str3, str5);
                } else {
                    com.baidu.mshield.b.c.a.b("sec sdata is empty ");
                }
            } catch (Throwable th5) {
                d.a(th5);
            }
            try {
                String strOptString = jSONObject.optString("fig");
                if (strOptString != null) {
                    b(strOptString);
                } else {
                    com.baidu.mshield.b.c.a.b("finger sdata is empty ");
                }
            } catch (Throwable th6) {
                d.a(th6);
            }
            try {
                String strOptString2 = jSONObject.optString("sig");
                if (strOptString2 != null) {
                    a(strOptString2);
                } else {
                    com.baidu.mshield.b.c.a.b("sig sdata is empty ");
                }
            } catch (Throwable th7) {
                d.a(th7);
            }
            try {
                String strOptString3 = jSONObject.optString("prv");
                com.baidu.mshield.b.c.a.b("privacyPolicy===" + strOptString3);
                new com.baidu.mshield.x0.l.c(this.b).c(strOptString3);
            } catch (Throwable th8) {
                d.a(th8);
            }
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sgs");
                if (jSONObjectOptJSONObject != null) {
                    com.baidu.mshield.b.c.a.b("sgs data ：" + jSONObjectOptJSONObject.toString());
                    l.b = jSONObjectOptJSONObject.optString("3", "");
                } else {
                    com.baidu.mshield.b.c.a.b("sgs sdata is empty ");
                }
            } catch (Throwable th9) {
                d.a(th9);
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("drf");
                if (jSONObjectOptJSONObject2 != null) {
                    a(jSONObjectOptJSONObject2);
                } else {
                    com.baidu.mshield.b.c.a.b("drf sdata is empty ");
                    a((JSONObject) null);
                }
            } catch (Throwable th10) {
                d.a(th10);
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rmf");
                if (jSONObjectOptJSONObject3 != null) {
                    b(jSONObjectOptJSONObject3);
                } else {
                    com.baidu.mshield.b.c.a.b("rmf sdata is empty ");
                    b((JSONObject) null);
                }
            } catch (Throwable th11) {
                d.a(th11);
            }
            try {
                String strOptString4 = jSONObject.optString(OapsKey.KEY_IDS);
                com.baidu.mshield.b.c.a.b("ids===" + strOptString4);
                EngineImpl.getInstance(this.b).ids = strOptString4;
            } catch (Throwable th12) {
                d.a(th12);
            }
            return true;
            d.a(th);
            str2 = str4;
            str3 = str;
            aVar.d(System.currentTimeMillis());
            if (!TextUtils.isEmpty(str2)) {
            }
        } catch (Throwable th13) {
            d.a(th13);
            return false;
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("handleDrfPolicy:" + jSONObject);
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(this.b);
            if (jSONObject == null) {
                l.d = "";
                return;
            }
            l.d = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("handleDrfPolicy ungz:" + new String(c.b(Base64.decode(jSONObject.optString("1").getBytes(), 0)), "utf-8"));
            bVar.g(jSONObject.optString("2"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(com.baidu.mshield.x0.l.a aVar, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("5");
        if (jSONObjectOptJSONObject != null) {
            int iOptInt = jSONObjectOptJSONObject.optInt("1", 0);
            if (iOptInt == 0 && aVar.d()) {
                EngineImpl.getInstance(this.b).unload();
            }
            aVar.b(iOptInt);
            aVar.f(jSONObjectOptJSONObject.optInt("9", 0));
            aVar.g(jSONObjectOptJSONObject.optInt("15", 3));
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2, String str3) {
        String str4;
        String strOptString;
        String strOptString2;
        int iOptInt;
        try {
            com.baidu.mshield.b.c.a.b("handleSecPolicy:" + jSONObject.toString());
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(this.b);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("3");
            if (jSONObjectOptJSONObject != null) {
                str4 = "95";
                try {
                    aVar.b("plc03", jSONObjectOptJSONObject.toString());
                    com.baidu.mshield.b.c.a.b("3" + jSONObjectOptJSONObject);
                } catch (Throwable th) {
                    th = th;
                    d.a(th);
                    return;
                }
            } else {
                str4 = "95";
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("15");
            if (jSONObjectOptJSONObject2 != null) {
                aVar.b("plc15", jSONObjectOptJSONObject2.toString());
                com.baidu.mshield.b.c.a.b("15" + jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("16");
            if (jSONObjectOptJSONObject3 != null) {
                aVar.b("plc16", jSONObjectOptJSONObject3.toString());
                com.baidu.mshield.b.c.a.b("16" + jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_18);
            if (jSONObjectOptJSONObject4 != null) {
                aVar.b("plc18", jSONObjectOptJSONObject4.toString());
                com.baidu.mshield.b.c.a.b(BaseWrapper.ENTER_ID_18 + jSONObjectOptJSONObject4);
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_SYSTEM_HELPER);
            if (jSONObjectOptJSONObject5 != null) {
                aVar.b("plc20", jSONObjectOptJSONObject5.toString());
                com.baidu.mshield.b.c.a.b(BaseWrapper.ENTER_ID_SYSTEM_HELPER + jSONObjectOptJSONObject5);
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET);
            if (jSONObjectOptJSONObject6 != null) {
                aVar.b("plc36", jSONObjectOptJSONObject6.toString());
                com.baidu.mshield.b.c.a.b(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET + jSONObjectOptJSONObject6);
            }
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("62");
            if (jSONObjectOptJSONObject7 != null) {
                aVar.b("plc62", jSONObjectOptJSONObject7.toString());
                com.baidu.mshield.b.c.a.b("62" + jSONObjectOptJSONObject7.toString());
            }
            JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("71");
            if (jSONObjectOptJSONObject8 != null) {
                aVar.b("plc71", jSONObjectOptJSONObject8.toString());
                com.baidu.mshield.b.c.a.b("71" + jSONObjectOptJSONObject8);
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("83");
            if (jSONObjectOptJSONObject9 != null) {
                aVar.b("plc83", jSONObjectOptJSONObject9.toString());
                com.baidu.mshield.b.c.a.b("83" + jSONObjectOptJSONObject9);
            }
            JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject("84");
            if (jSONObjectOptJSONObject10 != null) {
                aVar.b("plc84", jSONObjectOptJSONObject10.toString());
                com.baidu.mshield.b.c.a.b("84" + jSONObjectOptJSONObject10);
            }
            JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("94");
            if (jSONObjectOptJSONObject11 != null) {
                aVar.b("plc94", jSONObjectOptJSONObject11.toString());
                com.baidu.mshield.b.c.a.b("94" + jSONObjectOptJSONObject11);
            }
            String str5 = str4;
            JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject(str5);
            if (jSONObjectOptJSONObject12 != null) {
                aVar.b("plc95", jSONObjectOptJSONObject12.toString());
                com.baidu.mshield.b.c.a.b(str5 + jSONObjectOptJSONObject12.toString());
            }
            JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("107");
            if (jSONObjectOptJSONObject13 != null) {
                aVar.b("plc107", jSONObjectOptJSONObject13.toString());
                com.baidu.mshield.b.c.a.b("107" + jSONObjectOptJSONObject13.toString());
                if (jSONObjectOptJSONObject13.has("5")) {
                    JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject13.optJSONObject("5");
                    if (jSONObjectOptJSONObject14.has("t")) {
                        aVar.d(jSONObjectOptJSONObject14.optInt("t", EffectConstants.ROTATION_DEGREES_180));
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("51");
            if (jSONObjectOptJSONObject15 != null) {
                aVar.b("plc51", jSONObjectOptJSONObject15.toString());
                try {
                    a(aVar, jSONObjectOptJSONObject15);
                    com.baidu.mshield.b.c.a.b("51" + jSONObjectOptJSONObject15.toString());
                } catch (Throwable th2) {
                    th = th2;
                    d.a(th);
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("102");
            if (jSONObjectOptJSONObject16 != null) {
                aVar.b("plc102", jSONObjectOptJSONObject16.toString());
                int iOptInt2 = jSONObjectOptJSONObject16.optJSONObject("5").optInt("1", 60);
                aVar.c(iOptInt2);
                com.baidu.mshield.x0.g.a.d = iOptInt2;
                com.baidu.mshield.b.c.a.b("102" + jSONObjectOptJSONObject16.toString());
            }
            JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("104");
            if (jSONObjectOptJSONObject17 != null) {
                aVar.b("plc104", jSONObjectOptJSONObject17.toString());
                com.baidu.mshield.b.c.a.b("104" + jSONObjectOptJSONObject17.toString());
            }
            JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("114");
            if (jSONObjectOptJSONObject18 != null) {
                com.baidu.mshield.b.c.a.b("114" + jSONObjectOptJSONObject18.toString());
                JSONObject jSONObjectOptJSONObject19 = jSONObjectOptJSONObject18.optJSONObject("5");
                if (jSONObjectOptJSONObject19.has("uv6") && jSONObjectOptJSONObject19.optJSONObject("uv6").has("2")) {
                    com.baidu.mshield.x0.c.a.f4049a = jSONObjectOptJSONObject19.optJSONObject("uv6").optString("2");
                    com.baidu.mshield.b.c.a.b("policy detect app encrypt===" + com.baidu.mshield.x0.c.a.f4049a);
                    jSONObjectOptJSONObject19.optJSONObject("uv6").remove("2");
                    com.baidu.mshield.b.c.a.b("policy detect encryptStr====" + com.baidu.mshield.x0.c.a.f4049a);
                    aVar.b("plc114", jSONObjectOptJSONObject18.toString());
                } else {
                    aVar.b("plc114", jSONObjectOptJSONObject18.toString());
                }
            }
            JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("115");
            if (jSONObjectOptJSONObject20 != null) {
                String strC = aVar.c("plc115");
                String strOptString3 = "";
                if (TextUtils.isEmpty(strC)) {
                    strOptString = "";
                    strOptString2 = strOptString;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strC);
                    aVar.a(jSONObject2.optInt("3"));
                    JSONObject jSONObjectOptJSONObject21 = jSONObject2.optJSONObject("5");
                    strOptString2 = (jSONObjectOptJSONObject21.has("uv4") && jSONObjectOptJSONObject21.optJSONObject("uv4").has("2")) ? jSONObjectOptJSONObject21.optJSONObject("uv4").optString("2") : "";
                    strOptString = (jSONObjectOptJSONObject21.has("uv4") && jSONObjectOptJSONObject21.optJSONObject("uv4").has("4")) ? jSONObjectOptJSONObject21.optJSONObject("uv4").optString("4") : "";
                }
                com.baidu.mshield.b.c.a.b("115" + jSONObjectOptJSONObject20.toString());
                JSONObject jSONObjectOptJSONObject22 = jSONObjectOptJSONObject20.optJSONObject("5");
                if (jSONObjectOptJSONObject22.has("uv4")) {
                    JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject22.optJSONObject("uv4");
                    if (jSONObjectOptJSONObject23.has("4")) {
                        strOptString3 = jSONObjectOptJSONObject23.optString("4");
                        aVar.e(strOptString3);
                    }
                    int i = 0;
                    if (jSONObjectOptJSONObject23.has("7")) {
                        int iOptInt3 = jSONObjectOptJSONObject23.optJSONObject("7").optInt("2", 0);
                        iOptInt = jSONObjectOptJSONObject23.optJSONObject("7").optInt("3", 0);
                        i = iOptInt3;
                    } else {
                        iOptInt = 0;
                    }
                    if (jSONObjectOptJSONObject23.has("2")) {
                        String strOptString4 = jSONObjectOptJSONObject23.optString("2");
                        if (i != 0 && !TextUtils.isEmpty(strOptString3)) {
                            if (TextUtils.isEmpty(strOptString4) && !TextUtils.isEmpty(strOptString3) && strOptString3.equals(strOptString)) {
                                jSONObjectOptJSONObject23.put("2", strOptString2);
                            }
                        } else {
                            com.baidu.mshield.x0.c.c.f4051a = strOptString4;
                            jSONObjectOptJSONObject23.remove("2");
                        }
                    }
                    if (!TextUtils.isEmpty(strOptString3) && !strOptString3.equals(strOptString) && iOptInt == 1) {
                        aVar.a(0L);
                    }
                    aVar.b("plc115", jSONObjectOptJSONObject20.toString());
                } else {
                    aVar.b("plc115", jSONObjectOptJSONObject20.toString());
                }
            }
            aVar.a(true);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void a(String str) {
        try {
            com.baidu.mshield.b.c.a.b("handleEmulatorSig:" + str);
            if (!TextUtils.isEmpty(str)) {
                String strA = e.a(str);
                l.c = strA;
                new com.baidu.mshield.x6.b.b(this.b).h(strA);
                String str2 = new String(c.b(Base64.decode(str.getBytes(), 0)), "utf-8");
                com.baidu.mshield.b.c.a.b("handleEmulatorSig ungz:" + str2);
                l.f4090a = str2;
            } else {
                f.c(this.b);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
