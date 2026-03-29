package com.ss.android.downloadlib.iz;

import com.ss.android.socialbase.appdownloader.fx.jk;
import com.ss.android.socialbase.appdownloader.fx.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements t {
    private static volatile fx u;
    private List<t> nr;

    private fx() {
        ArrayList arrayList = new ArrayList();
        this.nr = arrayList;
        arrayList.add(new nr());
        this.nr.add(new u());
    }

    public static fx u() {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx();
                }
            }
        }
        return u;
    }

    @Override // com.ss.android.socialbase.appdownloader.fx.t
    public void u(DownloadInfo downloadInfo, jk jkVar) {
        if (downloadInfo != null && this.nr.size() != 0) {
            u(downloadInfo, 0, jkVar);
        } else if (jkVar != null) {
            jkVar.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final DownloadInfo downloadInfo, final int i, final jk jkVar) {
        if (i != this.nr.size() && i >= 0) {
            this.nr.get(i).u(downloadInfo, new jk() { // from class: com.ss.android.downloadlib.iz.fx.1
                @Override // com.ss.android.socialbase.appdownloader.fx.jk
                public void u() {
                    fx.this.u(downloadInfo, i + 1, jkVar);
                }
            });
        } else {
            jkVar.u();
        }
    }
}
