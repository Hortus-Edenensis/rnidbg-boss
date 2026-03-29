package com.zenmen.palmchat.activity.webview2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.cdo.oaps.ad.Launcher;
import com.igexin.push.g.o;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.browser.SRobotCompModel;
import com.zenmen.palmchat.widget.ZXWebView;
import defpackage.em2;
import defpackage.nc6;
import defpackage.qj6;
import defpackage.qp2;
import defpackage.up2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0017\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b4\u00105J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016JF\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00068"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/WebView;", "Lcom/zenmen/palmchat/widget/ZXWebView;", "Lem2;", "Lorg/apache/cordova/CordovaInterface;", "cordova", "Lorg/apache/cordova/ConfigXmlParser;", "parser", "", "init", "Lorg/apache/cordova/CordovaWebViewClient;", "webViewClient", "Lorg/apache/cordova/CordovaChromeClient;", "webChromeClient", "", "Lorg/apache/cordova/PluginEntry;", "pluginEntries", "Lorg/apache/cordova/Whitelist;", "internalWhitelist", "externalWhitelist", "Lorg/apache/cordova/CordovaPreferences;", "preferences", "Lqp2;", "container", "Lqp2;", "getContainer", "()Lqp2;", "Lcom/zenmen/palmchat/browser/SRobotCompModel;", "compModel", "Lcom/zenmen/palmchat/browser/SRobotCompModel;", "getCompModel", "()Lcom/zenmen/palmchat/browser/SRobotCompModel;", "setCompModel", "(Lcom/zenmen/palmchat/browser/SRobotCompModel;)V", "Lqj6;", "mWebShareObject", "Lqj6;", "getMWebShareObject", "()Lqj6;", "setMWebShareObject", "(Lqj6;)V", "Lup2;", "_iconGetter", "Lup2;", "get_iconGetter$app_release", "()Lup2;", "Lnc6;", "_videoListener", "Lnc6;", "get_videoListener$app_release", "()Lnc6;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lqp2;)V", "Companion", "a", "app_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebView.kt\ncom/zenmen/palmchat/activity/webview2/WebView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1549#2:116\n1620#2,3:117\n*S KotlinDebug\n*F\n+ 1 WebView.kt\ncom/zenmen/palmchat/activity/webview2/WebView\n*L\n82#1:116\n82#1:117,3\n*E\n"})
public class WebView extends ZXWebView implements em2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final up2 _iconGetter;
    private final nc6 _videoListener;
    private SRobotCompModel compModel;
    private final qp2 container;
    private qj6 mWebShareObject;

    /* JADX INFO: renamed from: com.zenmen.palmchat.activity.webview2.WebView$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002¨\u0006\u0007"}, d2 = {"Lcom/zenmen/palmchat/activity/webview2/WebView$a;", "", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "a", "<init>", "()V", "app_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorService a() {
            return ZXWebView.getThreadPool();
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<Unit> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WebView.this.getContainer().b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lqj6;", o.f, "", "a", "(Lqj6;)V"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function1<qj6, Unit> {
        public c() {
            super(1);
        }

        public final void a(qj6 qj6Var) {
            WebView.this.getContainer().a(qj6Var);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(qj6 qj6Var) {
            a(qj6Var);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, qp2 container) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this._iconGetter = new up2(this, new b(), new c());
        this._videoListener = new nc6();
    }

    public final SRobotCompModel getCompModel() {
        return this.compModel;
    }

    public final qp2 getContainer() {
        return this.container;
    }

    @Override // defpackage.em2
    public qj6 getMWebShareObject() {
        return this.mWebShareObject;
    }

    /* JADX INFO: renamed from: get_iconGetter$app_release, reason: from getter */
    public final up2 get_iconGetter() {
        return this._iconGetter;
    }

    /* JADX INFO: renamed from: get_videoListener$app_release, reason: from getter */
    public final nc6 get_videoListener() {
        return this._videoListener;
    }

    @Override // com.zenmen.palmchat.widget.ZXWebView
    public void init(CordovaInterface cordova, ConfigXmlParser parser) {
        Intrinsics.checkNotNullParameter(cordova, "cordova");
        Intrinsics.checkNotNullParameter(parser, "parser");
        super.init(cordova, parser);
    }

    public final void setCompModel(SRobotCompModel sRobotCompModel) {
        this.compModel = sRobotCompModel;
    }

    @Override // defpackage.em2
    public void setMWebShareObject(qj6 qj6Var) {
        this.mWebShareObject = qj6Var;
    }

    @Override // org.apache.cordova.CordovaWebView
    public void init(CordovaInterface cordova, CordovaWebViewClient webViewClient, CordovaChromeClient webChromeClient, List<? extends PluginEntry> pluginEntries, Whitelist internalWhitelist, Whitelist externalWhitelist, CordovaPreferences preferences) {
        Intrinsics.checkNotNullParameter(cordova, "cordova");
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        Intrinsics.checkNotNullParameter(webChromeClient, "webChromeClient");
        Intrinsics.checkNotNullParameter(pluginEntries, "pluginEntries");
        Intrinsics.checkNotNullParameter(internalWhitelist, "internalWhitelist");
        Intrinsics.checkNotNullParameter(externalWhitelist, "externalWhitelist");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        getSettings().setSavePassword(false);
        getSettings().setTextZoom(100);
        requestFocusFromTouch();
        setScrollBarStyle(33554432);
        setVerticalScrollBarEnabled(true);
        setScrollBarSize((int) getContext().getResources().getDimension(R.dimen.webview_scrollbar_size));
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Intrinsics.checkNotNullExpressionValue(obj, "mScrollCacheField.get(this)");
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Intrinsics.checkNotNullExpressionValue(obj2, "scrollBarField.get(mScrollCache)");
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, getContext().getResources().getDrawable(R.drawable.webview_scrollbar));
        } catch (Exception e) {
            e.printStackTrace();
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        removeJavascriptInterface("searchBoxJavaBridge_");
        addJavascriptInterface(this._iconGetter, "IconGetter");
        addJavascriptInterface(this._videoListener, "VideoListener");
        List<? extends PluginEntry> list = pluginEntries;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (PluginEntry pluginEntry : list) {
            if (Intrinsics.areEqual(pluginEntry.pluginClass, a.INSTANCE.a())) {
                String qualifiedName = Reflection.getOrCreateKotlinClass(a.class).getQualifiedName();
                Intrinsics.checkNotNull(qualifiedName);
                pluginEntry.pluginClass = qualifiedName;
            }
            arrayList.add(pluginEntry);
        }
        super.init(cordova, webViewClient, webChromeClient, arrayList, internalWhitelist, externalWhitelist, preferences);
    }
}
