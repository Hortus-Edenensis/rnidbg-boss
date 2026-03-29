package com.opos.exoplayer.core;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {
    public static v a(Context context, com.opos.exoplayer.core.c.h hVar) {
        return a(new DefaultRenderersFactory(context), hVar);
    }

    public static v a(t tVar, com.opos.exoplayer.core.c.h hVar) {
        return a(tVar, hVar, new e());
    }

    public static v a(t tVar, com.opos.exoplayer.core.c.h hVar, l lVar) {
        return new v(tVar, hVar, lVar);
    }
}
