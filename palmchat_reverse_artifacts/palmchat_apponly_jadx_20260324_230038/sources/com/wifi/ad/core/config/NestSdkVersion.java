package com.wifi.ad.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.az;
import com.wifi.ad.core.utils.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/wifi/ad/core/config/NestSdkVersion;", "", "()V", az.aQ, "", "getVersion", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestSdkVersion {
    public static final NestSdkVersion INSTANCE = new NestSdkVersion();
    private static String sdkVer = "";

    private NestSdkVersion() {
    }

    public final String getVersion(Context context) {
        if (!TextUtils.isEmpty(sdkVer)) {
            return sdkVer;
        }
        String appMetaDataString = DeviceUtils.getAppMetaDataString(context, "NEST_SDK_VERSION", "");
        Intrinsics.checkExpressionValueIsNotNull(appMetaDataString, "DeviceUtils.getAppMetaDa…, \"NEST_SDK_VERSION\", \"\")");
        sdkVer = appMetaDataString;
        return appMetaDataString;
    }
}
