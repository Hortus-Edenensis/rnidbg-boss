package com.oplus.tblplayer.upstream;

import com.oplus.tbl.exoplayer2.upstream.DataSource;
import com.oplus.tbl.exoplayer2.upstream.TransferListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface RedirectTransferListener extends TransferListener {
    void onBytesDiscarded(DataSource dataSource, long j, boolean z);

    void onOriginalTransferred(DataSource dataSource, int i, String... strArr);

    void onRedirectTransferred(DataSource dataSource, int i, String... strArr);

    void onRedirecting(DataSource dataSource, int i, String... strArr);

    void onTransferState(DataSource dataSource, boolean z);
}
