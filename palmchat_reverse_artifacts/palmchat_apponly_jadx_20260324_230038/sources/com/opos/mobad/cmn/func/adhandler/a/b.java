package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8648a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b {
        public a(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 11;
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0725b extends b {
        public C0725b(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 9;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends b {
        public c(String str) {
            super(str);
        }

        @Override // com.opos.mobad.cmn.func.adhandler.a.e
        public int b() {
            return 5;
        }
    }

    public b(String str) {
        this.f8648a = str;
    }

    public static com.opos.mobad.cmn.func.adhandler.a.a.a a(MaterialData materialData) {
        return new com.opos.mobad.cmn.func.adhandler.a.a.a(materialData != null ? materialData.q() : "", materialData != null ? materialData.ag() : "");
    }

    public static C0725b b(String str) {
        return new C0725b(str);
    }

    public static a c(String str) {
        return new a(str);
    }

    public static c a(String str) {
        return new c(str);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f8648a);
    }
}
