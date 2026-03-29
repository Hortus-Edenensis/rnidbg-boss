package com.zenmen.palmchat.jiguang;

import android.content.Context;
import android.util.Log;
import cn.jpush.android.service.WakedResultReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LxWakedResultReceiver extends WakedResultReceiver {
    @Override // cn.jpush.android.service.WakedResultReceiver
    public void onWake(Context context, int i) {
        super.onWake(context, i);
        Log.d("LxWakedResultReceiver", "onWake wakeType: " + i);
    }
}
