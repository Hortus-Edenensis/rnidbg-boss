package com.bytedance.sdk.component.fx.nr;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gi {
    public static gi u(dw dwVar, String str) {
        Charset charset = com.bytedance.sdk.component.fx.nr.u.fx.pn;
        if (dwVar != null) {
            Charset charsetFx = dwVar.fx();
            if (charsetFx == null) {
                dwVar = dw.u(dwVar + "; charset=utf-8");
            } else {
                charset = charsetFx;
            }
        }
        return u(dwVar, str.getBytes(charset));
    }

    public long nr() throws IOException {
        return -1L;
    }

    public abstract dw u();

    public abstract void u(com.bytedance.sdk.component.fx.u.b bVar) throws IOException;

    public static gi u(dw dwVar, byte[] bArr) {
        return u(dwVar, bArr, 0, bArr.length);
    }

    public static gi u(final dw dwVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(bArr.length, i, i2);
            return new gi() { // from class: com.bytedance.sdk.component.fx.nr.gi.1
                @Override // com.bytedance.sdk.component.fx.nr.gi
                public long nr() {
                    return i2;
                }

                @Override // com.bytedance.sdk.component.fx.nr.gi
                public dw u() {
                    return dwVar;
                }

                @Override // com.bytedance.sdk.component.fx.nr.gi
                public void u(com.bytedance.sdk.component.fx.u.b bVar) throws IOException {
                    bVar.fx(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
