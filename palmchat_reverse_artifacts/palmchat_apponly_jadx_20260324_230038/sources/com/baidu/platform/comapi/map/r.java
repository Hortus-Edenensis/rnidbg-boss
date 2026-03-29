package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import com.baidu.platform.comapi.map.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
interface r extends SurfaceHolder.Callback2 {
    Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config);

    int getDebugFlags();

    int getFPS();

    int getRenderMode();

    s.a getViewType();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onPause();

    void onResume();

    void queueEvent(Runnable runnable);

    void requestRender();

    void setDebugFlags(int i);

    void setFPS(int i);

    void setRenderMode(int i);

    void setRenderer(SurfaceRenderer surfaceRenderer);
}
