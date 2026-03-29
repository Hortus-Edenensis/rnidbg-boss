package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.base.LanguageType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiDetailSearchOption {
    private boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3779a = "";
    private boolean b = true;
    private String c = "";
    private boolean d = false;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public PoiDetailSearchOption extendAdcode(boolean z) {
        this.b = z;
        return this;
    }

    public String getUid() {
        return this.f3779a;
    }

    public String getUids() {
        return this.c;
    }

    public boolean isExtendAdcode() {
        return this.b;
    }

    public boolean isSearchByUids() {
        return this.d;
    }

    public boolean isShowPhoto() {
        return this.e;
    }

    public PoiDetailSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.d = false;
        this.f3779a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.d = true;
        this.c = str;
        return this;
    }

    public PoiDetailSearchOption setShowPhoto(boolean z) {
        this.e = z;
        return this;
    }
}
