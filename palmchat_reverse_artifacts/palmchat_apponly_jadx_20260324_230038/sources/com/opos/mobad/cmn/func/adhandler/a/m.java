package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8658a;
    public final String b;
    public final String c;
    public com.opos.mobad.p.a d;
    public com.opos.mobad.p.c e;
    public final String f;
    public final long g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends m {
        public a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.m, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends m {
        public b(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.m, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 12;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends m {
        public c(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
            super(adItemData, materialData, aVar, cVar, str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.m, com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 13;
        }
    }

    private m(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
        this.b = adItemData.f();
        this.c = materialData.c();
        this.f8658a = materialData.k();
        this.d = aVar;
        this.e = cVar;
        this.f = str;
        this.g = -1L;
    }

    public static m a(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
        return materialData.B() == 1 ? new a(adItemData, materialData, aVar, cVar, str) : new m(adItemData, materialData, aVar, cVar, str);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 3;
    }

    public static m b(AdItemData adItemData, MaterialData materialData, com.opos.mobad.p.a aVar, com.opos.mobad.p.c cVar, String str) {
        return materialData.B() == 1 ? new b(adItemData, materialData, aVar, cVar, str) : new c(adItemData, materialData, aVar, cVar, str);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f8658a);
    }
}
