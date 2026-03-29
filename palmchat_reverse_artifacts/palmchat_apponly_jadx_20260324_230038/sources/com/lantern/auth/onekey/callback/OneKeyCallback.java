package com.lantern.auth.onekey.callback;

import com.lantern.auth.core.BLCallback;
import com.lantern.auth.util.report.OneKeyReportInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class OneKeyCallback<T> extends MobCallbackBridge<T> {
    protected BLCallback callback;
    protected boolean isPreLogin;
    protected OneKeyReportInfo reportInfo;

    public OneKeyCallback(boolean z, BLCallback bLCallback, OneKeyReportInfo oneKeyReportInfo) {
        this.isPreLogin = z;
        this.callback = bLCallback;
        this.reportInfo = oneKeyReportInfo;
    }
}
