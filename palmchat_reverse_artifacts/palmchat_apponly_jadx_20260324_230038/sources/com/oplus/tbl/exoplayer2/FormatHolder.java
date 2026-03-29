package com.oplus.tbl.exoplayer2;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.drm.DrmSession;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FormatHolder {

    @Nullable
    public DrmSession drmSession;

    @Nullable
    public Format format;

    public void clear() {
        this.drmSession = null;
        this.format = null;
    }
}
