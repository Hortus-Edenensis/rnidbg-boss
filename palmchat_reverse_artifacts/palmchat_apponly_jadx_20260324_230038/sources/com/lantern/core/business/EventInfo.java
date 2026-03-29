package com.lantern.core.business;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class EventInfo {
    private long createDateTime;
    private String eventId;
    private String extra;
    private String source;

    public long getCreateDateTime() {
        return this.createDateTime;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getSource() {
        return this.source;
    }

    public void setCreateDateTime(long j) {
        this.createDateTime = j;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setSource(String str) {
        this.source = str;
    }
}
