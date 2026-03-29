package androidx.media3.effect;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.annotation.Nullable;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultGlObjectsProvider implements GlObjectsProvider {
    private final List<EGLContext> createdEglContexts;
    private final EGLContext sharedEglContext;

    public DefaultGlObjectsProvider() {
        this(null);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public GlTextureInfo createBuffersForTexture(int i, int i2, int i3) throws GlUtil.GlException {
        return new GlTextureInfo(i, GlUtil.createFboForTexture(i), -1, i2, i3);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLContext createEglContext(EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
        EGLContext eGLContextCreateEglContext = GlUtil.createEglContext(this.sharedEglContext, eGLDisplay, i, iArr);
        this.createdEglContexts.add(eGLContextCreateEglContext);
        return eGLContextCreateEglContext;
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface createEglSurface(EGLDisplay eGLDisplay, Object obj, int i, boolean z) throws GlUtil.GlException {
        return GlUtil.createEglSurface(eGLDisplay, obj, i, z);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface createFocusedPlaceholderEglSurface(EGLContext eGLContext, EGLDisplay eGLDisplay) throws GlUtil.GlException {
        return GlUtil.createFocusedPlaceholderEglSurface(eGLContext, eGLDisplay);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public void release(EGLDisplay eGLDisplay) throws GlUtil.GlException {
        for (int i = 0; i < this.createdEglContexts.size(); i++) {
            GlUtil.destroyEglContext(eGLDisplay, this.createdEglContexts.get(i));
        }
    }

    public DefaultGlObjectsProvider(@Nullable EGLContext eGLContext) {
        this.sharedEglContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.createdEglContexts = new ArrayList();
    }
}
