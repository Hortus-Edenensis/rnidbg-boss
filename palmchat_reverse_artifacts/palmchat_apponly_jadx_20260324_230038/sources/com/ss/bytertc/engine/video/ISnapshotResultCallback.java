package com.ss.bytertc.engine.video;

import android.graphics.Bitmap;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ISnapshotResultCallback {
    void onTakeLocalSnapshotResult(long j, StreamIndex streamIndex, Bitmap bitmap, int i);

    void onTakeRemoteSnapshotResult(long j, RemoteStreamKey remoteStreamKey, Bitmap bitmap, int i);
}
