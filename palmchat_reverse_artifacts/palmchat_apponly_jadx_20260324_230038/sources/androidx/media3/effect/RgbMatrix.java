package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface RgbMatrix extends GlEffect {
    float[] getMatrix(long j, boolean z);

    @Override // androidx.media3.effect.GlEffect
    BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;

    @Override // androidx.media3.effect.GlEffect
    /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
