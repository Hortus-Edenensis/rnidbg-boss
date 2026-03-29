package com.bytedance.sdk.component.iz.fx.u.nr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.iz.gi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements gi {
    private final com.bytedance.sdk.component.iz.fx.u.nr nr;
    private final gi u;

    public b(gi giVar) {
        this(giVar, null);
    }

    public b(gi giVar, com.bytedance.sdk.component.iz.fx.u.nr nrVar) {
        this.u = giVar;
        this.nr = nrVar;
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean nr(String str) {
        return this.u.nr(str);
    }

    @Override // com.bytedance.sdk.component.iz.u
    public boolean u(String str, Bitmap bitmap) {
        return this.u.u(str, bitmap);
    }

    @Override // com.bytedance.sdk.component.iz.u
    public Bitmap u(String str) {
        return this.u.u(str);
    }

    @Override // com.bytedance.sdk.component.iz.u
    public void u(double d) {
        this.u.u(d);
    }
}
