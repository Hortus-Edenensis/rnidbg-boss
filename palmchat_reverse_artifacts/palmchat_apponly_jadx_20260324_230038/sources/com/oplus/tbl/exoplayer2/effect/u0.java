package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.google.common.collect.ImmutableList;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class u0 {
    public static BaseGlShaderProgram a(RgbMatrix rgbMatrix, Context context, boolean z) throws VideoFrameProcessingException {
        return DefaultShaderProgram.create(context, ImmutableList.of(), ImmutableList.of(rgbMatrix), z);
    }
}
