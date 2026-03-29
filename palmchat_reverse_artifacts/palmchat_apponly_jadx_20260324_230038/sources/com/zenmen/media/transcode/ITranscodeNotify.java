package com.zenmen.media.transcode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITranscodeNotify {
    void onTranscodeFailure(int i);

    void onTranscodeFinish(long j);

    void onTranscodePercent(int i);
}
