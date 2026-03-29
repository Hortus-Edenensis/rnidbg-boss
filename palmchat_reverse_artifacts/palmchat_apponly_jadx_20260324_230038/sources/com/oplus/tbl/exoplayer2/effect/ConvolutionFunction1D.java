package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface ConvolutionFunction1D {
    float domainEnd();

    float domainStart();

    float value(float f);

    float width();
}
