package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapapi.SDKInitializer;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.nr;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.pn.nr;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.downloadlib.x.t;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements com.ss.android.downloadad.api.nr {
    private static volatile nr nr = null;
    private static String u = "nr";
    private jk fx = jk.u(l.getContext());

    private nr() {
    }

    public static DownloadEventConfig fx() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog nr(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (u(downloadModel.getId())) {
            if (z2) {
                u(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                nr(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.fx.u(context, i, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) mv.u(downloadEventConfig, fx());
        final DownloadController downloadController2 = (DownloadController) mv.u(downloadController, nr());
        downloadEventConfig2.setDownloadScene(1);
        if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.nr.u().u(downloadModel)) ? true : (l.a().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.fx.u(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        t.u(u, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogNr = l.fx().nr(new nr.u(context).u(downloadModel.getName()).nr("确认要下载此应用吗？").fx("确认").b("取消").u(new nr.InterfaceC0840nr() { // from class: com.ss.android.downloadlib.nr.2
            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void fx(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.u.u().u("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void nr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.u.u().u("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void u(DialogInterface dialogInterface) {
                nr.this.fx.u(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                com.ss.android.downloadlib.b.u.u().u("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).u(0).u());
        com.ss.android.downloadlib.b.u.u().u("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
        return dialogNr;
    }

    public static nr u() {
        if (nr == null) {
            synchronized (nr.class) {
                if (nr == null) {
                    nr = new nr();
                }
            }
        }
        return nr;
    }

    @Override // com.ss.android.downloadad.api.nr
    public Dialog u(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return u(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.ss.android.downloadad.api.nr
    public Dialog u(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return u(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog u(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return u(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog u(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.pn.nr.u(new nr.u<Dialog>() { // from class: com.ss.android.downloadlib.nr.1
            @Override // com.ss.android.downloadlib.pn.nr.u
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Dialog nr() {
                return nr.this.nr(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.nr
    public boolean u(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(j);
        if (nrVarB != null) {
            this.fx.u(context, i, downloadStatusChangeListener, nrVarB.rv());
            return true;
        }
        DownloadModel downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(j);
        if (downloadModelU == null) {
            return false;
        }
        this.fx.u(context, i, downloadStatusChangeListener, downloadModelU);
        return true;
    }

    @Override // com.ss.android.downloadad.api.nr
    public boolean u(long j, int i) {
        DownloadModel downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(j);
        if (downloadModelU == null) {
            return false;
        }
        this.fx.u(downloadModelU.getDownloadUrl(), i);
        return true;
    }

    public void u(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(j);
        com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(j);
        if (downloadModelU == null && nrVarB != null) {
            downloadModelU = nrVarB.rv();
        }
        if (downloadModelU == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.fx) && !(downloadController instanceof com.ss.android.download.api.download.nr)) {
            downloadEventConfig.setDownloadScene(1);
            this.fx.u(downloadModelU.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
        } else {
            nr(j);
        }
    }

    public void nr(long j) {
        DownloadModel downloadModelU = com.ss.android.downloadlib.addownload.nr.iz.u().u(j);
        com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(j);
        if (downloadModelU == null && nrVarB != null) {
            downloadModelU = nrVarB.rv();
        }
        if (downloadModelU == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigNr = com.ss.android.downloadlib.addownload.nr.iz.u().nr(j);
        DownloadController downloadControllerFx = com.ss.android.downloadlib.addownload.nr.iz.u().fx(j);
        if (downloadEventConfigNr instanceof com.ss.android.download.api.download.fx) {
            downloadEventConfigNr = null;
        }
        if (downloadControllerFx instanceof com.ss.android.download.api.download.nr) {
            downloadControllerFx = null;
        }
        if (nrVarB == null) {
            if (downloadEventConfigNr == null) {
                downloadEventConfigNr = fx();
            }
            if (downloadControllerFx == null) {
                downloadControllerFx = nr();
            }
        } else {
            if (downloadEventConfigNr == null) {
                downloadEventConfigNr = new AdDownloadEventConfig.Builder().setClickButtonTag(nrVarB.jk()).setRefer(nrVarB.a()).setIsEnableV3Event(nrVarB.mv()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerFx == null) {
                downloadControllerFx = nrVarB.ob();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigNr;
        downloadEventConfig.setDownloadScene(1);
        this.fx.u(downloadModelU.getDownloadUrl(), j, 2, downloadEventConfig, downloadControllerFx);
    }

    @Override // com.ss.android.downloadad.api.nr
    public boolean u(long j) {
        return (com.ss.android.downloadlib.addownload.nr.iz.u().u(j) == null && com.ss.android.downloadlib.addownload.nr.iz.u().b(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.nr
    public boolean u(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return u(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.nr
    public boolean u(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.pn.nr.u(new nr.u<Boolean>() { // from class: com.ss.android.downloadlib.nr.3
            @Override // com.ss.android.downloadlib.pn.nr.u
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public Boolean nr() {
                return Boolean.valueOf(nr.this.nr(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController u(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nr(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerNr = downloadController;
        if (!com.ss.android.download.api.fx.u.u(uri) || l.a().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? l.getContext() : context;
        String strNr = com.ss.android.download.api.fx.u.nr(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.x.a.u(context2, strNr).getType() == 5;
        }
        if (!TextUtils.isEmpty(strNr) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strNr);
        }
        if (downloadControllerNr != null) {
            downloadControllerNr.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerNr = u(true);
        } else if (downloadModel.getDownloadUrl().startsWith(BaseConstants.SCHEME_MARKET)) {
            downloadControllerNr = u(true);
        } else {
            downloadControllerNr = nr();
        }
        com.ss.android.downloadlib.addownload.nr.pn pnVar = new com.ss.android.downloadlib.addownload.nr.pn(downloadModel.getId(), downloadModel, (DownloadEventConfig) mv.u(downloadEventConfig, fx()), downloadControllerNr);
        com.ss.android.downloadlib.addownload.nr.iz.u().u(pnVar.nr);
        com.ss.android.downloadlib.addownload.nr.iz.u().u(pnVar.u, pnVar.fx);
        com.ss.android.downloadlib.addownload.nr.iz.u().u(pnVar.u, pnVar.b);
        if (mv.u(downloadModel) && com.ss.android.socialbase.downloader.n.u.fx().nr("app_link_opt") == 1 && com.ss.android.downloadlib.nr.u.u(pnVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, WfConstant.EXTRA_KEY_MARKET_URL, uri.toString());
        mv.u(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.b.u.u().nr("market_click_open", jSONObject, pnVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(context2, pnVar, strNr);
        String strU = mv.u(xVarU.nr(), "open_market");
        if (xVarU.getType() == 5) {
            com.ss.android.downloadlib.nr.u.u(strU, jSONObject, pnVar, true);
            return true;
        }
        if (xVarU.getType() != 6) {
            return true;
        }
        mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVarU.u()));
        com.ss.android.downloadlib.b.u.u().nr("market_open_failed", jSONObject, pnVar);
        if (com.ss.android.downloadlib.addownload.a.u(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController nr() {
        return u(false);
    }
}
