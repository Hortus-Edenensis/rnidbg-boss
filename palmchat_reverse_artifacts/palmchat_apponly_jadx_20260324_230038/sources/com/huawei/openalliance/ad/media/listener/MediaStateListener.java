package com.huawei.openalliance.ad.media.listener;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface MediaStateListener {
    void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i);

    void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i);

    void onProgress(int i, int i2);
}
