package com.kwad.sdk.core.webview.d;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static final class C0620a extends com.kwad.sdk.core.response.a.a {
        public String Mi;
        public int QW;
        public int QX;
        public String SDKVersion;
        public int SDKVersionCode;
        public String aGW;
        public String aGX;
        public String aMW;
        public String aMZ;
        public String aMl;
        public String aNa;
        public String aNn;
        public String aSG;
        public String aSH;
        public boolean aSI;
        public String aSJ;
        public String ahc;
        public String ahd;
        public int ahe;
        public String ahf;
        public int ahg;
        public String ahh;
        public String ahi;
        public int ahj;
        public int ahk;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0620a MR() {
            C0620a c0620a = new C0620a();
            c0620a.SDKVersion = BuildConfig.VERSION_NAME;
            c0620a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0620a.aMl = "6.1.8";
            c0620a.aSJ = "1.3";
            c0620a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0620a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0620a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0620a.appVersion = m.cN(context);
            c0620a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0620a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0620a.aSG = "";
            c0620a.aNa = ag.getEGid();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0620a.aMZ = hVar.qt();
            }
            c0620a.ahc = String.valueOf(ao.dp(context));
            c0620a.ahd = br.TU();
            c0620a.model = br.TK();
            c0620a.Mi = br.TM();
            c0620a.ahe = 1;
            c0620a.ahf = br.getOsVersion();
            c0620a.ahg = br.TX();
            c0620a.ahh = br.getLanguage();
            c0620a.ahi = br.getLocale();
            c0620a.aSI = ((f) ServiceProvider.get(f.class)).CT();
            c0620a.aSH = bd.getDeviceId();
            c0620a.QX = br.getScreenWidth(context);
            c0620a.QW = br.getScreenHeight(context);
            c0620a.aGW = bd.dA(context);
            c0620a.aGX = bd.getOaid();
            c0620a.aMW = bd.dB(context);
            c0620a.aNn = bd.dC(context);
            c0620a.ahj = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0620a.ahk = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0620a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull c cVar) {
        cVar.a(C0620a.MR());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
