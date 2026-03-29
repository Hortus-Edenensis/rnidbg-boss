package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8652a;
    public final String b;
    public final String c;
    public final com.opos.mobad.p.a d;

    private g(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar) {
        this.b = adItemData.f();
        this.c = materialData.c();
        this.f8652a = materialData.u();
        this.d = aVar;
    }

    public static g a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar) {
        return new g(adItemData, materialData, aVar);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 15;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f8652a);
    }
}
