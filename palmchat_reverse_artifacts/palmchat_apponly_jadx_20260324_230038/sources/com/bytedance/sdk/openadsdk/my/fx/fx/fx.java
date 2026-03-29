package com.bytedance.sdk.openadsdk.my.fx.fx;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import defpackage.ll7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public PluginValueSet u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final com.bytedance.sdk.openadsdk.my.b u = com.bytedance.sdk.openadsdk.my.b.u();

        public u nr(double d) {
            this.u.u(262002, Double.valueOf(d));
            return this;
        }

        public u u(double d) {
            this.u.u(262001, Double.valueOf(d));
            return this;
        }

        public fx u() {
            return new fx(this.u.nr());
        }
    }

    public fx(SparseArray<Object> sparseArray) {
        this.u = ll7.j(sparseArray).a();
    }

    public double nr() {
        return this.u.doubleValue(262002);
    }

    public double u() {
        return this.u.doubleValue(262001);
    }
}
