package com.bytedance.sdk.component.fx.u;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class my {
    static long nr;
    static k u;

    private my() {
    }

    public static k u() {
        synchronized (my.class) {
            k kVar = u;
            if (kVar == null) {
                return new k();
            }
            u = kVar.iz;
            kVar.iz = null;
            nr -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return kVar;
        }
    }

    public static void u(k kVar) {
        if (kVar.iz == null && kVar.x == null) {
            if (kVar.b) {
                return;
            }
            synchronized (my.class) {
                long j = nr;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                nr = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                kVar.iz = u;
                kVar.fx = 0;
                kVar.nr = 0;
                u = kVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
