package com.ss.android.downloadlib.addownload.fx;

import android.content.Context;
import com.igexin.push.f.b.d;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    public static void nr() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(l.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jU = ((long) com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jU <= 0) {
                        jU = d.b;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jU && !mv.iz(l.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        u(file);
                    }
                }
            }
        }
    }

    public static void u() throws Throwable {
        List<DownloadInfo> listU = com.ss.android.socialbase.appdownloader.b.t().u(l.getContext());
        if (listU == null || listU.size() <= 0) {
            return;
        }
        for (int i = 0; i < listU.size(); i++) {
            DownloadInfo downloadInfo = listU.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jU = ((long) com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("download_file_expire_hours", 0)) * 3600000;
            if (jU <= 0) {
                jU = d.b;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jU) {
                u(file);
                Downloader.getInstance(l.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void u(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            u(externalCacheDir.getPath());
        } catch (Exception unused) {
        }
    }

    public static void u(File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write("1".getBytes());
            fileOutputStream.close();
        } catch (Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
        file.delete();
    }

    private static void u(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    File file2 = new File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        u(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
