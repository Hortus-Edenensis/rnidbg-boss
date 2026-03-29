package com.oplus.tbl.exoplayer2.source;

import com.oplus.tbl.exoplayer2.source.MediaSource;
import defpackage.ll3;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public abstract class DefaultMediaSourceEventListener implements MediaSourceEventListener {
    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        ll3.a(this, i, mediaPeriodId, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        ll3.b(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        ll3.c(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        ll3.d(this, i, mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        ll3.e(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.oplus.tbl.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        ll3.f(this, i, mediaPeriodId, mediaLoadData);
    }
}
