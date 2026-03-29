package com.wifi.ad.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/utils/LocationUtil;", "", "()V", "LOCATION_LATITUDE", "", "LOCATION_LONGITUDE", "locationAdSpName", "getLatitude", "mContext", "Landroid/content/Context;", "getLongitude", "core_release"}, k = 1, mv = {1, 1, 16})
public final class LocationUtil {
    public static final LocationUtil INSTANCE = new LocationUtil();
    private static final String LOCATION_LATITUDE = "location_latitude";
    private static final String LOCATION_LONGITUDE = "location_longitude";
    private static final String locationAdSpName = "nest_ad_location_sp";

    private LocationUtil() {
    }

    public final String getLatitude(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(locationAdSpName, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "mContext.getSharedPrefer…me, Context.MODE_PRIVATE)");
        return sharedPreferences != null ? sharedPreferences.getString(LOCATION_LATITUDE, "") : "";
    }

    public final String getLongitude(Context mContext) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(locationAdSpName, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "mContext.getSharedPrefer…me, Context.MODE_PRIVATE)");
        return sharedPreferences != null ? sharedPreferences.getString(LOCATION_LONGITUDE, "") : "";
    }
}
