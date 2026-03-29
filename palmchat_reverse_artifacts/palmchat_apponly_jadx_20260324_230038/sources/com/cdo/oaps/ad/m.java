package com.cdo.oaps.ad;

import com.cdo.oaps.ad.Launcher;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class m {
    public static l a(String str) {
        return Launcher.Host.MK.equals(str) ? new n() : Launcher.Host.GC.equals(str) ? new k() : Launcher.Host.MK_OP.equals(str) ? new o() : new j();
    }
}
