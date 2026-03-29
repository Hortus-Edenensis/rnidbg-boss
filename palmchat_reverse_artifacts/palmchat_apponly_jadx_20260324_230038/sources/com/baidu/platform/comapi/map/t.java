package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class t extends SurfaceView implements SurfaceHolder.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected r f4217a;

    public t(Context context) {
        super(context);
        a(context, s.a.OPENGL_ES, true);
    }

    public void a(Context context, s.a aVar, boolean z) {
        if (this.f4217a != null) {
            return;
        }
        this.f4217a = a(aVar, z, context);
        getHolder().addCallback(this);
    }

    public Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return this.f4217a.captureImageFromSurface(i, i2, i3, i4, obj, config);
    }

    public int getDebugFlags() {
        return this.f4217a.getDebugFlags();
    }

    public r getRenderControl() {
        return this.f4217a;
    }

    public int getRenderMode() {
        return this.f4217a.getRenderMode();
    }

    public s.a getViewType() {
        r rVar = this.f4217a;
        return rVar != null ? rVar.getViewType() : s.a.AUTO;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4217a.onAttachedToWindow();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        this.f4217a.onDetachedFromWindow();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.f4217a.onPause();
    }

    public void onResume() {
        this.f4217a.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.f4217a.queueEvent(runnable);
    }

    public void requestRender() {
        this.f4217a.requestRender();
    }

    public void setDebugFlags(int i) {
        this.f4217a.setDebugFlags(i);
    }

    public void setRenderMode(int i) {
        this.f4217a.setRenderMode(i);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        this.f4217a.setRenderer(surfaceRenderer);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f4217a.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f4217a.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4217a.surfaceDestroyed(surfaceHolder);
    }

    @TargetApi(26)
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        this.f4217a.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, s.a.OPENGL_ES, true);
    }

    public t(Context context, s.a aVar) {
        super(context);
        a(context, aVar, true);
    }

    public r a(s.a aVar, boolean z, Context context) {
        return s.a(this, aVar, z, context);
    }

    public t(Context context, s.a aVar, boolean z) {
        super(context);
        a(context, aVar, z);
    }

    public t(Context context, boolean z) {
        super(context);
        a(context, s.a.OPENGL_ES, z);
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}
