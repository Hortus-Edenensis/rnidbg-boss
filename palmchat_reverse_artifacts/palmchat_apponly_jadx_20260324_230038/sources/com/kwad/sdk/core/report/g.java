package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g extends b<n, f> {
    private static volatile boolean aLi = false;
    private static volatile g aLj;
    private static r<n, f> aLk;

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public f A(List<n> list) {
        r<n, f> rVar = aLk;
        if (rVar != null) {
            return (f) rVar.Ks();
        }
        String strD = D(list);
        return !TextUtils.isEmpty(strD) ? new f(strD) : new f(list);
    }

    private static String D(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).aMy)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(",\"actionList\":[");
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().aMy);
            sb.append(',');
        }
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    private static g Kk() {
        if (aLj == null) {
            synchronized (g.class) {
                if (aLj == null) {
                    aLj = new g();
                }
            }
        }
        aLj.checkInit();
        return aLj;
    }

    private static boolean ah(long j) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.ah(j);
    }

    private void b(final n nVar, boolean z) {
        if (nVar == null || !aLi) {
            return;
        }
        if (z || ah(nVar.actionType)) {
            aLj.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* JADX INFO: renamed from: Kl, reason: merged with bridge method [inline-methods] */
                public n Kg() {
                    return nVar.Kn();
                }
            });
        } else {
            aLj.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* JADX INFO: renamed from: Kl, reason: merged with bridge method [inline-methods] */
                public n Kg() {
                    return nVar.Kn();
                }
            });
        }
    }

    private synchronized void checkInit() {
        if (aLi) {
            return;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            return;
        }
        int iAX = hVar.aX(context);
        j(context, iAX);
        t.init(context);
        t.Kt();
        com.kwad.sdk.core.d.c.d("BatchReporter", "cache type = " + iAX);
        if (iAX == 2) {
            a(q.bM(context));
        }
        aLi = true;
    }

    public static void a(@NonNull n nVar) {
        a(nVar, false);
    }

    public static void a(@NonNull n nVar, boolean z) {
        Kk().b(nVar, z);
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        Runnable runnableKq;
        r<n, f> rVar = aLk;
        return (rVar == null || (runnableKq = rVar.Kq()) == null) ? super.a(context, lVar, atomicInteger) : runnableKq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = aLk;
        if (rVar != null) {
            return (f) rVar.Kr();
        }
        return (f) super.a(nVar);
    }
}
