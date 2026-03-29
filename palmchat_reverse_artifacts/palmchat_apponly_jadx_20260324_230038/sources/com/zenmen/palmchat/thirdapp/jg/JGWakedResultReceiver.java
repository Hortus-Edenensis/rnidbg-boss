package com.zenmen.palmchat.thirdapp.jg;

import android.content.Context;
import android.util.Log;
import cn.jpush.android.service.WakedResultReceiver;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class JGWakedResultReceiver extends WakedResultReceiver {
    @Override // cn.jpush.android.service.WakedResultReceiver
    public void onWake(Context context, int i) {
        super.onWake(context, i);
        Log.i("jiguang", "JGWakedResultReceiver: " + i);
    }
}
