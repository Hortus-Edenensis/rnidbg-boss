package com.bytedance.sdk.openadsdk.my.fx.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public final PluginValueSet u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final ll7 u;

        public u() {
            this.u = ll7.b();
        }

        public u a(String str) {
            this.u.h(260022, str);
            return this;
        }

        public u b(String str) {
            this.u.h(260004, str);
            return this;
        }

        public u fx(String str) {
            this.u.h(260003, str);
            return this;
        }

        public u iz(String str) {
            this.u.h(260014, str);
            return this;
        }

        public u jk(String str) {
            this.u.h(260024, str);
            return this;
        }

        public u n(String str) {
            this.u.h(260021, str);
            return this;
        }

        public u nr(String str) {
            this.u.h(260002, str);
            return this;
        }

        public u pn(String str) {
            this.u.h(260013, str);
            return this;
        }

        public u u(String str) {
            this.u.h(260001, str);
            return this;
        }

        public u x(String str) {
            this.u.h(260019, str);
            return this;
        }

        public u b(int i) {
            this.u.f(260015, i);
            return this;
        }

        public u fx(int i) {
            this.u.f(2600012, i);
            return this;
        }

        public u iz(int i) {
            this.u.f(260018, i);
            return this;
        }

        public u n(int i) {
            this.u.f(260025, i);
            return this;
        }

        public u nr(int i) {
            this.u.f(260007, i);
            return this;
        }

        public u pn(int i) {
            this.u.f(260016, i);
            return this;
        }

        public u u(boolean z) {
            this.u.i(260005, z);
            return this;
        }

        public u x(int i) {
            this.u.f(260020, i);
            return this;
        }

        public u(nr nrVar) {
            this.u = ll7.k(nrVar.u);
        }

        public u nr(float f) {
            this.u.e(260009, f);
            return this;
        }

        public u u(int i) {
            this.u.f(260006, i);
            return this;
        }

        public u nr(boolean z) {
            this.u.i(260010, z);
            return this;
        }

        public u u(float f) {
            this.u.e(260008, f);
            return this;
        }

        public u u(int[] iArr) {
            this.u.g(260017, iArr);
            return this;
        }

        public nr u() {
            return new nr(this.u.a().sparseArray());
        }
    }

    public nr(SparseArray<Object> sparseArray) {
        this.u = ll7.j(sparseArray).a();
    }

    public float a() {
        return this.u.floatValue(260009);
    }

    public String b() {
        return (String) this.u.objectValue(260004, String.class);
    }

    public String bg() {
        return (String) this.u.objectValue(260019, String.class);
    }

    public int bq() {
        return this.u.intValue(260020);
    }

    public String c() {
        return (String) this.u.objectValue(260022, String.class);
    }

    public String dw() {
        return (String) this.u.objectValue(260021, String.class);
    }

    public String fx() {
        return (String) this.u.objectValue(260003, String.class);
    }

    public int iz() {
        return this.u.intValue(260006);
    }

    public boolean jk() {
        return this.u.booleanValue(260010);
    }

    public int k() {
        return this.u.intValue(260015);
    }

    public int kj() {
        return this.u.intValue(260025);
    }

    public int l() {
        return this.u.intValue(2600012);
    }

    public String mv() {
        return (String) this.u.objectValue(260013, String.class);
    }

    public int my() {
        return this.u.intValue(260016);
    }

    public float n() {
        return this.u.floatValue(260008);
    }

    public String nr() {
        return (String) this.u.objectValue(260002, String.class);
    }

    public int[] o() {
        return (int[]) this.u.objectValue(260017, int[].class);
    }

    public boolean pn() {
        return this.u.booleanValue(260005);
    }

    public Object q() {
        return this.u.objectValue(260023, Object.class);
    }

    public String qq() {
        return (String) this.u.objectValue(260024, String.class);
    }

    public String s() {
        return (String) this.u.objectValue(260014, String.class);
    }

    public int sx() {
        return this.u.intValue(260018);
    }

    public boolean t() {
        return this.u.booleanValue(260011);
    }

    public String u() {
        return (String) this.u.objectValue(260001, String.class);
    }

    public int x() {
        return this.u.intValue(260007);
    }

    public boolean z() {
        return this.u.booleanValue(260026);
    }
}
