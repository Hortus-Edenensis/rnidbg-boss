package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cp implements cy {
    private static final String I = "BaseDeviceImpl";
    protected Context Code;
    protected com.huawei.openalliance.ad.utils.at V;

    public cp(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.Code = applicationContext;
        this.V = com.huawei.openalliance.ad.utils.at.Code(applicationContext);
    }

    @Override // com.huawei.hms.ads.cy
    public boolean B() {
        return false;
    }

    @Override // com.huawei.hms.ads.cy
    public String C() {
        return null;
    }

    @Override // com.huawei.hms.ads.cy
    public int Code(View view) {
        return 0;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean I() {
        return true;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean S() {
        return false;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean V() {
        return true;
    }

    @Override // com.huawei.hms.ads.cy
    public String Z() {
        return null;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean Code() {
        return true;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.cy
    public boolean Code(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            fh.I(I, "check widget available error");
            return false;
        }
    }
}
