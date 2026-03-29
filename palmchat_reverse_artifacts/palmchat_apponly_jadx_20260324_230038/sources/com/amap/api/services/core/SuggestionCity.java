package com.amap.api.services.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SuggestionCity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3144a;
    private String b;
    private String c;
    private int d;

    public SuggestionCity() {
    }

    public String getAdCode() {
        return this.c;
    }

    public String getCityCode() {
        return this.b;
    }

    public String getCityName() {
        return this.f3144a;
    }

    public int getSuggestionNum() {
        return this.d;
    }

    public void setAdCode(String str) {
        this.c = str;
    }

    public void setCityCode(String str) {
        this.b = str;
    }

    public void setCityName(String str) {
        this.f3144a = str;
    }

    public void setSuggestionNum(int i) {
        this.d = i;
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f3144a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }
}
