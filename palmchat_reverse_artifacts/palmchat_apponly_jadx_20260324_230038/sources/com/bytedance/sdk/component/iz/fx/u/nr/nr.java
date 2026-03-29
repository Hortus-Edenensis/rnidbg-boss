package com.bytedance.sdk.component.iz.fx.u.nr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.iz.gi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements gi {
    private com.bytedance.sdk.component.iz.fx.u.fx<String, Bitmap> fx;
    private int nr;
    private int u;

    public nr(int i, int i2) {
        this.nr = i;
        this.u = i2;
        this.fx = new com.bytedance.sdk.component.iz.fx.u.fx<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.iz.fx.u.nr.nr.1
            @Override // com.bytedance.sdk.component.iz.fx.u.fx
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int nr(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return nr.u(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean nr(String str) {
        return this.fx.u(str) != null;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean u(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.fx.u(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public Bitmap u(String str) {
        return this.fx.u(str);
    }

    @Override // com.bytedance.sdk.component.iz.u
    public void u(double d) {
        this.fx.u((int) (((double) this.nr) * d));
    }

    public static int u(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
