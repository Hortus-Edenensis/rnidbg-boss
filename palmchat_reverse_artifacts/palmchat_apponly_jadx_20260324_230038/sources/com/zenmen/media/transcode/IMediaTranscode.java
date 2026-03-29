package com.zenmen.media.transcode;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IMediaTranscode {
    void getBitmap(Bitmap bitmap);

    void getFrameAtTime(Bitmap bitmap, long j);

    int getPercent();

    long getSrcDuration();

    int getVideoHeight();

    int getVideoWidth();

    void setBlendPic(Bitmap bitmap);

    int setDstUrl(String str, int i);

    int setSrcUrl(String str, CodecFormatCheckListener codecFormatCheckListener, int i);

    int setTimeRange(long j, long j2);

    int setVideoPropo(int i, int i2, int i3);

    int start(boolean z);

    void stop();
}
