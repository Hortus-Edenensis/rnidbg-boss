package com.ss.android.socialbase.downloader.impls;

import androidx.media3.common.C;
import com.ss.android.socialbase.downloader.downloader.bg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class jk implements bg {
    @Override // com.ss.android.socialbase.downloader.downloader.bg
    public long u(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
