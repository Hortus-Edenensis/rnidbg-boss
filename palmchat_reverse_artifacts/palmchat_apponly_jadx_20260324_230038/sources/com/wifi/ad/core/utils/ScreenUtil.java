package com.wifi.ad.core.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/utils/ScreenUtil;", "", "()V", "dp2px", "", "context", "Landroid/content/Context;", t.q, "", "getDisplayMetricsHeight", "getDisplayMetricsWidth", "core_release"}, k = 1, mv = {1, 1, 16})
public final class ScreenUtil {
    public static final ScreenUtil INSTANCE = new ScreenUtil();

    private ScreenUtil() {
    }

    public final int dp2px(Context context, float dp) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) TypedValue.applyDimension(1, dp, resources.getDisplayMetrics());
    }

    public final int getDisplayMetricsHeight(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.applicationContext.resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public final int getDisplayMetricsWidth(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        Resources resources = applicationContext.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.applicationContext.resources");
        return resources.getDisplayMetrics().widthPixels;
    }
}
