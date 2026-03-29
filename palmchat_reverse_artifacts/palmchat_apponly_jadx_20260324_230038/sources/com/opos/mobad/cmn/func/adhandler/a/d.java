package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8650a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends d {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.d, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 10;
        }
    }

    public d(String str) {
        this.f8650a = str;
    }

    public static d a(MaterialData materialData) {
        return new d(materialData.i());
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 4;
    }

    public static a b(MaterialData materialData) {
        return new a(materialData.i());
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f8650a);
    }
}
