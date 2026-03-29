package com.zenmen.palmchat.utils.traceroutePing;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class TracerouteContainer implements Serializable {
    private static final long serialVersionUID = 1034744411998219581L;
    private String hostname;
    private String ip;
    private boolean isSuccessful;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f15772ms;

    public TracerouteContainer(String str, String str2, float f, boolean z) {
        this.hostname = str;
        this.ip = str2;
        this.f15772ms = f;
        this.isSuccessful = z;
    }

    public String getHostname() {
        return this.hostname;
    }

    public String getIp() {
        return this.ip;
    }

    public float getMs() {
        return this.f15772ms;
    }

    public boolean isSuccessful() {
        return this.isSuccessful;
    }

    public void setHostname(String str) {
        this.hostname = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMs(float f) {
        this.f15772ms = f;
    }

    public void setSuccessful(boolean z) {
        this.isSuccessful = z;
    }

    public String toString() {
        return "Traceroute : \nHostname : " + this.hostname + "\nip : " + this.ip + "\nMilliseconds : " + this.f15772ms;
    }
}
