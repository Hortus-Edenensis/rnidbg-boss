package com.bytedance.sdk.component.adexpress.dynamic.fx;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public float nr;
    public float u;

    public a(float f, float f2) {
        this.u = f;
        this.nr = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (Float.compare(aVar.u, this.u) == 0 && Float.compare(aVar.nr, this.nr) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.u), Float.valueOf(this.nr)});
    }
}
