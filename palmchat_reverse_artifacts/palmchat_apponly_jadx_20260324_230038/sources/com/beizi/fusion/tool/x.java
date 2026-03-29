package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.media3.common.C;
import com.beizi.fusion.model.RequestInfo;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static x f4751a;
    private String b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f4752a;
        private int b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4752a == null) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = this.b;
            this.f4752a.sendMessage(messageObtain);
        }

        private a(final Context context) {
            this.b = 100100;
            this.f4752a = new j(context) { // from class: com.beizi.fusion.tool.x.a.1
                @Override // com.beizi.fusion.tool.j
                public void a(Message message) {
                    Context contextA;
                    if (message == null) {
                        return;
                    }
                    try {
                        if (message.what == a.this.b && (contextA = a()) != null) {
                            if (System.currentTimeMillis() - an.b(context, "updateUserAgentTime") < 172800000) {
                                return;
                            }
                            WebView webView = new WebView(contextA);
                            WebView.setWebContentsDebuggingEnabled(false);
                            webView.getSettings().setSavePassword(false);
                            String userAgentString = webView.getSettings().getUserAgentString();
                            RequestInfo.getInstance(contextA).updateUserAgent(userAgentString);
                            com.beizi.ad.b.b(userAgentString);
                            an.a(contextA, "userAgent", userAgentString);
                            an.a(contextA, "updateUserAgentTime", Long.valueOf(System.currentTimeMillis()));
                        }
                    } catch (Exception unused) {
                    }
                }
            };
        }
    }

    public static synchronized x a() {
        if (f4751a == null) {
            synchronized (x.class) {
                f4751a = new x();
            }
        }
        return f4751a;
    }

    public void b(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            Executors.newSingleThreadScheduledExecutor().schedule(new a(context), C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, TimeUnit.MILLISECONDS);
        }
    }

    public String a(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = an.a(context, "userAgent");
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                this.b = WebSettings.getDefaultUserAgent(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }
}
