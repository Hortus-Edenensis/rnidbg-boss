package com.tencent.turingfd.sdk.ams.ad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Lacerta implements LeoMinor {
    public static final Locale[] b = new Locale[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale[] f10711a;

    public Lacerta(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f10711a = b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException("list[" + i + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                a(sb, locale2);
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f10711a = (Locale[]) arrayList.toArray(new Locale[0]);
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.LeoMinor
    public Locale a(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f10711a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @Override // com.tencent.turingfd.sdk.ams.ad.LeoMinor
    public int a() {
        return this.f10711a.length;
    }

    public static void a(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }
}
