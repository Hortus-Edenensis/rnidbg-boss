package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cq extends cp {
    private static final int B = 0;
    private static final String I = "BaseHwnDeviceImpl";
    private static final String Z = "display_notch_status";

    public cq(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code(Context context) {
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), Z);
            fh.Code(I, "isNotchEnable, displayNotch: %s", Integer.valueOf(i));
            return i == 0;
        } catch (Throwable th) {
            fh.V(I, "isNotchEnable err:" + th.getClass().getSimpleName());
            return Build.VERSION.SDK_INT >= 26 && Code((View) null) > 0;
        }
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean V() {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code("ro.product.locale.region");
        if (!TextUtils.isEmpty(strCode)) {
            return "cn".equalsIgnoreCase(strCode);
        }
        String strCode2 = com.huawei.openalliance.ad.utils.bg.Code("ro.product.locale");
        if (!TextUtils.isEmpty(strCode2)) {
            return strCode2.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String strZ = com.huawei.openalliance.ad.utils.bg.Z();
        if (TextUtils.isEmpty(strZ)) {
            return false;
        }
        return "cn".equalsIgnoreCase(strZ);
    }
}
