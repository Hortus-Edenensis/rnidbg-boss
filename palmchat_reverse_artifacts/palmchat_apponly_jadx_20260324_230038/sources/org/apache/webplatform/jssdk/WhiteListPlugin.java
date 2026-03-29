package org.apache.webplatform.jssdk;

import org.apache.cordovaNew.CordovaPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class WhiteListPlugin extends CordovaPlugin {
    @Override // org.apache.cordovaNew.CordovaPlugin
    public Boolean shouldAllowRequest(String str) {
        return Boolean.TRUE;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public Boolean shouldOpenExternalUrl(String str) {
        return Boolean.TRUE;
    }
}
