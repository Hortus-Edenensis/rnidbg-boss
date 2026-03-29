package com.beizi.fusion.model;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class FreqItem {

    @JsonNode(key = "componentType")
    private int componentType;

    @JsonNode(key = "eventCode")
    private String eventCode;

    @JsonNode(key = "interval")
    private long interval = Long.MAX_VALUE;

    @JsonNode(key = "count")
    private int count = Integer.MAX_VALUE;

    public int getComponentType() {
        return this.componentType;
    }

    public int getCount() {
        return this.count;
    }

    public String getEventCode() {
        return this.eventCode;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setComponentType(int i) {
        this.componentType = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setEventCode(String str) {
        this.eventCode = str;
    }

    public void setInterval(long j) {
        this.interval = j;
    }

    @NonNull
    public String toString() {
        return "FreqItem{interval=" + this.interval + ", count=" + this.count + ", eventCode='" + this.eventCode + "', componentType=" + this.componentType + '}';
    }
}
