package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.baidu.mapapi.map.WeightedLatLng;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Contrast implements RgbMatrix {
    private final float contrast;
    private final float[] contrastMatrix;

    public Contrast(@FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        Assertions.checkArgument(-1.0f <= f && f <= 1.0f, "Contrast needs to be in the interval [-1, 1].");
        this.contrast = f;
        float f2 = (f + 1.0f) / (1.0001f - f);
        float f3 = (1.0f - f2) * 0.5f;
        this.contrastMatrix = new float[]{f2, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f3, f3, f3, 1.0f};
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.RgbMatrix
    public float[] getMatrix(long j, boolean z) {
        return this.contrastMatrix;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.contrast == 0.0f;
    }

    @Override // androidx.media3.effect.RgbMatrix, androidx.media3.effect.GlEffect
    public /* synthetic */ BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return g1.a(this, context, z);
    }

    @Override // androidx.media3.effect.RgbMatrix, androidx.media3.effect.GlEffect
    public /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return toGlShaderProgram(context, z);
    }
}
