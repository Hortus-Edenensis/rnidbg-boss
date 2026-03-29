package com.bytedance.sdk.component.nr.u.nr;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class x {
    static long nr;
    static iz u;

    private x() {
    }

    public static iz u() {
        synchronized (x.class) {
            iz izVar = u;
            if (izVar == null) {
                return new iz();
            }
            u = izVar.iz;
            izVar.iz = null;
            nr -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return izVar;
        }
    }

    public static void u(iz izVar) {
        if (izVar.iz == null && izVar.x == null) {
            if (izVar.b) {
                return;
            }
            synchronized (x.class) {
                long j = nr;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                nr = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                izVar.iz = u;
                izVar.fx = 0;
                izVar.nr = 0;
                u = izVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
