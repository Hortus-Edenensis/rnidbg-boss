package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cv extends cq {
    private static final String B = "display_notch_status";
    private static final int C = 0;
    private static final byte[] D = new byte[0];
    private static cy F = null;
    private static final String I = "HwDeviceImpl";
    private static final String S = "true";
    private static final String Z = "156";

    private cv(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String strV = V("hw_sc.build.platform.version");
        this.V.V(strV);
        return strV;
    }

    private static cy I(Context context) {
        cy cyVar;
        synchronized (D) {
            if (F == null) {
                F = new cv(context);
            }
            cyVar = F;
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
        return com.huawei.openalliance.ad.utils.bg.Code(com.huawei.openalliance.ad.utils.n.Code);
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
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.bg.Code("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public String Z() {
        String strC = this.V.C();
        if (TextUtils.isEmpty(strC)) {
            strC = F();
        } else {
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.cv.1
                @Override // java.lang.Runnable
                public void run() {
                    cv.this.F();
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
    public boolean I() {
        return com.huawei.openalliance.ad.utils.q.Code(this.Code);
    }

    @Override // com.huawei.hms.ads.cp, com.huawei.hms.ads.cy
    public boolean Code() {
        return Z.equals(com.huawei.openalliance.ad.utils.bg.Code("ro.config.hw_optb"));
    }
}
