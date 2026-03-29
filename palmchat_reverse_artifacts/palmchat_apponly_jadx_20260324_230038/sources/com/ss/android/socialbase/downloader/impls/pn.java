package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn extends u {
    private static com.ss.android.socialbase.downloader.a.b nr;

    public pn() {
        nr = new com.ss.android.socialbase.downloader.a.b();
    }

    public static List<Future> b(List<Runnable> list) {
        ExecutorService executorServiceO = com.ss.android.socialbase.downloader.downloader.fx.o();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceO.submit(it.next()));
        }
        return arrayList;
    }

    public static void fx(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceO = com.ss.android.socialbase.downloader.downloader.fx.o();
        if (executorServiceO != null) {
            executorServiceO.invokeAll(list);
        }
    }

    public static Runnable pn(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceO = com.ss.android.socialbase.downloader.downloader.fx.o();
                if ((executorServiceO instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceO).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.fx.u.b("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public void nr(int i) {
        com.ss.android.socialbase.downloader.a.b bVar = nr;
        if (bVar == null) {
            return;
        }
        bVar.fx(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public boolean u(int i) {
        DownloadInfo downloadInfoB;
        com.ss.android.socialbase.downloader.a.b bVar = nr;
        if (bVar == null || !bVar.u(i) || (downloadInfoB = b(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(downloadInfoB.getStatus())) {
            return true;
        }
        nr(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public com.ss.android.socialbase.downloader.a.fx fx(int i) {
        com.ss.android.socialbase.downloader.a.b bVar = nr;
        if (bVar == null) {
            return null;
        }
        return bVar.nr(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public void u(com.ss.android.socialbase.downloader.a.fx fxVar) {
        com.ss.android.socialbase.downloader.a.b bVar = nr;
        if (bVar == null) {
            return;
        }
        bVar.nr(fxVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public void u(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.fx.u.nr("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        nr.u(new com.ss.android.socialbase.downloader.a.fx(downloadTask, this.u));
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public List<Integer> u() {
        return nr.u();
    }

    @Override // com.ss.android.socialbase.downloader.impls.u
    public void u(int i, long j) {
        com.ss.android.socialbase.downloader.a.b bVar = nr;
        if (bVar == null) {
            return;
        }
        bVar.u(i, j);
    }
}
