package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ak implements am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6620a = "dl_PreferDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.am
    public final u a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        try {
            if (s.a(context, string).d > 0) {
                af.b(f6620a, "Choose the decompressedModuleVersion");
                return new s();
            }
            if (t.a(context, string) > 0) {
                af.b(f6620a, "Choose the HMSLoadStrategy");
                return new t();
            }
            af.c(f6620a, "No available module version.");
            return null;
        } catch (com.huawei.hms.ads.dynamicloader.j e) {
            throw e;
        } catch (Exception e2) {
            af.c(f6620a, "getLoadingStrategy other exception." + e2.getClass().getSimpleName());
            return null;
        }
    }
}
