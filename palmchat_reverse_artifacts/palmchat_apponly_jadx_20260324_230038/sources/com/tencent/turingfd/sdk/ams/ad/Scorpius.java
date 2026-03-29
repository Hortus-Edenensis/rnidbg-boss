package com.tencent.turingfd.sdk.ams.ad;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Scorpius implements Aquila {
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[PHI: r3
      0x002b: PHI (r3v1 android.os.Bundle) = (r3v0 android.os.Bundle), (r3v4 android.os.Bundle) binds: [B:9:0x0029, B:5:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.tencent.turingfd.sdk.ams.ad.Aquila
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Phoenix a(Context context) throws RemoteException {
        Uri uri = Uri.parse(Cfinally.a(Cfinally.x0));
        String strA = Cfinally.a(Cfinally.f10761a);
        int i = Build.VERSION.SDK_INT;
        ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
        Bundle bundleCall = null;
        try {
            bundleCall = contentProviderClientAcquireContentProviderClient.call(strA, null, null);
        } catch (Throwable unused) {
            if (contentProviderClientAcquireContentProviderClient != null) {
                if (Build.VERSION.SDK_INT >= 24) {
                }
            }
        }
        if (i >= 24) {
            contentProviderClientAcquireContentProviderClient.release();
        } else {
            contentProviderClientAcquireContentProviderClient.release();
        }
        return bundleCall == null ? Phoenix.a(-1) : bundleCall.getInt(Cfinally.a(Cfinally.y0), -1) != 0 ? Phoenix.a(-2) : new Phoenix(bundleCall.getString(Cfinally.a(Cfinally.z0)), 0);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.Aquila
    public void b(Context context) {
    }
}
