package com.kwad.components.ad;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class KsAdLoadManager {
    private volatile boolean bA;

    /* JADX INFO: compiled from: SearchBox */
    public enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    public /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    private static void N() {
        boolean zIi = e.Ii();
        c.d("AdLoadManager", "reportInstallerCheckRecord isInstallerCheckEnable: " + zIi);
        if (zIi) {
            Context context = ServiceProvider.getContext();
            try {
                com.kwad.components.ad.j.b.ak(context);
                com.kwad.components.ad.j.b.al(context);
            } catch (Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }
        }
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            d.f(DevelopMangerComponents.class);
            return false;
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            return false;
        }
    }

    public final void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (!l.DP().Eq()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aIZ;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, true);
        } else {
            if (com.kwad.components.ad.adbit.c.c(aVar) || b(aVar)) {
                return;
            }
            if (!this.bA) {
                N();
                this.bA = true;
            }
            com.kwad.components.core.c.d.oq().d(aVar);
        }
    }

    private KsAdLoadManager() {
        this.bA = false;
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.oz().add(it.next());
        }
    }

    public final synchronized <T> void a(T t) {
        g.oz().add(t);
    }
}
