package com.bytedance.sdk.component.iz.b;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.iz.gi;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk extends u {
    private Bitmap fx(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        return fxVar.l().u(fxVar.mv()).u(fxVar.getMemoryCacheKey());
    }

    private Bitmap nr(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        Collection<gi> collectionU = fxVar.l().u();
        Bitmap bitmapU = null;
        if (collectionU == null) {
            return null;
        }
        Iterator<gi> it = collectionU.iterator();
        while (it.hasNext() && (bitmapU = it.next().u(fxVar.getMemoryCacheKey())) == null) {
        }
        return bitmapU;
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        int iPn = fxVar.pn();
        Bitmap bitmapNr = (iPn == 2 || iPn == 1) ? (fxVar.s() || fxVar.mv().isQueryAll()) ? nr(fxVar) : fx(fxVar) : null;
        if (bitmapNr != null) {
            fxVar.u(new mv(bitmapNr, null, null, false));
        } else if (fxVar.mv().isRawMemoryCache()) {
            fxVar.u(new l());
        } else {
            fxVar.u(new iz());
        }
    }
}
