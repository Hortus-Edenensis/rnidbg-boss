package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.dw;
import com.bytedance.sdk.component.fx.nr.rh;
import com.bytedance.sdk.component.nr.u.o;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends o {
    rh u;

    public jk(rh rhVar) {
        this.u = rhVar;
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public byte[] b() {
        try {
            return this.u.pn();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rh rhVar = this.u;
        if (rhVar != null) {
            rhVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public InputStream fx() {
        rh rhVar = this.u;
        if (rhVar != null) {
            return rhVar.b();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public String nr() {
        try {
            return this.u.iz();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public com.bytedance.sdk.component.nr.u.jk pn() {
        dw dwVarU;
        rh rhVar = this.u;
        if (rhVar == null || (dwVarU = rhVar.u()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.nr.u.jk(dwVarU.toString(), dwVarU.u(), dwVarU.nr(), dwVarU.fx() != null ? dwVarU.fx().name() : null);
    }

    @Override // com.bytedance.sdk.component.nr.u.o
    public long u() {
        rh rhVar = this.u;
        if (rhVar != null) {
            return rhVar.nr();
        }
        return -1L;
    }
}
