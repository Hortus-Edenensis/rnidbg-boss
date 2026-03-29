package com.kwad.framework.filedownloader.services;

import android.content.Intent;
import com.lantern.auth.server.WkParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.yn() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra(WkParams.MODEL, cVar);
        com.kwad.framework.filedownloader.f.c.Bd().sendBroadcast(intent);
    }
}
