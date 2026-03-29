package com.tide.host.a;

import com.tide.protocol.util.TideDebug;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class h0 {
    public static String a() {
        return TideDebug.TEST_ENV ? "https://test-app-conf.aishuttler.com/v1/api/sdk_plugin" : "https://app-conf.aishuttler.com/v1/api/sdk_plugin";
    }
}
