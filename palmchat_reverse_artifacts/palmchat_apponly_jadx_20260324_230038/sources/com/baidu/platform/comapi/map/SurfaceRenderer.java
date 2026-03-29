package com.baidu.platform.comapi.map;

import android.view.SurfaceHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface SurfaceRenderer {
    void onDrawFrame(Object obj);

    void onSurfaceChanged(int i, int i2);

    void onSurfaceCreated(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    void onSurfaceDestroyed(SurfaceHolder surfaceHolder);
}
