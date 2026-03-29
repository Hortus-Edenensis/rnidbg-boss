package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.gh;
import com.kuaishou.weapon.p0.jni.Engine;
import com.lantern.auth.server.WkParams;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7439a;

    public cj(Context context) {
        this.f7439a = context;
    }

    public JSONObject a() {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f7439a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (hVarA.b(df.G, 1) == 1) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (hVarA.b(df.K, 0) == 1 && Engine.loadSuccess) {
                    ap apVar = new ap(this.f7439a);
                    jSONObject.put("0", apVar.b("0"));
                    jSONObject.put("1", apVar.b("1"));
                    jSONObject.put("2", apVar.b("2"));
                    jSONObject.put("4", apVar.b("4"));
                    jSONObject.put("5", apVar.b("5"));
                    jSONObject.put("6", apVar.b("6"));
                    jSONObject.put("7", apVar.b("7"));
                    jSONObject.put("8", apVar.b("8"));
                    jSONObject.put("9", apVar.b("9"));
                    jSONObject.put("10", apVar.b("10"));
                    jSONObject.put("11", apVar.b("11"));
                    jSONObject.put(BaseWrapper.ENTER_ID_MARKET, apVar.b(BaseWrapper.ENTER_ID_MARKET));
                    jSONObject.put(BaseWrapper.ENTER_ID_GAME_CENTER, apVar.b(BaseWrapper.ENTER_ID_GAME_CENTER));
                    jSONObject.put(BaseWrapper.ENTER_ID_AD_SDK, apVar.b(BaseWrapper.ENTER_ID_AD_SDK));
                    jSONObject.put("15", apVar.b("15"));
                    jSONObject.put("16", apVar.b("16"));
                    jSONObject.put(BaseWrapper.ENTER_ID_17, apVar.b(BaseWrapper.ENTER_ID_17));
                    jSONObject.put(BaseWrapper.ENTER_ID_18, apVar.b(BaseWrapper.ENTER_ID_18));
                    jSONObject.put(BaseWrapper.ENTER_ID_19, apVar.b(BaseWrapper.ENTER_ID_19));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_HELPER, apVar.b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                    jSONObject.put("21", apVar.b("21"));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING, apVar.b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                    jSONObject.put(BaseWrapper.ENTER_ID_SHORTCUT, apVar.b(BaseWrapper.ENTER_ID_SHORTCUT));
                    jSONObject.put("24", apVar.b("24"));
                    jSONObject.put("25", apVar.b("25"));
                    jSONObject.put("26", apVar.b("26"));
                    jSONObject.put("27", apVar.b("27"));
                    jSONObject.put("28", apVar.b("28"));
                    jSONObject.put("29", apVar.b("29"));
                    jSONObject.put(BaseWrapper.ENTER_ID_TOOLKIT, apVar.b(BaseWrapper.ENTER_ID_TOOLKIT));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_DEMO, apVar.b(BaseWrapper.ENTER_ID_OAPS_DEMO));
                    jSONObject.put("32", apVar.b("32"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ROAMING, apVar.b(BaseWrapper.ENTER_ID_OAPS_ROAMING));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN, apVar.b(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, apVar.b(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, apVar.b(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_GAMESPACE, apVar.b(BaseWrapper.ENTER_ID_OAPS_GAMESPACE));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH, apVar.b(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SCANNER, apVar.b(BaseWrapper.ENTER_ID_OAPS_SCANNER));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, apVar.b(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER));
                    jSONObject.put("41", apVar.b("41"));
                    jSONObject.put("42", apVar.b("42"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_CLOUD, apVar.a(BaseWrapper.ENTER_ID_OAPS_CLOUD));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SECUREPAY, apVar.a(BaseWrapper.ENTER_ID_OAPS_SECUREPAY));
                    jSONObject.put("101", apVar.b("101"));
                    jSONObject.put("102", apVar.b("102"));
                    jSONObject.put("105", apVar.b("105"));
                    jSONObject.put("106", apVar.b("106"));
                    jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.V, dl.b(this.f7439a));
                }
                if (hVarA.b(df.J, 1) == 1 && Engine.loadSuccess) {
                    at atVar = new at(this.f7439a);
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_RECENTS, atVar.d(BaseWrapper.ENTER_ID_OAPS_RECENTS));
                    if (atVar.a()) {
                        i2 = 1;
                        jSONObject.put("93", 1);
                    } else {
                        i2 = 1;
                    }
                    if (atVar.b()) {
                        jSONObject.put("94", i2);
                    }
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, atVar.d(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP));
                    jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, atVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                    jSONObject.put("51", atVar.b("51"));
                    i = 0;
                    jSONObject.put("52", atVar.a(this.f7439a, "52", 0));
                    jSONObject.put("55", atVar.c("55"));
                    jSONObject.put("66", atVar.a("66"));
                    jSONObject.put("67", di.d());
                    jSONObject.put("78", atVar.a("78"));
                    jSONObject.put("79", atVar.a("79"));
                    az azVar = new az(this.f7439a, 200);
                    jSONObject.put(gh.Code, azVar.a(gh.Code));
                    jSONObject.put("71", azVar.a("71"));
                    jSONObject.put("72", azVar.a("72"));
                    jSONObject.put("73", azVar.a("73"));
                    jSONObject.put("74", azVar.a("74"));
                } else {
                    i = 0;
                }
                if (hVarA.b(df.M, 1) == 1) {
                    ax axVar = new ax(this.f7439a);
                    jSONObject.put("53", axVar.a(this.f7439a, "53", 1));
                    jSONObject.put("56", axVar.a("56"));
                    jSONObject.put("57", axVar.a("57"));
                    jSONObject.put("64", di.a());
                }
                if (hVarA.b(df.N, 1) == 1) {
                    cs csVar = new cs();
                    jSONObject.put("98", csVar.a());
                    jSONObject.put("107", csVar.b());
                    String strD = am.d();
                    if (!TextUtils.isEmpty(strD)) {
                        jSONObject.put("77", strD);
                    }
                    jSONObject.put("104", am.c());
                    jSONObject.put("109", dl.e(this.f7439a));
                    aj ajVar = new aj(this.f7439a);
                    jSONObject.put("82", ajVar.h());
                    String strI = ajVar.i();
                    if (!TextUtils.isEmpty(strI)) {
                        jSONObject.put("83", strI);
                    }
                    String strJ = ajVar.j();
                    if (!TextUtils.isEmpty(strJ)) {
                        jSONObject.put("84", strJ);
                    }
                    String strK = ajVar.k();
                    if (!TextUtils.isEmpty(strK)) {
                        jSONObject.put(WkParams.COUNTCODE, strK);
                    }
                }
                if (hVarA.b(df.L, 1) == 1) {
                    au auVar = new au(this.f7439a);
                    jSONObject.put("95", auVar.b("95"));
                    jSONObject.put("96", auVar.a() ? 1 : 0);
                    jSONObject.put("97", di.e());
                    try {
                        jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Oe().Od()));
                        jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Oe().getSdkVersion()));
                        jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Oe().getAppId()));
                    } catch (Throwable unused) {
                    }
                }
                jSONObject.put("11006", zE ? 1 : 0);
                if (zE2) {
                    i = 1;
                }
                jSONObject.put("11029", i);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new cm(str, ck.l).a(this.f7439a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
