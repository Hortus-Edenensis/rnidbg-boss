package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Size;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class r0 {
    public static Size a(GlMatrixTransformation glMatrixTransformation, int i, int i2) {
        return new Size(i, i2);
    }

    public static BaseGlShaderProgram b(GlMatrixTransformation glMatrixTransformation, Context context, boolean z) throws VideoFrameProcessingException {
        return DefaultShaderProgram.create(context, ImmutableList.of(glMatrixTransformation), ImmutableList.of(), z);
    }
}
