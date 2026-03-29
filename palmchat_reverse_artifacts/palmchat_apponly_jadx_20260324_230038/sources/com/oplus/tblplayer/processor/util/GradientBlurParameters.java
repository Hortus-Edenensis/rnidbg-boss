package com.oplus.tblplayer.processor.util;

import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class GradientBlurParameters {
    public static final GradientBlurParameters DEFAULT = new GradientBlurParameters(-1.0f, -1.0f, -1, -1);
    public float endBlurriness;
    public long endTimeUs;
    public float startBlurriness;
    public long startTimeUs;

    public GradientBlurParameters(float f, float f2, long j, long j2) {
        Assertions.checkArgument(j2 >= j);
        this.startBlurriness = f;
        this.endBlurriness = f2;
        this.startTimeUs = C.msToUs(j);
        this.endTimeUs = C.msToUs(j2);
    }
}
