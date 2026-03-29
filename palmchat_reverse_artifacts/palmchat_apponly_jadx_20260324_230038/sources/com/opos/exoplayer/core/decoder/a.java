package com.opos.exoplayer.core.decoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8131a;

    public void a() {
        this.f8131a = 0;
    }

    public final void a_(int i) {
        this.f8131a = i;
    }

    public final void b(int i) {
        this.f8131a = i | this.f8131a;
    }

    public final void c(int i) {
        this.f8131a = (~i) & this.f8131a;
    }

    public final boolean d() {
        return d(1);
    }

    public final boolean d_() {
        return d(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d(int i) {
        return (this.f8131a & i) == i;
    }
}
