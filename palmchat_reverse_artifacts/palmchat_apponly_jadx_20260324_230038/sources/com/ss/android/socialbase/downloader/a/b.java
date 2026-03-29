package com.ss.android.socialbase.downloader.a;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static ExecutorService u = new com.bytedance.sdk.component.jk.b.b(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new u("Download_OP_Thread"));
    private int fx = 0;
    private volatile SparseArray<fx> nr = new SparseArray<>();

    private void nr() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.nr.size(); i++) {
                int iKeyAt = this.nr.keyAt(i);
                if (!this.nr.get(iKeyAt).b()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.nr.remove(num.intValue());
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void u(Runnable runnable) {
        u.execute(runnable);
    }

    public void fx(int i) {
        synchronized (b.class) {
            nr();
            fx fxVar = this.nr.get(i);
            if (fxVar != null) {
                fxVar.u();
                fx(fxVar);
                this.nr.remove(i);
            }
        }
    }

    public void u(fx fxVar) {
        fxVar.iz();
        synchronized (b.class) {
            int i = this.fx;
            if (i >= 500) {
                nr();
                this.fx = 0;
            } else {
                this.fx = i + 1;
            }
            this.nr.put(fxVar.pn(), fxVar);
        }
        DownloadTask downloadTaskFx = fxVar.fx();
        try {
            ExecutorService executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.my();
            if (downloadTaskFx != null && downloadTaskFx.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(downloadTaskFx.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.n.u.fx().u("divide_plugin", 1) == 1) {
                    downloadTaskFx.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = downloadTaskFx.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.s();
                } else if (executorGroup == 4) {
                    executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.k();
                }
            }
            if (executorServiceMy == null) {
                com.ss.android.socialbase.downloader.b.u.u(downloadTaskFx.getMonitorDepend(), downloadTaskFx.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTaskFx.getDownloadInfo() != null ? downloadTaskFx.getDownloadInfo().getStatus() : 0);
            } else if (com.ss.android.socialbase.downloader.n.u.u(fxVar.pn()).nr("pause_with_interrupt", false)) {
                fxVar.u(executorServiceMy.submit(fxVar));
            } else {
                executorServiceMy.execute(fxVar);
            }
        } catch (Exception e) {
            if (downloadTaskFx != null) {
                com.ss.android.socialbase.downloader.b.u.u(downloadTaskFx.getMonitorDepend(), downloadTaskFx.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.jk.iz.nr(e, "DownloadThreadPoolExecute")), downloadTaskFx.getDownloadInfo() != null ? downloadTaskFx.getDownloadInfo().getStatus() : 0);
            }
        } catch (OutOfMemoryError unused) {
            if (downloadTaskFx != null) {
                com.ss.android.socialbase.downloader.b.u.u(downloadTaskFx.getMonitorDepend(), downloadTaskFx.getDownloadInfo(), new BaseException(1003, "execute OOM"), downloadTaskFx.getDownloadInfo() != null ? downloadTaskFx.getDownloadInfo().getStatus() : 0);
            }
        }
    }

    private void fx(fx fxVar) {
        Future futureX;
        if (fxVar == null) {
            return;
        }
        try {
            ExecutorService executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.my();
            DownloadTask downloadTaskFx = fxVar.fx();
            if (downloadTaskFx != null && downloadTaskFx.getDownloadInfo() != null) {
                int executorGroup = downloadTaskFx.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.s();
                } else if (executorGroup == 4) {
                    executorServiceMy = com.ss.android.socialbase.downloader.downloader.fx.k();
                }
            }
            if (executorServiceMy == null || !(executorServiceMy instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServiceMy).remove(fxVar);
            if (!com.ss.android.socialbase.downloader.n.u.u(fxVar.pn()).nr("pause_with_interrupt", false) || (futureX = fxVar.x()) == null) {
                return;
            }
            futureX.cancel(true);
        } catch (Exception unused) {
        }
    }

    public void nr(fx fxVar) {
        if (fxVar == null) {
            return;
        }
        synchronized (b.class) {
            try {
                if (com.ss.android.socialbase.downloader.jk.u.u(524288)) {
                    int iIndexOfValue = this.nr.indexOfValue(fxVar);
                    if (iIndexOfValue >= 0) {
                        this.nr.removeAt(iIndexOfValue);
                    }
                } else {
                    this.nr.remove(fxVar.pn());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public fx nr(int i) {
        synchronized (b.class) {
            nr();
            fx fxVar = this.nr.get(i);
            if (fxVar == null) {
                return null;
            }
            fxVar.nr();
            fx(fxVar);
            this.nr.remove(i);
            return fxVar;
        }
    }

    public boolean u(int i) {
        synchronized (b.class) {
            boolean z = false;
            if (this.nr != null && this.nr.size() > 0) {
                fx fxVar = this.nr.get(i);
                if (fxVar != null && fxVar.b()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    public List<Integer> u() {
        ArrayList arrayList;
        synchronized (b.class) {
            nr();
            arrayList = new ArrayList();
            for (int i = 0; i < this.nr.size(); i++) {
                fx fxVar = this.nr.get(this.nr.keyAt(i));
                if (fxVar != null) {
                    arrayList.add(Integer.valueOf(fxVar.pn()));
                }
            }
        }
        return arrayList;
    }

    public void u(int i, long j) {
        this.nr.get(i);
    }
}
