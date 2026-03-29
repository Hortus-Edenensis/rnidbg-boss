package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8653a;
    public final String b;

    public h(MaterialData materialData) {
        this.f8653a = materialData.I() == 3;
        this.b = materialData.J();
    }

    public static h a(MaterialData materialData) {
        if (TextUtils.isEmpty(materialData.J())) {
            return null;
        }
        return new h(materialData);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 1;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.b);
    }
}
