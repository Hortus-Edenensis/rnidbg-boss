package com.zenmen.palmchat.utils.captcha;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.captcha.CaptchaManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.ir5;
import defpackage.me1;
import defpackage.mz;
import defpackage.u93;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15738a;
    public final Window b;
    public Animation c;
    public ImageView d;
    public View e;
    public View f;
    public Activity g;
    public WebView h;
    public boolean i;
    public CaptchaManager.a j;
    public mz k;
    public long l;

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.captcha.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1123a implements View.OnClickListener {
        public ViewOnClickListenerC1123a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.m();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.i || a.this.g.isFinishing()) {
                return;
            }
            CaptchaManager.b(1, WkAdConfigModel.TAG_TIMEOUT, a.this.k);
            a.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.h != null) {
                    a.this.h.destroy();
                }
            } catch (Exception e) {
                LogUtil.i("CaptchaDialog", "destroy", e);
            }
            a.this.h = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.q();
        }
    }

    public a(@NonNull Activity activity, mz mzVar, CaptchaManager.a aVar) {
        super(activity, R.style.custom_progress_dialog);
        this.f15738a = 1.5f;
        this.l = 0L;
        this.b = getWindow();
        this.g = activity;
        this.j = aVar;
        this.k = mzVar;
        i(activity);
    }

    public void i(Context context) {
        getWindow().setAttributes(this.b.getAttributes());
        if (this.k.d) {
            this.b.setContentView(R.layout.dialog_sm_captcha_new);
        } else {
            this.b.setContentView(R.layout.dialog_sm_captcha);
        }
        this.b.setLayout(-1, -1);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.d = (ImageView) this.b.findViewById(R.id.progress_img);
        this.e = this.b.findViewById(R.id.retryView);
        ((TextView) this.b.findViewById(R.id.retryTv)).setText(Html.fromHtml(context.getResources().getString(R.string.captcha_error_text)));
        this.e.setOnClickListener(new ViewOnClickListenerC1123a());
        this.c = AnimationUtils.loadAnimation(context, R.anim.custom_progress_dialog_rotate);
        me1.k(this.b, com.zenmen.palmchat.c.a().getStatusBarColor());
        View viewFindViewById = this.b.findViewById(R.id.contentLayout);
        this.f = viewFindViewById;
        if (!this.k.d) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = me1.g();
            layoutParams.height = ((int) (me1.g() / this.f15738a)) + me1.b(context, 2);
            this.f.setLayoutParams(layoutParams);
        }
        setCancelable(false);
        l();
        m();
        this.l = ir5.b();
    }

    public final void j(CaptchaResult captchaResult) {
        LogUtil.i("CaptchaDialog", "dismissCaptchaDialog " + az2.c(captchaResult));
        try {
            this.j.a(0, captchaResult);
            dismiss();
            u93.c(new c());
        } catch (Exception e) {
            LogUtil.i("CaptchaDialog", "dismissCaptchaDialog", e);
        }
    }

    public final String k(String str) {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        AssetManager assets = AppContext.getContext().getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            inputStreamOpen = assets.open(str);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            sb.append("\n");
            return sb.toString().replace("xxxxxxxxxxxxxxxxxxxx", this.k.a());
        }
        inputStreamOpen.close();
        return sb.toString().replace("xxxxxxxxxxxxxxxxxxxx", this.k.a());
    }

    public final void l() {
        this.d.setVisibility(0);
        this.d.startAnimation(this.c);
        this.e.setVisibility(8);
        WebView webView = (WebView) this.b.findViewById(R.id.dialogWebView);
        this.h = webView;
        webView.setBackgroundColor(-1);
        WebSettings settings = this.h.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        this.h.addJavascriptInterface(new JsBridge(this), "jsBridge");
    }

    public final void m() {
        this.h.setVisibility(4);
        String strK = k("smcaptcha.html");
        if (TextUtils.isEmpty(strK)) {
            this.h.loadUrl("file:///android_asset/smcaptcha.html");
            mz mzVar = this.k;
            if (mzVar != null) {
                mzVar.b("slide");
            }
        } else {
            this.h.loadDataWithBaseURL("", strK, "text/html", "UTF-8", "");
        }
        this.d.startAnimation(this.c);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        u93.b(10000, new b());
    }

    public void n(String str) {
        if (this.i) {
            return;
        }
        r();
        CaptchaManager.b(2, str, this.k);
    }

    public void o(String str) {
        LogUtil.i("CaptchaDialog", "onGetData " + str);
        try {
            CaptchaBean captchaBean = (CaptchaBean) az2.a(str, CaptchaBean.class);
            if (captchaBean.pass) {
                j(new CaptchaResult(captchaBean.rid, this.k.a(), ir5.e(this.l)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            j(null);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.d.startAnimation(this.c);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.d.clearAnimation();
    }

    public void p() {
        this.i = true;
        u93.c(new d());
    }

    public final void q() {
        WebView webView = this.h;
        if (webView != null) {
            webView.setVisibility(0);
            this.d.clearAnimation();
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public final void r() {
        this.d.clearAnimation();
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.h.setVisibility(4);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
