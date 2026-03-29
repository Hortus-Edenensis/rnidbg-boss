package com.ss.android.downloadlib.addownload.u;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.nr;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.downloadlib.jk;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.downloadlib.x.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static u nr = null;
    private static final String u = "u";
    private boolean b = false;

    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> fx;
    private nr iz;
    private String pn;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0843u {
        void u();
    }

    private u() {
        nr nrVar = new nr();
        this.iz = nrVar;
        this.fx = nrVar.u("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static u u() {
        if (nr == null) {
            nr = new u();
        }
        return nr;
    }

    public void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            this.pn = "";
        } else if (TextUtils.equals(this.pn, str)) {
            this.pn = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:4:0x000b, B:8:0x0016, B:13:0x0021, B:15:0x0029, B:18:0x004c, B:20:0x005c, B:21:0x0066, B:23:0x006c, B:25:0x0074, B:27:0x0080, B:29:0x0088, B:31:0x0097, B:34:0x00bd, B:32:0x009b), top: B:38:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:4:0x000b, B:8:0x0016, B:13:0x0021, B:15:0x0029, B:18:0x004c, B:20:0x005c, B:21:0x0066, B:23:0x006c, B:25:0x0074, B:27:0x0080, B:29:0x0088, B:31:0x0097, B:34:0x00bd, B:32:0x009b), top: B:38:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0843u interfaceC0843u) {
        boolean z2;
        ListIterator<com.ss.android.downloadlib.addownload.nr.u> listIterator;
        if (downloadInfo == null) {
            try {
                if (this.fx.isEmpty()) {
                    return false;
                }
                if (activity != null && !activity.isFinishing()) {
                    z2 = true;
                    if (downloadInfo == null && this.fx.isEmpty()) {
                        u(activity, new com.ss.android.downloadlib.addownload.nr.u(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0843u);
                        return true;
                    }
                    long jLastModified = downloadInfo == null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
                    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> copyOnWriteArrayList = this.fx;
                    listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            z2 = false;
                            break;
                        }
                        com.ss.android.downloadlib.addownload.nr.u uVarPrevious = listIterator.previous();
                        if (uVarPrevious != null && !mv.pn(l.getContext(), uVarPrevious.b) && mv.u(uVarPrevious.x)) {
                            if (new File(uVarPrevious.x).lastModified() >= jLastModified) {
                                u(activity, uVarPrevious, z, interfaceC0843u);
                            } else {
                                u(activity, new com.ss.android.downloadlib.addownload.nr.u(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0843u);
                            }
                        }
                    }
                    t.u(u, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
                    return z2;
                }
            } catch (Exception unused) {
            }
        } else if (activity != null) {
            z2 = true;
            if (downloadInfo == null) {
            }
            if (downloadInfo == null) {
            }
            CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.nr.u> copyOnWriteArrayList2 = this.fx;
            listIterator = copyOnWriteArrayList2.listIterator(copyOnWriteArrayList2.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                }
            }
            t.u(u, "tryShowInstallDialog isShow:".concat(String.valueOf(z2)), null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean u(Activity activity, boolean z, InterfaceC0843u interfaceC0843u) {
        if (l.a().optInt("disable_install_app_dialog") == 1 || this.b) {
            return false;
        }
        return u(activity, u(activity), z, interfaceC0843u);
    }

    public void u(Context context, com.ss.android.downloadlib.addownload.nr.u uVar, boolean z, InterfaceC0843u interfaceC0843u) {
        this.fx.clear();
        u(context, uVar, interfaceC0843u, z);
        this.b = true;
        jk.u(context).fx();
        this.iz.nr("sp_ad_install_back_dialog", "key_uninstalled_list");
        t.u(u, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo u(Context context) {
        DownloadInfo downloadInfo = null;
        try {
            long jNr = jk.u(context).nr();
            if (l.a().optInt("enable_miniapp_dialog", 0) == 0) {
                return null;
            }
            List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
            if (successedDownloadInfosWithMimeType != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !mv.pn(context, downloadInfo2.getPackageName()) && mv.u(downloadInfo2.getTargetFilePath())) {
                        long jLastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (jLastModified >= jNr && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || jLastModified > j)) {
                                    downloadInfo = downloadInfo2;
                                    j = jLastModified;
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return downloadInfo;
    }

    public void u(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.fx.size(); i++) {
            com.ss.android.downloadlib.addownload.nr.u uVar = this.fx.get(i);
            if (uVar != null && uVar.nr == j2) {
                this.fx.set(i, new com.ss.android.downloadlib.addownload.nr.u(j, j2, j3, str, str2, str3, str4));
                this.iz.u("sp_ad_install_back_dialog", "key_uninstalled_list", this.fx);
                return;
            }
        }
        this.fx.add(new com.ss.android.downloadlib.addownload.nr.u(j, j2, j3, str, str2, str3, str4));
        this.iz.u("sp_ad_install_back_dialog", "key_uninstalled_list", this.fx);
    }

    private void u(final Context context, final com.ss.android.downloadlib.addownload.nr.u uVar, final InterfaceC0843u interfaceC0843u, boolean z) {
        final com.ss.android.downloadad.api.u.nr nrVarB = iz.u().b(uVar.nr);
        if (nrVarB == null) {
            com.ss.android.downloadlib.pn.fx.u().u("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.mv mvVarFx = l.fx();
        nr.u uVarU = new nr.u(context).u(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(uVar.pn) ? "刚刚下载的应用" : uVar.pn;
        mvVarFx.nr(uVarU.nr(String.format("%1$s下载完成，是否立即安装？", objArr)).fx("立即安装").b(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).u(false).u(mv.u(context, uVar.x)).u(new nr.InterfaceC0840nr() { // from class: com.ss.android.downloadlib.addownload.u.u.1
            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void fx(DialogInterface dialogInterface) {
                u.this.nr("");
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void nr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.u.u().nr("backdialog_exit", nrVarB);
                InterfaceC0843u interfaceC0843u2 = interfaceC0843u;
                if (interfaceC0843u2 != null) {
                    interfaceC0843u2.u();
                }
                u.this.nr("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void u(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.u.u().nr("backdialog_install", nrVarB);
                com.ss.android.socialbase.appdownloader.b.u(context, (int) uVar.u);
                dialogInterface.dismiss();
            }
        }).u(1).u());
        com.ss.android.downloadlib.b.u.u().nr("backdialog_show", nrVarB);
        this.pn = uVar.b;
    }

    public boolean u(String str) {
        return TextUtils.equals(this.pn, str);
    }

    public void u(com.ss.android.downloadad.api.u.nr nrVar) {
        if (l.a().optInt("enable_open_app_dialog", 0) == 1 && !nrVar.lf() && nrVar.o() && Build.VERSION.SDK_INT < 34) {
            nrVar.t(true);
            TTDelegateActivity.u(nrVar);
        }
    }
}
