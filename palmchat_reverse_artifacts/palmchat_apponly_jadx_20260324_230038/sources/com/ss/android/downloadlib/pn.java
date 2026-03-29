package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    private ExecutorService b;
    private ScheduledExecutorService fx;
    private ExecutorService nr;
    private ExecutorService u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static pn u = new pn();
    }

    public static pn u() {
        return u.u;
    }

    public ScheduledExecutorService b() {
        if (this.fx == null) {
            synchronized (pn.class) {
                if (this.fx == null) {
                    this.fx = new com.bytedance.sdk.component.jk.b.pn(0, new com.ss.android.socialbase.downloader.a.u(jk.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.fx;
    }

    public void fx(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        pn().execute(runnable);
    }

    public void iz() {
        u(new Runnable() { // from class: com.ss.android.downloadlib.pn.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (pn.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferencesU = com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), strArr[i], 0);
                            if (sharedPreferencesU != null) {
                                sharedPreferencesU.edit().clear().apply();
                            }
                        }
                        com.ss.android.socialbase.downloader.downloader.jk jkVarKj = com.ss.android.socialbase.downloader.downloader.fx.kj();
                        if (!(jkVarKj instanceof com.ss.android.socialbase.downloader.impls.b)) {
                            return;
                        }
                        SparseArray<DownloadInfo> sparseArrayU = ((com.ss.android.socialbase.downloader.impls.b) jkVarKj).u().u();
                        for (int size = sparseArrayU.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = sparseArrayU.get(sparseArrayU.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(l.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public void nr(Runnable runnable) {
        nr(runnable, false);
    }

    public ExecutorService pn() {
        if (this.b == null) {
            synchronized (pn.class) {
                if (this.b == null) {
                    this.b = new com.bytedance.sdk.component.jk.b.b(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.a.u(jk.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.b;
    }

    private pn() {
    }

    public ExecutorService fx() {
        if (this.nr == null) {
            synchronized (pn.class) {
                if (this.nr == null) {
                    this.nr = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.a.u(jk.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.nr;
    }

    public void nr(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (!z || mv.nr()) {
            fx().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public void u(Runnable runnable) {
        u(runnable, false);
    }

    public void u(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !mv.nr()) {
            runnable.run();
        } else {
            nr().execute(runnable);
        }
    }

    public ExecutorService nr() {
        if (this.u == null) {
            synchronized (pn.class) {
                if (this.u == null) {
                    this.u = new com.bytedance.sdk.component.jk.b.b(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.a.u(jk.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.u;
    }

    public void u(Runnable runnable, long j) {
        try {
            b().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
    }
}
