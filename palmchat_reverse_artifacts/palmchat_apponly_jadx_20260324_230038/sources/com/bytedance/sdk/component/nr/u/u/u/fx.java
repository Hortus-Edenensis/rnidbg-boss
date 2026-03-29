package com.bytedance.sdk.component.nr.u.u.u;

import com.bytedance.sdk.component.fx.nr.my;
import com.bytedance.sdk.component.fx.nr.qq;
import com.bytedance.sdk.component.nr.u.mv;
import com.bytedance.sdk.component.nr.u.s;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends my {
    private com.bytedance.sdk.component.nr.u.u.u.u nr;

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements com.bytedance.sdk.component.nr.u.nr {
        com.bytedance.sdk.component.fx.nr.pn u;

        public u(com.bytedance.sdk.component.fx.nr.pn pnVar) {
            this.u = pnVar;
        }

        @Override // com.bytedance.sdk.component.nr.u.nr
        public boolean b() {
            return this.u.b();
        }

        @Override // com.bytedance.sdk.component.nr.u.nr
        public void fx() {
            this.u.fx();
        }

        @Override // com.bytedance.sdk.component.nr.u.nr
        public com.bytedance.sdk.component.nr.u.my nr() throws IOException {
            return null;
        }

        /* JADX INFO: renamed from: pn, reason: merged with bridge method [inline-methods] */
        public com.bytedance.sdk.component.nr.u.nr clone() {
            return null;
        }

        @Override // com.bytedance.sdk.component.nr.u.nr
        public void u(com.bytedance.sdk.component.nr.u.fx fxVar) {
        }

        @Override // com.bytedance.sdk.component.nr.u.nr
        public s u() {
            return new n(this.u.u());
        }
    }

    public fx(com.bytedance.sdk.component.nr.u.u.u.u uVar) {
        this.nr = uVar;
    }

    @Override // com.bytedance.sdk.component.fx.nr.my
    public void u(com.bytedance.sdk.component.fx.nr.pn pnVar, InetSocketAddress inetSocketAddress, Proxy proxy, qq qqVar, IOException iOException) {
        super.u(pnVar, inetSocketAddress, proxy, qqVar, iOException);
        com.bytedance.sdk.component.nr.u.u.u.u uVar = this.nr;
        if (uVar != null) {
            uVar.u(new u(pnVar), inetSocketAddress, proxy, u(qqVar), iOException);
        }
    }

    @Override // com.bytedance.sdk.component.fx.nr.my
    public void u(com.bytedance.sdk.component.fx.nr.pn pnVar, IOException iOException) {
        super.u(pnVar, iOException);
        com.bytedance.sdk.component.nr.u.u.u.u uVar = this.nr;
        if (uVar != null) {
            uVar.u(new u(pnVar), iOException);
        }
    }

    private mv u(qq qqVar) {
        if (qqVar != null) {
            try {
                return mv.u(qqVar.toString());
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
