package com.volcengine.lxvertc.videocall.call;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum CallEvent {
    ANSWER_CALL("answer_call"),
    REFUSED("refused"),
    TIMEOUT("time_out"),
    RINGING("ringing"),
    CANCELED("canceled"),
    HANGUP("hangup"),
    RTC_ERROR("rtc_error");

    public final String name;

    CallEvent(String str) {
        this.name = str;
    }
}
