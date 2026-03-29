package com.wifi.ad.core.compliance;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeComplianceModel {
    private ArrayList<String> versions = null;
    private ArrayList<String> versionNames = null;
    private ArrayList<String> channels = null;
    private ArrayList<String> scenes = null;
    private ArrayList<Integer> downloadType = null;
    private boolean complianceInfo = false;
    private String videoClick = null;
    private int clickArea = 1;

    public ArrayList<String> getChannels() {
        return this.channels;
    }

    public int getClickArea() {
        return this.clickArea;
    }

    public ArrayList<Integer> getDownloadType() {
        return this.downloadType;
    }

    public ArrayList<String> getScenes() {
        return this.scenes;
    }

    public ArrayList<String> getVersionNames() {
        return this.versionNames;
    }

    public ArrayList<String> getVersions() {
        return this.versions;
    }

    public String getVideoClick() {
        return this.videoClick;
    }

    public boolean isComplianceInfo() {
        return this.complianceInfo;
    }

    public void setChannels(ArrayList<String> arrayList) {
        this.channels = arrayList;
    }

    public void setClickArea(int i) {
        this.clickArea = i;
    }

    public void setComplianceInfo(boolean z) {
        this.complianceInfo = z;
    }

    public void setDownloadType(ArrayList<Integer> arrayList) {
        this.downloadType = arrayList;
    }

    public void setScenes(ArrayList<String> arrayList) {
        this.scenes = arrayList;
    }

    public void setVersionNames(ArrayList<String> arrayList) {
        this.versionNames = arrayList;
    }

    public void setVersions(ArrayList<String> arrayList) {
        this.versions = arrayList;
    }

    public void setVideoClick(String str) {
        this.videoClick = str;
    }
}
