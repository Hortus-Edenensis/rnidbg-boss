package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.u06;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class t extends c<Void> {
    public static final Void l = null;
    public final i k;

    public t(i iVar) {
        this.k = iVar;
    }

    @Override // com.google.android.exoplayer2.source.c
    @Nullable
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public final i.b x(Void r1, i.b bVar) {
        return D(bVar);
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final long y(Void r1, long j) {
        return F(j);
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final int z(Void r1, int i) {
        return H(i);
    }

    public abstract void J(e0 e0Var);

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final void A(Void r1, i iVar, e0 e0Var) {
        J(e0Var);
    }

    public final void L() {
        C(l, this.k);
    }

    public void M() {
        L();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.i
    @Nullable
    public e0 getInitialTimeline() {
        return this.k.getInitialTimeline();
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.p getMediaItem() {
        return this.k.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.i
    public boolean isSingleWindow() {
        return this.k.isSingleWindow();
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public final void t(@Nullable u06 u06Var) {
        super.t(u06Var);
        M();
    }

    @Nullable
    public i.b D(i.b bVar) {
        return bVar;
    }

    public long F(long j) {
        return j;
    }

    public int H(int i) {
        return i;
    }
}
