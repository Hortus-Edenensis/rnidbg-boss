package com.ss.android.socialbase.downloader.iz;

import androidx.annotation.NonNull;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class l implements pn {
    private final pn fx;
    private final com.ss.android.socialbase.downloader.model.pn nr;
    private final a u;

    public l(DownloadInfo downloadInfo, nr nrVar, a aVar) throws BaseException {
        this.u = aVar;
        this.nr = u(downloadInfo, aVar);
        this.fx = new n(nrVar, this);
    }

    public void b() {
        com.ss.android.socialbase.downloader.jk.iz.u(this.nr);
    }

    public void fx() throws IOException {
        this.nr.fx();
    }

    @Override // com.ss.android.socialbase.downloader.iz.pn
    public void nr(@NonNull u uVar) throws IOException {
        this.nr.u(uVar.u, 0, uVar.fx);
        this.u.nr(uVar.fx);
    }

    public a pn() {
        return this.u;
    }

    public pn u() {
        return this.fx;
    }

    private com.ss.android.socialbase.downloader.model.pn u(DownloadInfo downloadInfo, a aVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.pn pnVarU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("flush_buffer_size_byte", -1));
        try {
            pnVarU.u(aVar.pn());
            return pnVarU;
        } catch (IOException e) {
            throw new BaseException(FunDC.ID_AUTH_1054, e);
        }
    }

    public void nr() throws IOException {
        this.nr.nr();
    }
}
