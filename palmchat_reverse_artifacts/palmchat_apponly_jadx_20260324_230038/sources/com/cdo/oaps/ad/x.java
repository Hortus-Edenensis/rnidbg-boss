package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003e -> B:19:0x0040). Please report as a decompilation issue!!! */
    public static float a(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo("com.nearme.gamecenter", 128);
            bundle = applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        float fFloatValue = (bundle == null || !bundle.containsKey("oaps_version") || (obj = applicationInfo.metaData.get("oaps_version")) == null) ? -1.0f : obj instanceof Number ? ((Number) obj).floatValue() : Float.valueOf(obj.toString()).floatValue();
        return fFloatValue > 0.0f ? fFloatValue : w.b(context);
    }
}
