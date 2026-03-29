package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.mv.fx;
import com.bytedance.sdk.component.mv.nr;
import com.bytedance.sdk.component.mv.u;
import com.bytedance.sdk.component.utils.jk;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.mv.u {
    public static com.bytedance.sdk.component.widget.u b = null;
    private static int pn = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<fx, Set<String>> f5185a;
    protected WebViewImpl fx;
    private long iz;
    private Deque<fx> n;
    protected volatile fx nr;
    protected final AtomicInteger u;
    private u.InterfaceC0224u x;

    public MultiWebview(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.fx == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.fx.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.fx.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.n.add(this.fx);
        this.nr = this.fx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        while (true) {
            fx fxVarU = u();
            if (fxVarU == null) {
                break;
            } else {
                removeView(fxVarU.getView());
            }
        }
        WebViewImpl webViewImpl = this.fx;
        if (webViewImpl != null) {
            webViewImpl.nr();
        }
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.u uVar) {
        b = uVar;
    }

    public static void setMaxWebViewCount(int i) {
        pn = i + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fx x() {
        if (this.n.size() < 2) {
            this.nr = this.fx;
            return null;
        }
        fx fxVarPollLast = this.n.pollLast();
        if (fxVarPollLast != null) {
            removeView(fxVarPollLast.getView());
            fxVarPollLast.destroy();
            this.f5185a.remove(fxVarPollLast);
        }
        fx last = this.n.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.nr = last;
        }
        return fxVarPollLast;
    }

    public void I_() {
        this.f5185a.clear();
        this.x = null;
        u(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.iz();
            }
        });
    }

    public void destroy() {
        while (true) {
            fx fxVarPollLast = this.n.pollLast();
            if (fxVarPollLast == null) {
                this.fx = null;
                this.nr = null;
                this.f5185a.clear();
                this.x = null;
                return;
            }
            fxVarPollLast.destroy();
        }
    }

    public long getCreateDuration() {
        return this.iz;
    }

    public fx getCurrentWebView() {
        return this.nr;
    }

    public int getWebViewCount() {
        return this.n.size();
    }

    public boolean pn() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private fx fx() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.u uVar = b;
            if (uVar == null) {
                return null;
            }
            uVar.u(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fx nr(String str) {
        fx fxVarFx = fx();
        if (fxVarFx != null) {
            fx fxVar = this.nr;
            this.n.add(fxVarFx);
            this.nr = fxVarFx;
            addView(fxVarFx.getView(), new FrameLayout.LayoutParams(-1, -1));
            u(fxVarFx);
            fxVarFx.loadUrl(str);
            if (fxVar != null) {
                fxVar.onPause();
                fxVar.setVisibility(8);
            }
        }
        return fxVarFx;
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.u = atomicInteger;
        this.n = new LinkedList();
        this.f5185a = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (pn()) {
            this.fx = u(context, attributeSet, i);
            b();
            this.iz = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        u(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.fx = multiWebview.u(context, attributeSet, i);
                MultiWebview.this.b();
                MultiWebview.this.iz = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl u(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.u.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.u.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.u.set(4);
            if (b == null) {
                return null;
            }
            b.u(Thread.currentThread().getName(), th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.mv.u
    public void nr(fx fxVar, String str) {
        Set<String> set;
        if (fxVar == null || str == null || (set = this.f5185a.get(fxVar)) == null) {
            return;
        }
        set.remove(str);
    }

    @Override // com.bytedance.sdk.component.mv.u
    public int u(final String str) {
        fx fxVarNr;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (pn == 1) {
            return 2;
        }
        if (getWebViewCount() >= pn) {
            return 1;
        }
        if (pn()) {
            fxVarNr = nr(str);
        } else {
            final fx[] fxVarArr = new fx[1];
            final Object obj = new Object();
            u(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    fxVarArr[0] = MultiWebview.this.nr(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (fxVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            fxVarNr = fxVarArr[0];
        }
        if (fxVarNr != null) {
            return 0;
        }
        return SkuConfig.INFINITE_COUNT;
    }

    private void u(fx fxVar) {
        u uVar;
        Object objU;
        WebViewImpl webViewImpl = this.fx;
        if (webViewImpl == null || fxVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            fxVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            fxVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            fxVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            fxVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            fxVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            fxVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            fxVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            fxVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            fxVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            fxVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            fxVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            fxVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            fxVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            fxVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            fxVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            fxVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            fxVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            fxVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            fxVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            fxVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            fxVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            fxVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            fxVar.setUserAgentString(userAgentString);
        }
        nr.u onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            fxVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            fxVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            fxVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.nr client = webViewImpl.getClient();
        if (client != null) {
            fxVar.setWebViewClient(client.u());
        }
        Map<String, u> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (uVar = javascriptInterfaces.get(str)) != null && (objU = uVar.u()) != null) {
                    fxVar.addJavascriptInterface(objU, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.mv.u
    public fx u() {
        if (pn()) {
            return x();
        }
        final fx[] fxVarArr = new fx[1];
        final Object obj = new Object();
        u(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                fxVarArr[0] = MultiWebview.this.x();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (fxVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return fxVarArr[0];
    }

    @Override // com.bytedance.sdk.component.mv.u
    public void u(fx fxVar, String str, String str2, Object obj) {
        if (str2 == null || fxVar == null) {
            return;
        }
        for (fx fxVar2 : this.f5185a.keySet()) {
            if (fxVar2 != null && fxVar != fxVar2) {
                Set<String> set = this.f5185a.get(fxVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    fxVar2.u(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.mv.u
    public void u(fx fxVar, String str) {
        if (fxVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.f5185a.get(fxVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f5185a.put(fxVar, hashSet);
        }
        hashSet.add(str);
    }

    public void u(Runnable runnable) {
        u(runnable, false);
    }

    public void u(final Runnable runnable, boolean z) {
        if (pn()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.pn()) {
                        runnable.run();
                    } else {
                        jk.nr().post(runnable);
                    }
                }
            });
        } else {
            jk.nr().post(runnable);
        }
    }
}
