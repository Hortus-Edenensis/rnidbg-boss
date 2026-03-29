package defpackage;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class cm1 implements d25 {
    @Override // defpackage.d25
    public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.k(4);
        return -4;
    }

    @Override // defpackage.d25
    public boolean isReady() {
        return true;
    }

    @Override // defpackage.d25
    public int skipData(long j) {
        return 0;
    }

    @Override // defpackage.d25
    public void maybeThrowError() {
    }
}
