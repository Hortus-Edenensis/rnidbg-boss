package com.opos.process.bridge.provider;

import android.content.Context;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IBridgeHandler {

    /* JADX INFO: compiled from: SearchBox */
    public interface Factory {
        IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify);
    }
}
