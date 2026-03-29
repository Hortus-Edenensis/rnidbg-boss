package com.bytedance.sdk.component.panglearmor;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    private boolean b;
    private String fx;
    private String nr;
    private n pn;
    private Context u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private final String fx;
        private final String nr;
        private final Context u;
        private boolean b = false;
        private n pn = null;

        public u(Context context, String str, String str2) {
            this.u = context;
            this.fx = str2;
            this.nr = str;
        }

        public void u(n nVar) {
            this.pn = nVar;
        }

        public u u(boolean z) {
            this.b = z;
            return this;
        }

        public x u() {
            x xVar = new x();
            xVar.u = this.u;
            xVar.nr = this.nr;
            xVar.fx = this.fx;
            xVar.pn = this.pn;
            xVar.b = this.b;
            return xVar;
        }
    }

    public n b() {
        return this.pn;
    }

    public boolean fx() {
        return this.b;
    }

    public String nr() {
        return this.nr;
    }

    public Context u() {
        return this.u;
    }
}
