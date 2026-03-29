package com.ss.android.socialbase.downloader.network.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.jk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static final Handler b;
    private static final HandlerThread fx;
    static long nr;
    static long u;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        fx = handlerThread;
        nr();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        b = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.u.nr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void nr() {
        u = com.ss.android.socialbase.downloader.n.u.fx().u("preconnect_connection_outdate_time", 300000L);
        nr = com.ss.android.socialbase.downloader.n.u.fx().u("preconnect_head_info_outdate_time", 300000L);
        u.u().u(com.ss.android.socialbase.downloader.n.u.fx().u("preconnect_max_cache_size", 3));
    }

    public static Looper u() {
        return fx.getLooper();
    }

    public static void u(final String str, final jk jkVar) {
        b.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.u.nr.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (TextUtils.isEmpty(str)) {
                    jk jkVar2 = jkVar;
                    if (jkVar2 != null) {
                        jkVar2.u(null);
                        return;
                    }
                    return;
                }
                try {
                    List<com.ss.android.socialbase.downloader.model.fx> listNr = nr.nr(0L, null, null);
                    fxVarU = u.u().u(str) ? u.u().u(str, listNr) : null;
                    if (fxVarU == null) {
                        fx fxVar = new fx(str, listNr, 0L);
                        try {
                            fxVar.u();
                            if (fxVar.pn()) {
                                u.u().u(str, fxVar);
                            }
                            fxVarU = fxVar;
                        } catch (Exception unused) {
                            fxVarU = fxVar;
                            try {
                                fxVarU.fx();
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fxVarU = fxVar;
                            try {
                                fxVarU.fx();
                            } catch (Throwable unused3) {
                            }
                            throw th;
                        }
                    }
                    Map<String, String> mapA = fxVarU.a();
                    jk jkVar3 = jkVar;
                    if (jkVar3 != null) {
                        jkVar3.u(mapA);
                    }
                    try {
                        fxVarU.fx();
                    } catch (Throwable unused4) {
                    }
                } catch (Exception unused5) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.fx> nr(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.fx> list) {
        return iz.u(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
