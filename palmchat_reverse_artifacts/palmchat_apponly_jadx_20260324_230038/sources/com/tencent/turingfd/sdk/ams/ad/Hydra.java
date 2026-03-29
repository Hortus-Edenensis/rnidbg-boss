package com.tencent.turingfd.sdk.ams.ad;

import android.os.Build;
import defpackage.ck2;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Hydra {
    public static final Hydra b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LeoMinor f10709a;

    public Hydra(LeoMinor leoMinor) {
        this.f10709a = leoMinor;
    }

    public static Hydra a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new Hydra(new Leo(ck2.a(localeArr))) : new Hydra(new Lacerta(localeArr));
    }

    public static Hydra a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split(",", -1);
            int length = strArrSplit.length;
            Locale[] localeArr = new Locale[length];
            for (int i = 0; i < length; i++) {
                localeArr[i] = Locale.forLanguageTag(strArrSplit[i]);
            }
            return a(localeArr);
        }
        return b;
    }
}
