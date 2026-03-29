package com.zenmen.palmchat.webplatform;

import android.os.Build;
import android.os.Bundle;
import defpackage.me1;
import defpackage.sc;
import org.apache.cordovaNew.CordovaWebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TransparentLyWebActivity extends LyWebActivity {
    public static long i;

    @Override // com.zenmen.palmchat.webplatform.LyWebActivity
    public void k(int i2) {
        getWindow().addFlags(67108864);
        me1.l(getWindow(), 0, true);
    }

    @Override // org.apache.cordovaNew.CordovaActivity
    public void loadUrl(String str) {
        super.loadUrl(str);
        CordovaWebView cordovaWebView = this.appView;
        if (cordovaWebView != null) {
            cordovaWebView.getView().setBackgroundColor(0);
        }
    }

    @Override // com.zenmen.palmchat.webplatform.LyWebActivity, org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        i = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(3);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        try {
            sc.b(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.apache.cordovaNew.CordovaActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
