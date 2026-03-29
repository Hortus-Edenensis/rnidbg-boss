package com.opos.exoplayer.core;

import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f8251a = new HashSet<>();
    private static String b = "goog.exo.core";

    public static synchronized String a() {
        return b;
    }

    public static synchronized void a(String str) {
        if (f8251a.add(str)) {
            b += ", " + str;
        }
    }
}
