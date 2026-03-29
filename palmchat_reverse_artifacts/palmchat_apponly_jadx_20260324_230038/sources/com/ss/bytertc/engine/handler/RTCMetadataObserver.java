package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.IMetadataObserver;
import com.ss.bytertc.engine.engineimpl.RTCVideoImpl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCMetadataObserver {
    private static final String TAG = "RtcMetadataObserver";
    private WeakReference<RTCVideoImpl> mRtcVideoImpl;

    public RTCMetadataObserver(RTCVideoImpl rTCVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rTCVideoImpl);
    }

    @CalledByNative
    public void onMetadataReceived(byte[] bArr, String str, long j) {
        RTCVideoImpl rTCVideoImpl;
        IMetadataObserver metadataObserver;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCVideoImpl = weakReference.get()) == null || (metadataObserver = rTCVideoImpl.getMetadataObserver()) == null) {
            return;
        }
        metadataObserver.onMetadataReceived(bArr, str, j);
    }

    @CalledByNative
    public byte[] onReadyToSendMetadata(long j) {
        RTCVideoImpl rTCVideoImpl;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        IMetadataObserver metadataObserver = (weakReference == null || (rTCVideoImpl = weakReference.get()) == null) ? null : rTCVideoImpl.getMetadataObserver();
        if (metadataObserver != null) {
            return metadataObserver.onReadyToSendMetadata(j);
        }
        return null;
    }
}
