package com.bytedance.sdk.openadsdk.core.l.u;

import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements ITTDownloadAdapter.OnEventLogHandler {
    private fx.u mPluginLogHandler;

    public u(fx.u uVar) {
        this.mPluginLogHandler = uVar;
    }

    public boolean onEventLog(int i, String str, String str2, String str3, Object obj) {
        fx.u uVar = this.mPluginLogHandler;
        if (uVar != null) {
            return uVar.u(i, str, str2, str3, obj);
        }
        return false;
    }
}
