package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SuggestionSearchOption {
    public boolean mHotWord;
    public String mCity = null;
    public String mKeyword = null;
    public LatLng mLocation = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3823a = true;
    public Boolean mCityLimit = Boolean.FALSE;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public SuggestionSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public SuggestionSearchOption citylimit(Boolean bool) {
        this.mCityLimit = bool;
        return this;
    }

    public SuggestionSearchOption extendAdcode(boolean z) {
        this.f3823a = z;
        return this;
    }

    public SuggestionSearchOption hotWord(boolean z) {
        this.mHotWord = z;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.f3823a;
    }

    public SuggestionSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public SuggestionSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public SuggestionSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }
}
