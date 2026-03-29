package com.oplus.tblplayer.processor;

import android.annotation.SuppressLint;
import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Log;
import defpackage.yb2;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FrameInterpolationEffect implements GlEffect {
    private static final float DEFAULT_INPUT_FPS = 1.0f;
    private static final float DEFAULT_TARGET_FPS = 60.0f;
    private static final String TAG = "FrameInterpolationEffect";
    private int blendMode;
    private final float inputFrameRate;
    private final float targetFrameRate;

    @SuppressLint({HttpHeaders.RANGE})
    private FrameInterpolationEffect(int i, float f, float f2) {
        this.blendMode = i;
        this.inputFrameRate = f;
        this.targetFrameRate = f2;
    }

    public static FrameInterpolationEffect createBlendFrameInterpolationEffect(float f) {
        return new FrameInterpolationEffect(0, 1.0f, f);
    }

    public static FrameInterpolationEffect createCopyFrameInterpolationEffect(float f) {
        return new FrameInterpolationEffect(0, -3.4028235E38f, f);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    @SuppressLint({HttpHeaders.RANGE})
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        int i;
        if (this.inputFrameRate == -3.4028235E38f || (i = this.blendMode) == 0) {
            return new CopyFrameInterpolationShaderProgram(context, z, this.targetFrameRate);
        }
        if (i == 1) {
            return new BlendFrameInterpolationShaderProgram(context, z, this.targetFrameRate);
        }
        if (i == 2) {
            return new OverlayInterpolationShaderProgram(context, z, 0.5f, this.targetFrameRate);
        }
        if (i == 3) {
            return new CompositeInterpolationShaderProgram(context, z, 0.5f, this.targetFrameRate);
        }
        Log.e(TAG, "toGlShaderProgram Fail - invalid input - input frame rate: " + this.inputFrameRate + ", blend mode: " + this.blendMode);
        return null;
    }

    public static FrameInterpolationEffect createBlendFrameInterpolationEffect(int i) {
        return new FrameInterpolationEffect(i, 1.0f, 60.0f);
    }

    public static FrameInterpolationEffect createBlendFrameInterpolationEffect(int i, float f) {
        return new FrameInterpolationEffect(i, 1.0f, f);
    }
}
