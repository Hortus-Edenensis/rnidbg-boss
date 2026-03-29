package com.zenmen.palmchat.activity.webview2;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amap.api.col.p0002sl.hb;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.activity.webview2.b;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a96;
import defpackage.jq0;
import defpackage.qj6;
import defpackage.qp2;
import defpackage.rj6;
import defpackage.v50;
import defpackage.wn4;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.cordova.Config;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001^\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u0006\u0010u\u001a\u00020t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bv\u0010wJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0004J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001e\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J \u0010+\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00100R\u001b\u00107\u001a\u0002028DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020<8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010G\u001a\u00020B8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010L\u001a\u00020H8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bJ\u0010KR#\u0010P\u001a\n M*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00104\u001a\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010RR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010_R\"\u0010f\u001a\u00020a8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b?\u0010b\u001a\u0004\bX\u0010c\"\u0004\bd\u0010eR\"\u0010h\u001a\u00020a8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\n\u0010b\u001a\u0004\bQ\u0010c\"\u0004\bg\u0010eR(\u0010p\u001a\b\u0012\u0004\u0012\u00020j0i8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\b[\u0010m\"\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010r¨\u0006x"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/b;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "Lorg/apache/cordova/CordovaInterface;", "Lqp2;", "", bq.b.V, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "n", "onAttachedToWindow", "onDetachedFromWindow", t.l, "Lqj6;", "shareObject", "a", "Lorg/apache/cordova/CordovaPlugin;", com.heytap.mcssdk.constant.b.y, "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "requestCode", "startActivityForResult", "plugin", "setActivityResultCallback", "Landroid/app/Activity;", "getActivity", "", "id", "", "data", "onMessage", "Ljava/util/concurrent/ExecutorService;", "getThreadPool", "getLaunchUrl", "getAppId", "Landroid/view/View;", "v", "onClick", "errorCode", "description", "failingUrl", "p", RXScreenCaptureService.KEY_WIDTH, "Landroid/content/Intent;", "g", "()Landroid/content/Intent;", "Landroid/app/Activity;", "ownerActivity2", "Lorg/apache/cordova/CordovaPreferences;", "c", "Lkotlin/Lazy;", "l", "()Lorg/apache/cordova/CordovaPreferences;", "_preferences", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "_rootLayout", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "e", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "m", "()Lcom/zenmen/palmchat/activity/webview2/WebView;", "_webView", "Lrj6;", "f", "Lrj6;", "get_webViewClient", "()Lrj6;", "_webViewClient", "Lv50;", "Lv50;", "get_chromeClient", "()Lv50;", "_chromeClient", "kotlin.jvm.PlatformType", "h", "()Landroid/view/View;", "_errorView", "i", "Ljava/lang/String;", "get_launchUrl", "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "_launchUrl", hb.j, "_pageIndex", "", t.f7496a, "Z", "_detaching", "com/zenmen/palmchat/activity/webview2/b$d", "Lcom/zenmen/palmchat/activity/webview2/b$d;", "mActivityBroadCastReceiver", "Lorg/apache/cordova/Whitelist;", "Lorg/apache/cordova/Whitelist;", "()Lorg/apache/cordova/Whitelist;", "s", "(Lorg/apache/cordova/Whitelist;)V", "_internalWhitelist", t.k, "_externalWhitelist", "", "Lorg/apache/cordova/PluginEntry;", "o", "Ljava/util/List;", "()Ljava/util/List;", "u", "(Ljava/util/List;)V", "_pluginEntries", "Lwn4;", "Lwn4;", "mBaseProgressDialog", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/content/Intent;)V", "app_release"}, k = 1, mv = {1, 8, 0})
public class b extends Dialog implements View.OnClickListener, CordovaInterface, qp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Intent intent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Activity ownerActivity2;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Lazy _preferences;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final RelativeLayout _rootLayout;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final WebView _webView;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final rj6 _webViewClient;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final v50 _chromeClient;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final Lazy _errorView;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public String _launchUrl;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public String _pageIndex;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean _detaching;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final d mActivityBroadCastReceiver;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Whitelist _internalWhitelist;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Whitelist _externalWhitelist;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public List<? extends PluginEntry> _pluginEntries;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public wn4 mBaseProgressDialog;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", t.l, "()Landroid/view/View;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function0<View> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final View invoke() {
            View viewInflate = b.this.getLayoutInflater().inflate(R.layout.layout_error_page, (ViewGroup) null);
            b bVar = b.this;
            viewInflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewInflate.setClickable(true);
            viewInflate.setOnClickListener(bVar);
            return viewInflate;
        }
    }

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.webview2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lorg/apache/cordova/CordovaPreferences;", "kotlin.jvm.PlatformType", t.l, "()Lorg/apache/cordova/CordovaPreferences;"}, k = 3, mv = {1, 8, 0})
    public static final class C0966b extends Lambda implements Function0<CordovaPreferences> {
        public C0966b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CordovaPreferences invoke() {
            ConfigXmlParser configXmlParser = new ConfigXmlParser();
            configXmlParser.parse(b.this.ownerActivity2);
            CordovaPreferences preferences = configXmlParser.getPreferences();
            Intent intent = b.this.getIntent();
            preferences.setPreferencesBundle(intent != null ? intent.getExtras() : null);
            b bVar = b.this;
            Whitelist internalWhitelist = configXmlParser.getInternalWhitelist();
            Intrinsics.checkNotNullExpressionValue(internalWhitelist, "parser.internalWhitelist");
            bVar.s(internalWhitelist);
            b bVar2 = b.this;
            Whitelist externalWhitelist = configXmlParser.getExternalWhitelist();
            Intrinsics.checkNotNullExpressionValue(externalWhitelist, "parser.externalWhitelist");
            bVar2.r(externalWhitelist);
            b.this.t(configXmlParser.getLaunchUrl());
            b bVar3 = b.this;
            ArrayList<PluginEntry> pluginEntries = configXmlParser.getPluginEntries();
            Intrinsics.checkNotNullExpressionValue(pluginEntries, "parser.pluginEntries");
            bVar3.u(pluginEntries);
            Config.parser = configXmlParser;
            return preferences;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/zenmen/palmchat/activity/webview2/b$c", "Lrj6;", "Landroid/webkit/WebView;", "Lcom/zenmen/palmchat/activity/webview2/SdkWebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "", "onPageStarted", "onPageFinished", "app_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends rj6 {
        public c(WebView webView) {
            super(b.this, webView);
        }

        @Override // defpackage.rj6, org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            b.this.w();
        }

        @Override // defpackage.rj6, org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
            b.this.v();
            b.this.get_webView().setVisibility(0);
            b.this.h().setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/zenmen/palmchat/activity/webview2/b$d", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "onReceive", "app_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY)) {
                b.this.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, Intent intent) {
        super(context, R.style.BaseTheme);
        Intrinsics.checkNotNullParameter(context, "context");
        this.intent = intent;
        this.ownerActivity2 = (Activity) context;
        this._preferences = LazyKt__LazyJVMKt.lazy(new C0966b());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        relativeLayout.setGravity(17);
        this._rootLayout = relativeLayout;
        WebView webView = new WebView(context, this);
        if (l().getBoolean("DisallowOverscroll", false)) {
            webView.setOverScrollMode(2);
        }
        webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        webView.setBackgroundColor(0);
        this._webView = webView;
        this._webViewClient = new c(webView);
        this._chromeClient = new v50(this, webView);
        this._errorView = LazyKt__LazyJVMKt.lazy(new a());
        this.mActivityBroadCastReceiver = new d();
    }

    public static final void o(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._webView.reload();
        this$0.h().setOnClickListener(this$0);
    }

    public static final void q(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h().setVisibility(0);
        this$0._webView.setVisibility(8);
    }

    @Override // defpackage.qp2
    public void b() {
        if (this._detaching) {
            return;
        }
        dismiss();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    @Override // org.apache.cordova.CordovaInterface
    /* JADX INFO: renamed from: getActivity, reason: from getter */
    public Activity getOwnerActivity2() {
        return this.ownerActivity2;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getAppId() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public String getLaunchUrl() {
        return null;
    }

    @Override // org.apache.cordova.CordovaInterface
    public ExecutorService getThreadPool() {
        ExecutorService executorServiceA = WebView.INSTANCE.a();
        Intrinsics.checkNotNullExpressionValue(executorServiceA, "WebView.GetThreadPool()");
        return executorServiceA;
    }

    public final View h() {
        return (View) this._errorView.getValue();
    }

    public final Whitelist i() {
        Whitelist whitelist = this._externalWhitelist;
        if (whitelist != null) {
            return whitelist;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_externalWhitelist");
        return null;
    }

    public final Whitelist j() {
        Whitelist whitelist = this._internalWhitelist;
        if (whitelist != null) {
            return whitelist;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_internalWhitelist");
        return null;
    }

    public final List<PluginEntry> k() {
        List list = this._pluginEntries;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_pluginEntries");
        return null;
    }

    public final CordovaPreferences l() {
        Object value = this._preferences.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-_preferences>(...)");
        return (CordovaPreferences) value;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final WebView get_webView() {
        return this._webView;
    }

    public final void n(Bundle savedInstanceState) {
        Intent intent = this.intent;
        Bundle extras = intent != null ? intent.getExtras() : null;
        Intent intent2 = this.intent;
        Uri data = intent2 != null ? intent2.getData() : null;
        if (data != null) {
            LogUtil.uploadInfoImmediate("03", null, null, null);
            this._launchUrl = data.toString();
        } else if (extras != null) {
            try {
                this._launchUrl = extras.getString("web_url");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this._pageIndex = extras != null ? extras.getString("page_index", null) : null;
        String str = this._launchUrl;
        if (str != null) {
            this._webView.loadUrlIntoView(str, true);
        } else {
            LOG.d(a96.b(), "empty launch url");
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.mActivityBroadCastReceiver, new IntentFilter(FrameworkBaseActivity.INTENT_ACTION_FINISH_ACTIVITY));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (Intrinsics.areEqual(v, h())) {
            h().setOnClickListener(null);
            this._webView.loadUrl("javascript:document.getElementsByTagName(\"body\")[0].innerHTML = \"\"");
            this._webView.postDelayed(new Runnable() { // from class: wi6
                @Override // java.lang.Runnable
                public final void run() {
                    b.o(this.f21721a);
                }
            }, 300L);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LOG.i(a96.b(), "Apache Cordova native platform version 3.7.2 is starting");
        LOG.d(a96.b(), "CordovaActivity.onCreate()");
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.requestFeature(1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.alpha = 1.0f;
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1280);
        window.setFlags(1024, 1024);
        window.clearFlags(6);
        this._webView.init(this, this._webViewClient, this._chromeClient, k(), j(), i(), l());
        RelativeLayout relativeLayout = this._rootLayout;
        relativeLayout.addView(h());
        relativeLayout.addView(this._webView);
        setContentView(relativeLayout);
        n(savedInstanceState);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._detaching = true;
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.mActivityBroadCastReceiver);
        this._webView.stopLoading();
        this._webView.handleDestroy();
    }

    @Override // org.apache.cordova.CordovaInterface
    public Object onMessage(String id, Object data) {
        if (!Intrinsics.areEqual("onScrollChanged", id)) {
            LOG.d(a96.b(), "onMessage(" + id + "," + data + ")");
        }
        if (id == null) {
            return null;
        }
        int iHashCode = id.hashCode();
        if (iHashCode != -1488920312) {
            if (iHashCode == 3127582) {
                if (!id.equals(com.alipay.sdk.m.x.d.z)) {
                    return null;
                }
                b();
                return null;
            }
            if (iHashCode != 277236744 || !id.equals(Action.ACTION_CLOSE_WINDOW)) {
                return null;
            }
            jq0.b();
            return null;
        }
        if (!id.equals("onReceivedError")) {
            return null;
        }
        try {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject = (JSONObject) data;
            int i = jSONObject.getInt("errorCode");
            String string = jSONObject.getString("description");
            Intrinsics.checkNotNullExpressionValue(string, "d.getString(\"description\")");
            String string2 = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string2, "d.getString(\"url\")");
            p(i, string, string2);
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void p(int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        Activity ownerActivity2 = getOwnerActivity2();
        if (ownerActivity2 != null) {
            ownerActivity2.runOnUiThread(new Runnable() { // from class: xi6
                @Override // java.lang.Runnable
                public final void run() {
                    b.q(this.f21970a);
                }
            });
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_index", this._pageIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("16", "1", "2", jSONObject.toString());
    }

    public final void r(Whitelist whitelist) {
        Intrinsics.checkNotNullParameter(whitelist, "<set-?>");
        this._externalWhitelist = whitelist;
    }

    public final void s(Whitelist whitelist) {
        Intrinsics.checkNotNullParameter(whitelist, "<set-?>");
        this._internalWhitelist = whitelist;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    @Override // org.apache.cordova.CordovaInterface
    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Activity ownerActivity2 = getOwnerActivity2();
        if (ownerActivity2 != null) {
            ownerActivity2.startActivityForResult(intent, requestCode);
        }
        b();
    }

    public final void t(String str) {
        this._launchUrl = str;
    }

    public final void u(List<? extends PluginEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this._pluginEntries = list;
    }

    public final void v() {
        if (this.mBaseProgressDialog == null) {
            wn4 wn4Var = new wn4(getContext());
            wn4Var.setCancelable(false);
            wn4Var.b(wn4Var.getContext().getString(R.string.loading));
            this.mBaseProgressDialog = wn4Var;
        }
        wn4 wn4Var2 = this.mBaseProgressDialog;
        Intrinsics.checkNotNull(wn4Var2);
        wn4Var2.show();
    }

    public final void w() {
        wn4 wn4Var = this.mBaseProgressDialog;
        if (wn4Var != null) {
            try {
                Intrinsics.checkNotNull(wn4Var);
                wn4Var.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.qp2
    public void a(qj6 shareObject) {
    }

    @Override // org.apache.cordova.CordovaInterface
    public void setActivityResultCallback(CordovaPlugin plugin) {
    }
}
