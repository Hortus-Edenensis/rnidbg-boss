package com.ss.android.socialbase.appdownloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.igexin.sdk.PushConsts;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.fx.k;
import com.ss.android.socialbase.appdownloader.fx.my;
import com.ss.android.socialbase.appdownloader.fx.s;
import com.ss.android.socialbase.appdownloader.fx.t;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.bf;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.mv;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.sx;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static boolean iz = false;
    private static boolean n = false;
    private static volatile b nr = null;
    private static final String u = "b";
    private static boolean x = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Future f10594a;
    private String b;
    private t bg;
    private h bq;
    private my c;
    private bf dw;
    private String fx;
    private int jk;
    private com.ss.android.socialbase.appdownloader.fx.a k;
    private com.ss.android.socialbase.appdownloader.fx.b mv;
    private com.ss.android.socialbase.appdownloader.fx.n my;
    private s o;
    private com.ss.android.socialbase.appdownloader.fx.fx q;
    private com.ss.android.socialbase.appdownloader.fx.pn s;
    private com.ss.android.socialbase.appdownloader.fx.x sx;
    private DownloadReceiver pn = new DownloadReceiver();
    private boolean t = false;
    private boolean l = false;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        synchronized (this.pn) {
            if (x) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.fx.oa().registerReceiver(this.pn, intentFilter);
                com.ss.android.socialbase.downloader.downloader.fx.oa().registerReceiver(this.pn, intentFilter2);
                x = true;
            } catch (Exception unused) {
            }
            com.ss.android.socialbase.downloader.fx.u.nr(u, "registerDownloadReceiver mIsRegistered:" + x);
        }
    }

    private void dw() {
        sx.u(new sx.nr() { // from class: com.ss.android.socialbase.appdownloader.b.3
            @Override // com.ss.android.socialbase.downloader.impls.sx.nr
            public void u(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.u(downloadInfo, j, z, i);
            }
        });
    }

    public static b t() {
        if (nr == null) {
            synchronized (b.class) {
                if (nr == null) {
                    nr = new b();
                }
            }
        }
        return nr;
    }

    public File a() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getGlobalSaveDir();
    }

    public com.ss.android.socialbase.appdownloader.fx.a b() {
        return this.k;
    }

    public com.ss.android.socialbase.appdownloader.fx.pn fx() {
        return this.s;
    }

    public com.ss.android.socialbase.appdownloader.fx.x iz() {
        return this.sx;
    }

    public String jk() {
        return this.fx;
    }

    public com.ss.android.socialbase.appdownloader.fx.n k() {
        return this.my;
    }

    public void l() {
        if (com.ss.android.socialbase.downloader.n.u.fx().u("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.fx.u.nr(u, "disable app install receiver");
            return;
        }
        synchronized (this.pn) {
            try {
                if (n) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.fx.oa().registerReceiver(this.pn, intentFilter);
                    n = true;
                    my myVar = this.c;
                    if (myVar != null) {
                        myVar.u();
                    }
                } catch (Throwable unused) {
                }
                com.ss.android.socialbase.downloader.fx.u.nr(u, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + x);
            } finally {
                nr(0);
            }
        }
    }

    public void mv() {
        my myVar;
        synchronized (this.pn) {
            try {
                if (x) {
                    com.ss.android.socialbase.downloader.downloader.fx.oa().unregisterReceiver(this.pn);
                    if (n && (myVar = this.c) != null) {
                        myVar.nr();
                    }
                }
            } catch (Exception unused) {
            }
            x = false;
            n = false;
        }
        com.ss.android.socialbase.downloader.fx.u.nr(u, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public com.ss.android.socialbase.downloader.downloader.sx my() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getReserveWifiStatusListener();
    }

    public t n() {
        return this.bg;
    }

    public h o() {
        return this.bq;
    }

    public String pn() {
        return this.b;
    }

    public s s() {
        return this.o;
    }

    public bf sx() {
        return this.dw;
    }

    public boolean x() {
        return com.ss.android.socialbase.downloader.n.u.nr().optInt("package_flag_config", 1) == 1;
    }

    private void fx(Context context) {
        if (context == null || iz) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.pn.u(AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.downloader.downloader.fx.u(context);
        com.ss.android.socialbase.downloader.downloader.fx.u(new com.ss.android.socialbase.appdownloader.b.nr());
        if (this.l) {
            com.ss.android.socialbase.downloader.downloader.fx.u(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bq();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            bq();
        }
        dw();
        iz = true;
    }

    public com.ss.android.socialbase.appdownloader.fx.b nr() {
        return this.mv;
    }

    public void nr(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).setDefaultSavePath(str);
    }

    public com.ss.android.socialbase.appdownloader.fx.fx u() {
        return this.q;
    }

    private void nr(int i) {
        this.jk = com.ss.android.socialbase.downloader.n.u.fx().u("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.fx.u.nr(u, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.jk);
        if (this.jk <= 0) {
            return;
        }
        if (i > 0) {
            this.jk = i;
        }
        Future future = this.f10594a;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
        }
        this.f10594a = com.ss.android.socialbase.downloader.downloader.fx.u(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.fx.u.nr(b.u, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                b.this.mv();
                b.this.bq();
            }
        }, this.jk, TimeUnit.SECONDS);
    }

    public void u(com.ss.android.socialbase.appdownloader.fx.fx fxVar) {
        this.q = fxVar;
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    public void u(com.ss.android.socialbase.appdownloader.fx.x xVar) {
        this.sx = xVar;
    }

    public void u(t tVar) {
        this.bg = tVar;
    }

    @Deprecated
    public void u(Context context, String str, com.ss.android.socialbase.appdownloader.fx.b bVar, com.ss.android.socialbase.appdownloader.fx.pn pnVar, com.ss.android.socialbase.appdownloader.fx.a aVar) {
        if (bVar != null) {
            this.mv = bVar;
        }
        if (pnVar != null) {
            this.s = pnVar;
        }
        if (aVar != null) {
            this.k = aVar;
        }
        fx(context);
    }

    private DownloadInfo nr(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public static boolean u(Context context, int i) {
        return fx.u(context, i, true) == 1;
    }

    public List<DownloadInfo> nr(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void u(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    fx.u(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception unused) {
        }
    }

    public static Pair<Intent, Boolean> nr(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 31 && com.ss.android.socialbase.downloader.n.u.u(i).nr("enable_target_34") > 0) {
            return new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), Boolean.FALSE);
    }

    public int u(iz izVar) {
        boolean z;
        int i;
        String str;
        int i2;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (izVar == null || izVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.fx> listU = u(izVar.b());
            String strU = izVar.u();
            if (TextUtils.isEmpty(strU)) {
                return 0;
            }
            final int iBg = izVar.bg();
            final boolean z2 = iBg == 0;
            String strY = izVar.y();
            final String strNr = izVar.nr();
            if (TextUtils.isEmpty(strY)) {
                strY = fx.u(strU, strNr, izVar.l(), z2);
            }
            if (strY.length() > 255) {
                strY = strY.substring(strY.length() - 255);
            }
            if (TextUtils.isEmpty(strNr)) {
                strNr = strY;
            }
            String strL = izVar.l();
            if (strY.endsWith(com.huawei.hms.ads.dynamicloader.b.b) && !fx.fx(izVar.l())) {
                strL = AdBaseConstants.MIME_APK;
            }
            String strFx = izVar.fx();
            if (TextUtils.isEmpty(izVar.fx())) {
                strFx = fx.nr();
            }
            String str2 = strFx;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strY)) {
                String strWi = izVar.wi();
                if (TextUtils.isEmpty(strWi)) {
                    strWi = strU;
                }
                int iU = com.ss.android.socialbase.downloader.downloader.fx.u(strWi, str2);
                if (com.ss.android.socialbase.downloader.n.u.u(izVar.kw()).u("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getDownloadInfo(iU)) != null) {
                    try {
                        izVar.u(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.n.u.u(iU, izVar.kw());
                boolean zJp = izVar.jp();
                boolean z3 = (com.ss.android.socialbase.downloader.n.u.u(iU).u("modify_force", 1) == 1 && !zJp && com.ss.android.socialbase.downloader.jk.iz.b(str2, strY) && Downloader.getInstance(izVar.getContext()).getDownloadInfo(iU) == null) ? true : zJp;
                IDownloadListener iDownloadListenerJk = izVar.jk();
                if (iDownloadListenerJk != null || (!izVar.pn() && !izVar.iz())) {
                    z = z3;
                    i = iU;
                    str = str2;
                } else if (izVar.s() != null) {
                    iDownloadListenerJk = new com.ss.android.socialbase.appdownloader.pn.nr(izVar.s());
                    z = z3;
                    i = iU;
                    str = str2;
                } else {
                    z = z3;
                    i = iU;
                    str = str2;
                    iDownloadListenerJk = new com.ss.android.socialbase.appdownloader.pn.nr(izVar.getContext(), iU, strNr, str2, strY, izVar.t());
                }
                com.ss.android.socialbase.downloader.depend.s sVarXw = izVar.xw();
                if (sVarXw == null) {
                    sVarXw = new com.ss.android.socialbase.downloader.depend.s() { // from class: com.ss.android.socialbase.appdownloader.b.4
                        @Override // com.ss.android.socialbase.downloader.depend.s
                        public void u(DownloadInfo downloadInfo2, BaseException baseException, int i3) {
                            if (b.this.k != null) {
                                b.this.k.u(downloadInfo2, baseException, i3);
                            }
                        }
                    };
                }
                List<mv> listD = com.ss.android.socialbase.downloader.downloader.fx.d();
                if (!listD.isEmpty()) {
                    Iterator<mv> it = listD.iterator();
                    while (it.hasNext()) {
                        izVar.u(it.next());
                    }
                }
                String strT = izVar.t();
                try {
                    if (!TextUtils.isEmpty(strT)) {
                        jSONObject = new JSONObject(strT);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", izVar.x());
                    jSONObject.put("auto_install_without_notification", izVar.iz());
                    strT = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z4 = izVar.pn() || izVar.iz();
                if (!z4 || com.ss.android.socialbase.downloader.n.u.u(i).nr("enable_notification_ui") <= 0) {
                    i2 = i;
                } else {
                    i2 = i;
                    com.ss.android.socialbase.appdownloader.pn.fx.u().u(i2, izVar.gc());
                }
                final DownloadTask autoInstall = com.ss.android.socialbase.downloader.downloader.nr.with(izVar.getContext()).url(strU).backUpUrls(izVar.mk()).name(strY).title(strNr).savePath(str).onlyWifi(izVar.n()).extraHeaders(listU).depend(sVarXw).retryCount(izVar.q()).backUpUrlRetryCount(izVar.qq()).showNotification(z4).extra(strT).mimeType(strL).minProgressTimeMsInterval(izVar.rh()).maxProgressCount(izVar.ja()).mainThreadListener(izVar.a()).notificationListener(iDownloadListenerJk).notificationEventListener(u(izVar.oa())).force(z).autoResumed(izVar.o()).showNotificationForAutoResumed(izVar.sx()).chunkStategy(izVar.k()).chunkAdjustCalculator(izVar.my()).needHttpsToHttpRetry(izVar.mv()).packageName(izVar.bq()).md5(izVar.dw()).expectFileLength(izVar.c()).needRetryDelay(izVar.kj()).retryDelayTimeArray(izVar.z()).needDefaultHttpServiceBackUp(izVar.gi()).needReuseFirstConnection(izVar.d()).needReuseChunkRunnable(izVar.bf()).needIndependentProcess(izVar.wq()).enqueueType(izVar.m()).monitorDepend(izVar.bc()).retryDelayTimeCalculator(izVar.h()).headConnectionAvailable(izVar.pb()).fileUriProvider(izVar.w()).diskSpaceHandler(izVar.p()).needChunkDowngradeRetry(izVar.xg()).notificationClickCallback(izVar.cj()).downloadSetting(izVar.kw()).iconUrl(izVar.gc()).needSDKMonitor(izVar.ay()).monitorScene(izVar.v()).extraMonitorStatus(izVar.eh()).executorGroup(izVar.mh()).throttleNetSpeed(izVar.yd()).distinctDirectory(izVar.lf()).taskKey(izVar.wi()).setAutoInstall(izVar.nb());
                if (autoInstall != null && !izVar.tk().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(izVar.tk());
                }
                if (autoInstall != null) {
                    if (z4 && izVar.su() && izVar.getActivity() != null && !izVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.pn.b.u()) {
                        com.ss.android.socialbase.appdownloader.pn.b.u(izVar.getActivity(), new k() { // from class: com.ss.android.socialbase.appdownloader.b.5
                            @Override // com.ss.android.socialbase.appdownloader.fx.k
                            public void nr() {
                                com.ss.android.socialbase.downloader.fx.u.nr(b.u, "notification permission denied, start download :" + strNr);
                                b.this.u(autoInstall, iBg, z2);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.fx.k
                            public void u() {
                                com.ss.android.socialbase.downloader.fx.u.nr(b.u, "notification permission granted, start download :" + strNr);
                                b.this.u(autoInstall, iBg, z2);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.fx.u.nr(u, "notification permission need not request, start download :".concat(String.valueOf(strNr)));
                        com.ss.android.socialbase.appdownloader.pn.b.u(i2);
                        u(autoInstall, iBg, z2);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i2;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.b.u.u(izVar.bc(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.jk.iz.nr(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.fx.u.pn(u, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.fx> u(List<com.ss.android.socialbase.downloader.model.fx> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.fx fxVar : list) {
                if (fxVar != null && !TextUtils.isEmpty(fxVar.u()) && !TextUtils.isEmpty(fxVar.nr())) {
                    if (fxVar.u().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.fx(fxVar.u(), fxVar.nr()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.fx("User-Agent", com.ss.android.socialbase.appdownloader.nr.u.u));
        }
        return arrayList;
    }

    public String u(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(com.huawei.hms.ads.dynamicloader.b.b) || fx.fx(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private z u(final com.ss.android.socialbase.appdownloader.fx.iz izVar) {
        if (izVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.appdownloader.b.6
            @Override // com.ss.android.socialbase.downloader.depend.z
            public void u(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 8:
                            downloadInfo.getPackageName();
                            break;
                        case 9:
                            com.ss.android.socialbase.downloader.downloader.fx.oa();
                            break;
                    }
                    return;
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean u(boolean z) {
                return izVar.u(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public String u() {
                return izVar.u();
            }
        };
    }

    public DownloadInfo u(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoU = u(context, str, a());
                if (downloadInfoU == null) {
                    downloadInfoU = u(context, str, com.bytedance.sdk.openadsdk.api.plugin.nr.u(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoU == null) {
                    downloadInfoU = u(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoU == null) {
                    downloadInfoU = u(context, str, com.bytedance.sdk.openadsdk.api.plugin.nr.u(context));
                }
                return (downloadInfoU == null && com.ss.android.socialbase.downloader.n.u.fx().u("get_download_info_by_list")) ? nr(context, str) : downloadInfoU;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.fx.u.nr(u, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo u(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> u(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void u(com.ss.android.socialbase.appdownloader.fx.n nVar) {
        this.my = nVar;
    }

    public void u(com.ss.android.socialbase.downloader.downloader.sx sxVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).setReserveWifiStatusListener(sxVar);
    }

    public void u(h hVar) {
        this.bq = hVar;
    }

    public void u(bf bfVar) {
        this.dw = bfVar;
    }

    public void u(int i) {
        if (com.ss.android.socialbase.downloader.n.u.fx().u("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        l();
        nr(i);
    }

    public void u(my myVar) {
        this.c = myVar;
    }

    public static PendingIntent u(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }
}
