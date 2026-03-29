package com.wifi.ad.core.data;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FilterConfigBean {
    private int enbale;
    private List<ExtDataBean> ext_data;
    private List<String> pkglist;
    private int update_interval;
    private List<String> urls;
    private List<String> words;

    /* JADX INFO: compiled from: SearchBox */
    public static class ExtDataBean {
        private String key;
        private String val;

        public String getKey() {
            return this.key;
        }

        public String getVal() {
            return this.val;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setVal(String str) {
            this.val = str;
        }
    }

    public int getEnbale() {
        return this.enbale;
    }

    public List<ExtDataBean> getExt_data() {
        return this.ext_data;
    }

    public List<String> getPkglist() {
        return this.pkglist;
    }

    public int getUpdate_interval() {
        return this.update_interval;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public List<String> getWords() {
        return this.words;
    }

    public void setEnbale(int i) {
        this.enbale = i;
    }

    public void setExt_data(List<ExtDataBean> list) {
        this.ext_data = list;
    }

    public void setPkglist(List<String> list) {
        this.pkglist = list;
    }

    public void setUpdate_interval(int i) {
        this.update_interval = i;
    }

    public void setUrls(List<String> list) {
        this.urls = list;
    }

    public void setWords(List<String> list) {
        this.words = list;
    }
}
