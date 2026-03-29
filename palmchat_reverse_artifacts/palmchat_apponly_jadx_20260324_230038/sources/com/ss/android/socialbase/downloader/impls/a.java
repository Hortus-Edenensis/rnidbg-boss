package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements com.ss.android.socialbase.downloader.downloader.t {
    @Override // com.ss.android.socialbase.downloader.downloader.t
    public int u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strPn = com.ss.android.socialbase.downloader.jk.iz.pn(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strPn)) {
            return 0;
        }
        return strPn.hashCode();
    }
}
