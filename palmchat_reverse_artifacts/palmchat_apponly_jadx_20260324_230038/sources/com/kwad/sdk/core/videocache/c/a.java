package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static f aQv;

    public static f b(Context context, int i, int i2) {
        f fVar = aQv;
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context, i, i2);
        aQv = fVarC;
        return fVarC;
    }

    private static f c(Context context, int i, int i2) {
        return new f.a(context).aJ(536870912L).ef(i).eg(i2).Mg();
    }

    public static f ca(Context context) {
        return b(context, 0, 0);
    }
}
