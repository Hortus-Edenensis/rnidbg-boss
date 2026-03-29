package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.h;
import com.bytedance.sdk.component.nr.u.my;
import com.bytedance.sdk.component.nr.u.o;
import com.bytedance.sdk.component.nr.u.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends my {
    public h u;

    public a(h hVar) {
        this.u = hVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public boolean b() {
        return this.u.b();
    }

    @Override // com.bytedance.sdk.component.nr.u.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.u.close();
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public int fx() {
        h hVar = this.u;
        if (hVar != null) {
            return hVar.fx();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public o iz() {
        return new jk(this.u.n());
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public t n() {
        h hVar = this.u;
        if (hVar == null) {
            return null;
        }
        return new t(hVar.k());
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public long nr() {
        return this.u.mv();
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String pn() {
        return this.u.pn();
    }

    public String toString() {
        return this.u.toString();
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public long u() {
        return this.u.s();
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public com.bytedance.sdk.component.nr.u.iz x() {
        return new com.bytedance.sdk.component.nr.u.iz(this.u.x().u);
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String u(String str) {
        return this.u.u(str);
    }

    @Override // com.bytedance.sdk.component.nr.u.my
    public String u(String str, String str2) {
        return this.u.u(str, str2);
    }
}
