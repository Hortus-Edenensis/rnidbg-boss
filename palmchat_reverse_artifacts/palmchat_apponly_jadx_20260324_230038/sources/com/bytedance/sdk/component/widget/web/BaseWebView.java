package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.mv.nr;
import com.bytedance.sdk.component.utils.jk;
import com.huawei.openalliance.ad.constant.bq;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BaseWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Boolean f5184a;
    protected DownloadListener b;
    protected Boolean bg;
    protected Boolean bq;
    protected Boolean c;
    protected Boolean d;
    protected Boolean dw;
    protected WebChromeClient fx;
    protected Boolean gi;
    protected nr.u h;
    protected View.OnScrollChangeListener iz;
    protected Boolean jk;
    protected Integer k;
    protected Integer kj;
    protected Boolean l;
    protected Boolean mv;
    protected String my;
    protected Boolean n;
    protected com.bytedance.sdk.component.widget.nr nr;
    protected Boolean o;
    protected Integer pn;
    protected Boolean q;
    protected Boolean qq;
    protected Integer s;
    protected WebSettings.LayoutAlgorithm sx;
    protected Boolean t;
    protected Map<String, u> u;
    protected Boolean x;
    protected Boolean z;

    public BaseWebView(Context context) {
        super(context);
        this.iz = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        nr();
        super.destroy();
    }

    public Boolean getAllowFileAccess() {
        return this.l;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.jk;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.f5184a;
    }

    public Boolean getAppCacheEnabled() {
        return this.qq;
    }

    public Integer getBackgroundColor() {
        return this.pn;
    }

    public Boolean getBlockNetworkImage() {
        return this.t;
    }

    public Boolean getBuiltInZoomControls() {
        return this.bg;
    }

    public Integer getCacheMode() {
        return this.kj;
    }

    public WebChromeClient getChromeClient() {
        return this.fx;
    }

    public com.bytedance.sdk.component.widget.nr getClient() {
        return this.nr;
    }

    public Boolean getDatabaseEnabled() {
        return this.mv;
    }

    public Integer getDefaultFontSize() {
        return this.k;
    }

    public String getDefaultTextEncodingName() {
        return this.my;
    }

    public Boolean getDisplayZoomControls() {
        return this.z;
    }

    public Boolean getDomStorageEnabled() {
        return this.bq;
    }

    public DownloadListener getDownloadListener() {
        return this.b;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.dw;
    }

    public Boolean getJavaScriptEnabled() {
        return this.gi;
    }

    public Map<String, u> getJavascriptInterfaces() {
        return this.u;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.sx;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.o;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.x;
    }

    public Integer getMixedContentMode() {
        return this.s;
    }

    public Boolean getNetworkAvailable() {
        return this.d;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.iz;
    }

    public nr.u getOnTouchEventListener() {
        return this.h;
    }

    public Boolean getSavePassword() {
        return this.n;
    }

    public Boolean getSupportZoom() {
        return this.c;
    }

    public Boolean getUseWideViewPort() {
        return this.q;
    }

    public void nr() {
        this.u = null;
        this.nr = null;
        this.fx = null;
        this.b = null;
        this.iz = null;
        this.pn = null;
        this.x = null;
        this.n = null;
        this.f5184a = null;
        this.jk = null;
        this.t = null;
        this.l = null;
        this.mv = null;
        this.s = null;
        this.k = null;
        this.my = null;
        this.o = null;
        this.sx = null;
        this.bg = null;
        this.bq = null;
        this.dw = null;
        this.c = null;
        this.q = null;
        this.qq = null;
        this.kj = null;
        this.z = null;
        this.gi = null;
        this.d = null;
        this.h = null;
    }

    public void u(Runnable runnable) {
        if (u()) {
            runnable.run();
        } else {
            jk.nr().post(runnable);
        }
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iz = null;
    }

    public boolean u() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iz = null;
    }

    public void u(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", bq.f.L);
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            u(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    private void u(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }

    public void nr(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "event");
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            u(str, jSONObject2);
        } catch (Throwable unused) {
        }
    }
}
