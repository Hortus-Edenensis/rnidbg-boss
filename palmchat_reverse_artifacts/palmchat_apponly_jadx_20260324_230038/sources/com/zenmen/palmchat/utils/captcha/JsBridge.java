package com.zenmen.palmchat.utils.captcha;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class JsBridge {
    public static final String TAG = "JsBridge";
    private a webViewDialog;

    public JsBridge(a aVar) {
        this.webViewDialog = aVar;
    }

    @JavascriptInterface
    public void onData(String str) {
        LogUtil.i(TAG, "onData " + str + this.webViewDialog);
        this.webViewDialog.o(str);
        LogUtil.i(TAG, "getData222" + str);
    }

    @JavascriptInterface
    public void onError(String str) {
        LogUtil.i(TAG, "onError" + str);
        this.webViewDialog.n(str);
    }

    @JavascriptInterface
    public void onReady() {
        LogUtil.i(TAG, "onReady");
        this.webViewDialog.p();
    }
}
