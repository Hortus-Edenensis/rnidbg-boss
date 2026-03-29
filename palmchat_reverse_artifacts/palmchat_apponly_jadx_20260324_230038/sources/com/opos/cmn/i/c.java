package com.opos.cmn.i;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static final boolean a(Context context, Uri uri) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            z = contentProviderClientAcquireContentProviderClient != null;
            if (contentProviderClientAcquireContentProviderClient != null) {
                contentProviderClientAcquireContentProviderClient.release();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("", "check provider", e);
        }
        return z;
    }
}
