package com.volcengine.lxvertc.videocall.call.state;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum VoipState {
    IDLE("idle", 0),
    CALLING("calling", 1),
    RINGING("ringing", 2),
    ACCEPTED("accepted", 3),
    ONTHECALL("on_the_call", 4),
    TERMINATED("terminated", 101),
    OCCUPIED("occupied", 102),
    REFUSED("refused", 103),
    CANCELLED("cancelled", 104),
    UNAVAILABLE("unavailable", 105),
    RTC_ERROR("rtc_error", 106);

    private String name;
    private int value;

    VoipState(String str, int i) {
        this.name = str;
        this.value = i;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "VoipState{name='" + this.name + "', ordinal=" + this.value + '}';
    }
}
