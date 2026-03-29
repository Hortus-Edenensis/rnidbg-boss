package com.huawei.openalliance.ad.activity;

import android.os.Bundle;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.gk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class PPSNotificationActivity extends d {
    private static final String Code = "PPSNotificationActivity";

    @Override // com.huawei.openalliance.ad.activity.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        fh.Code(Code, "PPSNotification onCreate");
        gk.Code(this).Code(this, getIntent());
        finish();
    }
}
