package com.kwad.sdk.core.video.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private static AtomicBoolean aPi = null;
    private static int aPj = -1;
    private static final AtomicBoolean aPk = new AtomicBoolean(false);
    private static final AtomicBoolean aPl = new AtomicBoolean(false);
    private static int aPm = 0;
    private static boolean adD = false;

    public static boolean Ft() {
        return aPl.get() || com.kwad.framework.a.a.Nt.booleanValue();
    }

    public static int LS() {
        return aPm;
    }

    public static boolean LT() {
        AtomicBoolean atomicBoolean = aPi;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aPi = atomicBoolean2;
        return atomicBoolean2.get();
    }

    public static c a(@NonNull Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        c cVar;
        c cVar2;
        try {
            if (Ft() && z2 && LT()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aPm = 2;
                dVar.by(z);
                cVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar = new b();
                aPm = 1;
                cVar2 = bVar;
            }
            z4 = false;
            cVar = cVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!adD) {
                adD = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar2 = new b();
            aPm = 1;
            z4 = true;
            cVar = bVar2;
        }
        int iA = av.a(Ft(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT(), z2, LT(), z4, z3, cVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.U("KwaiPlayHelper", "player v=" + Integer.toBinaryString(iA));
        if (aPj != iA) {
            aPj = iA;
            ed(iA);
        }
        return cVar;
    }

    private static void ed(int i) {
        n nVar = new n(10212L);
        nVar.aLX = i;
        g.a(nVar);
    }
}
