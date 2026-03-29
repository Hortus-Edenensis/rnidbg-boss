package com.opos.exoplayer.core;

import com.opos.exoplayer.core.source.h;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h.b f8108a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;

    public aa(h.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f8108a = bVar;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
    }

    public aa a(int i) {
        return new aa(this.f8108a.a(i), this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public aa a(long j) {
        return new aa(this.f8108a, j, this.c, this.d, this.e, this.f, this.g);
    }
}
