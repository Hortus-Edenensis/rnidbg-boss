package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static volatile nr u;
    private Handler nr = null;

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new nr();
                }
            }
        }
        return u;
    }

    public boolean nr() {
        return l.a().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void u(Context context, DownloadInfo downloadInfo) {
        if (nr() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
            if (this.nr == null) {
                this.nr = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    l.fx().u(3, l.getContext(), null, "下载失败，请重试！", null, 0);
                    pn pnVarU = com.ss.android.downloadlib.n.u().u(url);
                    if (pnVarU != null) {
                        pnVarU.x();
                    }
                }
            });
        }
    }
}
