package com.tide.host.a;

import com.tide.protocol.host.model.PluginUpdateInfo;
import com.tide.protocol.util.TdLogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class x implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f10804a;

    public x(y yVar) {
        this.f10804a = yVar;
    }

    @Override // com.tide.host.a.s
    public final void a(PluginUpdateInfo pluginUpdateInfo) {
        if (pluginUpdateInfo == null) {
            a(-1, "success but response is null");
            return;
        }
        TdLogUtils.log("PluginUpdateCheckRequest", "onSuccess: " + pluginUpdateInfo);
        this.f10804a.c.a(pluginUpdateInfo);
    }

    @Override // com.tide.host.a.s
    public final void a(int i, String str) {
        TdLogUtils.log("PluginUpdateCheckRequest", i + " onFailure: " + str);
        this.f10804a.c.a(i, str);
    }
}
