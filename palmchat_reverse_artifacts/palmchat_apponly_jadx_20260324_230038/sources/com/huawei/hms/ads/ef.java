package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderCommonInter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ef implements LoaderCommonInter {
    private static final String Code = "LoaderCommonHandler";
    private static ef V;
    private static final byte[] Z = new byte[0];
    private Context I;

    private ef(Context context) {
        this.I = context;
    }

    public static ef Code(Context context) {
        return V(context);
    }

    private static ef V(Context context) {
        ef efVar;
        synchronized (Z) {
            if (V == null) {
                V = new ef(context);
            }
            efVar = V;
        }
        return efVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public boolean isTrustApp(String str, String str2) {
        return com.huawei.openalliance.ad.constant.dg.Code(this.I, str, str2);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public void saveReportPoint(int i, Integer num, Integer num2) {
        if (fh.Code()) {
            fh.Code(Code, "saveReportPoint");
        }
        db.Code(this.I, i, num, num2);
    }
}
