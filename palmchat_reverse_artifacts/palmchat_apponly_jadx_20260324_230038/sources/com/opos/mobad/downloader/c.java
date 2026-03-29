package com.opos.mobad.downloader;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements i {
    @Override // com.opos.mobad.downloader.i
    public String a(Context context) {
        return context.getExternalCacheDir().getAbsolutePath();
    }

    @Override // com.opos.mobad.downloader.i
    public String a(String str) {
        return com.opos.cmn.an.b.c.a(str);
    }
}
