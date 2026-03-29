package com.ss.android.socialbase.appdownloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.igexin.sdk.PushConsts;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.fx.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.impls.sx;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements l {
    private BroadcastReceiver nr;
    private List<Integer> u;

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        b.t();
        Context contextOa = fx.oa();
        if (contextOa == null) {
            return;
        }
        boolean zNr = iz.nr(contextOa);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            u(contextOa, it.next(), zNr, i);
        }
        List<Integer> list2 = this.u;
        if (list2 == null || list2.isEmpty() || this.nr != null) {
            return;
        }
        this.nr = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.b.nr.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (iz.nr(applicationContext)) {
                    com.ss.android.socialbase.downloader.fx.u.nr("LaunchResume", "onReceive : wifi connected !!!");
                    fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.nr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (nr.this.u != null && !nr.this.u.isEmpty()) {
                                    int size = nr.this.u.size();
                                    Integer[] numArr = new Integer[size];
                                    nr.this.u.toArray(numArr);
                                    nr.this.u.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            nr.this.u(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(nr.this.nr);
                    } catch (Throwable unused) {
                    }
                    nr.this.nr = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            contextOa.registerReceiver(this.nr, intentFilter);
        } catch (Throwable unused) {
            this.nr = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public List<String> u() {
        return com.ss.android.socialbase.appdownloader.fx.fx();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.l
    public void u(final List<DownloadInfo> list, final int i) {
        if (iz.b()) {
            fx.l().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        nr.this.nr(list, i);
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            nr(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
            int iU = uVarU.u("failed_resume_max_count", 0);
            double dU = uVarU.u("failed_resume_max_hours", 72.0d);
            double dU2 = uVarU.u("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (downloadInfo.isPauseReserveOnWifi() && z) ? true : downloadInfo.getFailedResumeCount() < iU && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dU * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastFailedResumeTime())) > dU2 * 3600000.0d;
            if (z3) {
                boolean z4 = uVarU.u("failed_resume_need_wifi", 1) == 1;
                boolean z5 = uVarU.u("failed_resume_need_wait_wifi", 0) == 1;
                if (!z && z4 && z5) {
                    if (this.u == null) {
                        this.u = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.u.contains(Integer.valueOf(id))) {
                        this.u.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    sx.u().u(downloadInfo);
                    z2 = false;
                } else {
                    com.ss.android.socialbase.appdownloader.fx.u(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        com.ss.android.socialbase.downloader.downloader.sx sxVarMy = b.t().my();
                        if (sxVarMy != null) {
                            sxVarMy.u(downloadInfo, 5, i);
                        }
                    }
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            com.ss.android.socialbase.downloader.fx.u.fx("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            n nVarK = b.t().k();
            if (nVarK != null) {
                nVarK.u(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus != -3 || !u(downloadInfo)) {
            if (realStatus == -2) {
                if (downloadInfo.isPauseReserveOnWifi()) {
                    if (z) {
                        com.ss.android.socialbase.appdownloader.fx.u(downloadInfo, true, true);
                        downloadInfo.updateSpData();
                        downloadInfo.setDownloadFromReserveWifi(true);
                        n nVarK2 = b.t().k();
                        if (nVarK2 != null) {
                            nVarK2.u(downloadInfo, true);
                        }
                        com.ss.android.socialbase.downloader.downloader.sx sxVarMy2 = b.t().my();
                        if (sxVarMy2 != null) {
                            sxVarMy2.u(downloadInfo, 5, i);
                            return;
                        }
                        return;
                    }
                    if (this.u == null) {
                        this.u = new ArrayList();
                    }
                    int id2 = downloadInfo.getId();
                    if (!this.u.contains(Integer.valueOf(id2))) {
                        this.u.add(Integer.valueOf(id2));
                    }
                    sx.u().u(downloadInfo);
                }
                u(downloadInfo, context);
                return;
            }
            return;
        }
        com.ss.android.socialbase.downloader.n.u uVarU2 = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
        if (com.ss.android.socialbase.appdownloader.fx.u(context, downloadInfo)) {
            return;
        }
        int iU2 = uVarU2.u("uninstall_resume_max_count", 0);
        double dU3 = uVarU2.u("uninstall_resume_max_hours", 72.0d);
        double dU4 = uVarU2.u("uninstall_resume_min_hours", 12.0d);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean z6 = downloadInfo.getUninstallResumeCount() < iU2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dU3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > dU4 * 3600000.0d;
        com.ss.android.socialbase.downloader.fx.u.fx("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z6);
        if (z6) {
            com.ss.android.socialbase.downloader.notification.u uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(downloadInfo.getId());
            if (uVarPn == null) {
                uVarPn = new com.ss.android.socialbase.appdownloader.pn.u(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.nr.u().u(uVarPn);
            } else {
                uVarPn.u(downloadInfo);
            }
            uVarPn.nr(downloadInfo.getTotalBytes());
            uVarPn.u(downloadInfo.getTotalBytes());
            uVarPn.u(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setLastUninstallResumeTime(jCurrentTimeMillis2);
            downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + 1);
            downloadInfo.updateSpData();
        }
    }

    private void u(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
        int iU = uVarU.u("paused_resume_max_count", 0);
        double dU = uVarU.u("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iU && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dU * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.u uVarPn = com.ss.android.socialbase.downloader.notification.nr.u().pn(downloadInfo.getId());
            if (uVarPn == null) {
                uVarPn = new com.ss.android.socialbase.appdownloader.pn.u(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.nr.u().u(uVarPn);
            } else {
                uVarPn.u(downloadInfo);
            }
            uVarPn.nr(downloadInfo.getTotalBytes());
            uVarPn.u(downloadInfo.getCurBytes());
            uVarPn.u(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean u(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).nr("uninstall_can_not_resume_for_force_task", false)) {
            return iz.u(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
