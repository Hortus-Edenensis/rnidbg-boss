package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.engineimpl.RTCVideoImpl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCExternalVideoEncoderEventHandler {
    private static final String TAG = "RTCExternalVideoEncoderEventHandler";
    private WeakReference<RTCVideoImpl> mRtcVideoImpl;

    public RTCExternalVideoEncoderEventHandler(RTCVideoImpl rTCVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rTCVideoImpl);
    }

    @CalledByNative
    public void OnActiveVideoLayer(int i, int i2, boolean z) {
        RTCVideoImpl rTCVideoImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        RTCVideoImpl rTCVideoImpl2;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler2;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference != null && (rTCVideoImpl2 = weakReference.get()) != null && (externalVideoEncoderEventHandler2 = rTCVideoImpl2.getExternalVideoEncoderEventHandler()) != null) {
            externalVideoEncoderEventHandler2.onActiveVideoLayer(StreamIndex.fromId(i), i2, z);
        }
        WeakReference<RTCVideoImpl> weakReference2 = this.mRtcVideoImpl;
        if (weakReference2 == null || (rTCVideoImpl = weakReference2.get()) == null || (externalVideoEncoderEventHandler = rTCVideoImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onActiveVideoLayer(StreamIndex.fromId(i), i2, z);
    }

    @CalledByNative
    public void OnRateUpdate(int i, int i2, int i3, int i4) {
        RTCVideoImpl rTCVideoImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCVideoImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCVideoImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onRateUpdate(StreamIndex.fromId(i), i2, i3, i4);
    }

    @CalledByNative
    public void OnRequestKeyFrame(int i, int i2) {
        RTCVideoImpl rTCVideoImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCVideoImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCVideoImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onRequestKeyFrame(StreamIndex.fromId(i), i2);
    }

    @CalledByNative
    public void OnStart(int i) {
        RTCVideoImpl rTCVideoImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCVideoImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCVideoImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onStart(StreamIndex.fromId(i));
    }

    @CalledByNative
    public void OnStop(int i) {
        RTCVideoImpl rTCVideoImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCVideoImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCVideoImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCVideoImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onStop(StreamIndex.fromId(i));
    }
}
