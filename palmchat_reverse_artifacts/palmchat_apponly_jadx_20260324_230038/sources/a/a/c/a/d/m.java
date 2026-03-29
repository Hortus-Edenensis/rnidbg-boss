package a.a.c.a.d;

import a.a.c.a.b.c;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class m implements a.a.c.a.b.c {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends c.a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a A[PHI: r2 r4
      0x002a: PHI (r2v3 android.os.Bundle) = (r2v2 android.os.Bundle), (r2v9 android.os.Bundle) binds: [B:15:0x0028, B:5:0x001b] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r4v4 android.content.ContentProviderClient) = (r4v15 android.content.ContentProviderClient), (r4v16 android.content.ContentProviderClient) binds: [B:15:0x0028, B:5:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // a.a.c.a.b.c
    @RequiresApi(api = 24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a a(Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Bundle bundleCall;
        ContentProviderClient contentProviderClient;
        a aVar = new a();
        ?? r1 = 0;
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.pico.idprovider"));
                try {
                    bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("request_oaid", null, null);
                    context = contentProviderClientAcquireUnstableContentProviderClient;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                } catch (RemoteException e) {
                    e = e;
                    e.printStackTrace();
                    bundleCall = null;
                    context = contentProviderClientAcquireUnstableContentProviderClient;
                    contentProviderClient = contentProviderClientAcquireUnstableContentProviderClient;
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = context;
                if (r1 != 0) {
                    r1.release();
                }
                throw th;
            }
        } catch (RemoteException e2) {
            e = e2;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
            contentProviderClient.release();
            context = contentProviderClient;
        }
        if (bundleCall != null) {
            aVar.f1105a = bundleCall.getString("oaid", null);
            aVar.b = bundleCall.getBoolean("forbidden", false);
        }
        return aVar;
    }

    @Override // a.a.c.a.b.c
    public boolean b(Context context) {
        return true;
    }
}
