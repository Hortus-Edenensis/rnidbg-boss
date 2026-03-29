package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class j implements a.a.c.a.b.c {
    @Override // a.a.c.a.b.c
    public c.a a(Context context) {
        Uri uri = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i = Build.VERSION.SDK_INT;
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.release();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) != 0) {
                TextUtils.isEmpty(bundleCall.getString("message"));
                return null;
            }
            c.a aVar = new c.a();
            aVar.f1105a = bundleCall.getString("id");
            return aVar;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }
}
