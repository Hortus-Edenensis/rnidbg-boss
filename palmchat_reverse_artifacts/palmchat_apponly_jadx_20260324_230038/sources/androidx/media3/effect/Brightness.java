package androidx.media3.effect;

import android.content.Context;
import android.opengl.Matrix;
import androidx.annotation.FloatRange;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import com.baidu.mapapi.map.WeightedLatLng;
import defpackage.ik1;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class Brightness implements RgbMatrix {
    private final float[] rgbMatrix;

    public Brightness(@FloatRange(from = -1.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        Assertions.checkArgument(f >= -1.0f && f <= 1.0f, "brightness value outside of range from -1f to 1f, inclusive");
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.rgbMatrix = fArrCreate4x4IdentityMatrix;
        Matrix.translateM(fArrCreate4x4IdentityMatrix, 0, f, f, f);
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.RgbMatrix
    public float[] getMatrix(long j, boolean z) {
        Assertions.checkArgument(!z, "HDR is not supported.");
        return this.rgbMatrix;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return Arrays.equals(this.rgbMatrix, GlUtil.create4x4IdentityMatrix());
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
