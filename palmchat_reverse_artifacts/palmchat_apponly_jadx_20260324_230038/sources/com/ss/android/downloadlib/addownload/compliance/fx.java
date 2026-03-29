package com.ss.android.downloadlib.addownload.compliance;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx extends com.ss.android.socialbase.downloader.jk.n<Long, com.ss.android.downloadlib.addownload.nr.nr> {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static fx u = new fx();
    }

    public static fx u() {
        return u.u;
    }

    private fx() {
        super(16, 16);
    }

    public void u(com.ss.android.downloadlib.addownload.nr.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        put(Long.valueOf(nrVar.u()), nrVar);
    }

    public com.ss.android.downloadlib.addownload.nr.nr u(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.nr.nr u(long j) {
        return get(Long.valueOf(j));
    }
}
