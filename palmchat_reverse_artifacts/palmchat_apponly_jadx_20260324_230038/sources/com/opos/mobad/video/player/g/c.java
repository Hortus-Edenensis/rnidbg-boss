package com.opos.mobad.video.player.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {
    public static boolean a(int i) {
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "isRewardVideo()", "actionType=", Integer.valueOf(i));
        return i == 1;
    }

    public static boolean a(int i, String str, String str2) {
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "canShowFallbackVideo code=", Integer.valueOf(i), ", msg=", str);
        if (com.opos.mobad.mediaplayer.a.a.a(i, str2) == i) {
            return false;
        }
        com.opos.cmn.an.f.a.b("AdShowControllerUtils", "canShowFallbackVideo");
        return true;
    }
}
