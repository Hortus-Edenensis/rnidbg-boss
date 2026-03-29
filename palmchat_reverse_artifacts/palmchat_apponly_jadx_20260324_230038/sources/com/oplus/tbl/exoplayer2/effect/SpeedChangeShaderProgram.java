package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
final class SpeedChangeShaderProgram extends PassthroughShaderProgram {
    private final float speed;

    public SpeedChangeShaderProgram(float f) {
        this.speed = f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.PassthroughShaderProgram, com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        super.queueInputFrame(glObjectsProvider, glTextureInfo, (long) (j / this.speed));
    }
}
