package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private volatile String f6592a;

    /* JADX INFO: renamed from: com.huawei.hms.ads.jsbridge.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class CallableC0434a implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IWebView f6593a;
        private WebView b;
        private boolean c;

        public CallableC0434a(WebView webView) {
            this.b = webView;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            if (this.c) {
                IWebView iWebView = this.f6593a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }

        public CallableC0434a(IWebView iWebView) {
            this.c = true;
            this.f6593a = iWebView;
        }
    }

    @Nullable
    private static String b(@NonNull WebView webView) {
        try {
            return a(new FutureTask(new CallableC0434a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    public String a(@Nullable WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f6592a;
        if (str != null) {
            return str;
        }
        b.a("securityExtSetFrameUrl is null ,get url from native");
        return b(webView);
    }

    @Nullable
    private static String b(@NonNull IWebView iWebView) {
        try {
            return a(new FutureTask(new CallableC0434a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    @Nullable
    public String a(@Nullable IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f6592a;
        return str != null ? str : b(iWebView);
    }

    private static Future<String> a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
        } else {
            new Handler(Looper.getMainLooper()).post(futureTask);
        }
        return futureTask;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
