package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t {
    private static t u;
    private List<a> nr;

    private t() {
        ArrayList arrayList = new ArrayList();
        this.nr = arrayList;
        arrayList.add(new jk());
        this.nr.add(new l());
        this.nr.add(new iz());
        this.nr.add(new u());
    }

    public static t u() {
        if (u == null) {
            synchronized (t.class) {
                if (u == null) {
                    u = new t();
                }
            }
        }
        return u;
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar, int i, n nVar) {
        DownloadInfo downloadInfoNr;
        List<a> list = this.nr;
        if (list != null && list.size() != 0 && nrVar != null) {
            if (!TextUtils.isEmpty(nrVar.f())) {
                downloadInfoNr = com.ss.android.downloadlib.jk.u((Context) null).u(nrVar.f(), null, true);
            } else {
                downloadInfoNr = com.ss.android.downloadlib.jk.u((Context) null).nr(nrVar.u());
            }
            if (downloadInfoNr != null && AdBaseConstants.MIME_APK.equals(downloadInfoNr.getMimeType())) {
                boolean z = com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("pause_optimise_switch", 0) == 1;
                for (a aVar : this.nr) {
                    if (z || (aVar instanceof l)) {
                        if (aVar.u(nrVar, i, nVar)) {
                            return;
                        }
                    }
                }
                nVar.u(nrVar);
                return;
            }
            nVar.u(nrVar);
            return;
        }
        nVar.u(nrVar);
    }
}
