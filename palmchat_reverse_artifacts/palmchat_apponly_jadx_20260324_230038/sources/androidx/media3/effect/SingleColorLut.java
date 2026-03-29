package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import defpackage.ik1;
import defpackage.zb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class SingleColorLut implements ColorLut {
    private final Bitmap lut;
    private int lutTextureId = -1;

    private SingleColorLut(Bitmap bitmap) {
        this.lut = bitmap;
    }

    public static SingleColorLut createFromBitmap(Bitmap bitmap) {
        Assertions.checkArgument(bitmap.getWidth() * bitmap.getWidth() == bitmap.getHeight(), Util.formatInvariant("LUT needs to be in a N x N^2 format, received %d x %d.", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        Assertions.checkArgument(bitmap.getConfig() == Bitmap.Config.ARGB_8888, "Color representation needs to be ARGB_8888.");
        return new SingleColorLut(bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SingleColorLut createFromCube(int[][][] iArr) {
        boolean z;
        if (iArr.length > 0) {
            int[][] iArr2 = iArr[0];
            z = iArr2.length > 0 && iArr2[0].length > 0;
        }
        Assertions.checkArgument(z, "LUT must have three dimensions.");
        int length = iArr.length;
        int[][] iArr3 = iArr[0];
        Assertions.checkArgument(length == iArr3.length && iArr.length == iArr3[0].length, Util.formatInvariant("All three dimensions of a LUT must match, received %d x %d x %d.", Integer.valueOf(iArr.length), Integer.valueOf(iArr[0].length), Integer.valueOf(iArr[0][0].length)));
        return new SingleColorLut(transformCubeIntoBitmap(iArr));
    }

    private static Bitmap transformCubeIntoBitmap(int[][][] iArr) {
        int length = iArr.length;
        int i = length * length;
        int[] iArr2 = new int[i * length];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr2[(((length * i2) + i3) * length) + i4] = iArr[i2][i3][i4];
                }
            }
        }
        return Bitmap.createBitmap(iArr2, length, i, Bitmap.Config.ARGB_8888);
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.ColorLut
    public int getLength(long j) {
        return this.lut.getWidth();
    }

    @Override // androidx.media3.effect.ColorLut
    public int getLutTextureId(long j) {
        Assertions.checkState(this.lutTextureId != -1, "The LUT has not been stored as a texture in OpenGL yet. You must to call #toGlShaderProgram() first.");
        return this.lutTextureId;
    }

    @Override // androidx.media3.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return zb2.a(this, i, i2);
    }

    @Override // androidx.media3.effect.ColorLut
    public void release() throws GlUtil.GlException {
        GlUtil.deleteTexture(this.lutTextureId);
    }

    @Override // androidx.media3.effect.ColorLut, androidx.media3.effect.GlEffect
    public BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        Assertions.checkState(!z, "HDR is currently not supported.");
        try {
            this.lutTextureId = GlUtil.createTexture(this.lut);
            return new ColorLutShaderProgram(context, this, z);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException("Could not store the LUT as a texture.", e);
        }
    }
}
