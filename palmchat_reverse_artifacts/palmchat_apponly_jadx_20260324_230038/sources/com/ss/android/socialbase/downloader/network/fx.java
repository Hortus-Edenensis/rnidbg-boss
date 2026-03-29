package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    private final Handler fx;
    private final Handler nr;
    private final com.ss.android.socialbase.downloader.jk.n<String, nr> u;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.fx$fx, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0881fx {
        private static final fx u = new fx();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr {
        long nr;
        List<InetAddress> u;

        private nr() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final String str, final u uVar, long j) {
        final nr nrVar;
        List<InetAddress> listU;
        iz izVarC;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.u) {
                nrVar = this.u.get(host);
            }
            if (nrVar != null) {
                if (System.currentTimeMillis() - nrVar.nr < com.ss.android.socialbase.downloader.n.u.fx().u("dns_expire_min", 10) * 60 * 1000) {
                    if (uVar != null) {
                        uVar.u(str, nrVar.u);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.network.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        String str2 = str;
                        nr nrVar2 = nrVar;
                        uVar2.u(str2, nrVar2 == null ? null : nrVar2.u);
                    }
                }
            };
            this.fx.postDelayed(runnable, j);
            if (com.ss.android.socialbase.downloader.n.u.fx().u("use_host_dns", 1) != 1 || (izVarC = com.ss.android.socialbase.downloader.downloader.fx.c()) == null) {
                listU = null;
            } else {
                try {
                    listU = izVarC.u(host);
                } catch (Throwable unused) {
                    listU = null;
                }
            }
            if (listU == null || listU.isEmpty()) {
                try {
                    listU = com.ss.android.socialbase.downloader.downloader.fx.q().u(host);
                } catch (Throwable unused2) {
                }
            }
            if (listU != null && !listU.isEmpty()) {
                u(host, listU);
            } else if (nrVar != null) {
                listU = nrVar.u;
            }
            this.fx.removeCallbacks(runnable);
            if (uVar != null) {
                uVar.u(str, listU);
            }
        } catch (Throwable unused3) {
        }
    }

    private fx() {
        this.u = new com.ss.android.socialbase.downloader.jk.n<>(4, 16, false);
        this.nr = new Handler(com.ss.android.socialbase.downloader.network.u.nr.u());
        this.fx = new Handler(com.ss.android.socialbase.downloader.a.pn.u());
    }

    public static fx u() {
        return C0881fx.u;
    }

    public void u(final String str, final u uVar, final long j) {
        this.nr.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.fx.1
            @Override // java.lang.Runnable
            public void run() {
                fx.this.nr(str, uVar, j);
            }
        });
    }

    private void u(String str, List<InetAddress> list) {
        synchronized (this.u) {
            nr nrVar = this.u.get(str);
            if (nrVar == null) {
                nrVar = new nr();
                this.u.put(str, nrVar);
            }
            nrVar.u = list;
            nrVar.nr = System.currentTimeMillis();
        }
    }
}
