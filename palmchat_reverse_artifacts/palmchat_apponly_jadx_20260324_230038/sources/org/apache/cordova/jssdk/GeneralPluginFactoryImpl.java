package org.apache.cordova.jssdk;

import android.app.Activity;
import android.webkit.WebView;
import defpackage.wl2;
import defpackage.xl2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class GeneralPluginFactoryImpl implements xl2 {
    @Override // defpackage.xl2
    public wl2 createGeneralPlugin(Activity activity, WebView webView) {
        return new GeneralPluginImpl();
    }
}
