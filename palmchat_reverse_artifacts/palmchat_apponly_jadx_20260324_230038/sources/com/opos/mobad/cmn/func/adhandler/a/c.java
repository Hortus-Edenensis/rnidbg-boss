package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.cmn.func.adhandler.b;
import com.opos.mobad.model.data.AppDownloadData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8649a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final b.a f;

    public c(AppDownloadData appDownloadData, String str, b.a aVar) {
        String strD;
        this.f = aVar;
        if (appDownloadData == null || TextUtils.isEmpty(appDownloadData.a()) || TextUtils.isEmpty(appDownloadData.c())) {
            strD = null;
            this.f8649a = null;
            this.b = null;
            this.c = null;
        } else {
            this.f8649a = appDownloadData.a();
            this.b = appDownloadData.c();
            this.c = appDownloadData.b();
            strD = appDownloadData.d();
        }
        this.d = strD;
        this.e = str;
    }

    public static c a(MaterialData materialData, b.a aVar) {
        return new c(materialData.K(), materialData.X(), aVar);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 7;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f8649a) || TextUtils.isEmpty(this.b)) ? false : true;
    }
}
