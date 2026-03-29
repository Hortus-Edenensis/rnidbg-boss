package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5903a = new e() { // from class: lf3
        @Override // com.google.android.exoplayer2.mediacodec.e
        public final List getDecoderInfos(String str, boolean z, boolean z2) {
            return MediaCodecUtil.t(str, z, z2);
        }
    };

    List<d> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
