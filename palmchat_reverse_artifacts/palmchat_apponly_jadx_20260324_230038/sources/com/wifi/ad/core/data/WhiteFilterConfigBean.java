package com.wifi.ad.core.data;

import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WhiteFilterConfigBean {
    private int enbale;
    private Set<String> fullList;
    private int more_data;
    private int update_interval;
    private int update_type;
    private String version;

    public int getEnbale() {
        return this.enbale;
    }

    public Set<String> getFullList() {
        return this.fullList;
    }

    public int getMore_data() {
        return this.more_data;
    }

    public int getUpdate_interval() {
        return this.update_interval;
    }

    public int getUpdate_type() {
        return this.update_type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEnbale(int i) {
        this.enbale = i;
    }

    public void setFullList(Set<String> set) {
        this.fullList = set;
    }

    public void setMore_data(int i) {
        this.more_data = i;
    }

    public void setUpdate_interval(int i) {
        this.update_interval = i;
    }

    public void setUpdate_type(int i) {
        this.update_type = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
