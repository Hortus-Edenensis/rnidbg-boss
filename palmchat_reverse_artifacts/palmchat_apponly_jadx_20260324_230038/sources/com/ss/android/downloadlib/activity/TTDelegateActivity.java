package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.download.api.config.dw;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.nr;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.u.nr;
import com.ss.android.downloadlib.addownload.b.fx;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.iz;
import com.ss.android.downloadlib.addownload.u.pn;
import com.ss.android.downloadlib.guide.install.u;
import com.ss.android.downloadlib.jk;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.downloadlib.x.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TTDelegateActivity extends Activity {
    private static u b;
    private nr fx;
    private boolean nr;
    protected Intent u = null;

    private static Intent fx(@NonNull com.ss.android.downloadad.api.u.u uVar) {
        return new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void nr(String str, com.ss.android.downloadad.api.u.u uVar) {
        Intent intentFx = fx(uVar);
        intentFx.addFlags(268435456);
        intentFx.putExtra("type", 11);
        intentFx.putExtra("package_name", str);
        if (l.getContext() != null) {
            l.getContext().startActivity(intentFx);
        }
    }

    public static void u(String str, String[] strArr) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        nr();
        this.u = getIntent();
        l.nr(this);
        u();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.u = intent;
        l.nr(this);
        u();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        l.pn().u(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onStop() {
        nr nrVar;
        super.onStop();
        if (!this.nr || (nrVar = this.fx) == null) {
            return;
        }
        DownloadInfo downloadInfoU = !TextUtils.isEmpty(nrVar.f()) ? jk.u(l.getContext()).u(this.fx.f(), null, true) : jk.u(l.getContext()).nr(this.fx.u());
        if (downloadInfoU == null || downloadInfoU.getCurBytes() < downloadInfoU.getTotalBytes() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fx() {
        nr nrVar;
        int iU;
        int i;
        int i2;
        String str;
        long longExtra = this.u.getLongExtra("model_id", 0L);
        String stringExtra = this.u.getStringExtra("message_text");
        String stringExtra2 = this.u.getStringExtra("positive_button_text");
        String stringExtra3 = this.u.getStringExtra("negative_button_text");
        String stringExtra4 = this.u.getStringExtra("delete_button_text");
        int intExtra = this.u.getIntExtra("type", 0);
        nr nrVarB = iz.u().b(longExtra);
        if (nrVarB == null) {
            nrVar = nrVarB;
            iU = -1;
            i = 0;
            i2 = 0;
        } else {
            DownloadInfo downloadInfoU = !TextUtils.isEmpty(nrVarB.f()) ? jk.u(l.getContext()).u(nrVarB.f(), null, true) : jk.u(l.getContext()).nr(nrVarB.u());
            if (downloadInfoU != null) {
                long curBytes = downloadInfoU.getCurBytes();
                long totalBytes = downloadInfoU.getTotalBytes();
                if (curBytes > 0 && totalBytes > 0) {
                    nrVar = nrVarB;
                    i2 = (int) (curBytes / 1048576);
                    i = (int) (totalBytes / 1048576);
                    iU = com.ss.android.downloadlib.addownload.jk.u(downloadInfoU.getId(), (int) ((curBytes * 100) / totalBytes));
                }
            }
        }
        pn.u uVarFx = new pn.u(this).u(false).u(stringExtra).nr(stringExtra2).fx(stringExtra3);
        if (intExtra == 7) {
            if (com.ss.android.downloadlib.addownload.b.iz.u() == null) {
                return;
            }
            uVarFx.u(com.ss.android.downloadlib.addownload.b.iz.u());
            uVarFx.u().show();
            str = "download_percent";
        } else if (intExtra == 8) {
            if (com.ss.android.downloadlib.addownload.b.u.u() == null) {
                return;
            }
            uVarFx.u(com.ss.android.downloadlib.addownload.b.u.u());
            uVarFx.u().show();
            str = "apk_size";
        } else if (intExtra == 20) {
            if (fx.u() == null || fx.nr() == null) {
                return;
            }
            uVarFx.u(fx.u()).b(stringExtra4).u(fx.nr());
            uVarFx.u().show();
            str = "download_percent_cancel";
        } else if (intExtra != 21) {
            str = "";
        } else {
            if (com.ss.android.downloadlib.addownload.b.nr.u() == null || com.ss.android.downloadlib.addownload.b.nr.nr() == null) {
                return;
            }
            uVarFx.u(com.ss.android.downloadlib.addownload.b.nr.u()).b(stringExtra4).u(com.ss.android.downloadlib.addownload.b.nr.nr());
            uVarFx.u().show();
            str = "apk_size_cancel";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.nr = true;
        nr nrVar2 = nrVar;
        this.fx = nrVar2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", "show_dialog");
            jSONObject.putOpt("download_percent", Integer.valueOf(iU));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i));
        } catch (JSONException unused) {
        }
        if (TextUtils.equals(str, "download_percent") || TextUtils.equals(str, "apk_size")) {
            com.ss.android.downloadlib.b.u.u().u("pause_optimise", jSONObject, nrVar2);
        } else if (TextUtils.equals(str, "download_percent_cancel") || TextUtils.equals(str, "apk_size_cancel")) {
            com.ss.android.downloadlib.b.u.u().u("pause_cancel_optimise", jSONObject, nrVar2);
        }
    }

    public static void nr(String str, long j, String str2) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    public static void u(String str, com.ss.android.downloadad.api.u.u uVar) {
        Intent intentFx = fx(uVar);
        intentFx.addFlags(268435456);
        intentFx.putExtra("type", 2);
        intentFx.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        if (l.getContext() != null) {
            l.getContext().startActivity(intentFx);
        }
    }

    public static void u(com.ss.android.downloadad.api.u.u uVar) {
        Intent intentFx = fx(uVar);
        intentFx.addFlags(268435456);
        intentFx.putExtra("type", 4);
        intentFx.putExtra("model_id", uVar.nr());
        if (l.getContext() != null) {
            l.getContext().startActivity(intentFx);
        }
    }

    public static void nr(@NonNull com.ss.android.downloadad.api.u.u uVar) {
        u(uVar, 5, "", "", "", "");
    }

    public static void nr(@NonNull com.ss.android.downloadad.api.u.u uVar, String str, String str2, String str3) {
        u(uVar, 7, str, str2, str3, "");
    }

    public static void nr(@NonNull com.ss.android.downloadad.api.u.u uVar, String str, String str2, String str3, String str4) {
        u(uVar, 20, str, str2, str3, str4);
    }

    private void nr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void u(com.ss.android.downloadad.api.u.u uVar, u uVar2) {
        Intent intentFx = fx(uVar);
        intentFx.addFlags(268435456);
        intentFx.putExtra("type", 9);
        b = uVar2;
        if (l.getContext() != null) {
            l.getContext().startActivity(intentFx);
        }
    }

    private void nr(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            dw dwVar = new dw() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
                private WeakReference<Activity> fx;

                {
                    this.fx = new WeakReference<>(TTDelegateActivity.this);
                }

                @Override // com.ss.android.download.api.config.dw
                public void u() {
                    com.ss.android.downloadlib.x.jk.u(str);
                    com.ss.android.socialbase.appdownloader.fx.u(this.fx.get());
                }

                @Override // com.ss.android.download.api.config.dw
                public void u(String str2) {
                    com.ss.android.downloadlib.x.jk.u(str, str2);
                    com.ss.android.socialbase.appdownloader.fx.u(this.fx.get());
                }
            };
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    l.pn().u(this, strArr, dwVar);
                    return;
                } catch (Exception e) {
                    l.bq().u(e, "requestPermission");
                }
            }
            dwVar.u();
            return;
        }
        com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
    }

    public static void u(long j) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    private void nr(String str) {
        Intent intentX = mv.x(this, str);
        if (intentX == null) {
            return;
        }
        try {
            intentX.addFlags(268435456);
            intentX.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intentX);
        } catch (Exception unused) {
        } finally {
            com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
        }
    }

    public static void u(String str, long j, String str2, @NonNull JSONObject jSONObject) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    private void nr(long j) {
        final nr nrVarB = iz.u().b(j);
        if (nrVarB == null) {
            com.ss.android.downloadlib.pn.fx.u().u("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
            return;
        }
        com.ss.android.download.api.config.mv mvVarFx = l.fx();
        nr.u uVarU = new nr.u(this).u("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(nrVarB.xw()) ? "刚刚下载的应用" : nrVarB.xw();
        mvVarFx.nr(uVarU.nr(String.format("%1$s已安装完成，是否立即打开？", objArr)).fx("打开").b("取消").u(false).u(mv.b(this, nrVarB.pn())).u(new nr.InterfaceC0840nr() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void fx(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.fx.u((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void nr(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.b.u.u().nr("market_openapp_cancel", nrVarB);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.fx.u((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.download.api.model.nr.InterfaceC0840nr
            public void u(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.nr.u.nr(nrVarB);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.fx.u((Activity) TTDelegateActivity.this);
            }
        }).u(2).u());
        com.ss.android.downloadlib.b.u.u().nr("market_openapp_window_show", nrVarB);
    }

    public static void u(String str, long j, String str2) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        intent.putExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT, str2);
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    public static void u(String str, long j) {
        Intent intent = new Intent(l.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (l.getContext() != null) {
            l.getContext().startActivity(intent);
        }
    }

    private void fx(long j) {
        new com.ss.android.downloadlib.addownload.compliance.u(this, j).show();
    }

    public static void u(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 16);
        intent.putExtra("package_name", str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static void u(@NonNull com.ss.android.downloadad.api.u.u uVar, String str) {
        u(uVar, 19, "", "", "", str);
    }

    public static void u(@NonNull com.ss.android.downloadad.api.u.u uVar, String str, String str2, String str3) {
        u(uVar, 8, str, str2, str3, "");
    }

    public static void u(@NonNull com.ss.android.downloadad.api.u.u uVar, String str, String str2, String str3, String str4) {
        u(uVar, 21, str, str2, str3, str4);
    }

    private static void u(@NonNull com.ss.android.downloadad.api.u.u uVar, int i, String str, String str2, String str3, String str4) {
        Intent intentFx = fx(uVar);
        intentFx.addFlags(268435456);
        intentFx.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentFx.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentFx.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentFx.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentFx.putExtra("message_text", str);
        }
        intentFx.putExtra("model_id", uVar.nr());
        if (l.getContext() != null) {
            l.getContext().startActivity(intentFx);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void u() {
        Intent intent = this.u;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    nr(this.u.getStringExtra("permission_id_key"), this.u.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    u(this.u.getStringExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 4:
                    nr(this.u.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    u(this.u.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    fx();
                    break;
                case 9:
                    u uVar = b;
                    if (uVar != null) {
                        uVar.u();
                    }
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 10:
                    fx(this.u.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    nr(this.u.getStringExtra("package_name"));
                    break;
                case 12:
                    n.u(this, this.u.getStringExtra("package_name"), this.u.getLongExtra("model_id", 0L), this.u.getStringExtra(RemoteMessageConst.MessageBody.PARAM), this.u.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 13:
                    n.u(this, this.u.getStringExtra("package_name"), this.u.getLongExtra("model_id", 0L), this.u.getStringExtra(BaseConstants.VIVO_MARKET_NEED_COMMENT));
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 14:
                    n.nr(this, this.u.getStringExtra("package_name"), this.u.getLongExtra("model_id", 0L), this.u.getStringExtra("market_app_id"));
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 15:
                    n.u(this, this.u.getStringExtra("package_name"), this.u.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 16:
                    n.nr(this, this.u.getStringExtra("package_name"), this.u.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
                    break;
                case 19:
                    u(this.u.getLongExtra("model_id", 0L), this.u.getStringExtra("delete_button_text"));
                    break;
            }
            this.u = null;
        }
    }

    private void u(long j, String str) {
        if (k.u() == null) {
            return;
        }
        com.ss.android.downloadad.api.u.nr nrVarB = iz.u().b(j);
        if (nrVarB != null) {
            DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVarB.bg());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - nrVarB.su()));
                jSONObject.putOpt("click_download_size", Long.valueOf(nrVarB.mh()));
                if (downloadInfo != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                    jSONObject.putOpt("download_percent", Long.valueOf(downloadInfo.getCurBytes() / downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (downloadInfo.getCurBytes() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (downloadInfo.getTotalBytes() / 1048576)));
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.b.u.u().u("cancel_pause_reserve_wifi_dialog_show", jSONObject, nrVarB);
            } else {
                com.ss.android.downloadlib.b.u.u().nr("pause_reserve_wifi_dialog_show", jSONObject, nrVarB);
            }
        }
        pn.u uVarU = new pn.u(this).u(false).u(k.u());
        if (!TextUtils.isEmpty(str)) {
            uVarU.b(str).u(k.nr());
        }
        uVarU.u().show();
        this.nr = true;
        this.fx = nrVarB;
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            startActivity(intent);
        } catch (Exception unused) {
        } finally {
            com.ss.android.socialbase.appdownloader.fx.u((Activity) this);
        }
    }
}
