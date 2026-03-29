package com.oplus.tbl.exoplayer2.effect;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class DefaultGlObjectsProvider implements GlObjectsProvider {
    private final EGLContext sharedEglContext;

    public DefaultGlObjectsProvider() {
        this(null);
    }

    @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
    public GlTextureInfo createBuffersForTexture(int i, int i2, int i3) throws GlUtil.GlException {
        return new GlTextureInfo(i, GlUtil.createFboForTexture(i), -1, i2, i3);
    }

    @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
    @RequiresApi(api = 17)
    public EGLContext createEglContext(EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
        return GlUtil.createEglContext(this.sharedEglContext, eGLDisplay, i, iArr);
    }

    @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
    @RequiresApi(api = 17)
    public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, ColorInfo colorInfo, boolean z) throws GlUtil.GlException {
        return GlUtil.createEglSurface(eGLDisplay, obj, colorInfo, z);
    }

    @Override // com.oplus.tbl.exoplayer2.GlObjectsProvider
    @RequiresApi(api = 17)
    public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException {
        return GlUtil.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay);
    }

    @RequiresApi(api = 17)
    public DefaultGlObjectsProvider(@Nullable EGLContext eGLContext) {
        this.sharedEglContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
    }
}
