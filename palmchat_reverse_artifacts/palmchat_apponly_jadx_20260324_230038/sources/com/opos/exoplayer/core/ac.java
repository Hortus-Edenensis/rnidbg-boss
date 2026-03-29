package com.opos.exoplayer.core;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.source.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8110a;

    @Nullable
    public final Object b;
    public final h.b c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final com.opos.exoplayer.core.c.i h;
    public volatile long i;
    public volatile long j;

    public ac(w wVar, long j, com.opos.exoplayer.core.c.i iVar) {
        this(wVar, null, new h.b(0), j, -9223372036854775807L, 1, false, iVar);
    }

    public ac a(int i) {
        ac acVar = new ac(this.f8110a, this.b, this.c.a(i), this.d, this.e, this.f, this.g, this.h);
        a(this, acVar);
        return acVar;
    }

    public ac b(int i) {
        ac acVar = new ac(this.f8110a, this.b, this.c, this.d, this.e, i, this.g, this.h);
        a(this, acVar);
        return acVar;
    }

    public ac(w wVar, @Nullable Object obj, h.b bVar, long j, long j2, int i, boolean z, com.opos.exoplayer.core.c.i iVar) {
        this.f8110a = wVar;
        this.b = obj;
        this.c = bVar;
        this.d = j;
        this.e = j2;
        this.i = j;
        this.j = j;
        this.f = i;
        this.g = z;
        this.h = iVar;
    }

    public ac a(com.opos.exoplayer.core.c.i iVar) {
        ac acVar = new ac(this.f8110a, this.b, this.c, this.d, this.e, this.f, this.g, iVar);
        a(this, acVar);
        return acVar;
    }

    public ac a(h.b bVar, long j, long j2) {
        return new ac(this.f8110a, this.b, bVar, j, bVar.a() ? j2 : -9223372036854775807L, this.f, this.g, this.h);
    }

    public ac a(w wVar, Object obj) {
        ac acVar = new ac(wVar, obj, this.c, this.d, this.e, this.f, this.g, this.h);
        a(this, acVar);
        return acVar;
    }

    public ac a(boolean z) {
        ac acVar = new ac(this.f8110a, this.b, this.c, this.d, this.e, this.f, z, this.h);
        a(this, acVar);
        return acVar;
    }

    private static void a(ac acVar, ac acVar2) {
        acVar2.i = acVar.i;
        acVar2.j = acVar.j;
    }
}
