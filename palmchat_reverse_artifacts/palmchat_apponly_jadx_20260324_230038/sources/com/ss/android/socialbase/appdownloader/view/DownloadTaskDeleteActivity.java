package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.fx.b;
import com.ss.android.socialbase.appdownloader.fx.l;
import com.ss.android.socialbase.appdownloader.fx.mv;
import com.ss.android.socialbase.appdownloader.fx.pn;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.fx;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private Intent nr;
    private l u;

    private void nr() {
        Intent intent;
        if (this.u != null || (intent = this.nr) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(getApplicationContext()).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                return;
            }
            String string = String.format(getString(a.u(this, "tt_appdownloader_notification_download_delete")), title);
            b bVarNr = com.ss.android.socialbase.appdownloader.b.t().nr();
            mv mvVarU = bVarNr != null ? bVarNr.u(this) : null;
            if (mvVarU == null) {
                mvVarU = new com.ss.android.socialbase.appdownloader.b.u(this);
            }
            int iU = a.u(this, "tt_appdownloader_tip");
            int iU2 = a.u(this, "tt_appdownloader_label_ok");
            int iU3 = a.u(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("cancel_with_net_opt", 0) == 1 && iz.n() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                iU2 = a.u(this, "tt_appdownloader_label_reserve_wifi");
                iU3 = a.u(this, "tt_appdownloader_label_cancel_directly");
                string = getResources().getString(a.u(this, "tt_appdownloader_resume_in_wifi"));
            }
            mvVarU.u(iU).u(string).u(iU2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    } else {
                        DownloadTaskDeleteActivity.this.u(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).nr(iU3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.u(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).u(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.u = mvVarU.u();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        u();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.nr = getIntent();
        nr();
        l lVar = this.u;
        if (lVar != null && !lVar.nr()) {
            this.u.u();
        } else if (this.u == null) {
            finish();
        }
    }

    private void u() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(DownloadInfo downloadInfo, int i) {
        pn pnVarFx = com.ss.android.socialbase.appdownloader.b.t().fx();
        if (pnVarFx != null) {
            pnVarFx.u(downloadInfo);
        }
        z downloadNotificationEventListener = Downloader.getInstance(fx.oa()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.u(10, downloadInfo, "", "");
        }
        if (fx.oa() != null) {
            Downloader.getInstance(fx.oa()).cancel(i);
        }
    }
}
