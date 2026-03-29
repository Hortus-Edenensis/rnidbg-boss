package com.tide.protocol.host.model;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PluginInfo {
    private int frameVCode;
    private int hostVCode;
    private long loadTime;
    private String md5;
    private String packageName;
    private String pluginFrom;
    private String pluginName;
    private String pluginPath;
    private int pluginVCode;
    private String pluginVName;

    public int getFrameVCode() {
        return this.frameVCode;
    }

    public int getHostVCode() {
        return this.hostVCode;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPluginFrom() {
        return this.pluginFrom;
    }

    public String getPluginName() {
        return this.pluginName;
    }

    public String getPluginPath() {
        return this.pluginPath;
    }

    public int getPluginVCode() {
        return this.pluginVCode;
    }

    public String getPluginVName() {
        return this.pluginVName;
    }

    public void setFrameVCode(int i) {
        this.frameVCode = i;
    }

    public void setHostVCode(int i) {
        this.hostVCode = i;
    }

    public void setLoadTime(long j) {
        this.loadTime = j;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPluginFrom(String str) {
        this.pluginFrom = str;
    }

    public void setPluginName(String str) {
        this.pluginName = str;
    }

    public void setPluginPath(String str) {
        this.pluginPath = str;
    }

    public void setPluginVCode(int i) {
        this.pluginVCode = i;
    }

    public void setPluginVName(String str) {
        this.pluginVName = str;
    }

    public String toString() {
        return "pluginName" + this.pluginName + "packageName" + this.packageName + "pluginPath" + this.pluginPath + "hostVCode" + this.hostVCode + "frameVCode" + this.frameVCode + "loadTime" + this.loadTime + "pluginFrom" + this.pluginFrom + "md5" + this.md5;
    }
}
