package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.hms.ads.jk;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AdEventRecord;
import com.huawei.openalliance.ad.inter.data.AdEventType;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.z;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public class f {
    private static f Code;
    private static final byte[] V = new byte[0];
    private Context I;

    private f(Context context) {
        this.I = context.getApplicationContext();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static f Code(Context context) {
        return V(context);
    }

    private static f V(Context context) {
        f fVar;
        synchronized (V) {
            if (Code == null) {
                Code = new f(context);
            }
            fVar = Code;
        }
        return fVar;
    }

    private void Code(AdContentData adContentData, Long l, boolean z) {
        if (adContentData == null) {
            return;
        }
        adContentData.I(String.valueOf(z.Code()));
        jk.Code(this.I, adContentData, (String) null, l, Boolean.valueOf(z));
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, Long l, boolean z) {
        Code(dVar.q(), l, z);
        jk.Code(this.I, dVar.q(), Long.valueOf(Math.min(dVar.j() - dVar.i(), dVar.x())), Integer.valueOf(dVar.y()), (Integer) 7, l, Boolean.valueOf(z));
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(List<AdEventRecord> list) {
        com.huawei.openalliance.ad.inter.data.d dVarCode;
        if (ag.Code(list)) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            AdEventRecord adEventRecord = list.get(i);
            if (adEventRecord != null && (dVarCode = adEventRecord.Code()) != null && dVarCode.H()) {
                String strZ = adEventRecord.Z();
                Long lValueOf = Long.valueOf(adEventRecord.B() == null ? z.Code() : adEventRecord.B().longValue());
                boolean z = i >= size + (-1);
                if ("imp".equalsIgnoreCase(strZ)) {
                    Code(dVarCode, lValueOf, z);
                } else if (AdEventType.SHOW_START.equalsIgnoreCase(strZ)) {
                    Code(dVarCode.q(), lValueOf, z);
                } else if ("click".equalsIgnoreCase(strZ)) {
                    MaterialClickInfo materialClickInfo = new MaterialClickInfo();
                    materialClickInfo.B((Integer) 1);
                    jk.Code(this.I, dVarCode.q(), null, 0, 0, v.D, 12, null, lValueOf, Boolean.valueOf(z), materialClickInfo);
                } else if ("intentSuccess".equalsIgnoreCase(strZ)) {
                    jk.Code(this.I, dVarCode.q(), "intentSuccess", (Integer) 1, (Integer) null, lValueOf, Boolean.valueOf(z));
                }
            }
            i++;
        }
    }
}
