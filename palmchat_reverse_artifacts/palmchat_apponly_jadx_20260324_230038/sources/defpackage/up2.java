package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alipay.sdk.m.x.d;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0006¢\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R4\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00050\u00168\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lup2;", "", "", "pageSource", "pageUrl", "", "getIcon", "checkBodySource", "Lqj6;", "a", "Landroid/webkit/WebView;", "Lcom/zenmen/palmchat/activity/webview2/SdkWebView;", "webview", t.l, "Lem2;", "Lem2;", "iface", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnExit", "()Lkotlin/jvm/functions/Function0;", d.r, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shareObject", "c", "Lkotlin/jvm/functions/Function1;", "getOnFound", "()Lkotlin/jvm/functions/Function1;", "onFound", "<init>", "(Lem2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "app_release"}, k = 1, mv = {1, 8, 0})
public final class up2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final em2 iface;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Function0<Unit> onExit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function1<qj6, Unit> onFound;

    /* JADX WARN: Multi-variable type inference failed */
    public up2(em2 iface, Function0<Unit> onExit, Function1<? super qj6, Unit> onFound) {
        Intrinsics.checkNotNullParameter(iface, "iface");
        Intrinsics.checkNotNullParameter(onExit, "onExit");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        this.iface = iface;
        this.onExit = onExit;
        this.onFound = onFound;
    }

    public final qj6 a(String pageSource, String pageUrl) {
        qj6 qj6Var = new qj6();
        synchronized (qj6.class) {
            if (this.iface.getMWebShareObject() == null) {
                String strE = tp2.e(pageSource, pageUrl);
                String strJ = tp2.j(pageSource, pageUrl);
                if (strE != null && strJ != null) {
                    qj6Var.a(strE);
                    qj6Var.b(strJ);
                    this.iface.setMWebShareObject(qj6Var);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return this.iface.getMWebShareObject();
    }

    public final qj6 b(WebView webview) {
        Intrinsics.checkNotNullParameter(webview, "webview");
        if (this.iface.getMWebShareObject() != null) {
            return this.iface.getMWebShareObject();
        }
        webview.loadUrl(StringsKt__IndentKt.trimIndent("\n                    javascript:window.IconGetter.getIcon(document.getElementsByTagName(\"head\")[0].innerHTML, \"" + webview.getUrl() + "\")\n                    "));
        return null;
    }

    @JavascriptInterface
    public final void checkBodySource(String pageSource) {
        if (TextUtils.isEmpty(pageSource)) {
            this.onExit.invoke();
        }
    }

    @JavascriptInterface
    public final void getIcon(String pageSource, String pageUrl) {
        if (TextUtils.isEmpty(pageSource)) {
            Log.e(a96.b(), "get icon pageSource is empty");
        } else {
            this.onFound.invoke(a(pageSource, pageUrl));
        }
    }
}
