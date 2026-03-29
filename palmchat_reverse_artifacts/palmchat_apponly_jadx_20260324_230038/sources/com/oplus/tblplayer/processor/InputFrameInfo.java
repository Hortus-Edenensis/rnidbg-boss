package com.oplus.tblplayer.processor;

import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class InputFrameInfo {
    private static final String TAG = "TblInputFrameInfo";
    public Size originSize;
    public long presentationTimeUs;
    public GlTextureInfo textureInfo;

    public InputFrameInfo(GlTextureInfo glTextureInfo, long j) {
        this.textureInfo = glTextureInfo;
        this.presentationTimeUs = j;
        this.originSize = new Size(glTextureInfo.width, glTextureInfo.height);
    }

    public void release() throws GlUtil.GlException {
        this.textureInfo.release();
    }
}
