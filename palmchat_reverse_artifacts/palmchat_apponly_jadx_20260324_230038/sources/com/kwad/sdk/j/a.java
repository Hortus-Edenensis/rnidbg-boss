package com.kwad.sdk.j;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class C0628a extends com.kwad.sdk.commercial.c.a {
        public String aTr;
        public int aYq;
        public String sdkVersion;
    }

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class b extends com.kwad.sdk.commercial.c.a {
        public int aYr;
        public String aYs;
        public String aYt;
        public String aYu;
        public String aYv;
        public String aYw;
    }

    public static void Py() {
        h.execute(new bg() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.Pz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Pz() {
        C0628a c0628aA;
        JSONObject jSONObject = (JSONObject) e.Hl().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.a.2
            private static JSONObject p(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return p(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.aYr == 1 && (c0628aA = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_tt_sdk_info", "sv").z(c0628aA).a(com.kwai.adclient.kscommerciallogger.model.a.bjx));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static C0628a a(ClassLoader classLoader, b bVar) {
        Class<?> clsA = z.a(bVar.aYs, classLoader);
        if (clsA == null) {
            return null;
        }
        C0628a c0628a = new C0628a();
        c0628a.aYq = z.classExists(bVar.aYt) ? 1 : 0;
        Object objCallStaticMethod = z.callStaticMethod(clsA, bVar.aYu, new Object[0]);
        c0628a.sdkVersion = (String) z.callMethod(objCallStaticMethod, bVar.aYv, new Object[0]);
        c0628a.aTr = (String) z.callMethod(objCallStaticMethod, bVar.aYw, new Object[0]);
        return c0628a;
    }
}
