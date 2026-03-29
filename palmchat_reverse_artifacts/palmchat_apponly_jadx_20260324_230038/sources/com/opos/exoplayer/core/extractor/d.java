package com.opos.exoplayer.core.extractor;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.util.p;
import java.io.EOFException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d implements n {
    @Override // com.opos.exoplayer.core.extractor.n
    public int a(f fVar, int i, boolean z) throws EOFException {
        int iA = fVar.a(i);
        if (iA != -1) {
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(long j, int i, int i2, int i3, n.a aVar) {
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(Format format) {
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(p pVar, int i) {
        pVar.d(i);
    }
}
