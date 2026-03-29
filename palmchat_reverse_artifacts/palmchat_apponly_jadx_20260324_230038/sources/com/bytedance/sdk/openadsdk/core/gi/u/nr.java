package com.bytedance.sdk.openadsdk.core.gi.u;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private List<Object> b;
    private Bitmap fx;
    private byte[] nr;
    private Map<String, String> pn;
    int u;

    public nr(byte[] bArr, int i) {
        this.fx = null;
        this.b = null;
        this.pn = null;
        this.nr = bArr;
        this.u = i;
    }

    public boolean b() {
        if (this.fx != null) {
            return true;
        }
        byte[] bArr = this.nr;
        return bArr != null && bArr.length > 0;
    }

    public byte[] fx() {
        try {
            if (this.nr == null) {
                this.nr = b.nr(this.fx);
            }
        } catch (OutOfMemoryError unused) {
        }
        return this.nr;
    }

    public int nr() {
        return this.u;
    }

    public boolean pn() {
        byte[] bArr = this.nr;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public Bitmap u() {
        return this.fx;
    }

    public nr(Bitmap bitmap, int i) {
        this.nr = null;
        this.b = null;
        this.pn = null;
        this.fx = bitmap;
        this.u = i;
    }
}
