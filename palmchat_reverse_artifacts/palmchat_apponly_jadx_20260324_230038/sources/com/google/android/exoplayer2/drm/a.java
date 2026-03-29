package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.d;
import defpackage.g86;
import defpackage.hi1;
import defpackage.ku2;
import defpackage.o46;
import defpackage.vh;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a implements hi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5858a = new Object();

    @GuardedBy("lock")
    public p.f b;

    @GuardedBy("lock")
    public c c;

    @Nullable
    public a.InterfaceC0360a d;

    @Nullable
    public String e;

    @Override // defpackage.hi1
    public c a(p pVar) {
        c cVar;
        vh.e(pVar.b);
        p.f fVar = pVar.b.c;
        if (fVar == null || g86.f17680a < 18) {
            return c.f5861a;
        }
        synchronized (this.f5858a) {
            if (!g86.c(fVar, this.b)) {
                this.b = fVar;
                this.c = b(fVar);
            }
            cVar = (c) vh.e(this.c);
        }
        return cVar;
    }

    @RequiresApi(18)
    public final c b(p.f fVar) {
        a.InterfaceC0360a interfaceC0360aB = this.d;
        if (interfaceC0360aB == null) {
            interfaceC0360aB = new d.b().b(this.e);
        }
        Uri uri = fVar.c;
        i iVar = new i(uri == null ? null : uri.toString(), fVar.h, interfaceC0360aB);
        o46<Map.Entry<String, String>> it = fVar.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            iVar.e(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().e(fVar.f5916a, h.d).b(fVar.f).c(fVar.g).d(ku2.p(fVar.j)).a(iVar);
        defaultDrmSessionManagerA.E(0, fVar.e());
        return defaultDrmSessionManagerA;
    }
}
