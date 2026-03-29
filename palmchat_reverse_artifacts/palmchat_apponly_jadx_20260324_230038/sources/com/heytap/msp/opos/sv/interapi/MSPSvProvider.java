package com.heytap.msp.opos.sv.interapi;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.opos.cmn.an.f.a;
import com.opos.process.bridge.server.ProcessBridgeProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MSPSvProvider extends ProcessBridgeProvider {
    private static final String TAG = "MSPSvProvider";

    @Override // com.opos.process.bridge.server.ProcessBridgeProvider, android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        try {
            PkgNameManager.getInstance().putCallingPackage(getCallingPackage());
        } catch (Throwable th) {
            a.c(TAG, "putCallingPackage", th);
        }
        return super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        try {
            PkgNameManager.getInstance().putCallingPackage(getCallingPackage());
        } catch (Throwable th) {
            a.c(TAG, "putCallingPackage", th);
        }
        return super.call(str, str2, str3, bundle);
    }
}
