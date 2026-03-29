package com.bytedance.pangle.receiver;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Keep
public abstract class PluginBroadcastReceiver {
    public abstract void onReceive(Context context, Intent intent);
}
