package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.dw;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.fx;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.n;
import com.ss.android.downloadlib.x.s;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn implements x, s.u {
    private static final String u = "pn";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fx f10590a;
    private b b;
    private boolean bg;
    private final boolean bq;
    private SoftReference<IDownloadButtonClickListener> dw;
    private n fx;
    private final Map<Integer, Object> iz;
    private final IDownloadListener jk;
    private DownloadModel k;
    private long l;
    private String mv;
    private DownloadEventConfig my;
    private DownloadInfo n;
    private final com.ss.android.downloadlib.x.s nr;
    private DownloadController o;
    private WeakReference<Context> pn;
    private long s;
    private SoftReference<OnItemClickListener> sx;
    private boolean t;
    private DownloadShortInfo x;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public pn() {
        com.ss.android.downloadlib.x.s sVar = new com.ss.android.downloadlib.x.s(Looper.getMainLooper(), this);
        this.nr = sVar;
        this.iz = new ConcurrentHashMap();
        this.jk = new n.u(sVar);
        this.s = -1L;
        this.k = null;
        this.my = null;
        this.o = null;
        this.fx = new n(this);
        this.b = new b(sVar);
        this.bq = com.ss.android.socialbase.downloader.n.u.fx().u("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.pn;
        return (weakReference == null || weakReference.get() == null) ? l.getContext() : this.pn.get();
    }

    private boolean k() {
        if (!com.ss.android.socialbase.downloader.n.u.fx().u("fix_click_start")) {
            DownloadInfo downloadInfo = this.n;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(l.getContext()).canResume(this.n.getId())) || this.n.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.n;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.n.getCurBytes() <= 0) || this.n.getStatus() == 0 || this.n.getStatus() == -4) {
            return true;
        }
        return com.ss.android.socialbase.downloader.jk.iz.u(this.n.getStatus(), this.n.getSavePath(), this.n.getName());
    }

    @NonNull
    private DownloadEventConfig l() {
        DownloadEventConfig downloadEventConfig = this.my;
        return downloadEventConfig == null ? new fx.u().u() : downloadEventConfig;
    }

    @NonNull
    private DownloadController mv() {
        if (this.o == null) {
            this.o = new com.ss.android.download.api.download.nr();
        }
        return this.o;
    }

    private void my() {
        fx fxVar = this.f10590a;
        if (fxVar != null && fxVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f10590a.cancel(true);
        }
        this.f10590a = new fx();
        if (TextUtils.isEmpty(this.mv)) {
            com.ss.android.downloadlib.x.nr.u(this.f10590a, this.k.getDownloadUrl(), this.k.getPackageName());
        } else {
            com.ss.android.downloadlib.x.nr.u(this.f10590a, this.k.getDownloadUrl(), this.k.getPackageName(), this.mv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo o() {
        if (this.x == null) {
            this.x = new DownloadShortInfo();
        }
        return this.x;
    }

    private void s() {
        String str = u;
        com.ss.android.downloadlib.x.t.u(str, "pICD", null);
        if (this.fx.b(this.n)) {
            com.ss.android.downloadlib.x.t.u(str, "pICD BC", null);
            iz(false);
        } else {
            com.ss.android.downloadlib.x.t.u(str, "pICD IC", null);
            t();
        }
    }

    private void t() {
        SoftReference<OnItemClickListener> softReference = this.sx;
        if (softReference != null && softReference.get() != null) {
            this.sx.get().onItemClick(this.k, l(), mv());
            this.sx = null;
        } else {
            l.nr();
            getContext();
            mv();
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        Iterator<DownloadStatusChangeListener> it = n.u(this.iz).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.k, mv());
        }
        int iU = this.fx.u(l.getContext(), this.jk);
        String str = u;
        com.ss.android.downloadlib.x.t.u(str, "beginDown id:" + iU, null);
        if (iU == 0) {
            DownloadInfo downloadInfoU = new DownloadInfo.u(this.k.getDownloadUrl()).u();
            downloadInfoU.setStatus(-1);
            u(downloadInfoU);
            com.ss.android.downloadlib.b.u.u().u(this.s, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.pn.fx.u().nr("beginDown");
        } else if (this.n != null && !com.ss.android.socialbase.downloader.n.u.fx().u("fix_click_start")) {
            this.fx.u(this.n, false);
        } else if (z) {
            this.fx.u();
        }
        if (this.fx.u(fx())) {
            com.ss.android.downloadlib.x.t.u(str, "beginDown IC id:" + iU, null);
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final boolean z) {
        this.b.u(new com.ss.android.downloadlib.addownload.nr.pn(this.s, this.k, l(), mv()));
        this.b.u(0, 0L, 0L, new u() { // from class: com.ss.android.downloadlib.addownload.pn.9
            @Override // com.ss.android.downloadlib.addownload.pn.u
            public void u() {
                if (pn.this.b.u()) {
                    return;
                }
                pn.this.n(z);
            }
        });
    }

    public boolean a() {
        SoftReference<IDownloadButtonClickListener> softReference = this.dw;
        if (softReference == null) {
            return false;
        }
        return a.u(this.k, softReference.get());
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public long b() {
        return this.l;
    }

    public boolean fx() {
        DownloadInfo downloadInfo = this.n;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public void iz() {
        this.nr.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.pn.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = n.u((Map<Integer, Object>) pn.this.iz).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(pn.this.o());
                }
            }
        });
    }

    public boolean pn() {
        return l.a().optInt("quick_app_enable_switch", 0) == 0 && this.k.getQuickAppModel() != null && !TextUtils.isEmpty(this.k.getQuickAppModel().u()) && com.ss.android.downloadlib.addownload.fx.u(this.n) && com.ss.android.downloadlib.x.mv.u(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.k.getQuickAppModel().u())));
    }

    private boolean fx(int i) {
        if (!pn()) {
            return false;
        }
        String strU = this.k.getQuickAppModel().u();
        int i2 = i != 1 ? i != 2 ? -1 : 4 : 5;
        DownloadModel downloadModel = this.k;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zFx = com.ss.android.downloadlib.x.a.fx(l.getContext(), strU);
        if (zFx) {
            com.ss.android.downloadlib.b.u.u().u(this.s, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.k.getId());
            com.ss.android.downloadlib.addownload.fx.u().u(this, i2, this.k);
        } else {
            com.ss.android.downloadlib.b.u.u().u(this.s, false, 0);
        }
        return zFx;
    }

    private void iz(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = u;
        com.ss.android.downloadlib.x.t.u(str, "pBCD", null);
        if (k()) {
            com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(this.s);
            if (this.bg) {
                if (a()) {
                    if (b(false) && (downloadController2 = pnVarPn.b) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        u(z, true);
                        return;
                    }
                    return;
                }
                u(z, true);
                return;
            }
            if (this.k.isAd() && (downloadController = pnVarPn.b) != null && downloadController.enableShowComplianceDialog() && pnVarPn.nr != null && com.ss.android.downloadlib.addownload.compliance.nr.u().u(pnVarPn.nr) && com.ss.android.downloadlib.addownload.compliance.nr.u().u(pnVarPn)) {
                return;
            }
            u(z, true);
            return;
        }
        com.ss.android.downloadlib.x.t.u(str, "pBCD continue download, status:" + this.n.getStatus(), null);
        DownloadInfo downloadInfo = this.n;
        if (downloadInfo != null && (downloadModel = this.k) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.n.getStatus();
        final int id = this.n.getId();
        final com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(this.n);
        if (status != -2 && status != -1) {
            if (k.u(status)) {
                if (this.k.enablePause()) {
                    this.b.u(true);
                    com.ss.android.downloadlib.fx.n.u().nr(com.ss.android.downloadlib.addownload.nr.iz.u().b(this.s));
                    if (com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVarU).u("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.b.b.u().u(nrVarU, status, new com.ss.android.downloadlib.addownload.b.n() { // from class: com.ss.android.downloadlib.addownload.pn.6
                            @Override // com.ss.android.downloadlib.addownload.b.n
                            public void u(com.ss.android.downloadad.api.u.nr nrVar) {
                                if (pn.this.n == null && com.ss.android.socialbase.downloader.n.u.fx().u("fix_handle_pause")) {
                                    pn.this.n = Downloader.getInstance(l.getContext()).getDownloadInfo(id);
                                }
                                pn.this.fx.u(pn.this.n, z);
                                if (pn.this.n != null && com.ss.android.socialbase.downloader.jk.iz.nr(l.getContext()) && pn.this.n.isPauseReserveOnWifi()) {
                                    pn.this.n.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_cancel_on_wifi", nrVarU);
                                } else {
                                    t.u().u(pn.this.k, pn.this.n);
                                    nrVar.t(System.currentTimeMillis());
                                    pn pnVar = pn.this;
                                    pnVar.u(id, status, pnVar.n);
                                }
                            }
                        }, new com.ss.android.downloadlib.addownload.u.fx() { // from class: com.ss.android.downloadlib.addownload.pn.5
                            @Override // com.ss.android.downloadlib.addownload.u.fx
                            public void delete() {
                                pn.this.u(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.b.t.u().u(nrVarU, status, new com.ss.android.downloadlib.addownload.b.n() { // from class: com.ss.android.downloadlib.addownload.pn.7
                            @Override // com.ss.android.downloadlib.addownload.b.n
                            public void u(com.ss.android.downloadad.api.u.nr nrVar) {
                                if (pn.this.n == null && com.ss.android.socialbase.downloader.n.u.fx().u("fix_handle_pause")) {
                                    pn.this.n = Downloader.getInstance(l.getContext()).getDownloadInfo(id);
                                }
                                pn.this.fx.u(pn.this.n, z);
                                if (pn.this.n != null && com.ss.android.socialbase.downloader.jk.iz.nr(l.getContext()) && pn.this.n.isPauseReserveOnWifi()) {
                                    pn.this.n.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.b.u.u().nr("pause_reserve_wifi_cancel_on_wifi", nrVarU);
                                } else {
                                    t.u().u(pn.this.k, pn.this.n);
                                    nrVar.t(System.currentTimeMillis());
                                    pn pnVar = pn.this;
                                    pnVar.u(id, status, pnVar.n);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.fx.u(this.n, z);
            u(id, status, this.n);
            return;
        }
        this.fx.u(this.n, z);
        if (nrVarU != null) {
            nrVarU.n(System.currentTimeMillis());
            nrVarU.a(this.n.getCurBytes());
        }
        this.n.setDownloadFromReserveWifi(false);
        this.b.u(new com.ss.android.downloadlib.addownload.nr.pn(this.s, this.k, l(), mv()));
        this.b.u(id, this.n.getCurBytes(), this.n.getTotalBytes(), new u() { // from class: com.ss.android.downloadlib.addownload.pn.3
            @Override // com.ss.android.downloadlib.addownload.pn.u
            public void u() {
                if (pn.this.b.u()) {
                    return;
                }
                pn pnVar = pn.this;
                pnVar.u(id, status, pnVar.n);
            }
        });
        if (status == -2 && com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVarU).u("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.n.u().nr().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.pn.4
                @Override // java.lang.Runnable
                public void run() {
                    l.fx().u(13, l.getContext(), pn.this.k, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    public boolean b(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.dw;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.dw.get().handleComplianceDialog(true);
                } else {
                    this.dw.get().handleMarketFailedComplianceDialog();
                }
                this.dw = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.pn.fx.u().nr("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.pn.fx.u().nr("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void x() {
        if (this.iz.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = n.u(this.iz).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.n;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.x
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public pn nr(Context context) {
        if (context != null) {
            this.pn = new WeakReference<>(context);
        }
        l.nr(context);
        return this;
    }

    private void pn(boolean z) {
        if (com.ss.android.downloadlib.x.pn.nr(this.k).nr("notification_opt_2") == 1 && this.n != null) {
            com.ss.android.socialbase.downloader.notification.nr.u().iz(this.n.getId());
        }
        iz(z);
    }

    @Override // com.ss.android.downloadlib.addownload.x
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public pn nr(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (l.a().optInt("back_use_softref_listener") == 1) {
                this.iz.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else if (l.a().optInt("use_weakref_listener") == 1) {
                this.iz.put(Integer.valueOf(i), new WeakReference(downloadStatusChangeListener));
            } else {
                this.iz.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public boolean nr() {
        return this.t;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public void nr(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.fx.u(this.s);
        if (!com.ss.android.downloadlib.addownload.nr.iz.u().pn(this.s).kj()) {
            com.ss.android.downloadlib.pn.fx.u().u("handleDownload ModelBox !isStrictValid");
        }
        if (this.fx.u(i, this.k)) {
            com.ss.android.downloadlib.addownload.compliance.iz.u().u(this.fx.u, new com.ss.android.downloadlib.addownload.compliance.n() { // from class: com.ss.android.downloadlib.addownload.pn.1
                @Override // com.ss.android.downloadlib.addownload.compliance.n
                public void u(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (com.ss.android.downloadlib.x.n.u(pn.this.getContext(), pn.this.fx.u, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.iz.u().u(0, pn.this.fx.u, jSONObject);
                            return;
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 0);
                        com.ss.android.downloadlib.addownload.compliance.iz.u().u(1, pn.this.fx.u, jSONObject);
                        int i2 = i;
                        if (i2 == 1) {
                            com.ss.android.socialbase.downloader.fx.u.u(pn.u, "miui new rollback fail: handleDownload id:" + pn.this.s + ",tryPerformButtonClick:", null);
                            pn.this.fx(true);
                            return;
                        }
                        if (i2 != 2) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.fx.u.u(pn.u, "miui new rollback fail: handleDownload id:" + pn.this.s + ",tryPerformButtonClick:", null);
                        pn.this.nr(true);
                    } catch (Exception e) {
                        com.ss.android.downloadlib.pn.fx.u().u(e, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.n
                public void u() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.fx.u.u(pn.u, "miui new get miui deeplink fail: handleDownload id:" + pn.this.s + ",tryPerformButtonClick:", null);
                        pn.this.fx(true);
                        return;
                    }
                    if (i2 != 2) {
                        return;
                    }
                    com.ss.android.socialbase.downloader.fx.u.u(pn.u, "miui new get miui deeplink fail: handleDownload id:" + pn.this.s + ",tryPerformButtonClick:", null);
                    pn.this.nr(true);
                }
            });
            return;
        }
        if (this.fx.u(getContext(), i, this.bg)) {
            return;
        }
        boolean zFx = fx(i);
        if (i == 1) {
            if (zFx) {
                return;
            }
            com.ss.android.downloadlib.x.t.u(u, "handleDownload id:" + this.s + ",pIC:", null);
            fx(true);
            return;
        }
        if (i == 2 && !zFx) {
            com.ss.android.downloadlib.x.t.u(u, "handleDownload id:" + this.s + ",pBC:", null);
            nr(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.x
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public pn nr(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.pn.fx.u().u("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.pn.fx.u().u(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadModel);
            this.s = downloadModel.getId();
            this.k = downloadModel;
            if (a.u(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(this.s);
                if (nrVarB != null && nrVarB.l() != 3) {
                    nrVarB.pn(3L);
                    com.ss.android.downloadlib.addownload.nr.a.u().u(nrVarB);
                }
            }
        }
        return this;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class fx extends com.bytedance.sdk.component.jk.b.nr<String, Void, DownloadInfo> {
        private fx() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (pn.this.k != null && !TextUtils.isEmpty(pn.this.k.getFilePath())) {
                downloadInfo = !TextUtils.isEmpty(str) ? Downloader.getInstance(l.getContext()).getDownloadInfo(Downloader.getInstance(l.getContext()).getDownloadId(str, pn.this.k.getFilePath())) : Downloader.getInstance(l.getContext()).getDownloadInfo(str2, pn.this.k.getFilePath());
            }
            return downloadInfo == null ? !TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), str) : com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), str2) : downloadInfo;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || pn.this.k == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.nr.fx fxVarU = com.ss.android.downloadlib.x.mv.u(pn.this.k.getPackageName(), pn.this.k.getVersionCode(), pn.this.k.getVersionName());
                com.ss.android.downloadlib.addownload.nr.n.u().u(pn.this.k.getVersionCode(), fxVarU.nr(), com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo));
                boolean zU = fxVarU.u();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zU || !Downloader.getInstance(l.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(l.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (pn.this.n == null || pn.this.n.getStatus() != -4) {
                        pn.this.n = downloadInfo;
                        if (pn.this.bq) {
                            Downloader.getInstance(l.getContext()).setMainThreadListener(pn.this.n.getId(), pn.this.jk, false);
                        } else {
                            Downloader.getInstance(l.getContext()).setMainThreadListener(pn.this.n.getId(), pn.this.jk);
                        }
                    } else {
                        pn.this.n = null;
                    }
                    pn.this.fx.u(pn.this.n, pn.this.o(), n.u((Map<Integer, Object>) pn.this.iz), zU);
                } else {
                    if (downloadInfo != null && Downloader.getInstance(l.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.nr.u().iz(downloadInfo.getId());
                        pn.this.n = null;
                    }
                    if (pn.this.n != null) {
                        Downloader.getInstance(l.getContext()).removeTaskMainListener(pn.this.n.getId());
                        if (pn.this.bq) {
                            Downloader.getInstance(pn.this.getContext()).setMainThreadListener(pn.this.n.getId(), pn.this.jk, false);
                        } else {
                            Downloader.getInstance(pn.this.getContext()).setMainThreadListener(pn.this.n.getId(), pn.this.jk);
                        }
                    }
                    if (!zU) {
                        Iterator<DownloadStatusChangeListener> it = n.u((Map<Integer, Object>) pn.this.iz).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        pn.this.n = null;
                    } else {
                        pn pnVar = pn.this;
                        pnVar.n = new DownloadInfo.u(pnVar.k.getDownloadUrl()).u();
                        pn.this.n.setStatus(-3);
                        pn.this.fx.u(pn.this.n, pn.this.o(), n.u((Map<Integer, Object>) pn.this.iz), zU);
                    }
                }
                pn.this.fx.fx(pn.this.n);
            } catch (Exception unused) {
            }
        }
    }

    public void fx(boolean z) {
        if (z) {
            com.ss.android.downloadlib.b.u.u().u(this.s, 1);
        }
        s();
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public void n() {
        com.ss.android.downloadlib.addownload.nr.iz.u().iz(this.s);
    }

    public void nr(boolean z) {
        pn(z);
    }

    @Override // com.ss.android.downloadlib.addownload.x
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public pn nr(DownloadController downloadController) {
        JSONObject extra;
        this.o = downloadController;
        if (com.ss.android.downloadlib.x.pn.nr(this.k).nr("force_auto_open") == 1) {
            mv().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_show_dialog") && (extra = this.k.getExtra()) != null && extra.optInt("subprocess") > 0) {
            mv().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.nr.iz.u().u(this.s, mv());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public pn nr(DownloadEventConfig downloadEventConfig) {
        this.my = downloadEventConfig;
        this.bg = l().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.nr.iz.u().u(this.s, l());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public x u(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.sx = null;
        } else {
            this.sx = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public void u() {
        this.t = true;
        com.ss.android.downloadlib.addownload.nr.iz.u().u(this.s, l());
        com.ss.android.downloadlib.addownload.nr.iz.u().u(this.s, mv());
        this.fx.u(this.s);
        my();
        if (l.a().optInt("enable_empty_listener", 1) == 1 && this.iz.get(Integer.MIN_VALUE) == null) {
            nr(Integer.MIN_VALUE, new com.ss.android.download.api.config.u());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public boolean u(int i) {
        if (i == 0) {
            this.iz.clear();
        } else {
            this.iz.remove(Integer.valueOf(i));
        }
        if (this.iz.isEmpty()) {
            this.t = false;
            this.l = System.currentTimeMillis();
            if (this.n != null) {
                Downloader.getInstance(l.getContext()).removeTaskMainListener(this.n.getId());
            }
            fx fxVar = this.f10590a;
            if (fxVar != null && fxVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f10590a.cancel(true);
            }
            this.fx.u(this.n);
            String str = u;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.n;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.x.t.u(str, sb.toString(), null);
            this.nr.removeCallbacksAndMessages(null);
            this.x = null;
            this.n = null;
            return true;
        }
        if (this.iz.size() == 1 && this.iz.containsKey(Integer.MIN_VALUE)) {
            this.fx.nr(this.n);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public void u(boolean z) {
        if (this.n != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.fx.pn pnVarFx = com.ss.android.socialbase.appdownloader.b.t().fx();
                if (pnVarFx != null) {
                    pnVarFx.u(this.n);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).cancel(this.n.getId(), true);
                return;
            }
            Intent intent = new Intent(l.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.n.getId());
            l.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public x u(long j) {
        if (j != 0) {
            DownloadModel downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(j);
            if (downloadModelU != null) {
                this.k = downloadModelU;
                this.s = j;
                this.fx.u(j);
            }
        } else {
            com.ss.android.downloadlib.pn.fx.u().u(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.x.s.u
    public void u(Message message) {
        if (message != null && this.t && message.what == 3) {
            this.n = (DownloadInfo) message.obj;
            this.fx.u(message, o(), this.iz);
        }
    }

    public void u(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.b.u.u().u(this.s, 2);
        }
        if (!com.ss.android.downloadlib.x.mv.u()) {
            if (!com.ss.android.downloadlib.x.jk.nr(g.j) && !mv().enableNewActivity()) {
                this.k.setFilePath(this.fx.nr());
            }
        } else if (!com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.x.jk.nr("android.permission.READ_MEDIA_VIDEO") && !mv().enableNewActivity()) {
            this.k.setFilePath(this.fx.nr());
        }
        if (com.ss.android.downloadlib.x.pn.fx(this.k) == 0) {
            com.ss.android.downloadlib.x.t.u(u, "pBCD not start", null);
            this.fx.u(new dw() { // from class: com.ss.android.downloadlib.addownload.pn.8
                @Override // com.ss.android.download.api.config.dw
                public void u() {
                    com.ss.android.downloadlib.x.t.u(pn.u, "pBCD start download", null);
                    pn.this.x(z2);
                }

                @Override // com.ss.android.download.api.config.dw
                public void u(String str) {
                    com.ss.android.downloadlib.x.t.u(pn.u, "pBCD onDenied", null);
                }
            });
        } else {
            x(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, int i2, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.b.u().pn(i)) {
                u(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.b.t().u(l.getContext(), i, i2);
    }

    private void u(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.nr.sendMessage(messageObtain);
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public x u(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mv = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.x
    public x u(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.dw = null;
        } else {
            this.dw = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
