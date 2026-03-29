package com.tide.host.a;

import com.tide.protocol.host.model.PluginUpdateInfo;
import com.tide.protocol.model.JsonFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class w implements JsonFactory {
    @Override // com.tide.protocol.model.JsonFactory
    public final Object fromJson(String str) {
        return PluginUpdateInfo.fromJson(str);
    }
}
