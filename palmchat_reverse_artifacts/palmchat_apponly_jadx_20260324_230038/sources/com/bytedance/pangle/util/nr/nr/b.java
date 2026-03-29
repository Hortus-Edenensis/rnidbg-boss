package com.bytedance.pangle.util.nr.nr;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private final File b;
    private u u = new u();
    private nr nr = new nr();
    private final com.bytedance.pangle.util.nr.u.fx fx = new com.bytedance.pangle.util.nr.u.fx();

    public b(String str) {
        this.b = new File(str);
    }

    public com.bytedance.pangle.util.nr.u.fx b() {
        return this.fx;
    }

    public File fx() {
        return this.b;
    }

    public nr nr() {
        return this.nr;
    }

    public u u() {
        return this.u;
    }

    public void u(u uVar) {
        this.u = uVar;
    }

    public void u(nr nrVar) {
        this.nr = nrVar;
    }
}
