package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class MapCustomStyleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3640a;
    private String b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f3640a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f3640a = str;
        return this;
    }
}
