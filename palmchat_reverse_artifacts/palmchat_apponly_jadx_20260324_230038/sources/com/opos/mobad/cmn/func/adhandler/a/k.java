package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8656a;
    public final String b;
    public final String c;
    public final String d;

    private k(AdItemData adItemData, MaterialData materialData) {
        this.f8656a = adItemData.d();
        this.b = adItemData.e();
        this.c = materialData.q();
        this.d = materialData.o();
    }

    public static k a(AdItemData adItemData, MaterialData materialData) {
        return new k(adItemData, materialData);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 14;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.c);
    }
}
