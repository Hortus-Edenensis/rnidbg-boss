package com.huawei.hms.ads.uiengineloader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6627a = "StringUtils";

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            af.c(f6627a, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return 0;
        }
    }

    private static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }
}
