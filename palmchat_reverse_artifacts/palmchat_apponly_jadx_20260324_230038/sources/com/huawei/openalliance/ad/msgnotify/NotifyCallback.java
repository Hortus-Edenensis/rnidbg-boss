package com.huawei.openalliance.ad.msgnotify;

import android.content.Intent;
import com.huawei.hms.ads.annotation.AllApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface NotifyCallback {
    void onMessageNotify(String str, Intent intent);
}
