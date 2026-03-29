package com.oplus.tbl.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface LoaderErrorThrower {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Dummy implements LoaderErrorThrower {
        @Override // com.oplus.tbl.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() {
        }

        @Override // com.oplus.tbl.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) {
        }
    }

    void maybeThrowError() throws IOException;

    void maybeThrowError(int i) throws IOException;
}
