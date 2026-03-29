package com.oplus.tblplayer.processor;

import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class InputFrameInfoPair {
    private static final String TAG = "TblInputFrameInfoPair";
    public InputFrameInfo alphaOverlayInput;
    public InputFrameInfo videoInput;

    public InputFrameInfoPair(InputFrameInfo inputFrameInfo, InputFrameInfo inputFrameInfo2) {
        this.videoInput = inputFrameInfo;
        this.alphaOverlayInput = inputFrameInfo2;
    }

    public void release() throws GlUtil.GlException {
        Assertions.checkStateNotNull(this.videoInput, "TblInputFrameInfoPair video input is null, no need to release.");
        this.videoInput.release();
        Assertions.checkStateNotNull(this.alphaOverlayInput, "TblInputFrameInfoPair alpha input is null, no need to release.");
        this.alphaOverlayInput.release();
    }
}
