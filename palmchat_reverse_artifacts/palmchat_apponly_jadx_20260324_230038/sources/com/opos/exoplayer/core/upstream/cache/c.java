package com.opos.exoplayer.core.upstream.cache;

import android.net.Uri;
import com.opos.exoplayer.core.upstream.DataSpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static String a(Uri uri) {
        return uri.toString();
    }

    public static String a(DataSpec dataSpec) {
        String str = dataSpec.f;
        return str != null ? str : a(dataSpec.f8366a);
    }
}
