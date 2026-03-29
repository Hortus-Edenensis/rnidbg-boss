package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.q;
import defpackage.d25;
import defpackage.or1;
import defpackage.vz5;
import defpackage.w45;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface h extends q {

    /* JADX INFO: compiled from: SearchBox */
    public interface a extends q.a<h> {
        void f(h hVar);
    }

    long a(long j, w45 w45Var);

    long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j);

    @Override // com.google.android.exoplayer2.source.q
    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    void g(a aVar, long j);

    @Override // com.google.android.exoplayer2.source.q
    long getBufferedPositionUs();

    @Override // com.google.android.exoplayer2.source.q
    long getNextLoadPositionUs();

    vz5 getTrackGroups();

    @Override // com.google.android.exoplayer2.source.q
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    long readDiscontinuity();

    @Override // com.google.android.exoplayer2.source.q
    void reevaluateBuffer(long j);

    long seekToUs(long j);
}
