package defpackage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.zenmen.palmchat.activity.webview2.WebView;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.IceCreamCordovaWebViewClient;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0010\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lrj6;", "Lorg/apache/cordova/IceCreamCordovaWebViewClient;", "Landroid/webkit/WebView;", "Lcom/zenmen/palmchat/activity/webview2/SdkWebView;", "view", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "", "onReceivedSslError", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "a", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "getWebview", "()Lcom/zenmen/palmchat/activity/webview2/WebView;", "webview", "Lorg/apache/cordova/CordovaInterface;", "iface", "<init>", "(Lorg/apache/cordova/CordovaInterface;Lcom/zenmen/palmchat/activity/webview2/WebView;)V", "app_release"}, k = 1, mv = {1, 8, 0})
public class rj6 extends IceCreamCordovaWebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final WebView webview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rj6(CordovaInterface iface, WebView webview) {
        super(iface, webview);
        Intrinsics.checkNotNullParameter(iface, "iface");
        Intrinsics.checkNotNullParameter(webview, "webview");
        this.webview = webview;
    }

    @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageFinished(view, url);
        LogUtil.i(a96.b(), "onPageFinished url:" + url);
        WebView webView = this.webview;
        webView.loadedUrl = url;
        webView.get_videoListener().b(url);
        this.webview.get_iconGetter().b(view);
        nc6 nc6Var = this.webview.get_videoListener();
        WebView webView2 = this.webview;
        nc6Var.c(webView2, webView2.getCompModel());
    }

    @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageStarted(view, url, favicon);
        LogUtil.i(a96.b(), "onPageStarted url:" + url);
        WebView webView = this.webview;
        webView.loadedUrl = url;
        webView.get_videoListener().b(url);
        this.webview.get_videoListener().a();
    }

    @Override // org.apache.cordova.CordovaWebViewClient, android.webkit.WebViewClient
    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        handler.cancel();
        LogUtil.i(a96.b(), 3, (HashMap<String, Object>) MapsKt__MapsKt.hashMapOf(TuplesKt.to("action", "load_https"), TuplesKt.to("error", error.toString())), (Throwable) null);
    }
}
