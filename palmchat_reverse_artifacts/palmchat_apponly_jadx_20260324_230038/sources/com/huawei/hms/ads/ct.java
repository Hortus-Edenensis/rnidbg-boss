package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.android.util.HwNotchSizeUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ct extends cq {
    private static final String B = "true";
    private static final String C = "156";
    private static final String I = "HnDeviceImpl";
    private static final byte[] S = new byte[0];
    private static cy Z;

    private ct(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String strV = V("msc.build.platform.version");
        this.V.V(strV);
        return strV;
    }

    private static cy I(Context context) {
        cy cyVar;
        synchronized (S) {
            if (Z == null) {
                Z = new ct(context);
            }
            cyVar = Z;
        }
        return cyVar;
    }

    public static cy V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean B() {
        return !TextUtils.isEmpty(Z());
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public String C() {
        return com.huawei.openalliance.ad.utils.bg.Code(com.huawei.openalliance.ad.utils.n.V);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public int Code(View view) {
        StringBuilder sb;
        try {
            if (!HwNotchSizeUtil.hasNotchInScreen()) {
                return 0;
            }
            int[] notchSize = HwNotchSizeUtil.getNotchSize();
            if (notchSize.length >= 2) {
                return notchSize[1];
            }
            return 0;
        } catch (Exception e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            fh.I(I, sb.toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            fh.I(I, sb.toString());
            return 0;
        }
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.bg.Code("msc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public String Z() {
        String strC = this.V.C();
        if (TextUtils.isEmpty(strC)) {
            strC = F();
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.ct.1
                @Override // java.lang.Runnable
                public void run() {
                    ct.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.x.be, strC)) {
            return null;
        }
        return strC;
    }

    private String V(String str) {
        String strCode = com.huawei.openalliance.ad.utils.bg.Code(str);
        return strCode == null ? com.huawei.openalliance.ad.constant.x.be : strCode;
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code() {
        return C.equals(com.huawei.openalliance.ad.utils.bg.Code("msc.config.optb"));
    }
}
