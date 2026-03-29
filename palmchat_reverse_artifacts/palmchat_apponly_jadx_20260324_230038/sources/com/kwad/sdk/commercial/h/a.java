package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0598a {
        private static final a aAM = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a FP() {
        return C0598a.aAM;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(FP());
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.OS().f("d", str, str2);
    }

    public final void df(String str) {
        try {
            if (this.mHasInit.get()) {
                return;
            }
            Context contextRe = ServiceProvider.Re();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.OS().a(str, g.ON().gr(ServiceProvider.getSDKConfig().appId).gs(ServiceProvider.getSdkVersion()).gt(bd.getOaid()).gw(bd.dA(contextRe)).gu(bd.getDeviceId()).gv(bd.dB(contextRe)).n(fVar.Db()).bP(com.kwad.sdk.components.g.encryptDisable()).gx(fVar.Da()).i(fVar.Dd()).o(fVar.Dc()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }

                @Override // com.kwad.sdk.i.f
                public final String av(String str2) {
                    return fVar.av(str2);
                }
            });
            b.Ji();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.h.schedule(new bg() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.OS().OT();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.mHasInit.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.OS().f("e", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.OS().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.OS().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.OS().f(RXScreenCaptureService.KEY_WIDTH, str, str2);
    }

    private a() {
        this.mHasInit = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        h.OS().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        h.OS().f(RXScreenCaptureService.KEY_WIDTH, str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
    }
}
