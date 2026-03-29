package com.bytedance.sdk.component.iz.fx.u.nr;

import com.bytedance.sdk.component.iz.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements d {
    private com.bytedance.sdk.component.iz.fx.u.fx<String, byte[]> fx;
    private int nr;
    private int u;

    public fx(int i, int i2) {
        this.nr = i;
        this.u = i2;
        this.fx = new com.bytedance.sdk.component.iz.fx.u.fx<String, byte[]>(i) { // from class: com.bytedance.sdk.component.iz.fx.u.nr.fx.1
            @Override // com.bytedance.sdk.component.iz.fx.u.fx
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int nr(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean nr(String str) {
        return this.fx.u(str) != null;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean u(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.fx.u(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public byte[] u(String str) {
        return this.fx.u(str);
    }

    @Override // com.bytedance.sdk.component.iz.u
    public void u(double d) {
        this.fx.u((int) (((double) this.nr) * d));
    }
}
