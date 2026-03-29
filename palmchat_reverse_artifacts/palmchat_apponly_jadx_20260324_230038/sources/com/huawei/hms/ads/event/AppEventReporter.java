package com.huawei.hms.ads.event;

import android.content.Context;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.da;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.ad;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class AppEventReporter {
    @AllApi
    public static void reportEventData(Context context, Map<String, String> map) {
        g.V(context).Code(da.S, ad.V(map), null, null);
    }
}
