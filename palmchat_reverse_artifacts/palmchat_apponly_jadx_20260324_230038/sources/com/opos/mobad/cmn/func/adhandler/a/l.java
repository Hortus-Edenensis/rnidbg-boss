package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8657a;
    public String b;
    public String c;

    public l(String str, String str2, String str3) {
        this.f8657a = str;
        this.b = str2;
        this.c = str3;
    }

    public static l a(AdItemData adItemData) {
        return new l(adItemData.ae(), "nativeOpenAdCanvas", adItemData.ai());
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 19;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f8657a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) ? false : true;
    }
}
