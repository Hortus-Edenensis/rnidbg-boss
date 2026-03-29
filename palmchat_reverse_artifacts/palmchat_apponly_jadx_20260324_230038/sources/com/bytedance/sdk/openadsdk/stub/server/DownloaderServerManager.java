package com.bytedance.sdk.openadsdk.stub.server;

import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.api.iz;
import com.bytedance.sdk.openadsdk.api.plugin.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class DownloaderServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        try {
            a.u(getContext());
        } catch (Throwable th) {
            iz.u(th);
        }
        return super.onCreate();
    }
}
