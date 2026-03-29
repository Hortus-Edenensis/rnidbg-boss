package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.ActivatingData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.ApkSignerData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8647a;
    public final String b;
    public final List<ApkSignerData> c;
    public final int d;

    private a(ActivatingData activatingData) {
        int i;
        if (activatingData == null) {
            this.f8647a = null;
            this.b = null;
            this.c = null;
            i = -1;
        } else {
            this.f8647a = activatingData.f9073a;
            this.b = activatingData.b;
            this.c = activatingData.c;
            i = activatingData.d;
        }
        this.d = i;
    }

    public static a a(AdItemData adItemData) {
        return new a(adItemData.M());
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 16;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f8647a)) ? false : true;
    }
}
