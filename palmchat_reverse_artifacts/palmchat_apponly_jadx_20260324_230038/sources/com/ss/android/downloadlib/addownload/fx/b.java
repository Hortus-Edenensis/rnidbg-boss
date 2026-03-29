package com.ss.android.downloadlib.addownload.fx;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static volatile b u;
    private long nr = 0;
    private ConcurrentHashMap<String, pn> fx = new ConcurrentHashMap<>();
    private HashMap<String, Integer> b = new HashMap<>();
    private List<String> pn = new CopyOnWriteArrayList();

    public static b u() {
        if (u == null) {
            synchronized (b.class) {
                if (u == null) {
                    u = new b();
                }
            }
        }
        return u;
    }

    public void fx() {
        this.nr = System.currentTimeMillis();
    }

    public long nr() {
        return this.nr;
    }

    public int nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str).intValue();
        }
        return 0;
    }

    public void u(String str, pn pnVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fx.put(str, pnVar);
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fx.remove(str);
    }

    @WorkerThread
    public static void u(com.ss.android.downloadad.api.u.nr nrVar) {
        DownloadInfo downloadInfo;
        if (nrVar == null || nrVar.nr() <= 0 || (downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVar.bg())) == null) {
            return;
        }
        u(downloadInfo);
    }

    @WorkerThread
    public static void u(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }
}
