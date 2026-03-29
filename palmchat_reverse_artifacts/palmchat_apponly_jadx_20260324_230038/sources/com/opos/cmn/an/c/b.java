package com.opos.cmn.an.c;

import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Locale f7735a;

    public static String a() {
        String language = c().getLanguage();
        return language == null ? "" : language;
    }

    public static String b() {
        String country = c().getCountry();
        return country == null ? "" : country;
    }

    private static Locale c() {
        if (f7735a == null) {
            f7735a = Locale.getDefault();
        }
        return f7735a;
    }
}
