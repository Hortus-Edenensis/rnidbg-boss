package com.opos.mobad.downloader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8787a;

    public j(Context context) {
        this.f8787a = context;
    }

    @Override // com.opos.mobad.downloader.h
    public File a(String str) {
        if (this.f8787a == null || TextUtils.isEmpty(str) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = com.opos.cmn.d.c.a(this.f8787a);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        File file = new File(strA);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String strA2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return new File(file, strA2);
    }

    @Override // com.opos.mobad.downloader.h
    public File a(String str, String str2) {
        if (this.f8787a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = com.opos.cmn.d.c.a(this.f8787a);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        File file = new File(strA + File.separator + str2);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String strA2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return new File(file, strA2);
    }
}
