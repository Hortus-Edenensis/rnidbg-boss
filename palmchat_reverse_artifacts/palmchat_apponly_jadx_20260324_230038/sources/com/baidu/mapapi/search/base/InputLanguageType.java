package com.baidu.mapapi.search.base;

import com.cdo.oaps.ad.OapsKey;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum InputLanguageType {
    AUTO("auto"),
    ENGLISH("en"),
    CANTONESE("yue"),
    CLASSICAL_CHINESE("wyw"),
    JAPANESE("jp"),
    KOREAN("kor"),
    FRENCH("fra"),
    SPANISH("spa"),
    THAI("th"),
    ARABIC("ara"),
    RUSSIAN("ru"),
    PORTUGUESE(OapsKey.KEY_PAGE_TYPE),
    GERMAN("de"),
    ITALIAN(o.f),
    Greek(t.n),
    DUTCH("nl"),
    Polish(bt.ax),
    BULGARIAN("bul"),
    ESTONIAN("est"),
    DANISH("dan"),
    FINNISH("fin"),
    CZECH(OapsKey.KEY_CHECKSUM),
    ROMANIAN("rom"),
    SLOVENIAN("slo"),
    SWEDISH("swe"),
    HUNGARIAN("hu"),
    TRADITIONAL_CHINESE("cht"),
    VIETNAMESE("vie");

    private final String value;

    InputLanguageType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
