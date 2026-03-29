package com.ss.android.downloadlib.nr;

import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.u.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements u.InterfaceC0886u {
    private long u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static pn u = new pn();
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void nr() {
        this.u = System.currentTimeMillis();
    }

    private pn() {
        this.u = 0L;
        com.ss.android.socialbase.downloader.u.u.u().u(this);
    }

    public static pn u() {
        return u.u;
    }

    public void nr(b bVar) {
        if (bVar == null) {
            return;
        }
        u(bVar, l.a().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }

    public void u(final b bVar, final long j) {
        if (bVar == null) {
            return;
        }
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.nr.pn.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.ss.android.socialbase.downloader.u.u.u().fx() || System.currentTimeMillis() - pn.this.u <= j) {
                    bVar.u(true);
                } else {
                    bVar.u(false);
                }
            }
        }, j);
    }

    public void u(b bVar) {
        u(bVar, 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void fx() {
    }
}
