package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cb;
import com.huawei.openalliance.ad.inter.data.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class NativeAdConverter {
    @GlobalApi
    public static NativeAd deserialization(Context context, String str) {
        return deserialization(context, str, null);
    }

    @GlobalApi
    public static String serialization(NativeAd nativeAd) {
        if (nativeAd instanceof cb) {
            return g.a.Code(((cb) nativeAd).Code());
        }
        return null;
    }

    @GlobalApi
    public static NativeAd deserialization(Context context, String str, NativeAdConfiguration nativeAdConfiguration) {
        g gVarCode = g.a.Code(str);
        if (gVarCode == null) {
            return null;
        }
        cb cbVar = new cb(context, gVarCode);
        if (nativeAdConfiguration != null) {
            cbVar.Code(nativeAdConfiguration);
        }
        return cbVar;
    }
}
