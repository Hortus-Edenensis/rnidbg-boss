package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static b u;
    private List<x> nr;

    private b() {
        ArrayList arrayList = new ArrayList();
        this.nr = arrayList;
        arrayList.add(new pn());
        this.nr.add(new nr());
        this.nr.add(new fx());
    }

    public static b u() {
        if (u == null) {
            synchronized (t.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar, int i, n nVar, com.ss.android.downloadlib.addownload.u.fx fxVar) {
        DownloadInfo downloadInfoNr;
        List<x> list = this.nr;
        if (list == null || list.size() == 0 || nrVar == null) {
            nVar.u(nrVar);
        }
        if (!TextUtils.isEmpty(nrVar.f())) {
            downloadInfoNr = com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).u(nrVar.f(), null, true);
        } else {
            downloadInfoNr = com.ss.android.downloadlib.jk.u(com.ss.android.downloadlib.addownload.l.getContext()).nr(nrVar.u());
        }
        if (downloadInfoNr == null) {
            downloadInfoNr = Downloader.getInstance(com.ss.android.downloadlib.addownload.l.getContext()).getDownloadInfo(nrVar.bg());
        }
        if (downloadInfoNr != null && AdBaseConstants.MIME_APK.equals(downloadInfoNr.getMimeType())) {
            if (new jk().u(nrVar, i, nVar)) {
                return;
            }
            Iterator<x> it = this.nr.iterator();
            while (it.hasNext()) {
                if (it.next().u(nrVar, i, nVar, fxVar)) {
                    return;
                }
            }
            nVar.u(nrVar);
            return;
        }
        nVar.u(nrVar);
    }
}
