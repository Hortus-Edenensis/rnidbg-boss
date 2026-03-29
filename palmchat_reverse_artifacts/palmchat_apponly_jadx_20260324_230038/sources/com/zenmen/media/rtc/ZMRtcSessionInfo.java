package com.zenmen.media.rtc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ZMRtcSessionInfo {
    public static int SignallingTypeOnAcceptResponse = 2;
    public static int SignallingTypeOnCall = 0;
    public static int SignallingTypeOnCallNotify = 8;
    public static int SignallingTypeOnCalleeAccept = 3;
    public static int SignallingTypeOnDeviceInfo = 7;
    public static int SignallingTypeOnHangup = 4;
    public static int SignallingTypeOnReceive = 1;
    public static int SignallingTypeOnRoomDestroy = 5;
    public static int SignallingTypeOnStatusUpdate = 6;
    public static int SignallingTypeOthers = 100;
    public long callingUserId = 0;
    public long calledUserId = 0;
    public long roomId = -1;
    public long byUserId = 0;
    public int signalType = SignallingTypeOthers;
    public int sessionType = 0;
    public int statusCode = 0;
    public int callNotifyInterval = 0;
    public int reserved = 0;

    public String toString() {
        return String.format("roomId=%d, signalType=%d, sessionType=%d, statusCode=%d, reserved=%d", Long.valueOf(this.roomId), Integer.valueOf(this.signalType), Integer.valueOf(this.sessionType), Integer.valueOf(this.statusCode), Integer.valueOf(this.reserved));
    }
}
