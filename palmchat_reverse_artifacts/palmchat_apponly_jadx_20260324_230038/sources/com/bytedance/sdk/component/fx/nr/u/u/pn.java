package com.bytedance.sdk.component.fx.nr.u.u;

import com.bytedance.sdk.component.fx.u.sx;
import com.bytedance.sdk.component.fx.u.x;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class pn extends x {
    private boolean u;

    public pn(sx sxVar) {
        super(sxVar);
    }

    @Override // com.bytedance.sdk.component.fx.u.x, com.bytedance.sdk.component.fx.u.sx
    public void a_(com.bytedance.sdk.component.fx.u.fx fxVar, long j) throws IOException {
        if (this.u) {
            fxVar.n(j);
            return;
        }
        try {
            super.a_(fxVar, j);
        } catch (IOException e) {
            this.u = true;
            u(e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.x, com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.u) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.u = true;
            u(e);
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.x, com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
    public void flush() throws IOException {
        if (this.u) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.u = true;
            u(e);
        }
    }

    public void u(IOException iOException) {
    }
}
