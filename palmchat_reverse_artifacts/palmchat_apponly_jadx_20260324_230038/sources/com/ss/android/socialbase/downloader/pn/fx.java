package com.ss.android.socialbase.downloader.pn;

import com.ss.android.socialbase.downloader.jk.iz;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements nr {
    private final com.ss.android.socialbase.downloader.iz.u nr;
    private final InputStream u;

    public fx(InputStream inputStream, int i) {
        this.u = inputStream;
        this.nr = new com.ss.android.socialbase.downloader.iz.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public void nr() {
        iz.u(this.u);
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public void u(com.ss.android.socialbase.downloader.iz.u uVar) {
    }

    @Override // com.ss.android.socialbase.downloader.pn.nr
    public com.ss.android.socialbase.downloader.iz.u u() throws IOException {
        com.ss.android.socialbase.downloader.iz.u uVar = this.nr;
        uVar.fx = this.u.read(uVar.u);
        return this.nr;
    }
}
