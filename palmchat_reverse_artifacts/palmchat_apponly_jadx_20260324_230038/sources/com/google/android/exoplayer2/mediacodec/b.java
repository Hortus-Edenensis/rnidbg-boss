package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.mediacodec.f;
import defpackage.fp3;
import defpackage.g86;
import defpackage.y53;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5900a = 0;
    public boolean b;

    @Override // com.google.android.exoplayer2.mediacodec.c.b
    public c a(c.a aVar) throws IOException {
        int i;
        int i2 = g86.f17680a;
        if (i2 < 23 || ((i = this.f5900a) != 1 && (i != 0 || i2 < 31))) {
            return new f.b().a(aVar);
        }
        int iK = fp3.k(aVar.c.l);
        y53.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + g86.n0(iK));
        return new a.b(iK, this.b).a(aVar);
    }
}
