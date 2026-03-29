package com.opos.exoplayer.core;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.drm.DrmInitData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements q, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8084a;
    private s b;
    private int c;
    private int d;
    private com.opos.exoplayer.core.source.l e;
    private long f;
    private boolean g = true;
    private boolean h;

    public a(int i) {
        this.f8084a = i;
    }

    @Override // com.opos.exoplayer.core.q, com.opos.exoplayer.core.r
    public final int a() {
        return this.f8084a;
    }

    @Override // com.opos.exoplayer.core.q
    public final int a_() {
        return this.d;
    }

    public int b(long j) {
        return this.e.a(j - this.f);
    }

    @Override // com.opos.exoplayer.core.q
    public final void b_() {
        com.opos.exoplayer.core.util.a.b(this.d == 1);
        this.d = 2;
        n();
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.util.l c() {
        return null;
    }

    @Override // com.opos.exoplayer.core.q
    public final com.opos.exoplayer.core.source.l f() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.q
    public final boolean g() {
        return this.g;
    }

    @Override // com.opos.exoplayer.core.q
    public final void h() {
        this.h = true;
    }

    @Override // com.opos.exoplayer.core.q
    public final boolean i() {
        return this.h;
    }

    @Override // com.opos.exoplayer.core.q
    public final void j() {
        this.e.c();
    }

    @Override // com.opos.exoplayer.core.q
    public final void k() {
        com.opos.exoplayer.core.util.a.b(this.d == 2);
        this.d = 1;
        o();
    }

    @Override // com.opos.exoplayer.core.q
    public final void l() {
        com.opos.exoplayer.core.util.a.b(this.d == 1);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    @Override // com.opos.exoplayer.core.r
    public int m() {
        return 0;
    }

    public final s q() {
        return this.b;
    }

    public final int r() {
        return this.c;
    }

    public final boolean s() {
        return this.g ? this.h : this.e.b();
    }

    public final int a(j jVar, DecoderInputBuffer decoderInputBuffer, boolean z) {
        int iA = this.e.a(jVar, decoderInputBuffer, z);
        if (iA == -4) {
            if (decoderInputBuffer.c()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            decoderInputBuffer.c += this.f;
        } else if (iA == -5) {
            Format format = jVar.f8252a;
            long j = format.w;
            if (j != Long.MAX_VALUE) {
                jVar.f8252a = format.a(j + this.f);
            }
        }
        return iA;
    }

    @Override // com.opos.exoplayer.core.q
    public final r b() {
        return this;
    }

    @Override // com.opos.exoplayer.core.q
    public final void a(int i) {
        this.c = i;
    }

    @Override // com.opos.exoplayer.core.o.b
    public void a(int i, Object obj) {
    }

    @Override // com.opos.exoplayer.core.q
    public final void a(long j) {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    public void a(long j, boolean z) {
    }

    @Override // com.opos.exoplayer.core.q
    public final void a(s sVar, Format[] formatArr, com.opos.exoplayer.core.source.l lVar, long j, boolean z, long j2) {
        com.opos.exoplayer.core.util.a.b(this.d == 0);
        this.b = sVar;
        this.d = 1;
        a(z);
        a(formatArr, lVar, j2);
        a(j, z);
    }

    public void a(boolean z) {
    }

    public void a(Format[] formatArr, long j) {
    }

    @Override // com.opos.exoplayer.core.q
    public final void a(Format[] formatArr, com.opos.exoplayer.core.source.l lVar, long j) {
        com.opos.exoplayer.core.util.a.b(!this.h);
        this.e = lVar;
        this.g = false;
        this.f = j;
        a(formatArr, j);
    }

    public static boolean a(@Nullable com.opos.exoplayer.core.drm.b<?> bVar, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }
}
