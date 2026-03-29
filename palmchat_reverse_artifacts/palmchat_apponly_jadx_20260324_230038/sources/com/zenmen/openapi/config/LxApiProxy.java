package com.zenmen.openapi.config;

import defpackage.tm2;
import defpackage.wl2;
import defpackage.xl2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public enum LxApiProxy {
    mInstance;

    private tm2 config;
    private wl2 cordovaPlugin;
    private xl2 pluginFactory;

    public static LxApiProxy getInstance() {
        return mInstance;
    }

    public tm2 getConfigApi() {
        return this.config;
    }

    public String getConfigString(String str) {
        return this.config.a(str);
    }

    public xl2 getPluginFactory() {
        return this.pluginFactory;
    }

    public void setConfigImpl(tm2 tm2Var) {
        this.config = tm2Var;
    }

    public void setPluginFactory(xl2 xl2Var) {
        this.pluginFactory = xl2Var;
    }
}
