package com.zenmen.palmchat.circle.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.circle.bean.CircleSharePosterBean;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.bq6;
import defpackage.c70;
import defpackage.fc0;
import defpackage.gr2;
import defpackage.il5;
import defpackage.j70;
import defpackage.pu1;
import defpackage.sy5;
import defpackage.wi0;
import defpackage.wm3;
import defpackage.xt;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleSharePosterActivity extends BaseActionBarActivity {
    public String q;
    public ConstraintLayout r;
    public EffectiveShapeView s;
    public TextView t;
    public EffectiveShapeView u;
    public TextView v;
    public ImageView w;
    public TextView x;
    public TextView y;
    public ImageView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivityPermissionDispatcher.b(CircleSharePosterActivity.this, BaseActivityPermissionDispatcher.PermissionType.WRITE_SDCARD, BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_SAVE_IMAGE);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse<CircleSharePosterBean>> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleSharePosterBean> baseResponse) {
            CircleSharePosterActivity.this.hideBaseProgressBar();
            if (baseResponse == null) {
                return;
            }
            if (baseResponse.getResultCode() == 0) {
                CircleSharePosterActivity.this.K1(baseResponse.getData());
            } else {
                Toast.makeText(CircleSharePosterActivity.this, baseResponse.getErrorMsg(), 0).show();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<Bitmap, Void, String> {
        public c() {
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Bitmap... bitmapArr) {
            return xt.x(bitmapArr[0], System.currentTimeMillis() + "");
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (CircleSharePosterActivity.this.isFinishing()) {
                return;
            }
            wm3.a(str);
            CircleSharePosterActivity circleSharePosterActivity = CircleSharePosterActivity.this;
            sy5.f(circleSharePosterActivity, circleSharePosterActivity.getResources().getString(R.string.save_to_dir, pu1.m()), 1).g();
            CircleSharePosterActivity.this.J1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I1(View view) {
        finish();
    }

    public final void D1(Bitmap bitmap) {
        if (bitmap != null) {
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, bitmap);
        }
    }

    public final boolean E1() {
        String stringExtra = getIntent().getStringExtra(j70.f18338a);
        this.q = stringExtra;
        return il5.l(stringExtra);
    }

    public final void F1() {
        showBaseProgressBar(AppContext.getContext().getString(R.string.progress_sending), false);
        c70.R().G(this.q, new b());
    }

    public final void G1() {
        this.x.setOnClickListener(new a());
    }

    public final void H1() {
        this.r = (ConstraintLayout) findViewById(R.id.circle_share_poster_root);
        this.s = (EffectiveShapeView) findViewById(R.id.circle_share_poster_avatar);
        this.t = (TextView) findViewById(R.id.circle_share_poster_title);
        this.u = (EffectiveShapeView) findViewById(R.id.circle_share_poster_cover);
        this.v = (TextView) findViewById(R.id.circle_share_poster_name);
        this.w = (ImageView) findViewById(R.id.circle_share_poster_qr_code);
        this.x = (TextView) findViewById(R.id.circle_share_poster_save);
        this.y = (TextView) findViewById(R.id.circle_share_poster_inner_desc);
        ImageView imageView = (ImageView) findViewById(R.id.image_back);
        this.z = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ec0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17266a.I1(view);
            }
        });
    }

    public final void J1() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("weixin://")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void K1(CircleSharePosterBean circleSharePosterBean) {
        String shareUrl;
        if (circleSharePosterBean == null) {
            return;
        }
        gr2.j().h(circleSharePosterBean.getHeadIconUrl(), this.s, bq6.s());
        gr2.j().h(circleSharePosterBean.getHeadImgUrl(), this.u, bq6.s());
        this.t.setText(circleSharePosterBean.getNickname() + "邀请你加入群聊");
        this.v.setText(circleSharePosterBean.getName());
        if (!TextUtils.isEmpty(circleSharePosterBean.getCopy())) {
            this.y.setText(circleSharePosterBean.getCopy());
        }
        if (TextUtils.isEmpty(circleSharePosterBean.getShareUrl())) {
            return;
        }
        try {
            URL url = new URL(circleSharePosterBean.getShareUrl());
            Uri uri = Uri.parse(circleSharePosterBean.getShareUrl());
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            StringBuilder sb = new StringBuilder();
            for (String str : queryParameterNames) {
                sb.append(str);
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(uri.getQueryParameter(str), "UTF-8"));
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            shareUrl = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), sb.toString(), url.getRef()).toURL().toString();
        } catch (Exception e) {
            e.printStackTrace();
            shareUrl = circleSharePosterBean.getShareUrl();
        }
        new fc0(this.w, shareUrl).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_circle_share_poster);
        if (E1()) {
            finish();
            return;
        }
        H1();
        G1();
        F1();
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void onPermissionGrant(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        super.onPermissionGrant(permissionType, permissionUsage, z);
        if (permissionUsage == BaseActivityPermissionDispatcher.PermissionUsage.CIRCLE_SELECT_SAVE_IMAGE) {
            this.z.setVisibility(4);
            this.r.setDrawingCacheEnabled(true);
            Bitmap drawingCache = this.r.getDrawingCache();
            this.z.setVisibility(0);
            if (drawingCache != null) {
                D1(drawingCache);
            }
        }
    }
}
