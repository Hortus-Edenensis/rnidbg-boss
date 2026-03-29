package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface GlEffect extends Effect {
    boolean isNoOp(int i, int i2);

    GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
