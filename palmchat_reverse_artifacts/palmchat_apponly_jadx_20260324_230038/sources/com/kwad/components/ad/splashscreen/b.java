package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.media3.common.C;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private volatile boolean Fx;

        private a() {
            this.Fx = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0514b {
        private volatile boolean Fy;

        private C0514b() {
            this.Fy = false;
        }

        public static /* synthetic */ boolean a(C0514b c0514b, boolean z) {
            c0514b.Fy = true;
            return true;
        }

        public /* synthetic */ C0514b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0514b c0514b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (!c0514b.Fy) {
            iK.removeCallbacks(runnable);
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
        return true;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(sceneImplCovert);
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.u(sceneImplCovert.getPosId());
        boolean zB = t.uI().b(sceneImplCovert, "loadSplashScreenAd");
        sceneImplCovert.setAdStyle(4);
        sceneImplCovert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.Fx = false;
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        final C0514b c0514b = new C0514b(b);
        com.kwad.components.core.o.a.tz().tB();
        Handler handler = iK;
        handler.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(impInfo);
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        final bg bgVar = new bg() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                C0514b.a(c0514b, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJe;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.mk();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aJe;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, sceneImplCovert.getPosId());
                com.kwad.components.core.o.a.tz().bk(4);
            }
        };
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gj);
        if (iA < 0) {
            iA = 5000;
        }
        handler.postDelayed(bgVar, iA);
        final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.f(sceneImplCovert.getPosId(), jElapsedRealtime3);
        SplashPreloadManager.lO().a(sceneImplCovert.getPosId(), 2);
        List<String> listLP = SplashPreloadManager.lO().lP();
        List<Integer> listI = SplashPreloadManager.lO().i(listLP);
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.a(sceneImplCovert.getPosId(), listLP, listI);
        KsAdLoadManager.M().a(new a.C0560a().e(impInfo).aP(true).aQ(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (c0514b.Fy) {
                    return;
                }
                b.iK.removeCallbacks(bgVar);
                if (!aVar.Fx && i != com.kwad.sdk.core.network.e.aJc.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, sceneImplCovert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, sceneImplCovert.getPosId());
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        splashScreenAdListener.onError(i, str);
                        if (i == com.kwad.sdk.core.network.e.aJf.errorCode) {
                            com.kwad.components.core.o.a.tz().bk(0);
                        } else {
                            com.kwad.components.core.o.a.tz().bk(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00e3 A[Catch: all -> 0x0208, TryCatch #1 {all -> 0x0208, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0137, B:38:0x0146, B:39:0x0164, B:41:0x016d, B:45:0x018c, B:46:0x01a8), top: B:65:0x0061 }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0137 A[Catch: all -> 0x0208, TryCatch #1 {all -> 0x0208, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0137, B:38:0x0146, B:39:0x0164, B:41:0x016d, B:45:0x018c, B:46:0x01a8), top: B:65:0x0061 }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0164 A[Catch: all -> 0x0208, TryCatch #1 {all -> 0x0208, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0137, B:38:0x0146, B:39:0x0164, B:41:0x016d, B:45:0x018c, B:46:0x01a8), top: B:65:0x0061 }] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v9, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void a(@NonNull final AdResultData adResultData, boolean z) {
                boolean ksSplashScreenAdControl;
                boolean zH;
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.mi().t(sceneImplCovert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z, sceneImplCovert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    adTemplate.requestStartTime = jElapsedRealtime;
                    adTemplate.notNetworkRequest = z;
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.e(adTemplate, jElapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(sceneImplCovert, 1);
                    long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                    ksSplashScreenAdControl = new KsSplashScreenAdControl(sceneImplCovert, adResultData);
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Gn)) {
                        try {
                            SplashPreloadManager.lO();
                            if (SplashPreloadManager.i(adResultData)) {
                                if (b.a(c0514b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                if (SplashPreloadManager.lO().h(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.o.a.tz().bk(1);
                                    adTemplate.splashAdLoadType = 2;
                                    return;
                                }
                                if (SplashPreloadManager.lO().a(adResultData, true, 1) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.components.core.o.a.tz().bk(2);
                                    adTemplate.splashAdLoadType = 1;
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                                return;
                            }
                            SplashPreloadManager.lO();
                            if (!SplashPreloadManager.i(adResultData)) {
                                SplashPreloadManager.lO();
                                if (!SplashPreloadManager.j(adResultData)) {
                                    if (b.a(c0514b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                        return;
                                    }
                                    b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                                    com.kwad.components.core.o.a.tz().bk(5);
                                    return;
                                }
                            }
                            zH = SplashPreloadManager.lO().h(adResultData);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + zH);
                            if (!zH) {
                                if (b.a(c0514b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                com.kwad.components.core.o.a.tz().bk(1);
                                adTemplate.splashAdLoadType = 2;
                                return;
                            }
                            SplashPreloadManager.lO();
                            try {
                                if (!SplashPreloadManager.i(adResultData)) {
                                    if (!c0514b.Fy) {
                                        b.iK.removeCallbacks(bgVar);
                                        com.kwad.components.ad.splashscreen.monitor.b.mk();
                                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, jElapsedRealtime4, jElapsedRealtime3);
                                        aVar.Fx = true;
                                        a(com.kwad.sdk.core.network.e.aJd.errorCode, "请求成功，但缓存未命中", z);
                                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                                        com.kwad.components.core.o.a.tz().bk(3);
                                        return;
                                    }
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                    return;
                                }
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                                int iA2 = SplashPreloadManager.lO().a(adResultData, true, 1);
                                if (b.a(c0514b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, bgVar)) {
                                    return;
                                }
                                if (iA2 > 0) {
                                    b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.components.core.o.a.tz().bk(2);
                                    adTemplate.splashAdLoadType = 1;
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.mk();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                                aVar.Fx = true;
                                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aJf;
                                a(eVar.errorCode, eVar.msg, z);
                                return;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            ksSplashScreenAdControl = z;
                        }
                    } else {
                        SplashPreloadManager.lO();
                        if (!SplashPreloadManager.i(adResultData)) {
                        }
                        zH = SplashPreloadManager.lO().h(adResultData);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + zH);
                        if (!zH) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ksSplashScreenAdControl = z;
                }
                ServiceProvider.reportSdkCaughtException(th);
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aJh;
                a(eVar2.errorCode, eVar2.msg, ksSplashScreenAdControl);
            }
        }).tR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a(ksSplashScreenAd);
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    com.kwad.components.ad.splashscreen.monitor.a.mi().ai(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mk();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg, j);
        aVar.Fx = true;
        dVar.a(com.kwad.sdk.core.network.e.aJc.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aJc.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.o.a.tz().bk(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.tz().tC();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.mk();
            com.kwad.components.ad.splashscreen.monitor.b.v(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new a.C0560a().e(impInfo2).aQ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lO().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.mk();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - jElapsedRealtime, sceneImpl.getPosId());
                            com.kwad.components.core.o.a.tz().bl(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.mk();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, sceneImpl.getPosId());
                }
            }).tR());
        }
    }
}
