package com.amap.api.col.p0002sl;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class fy extends id {
    @Override // com.amap.api.col.p0002sl.id
    public String b_() {
        if (TextUtils.isEmpty(f())) {
            return f();
        }
        String strF = f();
        Uri uri = Uri.parse(strF);
        if (uri.getAuthority().startsWith("dualstack-")) {
            return strF;
        }
        if (uri.getAuthority().startsWith("restsdk.amap.com")) {
            return uri.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        return uri.buildUpon().authority("dualstack-" + uri.getAuthority()).build().toString();
    }
}
