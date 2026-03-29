package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static ExecutorService aBP = GlobalThreadPools.Lk();
    public static JSONObject aBQ;
    public static boolean aBR;

    /* JADX INFO: compiled from: SearchBox */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    private static int Gn() {
        return aq.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean H(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String strAz = com.kwad.sdk.core.response.b.a.az(adInfo);
        if (TextUtils.isEmpty(strAz)) {
            return false;
        }
        return as.as(fVar.getContext(), strAz);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cn(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    public static void bU(AdTemplate adTemplate) {
        r(adTemplate, 4);
    }

    public static void bV(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0601a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void bW(AdTemplate adTemplate) {
        r(adTemplate, 36);
    }

    public static void bX(AdTemplate adTemplate) {
        r(adTemplate, 38);
    }

    public static void bY(AdTemplate adTemplate) {
        r(adTemplate, 41);
    }

    public static void bZ(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aBP.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.C0601a c0601a = new a.C0601a();
                c0601a.aBx = adTemplate.downLoadType;
                com.kwad.sdk.core.adlog.c.b bVarDy = new com.kwad.sdk.core.adlog.c.b().b(c0601a).dy(adTemplate.downloadSource);
                c.a(adTemplate, bVarDy);
                c.a(adTemplate, 31, bVarDy.GB(), jSONObject);
                AdInfo adInfoEr = e.er(adTemplate);
                as.ay(adInfoEr.downloadFilePath, adInfoEr.downloadId);
            }
        });
    }

    public static void ca(@Nullable AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void cb(@Nullable AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void cc(@Nullable AdTemplate adTemplate) {
        r(adTemplate, 58);
    }

    public static void cd(AdTemplate adTemplate) {
        r(adTemplate, DetailedCreativeType.LONG_TEXT);
    }

    public static void ce(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bB(e.er(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void cf(AdTemplate adTemplate) {
        r(adTemplate, 722);
    }

    public static void cg(AdTemplate adTemplate) {
        r(adTemplate, 721);
    }

    public static void ch(AdTemplate adTemplate) {
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0601a.aBM = 1;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0601a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.GB(), (JSONObject) null);
    }

    private static boolean ci(AdTemplate adTemplate) {
        if (e.ej(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aU(adTemplate);
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0601a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aBP.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo adInfoEr = e.er(adTemplate);
                int iAz = as.az(adInfoEr.downloadId, com.kwad.sdk.core.response.b.a.az(adInfoEr));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                AdTemplate adTemplate2 = adTemplate;
                aVar.downloadSource = adTemplate2.downloadSource;
                aVar.aCD = iAz;
                aVar.aCE = adTemplate2.installFrom;
                aVar.a(new a.C0601a());
                a.C0601a c0601a = aVar.PJ;
                AdTemplate adTemplate3 = adTemplate;
                c0601a.aBx = adTemplate3.downLoadType;
                c.a(adTemplate3, 32, aVar, jSONObject);
            }
        });
    }

    public static void f(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCU = i;
        aVar.a(new a.C0601a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.PK = i;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static void j(@Nullable AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCC = i;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(@Nullable AdTemplate adTemplate, int i) {
        h(adTemplate, i, 0);
    }

    public static void l(@Nullable AdTemplate adTemplate, long j) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Gz().av(j), (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCm = i;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void o(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i) {
        e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().dx(i));
    }

    public static void q(AdTemplate adTemplate, int i) {
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0601a.aBM = i;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0601a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.GB(), (JSONObject) null);
    }

    private static void r(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    public static boolean b(@NonNull AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo adInfoEr = e.er(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dJ(Gn());
        com.kwad.sdk.core.adlog.c.a aVarGB = bVar.GB();
        if (adTemplate.fromCache) {
            aVarGB.a(h.cn(adTemplate));
        }
        aVarGB.aCP = H(adInfoEr) ? 1 : 0;
        return a(adTemplate, 1, aVarGB, jSONObject);
    }

    public static void c(@Nullable AdTemplate adTemplate, String str, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, 803, aVar, (JSONObject) null);
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarGB = bVar.GB();
        aVarGB.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, aVarGB, jSONObject);
    }

    public static void g(@Nullable AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0601a c0601a = new a.C0601a();
        if (z) {
            c0601a.aBB = 1;
        } else {
            c0601a.aBB = 2;
        }
        aVar.a(c0601a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, jSONObject);
    }

    public static void l(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCn = i;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void j(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCr = j;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCp = 69;
        aVar.aCK = i;
        aVar.aCL = i2;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBy = 2;
        bVar.b(c0601a);
        if (z) {
            bVar.dE(33);
        }
        a(adTemplate, 804, bVar.GB(), (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCN = j;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, @Nullable aj.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.mH = i;
        int i2 = adTemplate.swipeAngle;
        if (i2 != 0) {
            aVar2.aCY = i2;
        }
        if (aVar != null) {
            aVar2.mJ = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarGB = bVar.GB();
        aVarGB.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVarGB, jSONObject);
    }

    public static void c(AdTemplate adTemplate, @Nullable JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, bVar != null ? bVar.GB() : null, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCo = 1;
        a.C0601a c0601a = new a.C0601a();
        aVar.PJ = c0601a;
        c0601a.templateId = "101";
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCI = com.kwad.sdk.core.response.b.a.az(e.er(adTemplate));
        aVar.aCp = 93;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVar, (JSONObject) null);
    }

    private static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static void i(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBy = 1;
        bVar.b(c0601a);
        if (z) {
            bVar.dE(33);
        }
        a(adTemplate, 804, bVar.GB(), (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.GB() : null, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, @Nullable JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.GB() : null, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCO = i;
        aVar.PL = i2;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, long j, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0601a c0601a = new a.C0601a();
        if (j != -1) {
            c0601a.duration = j;
            aVar.PJ = c0601a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0601a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    public static void h(@Nullable AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0601a c0601a = new a.C0601a();
        if (z) {
            c0601a.aBB = 1;
        } else {
            c0601a.aBB = 2;
        }
        aVar.a(c0601a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCo = i;
        a.C0601a c0601a = new a.C0601a();
        c0601a.duration = j;
        aVar.PJ = c0601a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(@Nullable AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.yY = j;
        aVar.aCR = i2;
        aVar.aCo = i;
        a.C0601a c0601a = new a.C0601a();
        c0601a.duration = j2;
        aVar.PJ = c0601a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void b(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().dx(i));
    }

    public static void a(AdTemplate adTemplate, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0601a());
        aVar.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo adInfoEr = e.er(adTemplate);
        String str = adInfoEr.downloadFilePath;
        if (str == null) {
            return;
        }
        String strAz = com.kwad.sdk.core.response.b.a.az(adInfoEr);
        String strHw = as.hw(str);
        if (strHw == null || TextUtils.isEmpty(strHw) || strHw.equals(strAz)) {
            return;
        }
        bVar.dH(strHw);
        bVar.dG(strAz);
        adInfoEr.adBaseInfo.appPackageName = strHw;
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.aCF = aVar.toJson().toString();
        aVar2.a(new a.C0601a());
        aVar2.PJ.aBx = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCA = i;
        if (!str.equals("")) {
            aVar.aCB = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(@Nullable AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.aCM = j;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, @Nullable JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aCm = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == -9999 || i == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.aCs = i;
            if (adExposureFailedReason != null) {
                aVar.aCt = adExposureFailedReason.winEcpm;
                try {
                    int i2 = adExposureFailedReason.adnType;
                    aVar.adnType = i2;
                    if (i2 == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.aCu = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.aCv = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.aCw = adExposureFailedReason.adRequestId;
                    }
                    aVar.aCx = adExposureFailedReason.isShow;
                    aVar.aCy = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.PI = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0601a c0601a = new a.C0601a();
        c0601a.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        c0601a.aBJ = str;
        c0601a.aBK = str2;
        c0601a.aBL = i;
        bVar.b(c0601a);
        a(adTemplate, 1024, bVar.GB(), (JSONObject) null);
    }

    public static boolean a(@Nullable AdTemplate adTemplate, int i, @Nullable com.kwad.sdk.core.adlog.c.a aVar, @Nullable JSONObject jSONObject) {
        if (adTemplate == null || !ci(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aCQ = com.kwad.sdk.core.response.b.a.aU(e.er(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i == 2 && aBR) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0601a();
            }
            aVar.PJ.aBE = aBQ;
        }
        if (i == 1 && e.el(adTemplate) == 4 && com.kwad.sdk.core.response.b.a.dw(e.er(adTemplate))) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0601a();
            }
            aVar.PJ.aBD = com.kwad.sdk.core.response.b.a.dx(e.er(adTemplate));
        }
        if (i == 1 || i == 2) {
            if (aVar.PJ == null) {
                aVar.PJ = new a.C0601a();
            }
            aVar.PJ.aBI = com.kwad.sdk.core.response.b.a.dA(e.er(adTemplate)) ? 1 : 0;
        }
        aVar.adTemplate = adTemplate;
        aVar.aAV = i;
        aVar.aCl = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        com.kwad.sdk.core.d.c.d("AdReportManager", sb.toString());
        b.a(aVar);
        return true;
    }
}
