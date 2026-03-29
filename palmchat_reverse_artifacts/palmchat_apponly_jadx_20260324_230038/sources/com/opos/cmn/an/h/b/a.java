package com.opos.cmn.an.h.b;

import android.content.Context;
import android.media.AudioManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AudioManager f7789a;

    public static AudioManager a(Context context) {
        if (f7789a == null && context != null) {
            f7789a = (AudioManager) context.getApplicationContext().getSystemService("audio");
        }
        return f7789a;
    }

    public static int b(Context context) {
        try {
            AudioManager audioManagerA = a(context);
            if (audioManagerA != null) {
                return audioManagerA.getStreamVolume(3);
            }
            return 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AudioMgrTool", "", e);
            return 0;
        }
    }
}
