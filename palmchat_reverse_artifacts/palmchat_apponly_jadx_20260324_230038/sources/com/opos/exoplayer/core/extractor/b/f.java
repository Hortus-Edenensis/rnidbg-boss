package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.io.EOFException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class f {
    private static final int h = y.f("OggS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8169a;
    public int b;
    public long c;
    public int d;
    public int e;
    public int f;
    public final int[] g = new int[255];
    private final p i = new p(255);

    public void a() {
        this.f8169a = 0;
        this.b = 0;
        this.c = 0L;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public boolean a(com.opos.exoplayer.core.extractor.f fVar, boolean z) throws m, EOFException {
        this.i.a();
        a();
        if (!(fVar.d() == -1 || fVar.d() - fVar.b() >= 27) || !fVar.b(this.i.f8400a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.i.m() != h) {
            if (z) {
                return false;
            }
            throw new m("expected OggS capture pattern at begin of page");
        }
        int iG = this.i.g();
        this.f8169a = iG;
        if (iG != 0) {
            if (z) {
                return false;
            }
            throw new m("unsupported bit stream revision");
        }
        this.b = this.i.g();
        this.c = this.i.r();
        this.i.n();
        this.i.n();
        this.i.n();
        int iG2 = this.i.g();
        this.d = iG2;
        this.e = iG2 + 27;
        this.i.a();
        fVar.c(this.i.f8400a, 0, this.d);
        for (int i = 0; i < this.d; i++) {
            this.g[i] = this.i.g();
            this.f += this.g[i];
        }
        return true;
    }
}
