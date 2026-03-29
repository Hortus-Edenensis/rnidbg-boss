package com.bytedance.sdk.component.x;

import android.content.Context;
import com.bytedance.sdk.component.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private volatile boolean b;
        private volatile int fx;
        private volatile int iz;
        private volatile String nr;
        private volatile boolean pn;
        private volatile Context u;

        private com.bytedance.sdk.component.b.nr.fx fx() {
            com.bytedance.sdk.component.b.nr.fx fxVarU = com.bytedance.sdk.component.x.nr.u.u.u(this.u, this.nr, this.b, this.iz);
            this.pn = true;
            if (fxVarU != null) {
                return fxVarU;
            }
            this.pn = false;
            return nr();
        }

        public u nr(int i) {
            this.iz = i;
            return this;
        }

        public u u(Context context) {
            if (context == null) {
                return this;
            }
            this.u = context.getApplicationContext();
            fx.u(this.u);
            return this;
        }

        private com.bytedance.sdk.component.b.nr.fx nr() {
            return this.b ? com.bytedance.sdk.component.x.fx.u.u.u(this.nr) : ((a) com.bytedance.sdk.openadsdk.ats.fx.u("kv_store_factory")).get(this.nr);
        }

        public u u(String str) {
            this.nr = str;
            return this;
        }

        public u u(int i) {
            this.fx = i;
            return this;
        }

        public u u(boolean z) {
            this.b = z;
            return this;
        }

        public com.bytedance.sdk.component.b.nr.fx u() {
            if (this.fx != 2) {
                return nr();
            }
            return fx();
        }
    }
}
