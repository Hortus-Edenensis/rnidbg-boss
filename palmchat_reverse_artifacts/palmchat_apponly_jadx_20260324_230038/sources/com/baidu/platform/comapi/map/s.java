package com.baidu.platform.comapi.map;

import android.content.Context;
import android.view.SurfaceView;
import com.baidu.platform.comapi.util.EglConfigUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s {

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        OPENGL_ES,
        VULKAN,
        AUTO
    }

    public static r a(SurfaceView surfaceView, a aVar, boolean z, Context context) {
        int i;
        int i2;
        e eVar = new e(surfaceView);
        eVar.a(3);
        if (z) {
            i = 1;
            i2 = 4;
        } else {
            i = 0;
            i2 = 0;
        }
        try {
            if (EglConfigUtils.isSupportConfig(8, 8, 8, 8, 24, 8, i, i2)) {
                eVar.a(8, 8, 8, 8, 24, 8, i, i2);
            } else {
                eVar.a(true);
            }
        } catch (IllegalArgumentException unused) {
            eVar.a(true);
        }
        eVar.b(true);
        return eVar;
    }
}
