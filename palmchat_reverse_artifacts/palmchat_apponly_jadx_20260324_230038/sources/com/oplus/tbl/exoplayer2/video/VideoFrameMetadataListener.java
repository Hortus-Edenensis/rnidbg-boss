package com.oplus.tbl.exoplayer2.video;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long j, long j2, Format format, @Nullable MediaFormat mediaFormat);
}
