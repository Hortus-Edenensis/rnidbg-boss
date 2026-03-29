package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.ad.AdActivity;
import com.beizi.ad.DownloadService;
import com.beizi.ad.internal.c;
import com.beizi.ad.internal.download.b;
import com.beizi.ad.internal.e.h;
import com.beizi.ad.internal.e.k;
import com.beizi.ad.internal.e.u;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.j;
import com.beizi.ad.lance.a.o;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BeiZiDownloadDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f4358a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private ExpandableListView g;
    private LinearLayout h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private ApkBean l;
    private int m = -1;
    private int n = 1;
    private List<String> o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private int t;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.n == 2 && !TextUtils.isEmpty(this.p) && this.p.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            Class clsA = AdActivity.a();
            try {
                WebView webView = new WebView(this);
                u.a(webView);
                webView.loadUrl(this.p, j.a());
                a.f4370a.add(webView);
                Intent intent = new Intent(c.a().c(), (Class<?>) clsA);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.q);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", this.r);
                if (!TextUtils.isEmpty(this.s)) {
                    intent.putExtra("deeplinkUrl", this.s);
                    intent.putExtra("webDeepLink", this.t);
                }
                startActivity(intent);
            } catch (Exception unused) {
                a.f4370a.remove();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.beizi_download_dialog);
        setFinishOnTouchOutside(false);
        a();
        b();
        c();
    }

    private void a() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("apkBean")) {
                this.l = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            if (bundleExtra.containsKey("type")) {
                this.n = bundleExtra.getInt("type");
            }
            if (bundleExtra.containsKey("openList")) {
                this.o = bundleExtra.getStringArrayList("openList");
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.p = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("isCanJump")) {
                this.q = bundleExtra.getBoolean("isCanJump", false);
            }
            if (bundleExtra.containsKey("isDownload")) {
                this.r = bundleExtra.getBoolean("isDownload", false);
            }
            if (bundleExtra.containsKey("deeplinkUrl")) {
                this.s = bundleExtra.getString("deeplinkUrl");
            }
            if (bundleExtra.containsKey("webDeepLink")) {
                this.t = bundleExtra.getInt("webDeepLink");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        try {
            this.f4358a = (FrameLayout) findViewById(R.id.beizi_download_dialog_container_fl);
            this.e = (ImageView) findViewById(R.id.beizi_download_dialog_close_iv);
            this.f = (ImageView) findViewById(R.id.beizi_download_dialog_icon_iv);
            this.b = (TextView) findViewById(R.id.beizi_download_dialog_name_tv);
            this.c = (TextView) findViewById(R.id.beizi_download_dialog_version_tv);
            this.d = (TextView) findViewById(R.id.beizi_download_dialog_developer_tv);
            this.g = (ExpandableListView) findViewById(R.id.beizi_download_dialog_expand_lv);
            this.h = (LinearLayout) findViewById(R.id.beizi_download_dialog_download_container_ll);
            this.i = (LinearLayout) findViewById(R.id.beizi_download_dialog_market_container_ll);
            this.j = (TextView) findViewById(R.id.beizi_download_dialog_market_cancel_tv);
            this.k = (TextView) findViewById(R.id.beizi_download_dialog_market_confirm_tv);
            this.g.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.1
                @Override // android.widget.ExpandableListView.OnGroupClickListener
                public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
                    try {
                        if (BeiZiDownloadDialogActivity.this.g.isGroupExpanded(i)) {
                            BeiZiDownloadDialogActivity.this.g.collapseGroup(i);
                        } else {
                            BeiZiDownloadDialogActivity.this.g.expandGroup(i);
                            if (i == 0) {
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(1);
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(2);
                            } else if (i == 1) {
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(0);
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(2);
                            } else if (i == 2) {
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(0);
                                BeiZiDownloadDialogActivity.this.g.collapseGroup(1);
                            }
                        }
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            if (this.l == null) {
                return;
            }
            if (this.n == 1) {
                this.e.setVisibility(0);
                this.e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.h.setVisibility(0);
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.d();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.i.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.d();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
            }
            if (this.f != null && !TextUtils.isEmpty(this.l.getAppIconURL())) {
                try {
                    h.a((Context) null).a(this.l.getAppIconURL(), new h.a() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.6
                        @Override // com.beizi.ad.internal.e.h.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.e.h.a
                        public void a(Bitmap bitmap) {
                            try {
                                BeiZiDownloadDialogActivity.this.f.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            if (this.b != null && !TextUtils.isEmpty(this.l.getApkTittleName())) {
                this.b.setText(this.l.getApkTittleName());
            }
            if (this.c != null && !TextUtils.isEmpty(this.l.getAppVersion())) {
                this.c.setText("版本号 ：" + this.l.getAppVersion());
            }
            if (this.d != null && !TextUtils.isEmpty(this.l.getAppDeveloper())) {
                this.d.setText("开发者 ：" + this.l.getAppDeveloper());
            }
            ArrayList arrayList = new ArrayList();
            b bVar = new b();
            bVar.a("应用权限");
            if (!TextUtils.isEmpty(this.l.getAppPermissionsUrl())) {
                bVar.c(this.l.getAppPermissionsUrl());
                bVar.b("h5");
            } else if (!TextUtils.isEmpty(this.l.getAppPermissionsDesc())) {
                bVar.c(this.l.getAppPermissionsDesc());
                bVar.b("text");
            }
            arrayList.add(bVar);
            b bVar2 = new b();
            bVar2.a("隐私协议");
            String appPrivacyUrl = this.l.getAppPrivacyUrl();
            if (!TextUtils.isEmpty(appPrivacyUrl)) {
                if (appPrivacyUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b("h5");
                } else {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b("text");
                }
            }
            arrayList.add(bVar2);
            b bVar3 = new b();
            bVar3.a("产品功能介绍");
            String appintro = this.l.getAppintro();
            if (!TextUtils.isEmpty(appintro)) {
                if (appintro.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    bVar3.c(appintro);
                    bVar3.b("h5");
                } else {
                    bVar3.c(appintro);
                    bVar3.b("text");
                }
            }
            arrayList.add(bVar3);
            this.g.setAdapter(new com.beizi.ad.internal.download.a(this, arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (this.l == null) {
                return;
            }
            if (this.n == 2) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.l.getApkUrl()));
                intent.setFlags(268435456);
                startActivity(intent);
                List<String> list = this.o;
                if (list != null) {
                    k.a(list);
                    return;
                }
                return;
            }
            if (!o.a(this)) {
                Log.d("lance", "startDownloadService:checkStoragePermission false");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", this.l);
            Intent intent2 = new Intent(this, (Class<?>) DownloadService.class);
            intent2.putExtra("data", bundle);
            startService(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
