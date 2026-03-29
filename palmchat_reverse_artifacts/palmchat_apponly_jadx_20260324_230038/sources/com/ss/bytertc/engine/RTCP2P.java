package com.ss.bytertc.engine;

import com.ss.bytertc.engine.engineimpl.RTCVideoImpl;
import com.ss.bytertc.engine.handler.IRTCEngineInternalP2PEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCP2P {
    private static final String TAG = "RTCP2P";

    public static int enableP2P(RTCVideo rTCVideo, String str, boolean z) {
        try {
            int i = RTCVideoImpl.f10640a;
            return ((Integer) RTCVideoImpl.class.getMethod("enableP2PAbility", String.class, Boolean.TYPE).invoke(rTCVideo, str, Boolean.valueOf(z))).intValue();
        } catch (Exception unused) {
            LogUtil.e(TAG, "fail to find method enableP2PAbility");
            return -1;
        }
    }

    public static void setP2PEventHandler(RTCVideo rTCVideo, IRTCEngineInternalP2PEventHandler iRTCEngineInternalP2PEventHandler) {
        try {
            int i = RTCVideoImpl.f10640a;
            RTCVideoImpl.class.getMethod("setInternalP2PEventHandler", IRTCEngineInternalP2PEventHandler.class).invoke(rTCVideo, iRTCEngineInternalP2PEventHandler);
        } catch (Exception unused) {
            LogUtil.e(TAG, "fail to find method setInternalP2PEventHandler");
        }
    }
}
