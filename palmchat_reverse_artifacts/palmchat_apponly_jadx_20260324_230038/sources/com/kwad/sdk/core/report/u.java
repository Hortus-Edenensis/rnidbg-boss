package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong aMH = new AtomicLong(-1);
    protected final l<T> aKS;
    protected final b<T, R> aMI;
    protected final AtomicInteger aMJ;
    protected final Context mContext;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Kz();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.aKS = lVar;
        this.aMI = bVar;
        this.aMJ = atomicInteger;
    }

    public final void Ky() {
        long jTI = br.TI();
        if (jTI >= aMH.get() * 2) {
            try {
                List<T> listDW = this.aKS.dW(200);
                if (listDW.isEmpty()) {
                    return;
                }
                this.aMI.a(listDW, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    @Override // com.kwad.sdk.core.report.u.a
                    public final void Kz() {
                        u.this.Ky();
                    }
                });
            } catch (OutOfMemoryError e) {
                aMH.set(jTI);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.aMJ.get() > 0 || !ao.isNetworkConnected(this.mContext)) {
            return;
        }
        Ky();
    }
}
