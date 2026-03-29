package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class al implements am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6621a = "PreHiOrDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.am
    public final u a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        af.b(f6621a, "getLoadingStrategy");
        try {
            int iA = t.a(context, string);
            int i = s.a(context, string).d;
            af.b(f6621a, "3 module_name:" + string + ", hmsModuleVersion:" + iA + ", assetModuleVersion:0, decompressedModuleVersion:" + i);
            if (iA > 0 && iA > i) {
                af.b(f6621a, "Choose the HMSLoadStrategy");
                return new t();
            }
            if (i > 0) {
                af.b(f6621a, "Choose the DecompressLoadStrategy");
                return new s();
            }
            af.d(f6621a, "PreferHighestOrRemote: Cannot find a valid module version.");
            return null;
        } catch (com.huawei.hms.ads.dynamicloader.j e) {
            throw e;
        } catch (Throwable th) {
            Log.w(f6621a, "getLoadingStrategy other exception.".concat(String.valueOf(th)));
            return null;
        }
    }
}
