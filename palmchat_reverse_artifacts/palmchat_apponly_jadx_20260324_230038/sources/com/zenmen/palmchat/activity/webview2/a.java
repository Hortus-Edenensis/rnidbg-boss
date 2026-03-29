package com.zenmen.palmchat.activity.webview2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.jssdk.ReportPlugin;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/a;", "Lorg/apache/cordova/jssdk/ReportPlugin;", "", "action", "Lorg/json/JSONArray;", "args", "Lorg/apache/cordova/CallbackContext;", "callbackContext", "", "execute", "<init>", "()V", "a", "app_release"}, k = 1, mv = {1, 8, 0})
public final class a extends ReportPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String b;

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.webview2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/a$a;", "", "", "TARGET", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return a.b;
        }

        public Companion() {
        }
    }

    static {
        String qualifiedName = Reflection.getOrCreateKotlinClass(ReportPlugin.class).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        b = qualifiedName;
    }

    @Override // org.apache.cordova.jssdk.ReportPlugin, org.apache.cordova.CordovaPlugin
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(args, "args");
        CordovaWebView cordovaWebView = this.webView;
        Intrinsics.checkNotNull(cordovaWebView, "null cannot be cast to non-null type com.zenmen.palmchat.activity.webview2.WebView");
        WebView webView = (WebView) cordovaWebView;
        if (!Intrinsics.areEqual(action, Action.ACTION_CLOSE_WINDOW)) {
            return super.execute(action, args, callbackContext);
        }
        webView.getContainer().b();
        return true;
    }
}
