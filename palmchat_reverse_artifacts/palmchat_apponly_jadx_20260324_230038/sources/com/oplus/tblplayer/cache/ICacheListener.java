package com.oplus.tblplayer.cache;

import com.oplus.tblplayer.misc.MediaUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface ICacheListener {
    void onCacheCancel(MediaUrl mediaUrl);

    void onCacheError(MediaUrl mediaUrl, int i, String str);

    void onCacheFinish(MediaUrl mediaUrl, long j, long j2, long j3, long j4);

    void onCacheStart(MediaUrl mediaUrl);
}
