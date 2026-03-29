package androidx.media3.effect;

import android.util.Pair;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import defpackage.la4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public abstract class TextureOverlay {
    private static final float[] IDENTITY_MATRIX = GlUtil.create4x4IdentityMatrix();

    public OverlaySettings getOverlaySettings(long j) {
        return new OverlaySettings() { // from class: androidx.media3.effect.TextureOverlay.1
            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ float getAlphaScale() {
                return la4.a(this);
            }

            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ Pair getBackgroundFrameAnchor() {
                return la4.b(this);
            }

            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ float getHdrLuminanceMultiplier() {
                return la4.c(this);
            }

            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ Pair getOverlayFrameAnchor() {
                return la4.d(this);
            }

            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ float getRotationDegrees() {
                return la4.e(this);
            }

            @Override // androidx.media3.common.OverlaySettings
            public /* synthetic */ Pair getScale() {
                return la4.f(this);
            }
        };
    }

    public abstract int getTextureId(long j) throws VideoFrameProcessingException;

    public abstract Size getTextureSize(long j);

    public float[] getVertexTransformation(long j) {
        return IDENTITY_MATRIX;
    }

    public void release() throws VideoFrameProcessingException {
    }

    public void configure(Size size) {
    }
}
