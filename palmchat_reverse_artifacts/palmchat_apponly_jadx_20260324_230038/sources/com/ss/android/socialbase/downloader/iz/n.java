package com.ss.android.socialbase.downloader.iz;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class n implements pn {
    private final pn nr;
    private final pn u;

    public n(pn pnVar, pn pnVar2) {
        this.u = pnVar;
        this.nr = pnVar2;
    }

    @Override // com.ss.android.socialbase.downloader.iz.pn
    public void nr(@NonNull u uVar) throws IOException {
        uVar.nr = this.nr;
        this.u.nr(uVar);
    }
}
