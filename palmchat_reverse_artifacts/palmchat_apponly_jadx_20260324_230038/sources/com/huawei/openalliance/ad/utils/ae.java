package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ae {
    private static final String Code = "KitDataUtil";

    public static void Code(final Context context) {
        i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ae.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.S(context, 1)) {
                    fh.Code(ae.Code, "prepare cached contentId");
                    com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.A, null, null, null);
                    af.Code(context);
                }
            }
        });
    }
}
