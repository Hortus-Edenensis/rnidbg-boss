package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ProcessingGlShaderProgram {
    boolean isColorComponentsSupported(boolean z);

    void setWorkingColorInfo(ColorInfo colorInfo, ColorInfo colorInfo2) throws VideoFrameProcessingException;
}
