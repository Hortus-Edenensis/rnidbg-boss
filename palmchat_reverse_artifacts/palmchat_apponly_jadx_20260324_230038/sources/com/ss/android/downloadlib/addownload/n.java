package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.config.dw;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.x.jk;
import com.ss.android.downloadlib.x.s;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n implements s.u {
    private pn b;
    private boolean fx = false;
    private long nr;
    private nr pn;
    public com.ss.android.downloadlib.addownload.nr.pn u;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(DownloadInfo downloadInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends com.ss.android.socialbase.downloader.depend.u {
        private com.ss.android.downloadlib.x.s u;

        public u(com.ss.android.downloadlib.x.s sVar) {
            this.u = sVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            u(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            u(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            u(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            u(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            u(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            u(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            u(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.u, com.ss.android.socialbase.downloader.depend.bg
        public void u(DownloadInfo downloadInfo) {
            u(downloadInfo, 11);
        }

        private void u(DownloadInfo downloadInfo, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i;
            this.u.sendMessage(messageObtain);
        }
    }

    public n(pn pnVar) {
        this.b = pnVar;
    }

    private boolean b() {
        DownloadModel downloadModel = this.u.nr;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.u.nr.getDownloadUrl())) ? false : true;
    }

    private boolean fx() {
        return b() && pn();
    }

    private boolean iz() {
        return com.ss.android.downloadlib.x.mv.u(this.u.nr) && a.u(this.u.b.getLinkMode());
    }

    private boolean pn() {
        return this.u.b.isAddToDownloadManage();
    }

    public void nr(@Nullable DownloadInfo downloadInfo) {
        nr nrVar = this.pn;
        if (nrVar != null) {
            nrVar.u(downloadInfo);
            this.pn = null;
        }
    }

    @Override // com.ss.android.downloadlib.x.s.u
    public void u(Message message) {
    }

    private boolean iz(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.jk.iz.b(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean pn(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.x.mv.u(this.u.nr) && iz(downloadInfo);
    }

    public void fx(DownloadInfo downloadInfo) {
        if (!a.u(this.u.nr) || this.fx) {
            return;
        }
        com.ss.android.downloadlib.b.u.u().u("file_status", (downloadInfo == null || !com.ss.android.downloadlib.x.mv.nr(downloadInfo.getTargetFilePath())) ? 2 : 1, this.u);
        this.fx = true;
    }

    public void u(long j) {
        this.nr = j;
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        this.u = pnVarPn;
        if (pnVarPn.qq()) {
            com.ss.android.downloadlib.pn.fx.u().u("setAdId ModelBox notValid");
        }
    }

    private void nr(final dw dwVar) {
        String str;
        if (com.ss.android.downloadlib.x.jk.nr(g.j)) {
            if (dwVar != null) {
                dwVar.u();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.x.mv.u()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_VIDEO")) {
                if (dwVar != null) {
                    dwVar.u();
                    return;
                }
                return;
            }
        } else {
            str = g.i;
        }
        com.ss.android.downloadlib.x.jk.u(new String[]{str}, new jk.u() { // from class: com.ss.android.downloadlib.addownload.n.2
            @Override // com.ss.android.downloadlib.x.jk.u
            public void u() {
                dw dwVar2 = dwVar;
                if (dwVar2 != null) {
                    dwVar2.u();
                }
            }

            @Override // com.ss.android.downloadlib.x.jk.u
            public void u(String str2) {
                dw dwVar2 = dwVar;
                if (dwVar2 != null) {
                    dwVar2.u(str2);
                }
            }
        });
    }

    public boolean b(DownloadInfo downloadInfo) {
        return iz() || pn(downloadInfo);
    }

    public void u(DownloadInfo downloadInfo) {
        this.fx = false;
        nr(downloadInfo);
    }

    public boolean u(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.x.mv.u(this.u.nr)) {
            com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(this.u.u);
            if (nrVarB != null) {
                com.ss.android.socialbase.downloader.notification.nr.u().iz(nrVarB.bg());
            }
            return com.ss.android.downloadlib.nr.u.u(this.u);
        }
        if (u(i) && !TextUtils.isEmpty(this.u.nr.getPackageName()) && l.a().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.nr.u.u(this.u, i)) {
                return true;
            }
            return this.b.a() && this.b.b(true);
        }
        if (!z || this.u.b.getDownloadMode() != 4 || this.b.pn()) {
            return false;
        }
        this.b.fx(true);
        return true;
    }

    @Nullable
    public String nr() {
        File externalFilesDir = l.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.u> nr(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.u) {
                    arrayList.add((com.ss.android.download.api.download.u) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.u) {
                            arrayList.add((com.ss.android.download.api.download.u) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.u) {
                            arrayList.add((com.ss.android.download.api.download.u) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean u(int i) {
        if (this.u.b.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.u.b.getDownloadMode() == 2 && i == 1 && l.a().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean u(int i, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.iz.pn.fx() && u(i) && !com.ss.android.downloadlib.x.mv.u(downloadModel);
    }

    public boolean u(boolean z) {
        return !z && this.u.b.getDownloadMode() == 1;
    }

    public void u(@NonNull final dw dwVar) {
        if (!TextUtils.isEmpty(this.u.nr.getFilePath())) {
            String filePath = this.u.nr.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                dwVar.u();
                return;
            }
            try {
                String parent = l.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (filePath.startsWith(parent)) {
                    dwVar.u();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        nr(new dw() { // from class: com.ss.android.downloadlib.addownload.n.1
            @Override // com.ss.android.download.api.config.dw
            public void u() {
                dwVar.u();
            }

            @Override // com.ss.android.download.api.config.dw
            public void u(String str) {
                l.fx().u(1, l.getContext(), n.this.u.nr, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.b.u.u().nr(n.this.nr, 1);
                dwVar.u(str);
            }
        });
    }

    public void u(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        nr nrVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.n nVarU = com.ss.android.downloadlib.n.u();
                com.ss.android.downloadlib.addownload.nr.pn pnVar = this.u;
                nVarU.u(pnVar.nr, pnVar.b, pnVar.fx);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.b.u.u().u(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        jk.u(downloadShortInfo);
        int iU = com.ss.android.socialbase.appdownloader.fx.u(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || com.ss.android.socialbase.downloader.n.u.fx().u("fix_click_start")) && (nrVar = this.pn) != null) {
            nrVar.u(downloadInfo);
            this.pn = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : u(map)) {
            if (iU != 1) {
                if (iU == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, jk.u(downloadInfo.getId(), curBytes));
                } else if (iU == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.x.mv.u(this.u.nr)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, jk.u(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.u> it = nr(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public void u() {
        if (this.pn == null) {
            this.pn = new nr() { // from class: com.ss.android.downloadlib.addownload.n.3
                @Override // com.ss.android.downloadlib.addownload.n.nr
                public void u(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.b.u.u().u(n.this.nr, 2, downloadInfo);
                }
            };
        }
    }

    public int u(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.fx.u uVar;
        com.ss.android.socialbase.downloader.model.fx fxVarU;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.u.nr.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (l.a().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.u.nr.getLogExtra()) && (fxVarU = u(this.u.nr.getLogExtra())) != null) {
            arrayList.add(fxVarU);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.fx(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strU = com.ss.android.downloadlib.x.b.u(String.valueOf(this.u.nr.getId()), this.u.nr.getNotificationJumpUrl(), this.u.nr.isShowToast(), String.valueOf(this.u.nr.getModelType()));
        com.ss.android.socialbase.downloader.n.u uVarNr = com.ss.android.downloadlib.x.pn.nr(this.u.nr);
        JSONObject jSONObjectU = com.ss.android.downloadlib.x.pn.u(this.u.nr);
        if (!this.u.b.enableAH()) {
            jSONObjectU = com.ss.android.downloadlib.x.mv.u(jSONObjectU);
            com.ss.android.downloadlib.x.mv.u(jSONObjectU, "ah_plans", new JSONArray());
        }
        int executorGroup = this.u.nr.getExecutorGroup();
        if (this.u.nr.isAd() || a.nr(this.u.nr)) {
            executorGroup = 4;
        }
        String strU2 = u(uVarNr);
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.fx.u(this.u.nr.getDownloadUrl(), strU2));
        if (downloadInfo != null && 3 == this.u.nr.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.iz izVarK = new com.ss.android.socialbase.appdownloader.iz(context, this.u.nr.getDownloadUrl()).nr(this.u.nr.getBackupUrls()).u(this.u.nr.getName()).pn(strU).u(arrayList).u(this.u.nr.isShowNotification()).fx(this.u.nr.isNeedWifi()).nr(this.u.nr.getFileName()).fx(strU2).t(this.u.nr.getAppIcon()).n(this.u.nr.getMd5()).jk(this.u.nr.getSdkMonitorScene()).u(this.u.nr.getExpectFileLength()).u(iDownloadListener).l(this.u.nr.needIndependentProcess() || uVarNr.u("need_independent_process", 0) == 1).u(this.u.nr.getDownloadFileUriProvider()).nr(this.u.nr.autoInstallWithoutNotification()).x(this.u.nr.getPackageName()).b(1000).pn(100).u(jSONObjectU).a(true).jk(true).nr(uVarNr.u("retry_count", 5)).fx(uVarNr.u("backup_url_retry_count", 0)).jk(true).mv(uVarNr.u("need_head_connection", 0) == 1).b(uVarNr.u("need_https_to_http_retry", 0) == 1).n(uVarNr.u("need_chunk_downgrade_retry", 1) == 1).x(uVarNr.u("need_retry_delay", 0) == 1).a(uVarNr.fx("retry_delay_time_array")).t(uVarNr.u("need_reuse_runnable", 0) == 1).iz(executorGroup).my(this.u.nr.isAutoInstall()).k(this.u.nr.distinctDir());
        if (!TextUtils.isEmpty(this.u.nr.getMimeType())) {
            izVarK.iz(this.u.nr.getMimeType());
        } else {
            izVarK.iz(AdBaseConstants.MIME_APK);
        }
        if (uVarNr.u("notification_opt_2", 0) == 1) {
            izVarK.u(false);
            izVarK.nr(true);
        }
        if (uVarNr.u("clear_space_use_disk_handler", 0) == 1) {
            uVar = new com.ss.android.downloadlib.addownload.fx.u();
            izVarK.u(uVar);
        } else {
            uVar = null;
        }
        DownloadModel downloadModel = this.u.nr;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            izVarK.b(((AdDownloadModel) this.u.nr).getTaskKey());
        }
        int iU = a.u(this.u, fx(), izVarK);
        if (uVar != null) {
            uVar.u(iU);
        }
        return iU;
    }

    private String u(com.ss.android.socialbase.downloader.n.u uVar) {
        boolean zNr;
        String strNr;
        if (!TextUtils.isEmpty(this.u.nr.getFilePath())) {
            return this.u.nr.getFilePath();
        }
        DownloadInfo downloadInfoU = com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), this.u.nr.getDownloadUrl());
        if (!com.ss.android.downloadlib.x.mv.u()) {
            zNr = com.ss.android.downloadlib.x.jk.nr(g.j);
        } else {
            zNr = com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_VIDEO");
        }
        String strNr2 = nr();
        if (downloadInfoU != null && !TextUtils.isEmpty(downloadInfoU.getSavePath())) {
            String savePath = downloadInfoU.getSavePath();
            if (zNr || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strNr2)) {
                    if (savePath.startsWith(strNr2)) {
                        return savePath;
                    }
                }
            } catch (Exception unused) {
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).cancel(downloadInfoU.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zNr ? 1 : 2));
        } catch (JSONException unused2) {
        }
        com.ss.android.downloadlib.b.u.u().u("label_external_permission", jSONObject, this.u);
        try {
            strNr = com.ss.android.socialbase.appdownloader.fx.nr();
        } catch (Exception unused3) {
            strNr = null;
        }
        int iU = com.ss.android.downloadlib.x.pn.u(uVar);
        if (iU != 0) {
            if (iU != 4 && (zNr || iU != 2)) {
                if ((iU == 3 || (!zNr && iU == 1)) && !TextUtils.isEmpty(strNr2)) {
                    return strNr2;
                }
            } else {
                File filesDir = l.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return strNr;
    }

    public void u(DownloadInfo downloadInfo, boolean z) {
        if (this.u.nr == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || a.u(this.u.nr) || (z && com.ss.android.downloadlib.b.fx.u().fx() && (status == -2 || status == -3))) {
            com.ss.android.downloadlib.b.u.u().u(this.nr, 2);
        }
        switch (status) {
            case -4:
            case -1:
                u();
                com.ss.android.downloadlib.addownload.nr.iz izVarU = com.ss.android.downloadlib.addownload.nr.iz.u();
                com.ss.android.downloadlib.addownload.nr.pn pnVar = this.u;
                izVarU.u(new com.ss.android.downloadad.api.u.nr(pnVar.nr, pnVar.fx, pnVar.b, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.x.mv.u(this.u.nr)) {
                    com.ss.android.downloadlib.pn.fx.u().nr("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.b.u.u().u(this.nr, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.b.fx.u().nr() && !com.ss.android.downloadlib.b.fx.u().nr(this.nr, this.u.nr.getLogExtra())) {
                        com.ss.android.downloadlib.b.u.u().u(this.nr, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.b.u.u().u(this.nr, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.b.fx.u().nr() && !com.ss.android.downloadlib.b.fx.u().nr(this.nr, this.u.nr.getLogExtra())) {
                    com.ss.android.downloadlib.b.u.u().u(this.nr, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.b.u.u().u(this.nr, 3, downloadInfo);
                break;
        }
    }

    public void u(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list, boolean z) {
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            int curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
            int i = curBytes >= 0 ? curBytes : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            jk.u(downloadShortInfo);
            for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.ss.android.downloadlib.x.mv.u(this.u.nr)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onIdle();
                        }
                        break;
                    case -3:
                        if (z) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                        break;
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, jk.u(downloadInfo.getId(), i));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, jk.u(downloadInfo.getId(), i));
                        break;
                    case 11:
                        if (!(downloadStatusChangeListener instanceof com.ss.android.download.api.download.u)) {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, jk.u(downloadInfo.getId(), i));
                        }
                        break;
                }
            }
            return;
        }
        Iterator<DownloadStatusChangeListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> u(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.model.fx u(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.model.fx("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            l.bq().u(e, "parseLogExtra Error");
            return null;
        }
    }
}
