package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class g {
    public static GlShaderProgram a(ColorLut colorLut, Context context, boolean z) throws VideoFrameProcessingException {
        return new ColorLutShaderProgram(context, colorLut, z);
    }
}
