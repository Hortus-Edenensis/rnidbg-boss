package com.ss.android.socialbase.downloader.iz;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class k {
    public static long nr(@NonNull List<a> list) {
        long jFx;
        long jB;
        long j = 0;
        loop0: while (true) {
            jFx = -1;
            jB = -1;
            for (a aVar : list) {
                if (jFx == -1) {
                    if (aVar.u() > 0) {
                        jFx = aVar.fx();
                        jB = aVar.b();
                    }
                } else if (aVar.fx() > jB) {
                    j += jB - jFx;
                    if (aVar.u() > 0) {
                        jFx = aVar.fx();
                        jB = aVar.b();
                    }
                } else if (aVar.b() > jB) {
                    jB = aVar.b();
                }
            }
        }
        return (jFx < 0 || jB <= jFx) ? j : j + (jB - jFx);
    }

    public static long u(@NonNull List<a> list) {
        int size = list.size();
        long jPn = 0;
        for (int i = 0; i < size; i++) {
            a aVar = list.get(i);
            if (aVar.fx() > jPn) {
                break;
            }
            if (aVar.pn() > jPn) {
                jPn = aVar.pn();
            }
        }
        return jPn;
    }
}
