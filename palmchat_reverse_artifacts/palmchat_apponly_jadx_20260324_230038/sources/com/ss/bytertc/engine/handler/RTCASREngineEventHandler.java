package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCASREngineEventHandler {
    private IRTCASREngineEventHandler asrEventHandler;

    @CalledByNative
    public void onError(int i, String str) {
        IRTCASREngineEventHandler iRTCASREngineEventHandler = this.asrEventHandler;
        if (iRTCASREngineEventHandler != null) {
            iRTCASREngineEventHandler.onError(i, str);
        }
    }

    @CalledByNative
    public void onMessage(String str) {
        IRTCASREngineEventHandler iRTCASREngineEventHandler = this.asrEventHandler;
        if (iRTCASREngineEventHandler != null) {
            iRTCASREngineEventHandler.onMessage(str);
        }
    }

    @CalledByNative
    public void onSuccess() {
        IRTCASREngineEventHandler iRTCASREngineEventHandler = this.asrEventHandler;
        if (iRTCASREngineEventHandler != null) {
            iRTCASREngineEventHandler.onSuccess();
        }
    }

    public void setAsrEventHandler(IRTCASREngineEventHandler iRTCASREngineEventHandler) {
        this.asrEventHandler = iRTCASREngineEventHandler;
    }
}
