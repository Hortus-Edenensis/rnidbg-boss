package com.opos.exoplayer.core.text;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class g extends com.opos.exoplayer.core.decoder.e implements b {
    private b c;
    private long d;

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        return this.c.a(j - this.d);
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return this.c.b();
    }

    public abstract void e();

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        return this.c.a(i) + this.d;
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        return this.c.b(j - this.d);
    }

    @Override // com.opos.exoplayer.core.decoder.a
    public void a() {
        super.a();
        this.c = null;
    }

    public void a(long j, b bVar, long j2) {
        ((com.opos.exoplayer.core.decoder.e) this).f8135a = j;
        this.c = bVar;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.d = j;
    }
}
