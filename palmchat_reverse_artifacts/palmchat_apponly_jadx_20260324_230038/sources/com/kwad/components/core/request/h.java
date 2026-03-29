package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean aaM = false;
    private static final List<a> aaN = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void d(@NonNull SdkConfigData sdkConfigData);

        void tN();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b extends a {
        void tO();
    }

    public static synchronized void a(a aVar) {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
        if (sHasInit.get()) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
        } else {
            aaN.add(aVar);
            com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.request.h.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    Context contextRe = ServiceProvider.Re();
                    ag.l(contextRe, ag.de(contextRe) + 1);
                    com.kwad.sdk.core.config.e.bB(contextRe);
                    h.tJ();
                    h.tI();
                }
            });
        }
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        aaM = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(int i, String str) {
        for (a aVar : aaN) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).tO();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void tI() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            @NonNull
            private static SdkConfigData aP(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ag.ao(ServiceProvider.Re(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: tM, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.KG();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aP(str);
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull g gVar, int i, String str) {
                super.onError(gVar, i, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                h.p(i, str);
            }

            private static void c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.U("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bz(ServiceProvider.Re());
                    com.kwad.sdk.core.config.e.f(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    af.Sb();
                    af.RV();
                    ag.l(ServiceProvider.Re(), 0);
                    if (ag.Si() != com.kwad.sdk.core.config.e.HZ()) {
                        ag.f(ServiceProvider.Re(), com.kwad.sdk.core.config.e.HZ());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tJ() {
        Iterator<a> it = aaN.iterator();
        while (it.hasNext()) {
            try {
                it.next().tN();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static void b(a aVar) {
        try {
            aaN.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.tN();
            }
            if (aaM) {
                aVar.d(com.kwad.sdk.core.config.e.Hl());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull SdkConfigData sdkConfigData) {
        Iterator<a> it = aaN.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
