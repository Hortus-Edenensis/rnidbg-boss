package defpackage;

import com.zenmen.palmchat.activity.webview2.WebView;
import com.zenmen.palmchat.utils.log.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lv50;", "Lorg/apache/cordova/CordovaChromeClient;", "Landroid/webkit/WebView;", "Lcom/zenmen/palmchat/activity/webview2/SdkWebView;", "view", "", "newProgress", "", "onProgressChanged", "", "title", "onReceivedTitle", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "a", "Lcom/zenmen/palmchat/activity/webview2/WebView;", "getWebview", "()Lcom/zenmen/palmchat/activity/webview2/WebView;", "webview", "Lorg/apache/cordova/CordovaInterface;", "iface", "<init>", "(Lorg/apache/cordova/CordovaInterface;Lcom/zenmen/palmchat/activity/webview2/WebView;)V", "app_release"}, k = 1, mv = {1, 8, 0})
public class v50 extends CordovaChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final WebView webview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v50(CordovaInterface iface, WebView webview) {
        super(iface, webview);
        Intrinsics.checkNotNullParameter(iface, "iface");
        Intrinsics.checkNotNullParameter(webview, "webview");
        this.webview = webview;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView view, int newProgress) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onProgressChanged(view, newProgress);
        LogUtil.i(a96.b(), "onProgressChanged progress:" + newProgress);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView view, String title) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(title, "title");
        super.onReceivedTitle(view, title);
    }
}
