package com.opos.mobad.video.player.g;

import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10364a = true;

    public static void a(boolean z) {
        f10364a = z;
    }

    public static boolean a(AdItemData adItemData) {
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "sPlayRemindAtCellular=" + f10364a);
        boolean z = true;
        try {
            if (!f10364a) {
                z = false;
            } else if (adItemData != null && !adItemData.v()) {
                f10364a = false;
                z = false;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WifiPlayUtils", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "checkPlayConfirm=" + z);
        return z;
    }
}
