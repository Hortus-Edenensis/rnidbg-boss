package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.yb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class FrameDropEffect implements GlEffect {
    private final float inputFrameRate;
    private final float targetFrameRate;

    private FrameDropEffect(float f, float f2) {
        this.inputFrameRate = f;
        this.targetFrameRate = f2;
    }

    public static FrameDropEffect createDefaultFrameDropEffect(float f) {
        return new FrameDropEffect(-3.4028235E38f, f);
    }

    public static FrameDropEffect createSimpleFrameDropEffect(float f, float f2) {
        return new FrameDropEffect(f, f2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        float f = this.inputFrameRate;
        return f == -3.4028235E38f ? new DefaultFrameDroppingShaderProgram(context, z, this.targetFrameRate) : new SimpleFrameDroppingShaderProgram(f, this.targetFrameRate);
    }
}
