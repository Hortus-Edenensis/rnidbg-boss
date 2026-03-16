package com.twl.mms;

public class ConnectionInfo {
    public static final int NETWORK_WIFI = 100;

    public long connectTime;
    public long endTime;
    public boolean isForeground;
    public boolean isMobileNet;
    public boolean isNetStable;
    public boolean isOnline;
    public int mNetType;
    public String mqttUrl;
    public int reconnectCount;
    public long sslTime;
    public long startPreTime;
    public long startTime;
    public long subscribeTime;
    public String throwable;
    public long totalTime;

    public ConnectionInfo() {}

    public ConnectionInfo setEnvInfo(
            boolean foreground, boolean online, boolean mobileNet, boolean netStable) {
        this.isForeground = foreground;
        this.isOnline = online;
        this.isMobileNet = mobileNet;
        this.isNetStable = netStable;
        this.throwable = null;
        return this;
    }

    public void setMqttUrl(String url, long startedAtMs) {
        this.mqttUrl = url;
        this.reconnectCount++;
        this.startPreTime = Math.max(0L, System.currentTimeMillis() - startedAtMs);
    }

    public void setNetType(int netType) {
        this.mNetType = netType;
    }

    public ConnectionInfo setOnline(boolean online) {
        this.isOnline = online;
        return this;
    }

    public void setThrowable(Throwable error) {
        this.throwable = error == null ? null : error.toString();
    }

    public void updateConnect(long startedAtMs) {
        this.connectTime = Math.max(0L, System.currentTimeMillis() - startedAtMs);
        this.startTime = startedAtMs;
    }

    public void updateSubscribe(long startedAtMs) {
        this.subscribeTime = Math.max(0L, System.currentTimeMillis() - startedAtMs);
        this.endTime = System.currentTimeMillis();
        this.totalTime = Math.max(0L, this.endTime - this.startTime);
        this.throwable = null;
        this.reconnectCount = 0;
    }

    @Override
    public String toString() {
        return "ConnectionInfo{"
                + "mqttUrl='"
                + mqttUrl
                + '\''
                + ", reconnectCount="
                + reconnectCount
                + ", sslTime="
                + sslTime
                + ", throwable='"
                + throwable
                + '\''
                + "}";
    }
}
