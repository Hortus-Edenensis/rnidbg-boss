package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.b;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.x.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f10586a;
    private TextView b;
    private TextView fx;
    private TextView iz;
    private final long jk;
    private final com.ss.android.downloadlib.addownload.nr.nr l;
    private LinearLayout n;
    private TextView nr;
    private TextView pn;
    private long t;
    private TextView u;
    private ClipImageView x;

    public u(@NonNull Activity activity, long j) {
        super(activity);
        this.f10586a = activity;
        this.jk = j;
        this.l = fx.u().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.fx.u(this.f10586a);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.l == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.t = this.l.nr;
        u();
        x.nr("lp_app_dialog_show", this.t);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.u.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                x.u("lp_app_dialog_cancel", u.this.t);
            }
        });
    }

    private void u() {
        this.u = (TextView) findViewById(R.id.tv_app_name);
        this.nr = (TextView) findViewById(R.id.tv_app_version);
        this.fx = (TextView) findViewById(R.id.tv_app_developer);
        this.b = (TextView) findViewById(R.id.tv_app_detail);
        this.pn = (TextView) findViewById(R.id.tv_app_privacy);
        this.iz = (TextView) findViewById(R.id.tv_give_up);
        this.x = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.n = (LinearLayout) findViewById(R.id.ll_download);
        this.u.setText(mv.u(this.l.pn, HttpClient.ENDFLAG));
        this.nr.setText("版本号：" + mv.u(this.l.iz, HttpClient.ENDFLAG));
        this.fx.setText("开发者：" + mv.u(this.l.x, "应用信息正在完善中"));
        this.x.setRoundRadius(mv.u(l.getContext(), 8.0f));
        this.x.setBackgroundColor(Color.parseColor("#EBEBEB"));
        b.u().u(this.jk, new b.u() { // from class: com.ss.android.downloadlib.addownload.compliance.u.2
            @Override // com.ss.android.downloadlib.addownload.compliance.b.u
            public void u(Bitmap bitmap) {
                if (bitmap != null) {
                    u.this.x.setImageBitmap(bitmap);
                } else {
                    x.u(8, u.this.t);
                }
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.u.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.u().u(u.this.f10586a);
                AppDetailInfoActivity.u(u.this.f10586a, u.this.jk);
                x.u("lp_app_dialog_click_detail", u.this.t);
            }
        });
        this.pn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.u.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nr.u().u(u.this.f10586a);
                AppPrivacyPolicyActivity.u(u.this.f10586a, u.this.jk);
                x.u("lp_app_dialog_click_privacy", u.this.t);
            }
        });
        this.iz.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.u.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                u.this.dismiss();
                x.u("lp_app_dialog_click_giveup", u.this.t);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.u.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                x.u("lp_app_dialog_click_download", u.this.t);
                nr.u().nr(u.this.t);
                u.this.dismiss();
            }
        });
    }
}
