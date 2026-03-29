package com.bytedance.sdk.openadsdk.my.fx.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public final PluginValueSet nr;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final ll7 u = ll7.b();

        public u b(boolean z) {
            this.u.i(262106, z);
            return this;
        }

        public u fx(boolean z) {
            this.u.i(262104, z);
            return this;
        }

        public u iz(boolean z) {
            this.u.i(262110, z);
            return this;
        }

        public u nr(boolean z) {
            this.u.i(262103, z);
            return this;
        }

        public u pn(boolean z) {
            this.u.i(262108, z);
            return this;
        }

        public u u(boolean z) {
            this.u.i(262101, z);
            return this;
        }

        public u x(boolean z) {
            this.u.i(262111, z);
            return this;
        }

        public u b(String str) {
            this.u.h(262112, str);
            return this;
        }

        public u fx(String str) {
            this.u.h(262109, str);
            return this;
        }

        public u nr(String str) {
            this.u.h(262107, str);
            return this;
        }

        public u u(fx fxVar) {
            this.u.g(262102, fxVar);
            return this;
        }

        public u u(String str) {
            this.u.h(262105, str);
            return this;
        }

        public b u() {
            return new b(this.u.a().sparseArray());
        }
    }

    public b(SparseArray<Object> sparseArray) {
        this.nr = ll7.j(sparseArray).a();
    }

    public fx a() {
        SparseArray sparseArray = (SparseArray) this.nr.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new fx(sparseArray);
        }
        return null;
    }

    public boolean b() {
        return this.nr.booleanValue(262106);
    }

    public boolean fx() {
        return this.nr.booleanValue(262104);
    }

    public boolean iz() {
        return this.nr.booleanValue(262110);
    }

    public String jk() {
        return (String) this.nr.objectValue(262105, String.class);
    }

    public Map<String, Object> k() {
        return (Map) this.nr.objectValue(262119, Map.class);
    }

    public String l() {
        return (String) this.nr.objectValue(262109, String.class);
    }

    public boolean mv() {
        return this.nr.booleanValue(262121);
    }

    public boolean n() {
        return this.nr.booleanValue(262120);
    }

    public boolean nr() {
        return this.nr.booleanValue(262103);
    }

    public boolean pn() {
        return this.nr.booleanValue(262108);
    }

    public String s() {
        return (String) this.nr.objectValue(262112, String.class);
    }

    public String t() {
        return (String) this.nr.objectValue(262107, String.class);
    }

    public boolean u() {
        return this.nr.booleanValue(262101);
    }

    public boolean x() {
        return this.nr.booleanValue(262111);
    }
}
